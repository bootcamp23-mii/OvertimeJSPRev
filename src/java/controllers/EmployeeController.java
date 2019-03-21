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
import models.Employee;
import models.Job;
import models.LoginSession;
import models.SendEmailTemp;
import models.Site;
import org.hibernate.SessionFactory;
import tools.BCrypt;

/**
 *
 * @author Lusiana
 */
public class EmployeeController implements EmployeeControllerInterface {

    private DAOInterface<Employee> dao;

    public EmployeeController(SessionFactory factory) {
        dao = new GeneralDAO<>(factory, Employee.class);
    }

    @Override
    public String register(String id, String nama, String address, String salary, String email, String password, String division, String site, String idManager) {
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        if (dao.saveOrDelete(new Employee(id, nama, address, new Integer(salary), email, passwordHash, new Division(division), new Site(site), new Employee(idManager)), true)) {
            return "Selamat penambahan karyawan berhasil";
        }
        return "Maaf coba lagi";
    }

    @Override
    public String register2(String id, String nama, String address, String salary, String email, String password, String division, String site, String idManager, String job) {
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        String passwordHash2 = BCrypt.hashpw(password, BCrypt.gensalt());
        if (dao.saveOrDelete(new Employee(id, nama, address, new Integer(salary), email, passwordHash, new Division(division), new Site(site), new Employee(idManager), new Job(job)), true)) {
            SendEmailTemp.setToEmail(email);
            SendEmailTemp.setMessage("<html>\n"
                    + "<body>\n"
                    + "\n"
                    + "<a href=\"http://localhost:8084/OvertimeJSP/activationUser.jsp?namelink=" + nama + "&hash=" + passwordHash2 + "\">\n"
                    + "<button>YOLO YOLO<button></a>\n"
                    + "\n"
                    + "</body>\n"
                    + "</html>");
            SendEmailTemp.setSubject("ACTIVATE YOUR ACCOUNT");
            new SendMail().generate();

            return "Selamat penambahan karyawan berhasil";
        }
        return "Maaf coba lagi";
    }

    @Override
    public String insertOrUpdate(String id, String nama, String address, String salary, String email, String password, String division, String site, String idManager) {
        if (dao.saveOrDelete(new Employee(id, nama, address, new Integer(salary), email, password, new Division(division), new Site(site), new Employee(idManager)), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }

    @Override
    public String updateJob(String id, String nama, String job) {
        if (dao.saveOrDelete(new Employee(id, nama, new Job(job)), true)) {
            return "Selamat Data berhasil simpan";
        }
        return "Maaf Data gagal disimpan";
    }

    @Override
    public String delete(String id) {
        if (dao.saveOrDelete(new Employee(id), false)) {
            return "Selamat Data berhasil dihapus";
        }
        return "Maaf Data gagal dihapus";
    }

    @Override
    public List<Employee> getAll() {
        return dao.getData("");
    }

    @Override
    public List<Employee> getData(String keyword) {
        return dao.getData(keyword);
    }

    @Override
    public Employee getById(String id) {
        return dao.getById(id);
    }

    @Override
    public boolean login(String username, String password) {
        List<Employee> list = dao.login(username);
        if (!list.isEmpty()) {
            for (Employee employee : list) {
                LoginSession.setIdUsername(employee.getId());
                if (BCrypt.checkpw(password, employee.getPassword())) {
                    return true;
                }
            }
        }
        System.out.println("List kosong");
        return false;
    }

}
