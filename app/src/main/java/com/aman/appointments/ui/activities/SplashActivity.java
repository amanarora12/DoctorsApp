package com.aman.appointments.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.aman.appointments.R;
import com.aman.appointments.model.patientList.Patient;
import com.aman.appointments.ui.adapters.AcceptCardAdapter;
import com.aman.appointments.ui.recyclerview.ItemTouchCallback;
import com.aman.appointments.utils.Utility;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AcceptCardAdapter adapter;
    private ItemTouchHelper.Callback callback;
    private ItemTouchHelper helper;
    private ArrayList<Patient> acceptedList;
    ArrayList<Patient> patients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view_splash);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new AcceptCardAdapter(this);
        recyclerView.setAdapter(adapter);
        getData();
        callback=new ItemTouchCallback(adapter);
        helper=new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(SplashActivity.this,MainActivity.class));
                Log.e("Count",adapter.getAcceptedList().size()+"");
            }
        });
    }
    private void getData(){
        patients= Utility.getPatients(this);
        adapter.setPatientsList(patients);
    }
}
