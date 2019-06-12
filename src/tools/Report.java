/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.EmployeeController;
import controllers.EmployeesController;
import daos.ReportDAO;
import groovy.util.Factory;
import icontrollers.IEmployeeController;
import icontrollers.IEmployeesController;
import idaos.IReportDAO;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.SessionFactory;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author WINDOWS 10
 */
public class Report {
//        private Session session;
//    private Transaction transaction;
//        private SessionFactory factory;

    private static Session createSession() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        return sessionFactory.openSession();
    }
//    private Session openSession() {
//        return session.openSession();
//    }
    
    public static void print(String file) {
//        SessionFactory session = HibernateUtil.getSessionFactory();
        Session session = createSession();
//        Transaction transaction = session.beginTransaction();

//                session = this.factory.openSession();
//        transaction = session.beginTransaction();
//        System.out.println(factory);
//        JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(file);
//            Session fact = session.openSession();
        try {
            String namafile = "src/report/" + file + ".jasper";
            File report = new File(namafile);
            JasperReport jr = (JasperReport) JRLoader.loadObject(report);
            HashMap parameter = new HashMap();
//            Map params = getParameters(session);
            parameter.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, session);
//            parameter.put("employee_id", employee_id);
//            JasperPrint jp = JasperFillManager.fillReport(jr, null, session);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Gagal");
            e.printStackTrace();

        }
//        transaction.rollback();
//        session.close();

    }

    public static void main(String[] args) {
        print("employeenew");
//SessionFactory session = HibernateUtil.getSessionFactory();
//        IEmployeesController eco = new EmployeesController(session);
//        System.out.println(eco.Report("employees"));
//        IReportDAO redao = new ReportDAO(session);

//        System.out.println(session);
    }



}
