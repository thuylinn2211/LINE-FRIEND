package com.team5.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class Activity_TaiKhoan extends AppCompatActivity {
    ImageView imvRight1,imvThongBao,imvVoucher,imvRight4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);
        linkViews();
        addEvents();
        loadLocale();

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
    }

    private void addEvents() {
        imvRight1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_TaiKhoan.this,Activity_TaiKhoanCuaToi.class);
                startActivity(intent);

            }
        });
        imvThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_TaiKhoan.this,Fragment_TaiKhoan_ThongBao.class);
                startActivity(intent);

            }
        });
        imvVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_TaiKhoan.this,Fragment_TaiKhoan_ThongBao.class);
                startActivity(intent);
            }
        });
        imvRight4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguegeDialog();
            }
        });

    }

    private void showChangeLanguegeDialog() {
        final String[] listItems={"Việt Nam","English","대한민국","日本"};
        AlertDialog.Builder mBuider=new AlertDialog.Builder(Activity_TaiKhoan.this);
        mBuider.setTitle("Chọn ngôn ngữ");
        mBuider.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i==0){
                    setLocale("vi");
                    recreate();
                }
                else if(i==1){
                    setLocale("en");
                    recreate();
                }
                else if(i==2){
                    setLocale("ko");
                    recreate();
                }
                else if(i==3){
                    setLocale("ja");
                    recreate();
                }
                dialog.dismiss();
            }
        });

        AlertDialog mDialog=mBuider.create();
        mDialog.show();


    }

    private void setLocale(String lang) {
        Locale locale=new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor=getSharedPreferences("Đổi ngôn ngữ",MODE_PRIVATE).edit();
        editor.putString("Ngôn ngữ",lang);
    }
    public void loadLocale(){
        SharedPreferences preferences=getSharedPreferences("Đổi ngôn ngữ", Activity.MODE_PRIVATE);
        String ngonngu=preferences.getString("Ngôn ngữ","");
        setLocale(ngonngu);
    }

    private void linkViews() {

        imvRight1=findViewById(R.id.imvRight1);
        imvThongBao=findViewById(R.id.imvThongBao);
        imvVoucher=findViewById(R.id.imvVoucher);
        imvRight4=findViewById(R.id.imvRight4);

    }
}