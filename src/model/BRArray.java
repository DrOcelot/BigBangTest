package model;

import java.util.LinkedList;
import java.util.Random;

public class BRArray {
    
    private final LinkedList<BuyRequest> buyRequests = new LinkedList();
    private final String assetType;
    private final int numberOfElements;
    private int volume = 0 ;
    private final Random rng = new Random();
    private final float mean;
    private final float sDev;

    public int getVolume() {
        return volume;
    }

    public void incVolume() {
        this.volume = volume + 1;
    }
    
    public void decVolume() {
        this.volume = volume - 1;
    }    
    
    public BRArray(String assetType, int numberOfElements, float mean, float sDev){ 
        this.sDev = sDev;
        this.mean = mean;
        this.assetType = assetType;
        this.numberOfElements = numberOfElements;
        for(int i = 0; i<numberOfElements; i++){
            int targetPrice;
            targetPrice = (int)(((rng.nextGaussian())*sDev)+mean);
            buyRequests.add(new BuyRequest(assetType, targetPrice));
        }        
    }
        
    public void addAndShift(){//removes the oldest request and creates a new one
        buyRequests.remove(0);
        int targetPrice;
        targetPrice = (int)(((rng.nextGaussian())*sDev)+mean);
        buyRequests.add(new BuyRequest(assetType, targetPrice));
        buyRequests.get(buyRequests.size()).buyOrder(this);
    }
    
    public int getHighestTargetPrice(){
        if (buyRequests.isEmpty()) {
              return 0;
        }
        
        int high = buyRequests.get(0).getTargetPrice();
        
        for(int i = 0; i<numberOfElements; i++){
            if(high < buyRequests.get(i).getTargetPrice()){
                high = buyRequests.get(i).getTargetPrice();
            }
        }                
        return high;
    }
    
    public int getMeanAsset(){
        int meanAsset;       
        int sum = 0;
        for(int i = 0; i<numberOfElements; i ++){          
           sum = sum + buyRequests.get(i).getAsset();
        }
        meanAsset = sum / numberOfElements;        
        return meanAsset;
    }
    
    public void buyOrders(){ //setup the buyOrders of this array, buyOrder makes a final offer based on the offers of the other buyers
        for(int i = 0; i<numberOfElements; i ++){          
           buyRequests.get(i).buyOrder(this);
        }
    }
        
}
