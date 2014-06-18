package model;

import java.util.LinkedList;
import java.util.Random;

public class RequestsArray {

    private final LinkedList<Request> Requests = new LinkedList();
    private final String assetType;
    private final int numberOfElements;
    private int buyVolume = 0;
    private int sellVolume = 0;
    private final Random rng = new Random();
    private final float sDev;
    private final float meanPrice;
    private int high;
    private int low;
    
    public RequestsArray(String assetType, int numberOfElements, float meanPrice, float sDev) {
        this.sDev = sDev;
        this.meanPrice = meanPrice;
        this.assetType = assetType;
        this.numberOfElements = numberOfElements;
        for(int i = 0; i<numberOfElements; i++){
            int targetPrice;
            targetPrice = (int)(((rng.nextGaussian())*sDev)+meanPrice);
            int sORb = rng.nextInt(2);
            
            if(sORb == 0){
                int ass = (100*(rng.nextInt(4)+1));
                Requests.add(new SellRequest(assetType, targetPrice, ass));
            }
            if(sORb == 1){
                int ass = (100*(rng.nextInt(4)+1));
                Requests.add(new BuyRequest(assetType, targetPrice, ass));
            }        
        }
        lowestTargetPrice();
        highestTargetPrice();
    }
    
    public void addAndShift(){ //removes the oldest request and adds a new one
        Requests.remove(0);
        int targetPrice;
        targetPrice = (int)(((rng.nextGaussian())*sDev)+meanPrice);
        int sORb = rng.nextInt(2);
        if(sORb==0){
            int ass = (100*(rng.nextInt(4)+1));
            Requests.add(new SellRequest(assetType, targetPrice, ass));
        }
        if(sORb==1){
            int ass = (100*(rng.nextInt(4)+1));
            Requests.add(new BuyRequest(assetType, targetPrice, ass));
        }
        System.out.println(Requests.get(numberOfElements-1));
        lowestTargetPrice();
        highestTargetPrice();
    }
    
    public int getHigh(){
        return high;
    }
    
    public int getLow(){
        return low;
    }
        
    public int getSellVolume() {
        return sellVolume;
    }
    
    public int getBuyVolume() {
        return buyVolume;
    }

    public void incBuyVolume() {
        this.buyVolume = buyVolume + 1;
    }
    
    public void decBuyVolume() {
        this.buyVolume = buyVolume - 1;
    }
    
    public void incSellVolume() {
        this.buyVolume = buyVolume + 1;
    }
    
    public void decSellVolume() {
        this.sellVolume = sellVolume - 1;
    }
    
    private void lowestTargetPrice(){
        if (Requests.isEmpty()) {
              low =  0;
        }
        
        int lowest = Requests.get(0).getTargetPrice();
        
        for(int i = 0; i<numberOfElements; i++){
            if(lowest > Requests.get(i).getTargetPrice()){
                lowest = Requests.get(i).getTargetPrice();
            }
        }                
        low = lowest;
    }
    
    private void highestTargetPrice(){
        if (Requests.isEmpty()) {
              high = 0;
        }
        
        int highest = Requests.get(0).getTargetPrice();
        
        for(int i = 0; i<numberOfElements; i++){
            if(highest < Requests.get(i).getTargetPrice()){
                highest = Requests.get(i).getTargetPrice();
            }
        }                
        high = highest;
    }
}
