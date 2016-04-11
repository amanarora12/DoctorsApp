package com.aman.appointments.model.patientDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aman on 08-04-2016.
 */
public class PatientDetail {

    private String name;
    private String id;
    private String diagnosis;
    private String symptoms;
    private String medication;
    private String toBeTaken;
    private String comments;
    private List<String> knownDeseases = new ArrayList<String>();
    private String doctor;
    private String specialty;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     *
     * @param diagnosis
     * The diagnosis
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     *
     * @return
     * The symptoms
     */
    public String getSymptoms() {
        return symptoms;
    }

    /**
     *
     * @param symptoms
     * The symptoms
     */
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    /**
     *
     * @return
     * The medication
     */
    public String getMedication() {
        return medication;
    }

    /**
     *
     * @param medication
     * The medication
     */
    public void setMedication(String medication) {
        this.medication = medication;
    }

    /**
     *
     * @return
     * The toBeTaken
     */
    public String getToBeTaken() {
        return toBeTaken;
    }

    /**
     *
     * @param toBeTaken
     * The toBeTaken
     */
    public void setToBeTaken(String toBeTaken) {
        this.toBeTaken = toBeTaken;
    }

    /**
     *
     * @return
     * The comments
     */
    public String getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     * The comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     *
     * @return
     * The knownDeseases
     */
    public List<String> getKnownDeseases() {
        return knownDeseases;
    }

    /**
     *
     * @param knownDeseases
     * The knownDeseases
     */
    public void setKnownDeseases(List<String> knownDeseases) {
        this.knownDeseases = knownDeseases;
    }

    /**
     *
     * @return
     * The doctor
     */
    public String getDoctor() {
        return doctor;
    }

    /**
     *
     * @param doctor
     * The doctor
     */
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    /**
     *
     * @return
     * The specialty
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     *
     * @param specialty
     * The specialty
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}