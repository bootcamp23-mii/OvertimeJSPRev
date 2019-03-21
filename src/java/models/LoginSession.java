/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author milhamafemi
 */
public class LoginSession {
    private static String idUsername;
    private static String roleUsername;
    
    public LoginSession() {
    }

    public static String getIdUsername() {
        return idUsername;
    }

    public static void setIdUsername(String idUsername) {
        LoginSession.idUsername = idUsername;
    }

    public static String getRoleUsername() {
        return roleUsername;
    }

    public static void setRoleUsername(String roleUsername) {
        LoginSession.roleUsername = roleUsername;
    }
    
}
