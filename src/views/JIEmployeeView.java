/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.DepartmentController;
import controllers.EmployeeController;
import controllers.JobController;
import daos.GeneralDAO;
import icontrollers.IDepartmentController;
import icontrollers.IEmployeeController;
import icontrollers.IJobController;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Department;
import models.Employee;
import models.Job;
import models.Region;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author WINDOWS 10
 */
public class JIEmployeeView extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();
    SessionFactory factory = HibernateUtil.getSessionFactory();

    GeneralDAO<Employee> edao = new GeneralDAO<>(factory, Employee.class);
    GeneralDAO<Department> ddao = new GeneralDAO<>(factory, Department.class);
    GeneralDAO<Job> jdao = new GeneralDAO<>(factory, Job.class);
    IEmployeeController eco = new EmployeeController(factory);
    IJobController jco = new JobController(factory);
    IDepartmentController dco = new DepartmentController(factory);
    Date date = new Date(); // this object contains the current date value 
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public JIEmployeeView() {
        initComponents();
        tblEmployee.setModel(model);
        model.addColumn("No");
        model.addColumn("Employee ID");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Email");
        model.addColumn("Phone Number");
        model.addColumn("Hire Date");
        model.addColumn("Job");
        model.addColumn("Salary");
        model.addColumn("Commission PCT");
        model.addColumn("Manager");
        model.addColumn("Department");

        showTable("");
        getDepartment();
        getJob();
        getManager();
//        nourut();

    }

//    public Object nourut() {
//
//        Object[] no = new Object[1];
//        int baris = model.getRowCount();
//        for (int i = 0; i < baris; i++) {
//            String No = String.valueOf(i + 1);
//            model.setValueAt(No + ".", i, 0);
//        }
//        return no;
//    }
    public void showTable(String key) {
        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
        model.setRowCount(0);
        Object[] row = new Object[12];
        List<Employee> emp = new ArrayList<>();
        if (key == "") {
            emp = eco.getAll();
        }
        emp = eco.search(key);
//        emp = eco.search(key);

        for (int i = 0; i < emp.size(); i++) {
            row[0] = i + 1;
            row[1] = emp.get(i).getId();
            row[2] = emp.get(i).getFirstName();
            row[3] = emp.get(i).getLastName();
            row[4] = emp.get(i).getEmail();
            row[5] = emp.get(i).getPhoneNumber();
            row[6] = emp.get(i).getHireDate();
            row[7] = emp.get(i).getJob().getTitle();
            row[8] = emp.get(i).getSalary();
            row[9] = emp.get(i).getCommissionPct();
//            row[11] = emp.get(i).getDepartmentId().getDepartmentName();

            if (emp.get(i).getManager() == null) {
                row[10] = "";
            } else {
                row[10] = emp.get(i).getManager().getLastName();
            }
//
            if (emp.get(i).getDepartment() == null) {
                row[11] = "";
            } else {
                row[11] = emp.get(i).getDepartment().getName();
            }
            model.addRow(row);
        }
    }

    private void getJob() {
        for (Job job : new JobController(factory).getAll()) {
            jJob.addItem(job.getId() + "-" + job.getTitle());
//                for (Job job : jdao.getData(key)) {
//            jJob.addItem(job.getJobId()+ "-" + job.getJobTitle());
//            if (job.getId()== null) {
//            jJob.addItem("");
//            } else {
//            jJob.addItem(job.getId()+ "-" + job.getTitle());
//            }
        }
    }

    private void getDepartment() {
        for (Department depa : new DepartmentController(factory).getAll()) {
            jDepartment.addItem(depa.getId() + "-" + depa.getName());
//            if (depa.getId()== null) {
//            jDepartment.addItem("");
//            } else {
//            jDepartment.addItem(depa.getId()+ "-" + depa.getName());
//            }
        }
    }

    private void getManager() {
        for (Employee emp : new EmployeeController(factory).getAll()) {
//            jManager.addItem(emp.getManagerId().getManagerId()+ "-" + emp.getManagerId().getLastName());
//                for (Employee emp : edao.getData(key)) {
//            jManager.addItem(emp.getManagerId().getLastName());
//            if (emp.getManager() == null) {
//            jManager.addItem("");
//            } else {
            jManager.addItem(emp.getId() + "-" + emp.getFirstName());
//            }
        }
    }

