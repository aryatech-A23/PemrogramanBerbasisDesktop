import java.awt.*;
import java.util.ArrayList;
import java.io.*;

public class Pesanan {
    private ArrayList<MenuItem> daftarPesanan;

    public Pesanan(){
        daftarPesanan = new ArrayList<>();
    }

    public void tambahPesanan(MenuItem item){
        daftarPesanan.add(item);
    }
    public double hitungTotal(){
        double total = 0;
        double diskon = 0;

        for (MenuItem item : daftarPesanan){
            if (item instanceof  Diskon){
                diskon += ((Diskon)item).getDiskon();
            } else {
                total += item.getHarga();
            }
        }
        total = total - (total * diskon / 100);
        return total;
    }
    public void simpanStruk(){
        System.out.println("\n==== STRUK RESTORAN ====");
        for (MenuItem item : daftarPesanan){
            item.tampilMenu();
        }
        System.out.println("________________________");
        System.out.println("Total : Rp" + hitungTotal());
    }
    public void tampilStruk(){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Struk.txt"));
            pw.println("====== Struk anda=====");
            for (MenuItem item : daftarPesanan){
                pw.println(item.getNama() + "-Rp" + item.getHarga());
            }
            pw.println("----------");
            pw.println("Total = Rp" + hitungTotal());
            pw.close();
        } catch (IOException e){
            System.out.println("Gagal menyimpan Struk :(( ");
        }
    }
}
