package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.team5.adapter.GioHangAdapter;
import com.team5.model.SanPham;

import java.text.DecimalFormat;

public class Activity_GioHang extends AppCompatActivity {
    ImageView imvHinh, btnBack;
    TextView txtTenSanPham, txtGia, txtGiamGia, txtSumGia, txtSoLuong, txtThongBao;
    ListView lvGioHang;
    Button btnMuaHang, btnTang, btnGiam;

    GioHangAdapter gioHangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        linkViews();
        addEvents();
        getData();
    }

    private void linkViews() {

        lvGioHang = findViewById(R.id.lvGioHang);

        btnBack = findViewById(R.id.btnBack);

        imvHinh = findViewById(R.id.imvHinh);
        txtTenSanPham = findViewById(R.id.txtTenSanPham);
        txtGia = findViewById(R.id.txtGia);
        txtGiamGia = findViewById(R.id.txtGiamGia);

        btnGiam = findViewById(R.id.btnGiam);
        btnTang = findViewById(R.id.btnTang);

        txtThongBao = findViewById(R.id.txtThongBao);
        txtSoLuong = findViewById(R.id.txtSoLuong);
        txtSumGia = findViewById(R.id.txtSumGia);
        txtGiamGia = findViewById(R.id.txtGiamGia);

        btnMuaHang = findViewById(R.id.btnMuaHang);
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //quay trở về trang chi tiết sản phẩm
                startActivity(new Intent(Activity_GioHang.this, Activity_DetailedProduct.class));
            }
        });

        if( Activity_TatCaSanPham.mangGioHang.size() <= 0){
            gioHangAdapter.notifyDataSetChanged();
            txtThongBao.setVisibility(View.VISIBLE);
            lvGioHang.setVisibility(View.VISIBLE);
        }else {
            gioHangAdapter.notifyDataSetChanged();
            txtThongBao.setVisibility(View.INVISIBLE);
            lvGioHang.setVisibility(View.VISIBLE);
        }

        long tongTien = 0;
        for(int i = 0; i < Activity_TatCaSanPham.mangGioHang.size(); i++){
            tongTien += Activity_TatCaSanPham.mangGioHang.get(i).getSanphamGia();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###, ###, ###");
        txtSumGia.setText(decimalFormat.format(tongTien) + "Đ");







        btnMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void getData() {
    }

    public void trangchu(MenuItem item) {
        Intent intent = new Intent(Activity_GioHang.this, com.team5.myapplication.Activity_TrangChu.class);
        startActivity(intent);
    }

    public void yeuthich(MenuItem item) {
        Intent intent = new Intent(Activity_GioHang.this, com.team5.myapplication.Activity_LikedProducts.class);
        startActivity(intent);
    }

    public void muasam(MenuItem item) {
        Intent intent = new Intent(Activity_GioHang.this, com.team5.myapplication.Activity_GioHang.class);
        startActivity(intent);
    }

    public void timkiem(MenuItem item) {
        Intent intent = new Intent(Activity_GioHang.this, com.team5.myapplication.Activity_TimKiem.class);
        startActivity(intent);
    }

    public void taikhoan(MenuItem item) {
        Intent intent = new Intent(Activity_GioHang.this, com.team5.myapplication.Activity_TaiKhoan.class);
        startActivity(intent);
    }
}