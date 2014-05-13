package sdtest;

public class SDTest {
    
    public static void main(String[] args) {
        buyer Owen = new buyer(10,90,10);
        seller Eliza = new seller(10,110,10);
        
        
        
        while(true){
            Owen.setPricing();
            Eliza.setPricing();
            if(Owen.agree(Eliza.offer())==true){
                //System.out.println("Owen agrees to Eliza's offer of £" + Eliza.offer());
                System.out.println(Eliza.offer());
            } 
            if(Eliza.agree(Owen.offer())==true){
                //System.out.println("Eliza agrees to Owen's offer of £" + Owen.offer());
            }
            
        }
    }
    
}
