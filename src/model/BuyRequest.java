package model;

public class BuyRequest implements TraderBehaviour{
    private final String assetType;
    private int targetPrice;
    private int asset;
    private int offer;

    public BuyRequest(String assetType){
        this.assetType = assetType;
    }
    
    @Override
    public void setTargetPrice(int targetPrice){
        this.targetPrice = targetPrice;
    }
    
    @Override
    public int getTargetPrice(){
        return targetPrice;
    }

    public String getAssetType(){
        return this.assetType;
    }

    @Override
    public int getAsset() {
        return this.asset;           
    }

    @Override
    public void setAsset(int ast) {        
        this.asset = ast;
    }
    
    @Override
    public void incAsset(int inc) {
        this.asset = this.asset + inc; 
    }
    
    @Override
    public void buyOrder(BRArray array) { // offer is based on two factors; target price and trying to outbid other buyers,
        int high = array.getHighestTargetPrice();        
        offer = (high + targetPrice)/2;       
    }
    
    @Override
    public void sellOrder(SRArray nothing) {
        //buyers dont sell
    }

    public void setPricing(BRArray array) {// target price is based on: previous purchases from player, and how much comoditiy the buyer has,
        targetPrice = targetPrice + ((targetPrice*((20 - array.getVolume())/20))/20);
        targetPrice = targetPrice - ((targetPrice*((asset-array.getMeanAsset())/asset))/20);        // also compares his asset with the average buyerasset
    }
}
