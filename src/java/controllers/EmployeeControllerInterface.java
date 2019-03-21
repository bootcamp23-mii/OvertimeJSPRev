/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Employee;

/**
 *
 * @author milhamafemi
 */
public interface EmployeeControllerInterface {

    public String insertOrUpdate(String id, String nama, String address, String salary, String email, String password, String division, String site, String idManager);

    public String register(String id, String nama, String address, String salary, String email, String password, String division, String site, String idManager);

    public String register2(String id, String nama, String address, String salary, String email, String password, String division, String site, String idManager, String job);
    
    public String delete(String id);

    public String updateJob(String id, String nama, String job);

    public List<Employee> getAll();

    public List<Employee> getData(String keyword);

    public Employee getById(String id);

    public boolean login(String username, String Password);

}
