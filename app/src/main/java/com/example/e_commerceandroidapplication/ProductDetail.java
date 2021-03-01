package com.example.e_commerceandroidapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.e_commerceandroidapplication.models.Product;

public class ProductDetail extends AppCompatActivity {
    ImageView product_image;
    TextView product_name, product_price, product_quantity, product_description;
    Button add_to_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        add_to_cart = findViewById(R.id.add_to_cart);
        add_to_cart.setOnClickListener(v -> {
            Toast.makeText(ProductDetail.this, "Add to cart", Toast.LENGTH_SHORT).show();
        });

        setToolBar();
        setProduct();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar_menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_cart) {
            Toast.makeText(ProductDetail.this, "Action caddy clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_search) {
            Toast.makeText(ProductDetail.this, "Action search clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    private void setProduct() {
        product_image = findViewById(R.id.product_image);
        product_name = findViewById(R.id.product_name);
        product_price = findViewById(R.id.product_price);
        product_quantity = findViewById(R.id.product_quantity);
        product_description = findViewById(R.id.product_description);

        // Get the Intent that started this activity and extract the string
        Product product = (Product) getIntent().getSerializableExtra("product");

        product_name.setText(product.name);
        product_price.setText(product.price.toString());
        product_quantity.setText(product.quantity.toString());
        product_description.setText(product.description);

        switch (product.image) {
            case "p1":
                product_image.setImageResource(R.drawable.p1);
                break;
            case "p2":
                product_image.setImageResource(R.drawable.p2);
                break;
            case "p3":
                product_image.setImageResource(R.drawable.p3);
                break;
            case "p4":
                product_image.setImageResource(R.drawable.p4);
                break;
            case "p5":
                product_image.setImageResource(R.drawable.p5);
                break;
            case "p6":
                product_image.setImageResource(R.drawable.p6);
                break;
            case "p7":
                product_image.setImageResource(R.drawable.p7);
                break;
            case "p8":
                product_image.setImageResource(R.drawable.p8);
                break;
            default:
                String uri = product.image;
                Glide.with(this)
                        .load(uri)
                        .placeholder(R.drawable.placeholder)
                        .into(product_image);
                break;
        }

    }

    private void setToolBar() {
        Toolbar toolbar = findViewById(R.id.tool_bar_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}