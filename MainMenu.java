import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Menu menu = new Menu();
        menu.muatMenu();

        Pesanan pesanan = new Pesanan();

        int pilihan;

        do {

            System.out.println("\n===== RESTORAN ARYA =====");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Tampilkan Menu");
            System.out.println("3. Pesan");
            System.out.println("4. Tampilkan Struk");
            System.out.println("5. Simpan Menu");
            System.out.println("6. Keluar");
            System.out.print("Pilihan : ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:

                    System.out.println("\n1. Makanan");
                    System.out.println("2. Minuman");
                    System.out.println("3. Diskon");
                    System.out.print("Pilih jenis menu : ");

                    int jenis = input.nextInt();
                    input.nextLine();

                    if (jenis == 1) {

                        System.out.print("Nama : ");
                        String nama = input.nextLine();

                        System.out.print("Harga : ");
                        double harga = input.nextDouble();
                        input.nextLine();

                        System.out.print("Jenis Makanan : ");
                        String jm = input.nextLine();

                        menu.tambahMenu(
                                new Makanan(nama, harga, jm));

                    } else if (jenis == 2) {

                        System.out.print("Nama : ");
                        String nama = input.nextLine();

                        System.out.print("Harga : ");
                        double harga = input.nextDouble();
                        input.nextLine();

                        System.out.print("Jenis Minuman : ");
                        String jm = input.nextLine();

                        menu.tambahMenu(
                                new Minuman(nama, harga, jm));

                    } else if (jenis == 3) {

                        System.out.print("Nama Diskon : ");
                        String nama = input.nextLine();

                        System.out.print("Persentase Diskon : ");
                        double d = input.nextDouble();

                        menu.tambahMenu(
                                new Diskon(nama, d));
                    }

                    break;

                case 2:

                    menu.tampilkanMenu();
                    break;

                case 3:

                    menu.tampilkanMenu();

                    System.out.print("Pilih nomor menu : ");
                    int nomor = input.nextInt();

                    try {

                        pesanan.tambahPesanan(
                                menu.getItem(nomor - 1));

                        System.out.println(
                                "Pesanan berhasil ditambahkan");

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage());
                    }

                    break;

                case 4:

                    pesanan.tampilStruk();
                    pesanan.simpanStruk();
                    break;

                case 5:

                    menu.simpanMenu();
                    System.out.println(
                            "Menu berhasil disimpan");
                    break;

                case 6:

                    System.out.println(
                            "Program selesai");
                    break;

                default:

                    System.out.println(
                            "Pilihan tidak tersedia");
            }

        } while (pilihan != 6);

        input.close();
    }
}