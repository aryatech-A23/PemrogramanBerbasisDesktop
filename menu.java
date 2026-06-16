class Menu {

    String nama;
    int harga;
    String kategori;

    // Constructor
    Menu(String nama, int harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }
}

class Main {

    public static void tampilMenu(Menu[] menu) {

        System.out.println("===== MENU MAKANAN =====");

        if (menu[0].kategori.equals("makanan")) {
            System.out.println("1. " + menu[0].nama + " - Rp" + menu[0].harga);
        }

        if (menu[1].kategori.equals("makanan")) {
            System.out.println("2. " + menu[1].nama + " - Rp" + menu[1].harga);
        }

        if (menu[2].kategori.equals("makanan")) {
            System.out.println("3. " + menu[2].nama + " - Rp" + menu[2].harga);
        }

        if (menu[3].kategori.equals("makanan")) {
            System.out.println("4. " + menu[3].nama + " - Rp" + menu[3].harga);
        }

        System.out.println("\n===== MENU MINUMAN =====");

        if (menu[4].kategori.equals("minuman")) {
            System.out.println("5. " + menu[4].nama + " - Rp" + menu[4].harga);
        }

        if (menu[5].kategori.equals("minuman")) {
            System.out.println("6. " + menu[5].nama + " - Rp" + menu[5].harga);
        }

        if (menu[6].kategori.equals("minuman")) {
            System.out.println("7. " + menu[6].nama + " - Rp" + menu[6].harga);
        }

        if (menu[7].kategori.equals("minuman")) {
            System.out.println("8. " + menu[7].nama + " - Rp" + menu[7].harga);
        }
    }

    public static void main(String[] args) {

        Menu[] menu = new Menu[8];

        // Menu makanan
        menu[0] = new Menu("Nasi Goreng", 25000, "makanan");
        menu[1] = new Menu("Mie Ayam", 20000, "makanan");
        menu[2] = new Menu("Ayam Bakar", 30000, "makanan");
        menu[3] = new Menu("Sate Ayam", 35000, "makanan");

        // Menu minuman
        menu[4] = new Menu("Es Teh", 10000, "minuman");
        menu[5] = new Menu("Jus Jeruk", 15000, "minuman");
        menu[6] = new Menu("Kopi Hitam", 12000, "minuman");
        menu[7] = new Menu("Milkshake", 18000, "minuman");

        tampilMenu(menu);
    }
}