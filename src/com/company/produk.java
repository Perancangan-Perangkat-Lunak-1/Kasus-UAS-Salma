package com.company;

public class produk {

    public int sequence;
    public String namaProduk;
    public String codeProduk;
    public int hargaProduk;
    public int stock;

    public produk(){

    }
    public produk(int sequence, String namaProduk, String codeProduk, int hargaProduk, int stock){
        this.sequence = sequence;
        this.namaProduk= namaProduk;
        this.codeProduk= codeProduk;
        this.hargaProduk= hargaProduk;
        this.stock = stock;
    }
    public int getSequence()
    {
        return sequence;
    }

    public String getNameProduct()
    {
        return namaProduk;
    }
    public String getCodeProduk()
    {
        return codeProduk;
    }
    public int getHargaProduk() { return hargaProduk; }
    public int getStock() { return stock; }

    public void setSequence(){this.sequence=sequence; }
    public void setStock(int quantity){this.stock=stock-quantity;
    System.out.println("Sisa Stock Tinggal :"+this.stock + " UNIT");}
    public void setNamaProduk(){this.namaProduk=namaProduk;}
    public void setHargaProduk(){this.hargaProduk=hargaProduk;}




}
