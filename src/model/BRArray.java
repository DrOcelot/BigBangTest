package model;

import java.util.ArrayList;

public class BRArray {
    
    ArrayList<BuyRequest> buyRequests = new ArrayList();
    String assetType;
    int numberOfElements;
    
    public BRArray(String assetType, int numberOfElements){ 
        this.assetType = assetType;
        this.numberOfElements = numberOfElements;
        for(int i = 0; i<numberOfElements; i++){
            buyRequests.add(new BuyRequest(assetType));
        }        
    }
    
    public void setupArray(float mean, float sDev){
        //TODO each element of the list must be assigned a target price that together fits a set standard deviation and mean        
    }
    
    public void addAndShift(){
        buyRequests.remove(0);
        buyRequests.add(new BuyRequest(assetType));        
    }
    
}
