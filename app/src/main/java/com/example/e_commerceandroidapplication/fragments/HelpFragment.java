package com.example.e_commerceandroidapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.e_commerceandroidapplication.R;
import com.example.e_commerceandroidapplication.adapters.HelpAdapter;

import java.util.ArrayList;
import java.util.List;

public class HelpFragment extends Fragment {

    ListView help_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help, container, false);
        help_list = view.findViewById(R.id.help_list);

        List<String> helps = new ArrayList<>();

        helps.add("How to order");
        helps.add("Payment");
        helps.add("Shipping");
        helps.add("Profile");
        helps.add("Contact us");

        HelpAdapter helpAdapter = new HelpAdapter(view.getContext(), helps);
        help_list.setAdapter(helpAdapter);

        return view;
    }
}