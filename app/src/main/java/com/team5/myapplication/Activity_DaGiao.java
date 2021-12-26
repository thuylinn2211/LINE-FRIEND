package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_DaGiao extends AppCompatActivity {
    Button btnDanhGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_giao);
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
            }
        });
    }
}