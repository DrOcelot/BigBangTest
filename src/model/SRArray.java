package model;

import java.util.ArrayList;
import java.util.Random;

public class SRArray {    
    
    private final ArrayList<SellRequest> sellRequests = new ArrayList();
    private final String assetType;
    private final int numberOfElements;
    private int volume = 0;
    private final Random rng = new Random();
    
    public SRArray(String assetType, int numberOfElements){ 
        this.assetType = assetType;
        this.numberOfElements = numberOfElements;
        for(int i = 0; i<numberOfElements; i++){
            sellRequests.add(new SellRequest(assetType));
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
    
    public void setupArray(float mean, float sDev){ //sets teh prignign of te aarray with a ginve standard deviation and mean
        for(int i = 0; i<numberOfElements; i++){
            int price;
            price = (int)(((rng.nextGaussian())*sDev)+mean);
            sellRequests.get(i).setTargetPrice(price);
        }
    }
    
    public void addAndShift(){ //removes the oldest request and adds a new one
        sellRequests.remove(0);
        sellRequests.add(new SellRequest(assetType));
        sellRequests.get(sellRequests.size()).setTargetPrice((int)rng.nextGaussian());
    }
    
    public int getLowestTargetPrice(){
        int low = 1000000000;
        
        for(int i = 0; i<numberOfElements; i++){
            if(low > sellRequests.get(i).getTargetPrice()){
                low = sellRequests.get(i).getTargetPrice();
            }
        }                
        return low;
    }
    
    public int getMeanAsset(){
        int mean;       
        int sum = 0;
        for(int i = 0; i<numberOfElements; i ++){          
           sum = sum + sellRequests.get(i).getAsset();
        }
        mean = sum / numberOfElements;        
        return mean;
    }
    
    public void sellOrders(){
        for(int i = 0; i<numberOfElements; i ++){          
           sellRequests.get(i).sellOrder(this);
        }
    }
    
}
