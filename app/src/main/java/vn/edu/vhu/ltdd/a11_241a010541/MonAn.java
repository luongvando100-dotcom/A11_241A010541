package vn.edu.vhu.ltdd.a11_241a010541;

import java.text.NumberFormat;
import java.util.Locale;

public class MonAn {
    private String ten;
    private String moTa;
    private int gia;
    private int hinh;

    public MonAn(String ten, String moTa, int gia, int hinh) {
        this.ten = ten;
        this.moTa = moTa;
        this.gia = gia;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public static String dinhDangGia(int gia) {
        NumberFormat nf = NumberFormat.getInstance(new Locale("vi", "VN"));
        return nf.format(gia) + " đ";
    }
}
