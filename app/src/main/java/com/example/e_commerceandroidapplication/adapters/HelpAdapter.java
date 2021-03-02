package com.example.e_commerceandroidapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerceandroidapplication.R;

import java.util.List;

public class HelpAdapter extends BaseAdapter {
    Context context;
    List<String> helps;

    public HelpAdapter(Context context, List<String> helps) {
        this.context = context;
        this.helps = helps;
    }

    @Override
    public int getCount() {
        return helps.size();
    }

    @Override
    public Object getItem(int position) {
        return helps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"SetTextI18n", "ViewHolder"})
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        TextView help_text;
        view = LayoutInflater.from(context).inflate(R.layout.help_item_layout, parent, false);


        String help = helps.get(position);

        help_text = view.findViewById(R.id.help_text);

        help_text.setText(help);

        view.setOnClickListener(v -> Toast.makeText(context, help, Toast.LENGTH_SHORT).show());

        return view;
    }
}
