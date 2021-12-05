package com.example.tugas7_sqlite_database;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Pasien> Pasien;
    public CustomListAdapter(Activity activity, List<Pasien>
            Pasien) {
        this.activity = activity;
        this.Pasien = Pasien;
    }
    @Override
    public int getCount() {return Pasien.size();
    }
    @Override
    public Object getItem(int location) {
        return Pasien.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView alamat = (TextView)
                convertView.findViewById(R.id.text_alamat);
        TextView tindakan = (TextView)
                convertView.findViewById(R.id.text_tindakan);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Pasien m = Pasien.get(position);
        nama.setText("Nama : "+ m.get_nama());
        alamat.setText("Alamat : "+ m.get_alamat());
        tindakan.setText("Tindakan : "+ m.get_tindakan());
        return convertView;
    }
}
