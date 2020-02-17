package com.agyal.hospital.ui.Photos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agyal.hospital.Adapter.PhotoAdapter;
import com.agyal.hospital.Adapter.ServiceAdapter;
import com.agyal.hospital.MainActivity;
import com.agyal.hospital.Model.PhotoModel;
import com.agyal.hospital.Model.ServiceModel;
import com.agyal.hospital.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotosFragment extends Fragment {


    ImageView ic_menu;
    TextView photos_tv;

    RecyclerView recyclerView;
    PhotoAdapter photoAdapter;
    ArrayList<PhotoModel> photoModels;
    GridLayoutManager gridLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_photos, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ic_menu=view.findViewById(R.id.ic_menu);
        ic_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).menu();
            }
        });

        photos_tv=view.findViewById(R.id.photos_tv);
        photos_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity) getActivity()).onBackPressed();

            }
        });

        photoModels = new ArrayList<>();

        photoModels.add(new PhotoModel(R.drawable.cat1));
        photoModels.add(new PhotoModel(R.drawable.cat11));
        photoModels.add(new PhotoModel(R.drawable.cat2));
        photoModels.add(new PhotoModel(R.drawable.cat22));
        photoModels.add(new PhotoModel(R.drawable.cat3));
        photoModels.add(new PhotoModel(R.drawable.cat33));
        photoModels.add(new PhotoModel(R.drawable.cat4));
        photoModels.add(new PhotoModel(R.drawable.cat44));
        photoModels.add(new PhotoModel(R.drawable.cat5));
        photoModels.add(new PhotoModel(R.drawable.cat55));
        photoModels.add(new PhotoModel(R.drawable.cat6));
        photoModels.add(new PhotoModel(R.drawable.cat66));
        photoModels.add(new PhotoModel(R.drawable.cat7));
        photoModels.add(new PhotoModel(R.drawable.cat77));
        photoModels.add(new PhotoModel(R.drawable.cat8));
        photoModels.add(new PhotoModel(R.drawable.cat88));
        photoModels.add(new PhotoModel(R.drawable.cat9));
        photoModels.add(new PhotoModel(R.drawable.cat99));
        photoModels.add(new PhotoModel(R.drawable.cat10));
        photoModels.add(new PhotoModel(R.drawable.cat1010));

        recyclerView =view.findViewById(R.id.RV2);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gridLayoutManager = new GridLayoutManager(getContext(),4);
        }
        else{
            gridLayoutManager = new GridLayoutManager(getContext(), 2);
        }        recyclerView.setLayoutManager(gridLayoutManager);

        photoAdapter = new PhotoAdapter(photoModels, getContext(), new PhotoAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {
               int current = photoModels.get(position).getPhoto();

                Log.d("TTT",Integer.toString(current));

                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.img_dialog);
                ImageView imageView = dialog.findViewById(R.id.dialog);
                Picasso.with(getContext()).load(current).into(imageView);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        recyclerView.setAdapter(photoAdapter);
        photoAdapter.notifyDataSetChanged();
    }
}