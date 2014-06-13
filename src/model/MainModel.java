package model;

public class MainModel {
    
    public static void main(String[] args) {
        BRArray buyerBatch;
        buyerBatch = new BRArray("pb", 15, 1000, 300);
        System.out.println("highest price: " + buyerBatch.getHighestTargetPrice());  
        
        
    }
}

