package model;

public interface TraderBehaviour {
    void buyOrder();
    void sellOrder();
    void setPricing();
    int getAsset();
    void setAsset(int asset);
    
}
