package com.example.e_commerceandroidapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.e_commerceandroidapplication.R;
import com.example.e_commerceandroidapplication.adapters.CategoryAdapter;
import com.example.e_commerceandroidapplication.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    ListView category_list;
    List<Category> categories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        category_list = view.findViewById(R.id.category_list);
        categories = new ArrayList<>();
        categories.add(new Category("Electronics & Gadgets", "a1", 5));
        categories.add(new Category("Fashions", "a2", 5));
        categories.add(new Category("Baby Gear", "a3", 5));
        categories.add(new Category("Home & Furniture", "a4", 5));
        categories.add(new Category("Health & Sports", "a5", 5));
        categories.add(new Category("Office & Industry", "a6", 5));

        CategoryAdapter categoryAdapter = new CategoryAdapter(view.getContext(), categories);
        category_list.setAdapter(categoryAdapter);
        return view;
    }
}