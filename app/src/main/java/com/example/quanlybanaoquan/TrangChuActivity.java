package com.example.quanlybanaoquan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class TrangChuActivity extends AppCompatActivity {
    List<AoQuan> aoQuanList;
    AoQuanAdapter aoQuanAdapter;
    GridView aoQuanGVAX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        createAoQuanList();
        aoQuanAdapter = new AoQuanAdapter(TrangChuActivity.this, aoQuanList);
        aoQuanGVAX = findViewById(R.id.aoQuanGV);
        aoQuanGVAX.setAdapter(aoQuanAdapter);
    }
    public void createAoQuanList(){

        aoQuanList = new ArrayList<>();
        aoQuanList.add(new AoQuan("", "Áo thun sọc", "200 VND", "", R.drawable.aothun));
        aoQuanList.add(new AoQuan("", "Quần jean", "400 VND", "", R.drawable.quanjean));
        aoQuanList.add(new AoQuan("", "Quần tây", "199 VND", "", R.drawable.quantay));
        aoQuanList.add(new AoQuan("", "Áo sơ mi", "250 VND", "", R.drawable.sominam));
    }
}