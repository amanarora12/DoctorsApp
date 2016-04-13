package com.aman.appointments.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aman.appointments.R;
import com.aman.appointments.model.patientDetails.PatientDetail;
import com.aman.appointments.model.patientList.Patient;
import com.aman.appointments.utils.Utility;

import java.util.ArrayList;

public class PatientDetailsActivity extends AppCompatActivity {
    private ImageView patientPic;
    private TextView patientName;
    private TextView description;
    private TextView doctorInfo;
    private TextView knownDiseases;
    private TextView diagnosis;
    private TextView symptoms;
    private TextView comments;
    private TextView medicine;
    private TextView morning,afternoon,night;
    private int patientId;
    private PatientDetail patientDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        Intent intent=getIntent();
        String id=intent.getStringExtra("patient");
        //patientId=Integer.parseInt(id);
        ArrayList<PatientDetail> patientDetails=new ArrayList<>();
        for(PatientDetail patient:patientDetails){
            if(patient.getId()==id){
                patientDetail=patient;
                break;
            }
        }
        patientDetail=Utility.getPatientDetails(this).get(patientId);

        patientPic= (ImageView) findViewById(R.id.patient_pic);
        patientName= (TextView) findViewById(R.id.patient_name);
        description= (TextView) findViewById(R.id.patient_description);
        doctorInfo= (TextView) findViewById(R.id.doctor_info);
        knownDiseases= (TextView) findViewById(R.id.diseases_info);
        diagnosis= (TextView) findViewById(R.id.diagnosis);
        symptoms= (TextView) findViewById(R.id.symptoms);
        comments= (TextView) findViewById(R.id.comments);
        medicine= (TextView) findViewById(R.id.medicine);
        morning= (TextView) findViewById(R.id.morning);
        afternoon= (TextView) findViewById(R.id.afternoon);
        night= (TextView) findViewById(R.id.night);
        setViews(patientDetail,intent);
    }
    private void setViews(PatientDetail patientDetail,Intent intent){
        String age = intent.getStringExtra("age");
        String gender=intent.getStringExtra("gender");
        String bloodType=intent.getStringExtra("bloodType");
        String desc=gender+", "+age+" years"+", "+bloodType;
        String doctorName="Doctor- "+patientDetail.getDoctor()+", "+patientDetail.getSpecialty();

        patientName.setText(patientDetail.getName());
        description.setText(desc);
        doctorInfo.setText(doctorName);
        diagnosis.setText(patientDetail.getDiagnosis());
        symptoms.setText(patientDetail.getSymptoms());
        comments.setText(patientDetail.getComments());
        medicine.setText(patientDetail.getMedication());

    }
}
