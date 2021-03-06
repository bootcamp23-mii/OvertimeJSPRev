<%-- 
    Document   : adminCreateUser
    Created on : 14-Mar-2019, 10:00:49
    Author     : Pandu
--%>

<%@page import="models.Job"%>
<%@page import="models.Site"%>
<%@page import="java.util.List"%>
<%@page import="models.Division"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="section__content section__content--p30">
        <div class="container-fluid">
            <div class="container-fluid">
                <div class="row">
                  </div>
                <div class="row m-t-25">
                </div>  <div class="col-md-12">
                    </div>
                </div>
                <div class="row m-t-25">
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="au-card recent-report">
                            <div class="au-card-inner">
                                <h3 class="title-10" > Create User</h3>
                                <div class="row m-t-25">
                                </div>
                                <div class="col-lg-12">
                                    <form action="AdminServlet" method="POST">
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="tf-name" class=" form-control-label">Name</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="tf-name" name="tf-name" placeholder="" class="form-control" />
                                                <span class="help-block">What' Your Name?</span>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="tf-address" class=" form-control-label">Address</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="tf-address" name="tf-address" placeholder="" class="form-control" />
                                                <span class="help-block">Where Are You From?</span>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="tf-salary" class=" form-control-label">Salary</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="tf-salary" name="tf-salary" placeholder="" class="form-control" />
                                                <span class="help-block">How much  Salary You have got?</span>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="tf-email" class=" form-control-label">Email</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="email" id="tf-email" name="tf-email" placeholder="" class="form-control" />
                                                <span class="help-block">Your Email?</span>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="cb-division" class=" form-control-label">Division</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <div>
                                                    <select class="custom-select" name="cb-division" id="cb-division"><% for (Division elem : (List<Division>) session.getAttribute("dataDiv")) {
                                                            out.print("<option "
                                                                    + "value=\"" + elem.getId() + "\" "
                                                                    + (elem.getId().equals(session.getAttribute("dataDiv")) ? "selected" : "") + ">"
                                                                    + elem.getName()
                                                                    + "</option>");
                                                        }
                                                        %></select>
                                                </div>
                                                <span class="help-block">Your Division?</span>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="cb-site" class=" form-control-label">Site</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <div>
                                                    <select class="custom-select" name="cb-site" id="cb-site"><% for (Site elem : (List<Site>) session.getAttribute("dataSite")) {
                                                            out.print("<option "
                                                                    + "value=\"" + elem.getId() + "\" "
                                                                    + (elem.getId().equals(session.getAttribute("dataSite")) ? "selected" : "") + ">"
                                                                    + elem.getName()
                                                                    + "</option>");
                                                        }
                                                        %></select>
                                                </div> 
                                                <span class="help-block">Your Site?</span>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="tf-manager" class=" form-control-label">Manager Id</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="tf-description" name="tf-manager" placeholder="" class="form-control" />
                                                <span class="help-block">Who is Your manager?</span>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="cb-job" class=" form-control-label">Position</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <div>
                                                    <select class="custom-select" name="cb-job" id="cb-job"><% for (Job elem : (List<Job>) session.getAttribute("dataJob")) {
                                                            out.print("<option "
                                                                    + "value=\"" + elem.getId() + "\" "
                                                                    + (elem.getId().equals(session.getAttribute("dataJob")) ? "selected" : "") + ">"
                                                                    + elem.getPosition()
                                                                    + "</option>");
                                                        }%></select>
                                                </div> <span class="help-block">What's Your Position?</span>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Submit
                                        </button>
                                        <button type="reset" class="btn btn-danger btn-sm">
                                            <i class="fa fa-ban"></i> Reset
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</html>