//    public void showTable() {
//        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
//        Object[] row = new Object[12];
//        List<Employee> emp = new ArrayList<>();
//        emp = eco.getAll();
//
//        for (int i = 0; i < emp.size(); i++) {
//            row[0] = nourut();
//            row[1] = emp.get(i).getId();
//            row[2] = emp.get(i).getFirstName();
//            row[3] = emp.get(i).getLastName();
//            row[4] = emp.get(i).getEmail();
//            row[5] = emp.get(i).getPhoneNumber();
//            row[6] = emp.get(i).getHireDate();
//            row[7] = emp.get(i).getJob().getTitle();
//            row[8] = emp.get(i).getSalary();
//            row[9] = emp.get(i).getCommissionPct();
//            row[11] = emp.get(i).getDepartmentId().getDepartmentName();
//            if (emp.get(i).getManager() == null) {
//                row[10] = "";
//            } else {
//                row[10] = emp.get(i).getManager().getLastName();
//            }
////
//            if (emp.get(i).getDepartment() == null) {
//                row[11] = "";
//            } else {
//                row[11] = emp.get(i).getDepartment().getName();
//            }
//            model.addRow(row);
//        }
//    }
//    public void insert() {
//        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
//        model.setRowCount(0);
//        showTable("");
//    }
//
//    public void insert(String key) {
//        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
//        model.setRowCount(0);
////        if (key == "") {
////            showTable("");
////        }
//        showTable(key);
//    }
//        public void updateTableEmployee(String key) {
//        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
//        model.setRowCount(0);
//        if (key == "") {
//            showTable("");
//        }
//        showTable(key);
//    }
    public void resetText() {
        jID.setText("");
        jFirst.setText("");
        jLast.setText("");
        jEmail.setText("");
        jPhone.setText("");
        jSalary.setText("");
        jCommission.setText("");
        jJob.setSelectedIndex(0);
        jManager.setSelectedIndex(0);
        jDepartment.setSelectedIndex(0);
        btnInsert.setEnabled(true);
        jDate.setDate(null);

//        btnUpdate.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFirst = new javax.swing.JTextField();
        jID = new javax.swing.JTextField();
        jLast = new javax.swing.JTextField();
        jPhone = new javax.swing.JTextField();
        jEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCommission = new javax.swing.JTextField();
        jSalary = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jManager = new javax.swing.JComboBox<>();
        jDepartment = new javax.swing.JComboBox<>();
        jJob = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jSearch = new javax.swing.JTextField();
        jDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Employee ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("First Name");

        jFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFirstActionPerformed(evt);
            }
        });

        jID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIDActionPerformed(evt);
            }
        });

        jLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLastActionPerformed(evt);
            }
        });

        jPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPhoneActionPerformed(evt);
            }
        });

        jEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmailActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Phone Number");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Hire Date");

        jCommission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCommissionActionPerformed(evt);
            }
        });

        jSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalaryActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Commission PCT");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Salary");

        jManager.setMaximumRowCount(100);
        jManager.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));
        jManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jManagerActionPerformed(evt);
            }
        });

        jDepartment.setMaximumRowCount(100);
        jDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));

        jJob.setMaximumRowCount(100);
        jJob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Manager");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Department");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Job");

        btnInsert.setText("Save");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnInsert)
                .addGap(37, 37, 37)
                .addComponent(btnDelete)
                .addGap(27, 27, 27)
                .addComponent(btnReset)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnDelete)
                    .addComponent(btnReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Email", "Phone Number", "Hire Date", "Salary", "Commission PCT", "Manager", "Department", "Job"
            }
        ));
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Search");

        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });
        jSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSearchKeyTyped(evt);
            }
        });

        jDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDatePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel13)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 61, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(jLast, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(jID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(jFirst, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSalary)
                                    .addComponent(jCommission)
                                    .addComponent(jManager, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jJob, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCommission, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLast, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jManager, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jJob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel1.setText("EMPLOYEE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFirstActionPerformed

    private void jIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDActionPerformed

    private void jLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLastActionPerformed

    private void jPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPhoneActionPerformed

    private void jEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailActionPerformed

    private void jCommissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCommissionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCommissionActionPerformed

    private void jSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSalaryActionPerformed

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSearchActionPerformed

    private void jDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDatePropertyChange
        // TODO add your handling code here:
//                java.util.Date skrg= new java.util.Date();
//        SimpleDateFormat format= new SimpleDateFormat("MM/dd/yyyy");
        jDate.setDateFormatString("MM/dd/yyyy");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//String startDateString = dateFormat.format(jDate.getDate()); 


    }//GEN-LAST:event_jDatePropertyChange

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
//        Employee emp = new Employee();

//        emp.setEmployeeId(new Integer(jID.getText()));
//        emp.setFirstName(jFirst.getText());
//        emp.setLastName(jLast.getText());
//        emp.setEmail(jEmail.getText());
//        emp.setPhoneNumber(jPhone.getText());
//        emp.setHireDate(jDate.getDate());
//        emp.setSalary(new BigDecimal(jSalary.getText()));
//        emp.setCommissionPct(new BigDecimal(jCommission.getText()));
//        emp.setDepartmentId(new Department(new Short(dprtmnid)));
//        emp.setManagerId(new Employee((new Integer(mngrid))));
//        emp.setJobId(new Job(((jbid))));
        if (jID.getText().equals("") || jFirst.getText().equals("") || jLast.getText().equals("")
                || jEmail.getText().equals("") || jPhone.getText().equals("") || jDate.getDate() == null
                || jSalary.getText().equals("") || jCommission.getText().equals("")
                || jDepartment.getSelectedItem() == ("Choose") || jManager.getSelectedItem() == ("Choose")
                || jJob.getSelectedItem() == ("Choose")) {
            JOptionPane.showMessageDialog(null, "Isi semua kolom");
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Kamu yakin mau menambah data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                String dprtmnid = jDepartment.getSelectedItem().toString();
                dprtmnid = dprtmnid.substring(0, dprtmnid.indexOf("-"));
                String jbid = jJob.getSelectedItem().toString();
                String mngrid = jManager.getSelectedItem().toString();
                jbid = jbid.substring(0, jbid.indexOf("-"));
                mngrid = mngrid.substring(0, mngrid.indexOf("-"));
                date = jDate.getDate();
                String hiredate = formatter.format(date);
                JOptionPane.showMessageDialog(null, eco.save(jID.getText(), jFirst.getText(),
                        jLast.getText(), jEmail.getText(), jPhone.getText(), hiredate,
                        jSalary.getText(), jCommission.getText(), dprtmnid, mngrid, jbid));
//               if (confirm == JOptionPane.YES_OPTION) {
//            JOptionPane.showMessageDialog(null, edao.saveOrDelete(emp, false));
////            insert();
//        }
                resetText();
            }
        }
        showTable("");
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetText();
    }//GEN-LAST:event_btnResetActionPerformed

    private void jSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchKeyTyped
//        updateTableEmployee(jSearch.getText());
        showTable(jSearch.getText());

    }//GEN-LAST:event_jSearchKeyTyped

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
        int SelectRowIndex = tblEmployee.getSelectedRow();
