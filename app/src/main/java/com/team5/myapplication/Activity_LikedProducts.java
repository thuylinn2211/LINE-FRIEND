package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.team5.adapter.SanPhamAdapter;
import com.team5.model.Product;
import com.team5.model.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Activity_LikedProducts extends AppCompatActivity {

    GridView gvSanPham;

    SanPhamAdapter adapter;
    ArrayList<SanPham> sanpham;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_products);

        linkViews();
        initAdapter();
        loadData();
    }

    private void linkViews() {
        gvSanPham = findViewById(R.id.gvSanPham);

    }

    private void initAdapter() {
        sanpham = new ArrayList<SanPham>();
        sanpham.add(new SanPham(R.drawable.mockhoagaubrown, "Móc khóa hình Gấu Brown", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.butbihinhtraitim, "Bút bi hình trái tim", 50000, "Giảm 10000"));
    }
    private void loadData() {
        adapter = new SanPhamAdapter(Activity_LikedProducts.this,R.layout.likeditem_list, sanpham);
        gvSanPham.setAdapter(adapter);
    }
}