package com.example.e_commerceandroidapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_commerceandroidapplication.ProductDetail;
import com.example.e_commerceandroidapplication.R;
import com.example.e_commerceandroidapplication.models.Product;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    Context context;
    List<Product> products;

    public ProductsAdapter(Context context, List<Product> products) {
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

        holder.product_name.setText(product.name);
        holder.product_price.setText(product.price.toString() + " USD");


        switch (product.image) {
            case "p1":
                holder.product_image.setImageResource(R.drawable.p1);
                break;
            case "p2":
                holder.product_image.setImageResource(R.drawable.p2);
                break;
            case "p3":
                holder.product_image.setImageResource(R.drawable.p3);
                break;
            case "p4":
                holder.product_image.setImageResource(R.drawable.p4);
                break;
            case "p5":
                holder.product_image.setImageResource(R.drawable.p5);
                break;
            case "p6":
                holder.product_image.setImageResource(R.drawable.p6);
                break;
            case "p7":
                holder.product_image.setImageResource(R.drawable.p7);
                break;
            case "p8":
                holder.product_image.setImageResource(R.drawable.p8);
                break;
            default:
                String uri = product.image; // or whatever you want
                Glide.with(context)
                        .load(uri)
                        .placeholder(R.drawable.placeholder)
                        .into(holder.product_image);
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity) context;
                Intent intent = new Intent(context, ProductDetail.class);
                intent.putExtra("product", product);
                activity.startActivity(intent);
                activity.finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView product_name, product_price;
        ImageView product_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name = itemView.findViewById(R.id.product_name);
            product_price = itemView.findViewById(R.id.product_price);
            product_image = itemView.findViewById(R.id.product_image);
        }


    }

}
