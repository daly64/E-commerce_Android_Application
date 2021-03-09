package com.example.e_commerceandroidapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.e_commerceandroidapplication.R;
import com.example.e_commerceandroidapplication.models.ProfilHelp;

import java.util.List;

public class ProfilAdapter extends BaseAdapter {
    Context context;
    List<ProfilHelp> profilHelpList;

    public ProfilAdapter(Context context, List<ProfilHelp> profilHelpList) {
        this.context = context;
        this.profilHelpList = profilHelpList;
    }

    @Override
    public int getCount() {
        return profilHelpList.size();
    }

    @Override
    public Object getItem(int position) {
        return profilHelpList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"SetTextI18n", "ViewHolder"})
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ImageView profilHelp_image;
        TextView profilHelp_name;
        view = LayoutInflater.from(context).inflate(R.layout.profil_help_item_layout, parent, false);


        ProfilHelp profilHelp = profilHelpList.get(position);

        profilHelp_image = view.findViewById(R.id.profilHelp_image);
        profilHelp_name = view.findViewById(R.id.profilHelp_name);


        profilHelp_name.setText(profilHelp.name);

        int id = context.getResources().getIdentifier(profilHelp.image, "drawable", context.getPackageName());
        profilHelp_image.setImageResource(id);

        if (!profilHelp.image.contains("ic_")) {
            String uri = profilHelp.image; // or whatever you want
            Glide.with(context)
                    .load(uri)
                    .placeholder(R.drawable.placeholder)
                    .into(profilHelp_image);
        }

        view.setOnClickListener(v -> Toast.makeText(context, profilHelp.name, Toast.LENGTH_SHORT).show());
        return view;
    }


}