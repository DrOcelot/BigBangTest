package model;

public class Trader implements TraderBehaviour {
    int asset;
    
    @Override
    public void buyOrder() {
    }

    @Override
    public void sellOrder() {
    }

    @Override
    public void setPricing() {
    }

    @Override
    public int getAsset() {
        return asset;
    }

    @Override
    public void setAsset(int asset) {
    }

    @Override
    public void incAsset(int inc) {
        asset = asset + inc;
    }
    
}
