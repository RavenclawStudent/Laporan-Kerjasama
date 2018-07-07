/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapor.kerma.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ODETTE
 */
public class KermaDAO {
    static KermaDAO instance;
    
    // Ubah 5 (lima) konstanta berikut ini sesuai dengan konfigurasi MySQL masing-masing
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "laporkerma";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
    
    private static final String FIELD_ALAMAT = "alamat";
    private static final String FIELD_DETAIL = "detail";
    private static final String FIELD_INTERNAL = "internal";
    private static final String FIELD_JENIS = "jenis";
    private static final String FIELD_LINK = "link";
    private static final String FIELD_NAMA = "nama";
    private static final String FIELD_NOMOR = "nomor";
    private static final String FIELD_PARTNER = "partner";
    private static final String FIELD_TG_AWAL = "tg_awal";
    private static final String FIELD_TG_AKHIR = "tg_akhir";
   
    
    private Connection conn;
    private PreparedStatement statement;
    
    public static KermaDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new KermaDAO();
        }
        return instance;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    public KermaDAO() throws SQLException {
//        createListMahasiswaDummy();
        bukaKoneksiDB();
    }

    public Connection getConn() {
        return conn;
    }

    public PreparedStatement getStatement() {
        return statement;
    }
    
    private Connection bukaKoneksiDB() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to KERMA database...");
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            if (conn != null) {
                System.out.println("Succesfully connected to database.\n");
            }
            
            return conn;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
}
