package com.me.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LabTestDirectory implements Serializable {

	  private List<LabTests> cbcTestList=new ArrayList<LabTests>();
	  private List<LabTests> crpTestList=new ArrayList<LabTests>();
	  private List<LabTests> bgTestList=new ArrayList<LabTests>();
	  private List<LabTests> elecTestList=new ArrayList<LabTests>();
	  private List<LabTests> csTestList=new ArrayList<LabTests>();

	public List<LabTests> getCbcTestList() {
		return cbcTestList;
	}

	public void setCbcTestList(List<LabTests> cbcTestList) {
		this.cbcTestList = cbcTestList;
	}

	public List<LabTests> getCrpTestList() {
		return crpTestList;
	}

	public void setCrpTestList(List<LabTests> crpTestList) {
		this.crpTestList = crpTestList;
	}

	public List<LabTests> getBgTestList() {
		return bgTestList;
	}

	public void setBgTestList(List<LabTests> bgTestList) {
		this.bgTestList = bgTestList;
	}

	public List<LabTests> getElecTestList() {
		return elecTestList;
	}

	public void setElecTestList(List<LabTests> elecTestList) {
		this.elecTestList = elecTestList;
	}

	public List<LabTests> getCsTestList() {
		return csTestList;
	}

	public void setCsTestList(List<LabTests> csTestList) {
		this.csTestList = csTestList;
	}

	  
}
