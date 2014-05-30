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
    
    public void setupArray(float mean, float sDev){
        for(int i = 0; i<numberOfElements; i++){
            int price;
            price = (int)(((rng.nextGaussian())*sDev)+mean);
            buyRequests.get(i).setTargetPrice(price);
        }    
    }
    
    public void addAndShift(){
        buyRequests.remove(0);
        buyRequests.add(new BuyRequest(assetType));        
    }
    
}
