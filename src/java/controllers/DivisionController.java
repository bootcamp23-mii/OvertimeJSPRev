/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.util.List;
import models.Division;
import org.hibernate.SessionFactory;

/**
 *
 * @author milhamafemi
 */
public class DivisionController implements DivisionControllerInterface{
    private DAOInterface<Division> dao;
    
    public DivisionController(SessionFactory factory) {
        dao = new GeneralDAO<>(factory, Division.class);
    }
    @Override
    public List<Division> getAll() {
        return dao.getData("");
    }
}
