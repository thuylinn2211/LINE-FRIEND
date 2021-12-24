package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Activity_ThemTheNganHang extends AppCompatActivity {

    ImageButton btnBack;

    ImageView imvVisa, imvMasterCard, imvJcb;

    EditText edtName, edtNumberCard, edtNgayHetHan, edtDiaChi, edtMaBuuChinh;

    Button btnFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_the_ngan_hang);

        linkView();
        addEvent();
    }


    private void linkView() {
        btnBack = findViewById(R.id.btnBack);
        btnFinish = findViewById(R.id.btnFinish);

        imvVisa = findViewById(R.id.imvVisa);
        imvMasterCard = findViewById(R.id.imvMasterCard);
        imvJcb = findViewById(R.id.imvJcb);

        edtName = findViewById(R.id.edtName);
        edtNumberCard = findViewById(R.id.edtNumberCard);
        edtNgayHetHan = findViewById(R.id.edtNgayHetHan);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtMaBuuChinh = findViewById(R.id.edtMaBuuChinh);
    }
    private void addEvent() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThemTheNganHang.this, Activity_TaiKhoanNganHang.class));
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThemTheNganHang.this, Activity_ChoXacNhan.class));
            }
        });
    }
}