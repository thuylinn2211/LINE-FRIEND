package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Activity_ChoXacNhan extends AppCompatActivity {

    ImageView btnBack, btnSearch, imvHinh;
    TextView txtTenSanPham,txtChoXacNhan, txtChoLayHang, txtDangGiao, txtDaGiao, txtSumGia, txtSoLuong;
    ListView lvChoXacNhan;
    Button btnLienHeShop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cho_xac_nhan);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBack = findViewById(R.id.btnBack);
        btnSearch = findViewById(R.id.btnSearch);
        txtChoXacNhan = findViewById(R.id.txtChoXacNhan);
        txtChoLayHang = findViewById(R.id.txtChoLayHang);
        txtDangGiao = findViewById(R.id.txtDangGiao);
        txtDaGiao = findViewById(R.id.txtDaGiao);
        txtSumGia = findViewById(R.id.txtSumGia);
        txtSoLuong = findViewById(R.id.txtSoLuong);
        lvChoXacNhan = findViewById(R.id.lvChoXacNhan);
        btnLienHeShop = findViewById(R.id.btnLienHeShop);

        imvHinh =findViewById(R.id.imvHinh);
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_TrangChu.class));
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_TimKiem.class));
            }
        });

        btnLienHeShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_Chat.class));
            }
        });
        txtChoLayHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_ChoLayHang.class));
            }
        });
        txtDangGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_DangGiao.class));
            }
        });
        txtDaGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_DaGiao.class));
            }
        });
    }
}