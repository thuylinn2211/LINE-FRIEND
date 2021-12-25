package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Activity_ThanhToan_Momo extends AppCompatActivity {

    ImageView imvBack;

    EditText edtMyPhone, edtAddPhone;

    Button btnHoanThanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_momo);

        linkViews();
        addEvents();
    }
    private void linkViews() {
        imvBack = findViewById(R.id.imvBack);

        edtMyPhone = findViewById(R.id.edtMyPhone);
        edtAddPhone = findViewById(R.id.edtAddPhone);

        btnHoanThanh = findViewById(R.id.btnHoanThanh);
    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_Momo.this, Activity_ThanhToan_HienThiThongtin.class));
            }
        });

        edtAddPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_Momo.this, Activity_DiaChi.class));
            }
        });

        btnHoanThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_Momo.this, Activity_ChoLayHang.class));
            }
        });
    }

}