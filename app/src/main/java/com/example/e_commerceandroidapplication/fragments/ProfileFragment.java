package com.example.e_commerceandroidapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.e_commerceandroidapplication.R;
import com.example.e_commerceandroidapplication.adapters.ProfilAdapter;
import com.example.e_commerceandroidapplication.models.ProfilHelp;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    ListView list_profil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        list_profil = view.findViewById(R.id.list_profil);

        List<ProfilHelp> profilHelpList = new ArrayList<>();

        profilHelpList.add(new ProfilHelp("Order History", "ic_order_history"));
        profilHelpList.add(new ProfilHelp("Rate Us", "ic_rate_us"));
        profilHelpList.add(new ProfilHelp("Share", "ic_share"));
        profilHelpList.add(new ProfilHelp("Privacy Policy", "ic_privacy_policy"));


        ProfilAdapter profilAdapter = new ProfilAdapter(view.getContext(), profilHelpList);
        list_profil.setAdapter(profilAdapter);

        return view;
    }
}