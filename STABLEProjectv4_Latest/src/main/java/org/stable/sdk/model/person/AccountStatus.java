/**
 * 
 */
package org.stable.sdk.model.person;


/**
 * @author amuthanarulraj
 * 
 */
public enum AccountStatus {
	ACTIVE(1) {
		@Override
		public String toString() {
			return "Active";
		}
	},
	DISABLED(2) {
		@Override
		public String toString() {
			return "Disabled";
		}
	};

	private int id;

	private AccountStatus(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
