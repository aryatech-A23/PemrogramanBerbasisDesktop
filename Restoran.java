/*
   NAMA : ARYA ABHIZAKI
    NIM : 055518192
    PRODI : SISTEM INFORMASI
    UPBJJ UT BANDUNG
*/
import java.util.Scanner;
public class Restoran {
    public static void main (String[] args){

        Scanner input = new Scanner(System.in);

        //Data menu
        String[] namaMenu = {
                "Nasi Padang",
                "Mie ayam",
                "Ayam Goreng",
                "Es teh",
                "Jus jeruk"
        };

        int[] hargaMenu = {
                25000,
                20000,
                30000,
                10000,
                15000
        };
     String[] kategoriMenu = {
             "Makanan",
             "Makanan",
             "Makanan",
             "Minuman",
             "Minuman"
     };

     //tampilkan menu
        System.out.println("vvvv Daftar Menu restaurant vvvvv");

        for (int i = 0; i< namaMenu.length; i++){
            System.out.println((i + 1) + "." + namaMenu[i] +
            " | " + kategoriMenu[i] +
            " | Rp " + hargaMenu[i]);
        }

        //maksimal pemesanan 4
        String[] pesanan = new String[4];
        int[] jumlahPesanan = new int[4];
        int[] totalPerItem = new int[4];
        int totalBiaya = 0;

        System.out.print("\nMasukan jumlah menu yang ingin anda pesan (maksimal 4) :");

        int jumlahMenu;
        jumlahMenu = input.nextInt();

        if (jumlahMenu > 4){
            jumlahMenu = 4;
        }

        //input pesanan
        for (int i = 0; i < jumlahMenu; i++){
            System.out.print("\npilih nomor menu : ");
            int pilih = input.nextInt();
            System.out.print("Jumlah pesanan : ");
            int jumlah = input.nextInt();

            pesanan[i] = namaMenu[pilih - 1];
            jumlahPesanan[i] = jumlah;

            totalPerItem[i] = hargaMenu[pilih - 1] * jumlah;
            totalBiaya += totalPerItem[i];
        }
        //penawaran diskon
        int bonusMinuman = 0;
        if (totalBiaya > 50000) {
            for (int i = 0; i< jumlahMenu; i++){
                for ( int j = 0; j< namaMenu.length; j++){
                    if (pesanan[i].equals(namaMenu[j]) && kategoriMenu[j].equals("minuman")) {
    bonusMinuman = hargaMenu[j] /2;
                    }
                }
            }
        }
        //diskon 10%
        double diskon = 0;

        if (totalBiaya > 100000){
            diskon = totalBiaya * 0.10;
        }
        //pajak 10%
        double pajak = totalBiaya + 0.10;

        //biaya pelayanan
        int pelayanan = 20000;

        //total
        double totalAkhir = totalBiaya + pajak + pelayanan - diskon - bonusMinuman;

        //cetak struk
        System.out.println("\nSTRUCK PEMBAYARAN");

        for (int i = 0; i < jumlahMenu; i++) {
            System.out.println(pesanan[i] + " x " +  jumlahPesanan[i] + " = Rp " + totalPerItem[i]);
        }
        System.out.println("-----------------");
        System.out.println("Total bayar : Rp " + totalAkhir);
        System.out.println("-----------------");

        input.close();
    }
}


