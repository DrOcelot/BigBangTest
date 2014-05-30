package model;

public class BuyRequest implements TraderBehaviour{
    private final String assetType;
    private int targetPrice;
    private int asset;
    private int offer;

    public BuyRequest(String assetType){
        this.assetType = assetType;
    }
    
    public void setTargetPrice(int targetPrice){
        this.targetPrice = targetPrice;
    }

    public String getAssetType(){
        return this.assetType;
    }
    
    @Override
    public void buyOrder() {
        offer = targetPrice; //Placeholder logic
        // offer is based on two factors; target price and trying to outbid other buyers,
    }

    @Override
    public void sellOrder() {
        //buyers dont sell
    }

    @Override
    public void setPricing() {
        targetPrice = 1000; //placeholder value        
        // target price is based on: previous purchases from player, and how much comoditiy the buyer has,
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
}
