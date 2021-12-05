package com.example.tugas7_sqlite_database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Salamat, Stindakan;
    private EditText Enama, Ealamat, Etindakan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Salamat = i.getStringExtra("Ialamat");
        Stindakan = i.getStringExtra("Itindakan");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ealamat = (EditText) findViewById(R.id.updel_alamat);
        Etindakan = (EditText) findViewById(R.id.updel_tindakan);
        Enama.setText(Snama);
        Ealamat.setText(Salamat);
        Etindakan.setText(Stindakan);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Stindakan = String.valueOf(Etindakan.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Salamat.equals("")){
                    Ealamat.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi alamat",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stindakan.equals("")) {
                    Etindakan.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi tindakan",
                            Toast.LENGTH_SHORT).show();
                }else {
                    db.UpdatePasien(new Pasien (Sid, Snama, Salamat, Stindakan));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePasien (new Pasien(Sid, Snama, Salamat, Stindakan));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
