package com.agyal.hospital.ui.Contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agyal.hospital.Adapter.ContactAdapter;
import com.agyal.hospital.Adapter.SectionAdapter;
import com.agyal.hospital.MainActivity;
import com.agyal.hospital.Model.ServiceModel;
import com.agyal.hospital.R;

import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.VERTICAL;

public class ContactFragment extends Fragment {

    ImageView ic_menu;
    TextView contact_tv;

    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    ArrayList<ServiceModel> serviceModels;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_contact, container, false);

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

        contact_tv=view.findViewById(R.id.contact_tv);
        contact_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity) getActivity()).onBackPressed();

            }
        });

        serviceModels = new ArrayList<>();

        serviceModels.add(new ServiceModel("1 طريق دسوق قلين - مزلقان فوة - مدينة دسوق - محافظة كفر الشيخ",R.drawable.address));
        serviceModels.add(new ServiceModel("0472560590 - 0472560580 \n" +
                "01097117054 - 01274144744",R.drawable.telephone));
        serviceModels.add(new ServiceModel("info@agialhospital-eg.com",R.drawable.email));
        serviceModels.add(new ServiceModel("http://www.agialhospital-eg.com",R.drawable.website));
        serviceModels.add(new ServiceModel("fb.com/agialhospital.eg",R.drawable.fb));


        recyclerView =view.findViewById(R.id.RV3);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), VERTICAL,false));
        contactAdapter = new ContactAdapter(serviceModels,getContext());
        recyclerView.setAdapter(contactAdapter);
        contactAdapter.notifyDataSetChanged();
    }
}