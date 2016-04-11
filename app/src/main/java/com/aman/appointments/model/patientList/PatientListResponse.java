package com.aman.appointments.model.patientList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aman on 08-04-2016.
 */
public class PatientListResponse {

    private List<Patient> patients = new ArrayList<Patient>();

    /**
     *
     * @return
     * The patients
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     *
     * @param patients
     * The patients
     */
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

}

