package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.team5.model.Product;

import java.util.ArrayList;

public class Activity_LikedProducts extends AppCompatActivity {

    GridView gvProducts;

    ArrayAdapter<String> adapter;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_products);

        linkViews();
        initAdapter();
        getData();
    }

    private void linkViews() {
        gvProducts = findViewById(R.id.gvProducts);
    }

    private void initAdapter() {
        adapter = new ArrayAdapter<String>(Activity_LikedProducts.this, R.layout.item_products);
        gvProducts.setAdapter(adapter);
    }

    private void getData() {
        products  = new ArrayList<Product>();
        products.add(new Product(R.drawable.butbihinhtraitim, "Bút bi hình trái tim"));
        products.add(new Product(R.drawable.gaubonghinhtraitim, "Gấu bông hình trái tim"));
    }

}