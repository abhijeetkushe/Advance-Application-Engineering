/**
 * 
 */
package org.stable.sdk.model.bedlocation;


/**
 * @author amuthanarulraj
 * 
 */
public enum BedLocationType {

	NICU(1) {
		@Override
		public String toString() {
			return "NICU";
		}
	},
	NORMAL_CARE(2) {
		@Override
		public String toString() {
			return "Normal Care";
		}
	};

	private int id;

	private BedLocationType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
