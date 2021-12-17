package com.team5.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.team5.adapter.SanPhamAdapter;
import com.team5.model.SanPham;

import java.util.ArrayList;

public class FragmentSanPhamHot extends Fragment {
    GridView gvSanPham;

    SanPhamAdapter adapter;
    ArrayList<SanPham> sanpham;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_san_pham_hot, container, false);

        gvSanPham = view.findViewById(R.id.gvSanPham);

        adapter = new SanPhamAdapter(getContext(), R.layout.item_list, iniData());
        gvSanPham.setAdapter(adapter);

        return view;

    }

    private ArrayList<SanPham> iniData() {
        sanpham = new ArrayList<>();
        sanpham.add(new SanPham(R.drawable.mockhoagaubrown, "Móc khóa hình Gấu Brown", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.butbihinhtraitim, "Bút bi hình trái tim", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.gaubong, "Thú nhồi bông Gấu Brown", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.tuixach, "Túi xách thỏ Cony", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.mockhoatho, "Móc khóa hình Thỏ Cony", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.giadodt, "Giá đỡ điện thoại Thỏ Cony", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.mockhoavitvang, "Móc khóa hình vịt vàng", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.gaubonghinhtraitim, "Thú nhồi bông hình trái tim", 50000, "Giảm 10000"));

        return sanpham;
    }
}
