package org.stable.sdk.model.measurement;

import java.util.Date;

public class TestMeasurement {

	public static void main(String[] args) {
		
		Date d = new Date();
		System.out.println(d.getTime());
		
		MeasurementType mt = MeasurementType.BLOOD_GAS;
		System.out.println("this is mt " + mt.getId());
		
		MeasurementType mt1 = MeasurementType.BLOOD_GROUP;
		System.out.println("this is mt " + mt1.getId());
		
		MeasurementType mt2 = MeasurementType.FiO2;
		System.out.println("this is mt " + mt2.getId());
		
		MeasurementType mt3 = MeasurementType.HEART_RATE;
		System.out.println("this is mt " + mt3.getId());

		Measurement measurement;
		
		measurement = MeasurementFactory.getMeasurement(0, 0, "22");
		
		System.out.println(measurement.defineMeasurementType());
		System.out.println(measurement.hashCode());
		System.out.println(measurement.getUnit());

		measurement = MeasurementFactory.getMeasurement(0, 0, "22");
		System.out.println(measurement.defineMeasurementType());
		System.out.println(measurement.hashCode());
		System.out.println(measurement.getUnit());
		
		
		
	}
}
