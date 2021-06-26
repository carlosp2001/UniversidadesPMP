/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahccpmp.dao;

/**
 *
 * @author carlospineda
 */
public class Universidad {

    /**
     * @return the _ID
     */
    public double getID() {
        return _ID;
    }

    /**
     * @param _ID the _ID to set
     */
    public void setID(double _ID) {
        this._ID = _ID;
    }

    /**
     * @return the _SIGLAS
     */
    public String getSIGLAS() {
        return _SIGLAS;
    }

    /**
     * @param _SIGLAS the _SIGLAS to set
     */
    public void setSIGLAS(String _SIGLAS) {
        this._SIGLAS = _SIGLAS;
    }

    /**
     * @return the _RECTOR
     */
    public String getRECTOR() {
        return _RECTOR;
    }

    /**
     * @param _RECTOR the _RECTOR to set
     */
    public void setRECTOR(String _RECTOR) {
        this._RECTOR = _RECTOR;
    }
    private double _ID;
    private String _SIGLAS;
    private String _RECTOR;
    
}
