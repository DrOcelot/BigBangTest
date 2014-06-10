package model;

public class SellRequest implements TraderBehaviour{
    private final String assetType;
    private int asset;
    private int targetPrice;
    private int offer;

    public SellRequest(String assetType){
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
        return assetType;
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
    
    @Override
    public void buyOrder(BRArray nothing) {
        //sellers dont buy
    }

    @Override
    public void sellOrder(SRArray array) {   //Seller then makes an offer that best fits two rules; meeting target price, undercutting other sell requests.      
        int low  = array.getLowestTargetPrice();
        offer = (low + targetPrice)/2;        
    }

    public void setPricing(SRArray array) {
        targetPrice = targetPrice - ((targetPrice*((20 - array.getVolume())/20))/20);
        targetPrice = targetPrice - ((targetPrice*((asset-array.getMeanAsset())/asset))/20);        
    }
}
