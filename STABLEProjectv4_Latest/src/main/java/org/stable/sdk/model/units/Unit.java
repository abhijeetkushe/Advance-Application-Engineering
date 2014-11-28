package org.stable.sdk.model.units;


public abstract class Unit implements IUnit {

	
	
//	private String unitName;
//	private String unitID;
	
	public Unit() {
		// TODO Auto-generated constructor stub
	}
//	
//	public Unit(String unitName,String unitID){
//		this.unitName= unitName;
//		this.unitID = unitID;
//	}
	
	final public  String getUnitName() {
		return createUnitName();
	}
	
	
	final public int getId(){
		return createID();
	}
	

	
	
}
