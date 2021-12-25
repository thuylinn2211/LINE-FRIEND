package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class Activity_ThanhToan_HienThiThongtin extends AppCompatActivity {

    ImageView imvGioHang, imvDown;

    TextView txtSumGia, txtDoiSdt, txtDoiDiaChi, txtDoiHinhThucGiaoHang;

    Button btnThanhToan;
    LinearLayout btnBack;

    RadioButton radCod, radCredit, radMomo, radDiaChi, radThemDiaChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_hien_thi_thongtin);

        linkView();
        addEvent();
    }

    private void linkView() {
        imvGioHang = findViewById(R.id.imvGioHang);
        imvDown = findViewById(R.id.imvDown);

        txtSumGia = findViewById(R.id.txtSumGia);;
        txtDoiSdt = findViewById(R.id.txtDoiSdt);
        txtDoiDiaChi = findViewById(R.id.txtDoiDiaChi);
        txtDoiHinhThucGiaoHang = findViewById(R.id.txtDoiHinhThucGiaoHang);

        btnBack = findViewById(R.id.btnBack);
        btnThanhToan = findViewById(R.id.btnThanhToan);

        radCod = findViewById(R.id.radCod);
        radCredit = findViewById(R.id.radCredit);
        radMomo = findViewById(R.id.radMomo);
        radDiaChi = findViewById(R.id.radDiaChi);
        radThemDiaChi = findViewById(R.id.radThemDiaChi);
    }

    private void addEvent() {

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_VanChuyen.class);
                startActivity(intent);
            }
        });

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_ChoXacNhan.class);
                startActivity(intent);
            }
        });

    }
}