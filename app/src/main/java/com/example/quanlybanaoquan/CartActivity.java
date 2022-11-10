package com.example.quanlybanaoquan;

public class CartActivity {
    public  int idsp;
    public  String tensp;
    public  long giasp;
    public  String hinhsp;
    public  String soluongsp;

    public CartActivity(int idsp, String tensp, long giasp, String hinhsp, String soluongsp) {
        this.idsp = idsp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.hinhsp = hinhsp;
        this.soluongsp = soluongsp;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public long getGiasp() {
        return giasp;
    }

    public void setGiasp(long giasp) {
        this.giasp = giasp;
    }

    public String getHinhsp() {
        return hinhsp;
    }

    public void setHinhsp(String hinhsp) {
        this.hinhsp = hinhsp;
    }

    public String getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(String soluongsp) {
        this.soluongsp = soluongsp;
    }
}
