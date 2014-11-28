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
public class RiskFactors implements Serializable{
	

    private String RiskFactorName;
    private String Type;

    public String getRiskFactorName() {
        return RiskFactorName;
    }

    public void setRiskFactorName(String RiskFactorName) {
        this.RiskFactorName = RiskFactorName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    

}
