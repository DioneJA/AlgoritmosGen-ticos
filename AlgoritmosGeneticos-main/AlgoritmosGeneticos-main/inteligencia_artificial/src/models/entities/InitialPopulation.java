package models.entities;

import java.util.Random;
import javax.swing.JOptionPane;

public class InitialPopulation {

    private final int quantChromo = 200;
    private int[][] result;
    private int range;
    private int[] assistFit = new int[200];
    private int[][] graph;
    
    public InitialPopulation(int range,int[][] graph) {
        this.range = range;
        this.result = new int[quantChromo][range];
        this.graph = graph;
    }

    public void printResult() {
        for (int i = 0; i < quantChromo; i++) {
            for (int j = 0; j < range; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void initializer(int[] assist, int firstNumber) {
        for (int i = 0; i < assist.length; i++) {
            assist[i] = 0;
  
        }
        assist[firstNumber] = 1;
    }

    public int firstGen() {

        Random random = new Random();
        return random.nextInt(range);
    }

    public void genInitalPopulation() {
        int[] assist; //auxiliar
        int controller = 0;
        Random rand = new Random();
        int firstNumber = firstGen();
        for (int i = 0; i < quantChromo; i++) {
            controller = 0;
            assist = new int[range];
            initializer(assist, firstNumber);
            for (int j = 0; j < range; j++) {
                controller = 0;
                if (j == 0) {
                    result[i][0] = firstNumber;
                } else {
                    while (controller == 0) {
                        int random = rand.nextInt(range);
                        if (assist[random] == 0) {
                            result[i][j] = random;
                            assist[random] = 1;
                            controller = 1;
                        }

                    }
                }

            }
        }
    }
    public void printFit(){
         for(int i=0;i<quantChromo;i++){
             System.out.println("Soma da linha: " + i + " = " + assistFit[i]);
         }
    }
    
    public void fitness(){
        for(int i=0;i<quantChromo;i++){
            assistFit[i]=0;
            for(int j=0;j<range;j++){
                if(j!=range-1){
                    assistFit[i]+=graph[result[i][j]][result[i][j+1]]; 
                }else{
                    assistFit[i]+=graph[result[i][0]][result[i][range-1]];
                }

            }
        }
    }
}
