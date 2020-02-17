package com.agyal.hospital.ui.Sections;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agyal.hospital.Adapter.SectionAdapter;
import com.agyal.hospital.Adapter.ServiceAdapter;
import com.agyal.hospital.MainActivity;
import com.agyal.hospital.Model.ServiceModel;
import com.agyal.hospital.R;

import java.util.ArrayList;

public class SectionsFragment extends Fragment {

      ImageView ic_menu;
      TextView sections_tv;

    RecyclerView recyclerView;
    SectionAdapter sectionAdapter;
    ArrayList<ServiceModel> serviceModels;
    GridLayoutManager gridLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sections, container, false);

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

        sections_tv=view.findViewById(R.id.sections_tv);
        sections_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity) getActivity()).onBackPressed();

            }
        });

        serviceModels = new ArrayList<>();

        serviceModels.add(new ServiceModel("عناية مركزة",R.drawable.icu));
        serviceModels.add(new ServiceModel("جراحات عامة",R.drawable.surgery));
        serviceModels.add(new ServiceModel("معمل",R.drawable.lab));
        serviceModels.add(new ServiceModel("صيدلية",R.drawable.pharmacy));
        serviceModels.add(new ServiceModel("علاج طبيعى",R.drawable.physicaltherapy));
        serviceModels.add(new ServiceModel("حقن مجهرى",R.drawable.ivflab));
        serviceModels.add(new ServiceModel("حضان اطفال",R.drawable.maternity));
        serviceModels.add(new ServiceModel("عيادة الاسنان و التقويم",R.drawable.dental));
        serviceModels.add(new ServiceModel("التجميل و علاج السمنة",R.drawable.obesity));

        recyclerView =view.findViewById(R.id.RV1);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        Log.d("WWW", Integer.toString(width));
        int size = width/serviceModels.size() ;

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gridLayoutManager = new GridLayoutManager(getContext(),4);
        }
        else{
            gridLayoutManager = new GridLayoutManager(getContext(), 2);
        }
        recyclerView.setLayoutManager(gridLayoutManager);

        sectionAdapter = new SectionAdapter(serviceModels,getContext());
        recyclerView.setAdapter(sectionAdapter);
        sectionAdapter.notifyDataSetChanged();
    }
}