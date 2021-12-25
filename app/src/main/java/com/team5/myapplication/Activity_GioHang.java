package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.team5.adapter.GioHangAdapter;
import com.team5.model.SanPham;

import java.sql.Connection;
import java.text.DecimalFormat;

public class Activity_GioHang extends AppCompatActivity {
    ImageView btnBack;
    static TextView txtSumGia;
    TextView txtThongBao;
    ListView lvGioHang;
    Button btnMuaHang;

    GioHangAdapter gioHangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        linkViews();
        addEvents();
        getData();
        xoa();
    }

    private void linkViews() {

        lvGioHang = findViewById(R.id.lvGioHang);
        btnBack = findViewById(R.id.btnBack);

        txtThongBao = findViewById(R.id.txtThongBao);
        txtSumGia = findViewById(R.id.txtSumGia);

        btnMuaHang = findViewById(R.id.btnMuaHang);

        gioHangAdapter = new GioHangAdapter(Activity_GioHang.this, Activity_TatCaSanPham.mangGioHang);
        lvGioHang.setAdapter(gioHangAdapter);
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //quay trở về trang chi tiết sản phẩm
                startActivity(new Intent(Activity_GioHang.this, Activity_TatCaSanPham.class));
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


        btnMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Activity_TatCaSanPham.mangGioHang.size() >0){
//                    Intent intent = new Intent(Activity_GioHang.this, Activity_ThanhToan_TTDC.class);
//                    startActivity(intent);
                }else {
                    Toast toast = Toast.makeText(Activity_GioHang.this, "Giỏ hàng của bạn hiện không có sản phẩm nào !", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

    public static void getData() {
        long tongTien = 0;
        for(int i = 0; i < Activity_TatCaSanPham.mangGioHang.size(); i++){
            tongTien += Activity_TatCaSanPham.mangGioHang.get(i).getSanphamGia();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtSumGia.setText(decimalFormat.format(tongTien) + "Đ");
    }

    private void xoa() {
        lvGioHang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Activity_GioHang.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này? ");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if(Activity_TatCaSanPham.mangGioHang.size() <= 0){
                            txtThongBao.setVisibility(View.VISIBLE);
                        }else {
                            Activity_TatCaSanPham.mangGioHang.remove(position);
                            gioHangAdapter.notifyDataSetChanged();
                            getData();
                            if(Activity_TatCaSanPham.mangGioHang.size() <= 0){
                                txtThongBao.setVisibility(View.VISIBLE);
                            }else {
                                txtThongBao.setVisibility(View.INVISIBLE);
                                gioHangAdapter.notifyDataSetChanged();
                                getData();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        gioHangAdapter.notifyDataSetChanged();
                        getData();
                    }
                });
                builder.show();
                return true;
            }
        });
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