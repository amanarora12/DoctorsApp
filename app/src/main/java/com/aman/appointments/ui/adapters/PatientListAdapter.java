package com.aman.appointments.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aman.appointments.R;
import com.aman.appointments.model.patientList.Patient;
import com.aman.appointments.ui.activities.MainActivity;
import com.aman.appointments.ui.activities.PatientDetailsActivity;
import com.aman.appointments.widget.CircleTransform;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Aman on 09-04-2016.
 */
public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.PatientViewHolder> {
    private ArrayList<Patient> patientsList=new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;
    public PatientListAdapter(Context context){
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    public void setPatientsList(ArrayList<Patient> patientsList) {
        this.patientsList = patientsList;
        notifyDataSetChanged();
    }

    @Override
    public PatientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.patient_list_item,parent,false);
        PatientViewHolder viewHolder=new PatientViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PatientViewHolder holder, int position) {
        Patient patient=patientsList.get(position);
        //holder.dateTxt.setText(patient.getDate());
        holder.nameTxt.setText(patient.getName());
        String patientDetails= "Age "+patient.getAge()+","+patient.getGender()+","+patient.getBloodGroup();
        holder.detailsTxt.setText(patientDetails);
        holder.phoneTxt.setText(patient.getMobileNo());
        holder.addressTxt.setText(patient.getAddress());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS");
        try {
            Date date =dateFormat.parse(patient.getDate());
            // Log.e("DAte",date+" " + new SimpleDateFormat("MMMM dd, HH:mm").format(date) );
            holder.dateTxt.setText(new SimpleDateFormat("MMMM dd, HH:mm").format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    class PatientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView displayPic;
        private TextView nameTxt,dateTxt,detailsTxt,phoneTxt,addressTxt;

        public PatientViewHolder(View itemView) {
            super(itemView);
            displayPic= (ImageView) itemView.findViewById(R.id.display_pic);
            nameTxt= (TextView) itemView.findViewById(R.id.txt_name);
            dateTxt= (TextView) itemView.findViewById(R.id.txt_date);
            detailsTxt= (TextView) itemView.findViewById(R.id.txt_patient_details);
            phoneTxt= (TextView) itemView.findViewById(R.id.txt_phone);
            addressTxt= (TextView) itemView.findViewById(R.id.txt_address);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, PatientDetailsActivity.class);
            intent.putExtra("patient",patientsList.get(getAdapterPosition()).getId());
            intent.putExtra("age",patientsList.get(getAdapterPosition()).getAge());
            intent.putExtra("gender",patientsList.get(getAdapterPosition()).getGender());
            intent.putExtra("bloodType",patientsList.get(getAdapterPosition()).getBloodGroup());
            context.startActivity(intent);
        }
    }
}
