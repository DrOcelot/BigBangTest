package model;

public class MainModel {
    
    public static void main(String[] args) {
        BRArray buyerBatch = new BRArray("pb", 15);
        SRArray sellerBatch = new SRArray("pb", 15);
        buyerBatch.setupArray(1000, 100);
        buyerBatch.buyOrders();
        System.out.println(buyerBatch.getLowestTargetPrice());
        
        
    }
}

