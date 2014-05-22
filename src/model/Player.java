package model;

public class Player extends Trader{
    float cash =10000;
    int pb; //porkBellies
    int oj; //orangeJuice
    int sb; //soyBeans
    
    float getCash(){
        return cash;
    }
    
    void setCash(float cashIn){
        cash = cashIn;
    }
    
    void incCash(float increment){
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
        }else throw new Error("no such asset");
        
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
        }else throw new Error("no such asset");
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
        }else throw new Error("no such asset");
    }
}
