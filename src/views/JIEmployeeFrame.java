/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmployeeController;
import daos.GeneralDAO;
import icontrollers.IEmployeeController;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Employee;
import models.Job;
import models.Region;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author ASUS
 */
public class JIEmployeeFrame extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();
    SessionFactory factory = HibernateUtil.getSessionFactory();

    GeneralDAO<Employee> edao = new GeneralDAO<>(factory, Employee.class);
    IEmployeeController eco = new EmployeeController(factory);

    public JIEmployeeFrame() {
        initComponents();
        tblEmployee.setModel(model);
        model.addColumn("No");
        model.addColumn("Employee ID");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Email");
        model.addColumn("Phone Number");
        model.addColumn("Hire Date");
        model.addColumn("Job ID");
        model.addColumn("Salary");
        model.addColumn("Commission PCT");
        model.addColumn("Manager ID");
        model.addColumn("Department ID");

        showTable();
        nourut();

    }

    public Object nourut() {

        Object[] no = new Object[1];
        int baris = model.getRowCount();
        for (int i = 0; i < baris; i++) {
            String No = String.valueOf(i + 1);
            model.setValueAt(No + ".", i, 0);
        }
        return no;
    }

    public void showTable() {
        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
        Object[] row = new Object[15];
        List<Employee> emp = new ArrayList<>();
        emp = edao.getData("");
//        if (key.isEmpty()) {
//            emp = edao.getData("");
//        }
        for (int i = 0; i < emp.size(); i++) {
            row[0] = i + 1;
            row[1] = emp.get(i).getId();
            row[2] = emp.get(i).getFirstName();
            row[3] = emp.get(i).getLastName();
            row[4] = emp.get(i).getEmail();
            row[5] = emp.get(i).getPhoneNumber();
            row[6] = emp.get(i).getHireDate();

            if (emp.get(i).getJob() == null) {
                row[7] = "";
            } else {
                row[7] = emp.get(i).getJob().getId()
                        + " - " + emp.get(i).getJob().getTitle();
            }

            row[8] = emp.get(i).getSalary();

            if (emp.get(i).getCommissionPct() == null) {
                row[9] = "";
            } else {
                row[9] = emp.get(i).getCommissionPct();
            }

            if (emp.get(i).getManager() == null) {
                row[10] = "";
            } else {
                row[10] = emp.get(i).getManager().getId()
                        + " - " + emp.get(i).getManager().getLastName();
            }

            if (emp.get(i).getDepartment() == null) {
                row[11] = "";
            } else {
                row[11] = emp.get(i).getDepartment().getId()
                        + " - " + emp.get(i).getDepartment().getName();
            }

            model.addRow(row);
        }
    }

    public void showTable(String key) {
        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
        Object[] row = new Object[15];
        List<Employee> emp = new ArrayList<>();
        emp = edao.getData("");
        for (int i = 0; i < emp.size(); i++) {
            row[0] = nourut();
            row[1] = emp.get(i).getId();
            row[2] = emp.get(i).getFirstName();
            row[3] = emp.get(i).getLastName();
            row[4] = emp.get(i).getEmail();
            row[5] = emp.get(i).getPhoneNumber();
            row[6] = emp.get(i).getHireDate();
            row[7] = emp.get(i).getJob().getTitle();
            row[8] = emp.get(i).getSalary();
            row[9] = emp.get(i).getCommissionPct();
            row[10] = emp.get(i).getManager();
            row[11] = emp.get(i).getDepartment();
            row[12] = emp.get(i).getFirstName();
            model.addRow(row);
        }
        
    }

    public void insert() {
        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
        model.setRowCount(0);
        showTable();
    }

    public void insert(String key) {
        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
        model.setRowCount(0);
        if (key == "") {
            showTable();
        }
        showTable(key);
    }

    public void resetText() {
        jID.setText("");
        jFirst.setText("");
        jLast.setText("");
        jEmail.setText("");
        jPhone.setText("");
        jSalary.setText("");
        jCommission.setText("");
        //        txtCountry_Id.setEditable(true);
//        btnInsertCountry.setEnabled(true);
    }
    
    public void updateTableEmployee(String s) {
        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
        model.setRowCount(0);
        if (s == "") {
            showTable();
        }
        showTable(s);
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
        jUpdate = new javax.swing.JButton();
        jInsert = new javax.swing.JButton();
        jDelete = new javax.swing.JButton();
        jReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jSearch = new javax.swing.JTextField();
        jDate = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();

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

        jManager.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager ID", "100", "102", "103" }));

        jDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Department ID", "60", "90", "100", " " }));

        jJob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Job ID", "AD_PRES", "IT_PROG", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Manager ID");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Department ID");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Job ID");

        jUpdate.setText("Update");

        jInsert.setText("Insert");
        jInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInsertActionPerformed(evt);
            }
        });

        jDelete.setText("Delete");
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });

        jReset.setText("Reset");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInsert)
                .addGap(18, 18, 18)
                .addComponent(jUpdate)
                .addGap(18, 18, 18)
                .addComponent(jDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUpdate)
                    .addComponent(jInsert)
                    .addComponent(jDelete)
                    .addComponent(jReset))
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
                "Employee ID", "First Name", "Last Name", "Email", "Phone Number", "Hire Date", "Salary", "Commission PCT", "Manager ID", "Department ID", "Job ID"
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSearchKeyReleased(evt);
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSalary)
                                    .addComponent(jCommission)
                                    .addComponent(jManager, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jJob, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 61, Short.MAX_VALUE)))))
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
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
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
//        jDate.setDateFormatString("dd/mm/yyyy");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//String startDateString = dateFormat.format(jDate.getDate()); 


    }//GEN-LAST:event_jDatePropertyChange

    private void jInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInsertActionPerformed
