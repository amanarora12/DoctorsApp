package com.aman.appointments.utils;

import android.content.Context;

import com.aman.appointments.model.patientDetails.PatientDetail;
import com.aman.appointments.model.patientDetails.PatientDetailsResponse;
import com.aman.appointments.model.patientList.Patient;
import com.aman.appointments.model.patientList.PatientListResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Aman on 08-04-2016.
 */
public class Utility {
    public static ArrayList<Patient> getPatients(Context context){
        ArrayList<Patient> patients=null;
        Gson gson=new Gson();
        PatientListResponse response=gson.fromJson(getData(context,"data/patient_list_api.json"),PatientListResponse.class);
        if(response!=null){
            patients= (ArrayList<Patient>) response.getPatients();
        }else{
            patients=new ArrayList<>();
        }
        return patients;
    }
    public static ArrayList<PatientDetail> getPatientDetails(Context context){
        ArrayList<PatientDetail> patientDetails=null;
        Gson gson=new Gson();
        PatientDetailsResponse response=gson.fromJson(getData(context,"data/patient_detail_api.json"),PatientDetailsResponse.class);
        if(response!=null){
            patientDetails= (ArrayList<PatientDetail>) response.getPatientDetails();
        }else {
            patientDetails=new ArrayList<>();
        }
        return  patientDetails;
    }
    public static String getData(Context context, String filename) {
        StringBuilder buf = new StringBuilder();
        BufferedReader in;
        try {
            InputStream json = context.getAssets().open(filename);
            in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }

            in.close();
            return buf.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}
