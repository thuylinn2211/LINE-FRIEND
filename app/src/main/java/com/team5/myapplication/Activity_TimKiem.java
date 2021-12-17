package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Activity_TimKiem extends AppCompatActivity {

    public static final String[] SANPHAM = new String[]{"BT21", "Missha", "Móc khóa Thỏ Cony", "Gấu bông"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);

        AutoCompleteTextView edtTimKiem = findViewById(R.id.edtTimKiem);
        ArrayAdapter<String> spAdapter = new ArrayAdapter<String>(Activity_TimKiem.this, android.R.layout.simple_list_item_1, SANPHAM);
        edtTimKiem.setAdapter(spAdapter);
    }
}