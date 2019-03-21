/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Job;

/**
 *
 * @author milhamafemi
 */
public interface JobControllerInterface {
    public List<Job> getAll();
}
