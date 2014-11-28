/**
 * 
 */
package org.stable.sdk.model.patient;

/**
 * @author amuthanarulraj
 * 
 */
public enum PatientStatus {

	BORN(1) {
		@Override
		public String toString() {
			return "Born";
		}
	},
	ADMITTED(2) {
		@Override
		public String toString() {
			return "Admitted";
		}
	},
	DISCHARGED(3) {
		@Override
		public String toString() {
			return "Discharged";
		}
	};

	private int id;

	private PatientStatus(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
