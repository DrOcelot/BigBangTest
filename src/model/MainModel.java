package model;

public class MainModel {
    
    public static void main(String[] args) {
        
        Seller testSeller = new Seller();
        Player testPlayer = new Player();
        testPlayer.setCash(2000);
        testPlayer.incCash(20);
        int pig;
        pig = testPlayer.getAsset("sb");
        System.out.println(testPlayer.getCash());
        testSeller.setAsset(1000);
        System.out.println(testSeller.getAsset());
        
    } 
}