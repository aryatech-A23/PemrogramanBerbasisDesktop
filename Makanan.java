public class Makanan  extends  MenuItem{
    private String jenisMakanan;

    public Makanan(String nama, double harga, String jenisMakanan){
        super(nama, harga, "Makanan");
        this.jenisMakanan = jenisMakanan;
    }
    public String getJenisMakanan(){
        return jenisMakanan;
    }
    @Override
    public void tampilMenu(){
        System.out.print("makanan : " + getNama() + "Jenis : " + jenisMakanan + "Harga : Rp" + getHarga());
    }
}
