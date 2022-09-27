/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entities;

import java.util.Random;

/**
 *
 * @author 202011000030
 */
public class AG {

    private int[][] mat;
    private final int range;
    private Random random = new Random();

    public AG(int range) {
        setMat(range);
        this.range = range;
    }

    public void getMat() {
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param range
     */
    public void setMat(int range) {
        this.mat = new int[range][range];
    }

    public void geraNumMat() {
        for (int i = 0; i < range; i++) {
            for (int j = i+1; j < range; j++) {
                if (i != j) {
                    int aux = random.nextInt(100)+1;
                    mat[i][j] = aux;
                    mat[j][i] = aux;
                } else {
                    mat[i][j] = 0;
                }

            }
        }
    }

}
