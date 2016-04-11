package com.aman.appointments.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aman.appointments.R;
import com.aman.appointments.model.patientList.Patient;
import com.aman.appointments.ui.activities.MainActivity;
import com.aman.appointments.ui.recyclerview.ItemTouchHelperAdapter;
import com.aman.appointments.widget.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Aman on 10-04-2016.
 */
public class AcceptCardAdapter extends RecyclerView.Adapter<AcceptCardAdapter.AcceptCardViewHolder> implements ItemTouchHelperAdapter {
    private ArrayList<Patient> patientsList=new ArrayList<>();
    private ArrayList<Patient> acceptedList=new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;
    public AcceptCardAdapter(Context context){
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    public void setPatientsList(ArrayList<Patient> patientsList) {
        this.patientsList = patientsList;
        notifyDataSetChanged();
    }

    @Override
    public AcceptCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.accept_card,parent,false);
        AcceptCardViewHolder viewHolder=new AcceptCardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AcceptCardViewHolder holder, final int position) {
        Patient patient=patientsList.get(position);
        holder.nameTxt.setText(patient.getName());
        String patientDetails= "Age "+patient.getAge()+","+patient.getGender()+","+patient.getBloodGroup();
        holder.detailsTxt.setText(patientDetails);
        //holder.timeTxt.setText(patient.getDate());
        Picasso.with(context).load(patient.getProfile())
                .transform(new CircleTransform())
                .placeholder(R.drawable.ic_user)
                .error(R.drawable.ic_user)
                .into(holder.displayPic);
    }

    @Override
    public int getItemCount() {
        return patientsList.size();
    }

    @Override
    public void onItemDismiss(int position,int direction) {
        if(direction== ItemTouchHelper.RIGHT){
            acceptedList.add(patientsList.get(position));
            Toast.makeText(context,"Appointment Added",Toast.LENGTH_SHORT).show();
        }
        patientsList.remove(position);
        notifyItemRemoved(position);
        if(patientsList.size()==0 ){
            Intent intent=new Intent(context, MainActivity.class);
            intent.putParcelableArrayListExtra("array",acceptedList);
            context.startActivity(intent);
        }
    }

    public ArrayList<Patient> getAcceptedList() {
        return acceptedList;
    }

    class AcceptCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView displayPic;
        private TextView nameTxt,detailsTxt,timeTxt,acceptTxt,declineTxt;
        public AcceptCardViewHolder(View itemView) {
            super(itemView);
            nameTxt= (TextView) itemView.findViewById(R.id.txt_name);
            detailsTxt= (TextView) itemView.findViewById(R.id.txt_patient_details);
            timeTxt= (TextView) itemView.findViewById(R.id.txt_time);
            acceptTxt= (TextView) itemView.findViewById(R.id.txt_accept);
            declineTxt= (TextView) itemView.findViewById(R.id.txt_decline);
            displayPic= (ImageView) itemView.findViewById(R.id.display_pic);
            acceptTxt.setOnClickListener(this);
            declineTxt.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.txt_accept){
                onItemDismiss(getAdapterPosition(),ItemTouchHelper.RIGHT);
            }
            else if(v.getId()==R.id.txt_decline){
                onItemDismiss(getAdapterPosition(),ItemTouchHelper.LEFT);
            }
        }
    }
}
