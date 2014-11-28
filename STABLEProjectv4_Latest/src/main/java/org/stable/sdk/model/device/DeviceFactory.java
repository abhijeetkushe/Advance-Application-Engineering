package org.stable.sdk.model.device;

import org.stable.sdk.model.clinic.Clinic;
import org.stable.sdk.model.device.airway.baseexcess.BaseExcessDevice;
import org.stable.sdk.model.device.airway.cpap.CPAPDevice;
import org.stable.sdk.model.device.airway.dopamine.DopamineDevice;
import org.stable.sdk.model.device.airway.ettube.ETTubeDevice;
import org.stable.sdk.model.device.airway.ppv.PPVDevice;
import org.stable.sdk.model.device.airway.trachealincubation.TrachealIncubationDevice;
import org.stable.sdk.model.device.airway.volumebolusamount.VolumeBolusAmountDevice;
import org.stable.sdk.model.device.bloodpressure.capillaryrefilltime.CapillaryRefillTimeDevice;
import org.stable.sdk.model.device.bloodpressure.pulsepressure.PulsePressureDevice;
import org.stable.sdk.model.device.labwork.bloodgas.MetHb.MetHbDevice;
import org.stable.sdk.model.device.labwork.bloodgas.PO2.PO2Device;
import org.stable.sdk.model.device.labwork.cbc.bands.BandsDevice;
import org.stable.sdk.model.device.labwork.cbc.basos.BasosDevice;
import org.stable.sdk.model.device.labwork.cbc.eos.EosDevice;
import org.stable.sdk.model.device.labwork.cbc.hct.HctDevice;
import org.stable.sdk.model.device.labwork.cbc.hgb.HgbDevice;
import org.stable.sdk.model.device.labwork.cbc.lymphs.LymphsDevice;
import org.stable.sdk.model.device.labwork.cbc.metamyelocytes.MetamyelocytesDevice;
import org.stable.sdk.model.device.labwork.cbc.monos.MonosDevice;
import org.stable.sdk.model.device.labwork.cbc.neutrophils.NeutrophilsDevice;
import org.stable.sdk.model.device.labwork.cbc.plts.PLTSDevice;
import org.stable.sdk.model.device.labwork.cbc.wbc.WBCDevice;
import org.stable.sdk.model.device.labwork.clotting.fibrinogen.FibrinogenDevice;
import org.stable.sdk.model.device.labwork.clotting.pt.ProthrombinTimeDevice;
import org.stable.sdk.model.device.labwork.clotting.ptt.PartialThromboplastinTimeDevice;
import org.stable.sdk.model.device.labwork.crp.C_ReactiveProteinDevice;
import org.stable.sdk.model.device.labwork.electrolytes.CO2.CO2Device;
import org.stable.sdk.model.device.labwork.electrolytes.Cl.ClDevice;
import org.stable.sdk.model.device.labwork.electrolytes.K.KDevice;
import org.stable.sdk.model.device.labwork.electrolytes.Na.NaDevice;
import org.stable.sdk.model.device.labwork.electrolytes.ionizedcalcium.IonizedCalciumDevice;
import org.stable.sdk.model.device.labwork.electrolytes.totalcalcium.TotalCalciumDevice;
import org.stable.sdk.model.device.sugar.birthorder.BirthOrderDevice;
import org.stable.sdk.model.device.sugar.gestationalage.GestationalAgeDevice;
import org.stable.sdk.model.device.sugar.glucoselevel.GlucoseLevelDevice;
import org.stable.sdk.model.device.sugar.headcircumference.HeadCircumferenceDevice;
import org.stable.sdk.model.device.sugar.height.HeightDevice;
import org.stable.sdk.model.device.sugar.treatment.bolusconc.BolusConcDevice;
import org.stable.sdk.model.device.sugar.treatment.bolusdose.BolusDoseDevice;
import org.stable.sdk.model.device.sugar.treatment.bolusinfusionrate.BolusInfusionRateDevice;
import org.stable.sdk.model.device.sugar.treatment.dextroseconc.DextroseConcDevice;
import org.stable.sdk.model.device.sugar.treatment.dextrosehourlyinfusionrate.DextroseHourlyInfusionRateDevice;
import org.stable.sdk.model.device.sugar.treatment.dextroseinfusionrate.DextroseInfusionRateDevice;
import org.stable.sdk.model.device.sugar.treatment.ivat.IVAtDevice;
import org.stable.sdk.model.device.sugar.treatment.uvcat.UVCDevice;
import org.stable.sdk.model.device.sugar.treatment.vacat.UACDevice;
import org.stable.sdk.model.device.vitalsigns.bloodgas.BloodGasDevice;
import org.stable.sdk.model.device.vitalsigns.bloodpressure.BloodPressureDevice;
import org.stable.sdk.model.device.vitalsigns.fio2.FiO2Device;
import org.stable.sdk.model.device.vitalsigns.hco3.HCO3Device;
import org.stable.sdk.model.device.vitalsigns.heartrate.HeartRateDevice;
import org.stable.sdk.model.device.vitalsigns.o2saturation.O2SaturationDevice;
import org.stable.sdk.model.device.vitalsigns.pHlevel.pHLevelDevice;
import org.stable.sdk.model.device.vitalsigns.pco2.PCO2Device;
import org.stable.sdk.model.device.vitalsigns.respiratoryrate.RespiratoryRateDevice;
import org.stable.sdk.model.device.vitalsigns.temperature.TemperatureDevice;
import org.stable.sdk.model.device.vitalsigns.weight.WeightDevice;

