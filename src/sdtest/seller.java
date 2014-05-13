package sdtest;

public class seller {
    int supply;
    double targetPrice;
    int productionRate;
    
    public seller(int initS, int initTP, int initPR){
        supply = initS;
        targetPrice = initTP;
        productionRate = initPR;
        
    }
    
    public void setPricing(){
        supply = supply + (((int)(Math.random() * 11)) - 5);
        productionRate = productionRate + (((int)(Math.random() * 11)) - 5);
        double marketForce = Math.atan((supply+productionRate)*0.01);
        marketForce = marketForce +((Math.PI)/2);
        marketForce = 2*(marketForce/Math.PI);
        //System.out.println(marketForce);
        
    }
    
    public double offer(){
        double offer = targetPrice;
        return offer;
    }
    
    public boolean agree(double offer){ 
        if(offer < targetPrice){
            targetPrice = targetPrice * (1-(Math.random()*0.1));
            targetPrice = targetPrice + Math.atan(targetPrice);
        }
        if(offer > targetPrice){
            targetPrice = targetPrice * ((Math.random()*0.1)+1);
        }
        //System.out.println("eliza" + targetPrice);
        return offer >= targetPrice;    
    }
}
