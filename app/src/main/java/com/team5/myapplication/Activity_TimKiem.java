package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import com.team5.model.SanPham;

import java.util.ArrayList;

public class Activity_TimKiem extends AppCompatActivity {

    SearchView btnSearch;
    ListView lvTimKiem;
    ImageView btnSearchCamera, btnBack;

    ArrayList<String> sanpham;
    ArrayAdapter<String> adapter;



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
        lvTimKiem = findViewById(R.id.lvTimKiem);
        btnBack = findViewById(R.id.btnBack);
    }

    private void loadData() {

        sanpham = new ArrayList<String>();
        sanpham.add("Móc khóa hình Gấu Brown");
        sanpham.add("Bút bi hình trái tim");
        sanpham.add("Thú nhồi bông Gấu Brown");
        sanpham.add("Túi xách thỏ Cony");
        sanpham.add("Móc khóa hình Thỏ Cony");
        sanpham.add("Giá đỡ điện thoại Thỏ Cony");
        sanpham.add("Móc khóa hình vịt vàng");
        sanpham.add("Thú nhồi bông hình trái tim");
    }

    private void addEvents() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sanpham);
        lvTimKiem.setAdapter(adapter);

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

        lvTimKiem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){

                    startActivity(new Intent(Activity_TimKiem.this, Activity_DetailedProduct.class));

                }else if(position == 1){

                }else {

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