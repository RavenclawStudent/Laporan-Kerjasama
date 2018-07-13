/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapor.kerma.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapor.kerma.model.Kerma;
import static lapor.kerma.frame.Data.DB_URL;

/**
 *
 * @author ODETTE
 */
public class Detail extends javax.swing.JFrame {

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Creates new form Tambah
     */
    static final String JBDC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/laporkerma";
    static final String DB_USERNAME = "kerma";
    static final String DB_PASSWORD = "Laporkerma1@";
    Connection conn = null;
    Statement stmt = null;

    //Variable Mode untuk edit dan detail
    public static int MODE = 2;
    public static String id = "";

    //Variable Instance / Example
    private static Detail instance = null;

    public static Detail getInstance() {
        if (instance == null) {
            instance = new Detail();
        }

        return instance;
    }
    SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

    public Detail() {
        initComponents();
        if (MODE != 2) {
            tampilkan_data();
        }

        //Pengecekan mode, apabila 1 maka detail apabila 2 maka edit
        if (MODE == 1) {
            //Detail mode
            //matikan seluruhnya 
            enable_seluruhnya(false);

            //matikan button save
            saveButton.setVisible(false);
            //hidupkan Edit button
            editButton.setVisible(true);
            resetButton.setVisible(false);
        }
        else if (MODE == 2) {
            //Detail mode
            //matikan seluruhnya 
            enable_seluruhnya(true);
            no_dok.setEditable(true);

            //matikan button save
            saveButton.setVisible(true);
            //hidupkan Edit button
            editButton.setVisible(false);
            resetButton.setVisible(true);
        } else {
            //Edit mode
            //Hidupkan seluruhnya 
            enable_seluruhnya(true);

            //Hidupkan button save
            saveButton.setVisible(true);
            //Matikan Edit button
            editButton.setVisible(false);
            resetButton.setVisible(false);
        }

    }

    void tampilkan_data() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Connecting to database...");
        System.out.println("...");
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            if (conn != null) {
                System.out.println("Successfully connected to database\n");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Creating statement ...\n");
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * from tb_kerjasama where nomor = '" + id + "'";
            System.out.println(sql);
            ResultSet hasil = stmt.executeQuery(sql);

            hasil.next();
            String no = hasil.getString("nomor");
            String nama = hasil.getString("nama");
            String jenis = hasil.getString("jenis");
            //Rubah jenis jadi int
            int pos_jenis = Integer.parseInt(jenis);
            switch (jenis) {
                case "1":
                    jenis = "Memorandum of Understanding";
                    break;
                case "2":
                    jenis = "Implementation Arrangement";
                    break;
                case "3":
                    jenis = "Memorandum of Agreement";
                    break;
            }

            String Negara = hasil.getString("negara");
            Date tg_akhir = null, tg_awal = null;
            String tgl_awal = sm.format(hasil.getDate("tg_awal"));
            if (hasil.getDate("tg_awal") == null || tgl_awal.equals("0000-00-00")) {

            } else {
                tg_awal = hasil.getDate("tg_awal");
            }
            String tgl_akhir = sm.format(hasil.getDate("tg_akhir"));
            if (hasil.getDate("tg_akhir") == null || tgl_akhir.equals("0000-00-00")) {

            } else {
                tg_akhir = hasil.getDate("tg_akhir");
            }
            String alamat = hasil.getString("alamat");
            String detail = hasil.getString("detail");
            String internal = hasil.getString("internal");
            String partner = hasil.getString("partner");
            String link = hasil.getString("link");

            //System.out.println(nama + jenis);
            Kerma new_kerma = new Kerma(jenis, no, nama, alamat, detail, tg_awal, tg_akhir, internal, partner, link, Negara);

            //tampil di form
//                jenis_kerjasama.setText(jenis);
            negara.setSelectedItem(Negara);
            jenis_kerjasama.setSelectedIndex(pos_jenis - 1);
            no_dok.setText(no);
            nama_institusi.setText(nama);
            address.setText(alamat);
            bentuk_kerjasama.setText(detail);
            tglAwal.setDate(tg_awal);
            tglAkhir.setDate(tg_awal);
            pihak_internal.setText(internal);
            pihak_partner.setText(partner);
            link_kerjasama.setText(link);

        } catch (Exception e) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        no_dok = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama_institusi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bentuk_kerjasama = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pihak_internal = new javax.swing.JTextField();
        pihak_partner = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        keluarButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        link_kerjasama = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        jenis_kerjasama = new javax.swing.JComboBox<>();
        tglAwal = new org.jdesktop.swingx.JXDatePicker();
        tglAkhir = new org.jdesktop.swingx.JXDatePicker();
        resetButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        negara = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Jenis Kerjasama");

