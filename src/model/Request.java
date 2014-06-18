package model;

public interface Request {

    public void order(RequestsArray requests);
    public int getTargetPrice();    
    public String getAssetType();
}
