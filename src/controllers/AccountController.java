/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IAccountController;
import idaos.IGeneralDAO;
import java.util.List;
import models.Account;
import org.hibernate.SessionFactory;
import tools.BCrypt;

/**
 *
 * @author HP
 */
public class AccountController implements IAccountController{
    private IGeneralDAO<Account> igdao;

    public AccountController(SessionFactory factory) {
        igdao = new GeneralDAO(factory, Account.class);
    }
    
    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public String register (String id, String username, String password) {
        String result = "";
        String pass = hash(password);
        Account account = new Account(Integer.parseInt(id), username, pass);
        if (igdao.saveOrDelete(account, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }
    
}
