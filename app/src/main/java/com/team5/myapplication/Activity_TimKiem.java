package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;


import com.team5.adapter.SanPhamAdapter;
import com.team5.model.SanPham;

import java.text.DecimalFormat;
import com.team5.model.SanPham;

import java.util.ArrayList;

public class Activity_TimKiem extends AppCompatActivity {

    SearchView btnSearch;
    GridView gvSearch;
    ListView lvSearch;
    ImageView btnSearchCamera, btnBack;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    ArrayList<SanPham> sanpham;
    SanPhamAdapter sanPhamAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);

        linkViews();
        loadData();
        addEvents();
    }

    private void linkViews() {
        btnSearch = findViewById(R.id.btnSearch);
        btnSearchCamera = findViewById(R.id.btnSearchCamera);
        gvSearch = findViewById(R.id.gvSearch);
        btnBack = findViewById(R.id.btnBack);
        lvSearch = findViewById(R.id.lvSearch);
    }

    private void loadData() {

        sanpham = new ArrayList<SanPham>();
        sanpham.add(new SanPham(R.drawable.gaubong,"Thú nhồi bông gấu Brown", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.butbihinhtraitim, "Bút bi hình trái tim", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.tuixach, "Túi xách thỏ Cony", 50000, "Giảm 10000"));

        list = new ArrayList<String>();
        list.add("Móc khóa Thỏ Cony");
        list.add("Giá đỡ điện thoại Thỏ Cony");
        list.add("Bút bi hình trái tim");
        list.add("Túi xách Thỏ Cony");
    }

    private void addEvents() {
        sanPhamAdapter = new SanPhamAdapter(Activity_TimKiem.this, R.layout.item_list, sanpham);
        gvSearch.setAdapter(sanPhamAdapter);

        adapter = new ArrayAdapter<String>(Activity_TimKiem.this,android.R.layout.simple_list_item_1, list);
        lvSearch.setAdapter(adapter);

        btnSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });


        gvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(getApplicationContext(), Activity_DetailedProduct.class);
                    intent.putExtra("thongtinsanpham", sanpham.get(position));
                    startActivity(intent);
                }else if(position == 1){
                    Intent intent = new Intent(getApplicationContext(), Activity_DetailedProduct.class);
                    intent.putExtra("thongtinsanpham", sanpham.get(position));
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getApplicationContext(), Activity_DetailedProduct.class);
                    intent.putExtra("thongtinsanpham", sanpham.get(position));
                    startActivity(intent);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_TimKiem.this, Activity_TrangChu.class));
            }
        });

        //open camera
        if( ContextCompat.checkSelfPermission(Activity_TimKiem.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Activity_TimKiem.this, new String[]{Manifest.permission.CAMERA}, 101);

        }
        btnSearchCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 101);
            }
        });
    }

    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if( requestCode == 101){
//            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//
//        }
//    }
}