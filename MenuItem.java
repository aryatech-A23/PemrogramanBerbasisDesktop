/*
    NAMA    : ARYA ABHIZAAKI
    NIM     : 055518192
    UPBJJ UT BANDUNG
    TUGAS 3 PEMROGRAMAN BERBASIS DESKTOP
 */

public abstract class MenuItem{
    private String nama;
    private double harga;
    private String kategotri;

    public MenuItem(String nama, double harga, String kategotri) {
        this.nama = nama;
        this.harga = harga;
        this.kategotri = kategotri;
    }

    protected MenuItem() {
    }

    public String getNama(){
        return nama;
    }
    public double getHarga(){
        return harga;
    }
    public String getKategotri(){
        return kategotri;
    }
    public abstract void tampilMenu();
}
