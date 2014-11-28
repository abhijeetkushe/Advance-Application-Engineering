package org.stable.sdk.model.patient;

public enum PatientMeasurementType {

	BLOOD_PRESSURE(1) {
		@Override
		public String toString() {
			return "Blood Pressure";
		}
	},
	HEART_RATE(2) {
		@Override
		public String toString() {
			return "Heart Rate";
		}
	};

	private int id;

	private PatientMeasurementType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
