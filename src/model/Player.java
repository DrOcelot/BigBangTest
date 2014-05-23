package model;

public class Player extends Trader implements TraderBehaviour{
    String name;
    
    Player(String n){
        name = n;
    }
    
    float getCash(){
        return cash;
    }
    
    void setCash(float cashIn){
        cash = cashIn;
    }
    
    void incCash(float increment){
        cash = cash + increment;
    }
   
    @Override
    public int getAsset(String as){
        if ("pb".equals(as)){
            return pb;
        }
        if ("oj".equals(as)){
            return oj;
        }
        if ("sb".equals(as)){
            return sb;
        }else throw new Error("No such asset");
        
    }
    
    @Override
    public void setAsset(String as, int a){
        if ("pb".equals(as)){
            pb = a;
        }
        if ("oj".equals(as)){
            oj = a;
        }
        if ("sb".equals(as)){
            sb = a;
        }else throw new Error("No such asset");
    }

    public void incAsset(String as, int inc){
        if ("pb".equals(as)){
            pb = pb+inc;
        }
        if ("oj".equals(as)){
            oj = oj+inc;
        }
        if ("sb".equals(as)){
            sb = sb+inc;
        }else throw new Error("No such asset");
    }

    @Override
    public void buyOrder() {        
        //check if player has enough cash and Seller has enough asset,
        //player agrees to a seller's offer.
        //decrease player's cash by the offer amount,
        //increase player's particular asset (pb,oj,sb) by the offer amount,
        //decrease seller's assets ???and increase seller's cash???
    }

    @Override
    public void sellOrder() {        
        //check if player has enough asset ???and Buyer has enough cash???,
        //player agrees to a buyer's offer.
        //increase player's cash by the offer amount,
        //decrease player's asset by the offer amount,
        //increse buyers asset, ???decrese buyer's cash???
    }

    @Override
    public void setPricing() {
        throw new Error("Players shouldn't be able to 'setPricing()'");
    }

}
