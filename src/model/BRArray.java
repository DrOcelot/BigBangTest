package model;

import java.util.ArrayList;
import java.util.Random;

public class BRArray {
    
    ArrayList<BuyRequest> buyRequests = new ArrayList();
    String assetType;
    int numberOfElements;
    Random rng = new Random(); 
    
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
    
    public int getLowestTargetPrice(){
        int low = 1000000000;
        
        for(int i = 0; i<numberOfElements; i++){
            if(low > buyRequests.get(i).getTargetPrice()){
                low = buyRequests.get(i).getTargetPrice();
            }
        }                
        return low;
    }
    
}
