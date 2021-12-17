package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Activity_frag_thanhtoan_chinhsuadonhang extends AppCompatActivity {

    String selectedTinh, selectedHuyen, selectedXa;
    Spinner tinhSpinner, huyenSpinner, xaSpinner;
    ArrayAdapter<CharSequence> tinhAdapter, huyenAdapter, xaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_thanhtoan_chinhsuadonhang);

        linkViews();
        loadData();
    }

    private void linkViews() {
        tinhSpinner = findViewById(R.id.spTinh);

    }

    private void loadData() {
        tinhAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_tinh, R.layout.fragment_spinner_layout);
        tinhAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tinhSpinner.setAdapter(tinhAdapter);
        tinhSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*tìm thành phố, huyện */
                huyenSpinner = findViewById(R.id.spHuyen);
                selectedTinh = tinhSpinner.getSelectedItem().toString();

                int parentID = parent.getId();
                if (parentID == R.id.spTinh){
                    switch (selectedTinh){
                        case  "Thành phố/ Tỉnh thành (*)": huyenAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.arrray_default_huyen, R.layout.fragment_spinner_layout);
                        break;
                        case "Đắk Lắk": huyenAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_daklak_huyen, R.layout.fragment_spinner_layout);
                        break;
                        case "Hà Nam": huyenAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_hanam_huyen, R.layout.fragment_spinner_layout);
                        break;
                        case "An Giang": huyenAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_angiang_huyen, R.layout.fragment_spinner_layout);
                        break;
                        default: break;
                    }

                    //selected huyen --> xa
                    huyenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    huyenSpinner.setAdapter(huyenAdapter);
                    huyenSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            //tìm xã
                            xaSpinner = findViewById(R.id.spXa);
                            selectedHuyen = huyenSpinner.getSelectedItem().toString();

                            int parentID = parent.getId();
                            if (parentID == R.id.spHuyen) {
                                switch (selectedHuyen) {
                                    case "Quận/ Huyện (*)":
                                        xaAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.arrray_default_xa, R.layout.fragment_spinner_layout);
                                        break;
                                    case "Thành phố Long Xuyên":
                                        xaAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                                R.array.array_angiang_thanhpholongxuyen_xa, R.layout.fragment_spinner_layout);
                                        break;
                                    default: break;
                                }

                                xaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                xaSpinner.setAdapter(xaAdapter);

                                xaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        selectedXa = xaSpinner.getSelectedItem().toString();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {
                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}