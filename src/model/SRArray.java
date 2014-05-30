package model;

import java.util.ArrayList;
import java.util.Random;

public class SRArray {    
    
    ArrayList<SellRequest> sellRequests = new ArrayList();
    String assetType;
    int numberOfElements;
    Random rng = new Random();
    
    public SRArray(String assetType, int numberOfElements){ 
        this.assetType = assetType;
        this.numberOfElements = numberOfElements;
        for(int i = 0; i<numberOfElements; i++){
            sellRequests.add(new SellRequest(assetType));
        }        
    }
    
    public void setupArray(float mean, float sDev){
        for(int i = 0; i<numberOfElements; i++){
            int price;
            price = (int)(((rng.nextGaussian())*sDev)+mean);
            sellRequests.get(i).setTargetPrice(price);
        }
    }
    
    public void addAndShift(){
        sellRequests.remove(0);
        sellRequests.add(new SellRequest(assetType));        
    }
    
}
