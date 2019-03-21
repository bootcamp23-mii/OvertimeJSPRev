/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.util.List;
import models.Site;
import org.hibernate.SessionFactory;

/**
 *
 * @author milhamafemi
 */
public class SiteController implements SiteControllerInterface{
    private DAOInterface<Site> dao;
    
    public SiteController(SessionFactory factory) {
        dao = new GeneralDAO<>(factory, Site.class);
    }
    @Override
    public List<Site> getAll() {
        return dao.getData("");
    }
}