//        Employee emp = new Employee();
//        
//        Job job = new Job();
//        emp.setId(new Integer(jID.getText()));
//        emp.setFirstName(jFirst.getText());
//        emp.setLastName(jLast.getText());
//        emp.setEmail(jEmail.getText());
//        emp.setPhoneNumber(jPhone.getText());
//        emp.setHireDate(jDate.getDateFormatString());
//        emp.setSalary(new BigDecimal(jFirst.getText()));
//        emp.setCommissionPct(new BigDecimal(jCommission.getText()));
//        emp.getDepartmentId(jDepartment.getSelectedItem(Department));
//        emp.getManagerId(jManager.getSelectedItem(Manager));
//        emp.getJobId(jJob.getSelectedItem());
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin untuk melakukan insert?", "Confirm Insert", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, eco.save("0", jFirst.getText(), jLast.getText(), jEmail.getText(), jPhone.getText(), jDate.getText(), jSalary.getText(), jCommission.getText(), jDepartment.getName(), jManager.getName(), jJob.getName()));
//            JOptionPane.showMessageDialog(null, eco.save("0", jFirst.getText(), jLast.getText(), jEmail.getText(), jPhone.getText(), "", "", "", "", ""));
            updateTableEmployee("");
            resetText();
        }

//                JobHistoryView jobHistoryView = new JobHistoryView();
//        int employee_id = Integer.parseInt(jEmployee.getText());
//        String Start_date = jStart.getDateFormatString();
//        String End_date = jEnd.getDateFormatString();
//        String Job_id = jJob.getText();
//        int department_id = Integer.parseInt(jDepartment.getText());
//
//        jobHistory.setEmployee_id(employee_id);
//        jobHistory.setStart_date(Start_date);
//        jobHistory.setEnd_date(End_date);
//        jobHistory.setJob_id(Job_id);
//        jobHistory.setDepartment_id(department_id);

    }//GEN-LAST:event_jInsertActionPerformed

    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin untuk melakukan delete?", "Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, eco.delete(jID.getText()));
            updateTableEmployee("");
            resetText();
        }
    }//GEN-LAST:event_jDeleteActionPerformed

    private void jSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchKeyReleased
        updateTableEmployee(jSearch.getText());
    }//GEN-LAST:event_jSearchKeyReleased

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
            int SelectedRowIndex = tblEmployee.getSelectedRow();

            jID.setEditable(false);
            jInsert.setEnabled(false);

            jID.setText(model.getValueAt(SelectedRowIndex, 1).toString());
            jFirst.setText(model.getValueAt(SelectedRowIndex, 2).toString());
            jLast.setText(model.getValueAt(SelectedRowIndex, 3).toString());
            jEmail.setText(model.getValueAt(SelectedRowIndex, 4).toString());
            jPhone.setText(model.getValueAt(SelectedRowIndex, 5).toString());
    }//GEN-LAST:event_tblEmployeeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jCommission;
    private datechooser.beans.DateChooserCombo jDate;
    private javax.swing.JButton jDelete;
    private javax.swing.JComboBox<String> jDepartment;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jFirst;
    private javax.swing.JTextField jID;
    private javax.swing.JButton jInsert;
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
    private javax.swing.JButton jReset;
    private javax.swing.JTextField jSalary;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSearch;
    private javax.swing.JButton jUpdate;
    private javax.swing.JTable tblEmployee;
    // End of variables declaration//GEN-END:variables
}