public class DeviceFactory {

	public static AbstractDevice createDevice(int deviceTypeInt,
			String inventoryNumber, Clinic clinic) {
		System.out.println(deviceTypeInt);
		DeviceType deviceType = DeviceType.values()[deviceTypeInt-1];
		String deviceName = deviceType.name();
		AbstractDevice abstractDevice = null;
		switch (deviceType) {
		case BLOOD_GAS:

			abstractDevice = new BloodGasDevice(deviceName, "--",inventoryNumber);
			break;
		case BLOOD_PRESSURE:
			abstractDevice = new BloodPressureDevice(deviceName, "--",inventoryNumber);
			break;
		case BLOOD_GROUP:
			abstractDevice = new BloodGasDevice(deviceName, "--",
					inventoryNumber);
			break;
		case FiO2:
			abstractDevice = new FiO2Device(deviceName, "--", inventoryNumber);
			break;
		case HCO3:
			abstractDevice = new HCO3Device(deviceName, "--", inventoryNumber);
			break;
		case HEART_RATE:
			abstractDevice = new HeartRateDevice(deviceName, "--",
					inventoryNumber);
			break;
		case O2_SATURATION:
			abstractDevice = new O2SaturationDevice(deviceName, "--",
					inventoryNumber);
			break;
		case PCO2:
			abstractDevice = new PCO2Device(deviceName, "--", inventoryNumber);
			break;
		case PH_LEVEL:
			abstractDevice = new pHLevelDevice(deviceName, "--",
					inventoryNumber);
			break;
		case RESPIRATORY_RATE:
			abstractDevice = new RespiratoryRateDevice(deviceName, "--",
					inventoryNumber);
			break;
		case TEMPERATURE:
			abstractDevice = new TemperatureDevice(deviceName, "--",
					inventoryNumber);
			break;
		case WEIGHT:
			abstractDevice = new WeightDevice(deviceName, "--", inventoryNumber);
			break;
		case BASE_EXCESS:
			abstractDevice = new BaseExcessDevice(deviceName, "--",
					inventoryNumber);
			break;
		case CPAP:
			abstractDevice = new CPAPDevice(deviceName, "--", inventoryNumber);
			break;
		case DOPAMINE:
			abstractDevice = new DopamineDevice(deviceName, "--",
					inventoryNumber);
			break;
		case ET_TUBE:
			abstractDevice = new ETTubeDevice(deviceName, "--", inventoryNumber);
			break;
		case O2_IN_USE:
			abstractDevice = new O2SaturationDevice(deviceName, "--",
					inventoryNumber);
			break;
		case PPV:
			abstractDevice = new PPVDevice(deviceName, "--", inventoryNumber);
			break;
		case TRACHEAL_INCUBATION:
			abstractDevice = new TrachealIncubationDevice(deviceName, "--",
					inventoryNumber);
			break;
		case VOLUME_BOLUS_AMOUNT:
			abstractDevice = new VolumeBolusAmountDevice(deviceName, "--",
					inventoryNumber);
			break;
		case VOLUME_BOLUS_TYPE:
			abstractDevice = new VolumeBolusAmountDevice(deviceName, "--",
					inventoryNumber);
			break;
		case CAPILLARY_REFILL_TIME:
			abstractDevice = new CapillaryRefillTimeDevice(deviceName, "--",
					inventoryNumber);
			break;
		case PULSE_PRESSURE:
			abstractDevice = new PulsePressureDevice(deviceName, "--",
					inventoryNumber);
			break;
		case BIRTH_ORDER:
			abstractDevice = new BirthOrderDevice(deviceName, "--",
					inventoryNumber);
			break;

		case BOLUS_DOSE:
			abstractDevice = new BolusDoseDevice(deviceName, "--",
					inventoryNumber);
			break;
		case BOLUS_CONC:
			abstractDevice = new BolusConcDevice(deviceName, "--",
					inventoryNumber);
			break;
		case BOLUS_INFUSION_RATE:
			abstractDevice = new BolusInfusionRateDevice(deviceName, "--",
					inventoryNumber);
			break;

		case DEXTROSE_CONC:
			abstractDevice = new DextroseConcDevice(deviceName, "--",
					inventoryNumber);
			break;
		case DEXTROSE_INFUSION_RATE:
			abstractDevice = new DextroseInfusionRateDevice(deviceName, "--",
					inventoryNumber);
			break;
		case DEXTROSE_HOURLY_INFUSION_RATE:
			abstractDevice = new DextroseHourlyInfusionRateDevice(deviceName,
					"--", inventoryNumber);
			break;

		case GESTATIONAL_AGE:
			abstractDevice = new GestationalAgeDevice(deviceName, "--",
					inventoryNumber);
			break;
		case GLUCOSE_LEVEL:
			abstractDevice = new GlucoseLevelDevice(deviceName, "--",
					inventoryNumber);
			break;
		case HEAD_CIRCUMFRENCE:
			abstractDevice = new HeadCircumferenceDevice(deviceName, "--",
					inventoryNumber);
			break;
		case HEIGHT:
			abstractDevice = new HeightDevice(deviceName, "--", inventoryNumber);
			break;
		case IV_AT:
			abstractDevice = new IVAtDevice(deviceName, "--", inventoryNumber);
			break;
		case UAC_AT:
			abstractDevice = new UACDevice(deviceName, "--", inventoryNumber);
			break;
		case UVC_AT:
			abstractDevice = new UVCDevice(deviceName, "--", inventoryNumber);
			break;
		case WBC:
			abstractDevice = new WBCDevice(deviceName, "--", inventoryNumber);
			break;
		case Hgb:
			abstractDevice = new HgbDevice(deviceName, "--", inventoryNumber);
			break;
		case Hct:
			abstractDevice = new HctDevice(deviceName, "--", inventoryNumber);
			break;
		case PLTS:
			abstractDevice = new PLTSDevice(deviceName, "--", inventoryNumber);
			break;
		case NEUTROPHILS:
			abstractDevice = new NeutrophilsDevice(deviceName, "--",
					inventoryNumber);
			break;
		case BANDS:
			abstractDevice = new BandsDevice(deviceName, "--", inventoryNumber);
			break;
		case BASOS:
			abstractDevice = new BasosDevice(deviceName, "--", inventoryNumber);
			break;
		case C_Reactive_Protein:
			abstractDevice = new C_ReactiveProteinDevice(deviceName, "--",
					inventoryNumber);
			break;
		case Cl:
			abstractDevice = new ClDevice(deviceName, "--", inventoryNumber);
			break;
		case CO2:
			abstractDevice = new CO2Device(deviceName, "--", inventoryNumber);
			break;
		case EOS:
			abstractDevice = new EosDevice(deviceName, "--", inventoryNumber);
			break;
		case Fibrinogen:
			abstractDevice = new FibrinogenDevice(deviceName, "--",
					inventoryNumber);
			break;
		case Ionized_Calcium:
			abstractDevice = new IonizedCalciumDevice(deviceName, "--",
					inventoryNumber);
			break;
		case K:
			abstractDevice = new KDevice(deviceName, "--", inventoryNumber);
			break;
		case LYMPHS:
			abstractDevice = new LymphsDevice(deviceName, "--", inventoryNumber);
			break;
		case METAMYELOCYTES:
			abstractDevice = new MetamyelocytesDevice(deviceName, "--",
					inventoryNumber);
			break;
		case MetHb:
			abstractDevice = new MetHbDevice(deviceName, "--", inventoryNumber);
			break;
		case MONOS:
			abstractDevice = new MonosDevice(deviceName, "--", inventoryNumber);
			break;
		case Na:
			abstractDevice = new NaDevice(deviceName, "--", inventoryNumber);
			break;
		case Partial_Thromboplastin_Time:
			abstractDevice = new PartialThromboplastinTimeDevice(deviceName,
					"--", inventoryNumber);
			break;
		case Prothrombin_Time:
			abstractDevice = new ProthrombinTimeDevice(deviceName, "--",
					inventoryNumber);
			break;
		case Total_Calcium:
			abstractDevice = new TotalCalciumDevice(deviceName, "--",
					inventoryNumber);
			break;
		case PO2:
			abstractDevice = new PO2Device(deviceName, "--",
					inventoryNumber);
			break;
		default:
			abstractDevice = null;
		}
		if (abstractDevice != null) {
			abstractDevice.setClinic(clinic);
		}
		return abstractDevice;
	}

	public static AbstractDevice createDevice(DeviceType deviceType,
			String inventoryNumber, Clinic clinic) {
		return createDevice(deviceType.getId(), inventoryNumber, clinic);
	}

}
