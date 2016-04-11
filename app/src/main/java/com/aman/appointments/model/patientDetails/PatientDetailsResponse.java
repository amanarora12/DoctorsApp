package com.aman.appointments.model.patientDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aman on 08-04-2016.
 */
public class PatientDetailsResponse {

    private List<PatientDetail> patientDetails = new ArrayList<PatientDetail>();

    /**
     *
     * @return
     * The patientDetails
     */
    public List<PatientDetail> getPatientDetails() {
        return patientDetails;
    }

    /**
     *
     * @param patientDetails
     * The patientDetails
     */
    public void setPatientDetails(List<PatientDetail> patientDetails) {
        this.patientDetails = patientDetails;
    }

}
