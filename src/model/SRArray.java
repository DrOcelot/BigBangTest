package model;

import java.util.ArrayList;

public class SRArray {    
    
    ArrayList<SellRequest> sellRequests = new ArrayList();
    String assetType;
    int numberOfElements;
    
    public SRArray(String assetType, int numberOfElements){ 
        this.assetType = assetType;
        this.numberOfElements = numberOfElements;
        for(int i = 0; i<numberOfElements; i++){
            sellRequests.add(new SellRequest(assetType));
        }        
    }
    
    public void setupArray(float mean, float sDev){
        //TODO each element of the list must be assigned a target price that together fits a set standard deviation and mean
    }
    
    public void addAndShift(){
        sellRequests.remove(0);
        sellRequests.add(new SellRequest(assetType));        
    }
    
}
