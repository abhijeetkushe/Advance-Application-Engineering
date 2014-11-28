/**
 * 
 */
package org.stable.sdk.model.patient;

/**
 * @author amuthanarulraj
 * 
 */
public enum PBLStatus {

	ACTIVE(1) {
		@Override
		public String toString() {
			return "Active";
		}
	},
	DISCHARGED(2) {
		@Override
		public String toString() {
			return "Discharged";
		}
	};

	private int id;

	private PBLStatus(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
