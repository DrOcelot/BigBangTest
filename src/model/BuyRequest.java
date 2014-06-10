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
    public void buyOrder(BRArray array) { // offer is based on two factors; target price and trying to outbid other buyers,
        int low = array.getLowestTargetPrice();
        offer = (low + targetPrice)/2;
    }
    
    @Override
    public void sellOrder(SRArray nothing) {
        //buyers dont sell
    }

    @Override
    public void setPricing() {// target price is based on: previous purchases from player, and how much comoditiy the buyer has,
        targetPrice = (targetPrice * 105)/100;
        targetPrice = targetPrice * 1;        // also compares his asset with the average buyerasset
    }


    @Override
    public void incAsset(int inc) {
        this.asset = this.asset + inc; 
    }
}
