package com.example.e_commerceandroidapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_commerceandroidapplication.R;
import com.example.e_commerceandroidapplication.models.Product;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    Context context;
    private ArrayList<Product> products;

    public ProductsAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.product_layout_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.TvName.setText(product.getName());
        holder.TvPrice.setText(product.getPrice().toString() + " USD");


        switch (product.getImage()) {
            case "p1":
                holder.SiImage.setImageResource(R.drawable.p1);
                break;
            case "p2":
                holder.SiImage.setImageResource(R.drawable.p2);
                break;
            case "p3":
                holder.SiImage.setImageResource(R.drawable.p3);
                break;
            case "p4":
                holder.SiImage.setImageResource(R.drawable.p4);
                break;
            case "p5":
                holder.SiImage.setImageResource(R.drawable.p5);
                break;
            case "p6":
                holder.SiImage.setImageResource(R.drawable.p6);
                break;
            case "p7":
                holder.SiImage.setImageResource(R.drawable.p7);
                break;
            case "p8":
                holder.SiImage.setImageResource(R.drawable.p8);
                break;
            default:
                String uri = product.getImage(); // or whatever you want
                Glide.with(context)
                        .load(uri)
                        .placeholder(R.drawable.placeholder)
                        .into(holder.SiImage);
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.TvName.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView TvName, TvPrice;
        public ImageView SiImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TvName = itemView.findViewById(R.id.product_name);
            TvPrice = itemView.findViewById(R.id.product_price);
            SiImage = itemView.findViewById(R.id.product_image);
        }


    }

}
