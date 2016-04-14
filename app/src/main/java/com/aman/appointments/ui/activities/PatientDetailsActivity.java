package com.aman.appointments.ui.activities;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.aman.appointments.R;
import com.aman.appointments.model.patientDetails.PatientDetail;
import com.aman.appointments.model.patientList.Patient;
import com.aman.appointments.utils.Utility;
import com.aman.appointments.utils.ViewUtils;
import com.aman.appointments.widget.CircleTransform;
import com.aman.appointments.widget.ElasticDragDismissFrameLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

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
    private PatientDetail patientDetail;
    private NestedScrollView diagnosisDetails;
    private ViewGroup patientDetailsView;
    private ElasticDragDismissFrameLayout frame;
    private ElasticDragDismissFrameLayout.SystemChromeFader chromeFader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        Intent intent=getIntent();
        String id=intent.getStringExtra("patient");
        ArrayList<PatientDetail> patientDetails=Utility.getPatientDetails(this);
        for(PatientDetail patient:patientDetails){
            if(patient.getId().equals(id)){
                patientDetail=patient;
                break;
            }
        }
        chromeFader=new ElasticDragDismissFrameLayout.SystemChromeFader(this);
        frame= (ElasticDragDismissFrameLayout) findViewById(R.id.frame);
        patientDetailsView= (ViewGroup) findViewById(R.id.patient_details);
        diagnosisDetails= (NestedScrollView) findViewById(R.id.diagnosis_details);
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
        frame.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        frame.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                ((ViewGroup.MarginLayoutParams) frame.getLayoutParams()).rightMargin
                        += insets.getSystemWindowInsetRight(); // landscape
                ((ViewGroup.MarginLayoutParams) patientPic.getLayoutParams()).topMargin
                        += insets.getSystemWindowInsetTop();
                ViewUtils.setPaddingTop(patientDetailsView, insets.getSystemWindowInsetTop());
                ViewUtils.setPaddingBottom(diagnosisDetails, insets.getSystemWindowInsetBottom());
                // clear this listener so insets aren't re-applied
                frame.setOnApplyWindowInsetsListener(null);
                return insets;
            }
        });
    }
    private void setViews(PatientDetail patientDetail,Intent intent){
        String age = intent.getStringExtra("age");
        String gender=intent.getStringExtra("gender");
        String bloodType=intent.getStringExtra("bloodType");
        String desc=gender+", "+age+" years"+", "+bloodType;
        String doctorName="Doctor- "+patientDetail.getDoctor()+", "+patientDetail.getSpecialty();
        String diseases="Known diseases- ";
        String profile=intent.getStringExtra("profile");
        ArrayList<String> disesaseList= (ArrayList<String>) patientDetail.getKnownDeseases();
        for(String d:disesaseList){
            diseases+=d+", ";
        }
        String[] dose=patientDetail.getToBeTaken().split("-");
        String morningDoze=dose[0]+" tablet";
        String afternoonDoze=dose[1]+" tablet";
        String nightDoze=dose[2]+" tablet";
        patientName.setText(patientDetail.getName());
        description.setText(desc);
        doctorInfo.setText(doctorName);
        knownDiseases.setText(diseases);
        diagnosis.setText(patientDetail.getDiagnosis());
        symptoms.setText(patientDetail.getSymptoms());
        comments.setText(patientDetail.getComments());
        medicine.setText(patientDetail.getMedication());
        morning.setText(morningDoze);
        afternoon.setText(afternoonDoze);
        night.setText(nightDoze);
        Picasso.with(this).load(profile)
                .transform(new CircleTransform())
                .placeholder(R.drawable.ic_user)
                .error(R.drawable.ic_user)
                .into(patientPic);

        patientDetailsView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                patientDetailsView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int height=patientDetailsView.getHeight();
                ViewUtils.setPaddingTop(diagnosisDetails,height);
            }
        });

        diagnosisDetails.setVisibility(View.VISIBLE);


    }

    @Override
    protected void onResume() {
        frame.addListener(chromeFader);
        super.onResume();
    }

    @Override
    protected void onPause() {
        frame.removeListener(chromeFader);
        super.onPause();
    }
}
