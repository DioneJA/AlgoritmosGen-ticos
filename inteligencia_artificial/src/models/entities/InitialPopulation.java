package models.entities;

import java.util.Random;


public class InitialPopulation {
    
    private final int quantChromo = 200;
    private int[][] result;
    private int range;
    
    
    public InitialPopulation (int range){
        this.range = range;
        this.result = new int [quantChromo][range];
    }

    public void getResult() {
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    
    public void initializer(int[] assist){
        for(int i=0; i<assist.length; i++){
            assist[i] = 0;
        }
    }
    
    public void genInitalPopulation(){
        int[] assist; //auxiliar
        int controller = 0;
        Random rand = new Random();
        for(int i=0; i<quantChromo; i++){
            controller = 0;
            assist = new int[range];
            initializer(assist);
            for(int j=0; j<range; j++){
                while(controller == 0){
                    int random = rand.nextInt(range);
                    if(assist[random] == 0){
                        result[i][j] = random;
                        assist[random] = 1;
                        controller = 1;
                    }
                   
                }
            }
        }
    }
}
