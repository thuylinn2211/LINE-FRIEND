package com.team5.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.team5.adapter.SanPhamAdapter;
import com.team5.model.SanPham;

import java.util.ArrayList;

public class FragmentGioiThieu extends Fragment {
    GridView gvSanPham1, gvSanPham2;
    Button btnXemThem;
    ImageView imvTinTuc1;

    SanPhamAdapter adapter;
    ArrayList<SanPham> sanpham;

    ArrayList<SanPham> sanpham2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_gioi_thieu, container, false);

        gvSanPham1 = view.findViewById(R.id.gvSanPham1);
        gvSanPham2 = view.findViewById(R.id.gvSanPham2);
        imvTinTuc1 = view.findViewById(R.id.imvTinTuc1);
        imvTinTuc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Activity_TinTuc1.class);
                startActivity(intent);
            }
        });
        btnXemThem = view.findViewById(R.id.btnXemThem);

        btnXemThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Activity_TatCaSanPham.class);
                startActivity(intent);
            }
        });

        adapter = new SanPhamAdapter(getContext(), R.layout.item_list, iniData());
        gvSanPham1.setAdapter(adapter);

        adapter = new SanPhamAdapter(getContext(), R.layout.item_list, iniData2());
        gvSanPham2.setAdapter(adapter);

        return view;

    }

    private ArrayList<SanPham> iniData() {
        sanpham = new ArrayList<>();
        sanpham.add(new SanPham(R.drawable.mockhoagaubrown, "Móc khóa hình Gấu Brown", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.butbihinhtraitim, "Bút bi hình trái tim", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.gaubong, "Thú nhồi bông Gấu Brown", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(R.drawable.tuixach, "Túi xách thỏ Cony", 50000, "Giảm 10000"));
        return sanpham;

    }

    private ArrayList<SanPham> iniData2() {
        sanpham2 = new ArrayList<>();
        sanpham2.add(new SanPham(R.drawable.mockhoatho, "Móc khóa hình Thỏ Cony", 50000, "Giảm 10000"));
        sanpham2.add(new SanPham(R.drawable.giadodt, "Giá đỡ điện thoại Thỏ Cony", 50000, "Giảm 10000"));
        sanpham2.add(new SanPham(R.drawable.mockhoavitvang, "Móc khóa hình vịt vàng", 50000, "Giảm 10000"));
        sanpham2.add(new SanPham(R.drawable.gaubonghinhtraitim, "Thú nhồi bông hình trái tim", 50000, "Giảm 10000"));

        return sanpham2;
    }

}
