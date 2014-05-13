package sdtest;

public class buyer {
    int demand;
    double targetPrice;
    int consumptionRate;
    
    public buyer(int initD, int initTP, int initCR){
        demand = initD;
        targetPrice = initTP;
        consumptionRate = initCR;
        
    }
    
    public void setPricing(){
        demand = demand + (((int)(Math.random() * 11)) - 5);
        consumptionRate = consumptionRate + (((int)(Math.random() * 11)) - 5);
        double marketForce = Math.atan((demand+consumptionRate)*0.01);
        marketForce = marketForce +((Math.PI)/2);
        marketForce = 2*(marketForce/Math.PI);
        
    }
    
    public double offer(){
        double offer = targetPrice;
        return offer;
    }
    
    public boolean agree(double offer){ 
        if(offer > targetPrice){
            targetPrice = targetPrice * ((Math.random()*0.1)+1);
        }
        if(offer < targetPrice){
            targetPrice = targetPrice * (1-(Math.random()*0.1));
        }
        //System.out.println("owen " + targetPrice);
        return offer <= targetPrice;        
    }
}
