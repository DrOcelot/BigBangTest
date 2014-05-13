package sdtest;

public class SDTest {
    
    public static void main(String[] args) {
        buyer Owen = new buyer(9,0,9,0.2);
        seller Eliza = new seller(10,500,10,0.2);
        
        
        
        while(true){
            Owen.setPricing();
            Eliza.setPricing();
            if(Owen.agree(Eliza.offer())==true){
                System.out.println("Owen agrees to Eliza's offer of £" + Eliza.offer());
                //System.out.println(Eliza.offer());
            } 
            if(Eliza.agree(Owen.offer())==true){
                System.out.println("Eliza agrees to Owen's offer of £" + Owen.offer());
            }
            
        }
    }
    
}
