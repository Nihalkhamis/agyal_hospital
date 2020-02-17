package com.agyal.hospital.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agyal.hospital.Model.PhotoModel;
import com.agyal.hospital.Model.ServiceModel;
import com.agyal.hospital.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder> {

    ArrayList<PhotoModel> photoModels;
    public Context context;
    private OnItemClick mOnItemClick;


    public PhotoAdapter(ArrayList<PhotoModel> photoModels, Context context, OnItemClick mOnItemClick) {
        this.photoModels = photoModels;
        this.context = context;
        this.mOnItemClick = mOnItemClick;
    }

    @NonNull
    @Override
    public PhotoAdapter.PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item,parent,false);
        PhotoAdapter.PhotoHolder photoHolder = new PhotoAdapter.PhotoHolder(view);
        return photoHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.PhotoHolder holder, int position) {
        PhotoModel photoModel = photoModels.get(position);
        Picasso.with(context).load(photoModel.getPhoto()).into(holder.photo);

    }

    @Override
    public int getItemCount() {
        return photoModels.size();
    }

    public class PhotoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView photo;

        public PhotoHolder(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.photo);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mOnItemClick.setOnItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClick {
        void setOnItemClick(int position);
    }
}
