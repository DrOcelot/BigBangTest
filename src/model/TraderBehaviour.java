package model;

public interface TraderBehaviour {
    public void buyOrder();
    public void sellOrder();
    public void setPricing();
    public int getAsset(String as);
    public void setAsset(String as, int asset);
    public void incAsset(String as, int inc);
    
}
