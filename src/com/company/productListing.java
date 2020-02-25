package com.company;


import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class productListing {
    ArrayList<produk> listProduk;

    public productListing() {
        listProduk = new ArrayList<produk>();
    }

    // Map< String, ArrayList<produk>> map = new HashMap<String,ArrayList<produk>>();
    public void IsiMenu() {
        listProduk.add(new produk(1, "jtkpad", "01921", 7500000, 12));
        listProduk.add(new produk(2, "laptop Lenovo legion", "02837", 9322000, 3));
        listProduk.add(new produk(3, "laptop MSI dragon", "05050", 9992000, 12));
        listProduk.add(new produk(4, "laptop Acer Aspire", "02021", 5000000, 10));
        listProduk.add(new produk(5, "laptop Acer Predator", "02101", 9800000, 10));
        listProduk.add(new produk(6, "laptop Asus Portable", "01911", 7500000, 11));
        listProduk.add(new produk(7, "laptop Lenovo thinkPad", "02237", 9800000, 10));
        listProduk.add(new produk(8, "ipad APPLE A5", "33211", 9920000, 10));
        listProduk.add(new produk(9, "ipad APPLE A7", "33022", 9720000, 10));
        listProduk.add(new produk(10, "ipad APPLE A10", "3323", 6500000, 10));
        listProduk.add(new produk(11, "Mouse Logitec A1", "11921", 7500000, 32));
        listProduk.add(new produk(12, "Mouse Logitec A2", "12837", 160000, 10));
        listProduk.add(new produk(13, "Mouse Logitec A3", "15050", 130000, 10));
        listProduk.add(new produk(14, "Mouse Logitec A4", "12021", 500000, 10));
        listProduk.add(new produk(15, "Printer Hp a234", "20101", 500000, 5));
        listProduk.add(new produk(16, "Printer Cannor a231 ", "21911", 700000, 10));
        listProduk.add(new produk(17, "Printer epson b1234", "22237", 1600000, 15));
        listProduk.add(new produk(18, "Keyboard Logitec B9", "6321", 130000, 10));
        listProduk.add(new produk(19, "Keyboard Logitec B11", "63022", 150000, 10));
        listProduk.add(new produk(20, "Keyboard Logitec B12", "6323", 200000, 10));

//        ListIterator litr = null;
//        litr=listProduk.listIterator();
//
//        System.out.println("\n Using list iterator");
//        while(litr.hasNext()){
//            System.out.println(litr.next());


    }

    public void showMenu() {
        for (produk barang : listProduk) {
            System.out.println("kode Barang : " + barang.getCodeProduk() + "\t" + "Nama Barang : " + barang.getNameProduct() + "\t" + " Harga Barang: Rp." + barang.getHargaProduk() + "\t" + "Stock:" + barang.getStock());
        }
    }

    public void chooseProduct(String codeBarang) {
        for (produk barang : listProduk) {
            if (codeBarang.equals(barang.codeProduk)) {
                System.out.println("kode Barang : " + barang.getCodeProduk() + "\t" + "Nama Barang : " + barang.getNameProduct() + "\t" + " Harga Barang: " + barang.getHargaProduk() + "\t" + "Stock:" + barang.getStock());
            }
        }

    }

    public int calculate(int day, String codeBarang, int quantity) {
        int calculateTotal = 0;
        for (produk barang : listProduk) {
            if (codeBarang.equals(barang.codeProduk)) {
                int harga = barang.getHargaProduk();
                if (day == 2) {
                    calculateTotal = quantity * (harga - (harga * 5 / 100));
                } else if (day == 1) {
                    calculateTotal = quantity * harga;
                }
            }

        }
        return calculateTotal;
    }

    public void calculateDiscount(int day, String codeBarang, int quantity) {

        int Discount;
        for (produk barang : listProduk) {
            if (codeBarang.equals(barang.codeProduk)) {
                int harga = barang.getHargaProduk();
                if (day == 2) {
                    int disc = harga * 5 / 100;
                    System.out.println("DISCOUNT = Rp." + harga * 5 / 100 + " PER UNIT");
                    System.out.println("TOTAL DISCOUNT= Rp." + disc * quantity);
                } else {
                    System.out.println("MAAF BELUM MENDAPAT POTONGAN HARGA");
                }
            }
        }
    }

    public void updateStock(String codeProduct, int quantity) {
        for (produk barang : listProduk) {
            if (codeProduct.equals(barang.codeProduk))
                barang.setStock(quantity);
        }
    }

    public int priceAfterDiscount(String codeProduct) {
        int priceBeforeDiscount = 0;
        int discount;
        int priceAfterDiscount = 0;
        for (produk barang : listProduk) {
            if (codeProduct.equals(barang.codeProduk))
                priceBeforeDiscount = barang.getHargaProduk();
            discount = priceBeforeDiscount * 5 / 100;
            priceAfterDiscount = priceBeforeDiscount - discount;
        }
        return priceAfterDiscount;
    }

    public String menuUnavailable(String codeProduct, int quantity) {
        int stock;
        String statement="no Statement";
        for (produk barang : listProduk) {
            if (codeProduct.equals(barang.codeProduk)) {
                stock = barang.getStock();
                if (stock < quantity) {
                    statement="Product Unavailable";
                } else {
                    statement="Product Available";
                }
            }
        }
    return statement;
    }
}
