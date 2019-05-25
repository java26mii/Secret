/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.DepartmentController;
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
 * @Arif Fridasari
 */
public class OHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        System.out.println(factory);

        GeneralDAO<Region> gdao = new GeneralDAO(factory, Region.class);
        GeneralDAO<Location> ldao = new GeneralDAO(factory, Location.class);

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
        /* Location */
        //System.out.println(ldao.getById(new Short("1000")).getCountry());

//        for (Location location : ldao.getData("")) {
//            System.out.println(location.getId() + " - " + location.getPostalCode());
//        }
 /**
         * GET ALL
         */
        GeneralDAO<Department> dDao = new GeneralDAO<>(factory, Department.class);
        DepartmentController dc = new DepartmentController(factory);

//        for (Department department : dDao.getData("")) {
//            System.out.println(department.getName());
//            System.out.println(department.getId());
//            System.out.println(department.getManager().getId());
//            System.out.println(department.getLocation().getId());
//
//        }

       

        /**
         * INSERT
         */
//        Department department = new Department(new Short("270"), "Bawen");
//        System.out.println(dDao.saveOrDelete(department, false));

//        System.out.println(dc.save("270", "Bawen","",""));
        /**
         * UPDATE
         */
//        Department department = new Department(new Short("270"), "Bawen Sayang");
//        System.out.println(dDao.saveOrDelete(department, false));
        /**
         * DELETE
         */
//        Department department = new Department(new Short("270"));
//        System.out.println(dDao.saveOrDelete(department, true));
//        Department department = new Department(new Short("270"));
//        System.out.println(dDao.saveOrDelete(department, true));

    }
}
