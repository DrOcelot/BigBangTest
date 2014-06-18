package model;

public class SellRequest implements Request{
    private final String assetType;
    private final int asset;
    private int targetPrice;
    private int offer;

    public SellRequest(String assetType, int targetPrice, int asset){
        this.assetType = assetType;
        this.targetPrice = targetPrice;
        this.asset = asset;
    }
        
    @Override
    public int getTargetPrice(){
        return targetPrice;
    }
    
    public String getAssetType(){
        return assetType;
    }
          
    @Override
    public void order(RequestsArray requests) {   //Seller then makes an offer that best fits two rules; meeting target price, undercutting other sell requests.      
        int low  = requests.getLow();
        offer = (low + targetPrice)/2;        
    }

    /*public void setPricing(SRArray array) {
        targetPrice = targetPrice - ((targetPrice*((20 - array.getVolume())/20))/20);
        targetPrice = targetPrice - ((targetPrice*((asset-array.getMeanAsset())/asset))/20);        
    }*/
}
