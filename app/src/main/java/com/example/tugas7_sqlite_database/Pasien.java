package com.example.tugas7_sqlite_database;

public class Pasien {
    private String _id, _nama, _alamat, _tindakan;
    public Pasien (String id, String nama, String _alamat, String _tindakan) {
        this._id = id;
        this._nama = nama;
        this._alamat = _alamat;
        this._tindakan = _tindakan;
    }
    public Pasien() {
    }
    public String get_id() {
        return _id;
    } public void set_id(String _id) {
        this._id = _id;
    }public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_alamat() {
        return _alamat;
    }
    public void set_alamat(String _alamat) {
        this._alamat = _alamat;
    }
    public String get_tindakan() {
        return _tindakan;
    }
    public void set_tindakan(String _tindakan) {
        this._tindakan = _tindakan;
    }
}
