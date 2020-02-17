package com.agyal.hospital.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agyal.hospital.Model.ServiceModel;
import com.agyal.hospital.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceHolder> {

    ArrayList<ServiceModel> serviceModels;
    public Context context;

    public ServiceAdapter(ArrayList<ServiceModel> serviceModels, Context context) {
        this.serviceModels = serviceModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ServiceAdapter.ServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item,parent,false);
        ServiceHolder serviceHolder = new ServiceHolder(view);
        return serviceHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.ServiceHolder holder, int position) {
             ServiceModel serviceModel = serviceModels.get(position);
             holder.emergency_tv.setText(serviceModel.getTitle());
             Picasso.with(context).load(serviceModel.getIcon()).into(holder.emergency24);

    }

    @Override
    public int getItemCount() {
        return serviceModels.size();
    }


    public class ServiceHolder extends RecyclerView.ViewHolder{

        ImageView emergency24;
        TextView emergency_tv;

        public ServiceHolder(@NonNull View itemView) {
            super(itemView);

            emergency24 = itemView.findViewById(R.id.emergency24);
            emergency_tv = itemView.findViewById(R.id.emergency_tv);

        }
    }
}
