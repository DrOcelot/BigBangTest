package sdtest;

public class buyer {
    int demand;
    double targetPrice;
    int consumptionRate;
    double marketForce;
    double elasticity;
    
    public buyer(int initD, double initTP, int initCR, double elas){
        demand = initD;
        targetPrice = initTP;
        consumptionRate = initCR;
        elasticity = elas;
        
    }
    
    public void setPricing(){
        marketForce = consumptionRate * demand;
        targetPrice = targetPrice + ((-elasticity*targetPrice)+(elasticity*marketForce));               
    }
    
    public double offer(){
        double offer = targetPrice;
        return offer;
    }
    
    public boolean agree(double offer){ 
        if(offer > targetPrice){
            targetPrice = targetPrice * ((Math.random()*0.05)+1);
        }
        if(offer < targetPrice){
            targetPrice = targetPrice * (1-(Math.random()*0.05));
        }
        System.out.println("owen " + targetPrice);
        return offer <= targetPrice;        
    }
}
