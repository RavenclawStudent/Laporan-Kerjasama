/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapor.kerma.model;

/**
 *
 * @author ODETTE
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapor.kerma.model.Login;
import lapor.kerma.frame.KERMA;

public class LoginDAO {

    static final String JBDC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/laporkerma";
    static final String DB_USERNAME = "kerma";
    static final String DB_PASSWORD = "Laporkerma1@";
    Connection conn = null;
    Statement stmt = null;

    public Login validateUser(String form_username, String form_password) throws Exception {
        String Username="";
            String Fullname="";
            String Password="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Connecting to database...");
        System.out.println("...");
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            if (conn != null) {
                System.out.println("Successfully connected to database\n");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Creating statement ...\n");
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * from tb_user WHERE id='"+form_username+"'";
            System.out.println(sql);
            ResultSet hasil = stmt.executeQuery(sql);

            hasil.next();
             Username = hasil.getString("id");
             Fullname = hasil.getString("unit");
             Password = hasil.getString("password");
            

            System.out.println(Username + Password);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login foundUser = new Login(Username, Fullname, Password);
        
        if (!foundUser.getUsername().equals(form_username)) {
            System.out.println(foundUser.getUsername());
            throw new Exception("User tersebut tidak dapat ditemukan");
        } else if (!foundUser.getPassword().equals(form_password)) {
            throw new Exception("Password tidak sesuai");
        } else if(foundUser.getPassword().isEmpty()){
            throw new Exception("Masukkan Username dan Password");
        }
        KERMA.kdUnit = foundUser.getUsername();
        
        return foundUser;

    }
}
