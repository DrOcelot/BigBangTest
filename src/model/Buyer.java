package model;

public class Buyer extends Trader implements TraderBehaviour{

    Buyer(String as){
        assetType = as;
    }

    @Override
    public void buyOrder() {
        offer = targetPrice; //Placeholder logic
        // offer is based on two factors; target price and trying to outbid other buyers, ???and cash???
    }

    @Override
    public void sellOrder() {
        throw new Error("Buyers shouldn't be selling anything");
    }

    @Override
    public void setPricing() {
        targetPrice = 1000; //placeholder value        
        // target price is based on: previous purchases from player, and how much comoditiy the buyer has, ???and cash???
    }

    @Override
    public int getAsset(String as) {
        if(as.equals(assetType)){
            return asset;
        } else throw new Error("The buyer does not buy that asset");        
    }

    @Override
    public void setAsset(String as, int ast) {
        if(as.equals(assetType)){
            this.asset = ast;
        } else throw new Error("The buyer does not buy that asset");  
    }

    @Override
    public void incAsset(String as, int inc) {
        if(as.equals(assetType)){
            asset = asset + inc;
        } else throw new Error("The buyer does not buy that asset");  
    }
}
