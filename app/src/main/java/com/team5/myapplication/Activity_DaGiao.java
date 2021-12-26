package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
<<<<<<< HEAD
=======
import android.widget.ImageView;
import android.widget.TextView;
>>>>>>> 5780659272d4ee503dc18df2c1bbced8824c1bb7

public class Activity_DaGiao extends AppCompatActivity {
    Button btnDanhGia;

    ImageView btnBack, btnSearch, imvHinh;
    TextView txtTenSanPham,txtChoXacNhan, txtChoLayHang, txtDangGiao, txtDaGiao, txtSumGia, txtSoLuong;
    Button btnLienHeShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_giao);
<<<<<<< HEAD
        linkView();
        addEvent();
    }

    private void linkView() {
        btnDanhGia=findViewById(R.id.btnDanhGia);
    }

    private void addEvent() {
        btnDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Activity_DanhGiaSanPham.class);
                startActivity(intent);
=======

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
        btnLienHeShop = findViewById(R.id.btnLienHeShop);

        imvHinh =findViewById(R.id.imvHinh);
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_TrangChu.class));
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_TimKiem.class));
            }
        });

        btnLienHeShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_Chat.class));
            }
        });
        txtChoXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_ChoLayHang.class));
            }
        });
        txtChoLayHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_ChoLayHang.class));
            }
        });
        txtDangGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_DangGiao.class));
            }
        });
        txtDaGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_DaGiao.class));
>>>>>>> 5780659272d4ee503dc18df2c1bbced8824c1bb7
            }
        });
    }
}