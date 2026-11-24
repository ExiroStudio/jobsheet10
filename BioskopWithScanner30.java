package jobsheet10;

import java.util.Scanner;

public class BioskopWithScanner30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int baris = -1, kolom = -1;
        String nama, next;
        String[][] penonton = new String[4][2];
        boolean stopProgram = false;

        while (!stopProgram) {
            System.out.println("\n====== Menu Bioskop ======");
            System.out.println("Menu 1: Input data penonton");
            System.out.println("Menu 2: Tampilkan daftar penonton");
            System.out.println("Menu 3: Exit");
            System.out.print("Masukkan nomor menu 1/2/3 : ");
            int menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    while (true) {
                        System.out.print("Masukkan nama: ");
                        nama = sc.nextLine();
                        do {
                            do {
                                System.out.print("Masukkan baris: ");
                                baris = sc.nextInt();
                                if (baris > penonton.length || baris < 0) {
                                    System.out.println("Nomor baris tidak valid");
                                }
                            } while (baris > penonton.length || baris < 0);

                            do {
                                System.out.print("Masukkan kolom: ");
                                kolom = sc.nextInt();
                                if (kolom > penonton[0].length || kolom < 0) {
                                    System.out.println("Nomor kolom tidak valid");
                                }
                            } while (kolom > penonton[0].length || kolom < 0);
                            sc.nextLine();
                            if (penonton[baris - 1][kolom - 1] != null) {
                                System.out.println("Kursi yang dipilih sudah terisi penonton lain.");
                                System.out.println("Mohon isi baris dan kolom kembali");
                            }
                        } while (penonton[baris - 1][kolom - 1] != null);
                        penonton[baris - 1][kolom - 1] = nama;
                        System.out.print("Input penonton lainnya? (y/n): ");
                        next = sc.nextLine();
                        if (next.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < penonton.length; i++) {
                        System.out.printf("Baris kursi ke-%s", i + 1);
                        for (String namaPenonton : penonton[i]) {
                            System.out.printf(" %-6s",(namaPenonton != null ? namaPenonton : "***"));
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    stopProgram = true;
                    break;
                default:
                    System.out.println("Nomor menu tidak valid");
                    break;
            }
        }
        sc.close();
    }

}
