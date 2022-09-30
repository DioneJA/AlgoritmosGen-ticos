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
public class Graph {

    private int[][] graph;
    private final int range;
    private Random random = new Random();

    public Graph(int range) {
        setGraph(range);
        this.range = range;
    }

    public void getGraph() {
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param range
     */
    public void setGraph(int range) {
        this.graph = new int[range][range];
    }

    public void genNumGraph() {
        for (int i = 0; i < range; i++) {
            for (int j = i+1; j < range; j++) {
                if (i != j) {
                    int aux = random.nextInt(100)+1;
                    graph[i][j] = aux;
                    graph[j][i] = aux;
                } else {
                    graph[i][j] = 0;
                }

            }
        }
    }

}
