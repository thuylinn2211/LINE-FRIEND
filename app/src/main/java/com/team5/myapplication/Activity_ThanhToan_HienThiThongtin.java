package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Activity_ThanhToan_HienThiThongtin extends AppCompatActivity {

    ImageView imvGioHang, imvDown;

    TextView txtSumGia, txtDoiSdt, txtDoiDiaChi, txtDoiHinhThucGiaoHang;

    Button btnHoanThanhDonHang, btnThanhToan;

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

        btnHoanThanhDonHang = findViewById(R.id.btnHoanThanhDonHang);
        btnThanhToan = findViewById(R.id.btnThanhToan);

        radCod = findViewById(R.id.radCod);
        radCredit = findViewById(R.id.radCredit);
        radMomo = findViewById(R.id.radMomo);
        radDiaChi = findViewById(R.id.radDiaChi);
        radThemDiaChi = findViewById(R.id.radThemDiaChi);
    }

    private void addEvent() {

    }
}