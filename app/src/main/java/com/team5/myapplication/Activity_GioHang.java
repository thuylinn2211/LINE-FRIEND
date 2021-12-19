package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.team5.model.SanPham;

import java.text.DecimalFormat;

public class Activity_GioHang extends AppCompatActivity {
    ImageView imvPhoto;
    TextView txtTenSanPham, txtGia, txtGiamGia;

    Button btnMuaHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        linkViews();
        addEvents();
        getData();
    }

    private void linkViews() {
        imvPhoto = findViewById(R.id.imvPhoto);
        txtTenSanPham = findViewById(R.id.txtTenSanPham);
        txtGia = findViewById(R.id.txtGia);
        txtGiamGia = findViewById(R.id.txtGiamGia);
        btnMuaHang = findViewById(R.id.btnMuaHang);
    }

    private void addEvents() {
        btnMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void getData() {
    }
}