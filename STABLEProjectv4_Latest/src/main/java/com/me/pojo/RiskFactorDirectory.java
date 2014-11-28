/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Venketesh
 */
public class RiskFactorDirectory  implements Serializable {

    private List<RiskFactor> riskList = new ArrayList<RiskFactor>();

    public List<RiskFactor> getRiskList() {
        return riskList;
    }

    public void setRiskList(List<RiskFactor> riskList) {
        this.riskList = riskList;
    }

    

}
