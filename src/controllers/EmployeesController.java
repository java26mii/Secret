/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IEmployeesController;
import idaos.IReportDAO;
import org.hibernate.SessionFactory;

/**
 *
 * @author WINDOWS 10
 */
public class EmployeesController implements IEmployeesController{
    private IReportDAO redao;
    private SessionFactory factory;

    public EmployeesController(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public String Report(String file) {
        return redao.Report("");
    }
    
}
