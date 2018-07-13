/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapor.kerma.model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ODETTE
 */
public class Login {

    static final String JBDC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/laporkerma";
    static final String DB_USERNAME = "kerma";
    static final String DB_PASSWORD = "Laporkerma1@";
    Connection conn = null;
    Statement stmt = null;
    String username;
    String unit;
    String password;

    public Login(String username, String unit, String password) {
        this.username = username;
        this.unit = unit;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return unit;
    }

    public void setFullname(String unit) {
        this.unit = unit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
