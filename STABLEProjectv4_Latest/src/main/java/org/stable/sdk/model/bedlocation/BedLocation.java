package org.stable.sdk.model.bedlocation;

import java.util.HashMap;
import java.util.Map;

import org.stable.sdk.model.common.IStableModel;
import org.stable.sdk.model.device.IDevice;

public class BedLocation implements IStableModel {

	/**
	 * Please change serialVersionUID when changing the class
	 */
	private static final long serialVersionUID = 1L;
	private int bedLocationID;
	private String location;
	private int type;
	private int bedLocStatus;
	private Map<String, IDevice> deviceList;

	public BedLocation() {
		deviceList = new HashMap<String, IDevice>();
		bedLocStatus = BedLocationStatus.AVAILIABLE.getId();
	}

	/**
	 * @return the bedLocationID
	 */
	public int getBedLocationID() {
		return bedLocationID;
	}

	/**
	 * @param bedLocationID
	 *            the bedLocationID to set
	 */
	public void setBedLocationID(int bedLocationID) {
		this.bedLocationID = bedLocationID;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the BedLocationType
	 */
	public BedLocationType getTypeEnum() {
		for (BedLocationType blt : BedLocationType.values()) {
			if (getType() == blt.getId()) {
				return blt;
			}
		}
		return null;
	}

	/**
	 * @param bedLocationType
	 *            the bedLocationType to set
	 */
	public void setTypeEnum(BedLocationType bedLocationType) {
		setType(bedLocationType.getId());
	}

	/**
	 * @return the bedLocStatus
	 */
	public int getBedLocStatus() {
		return bedLocStatus;
	}

	/**
	 * @param bedLocStatus
	 *            the bedLocStatus to set
	 */
	public void setBedLocStatus(int bedLocStatus) {
		this.bedLocStatus = bedLocStatus;
	}

	/**
	 * @return the BedLocationStatus
	 */
	public BedLocationStatus getBedLocStatusEnum() {
		return null;
	}

	/**
	 * @param bedLocationStatus
	 *            the bedLocationStatus to set
	 */
	public void setBedLocStatusEnum(BedLocationStatus bedLocationStatus) {
		setBedLocStatus(bedLocationStatus.getId());
	}

	/**
	 * @return the deviceList
	 */
	public Map<String, IDevice> getDeviceList() {
		return deviceList;
	}

	/**
	 * @param deviceList
	 *            the deviceList to set
	 */
	public void setDeviceList(Map<String, IDevice> deviceList) {
		this.deviceList = deviceList;
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
				+ (int) (bedLocationID ^ (bedLocationID >>> 32));
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
		if (!(obj instanceof BedLocation)) {
			return false;
		}
		BedLocation other = (BedLocation) obj;
		if (bedLocationID != other.bedLocationID) {
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
		return location != null ? location : "";
	}

}
