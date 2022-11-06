package com.example.quanlybanaoquan;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AoQuanAdapter extends BaseAdapter {
    private Activity activity;
    private List<AoQuan> aoQuanList;

    public AoQuanAdapter(Activity activity, List<AoQuan> aoQuanList) {
        this.activity = activity;
        this.aoQuanList = aoQuanList;
    }

    @Override
    public int getCount() {
        return aoQuanList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.customer_aoquan,null);
        ImageView imageView = view.findViewById(R.id.clothesImage);
        TextView nameTVAX = view.findViewById(R.id.nameTV);
        TextView priceTVAX = view.findViewById(R.id.priceTV);
        AoQuan aoQuan = aoQuanList.get(i);
        imageView.setImageResource(aoQuan.getImage());
        nameTVAX.setText(aoQuan.getName());
        priceTVAX.setText(aoQuan.getPrice());
        return view;
    }
}
