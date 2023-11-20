package com.features.growharvestnew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.features.growharvestnew.R;

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] productName;
    int[] productImage;

    LayoutInflater inflater;

    public GridAdapter(Context context, String[] productName, int[] productImage) {
        this.context = context;
        this.productName = productName;
        this.productImage = productImage;
    }

    @Override
    public int getCount() {
        return productName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){

            convertView = inflater.inflate(R.layout.activity_another_grid_adapter,null);

        }

        ImageView imageView = convertView.findViewById(R.id.anotherimageView);
        TextView textView = convertView.findViewById(R.id.anothertextName);

        imageView.setImageResource(productImage[position]);
        textView.setText(productName[position]);

        return convertView;
    }
}
