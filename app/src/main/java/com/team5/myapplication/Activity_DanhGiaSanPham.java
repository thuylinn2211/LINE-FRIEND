package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Activity_DanhGiaSanPham extends AppCompatActivity {

    Button btnDang;
    LinearLayout btnCamera, btnVideo;
    ImageView imvHinhDanhia;
    EditText edtDanhGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_gia_san_pham);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnDang = findViewById(R.id.btnDang);
    }

    private void addEvents() {
        btnDang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_DanhGiaSanPham.this, Activity_ThongTinDonHang.class);
                startActivity(intent);
            }
        });
    }
}