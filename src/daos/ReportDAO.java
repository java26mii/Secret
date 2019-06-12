/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author WINDOWS 10
 */
public class ReportDAO {

    static SessionFactory session = HibernateUtil.getSessionFactory();
    private Map<String, Object> param = new HashMap<>();
//        Session session = createSession();
//        Transaction transaction = session.beginTransaction();
//        transaction = session.beginTransaction();
//        System.out.println(factory);
//        JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(file);
//            Session fact = session.openSession();

    public Session openSession() {
        return session.openSession();
    }

    public void report(String file) {
                Session sesi = this.openSession();
            param.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, sesi);
            String namafile = "src/report/" + file + ".jasper";
            File report = new File(namafile);
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(report);
//            HashMap parameter = new HashMap();
//            Map params = getParameters(session);
//            parameter.put("employee_id", employee_id);
//            JasperPrint jp = JasperFillManager.fillReport(jr, null, session);
            JasperPrint jp = JasperFillManager.fillReport(jr, param);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Gagal");
            e.printStackTrace();

        }
    }

}
