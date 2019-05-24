/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IDepartmentController;
import java.math.BigDecimal;
import java.util.List;
import models.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasari
 */
public class DepartmentController implements IDepartmentController {

    private GeneralDAO<Department> gdao;

    public DepartmentController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Department.class);
    }

    @Override
    public List<Department> getAll() {
        return gdao.getData("");
    }

    @Override
    public Department getById(String id) {
        return gdao.getById(new BigDecimal(id));
    }

    @Override
    public List<Department> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String name, String manager_id, String location_id) {
        String result = "Data gagal disimpan";
        if(gdao.saveOrDelete(new Department(), true)){
            result = "Data berhasil disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "Data gagal disimpan";
        if(gdao.saveOrDelete(new Department(), false)){
            result = "Data berhasil disimpan";
        }
        return result;
    }

    
   
}
