package com.example.tugas7_sqlite_database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ealamat,Etindakan;
    private String Snama, Salamat,Stindakan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ealamat = (EditText) findViewById(R.id.create_alamat);
        Etindakan = (EditText) findViewById(R.id.create_tindakan);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Stindakan = String.valueOf(Etindakan.getText());if (Snama.equals(""))
                {
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Salamat.equals("")) {
                    Ealamat.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi alamat",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stindakan.equals("")) {
                    Etindakan.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tindakan",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Ealamat.setText("");
                    Etindakan.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreatePasien(new Pasien(null, Snama, Salamat, Stindakan));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
