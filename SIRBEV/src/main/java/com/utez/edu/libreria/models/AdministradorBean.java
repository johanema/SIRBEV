package com.utez.edu.libreria.models;

import java.io.InputStream;

public class AdministradorBean {
    private String idadmin;
    private String passadmin;
    private String nomadmin;
    private String apePadmin;
    private String apeMadmin;
    private String correoadmin;
    private String teladmin;
    private InputStream fotoadmin;
    private byte[] fotoadmin2;

    public AdministradorBean() {
    }

    public AdministradorBean(String idadmin, String passadmin) {
        this.idadmin = idadmin;
        this.passadmin = passadmin;
    }

    public AdministradorBean(String idadmin, String nomadmin, String apePadmin, String apeMadmin, String correoadmin, String teladmin, InputStream fotoadmin) {
        this.idadmin = idadmin;
        this.nomadmin = nomadmin;
        this.apePadmin = apePadmin;
        this.apeMadmin = apeMadmin;
        this.correoadmin = correoadmin;
        this.teladmin = teladmin;
        this.fotoadmin = fotoadmin;
    }

    public AdministradorBean(String idadmin, String passadmin, String nomadmin, String apePadmin, String apeMadmin, String correoadmin, String teladmin, InputStream fotoadmin) {
        this.idadmin = idadmin;
        this.passadmin = passadmin;
        this.nomadmin = nomadmin;
        this.apePadmin = apePadmin;
        this.apeMadmin = apeMadmin;
        this.correoadmin = correoadmin;
        this.teladmin = teladmin;
        this.fotoadmin = fotoadmin;
    }

    public String getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(String idadmin) {
        this.idadmin = idadmin;
    }

    public String getPassadmin() {
        return passadmin;
    }

    public void setPassadmin(String passadmin) {
        this.passadmin = passadmin;
    }

    public String getNomadmin() {
        return nomadmin;
    }

    public void setNomadmin(String nomadmin) {
        this.nomadmin = nomadmin;
    }

    public String getApePadmin() {
        return apePadmin;
    }

    public void setApePadmin(String apePadmin) {
        this.apePadmin = apePadmin;
    }

    public String getApeMadmin() {
        return apeMadmin;
    }

    public void setApeMadmin(String apeMadmin) {
        this.apeMadmin = apeMadmin;
    }

    public String getCorreoadmin() {
        return correoadmin;
    }

    public void setCorreoadmin(String correoadmin) {
        this.correoadmin = correoadmin;
    }

    public String getTeladmin() {
        return teladmin;
    }

    public void setTeladmin(String teladmin) {
        this.teladmin = teladmin;
    }


    public InputStream getFotoadmin() {
        return fotoadmin;
    }

    public void setFotoadmin(byte[] fotoadmin2) {
        this.fotoadmin2 = fotoadmin2;
    }
}