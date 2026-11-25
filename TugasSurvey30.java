import java.util.Scanner;

public class TugasSurvey30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int RESPONDEN = 10, PERTANYAAN = 6;
        int total = 0;
        int[][] nilai = new int[RESPONDEN][PERTANYAAN];

        for (int i = 0; i < nilai.length; i++) {
            System.out.println("Masukkan Nilai Responden ke-" + (i + 1) + " :");
            for (int j = 0; j < nilai[i].length; j++) {
                do {
                    System.out.printf("Pertanyaan ke-%s : ", (j + 1));
                    nilai[i][j] = sc.nextInt();
                    if (nilai[i][j] < 1 || nilai[i][j] > 5) {
                        System.out.println("Nilai yang dimasukkan tidak valid. Masukkan ulang");
                    }
                } while (nilai[i][j] < 1 || nilai[i][j] > 5);
            }
        }
        sc.close();
        System.out.println("\n===== Rekap Rata-Rata Survey =====");
        System.out.println();
        System.out.print("Rata-Rata Responden:");
        for (int i = 0; i < nilai.length; i++) {
            total = 0;
            for (int j = 0; j < nilai[i].length; j++) {
                total += nilai[i][j];
            }
            System.out.printf("\nRata-rata responden ke-%s : %2f", (i + 1), (double) total / PERTANYAAN);
        }
        System.out.println();
        System.out.print("Rata-Rata Pertanyaan:");
        for (int i = 0; i < PERTANYAAN; i++) {
            total = 0;
            for (int j = 0; j < RESPONDEN; j++) {
                total += nilai[j][i];
            }
            System.out.printf("\nRata-rata pertanyaan ke-%s : %2f", (i + 1), (double) total / RESPONDEN);
        }
    }
}
