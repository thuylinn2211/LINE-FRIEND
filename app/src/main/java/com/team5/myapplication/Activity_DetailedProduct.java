package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.team5.adapter.SanPhamAdapter;
import com.team5.model.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Activity_DetailedProduct extends AppCompatActivity {

    GridView gvSanPham;
    ImageView imvHinh;
    TextView txtTenSanPham, txtGia, txtGiamGia;

    Button btnAddProduct, btnBuy, btnAddLikedProduct;

    Spinner spPhanLoai;
    ArrayList<String> phanloai;
    ArrayAdapter<String> adapter;

    ArrayList<SanPham> sanpham;
    SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_product);
        linkViews();
        iniData();
        loadData();
        getData();
        addEvents();


    }

    private void linkViews() {
        spPhanLoai = findViewById(R.id.spPhanLoai);
        gvSanPham = findViewById(R.id.gvSanPham);

        imvHinh = findViewById(R.id.imvHinh);

        txtGia = findViewById(R.id.txtGia);
        txtGiamGia = findViewById(R.id.txtGiamGia);
        txtTenSanPham = findViewById(R.id.txtTenSanPham);

        btnBuy = findViewById(R.id.btnBuy);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        btnAddLikedProduct = findViewById(R.id.btnAddLikedProduct);

    }

    private void getData() {
        String tensanpham = "";
        double giasanpham = 0;
        String giamgia = "";
        int hinhanh = 0;

        SanPham sanPham = (SanPham) getIntent().getSerializableExtra("thongtinsanpham");

        tensanpham = sanPham.getSanphamTen();
        giasanpham = sanPham.getSanphamGia();
        giamgia = sanPham.getSanphamGiamGia();
        hinhanh = sanPham.getSanphamHinh();
//        Intent intent = getIntent();
//        if (intent.getExtras() != null){
//            sanpham = (ArrayList<SanPham>) intent.getSerializableExtra("item");
//            imvHinh.set
//        }
        txtTenSanPham.setText(tensanpham);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtGia.setText(decimalFormat.format(giasanpham));
        txtGiamGia.setText(giamgia);
        imvHinh.setImageResource(hinhanh);


    }

    private void iniData() {
        sanpham = new ArrayList<SanPham>();
        sanpham.add(new SanPham(R.drawable.mockhoagaubrown, "Móc khóa hình Gấu Brown", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.butbihinhtraitim, "Bút bi hình trái tim", 50000, "Giảm 10000"));

        phanloai = new ArrayList<String>();
        phanloai.add("Size lớn");
        phanloai.add("Size vừa");
        phanloai.add("Size nhỏ");

    }

    private void loadData() {
        sanPhamAdapter = new SanPhamAdapter(Activity_DetailedProduct.this, R.layout.item_list, sanpham);
        gvSanPham.setAdapter(sanPhamAdapter);

        adapter = new ArrayAdapter<String>(Activity_DetailedProduct.this, android.R.layout.simple_dropdown_item_1line, phanloai);
        spPhanLoai.setAdapter(adapter);
    }

    private void addEvents() {
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_DetailedProduct.this, Activity_GioHang.class);
                startActivity(intent);
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Chuyển qua màn hình thanh toán
//                Intent intent = new Intent(Activity_DetailedProduct.this, Activity_ThanhToan_TTDC.class);
//                startActivity(intent);
            }
        });
        btnAddLikedProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_DetailedProduct.this, Activity_LikedProducts.class);
                startActivity(intent);
            }
        });
    }
}