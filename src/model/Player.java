package model;

public class Player{
    private final String name;
    private float cash;
    private int pb;
    private int oj;
    private int sb;
    
    public Player(String n){
        name = n;
    }
    
    public float getCash(){
        return cash;
    }
    
    public void setCash(float cashIn){
        cash = cashIn;
    }
    
    public void incCash(float increment){
        cash = cash + increment;
    }
   
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

    public void buyFrom() {        
        //check if player has enough cash and Seller has enough asset,
        //player agrees to a seller's offer.
        //decrease player's cash by the offer amount,
        //increase player's particular asset (pb,oj,sb) by the offer amount,
        //decrease seller's assets ???and increase seller's cash???
    }

    public void sellTo() {        
        //check if player has enough asset ???and Buyer has enough cash???,
        //player agrees to a buyer's offer.
        //increase player's cash by the offer amount,
        //decrease player's asset by the offer amount,
        //increse buyers asset, ???decrese buyer's cash???
    }

}
