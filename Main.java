/*
    NAMA : ARYA ABHIZAKI
    NIM : 055518192
    UPBJJ UT BANDUNG
    TUGAS 2 PEMROGRAMAN BERBASIS DESKTOP
 */
import java.util.Scanner;

class Menu {

    String nama;
    int harga;
    String kategori;

    Menu(String nama, int harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }
}

public class Main {

    static Scanner input = new Scanner(System.in);

    static Menu[] daftarMenu = new Menu[100];
    static int jumlahMenu = 0;

    static String[] pesanan = new String[100];
    static int[] jumlahPesanan = new int[100];
    static int jumlahDataPesanan = 0;

    public static void main(String[] args) {

        tambahMenuAwal();

        int pilihan;

        do {

            System.out.println("\n==== MENU RESTORAN ARYA ====");
            System.out.println("1. Menu Pelanggan");
            System.out.println("2. Manajemen Menu");
            System.out.println("3. Keluar");

            System.out.print("Pilih menu : ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    menuPelanggan();
                    break;

                case 2:
                    menuManajemen();
                    break;

                case 3:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia!");
            }

        } while (pilihan != 3);
    }
    //meniu awal
    static void tambahMenuAwal() {

        daftarMenu[jumlahMenu++] =
                new Menu("Mie Ayam", 20000, "Makanan");

        daftarMenu[jumlahMenu++] =
                new Menu("Nasi Goreng", 25000, "Makanan");

        daftarMenu[jumlahMenu++] =
                new Menu("Sate Ayam", 35000, "Makanan");

        daftarMenu[jumlahMenu++] =
                new Menu("Es Teh", 10000, "Minuman");

        daftarMenu[jumlahMenu++] =
                new Menu("Jus Jeruk", 15000, "Minuman");

        daftarMenu[jumlahMenu++] =
                new Menu("Kopi", 18000, "Minuman");

        daftarMenu[jumlahMenu++] =
                new Menu("Susu Coklat", 20000, "Minuman");
    }

//tampilkan menu

    static void tampilkanMenu() {

        System.out.println("\n==== DAFTAR MENU ====");

        System.out.println("\n--- MAKANAN ---");

        for (int i = 0; i < jumlahMenu; i++) {

            if (daftarMenu[i].kategori.equalsIgnoreCase("Makanan")) {

                System.out.println(
                        (i + 1) + ". " +
                                daftarMenu[i].nama +
                                " - Rp" +
                                daftarMenu[i].harga
                );
            }
        }

        System.out.println("\n--- MINUMAN ---");

        for (int i = 0; i < jumlahMenu; i++) {

            if (daftarMenu[i].kategori.equalsIgnoreCase("Minuman")) {

                System.out.println(
                        (i + 1) + ". " +
                                daftarMenu[i].nama +
                                " - Rp" +
                                daftarMenu[i].harga
                );
            }
        }
    }

 //menu pelanggan

    static void menuPelanggan() {

        jumlahDataPesanan = 0;

        tampilkanMenu();

        while (true) {

            System.out.print(
                    "\nMasukkan nama menu (ketik selesai) : "
            );

            String namaMenu = input.nextLine();

            if (namaMenu.equalsIgnoreCase("selesai")) {
                break;
            }

            boolean ditemukan = false;

            for (int i = 0; i < jumlahMenu; i++) {

                if (daftarMenu[i].nama.equalsIgnoreCase(namaMenu)) {

                    ditemukan = true;

                    System.out.print("Jumlah pesanan : ");
                    int jumlah = input.nextInt();
                    input.nextLine();

                    pesanan[jumlahDataPesanan] =
                            daftarMenu[i].nama;

                    jumlahPesanan[jumlahDataPesanan] =
                            jumlah;

                    jumlahDataPesanan++;

                    System.out.println(
                            "Pesanan berhasil ditambahkan."
                    );
                }
            }

            if (!ditemukan) {
                System.out.println(
                        "Menu tidak tersedia!"
                );
            }
        }

        hitungTotal();
    }

  //menghitung total

