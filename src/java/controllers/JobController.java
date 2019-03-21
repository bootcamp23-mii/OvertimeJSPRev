/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import java.util.List;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author milhamafemi
 */
public class JobController implements JobControllerInterface{
    private DAOInterface<Job> dao;
    
    public JobController(SessionFactory factory) {
        dao = new GeneralDAO<>(factory, Job.class);
    }
    
    @Override
    public List<Job> getAll() {
        return dao.getData("");
    }
}
