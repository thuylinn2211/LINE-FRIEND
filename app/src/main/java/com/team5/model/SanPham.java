package com.team5.model;

public class SanPham {
    private int sanphamHinh;
    private String sanphamTen;
    private double sanphamGia;
    private String sanphamGiamGia;

    public int getSanphamHinh() {
        return sanphamHinh;
    }

    public void setSanphamHinh(int sanphamHinh) {
        this.sanphamHinh = sanphamHinh;
    }

    public String getSanphamTen() {
        return sanphamTen;
    }

    public void setSanphamTen(String sanphamTen) {
        this.sanphamTen = sanphamTen;
    }

    public double getSanphamGia() {
        return sanphamGia;
    }

    public void setSanphamGia(double sanphamGia) {
        this.sanphamGia = sanphamGia;
    }

    public String getSanphamGiamGia() {
        return sanphamGiamGia;
    }

    public void setSanphamGiamGia(String sanphamGiamGia) {
        this.sanphamGiamGia = sanphamGiamGia;
    }

    public SanPham(int sanphamHinh, String sanphamTen, double sanphamGia, String sanphamGiamGia) {
        this.sanphamHinh = sanphamHinh;
        this.sanphamTen = sanphamTen;
        this.sanphamGia = sanphamGia;
        this.sanphamGiamGia = sanphamGiamGia;
    }
}
