package model;

import java.util.ArrayList;
import java.util.Random;

public class BRArray {
    
    private final ArrayList<BuyRequest> buyRequests = new ArrayList();
    private final String assetType;
    private final int numberOfElements;
    private int volume = 0 ;
    private final Random rng = new Random(); 

    public int getVolume() {
        return volume;
    }

    public void incVolume() {
        this.volume = volume + 1;
    }
    
    public void decVolume() {
        this.volume = volume - 1;
    }    
    
    public BRArray(String assetType, int numberOfElements){ 
        this.assetType = assetType;
        this.numberOfElements = numberOfElements;
        for(int i = 0; i<numberOfElements; i++){
            buyRequests.add(new BuyRequest(assetType));
        }        
    }
    
    public void setupArray(float mean, float sDev){ //Setup an array of buyrequests with random pricing of a given Standard deviation and mean
        for(int i = 0; i<numberOfElements; i++){
            int price;
            price = (int)(((rng.nextGaussian())*sDev)+mean);
            buyRequests.get(i).setTargetPrice(price);
        }    
    }
    
    public void addAndShift(){//removes the oldest request and creates a new one
        buyRequests.remove(0);
        buyRequests.add(new BuyRequest(assetType));
        buyRequests.get(buyRequests.size()).setTargetPrice((int)rng.nextGaussian());
    }
    
    public int getHighestTargetPrice(){
        int high = 0;
        
        for(int i = 0; i<numberOfElements; i++){
            if(high < buyRequests.get(i).getTargetPrice()){
                high = buyRequests.get(i).getTargetPrice();
            }
        }                
        return high;
    }
    
    public int getMeanAsset(){
        int mean;       
        int sum = 0;
        for(int i = 0; i<numberOfElements; i ++){          
           sum = sum + buyRequests.get(i).getAsset();
        }
        mean = sum / numberOfElements;        
        return mean;
    }
    
    public void buyOrders(){
        for(int i = 0; i<numberOfElements; i ++){          
           buyRequests.get(i).buyOrder(this);
        }
    }
        
}
