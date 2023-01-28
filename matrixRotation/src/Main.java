import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;
    public static int[][] colors = new int[SIZE][SIZE];
    public static int[][] rotatedColors = new int[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createMatrix();
        System.out.println("Исходная матрица:" + "\n");
        printMatrix(colors);
        System.out.println("""

                Введите номер опции меню, соответствующей требуемому углу поворота:\s
                1. 90 градусов
                2. 180 градусов
                3. 270 градусов""");
        String option = scanner.nextLine();
        switch (option) {
            case ("1"):
                rotateMatrix(colors, rotatedColors);
                System.out.println("Матрица после поворота:" + "\n");
                printMatrix(rotatedColors);
                break;
            case ("2"):
                int[][] tmpColors = new int[SIZE][SIZE];
                rotateMatrix(colors, rotatedColors);
                copyMatrix(rotatedColors, tmpColors);
                rotateMatrix(tmpColors, rotatedColors);
                System.out.println("Матрица после поворота:" + "\n");
                printMatrix(rotatedColors);
                break;
            case ("3"):
                int[][] tmpColors1 = new int[SIZE][SIZE];
                int[][] tmpColors2 = new int[SIZE][SIZE];
                rotateMatrix(colors, rotatedColors);
                copyMatrix(rotatedColors, tmpColors1);
                rotateMatrix(tmpColors1, rotatedColors);
                copyMatrix(rotatedColors, tmpColors2);
                rotateMatrix(tmpColors2, rotatedColors);
                System.out.println("Матрица после поворота:" + "\n");
                printMatrix(rotatedColors);
                break;
            default:
                System.out.println("Неверная опция.");
                break;
        }
    }

    public static void createMatrix() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
    }

    public static void printMatrix(int[][] colors) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
    }

    public static void rotateMatrix(int[][] colors, int[][] rotatedColors) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[i][j] = colors[SIZE - j - 1][i];
            }
        }
    }

    public static void copyMatrix(int[][] colors, int[][] tmp) {
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(colors[i], 0, tmp[i], 0, SIZE);
        }
    }
}
