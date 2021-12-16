package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Activity_TinTuc extends AppCompatActivity implements View.OnClickListener{

    LinearLayout lvTinTuc1, lvTinTuc2, lvTinTuc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_tuc);

        linkViews();


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.lvTinTuc1, new frag_tintuc1()).commit();
    }

    private void linkViews() {
        lvTinTuc1 = findViewById(R.id.lvTinTuc1);
        lvTinTuc2 = findViewById(R.id.lvTinTuc2);
        lvTinTuc3 = findViewById(R.id.lvTinTuc3);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.lvTinTuc1){
            getSupportFragmentManager().beginTransaction().replace(R.id.lvTinTuc1, new frag_tintuc1()).commit();
            lvTinTuc1.setVisibility(View.GONE);
        }
    }

}