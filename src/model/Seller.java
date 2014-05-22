package model;

public class Seller extends Trader implements TraderBehaviour{
    int sellerAsset=100000;
    String assetType;
    
    Seller(String as){
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
