package model;

public class Buyer extends Trader implements TraderBehaviour{
    int buyerAsset=0;
    String assetType;
    
    Buyer(String as){
        assetType = as;
    }

    @Override
    public void buyOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sellOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPricing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAsset(String as) {
        if(as.equals(assetType)){
            return buyerAsset;
        } else throw new Error("the buyer does not buy that asset");        
    }

    @Override
    public void setAsset(String as, int asset) {
        if(as.equals(assetType)){
            buyerAsset = asset;
        } else throw new Error("the buyer does not buy that asset");  
    }

    @Override
    public void incAsset(String as, int inc) {
        if(as.equals(assetType)){
            buyerAsset = buyerAsset + inc;
        } else throw new Error("the buyer does not buy that asset");  
    }
}