    static void hitungTotal() {

        int subtotal = 0;
        int totalMinuman = 0;

        System.out.println(
                "\n==== STRUK PEMBAYARAN ===="
        );

        for (int i = 0; i < jumlahDataPesanan; i++) {

            for (int j = 0; j < jumlahMenu; j++) {

                if (pesanan[i].equalsIgnoreCase(
                        daftarMenu[j].nama)) {

                    int totalItem =
                            daftarMenu[j].harga *
                                    jumlahPesanan[i];

                    System.out.println(
                            pesanan[i] +
                                    " x " +
                                    jumlahPesanan[i] +
                                    " = Rp" +
                                    totalItem
                    );

                    subtotal += totalItem;

                    if (daftarMenu[j].kategori.equalsIgnoreCase(
                            "Minuman")) {

                        totalMinuman += jumlahPesanan[i];
                    }
                }
            }
        }

        System.out.println(
                "\nSubtotal : Rp" + subtotal
        );

        int diskon = 0;

        if (subtotal > 100000) {

            diskon = subtotal * 10 / 100;

            System.out.println(
                    "Diskon 10% : Rp" + diskon
            );
        }

        int gratisMinuman = 0;

        if (subtotal > 50000 && totalMinuman >= 2) {

            gratisMinuman = 10000;

            System.out.println(
                    "Promo beli 1 gratis 1 minuman : Rp" +
                            gratisMinuman
            );
        }

        int setelahDiskon =
                subtotal - diskon - gratisMinuman;

        int pajak =
                setelahDiskon * 10 / 100;

        int pelayanan = 20000;

        int totalBayar =
                setelahDiskon + pajak + pelayanan;

        System.out.println(
                "Pajak 10% : Rp" + pajak
        );

        System.out.println(
                "Biaya pelayanan : Rp" + pelayanan
        );

        System.out.println("--------------------");

        System.out.println(
                "Total bayar : Rp" + totalBayar
        );
    }

//menu manajemen

    static void menuManajemen() {

        int pilih;

        do {

            System.out.println(
                    "\n==== MANAJEMEN MENU ===="
            );

            System.out.println("1. Tambah menu");
            System.out.println("2. Ubah harga");
            System.out.println("3. Hapus menu");
            System.out.println("4. Lihat menu");
            System.out.println("5. Kembali");

            System.out.print("Pilih : ");

            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:
                    tambahMenuBaru();
                    break;

                case 2:
                    ubahHarga();
                    break;

                case 3:
                    hapusMenu();
                    break;

                case 4:
                    tampilkanMenu();
                    break;

                case 5:
                    System.out.println(
                            "Kembali ke menu utama"
                    );
                    break;

                default:
                    System.out.println(
                            "Pilihan salah!"
                    );
            }

        } while (pilih != 5);
    }

//tambah menu baru

    static void tambahMenuBaru() {

        char lagi;

        do {

            System.out.print("Nama menu : ");
            String nama = input.nextLine();

            System.out.print("Harga menu : ");
            int harga = input.nextInt();
            input.nextLine();

            System.out.print(
                    "Kategori (Makanan/Minuman) : "
            );

            String kategori = input.nextLine();

            daftarMenu[jumlahMenu++] =
                    new Menu(nama, harga, kategori);

            System.out.println(
                    "Menu berhasil ditambahkan."
            );

            System.out.print(
                    "Tambah lagi? (y/t) : "
            );

            lagi = input.next().charAt(0);
            input.nextLine();

        } while (lagi == 'y' || lagi == 'Y');
    }

//mengubah harga

    static void ubahHarga() {

        tampilkanMenu();

        System.out.print(
                "Pilih nomor menu yang ingin diubah : "
        );

        int nomor = input.nextInt();
        input.nextLine();

        if (nomor < 1 || nomor > jumlahMenu) {

            System.out.println(
                    "Nomor tidak valid!"
            );

            return;
        }

        System.out.print(
                "Yakin ingin mengubah? (Ya/Tidak) : "
        );

        String konfirmasi = input.nextLine();

        if (konfirmasi.equalsIgnoreCase("Ya")) {

            System.out.print(
                    "Masukkan harga baru : "
            );

            int hargaBaru = input.nextInt();
            input.nextLine();

            daftarMenu[nomor - 1].harga =
                    hargaBaru;

            System.out.println(
                    "Harga berhasil diubah."
            );

        } else {

            System.out.println(
                    "Perubahan dibatalkan."
            );
        }
    }

   //hapus menu

    static void hapusMenu() {

        tampilkanMenu();

        System.out.print(
                "Pilih nomor menu yang ingin dihapus : "
        );

        int nomor = input.nextInt();
        input.nextLine();

        if (nomor < 1 || nomor > jumlahMenu) {

            System.out.println(
                    "Nomor tidak valid!"
            );

            return;
        }

        System.out.print(
                "Yakin ingin menghapus? (Ya/Tidak) : "
        );

        String konfirmasi = input.nextLine();

        if (konfirmasi.equalsIgnoreCase("Ya")) {

            for (int i = nomor - 1;
                 i < jumlahMenu - 1;
                 i++) {

                daftarMenu[i] =
                        daftarMenu[i + 1];
            }

            jumlahMenu--;

            System.out.println(
                    "Menu berhasil dihapus."
            );

        } else {

            System.out.println(
                    "Penghapusan dibatalkan."
            );
        }
    }
}