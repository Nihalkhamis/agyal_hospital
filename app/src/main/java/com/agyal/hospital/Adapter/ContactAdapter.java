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

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    ArrayList<ServiceModel> serviceModels;
    public Context context;

    public ContactAdapter(ArrayList<ServiceModel> serviceModels, Context context) {
        this.serviceModels = serviceModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactAdapter.ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item,parent,false);
        ContactAdapter.ContactHolder contactHolder = new ContactAdapter.ContactHolder(view);
        return contactHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactHolder holder, int position) {

        ServiceModel serviceModel = serviceModels.get(position);
        holder.contact.setText(serviceModel.getTitle());
        Picasso.with(context).load(serviceModel.getIcon()).into(holder.loc);
    }

    @Override
    public int getItemCount() {
        return serviceModels.size();
    }

    public class ContactHolder extends RecyclerView.ViewHolder{

        ImageView loc;
        TextView contact;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);

            loc = itemView.findViewById(R.id.loc);
            contact = itemView.findViewById(R.id.contact);

        }
    }
}
