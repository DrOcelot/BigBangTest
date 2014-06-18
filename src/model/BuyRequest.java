package model;

public class BuyRequest implements Request{
    private final String assetType;
    private int targetPrice;
    private final int asset;
    private int offer;

    public BuyRequest(String assetType, int targetPrice, int asset){
        this.assetType = assetType;
        this.targetPrice = targetPrice;
        this.asset = asset;
    }
        
    @Override
    public int getTargetPrice(){
        return targetPrice;
    }

    public String getAssetType(){
        return this.assetType;
    }
    
    @Override
    public void order(RequestsArray requests) { // offer is based on two factors; target price and trying to outbid other buyers,
        int high = requests.getHigh();        
        offer = (high + targetPrice)/2;       
    }

    /*public void setPricing(BRArray array) {// target price is based on: previous purchases from player, and how much comoditiy the buyer has,
        targetPrice = targetPrice + ((targetPrice*((20 - array.getVolume())/20))/20);
        targetPrice = targetPrice - ((targetPrice*((asset-array.getMeanAsset())/asset))/20);        // also compares his asset with the average buyerasset
    }*/
}
