/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.GeneralDAO;
import java.math.BigDecimal;
import models.Country;
import models.Department;
import models.Employee;
import models.Location;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author Sindi Yulia Wibowo
 */
public class OHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        System.out.println(factory);

        GeneralDAO<Region> gdao = new GeneralDAO(factory, Region.class);

        /* insert */
//        System.out.println(gdao.saveOrDelete(new Region(new BigDecimal(40), "Antartica"), false));

        /* update */
//        System.out.println(gdao.saveOrDelete(new Region(new BigDecimal(40), "Antartica Region"), false));

//        /* delete */
//        System.out.println(gdao.saveOrDelete(new Region(new BigDecimal(40)), true));
//
//        /* getById */
        System.out.println(gdao.getById(new BigDecimal("1")).getName());

        for (Region region : gdao.getData("")) {
            System.out.println(region.getId() + " - " + region.getName());
        }

    }
}
