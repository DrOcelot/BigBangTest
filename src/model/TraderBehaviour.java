package model;

public interface TraderBehaviour {

    public void buyOrder(BRArray i);
    public void sellOrder(SRArray i);
    public int getTargetPrice();
    public int getAsset();
    public void setAsset(int asset);
    public void incAsset(int inc);
    
}
