/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.DivisionController;
import controllers.DivisionControllerInterface;
import controllers.EmployeeController;
import controllers.EmployeeControllerInterface;
import controllers.JobController;
import controllers.JobControllerInterface;
import controllers.SendMail;
import controllers.SiteController;
import controllers.SiteControllerInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Division;
import models.Employee;
import models.Job;
import models.SendEmailTemp;
import models.Site;
import tools.HibernateUtil;

/**
 *
 * @author milhamafemi
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    EmployeeControllerInterface ec = new EmployeeController(HibernateUtil.getSessionFactory());
    JobControllerInterface jc = new JobController(HibernateUtil.getSessionFactory());
    DivisionControllerInterface dc = new DivisionController(HibernateUtil.getSessionFactory());
    SiteControllerInterface sc = new SiteController(HibernateUtil.getSessionFactory());

    List<Employee> dataEmp = null;
    List<Job> dataJob = null;
    List<Site> dataSite = null;
    List<Division> dataDiv = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            dataEmp = ec.getAll();
            dataJob = jc.getAll();
            dataDiv = dc.getAll();
            dataSite = sc.getAll();

            request.getSession().setAttribute("dataJob", dataJob);
            request.getSession().setAttribute("dataEmp", dataEmp);
            request.getSession().setAttribute("dataDiv", dataDiv);
            request.getSession().setAttribute("dataSite", dataSite);
            response.sendRedirect("index.jsp");
//            for (Employee employee : dataEmp) {
//                request.getSession().setAttribute("idEmpList", employee.getId());
//                request.getSession().setAttribute("nameEmpList", employee.getName());
//                request.getSession().setAttribute("jobEmpList", employee.getJob());
//            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equalsIgnoreCase("update")) {
                Employee employee = ec.getById(request.getParameter("id"));
                request.getSession().setAttribute("UAid", employee.getId());
                request.getSession().setAttribute("UAname", employee.getName());
                request.getSession().setAttribute("UAjob", employee.getJob().getPosition());
            }
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (ec.register2("ID", request.getParameter("tf-name"), request.getParameter("tf-address"), request.getParameter("tf-salary"), request.getParameter("tf-email"), request.getParameter("tf-password"), request.getParameter("cb-division"), request.getParameter("cb-site"), "EMP01", request.getParameter("cb-job")) != null) {
            processRequest(request, response);
        } else if (ec.updateJob(request.getParameter("UAid"), request.getParameter("UAname"), request.getParameter("UAjob")
        ) != null) {
            processRequest(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