//        String hire = new Object(model.getValueAt(SelectRowIndex, 7));
        jID.setText(model.getValueAt(SelectRowIndex, 1).toString());
        jFirst.setText(model.getValueAt(SelectRowIndex, 2).toString());
        jLast.setText(model.getValueAt(SelectRowIndex, 3).toString());
        jEmail.setText(model.getValueAt(SelectRowIndex, 4).toString());
        jPhone.setText(model.getValueAt(SelectRowIndex, 5).toString());
        jJob.setSelectedItem(model.getValueAt(SelectRowIndex, 6));
//        jDate.setDate(new Object(model.getValueAt(SelectRowIndex, 7)));
        jSalary.setText(model.getValueAt(SelectRowIndex, 8).toString());
        jCommission.setText(model.getValueAt(SelectRowIndex, 9).toString());
        jManager.setSelectedItem(model.getValueAt(SelectRowIndex, 10));
//        jDepartment.setSelectedIndex(model.getValueAt(SelectRowIndex, 11));
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Kamu yakin mau menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, eco.delete(jID.getText()));
//               if (confirm == JOptionPane.YES_OPTION) {
//            JOptionPane.showMessageDialog(null, edao.saveOrDelete(emp, false));
////            insert();
//        }
            resetText();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jManagerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jManagerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JTextField jCommission;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JComboBox<String> jDepartment;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jFirst;
    private javax.swing.JTextField jID;
    private javax.swing.JComboBox<String> jJob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLast;
    private javax.swing.JComboBox<String> jManager;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPhone;
    private javax.swing.JTextField jSalary;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSearch;
    private javax.swing.JTable tblEmployee;
    // End of variables declaration//GEN-END:variables
}
