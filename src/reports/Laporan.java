/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.io.File;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Sekar Ayu Safitri
 */
public class Laporan {

    static void laporan(String file, int employee_id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        
        try {
            String namafile = "src/report/" + file + ".jasper";
            File report = new File(namafile);
            JasperReport jr = (JasperReport) JRLoader.loadObject(report);
            HashMap param = new HashMap();
            param.put("employee_id", employee_id);
            JasperPrint jp = JasperFillManager.fillReport(jr, param);
            JasperViewer.viewReport(jp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
    }

    public static void main(String[] args) {
        laporan("reportEmployee", 100);
    }
}
