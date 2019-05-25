/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Country;

/**
 *
 * @author erik
 */
public interface ICountryDAO <T> {
    public T getById(Short id);
    public List<T> getData(Object keyword);
    public boolean saveOrDelete(T object, boolean isDelete);
}

