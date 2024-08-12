package com.utez.edu.libreria.models;

import java.io.InputStream;

public class DocenteBean {
    private String iddoc;
    private String passdoc;
    private String nomdoc;
    private String apePdoc;
    private String apeMdoc;
    private String correodoc;
    private String teldoc;
    private InputStream fotodoc;
    private byte[] fotodoc2;

    private String idadministrador;

    public DocenteBean() {
    }

    public DocenteBean(String iddoc, String passdoc) {
        this.iddoc = iddoc;
        this.passdoc = passdoc;
    }

    public DocenteBean(String iddoc, String nomdoc, String apePdoc, String apeMdoc, String correodoc, String teldoc, InputStream fotodoc) {
        this.iddoc = iddoc;
        this.nomdoc = nomdoc;
        this.apePdoc = apePdoc;
        this.apeMdoc = apeMdoc;
        this.correodoc = correodoc;
        this.teldoc = teldoc;
        this.fotodoc = fotodoc;
    }

    public DocenteBean(String iddoc, String passdoc, String nomdoc, String apePdoc, String apeMdoc, String correodoc, String teldoc, InputStream fotodoc) {
        this.iddoc = iddoc;
        this.passdoc = passdoc;
        this.nomdoc = nomdoc;
        this.apePdoc = apePdoc;
        this.apeMdoc = apeMdoc;
        this.correodoc = correodoc;
        this.teldoc = teldoc;
        this.fotodoc = fotodoc;
    }

    public DocenteBean(String iddoc, String passdoc, String nomdoc, String apePdoc, String apeMdoc, String correodoc, String teldoc, InputStream fotodoc, String idadministrador) {
        this.iddoc = iddoc;
        this.passdoc = passdoc;
        this.nomdoc = nomdoc;
        this.apePdoc = apePdoc;
        this.apeMdoc = apeMdoc;
        this.correodoc = correodoc;
        this.teldoc = teldoc;
        this.fotodoc = fotodoc;
        this.idadministrador = idadministrador;
    }

    public String getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(String idadministrador) {
        this.idadministrador = idadministrador;
    }

    public String getIddoc() {
        return iddoc;
    }

    public void setIddoc(String iddoc) {
        this.iddoc = iddoc;
    }

    public String getPassdoc() {
        return passdoc;
    }

    public void setPassdoc(String passdoc) {
        this.passdoc = passdoc;
    }

    public String getNomdoc() {
        return nomdoc;
    }

    public void setNomdoc(String nomdoc) {
        this.nomdoc = nomdoc;
    }

    public String getApePdoc() {
        return apePdoc;
    }

    public void setApePdoc(String apePdoc) {
        this.apePdoc = apePdoc;
    }

    public String getApeMdoc() {
        return apeMdoc;
    }

    public void setApeMdoc(String apeMdoc) {
        this.apeMdoc = apeMdoc;
    }

    public String getCorreodoc() {
        return correodoc;
    }

    public void setCorreodoc(String correodoc) {
        this.correodoc = correodoc;
    }

    public String getTeldoc() {
        return teldoc;
    }

    public void setTeldoc(String teldoc) {
        this.teldoc = teldoc;
    }

    public InputStream getFotodoc() {
        return fotodoc;
    }

    public void setFotodoc(byte[] fotodoc2) {
        this.fotodoc2 = fotodoc2;
    }
}
