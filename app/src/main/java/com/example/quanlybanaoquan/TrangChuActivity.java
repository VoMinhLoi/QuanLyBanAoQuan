package com.example.quanlybanaoquan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class TrangChuActivity extends AppCompatActivity {
    List<AoQuan> aoQuanList;
    AoQuanAdapter aoQuanAdapter;
    GridView aoQuanGVAX;
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private List<Image> imageList;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageButton navBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        AnhXa();
        createAoQuanList();
        aoQuanAdapter = new AoQuanAdapter(TrangChuActivity.this, aoQuanList);
        aoQuanGVAX.setAdapter(aoQuanAdapter);
        getImageList();
        ImageAdapter imageAdapter = new ImageAdapter(imageList);
        viewPager2.setAdapter(imageAdapter);
        circleIndicator3.setViewPager(viewPager2);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,3000);
            }
        });

        navigationView.inflateHeaderView(R.layout.customer_nav_header);
        navBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int currentPosition = viewPager2.getCurrentItem();
            if(currentPosition == (imageList.size() - 1))
                viewPager2.setCurrentItem(0);
            else
                viewPager2.setCurrentItem(currentPosition + 1);
        }
    };
    public void createAoQuanList(){
        aoQuanList = new ArrayList<>();
        aoQuanList.add(new AoQuan("", "Áo thun sọc", "200 VND", "", R.drawable.aothun));
        aoQuanList.add(new AoQuan("", "Quần jean", "400 VND", "", R.drawable.quanjean));
        aoQuanList.add(new AoQuan("", "Quần tây", "199 VND", "", R.drawable.quantay));
        aoQuanList.add(new AoQuan("", "Áo sơ mi", "250 VND", "", R.drawable.sominam));
    }
    public void getImageList (){
        imageList = new ArrayList<>();
        imageList.add(new Image(R.drawable.slider1));
        imageList.add(new Image(R.drawable.slider2));
        imageList.add(new Image(R.drawable.slider3));
        imageList.add(new Image(R.drawable.slider4));

        imageList.add(new Image(R.drawable.slider1));
        imageList.add(new Image(R.drawable.slider2));
        imageList.add(new Image(R.drawable.slider3));
        imageList.add(new Image(R.drawable.slider4));
    }
    public void AnhXa(){
        aoQuanGVAX = findViewById(R.id.aoQuanGV);
        viewPager2 = findViewById(R.id.imagesViewPager);
        circleIndicator3 = findViewById(R.id.circleIndicator);
        navBT = findViewById(R.id.navigationBT);
        drawerLayout = findViewById(R.id.drawerLayOut);
        navigationView = findViewById(R.id.nav);
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        handler.removeCallbacks(runnable);
//    }
////    @Override
//    protected void onResume() {
//        super.onResume();
//        handler.postDelayed(runnable,3000);
//    }
}