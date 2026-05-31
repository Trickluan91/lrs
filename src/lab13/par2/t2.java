package lab13.par2;

import javax.swing.*;
import java.util.Random;

public class t2 {
    static int col = 5;
    static int line = 5;
    static int[][] matrix = new int[col][line];

    static void main() {
        initMatrix();

        IO.println(String.format("Введите номер столбца матрицы для вывода. Размер массива: %d, %d", col, line));
        Integer n = null;
        while (n == null || n == 0) {
            n = t1.parseInt(IO.readln());
        }

        try {
            for (int i = 0; i < line; i++) {
                IO.print(matrix[n][i]);
                IO.print(" ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            IO.println("Нет такого столбца.");
        }
    }

    static void initMatrix() {
        Random rand = new Random();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < line; j++) {
                matrix[i][j] = rand.nextInt(10_000);
            }
        }
    }
}
