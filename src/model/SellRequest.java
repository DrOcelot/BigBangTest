package model;

public class SellRequest implements TraderBehaviour{
    private final String assetType;
    private int asset;
    private int targetPrice;
    private int offer;

    public SellRequest(String assetType){
        this.assetType = assetType;
    }
    
    public void setTargetPrice(int targetPrice){
        this.targetPrice = targetPrice;
    }
    
    public String getAssetType(){
        return assetType;
    }
    
    @Override
    public void buyOrder() {
    }

    @Override
    public void sellOrder() {
        offer = targetPrice; //Placeholder Logic. 
        //TODO: make seller check all other sellers and own target price.
        //Seller then makes an offer that best fits two rules; meeting target price, undercutting other sell requests. 
    }

    @Override
    public void setPricing() {
        if(asset>0){
            targetPrice = 1000; //placeholder value
            //TODO: TargetPrice will be based on two factors; amount of asset held and what price the player has previously bought at. 
        }else System.out.println("I do not have anything to sell");
    }

    @Override
    public int getAsset() {
            return asset;   
    }

    @Override
    public void setAsset(int asset) {
            this.asset = asset;   
    }

    @Override
    public void incAsset(int inc) {
            asset = asset + inc;   
    }
}
