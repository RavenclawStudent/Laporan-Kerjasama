/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapor.kerma.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ODETTE
 */
public class Kerma {

    private String jenis;
    private String nomor;
    private String nama;
    private String alamat;
    private String detail;
    private Date tg_awal;
    private Date tg_akhir;
    private String internal;
    private String partner;
    private String link;
    private String negara;
    private String userid;
    public SimpleDateFormat dbDateFormat;
    public SimpleDateFormat outputDateFormat;

    public Kerma() {
        dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        outputDateFormat = new SimpleDateFormat("dd MMMM yyyy");
    }
    //Konstruktor
    public Kerma(String jenis, String nomor, String nama, String alamat, String detail, Date tg_awal, Date tg_akhir, String internal, String partner, String link, String negara, String userid) {
        this.jenis = jenis;
        this.nomor = nomor;
        this.nama = nama;
        this.alamat = alamat;
        this.detail = detail;
        this.tg_awal = tg_awal;
        this.tg_akhir = tg_akhir;
        this.internal = internal;
        this.partner = partner;
        this.link = link;
        this.negara = negara;
        this.userid = userid;
        dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        outputDateFormat = new SimpleDateFormat("dd MMMM yyyy");
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getInternal() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public Date getTg_awal() {
        return tg_awal;
    }

    public void setTg_awal(Date tg_awal) {
        this.tg_awal = tg_awal;
    }

    public Date getTg_akhir() {
        return tg_akhir;
    }

    public void setTg_akhir(Date tg_akhir) {
        this.tg_akhir = tg_akhir;
    }


    public SimpleDateFormat getDbDateFormat() {
        return dbDateFormat;
    }

    public void setDbDateFormat(SimpleDateFormat dbDateFormat) {
        this.dbDateFormat = dbDateFormat;
    }

    public SimpleDateFormat getOutputDateFormat() {
        return outputDateFormat;
    }

    public void setOutputDateFormat(SimpleDateFormat outputDateFormat) {
        this.outputDateFormat = outputDateFormat;
    }

 
    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }
    
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
