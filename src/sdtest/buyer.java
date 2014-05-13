package sdtest;

public class buyer {
    double demand;
    double targetPrice;
    int consumptionRate;       
    int asset = 1000;
    
    public buyer(int initD, double initTP, int initCR){
        demand = initD;
        targetPrice = initTP;
        consumptionRate = initCR;
        
    }
    
    public void setPricing(){
        consumptionRate = asset/100;
        demand = 1000*(Math.exp(-(0.0001*asset)));
        targetPrice = demand;               
    }
    
    public double offer(){
        double offer = targetPrice;
        return offer;
    }
    
    public boolean agree(double offer){ 
        if(offer > targetPrice){
            targetPrice = targetPrice * ((Math.random()*1)+1);
        }
        if(offer < targetPrice){
            targetPrice = targetPrice * (1-(Math.random()*1));            
        }
        //System.out.println("owen TP " + targetPrice + " owen asset " + asset);
        return offer <= targetPrice;        
    }
}
