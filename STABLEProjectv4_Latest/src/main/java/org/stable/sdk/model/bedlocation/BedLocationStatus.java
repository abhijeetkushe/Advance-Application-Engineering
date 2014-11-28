package org.stable.sdk.model.bedlocation;

public enum BedLocationStatus {

	AVAILIABLE(1) {
		@Override
		public String toString() {
			return "Available";
		}
	},
	OCCUPIED(2) {
		@Override
		public String toString() {
			return "Occupied";
		}
	},
	MAINTENANCE(3) {
		@Override
		public String toString() {
			return "Maintenance";
		}
	};

	private int id;

	private BedLocationStatus(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
