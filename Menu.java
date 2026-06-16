import java.util.ArrayList;
import java.io.*;

public class Menu {

    private ArrayList<MenuItem> daftarMenu;

    public Menu() {
        daftarMenu = new ArrayList<>();
    }

    public void tambahMenu(MenuItem item) {
        daftarMenu.add(item);
    }

    public ArrayList<MenuItem> getDaftarMenu() {
        return daftarMenu;
    }

    public void tampilkanMenu() {

        if (daftarMenu.isEmpty()) {
            System.out.println("Menu masih kosong.");
            return;
        }

        for (int i = 0; i < daftarMenu.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarMenu.get(i).tampilMenu();
        }
    }

    public MenuItem getItem(int index) throws Exception {

        if (index < 0 || index >= daftarMenu.size()) {
            throw new Exception("Menu tidak ditemukan!");
        }

        return daftarMenu.get(index);
    }

    public void simpanMenu() {

        try {

            PrintWriter pw =
                    new PrintWriter(new FileWriter("menu.txt"));

            for (MenuItem item : daftarMenu) {

                if (item instanceof Makanan) {

                    Makanan m = (Makanan) item;

                    pw.println(
                            "Makanan,"
                                    + m.getNama() + ","
                                    + m.getHarga() + ","
                                    + m.getJenisMakanan());

                } else if (item instanceof Minuman) {

                    Minuman m = (Minuman) item;

                    pw.println(
                            "Minuman,"
                                    + m.getNama() + ","
                                    + m.getHarga() + ","
                                    + m.getJenisMinuman());

                } else if (item instanceof Diskon) {

                    Diskon d = (Diskon) item;

                    pw.println(
                            "Diskon,"
                                    + d.getNama() + ","
                                    + d.getDiskon());
                }
            }

            pw.close();

        } catch (IOException e) {

            System.out.println("Gagal menyimpan menu.");
        }
    }

    public void muatMenu() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("menu.txt"));

            String baris;

            while ((baris = br.readLine()) != null) {

                String[] data = baris.split(",");

                if (data[0].equals("Makanan")) {

                    tambahMenu(
                            new Makanan(
                                    data[1],
                                    Double.parseDouble(data[2]),
                                    data[3]));

                } else if (data[0].equals("Minuman")) {

                    tambahMenu(
                            new Minuman(
                                    data[1],
                                    Double.parseDouble(data[2]),
                                    data[3]));

                } else if (data[0].equals("Diskon")) {

                    tambahMenu(
                            new Diskon(
                                    data[1],
                                    Double.parseDouble(data[2])));
                }
            }

            br.close();

        } catch (IOException e) {

            System.out.println("File menu belum tersedia.");
        }
    }
}