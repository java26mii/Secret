/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tools.HibernateUtil;

/**
 *
 * @author Dek Sekar
 */
public class Laporan {

    private static Map getParameters(Session session) {
        Map parameters = new HashMap();
        parameters.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, session);
        parameters.put("Report", "Job");
        return parameters;
    }

    public static void fill(String file) {
        Session session = createSession();
        Transaction transaction = session.beginTransaction();

        Map params = getParameters(session);
        try {
            File[] files
                    = new File[]{
                        new File("src/reports/" + file + ".jasper")
                    };
            for (int i = 0; i < files.length; i++) {
                File reportFile = files[i];
                long start = System.currentTimeMillis();
                JasperFillManager.fillReportToFile(reportFile.getAbsolutePath(), params);
                System.err.println(
                        "Report : " + reportFile + ". Filling time : " + (System.currentTimeMillis() - start)
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        transaction.rollback();
        session.close();
    }

    private static Session createSession() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        fill("report");
    }
}
