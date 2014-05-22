package sdtest;

public class SDTest {
    
    public static void main(String[] args) {
        buyer Owen = new buyer(9,0,40);
        seller Eliza = new seller(10,5000,40);
        
        
        
        while(true){
            Owen.asset = Owen.asset - Owen.consumptionRate;
            Eliza.asset = Eliza.asset + Eliza.productionRate;
            Owen.setPricing();
            Eliza.setPricing();
            if(Owen.agree(Eliza.offer())==true){
                Owen.asset = Owen.asset +1000;
                Eliza.asset = Eliza.asset - 1000;
                System.out.println("Owen agrees to Eliza's offer of £" + Eliza.offer());
                //System.out.println(Eliza.offer());
            } 
            if(Eliza.agree(Owen.offer())==true){
                Owen.asset = Owen.asset +1000;
                Eliza.asset = Eliza.asset - 1000;
                System.out.println("Eliza agrees to Owen's offer of £" + Owen.offer());
            }
            
        }
    }
    
}
