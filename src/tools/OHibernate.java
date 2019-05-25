/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.DepartmentController;
import daos.CountryDAO;
import daos.GeneralDAO;
import java.math.BigDecimal;
import models.Country;
import models.Department;
import models.Employee;
import models.Job;
import models.Location;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
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
         GeneralDAO<Job> jdao = new GeneralDAO<>(factory, Job.class);

        /* insert */
//        System.out.println(gdao.saveOrDelete(new Region(new BigDecimal(40), "Antartica"), false));

        /* update */
//        System.out.println(gdao.saveOrDelete(new Region(new BigDecimal(40), "Antartica Region"), false));

//        /* delete */
//        System.out.println(gdao.saveOrDelete(new Region(new BigDecimal(40)), true));
//
//        /* getById */
//        System.out.println(gdao.getById(new BigDecimal("1")).getName());
//
//        for (Region region : gdao.getData("")) {
//            System.out.println(region.getId() + " - " + region.getName());
//        }
        /* Location */
        //System.out.println(ldao.getById(new Short("1000")).getCountry());

//        for (Location location : ldao.getData("")) {
//            System.out.println(location.getId() + " - " + location.getPostalCode());
//        }
 /**
         * GET ALL
         */
//        GeneralDAO<Department> dDao = new GeneralDAO<>(factory, Department.class);
////        DepartmentController dc = new DepartmentController(factory);
//
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



/**
 * author erik
 */

SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
//        IJobDAO ijdao = new JobDAO(SessionFactory);
        // TODO code application logic here
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        System.out.println(SessionFactory);
        /**
         * untuk melakukan test insert >>
         *
         */
//        IJobDAO job = new JobDAO(SessionFactory);
//        Job job1 = new Job("AD_NANY","nani",200,299);
//        System.out.println(job.insert(job1));    

        
//        for (Job job : ijdao.search("AD_VP")) {
//            System.out.println(job.getId());
//            System.out.println(job.getTitle());
//            System.out.println(job.getMinSalary());
//            System.out.println(job.getMaxSalary());
//        }
//
//        for (Job job1 : job.getAll()) {
//            System.out.println(job1.getId());
//            System.out.println(job1.getTitle());
//            System.out.println(job1.getMinSalary());
//            System.out.println(job1.getMaxSalary());
//
//        }

        CountryDAO<Country> cdao = new CountryDAO<>(SessionFactory,Country.class);
        
        /**
         * untuk test getAll menggunakan ""
         * untuk test getById menggunakan ""
         * untuk test getSearch tinggal masukkan kata kunci di " "
         * 
         */
//        for (Country country : cdao.getData("AR") ) {
//            System.out.println(country.getId());
//            System.out.println(country.getName());
//            System.out.println(country.getRegion());
//                      
//        }
            
//           for (Country country : cdao.getData("AM")) {
//               System.out.println(country.getName());
//               System.out.println(country.getId());
//               System.out.println(country.getRegion());
//        }
           /**
            * untuk melakukan delete byId
            * untuk melakukan insert masukkan value yang akan di insert pada country dan juga ganti boolean menjadi false
            * untuk melakukan insert masukkan value yang akan di insert pada country dan juga ganti boolean menjadi false
            */
          Country country = new Country("AY", "Ameritak", new Region(new BigDecimal(2) ));       
        System.out.println(cdao.saveOrDelete(country, false));
    
        /*Job*/
        //insert
//        System.out.println(jdao.saveOrDelete(new Job("SA_KAR", "Programmer", 20000, 35000), false));

        //update
//        System.out.println(jdao.saveOrDelete(new Job("SA_KAR", "Programmer", 25000, 35000), false));
        
        //delete
//        System.out.println(jdao.saveOrDelete(new Job("SA_KAR", "Programmer", 25000, 35000), true));
        
        //getById
//        System.out.println(jdao.getById("PU_MAN").getMaxSalary());

        //getAll
//        for (Job job : jdao.getData("")) {
//            System.out.println(job.getTitle()+" - "+job.getMaxSalary());
//        }

        //search
//         for (Job job : jdao.getData("St")) {
//            System.out.println(job.getTitle()+" - "+job.getMinSalary());
//        }
    }
}
