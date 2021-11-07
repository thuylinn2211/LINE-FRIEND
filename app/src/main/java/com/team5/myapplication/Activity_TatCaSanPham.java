package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.team5.myapplication.model.Products;

import java.util.ArrayList;

public class Activity_TatCaSanPham extends AppCompatActivity {

    GridView gvTatCaSanPham;

    ArrayAdapter<String> adapter;
    ArrayList<Products> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tat_ca_san_pham);

    }

}