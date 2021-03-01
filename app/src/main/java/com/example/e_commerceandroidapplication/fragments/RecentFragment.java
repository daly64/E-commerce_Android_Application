package com.example.e_commerceandroidapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerceandroidapplication.R;
import com.example.e_commerceandroidapplication.adapters.ProductsAdapter;
import com.example.e_commerceandroidapplication.models.Product;

import java.util.ArrayList;
import java.util.List;

public class RecentFragment extends Fragment {
    ProductsAdapter adapter;
    RecyclerView products_list;
    List<Product> products = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recent, container, false);

        settingUpRecyclerView(view);
        return view;
    }

    private void settingUpRecyclerView(View view) {
        products.add(new Product("Samsung Galaxy S10 -Black", "p1", getString(R.string.product_description), 0, 899));
        products.add(new Product("U17 USB Portable M3 HUmidifier", "p2", getString(R.string.product_description), 0, 20));
        products.add(new Product("Apple Watch Series 3", "p3", getString(R.string.product_description), 0, 1200));
        products.add(new Product("Mini Digital Speaker", "p4", getString(R.string.product_description), 0, 100));
        products.add(new Product("Hybride Stroller Cabi", "p5", getString(R.string.product_description), 0, 380));
        products.add(new Product("Bib Slabber", "p6", getString(R.string.product_description), 0, 8));
        products.add(new Product("Portable Bottle Heater", "p7", getString(R.string.product_description), 0, 8));
        products.add(new Product("GEA Baby Ray Queen", "p8", getString(R.string.product_description), 0, 220));

        products_list = view.findViewById(R.id.products_list);
        products_list.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        products_list.setLayoutManager(manager);
        adapter = new ProductsAdapter(view.getContext(), products);
        products_list.setAdapter(adapter);
    }
}