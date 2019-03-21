<%-- 
    Document   : activationUser
    Created on : 20-Mar-2019, 11:02:33
    Author     : Pandu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <jsp:include page="head.jsp"/>
    <div class="page-wrapper">
        <div class="page-content--bge5">
            <div class="container">
                <div class="login-wrap">
                    <div class="login-content">
                        <div class="login-logo">
                            <h1>CONGRATULATIONS</h1>
                            <h3>Your Account <%= request.getParameter("namelink")%> Have Been Actived </h3>
                        </div>
                        <b><%= request.getParameter("name")%></b>
                        <div class="login-form">
                            <div class="form-group">
                                    <label>ID Employee</label>
                                    <input class="au-input au-input--full" type="text" name="usernameLogin" placeholder="<%= request.getParameter("namelink")%>">
                                </div>
                                <%String user = request.getParameter("name");%>
                                <%String mypass = request.getParameter("hash");%>
                                <div class="form-group">
                                    <label>ENCRYPTED</label>
                                    <input class="au-input au-input--full" type="password" name="passwordLogin" placeholder="<%= request.getParameter("hash")%>">
                                </div>
                            <form action="ActivationServlet" method="POST">
                                <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">Activate Your Accounnt !</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>
