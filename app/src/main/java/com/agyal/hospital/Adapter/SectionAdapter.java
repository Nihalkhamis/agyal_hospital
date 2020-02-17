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
import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionHolder>{

    ArrayList<ServiceModel> serviceModels;
    public Context context;

    public SectionAdapter(ArrayList<ServiceModel> serviceModels, Context context) {
        this.serviceModels = serviceModels;
        this.context = context;
    }

    @NonNull
    @Override
    public SectionAdapter.SectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_item,parent,false);
        SectionAdapter.SectionHolder sectionHolder = new SectionAdapter.SectionHolder(view);
        return sectionHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SectionHolder holder, int position) {
        ServiceModel serviceModel = serviceModels.get(position);
        holder.title_tv.setText(serviceModel.getTitle());
        Picasso.with(context).load(serviceModel.getIcon()).into(holder.icon);
    }


    @Override
    public int getItemCount() {
        return serviceModels.size();
    }

    public class SectionHolder extends RecyclerView.ViewHolder{

        ImageView icon;
        TextView title_tv;

        public SectionHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            title_tv = itemView.findViewById(R.id.title_tv);

        }
    }
}
