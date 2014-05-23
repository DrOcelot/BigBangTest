package model;

public class Seller extends Trader implements TraderBehaviour{

    Seller(String as){
        assetType = as;
    }
    
    @Override
    public void buyOrder() {
        throw new Error("Sellers shouldn't be buying anything");
    }

    @Override
    public void sellOrder() {
        offer = targetPrice; //Placeholder Logic. 
        //TODO: make seller check all other sellers and own target price.
        //Seller then makes an offer that best fits two rules; meeting target price, undercutting other sellers.
    }

    @Override
    public void setPricing() {
        if(sellerAsset>0){
            targetPrice = 1000; //placeholder value
            //TODO: TargetPrice will be based on two factors; amount of asset held and what price the player has previously bought at.
        }else System.out.println("I do not have anything to sell");
    }

    @Override
    public int getAsset(String as) {
        if(as.equals(assetType)){
            return sellerAsset;
        } else throw new Error("The seller does not sell that asset");     
    }

    @Override
    public void setAsset(String as, int asset) {
        if(as.equals(assetType)){
            sellerAsset = asset;
        } else throw new Error("The seller does not sell that asset");    
    }

    @Override
    public void incAsset(String as, int inc) {
        if(as.equals(assetType)){
            sellerAsset = sellerAsset + inc;
        } else throw new Error("The seller does not sell that asset");    
    }
}
