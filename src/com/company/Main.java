package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        productListing dataMenu = new productListing();
        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner in3 = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\tDAFTAR PRODUK SALMA ELECTONICS STORE\n");
        dataMenu.IsiMenu();
        dataMenu.showMenu();
        System.out.println("==============================================================");
        System.out.println("Hari Membeli : ");
        System.out.println("1.Hari antara Senin - Jum'at");
        System.out.println("2.Weekend (Sabtu atau Minggu)");
        System.out.print("Pilihan: ");
        int pilihan = in.nextInt();
        if(pilihan ==2){
            System.out.println("SELAMAT ANDA MENDAPATKAN DISKON SEBESAR\n5% UNTUK SEGALA JENIS PRODUK");
        }else{
            System.out.println("ANDA BELUM MENDAPATKAN POTONGAN HARGA");
        }
        System.out.println("\t\tSILAHKAN INPUT PRODUK YANG ANDA BUTUHKAN:");
        System.out.print("Kode Produk : ");
        String codeProductChoosen=in1.nextLine();
        dataMenu.chooseProduct(codeProductChoosen);
        System.out.print("Quantitas: ");
        int quantity = in2.nextInt();
        String statement = dataMenu.menuUnavailable(codeProductChoosen,quantity);
        System.out.println(statement);
        if (statement.equals("Product Unavailable")){
            System.exit(1);
        }else {

            if (pilihan == 2) {
                dataMenu.calculateDiscount(pilihan, codeProductChoosen, quantity);
                int priceAfterDiscount = dataMenu.priceAfterDiscount(codeProductChoosen);
                System.out.println("Harga Setelah Discount: Rp. " + priceAfterDiscount);
            } else {
                System.out.println("TOTAL DISCOUNT= 0");
            }

            dataMenu.updateStock(codeProductChoosen, quantity);
            int totalPrice = dataMenu.calculate(pilihan, codeProductChoosen, quantity);
            System.out.println("TOTAL BELANJA ANDA :" + totalPrice);
        }
        System.out.println("\t\t\t~TERIMAKASIH ATAS KUNJUNGAN ANDA :D ~");

        }
    }
