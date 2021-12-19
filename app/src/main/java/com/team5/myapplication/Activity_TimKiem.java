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

import java.util.ArrayList;

public class Activity_TimKiem extends AppCompatActivity {

    SearchView btnSearch;
    ListView lvSearch;
    ImageView btnSearchCamera, btnBack;

    ArrayList<String> list;
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
        lvSearch = findViewById(R.id.lvSearch);
        btnBack = findViewById(R.id.btnBack);
    }

    private void loadData() {

        list = new ArrayList<String>();
        list.add("Thú nhồi bông gấu Brown");
        list.add("Móc khóa Thỏ Cony");
        list.add("Giá đỡ điện thoại Thỏ Cony");
        list.add("Bút bi hình trái tim");
        list.add("Túi xách Thỏ Cony");
    }

    private void addEvents() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
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

        lvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    //em moi lam chi tiet thu bong Grown
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