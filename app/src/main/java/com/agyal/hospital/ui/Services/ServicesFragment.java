package com.agyal.hospital.ui.Services;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agyal.hospital.Adapter.ServiceAdapter;
import com.agyal.hospital.MainActivity;
import com.agyal.hospital.Model.ServiceModel;
import com.agyal.hospital.R;

import java.util.ArrayList;

public class ServicesFragment extends Fragment {

    ImageView ic_menu;
    TextView services_tv;

    RecyclerView recyclerView;
    ServiceAdapter serviceAdapter;
    ArrayList<ServiceModel> serviceModels;
    GridLayoutManager gridLayoutManager;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_services, container, false);


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

        services_tv=view.findViewById(R.id.services_tv);
        services_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity) getActivity()).onBackPressed();

            }
        });


        serviceModels = new ArrayList<>();

        serviceModels.add(new ServiceModel("طوارئ ٢٤ ساعة",R.drawable.emergency24));
        serviceModels.add(new ServiceModel("عيادات خارجية",R.drawable.clinics));
        serviceModels.add(new ServiceModel("جراحات عامة",R.drawable.surgery));
        serviceModels.add(new ServiceModel("تحاليل طبية",R.drawable.lab));
        serviceModels.add(new ServiceModel("اشعة",R.drawable.radio));
        serviceModels.add(new ServiceModel("عناية مركزة",R.drawable.icu));
        serviceModels.add(new ServiceModel("حضان اطفال",R.drawable.maternity));

        recyclerView =view.findViewById(R.id.RV);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gridLayoutManager = new GridLayoutManager(getContext(),4);
        }
        else{
            gridLayoutManager = new GridLayoutManager(getContext(), 2);
        }
        recyclerView.setLayoutManager(gridLayoutManager);

        serviceAdapter = new ServiceAdapter(serviceModels,getContext());
         recyclerView.setAdapter(serviceAdapter);
         serviceAdapter.notifyDataSetChanged();

    }
}