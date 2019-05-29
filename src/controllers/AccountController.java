/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAccountController;
import java.util.List;
import models.Account;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class AccountController implements IAccountController{
    private GeneralDAO<Account> gdao;

    public AccountController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Account.class);
    }
    


    @Override
    public String register (String id, String username, String password) {
        String result = "";
        
        Account account = new Account(Integer.parseInt(id), username, password);
        if (gdao.register(account)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }
    
}
