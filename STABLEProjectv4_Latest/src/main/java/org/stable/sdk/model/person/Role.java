package org.stable.sdk.model.person;


public enum Role {

	DOCTOR(1) {
		@Override
		public String toString() {
			return "Doctor";
		}
	},
	NEONATOLOGIST(2) {
		@Override
		public String toString() {
			return "Neonatologist";
		}
	},
	NURSEPRACTITIONER(3) {
		@Override
		public String toString() {
			return "Nurse Practitioner";
		}
	},
	PEDIATRICIAN(4) {
		@Override
		public String toString() {
			return "Pediatrician";
		}
	},
	RESIDENT(5) {
		@Override
		public String toString() {
			return "Resident";
		}
	},
	TECHNICIAN(6) {
		@Override
		public String toString() {
			return "Technician";
		}
	};

	private int id;

	private Role(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
