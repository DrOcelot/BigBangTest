package model;

import java.util.LinkedList;
import java.util.Random;

public class SRArray {    
    
    private final LinkedList<SellRequest> sellRequests = new LinkedList();
    private final String assetType;
    private final int numberOfElements;
    private int volume = 0;
    private final Random rng = new Random();
    private final float sDev;
    private final float meanPrice;
    
    public SRArray(String assetType, int numberOfElements, float meanPrice, float sDev){ 
        this.sDev = sDev;
        this.meanPrice = meanPrice;
        this.assetType = assetType;
        this.numberOfElements = numberOfElements;
        for(int i = 0; i<numberOfElements; i++){
            int targetPrice;
            targetPrice = (int)(((rng.nextGaussian())*sDev)+meanPrice);
            sellRequests.add(new SellRequest(assetType, targetPrice));
        }
        for(int i = 0; i<numberOfElements; i ++){          
           sellRequests.get(i).sellOrder(this);
        }
    }
    
    public int getVolume() {
        return volume;
    }

    public void incVolume() {
        this.volume = volume + 1;
    }
    
    public void decVolume() {
        this.volume = volume - 1;
    }
        
    public void addAndShift(){ //removes the oldest request and adds a new one
        sellRequests.remove(0);
        int targetPrice;
        targetPrice = (int)(((rng.nextGaussian())*sDev)+meanPrice);
        sellRequests.add(new SellRequest(assetType, targetPrice));
        sellRequests.get(sellRequests.size()).sellOrder(this);
    }
    
    public int getLowestTargetPrice(){
        if (sellRequests.isEmpty()) {
              return 0;
        }
        
        int low = sellRequests.get(0).getTargetPrice();
        
        for(int i = 0; i<numberOfElements; i++){
            if(low > sellRequests.get(i).getTargetPrice()){
                low = sellRequests.get(i).getTargetPrice();
            }
        }                
        return low;
    }
    
    public int getMeanAsset(){
        int meanAsset;       
        int sum = 0;
        for(int i = 0; i<numberOfElements; i ++){          
           sum = sum + sellRequests.get(i).getAsset();
        }
        meanAsset = sum / numberOfElements;        
        return meanAsset;
    }    
}