        jLabel2.setText("Nomor Dokumen ");

        no_dok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_dokActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Institusi");

        jLabel4.setText("Alamat");

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        jLabel5.setText("Bentuk Kerjasama");

        bentuk_kerjasama.setColumns(20);
        bentuk_kerjasama.setRows(5);
        jScrollPane1.setViewportView(bentuk_kerjasama);

        jLabel6.setText("Nama Penandatangan");

        jLabel7.setText("Tanggal Dibuat");

        jLabel8.setText("Tanggal Berakhir");

        jLabel9.setText("Pihak Internal");

        jLabel10.setText("Pihak Partnership");

        pihak_internal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pihak_internalActionPerformed(evt);
            }
        });

        pihak_partner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pihak_partnerActionPerformed(evt);
            }
        });

        jLabel11.setText("Link File Kerjasama");

        keluarButton.setText("Keluar");
        keluarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        link_kerjasama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                link_kerjasamaActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jenis_kerjasama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Memorandum of Understanding", "Implementation Arrangement", "Memorandum of Agreement" }));
        jenis_kerjasama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenis_kerjasamaActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel12.setText("Negara");

        negara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czechia", "Côte d'Ivoire", "Democratic People's Republic of Korea", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia Ethiopia", "Faroe Islands", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Lao People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Republic of Korea", "Republic of Moldova", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syrian Arab Republic", "Tajikistan", "Thailand", "The former Yugoslav Republic of Macedonia", "Timor-Leste", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United Republic of Tanzania", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Viet Nam", "Yemen", "Zambia", "Zimbabwe" }));
        negara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negaraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(235, 263, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(keluarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(no_dok)
                                    .addComponent(jenis_kerjasama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nama_institusi)
                                    .addComponent(address))))
                        .addGap(51, 51, 51)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(116, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(negara, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pihak_internal)
                            .addComponent(pihak_partner)
                            .addComponent(link_kerjasama)
                            .addComponent(tglAwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tglAkhir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jenis_kerjasama, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(no_dok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(negara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nama_institusi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editButton)
                            .addComponent(keluarButton)
                            .addComponent(saveButton)
                            .addComponent(resetButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tglAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tglAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(pihak_internal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(pihak_partner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(link_kerjasama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keluarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarButtonActionPerformed
        // TODO add your handling code here:
        //keluar
        this.setVisible(false);
    }//GEN-LAST:event_keluarButtonActionPerformed

    private void pihak_partnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pihak_partnerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pihak_partnerActionPerformed

    private void pihak_internalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pihak_internalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pihak_internalActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void link_kerjasamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_link_kerjasamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_link_kerjasamaActionPerformed

    private void no_dokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_dokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_dokActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        //matikan edit button
        editButton.setEnabled(false);
        //hidupkan save button
        saveButton.setEnabled(true);

        //Enable seluruh element 
        enable_seluruhnya(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        //hidupkan edit button
        editButton.setVisible(true);
        //matikan save button
        saveButton.setVisible(false);
        resetButton.setVisible(false);

        //Disable seluruhnya
        enable_seluruhnya(false);

        //Simpan ke dalam db
        int jenis = jenis_kerjasama.getSelectedIndex() + 1;
        String nomor = no_dok.getText();
        String nama = nama_institusi.getText();
        String alamat = address.getText();
        String detail = bentuk_kerjasama.getText();
        String tg_awal = df.format(tglAwal.getDate());
        String tg_akhir = df.format(tglAkhir.getDate());
//        Date tg_awal = tglAwal.getDate();
//        Date tg_akhir = tglAkhir.getDate();
        String internal = pihak_internal.getText();
        String partner = pihak_partner.getText();
        String link_dok = link_kerjasama.getText();
        String Negara = (String) negara.getSelectedItem();

        Kerma kerma = new Kerma();
        kerma.setJenis(jenis + "");
        kerma.setNomor(nomor);
        kerma.setNama(nama);
        kerma.setAlamat(alamat);
        kerma.setDetail(detail);
        Date tgl_awal_obj = null, tgl_akhir_obj = null;
        if (MODE == 3) {
            try {
                //jadikan tgl dari string ke date agar bisa disimpan di object
                tgl_awal_obj = kerma.dbDateFormat.parse(tg_awal);
                tgl_akhir_obj = kerma.dbDateFormat.parse(tg_akhir);
            } catch (ParseException ex) {
                Logger.getLogger(Detail.class.getName()).log(Level.SEVERE, null, ex);
            }

            kerma.setTg_awal(tgl_awal_obj);
            kerma.setTg_akhir(tgl_akhir_obj);
            kerma.setInternal(internal);
            kerma.setPartner(partner);
            kerma.setLink(link_dok);

            //Masukkan ke DB
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Connecting to database...");
            System.out.println("...");
            try {
                conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                if (conn != null) {
                    System.out.println("Successfully connected to database\n");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Creating statement ...\n");
            try {
                stmt = conn.createStatement();
                String sql = "UPDATE `tb_kerjasama` SET `jenis` = '" + jenis + "', "
                        + "`nama` = '" + nama + "', `alamat` = '" + alamat + "'"
                        + ", `detail` = '" + detail + "', `tg_awal` = '" + tg_awal + "'"
                        + ", `tg_akhir` = '" + tg_akhir + "', `internal` = '" + internal + "'"
                        + ", `partner` = '" + partner + "', `link` = '" + link_dok + "', `negara` = '"+Negara+"' "
                        + "WHERE `tb_kerjasama`.`nomor` = '" + nomor + "';";
                System.out.println(sql);
                stmt.execute(sql);

                //Tutup
                dispose();
            } catch (Exception e) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, e);
                System.out.println(e.getMessage());
            }
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Connecting to database...");
            System.out.println("...");
            try {
                conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                if (conn != null) {
                    System.out.println("Successfully connected to database\n");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Creating statement ...\n");
            try {
                stmt = conn.createStatement();
                String sql = "INSERT INTO `tb_kerjasama` (`jenis`, `nomor`, `nama`, "
                        + "`alamat`, `detail`, `tg_awal`, `tg_akhir`, `internal`, `partner`, `link`,negara) "
                        + "VALUES ('" + jenis + "', '" + nomor + "', '" + nama + "', '" + alamat + "', '" + detail + "'"
                        + ", '" + tg_awal + "', '" + tg_akhir + "', '" + internal + "', '" + partner + "', '" + link_dok + "','"+Negara+"')";
                System.out.println(sql);
                stmt.execute(sql);

                //Tutup
                dispose();
            } catch (Exception e) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, e);
                System.out.println(e.getMessage());
            }
        }

    }//GEN-LAST:event_saveButtonActionPerformed

    private void jenis_kerjasamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenis_kerjasamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenis_kerjasamaActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        no_dok.setText("");
        nama_institusi.setText("");
        address.setText("");
        bentuk_kerjasama.setText("");
        pihak_internal.setText("");
        pihak_partner.setText("");
        link_kerjasama.setText("");

    }//GEN-LAST:event_resetButtonActionPerformed

    private void negaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negaraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_negaraActionPerformed
    void enable_seluruhnya(boolean pilihan) {
        //jenis_kerjasama.setEnabled(pilihan); tidak dapat dicopy
        jenis_kerjasama.setEnabled(pilihan);
        no_dok.setEditable(pilihan);
        nama_institusi.setEditable(pilihan);
        address.setEditable(pilihan);
        bentuk_kerjasama.setEditable(pilihan);
        pihak_internal.setEditable(pilihan);
        pihak_partner.setEditable(pilihan);
        link_kerjasama.setEditable(pilihan);
        tglAwal.setEditable(pilihan);
        tglAkhir.setEditable(pilihan);

        //Kecuali Nomor
        no_dok.setEditable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextArea bentuk_kerjasama;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenis_kerjasama;
    private javax.swing.JButton keluarButton;
    private javax.swing.JTextField link_kerjasama;
    private javax.swing.JTextField nama_institusi;
    private javax.swing.JComboBox<String> negara;
    private javax.swing.JTextField no_dok;
    private javax.swing.JTextField pihak_internal;
    private javax.swing.JTextField pihak_partner;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private org.jdesktop.swingx.JXDatePicker tglAkhir;
    private org.jdesktop.swingx.JXDatePicker tglAwal;
    // End of variables declaration//GEN-END:variables
}
