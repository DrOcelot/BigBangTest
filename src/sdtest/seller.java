package sdtest;

public class seller {
    double supply;
    double targetPrice;
    int productionRate;   
    int asset = 100000;
    
    public seller(int initS, double initTP, int initPR){
        supply = initS;
        targetPrice = initTP;
        productionRate = initPR;        
        
    }
    
    public void setPricing(){
        productionRate = 1000000/asset;
        supply = (10*(Math.exp((0.0001*asset))))-100;
        targetPrice = (1000000/supply);             
    }
    
    public double offer(){
        double offer = targetPrice;
        return offer;
    }
    
    public boolean agree(double offer){ 
        if(offer < targetPrice){
            targetPrice = targetPrice * (1-(Math.random()*1));
            
        }
        if(offer > targetPrice){
            targetPrice = targetPrice * ((Math.random()*1)+1);            
        }
        System.out.println("eliza TP " + targetPrice + " eliza asset " + asset + " eliza supply " + supply);
        return offer >= targetPrice;    
    }
}
