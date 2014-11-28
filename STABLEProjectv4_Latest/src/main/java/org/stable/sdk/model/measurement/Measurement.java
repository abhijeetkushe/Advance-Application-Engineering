package org.stable.sdk.model.measurement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.stable.sdk.exception.DateFormatException;
import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.device.IDevice;
import org.stable.sdk.model.patient.Patient;
import org.stable.sdk.model.units.Unit;

abstract public class Measurement implements IStableModel {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	private long measurementID;
	private int methodType;
	private int unit;
	private int measurementType;
	private Patient patient;
	private Date dateTime;
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	private String value;
	private IDevice device;

	public Measurement() {
		super();
		dateTime = new Date();
	}

	public Measurement(IMethodType type, Unit unit, String value) {
		this();
		this.methodType = type.getId();
		this.unit = unit.getId();
		this.value = value;
	}

	public Measurement(IMethodType type, Unit unit, String value, Date dateTime) {
		super();
		this.dateTime = dateTime;
		this.methodType = type.getId();
		this.unit = unit.getId();
		this.value = value;
	}

	public Measurement(IMethodType type, Unit unit, String value,
			String sDateTime) {
		this(sDateTime);
		this.methodType = type.getId();
		this.unit = unit.getId();
		this.value = value;
	}

	public Measurement(String sDateTime) {
		super();
		/**
		 * We need a central place for date Formats
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			dateTime = sdf.parse(sDateTime);
		} catch (ParseException e) {

			throw new DateFormatException("Error While Creating Measurement");
			// TODO Auto-generated catch block
		}
	}

	abstract public IMeasurementType defineMeasurementType();

	/**
	 * @return the measurementID
	 */
	public long getMeasurementID() {
		return measurementID;
	}

	/**
	 * @param measurementID
	 *            the measurementID to set
	 */
	public void setMeasurementID(long measurementID) {
		this.measurementID = measurementID;
	}

	/**
	 * @return the methodType
	 */
	public int getMethodType() {
		return methodType;
	}

	/**
	 * @param methodType
	 *            the methodType to set
	 */
	public void setMethodType(int methodType) {
		this.methodType = methodType;
	}

	/**
	 * @return the methodType
	 */
	public IMethodType getMethodTypeEnum() {
		return null;
	}

	/**
	 * @param methodType
	 *            the methodType to set
	 */
	public void setMethodType(IMethodType methodType) {
		setMethodType(methodType.getId());
	}

	/**
	 * @return the unit
	 */
	public int getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(int unit) {
		this.unit = unit;
	}

	/**
	 * @return the unit
	 */
	public Unit getUnitEnum() {
		return null;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnitEnum(Unit unit) {
		setUnit(unit.getId());
	}

	/**
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime
	 *            the dateTime to set
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the measurementType
	 */
	public int getMeasurementType() {
		return defineMeasurementType().getId();
	}

	/**
	 * @param measurementType
	 *            the measurementType to set
	 */
	public void setMeasurementType(int measurementType) {
		this.measurementType = measurementType;
	}

	/**
	 * @return the measurementType
	 */
	public IMeasurementType getMeasurementTypeEnum() {
		return null;
	}

	/**
	 * @param measurementType
	 *            the measurementType to set
	 */
	public void setMeasurementTypeEnum(IMeasurementType measurementType) {
		setMeasurementType(measurementType.getId());
	}

	/**
	 * @return the device
	 */
	public IDevice getDevice() {
		return device;
	}

	/**
	 * @param device
	 *            the device to set
	 */
	public void setDevice(IDevice device) {
		this.device = device;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result
				+ (int) (measurementID ^ (measurementID >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Measurement)) {
			return false;
		}
		Measurement other = (Measurement) obj;
		if (dateTime == null) {
			if (other.dateTime != null) {
				return false;
			}
		} else if (!dateTime.equals(other.dateTime)) {
			return false;
		}
		if (measurementID != other.measurementID) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value != null ? value : "";
	}

}
