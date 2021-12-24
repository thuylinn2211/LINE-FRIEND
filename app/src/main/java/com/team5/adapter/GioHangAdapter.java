package com.team5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.team5.model.GioHang;
import com.team5.myapplication.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {

    Context context;
    ArrayList<GioHang> gioHangs;

    public GioHangAdapter(Context context, ArrayList<GioHang> gioHangs) {
        this.context = context;
        this.gioHangs = gioHangs;
    }

    @Override
    public int getCount() {
        return gioHangs.size();
    }

    @Override
    public Object getItem(int i) {
        return gioHangs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{

        public ImageView imvHinh;
        public TextView  txtTenSanPham,txtGia, txtGiamGia, txtSoLuong;
        public Button btnGiam, btnTang, btnXoa;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_giohang, null);

            viewHolder.imvHinh = view.findViewById(R.id.imvHinh);
            viewHolder.txtTenSanPham = view.findViewById(R.id.txtTenSanPham);
            viewHolder.txtGia = view.findViewById(R.id.txtGia);
            viewHolder.txtGiamGia = view.findViewById(R.id.txtGiamGia);
            viewHolder.txtSoLuong = view.findViewById(R.id.txtSoLuong);
            viewHolder.btnGiam = view.findViewById(R.id.btnGiam);
            viewHolder.btnTang = view.findViewById(R.id.btnTang);
            viewHolder.btnXoa = view.findViewById(R.id.btnXoa);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        GioHang gioHang = (GioHang) getItem(i);

        viewHolder.imvHinh.setImageResource(gioHang.getSanphamHinh());
        viewHolder.txtTenSanPham.setText(gioHang.getSanphamTen());
        DecimalFormat decimalFormat = new DecimalFormat("###, ###, ###");
        viewHolder.txtGia.setText(decimalFormat.format(gioHang.getSanphamGia()) + "Đ");
        viewHolder.txtGiamGia.setText(gioHang.sanphamGiamGia);
        viewHolder.txtSoLuong.setText(gioHang.getSoluongSP() + "");

        return null;
    }
}
