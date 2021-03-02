package com.example.e_commerceandroidapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

        switch (category.image) {
            case "a1":
                category_image.setImageResource(R.drawable.a1);
                break;
            case "a2":
                category_image.setImageResource(R.drawable.a2);
                break;
            case "a3":
                category_image.setImageResource(R.drawable.a3);
                break;
            case "a4":
                category_image.setImageResource(R.drawable.a4);
                break;
            case "a5":
                category_image.setImageResource(R.drawable.a5);
                break;
            case "a6":
                category_image.setImageResource(R.drawable.a6);
                break;

            default:
                String uri = category.image; // or whatever you want
                Glide.with(context)
                        .load(uri)
                        .placeholder(R.drawable.placeholder)
                        .into(category_image);
                break;
        }

        return view;
    }


}



