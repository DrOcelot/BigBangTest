package model;

public class MainModel {
    String name;
    Player user = new Player(name);
    
    public static void main(String[] args) {
        RequestsArray batch = new RequestsArray(20, 400, 300, 100);
        batch.printRequests();
        long clkCheck = System.currentTimeMillis();
        while(true){            
            if(System.currentTimeMillis() - clkCheck >= 20000){                
                batch.addAndShift();
                batch.decBuyVolume();
                batch.decSellVolume();
                clkCheck = System.currentTimeMillis();
            }
        }
    }
    
    public void acceptAndUpdate(RequestsArray array, int loc){
        user.acceptOffer(array.getRequest(loc));
        if(array.getRequest(loc)instanceof BuyRequest){
            array.incBuyVolume();
        }
        if(array.getRequest(loc)instanceof SellRequest){
            array.incSellVolume();
        }
        array.removeRequest(loc);
    }

}

