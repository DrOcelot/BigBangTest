package model;

public class Seller extends Trader{
    int sellerAsset=100000;
    
    @Override
    public int getAsset(){
        return sellerAsset;
    }
    @Override
    public void setAsset(int a){
        sellerAsset = a;
    }
    @Override
    public void incAsset(int inc){
        sellerAsset = sellerAsset + inc;
    }
}
