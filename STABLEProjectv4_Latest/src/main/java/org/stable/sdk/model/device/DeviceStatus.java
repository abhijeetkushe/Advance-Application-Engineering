package org.stable.sdk.model.device;


public enum DeviceStatus {

	AVAILIABLE(1) {
		@Override
		public String toString() {
			return "Available";
		}
	},
	IN_USE(2) {
		@Override
		public String toString() {
			return "In-Use";
		}
	},
	MAINTENANCE(3) {
		@Override
		public String toString() {
			return "Maintenance";
		}
	};

	private int id;

	private DeviceStatus(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
