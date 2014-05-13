package sdtest;

public class seller {
    int supply;
    double targetPrice;
    int productionRate;
    double marketForce;
    double elasticity;
    
    public seller(int initS, double initTP, int initPR, double elas){
        supply = initS;
        targetPrice = initTP;
        productionRate = initPR;
        elasticity = elas;
        
    }
    
    public void setPricing(){
        marketForce = productionRate * supply;
        targetPrice = targetPrice + ((-elasticity*targetPrice)+(elasticity*marketForce));             
    }
    
    public double offer(){
        double offer = targetPrice;
        return offer;
    }
    
    public boolean agree(double offer){ 
        if(offer < targetPrice){
            targetPrice = targetPrice * (1-(Math.random()*0.05));
            
        }
        if(offer > targetPrice){
            targetPrice = targetPrice * ((Math.random()*0.05)+1);
        }
        System.out.println("eliza " + targetPrice);
        return offer >= targetPrice;    
    }
}
