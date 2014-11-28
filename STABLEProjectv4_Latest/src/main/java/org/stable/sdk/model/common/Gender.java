/**
 * 
 */
package org.stable.sdk.model.common;

/**
 * @author Amuthan Arulraj
 * 
 */
public enum Gender {

	MALE(1) {
		@Override
		public String toString() {
			return "Male";
		}
	},
	FEMALE(2) {
		@Override
		public String toString() {
			return "Female";
		}
	},
	OTHER(3) {
		@Override
		public String toString() {
			return "Other";
		}
	};

	private int id;

	Gender(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
