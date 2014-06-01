package model;

public interface TraderBehaviour {

    public void buyOrder();
    public void sellOrder();
    public void setPricing();
    public int getAsset();
    public void setAsset(int asset);
    public void incAsset(int inc);
    
}
