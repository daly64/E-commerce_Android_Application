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
import com.example.e_commerceandroidapplication.models.Category;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    Context context;
    List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"SetTextI18n", "ViewHolder"})
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ImageView category_image;
        TextView category_name, category_items_number;
        view = LayoutInflater.from(context).inflate(R.layout.category_item_layout, parent, false);


        Category category = categories.get(position);

        category_image = view.findViewById(R.id.category_image);
        category_name = view.findViewById(R.id.category_name);
        category_items_number = view.findViewById(R.id.category_items_number);


        category_name.setText(category.name);
        category_items_number.setText(category.items_number.toString() + " " + context.getString(R.string.category_items_number));

        int id = context.getResources().getIdentifier(category.image, "drawable", context.getPackageName());
        category_image.setImageResource(id);

        if (!category.image.contains("a")) {
            String uri = category.image; // or whatever you want
            Glide.with(context)
                    .load(uri)
                    .placeholder(R.drawable.placeholder)
                    .into(category_image);
        }


        view.setOnClickListener(v -> Toast.makeText(context, category.name, Toast.LENGTH_SHORT).show());
        return view;
    }


}



