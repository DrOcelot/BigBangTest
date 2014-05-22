package model;

public class Buyer extends Trader{
    int buyerAsset=0;
    
    public int getAsset(){
        return buyerAsset;
    }
    public void setAsset(int a){
        buyerAsset = a;
    }
    @Override
    public void incAsset(int inc){
        buyerAsset = buyerAsset + inc;
    }
}
