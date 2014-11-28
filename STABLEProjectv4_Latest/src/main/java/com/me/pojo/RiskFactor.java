/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.pojo;

import java.io.Serializable;

/**
 *
 * @author Venketesh
 */
public class RiskFactor implements Serializable {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    
}
