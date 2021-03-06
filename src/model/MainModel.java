package model;

import java.util.Scanner;


public class MainModel {

    
    public static void main(String[] args) {
        RequestsArray batch = new RequestsArray(10, 0.1f);       
        long clkCheck = System.currentTimeMillis();
        Player user = new Player("boris",1000000);
        while(true){            
            /*if(System.currentTimeMillis() - clkCheck >= 20000){                
                batch.addAndShift();
                batch.decBuyVolume();
                batch.decSellVolume();
                clkCheck = System.currentTimeMillis();
            }*/
            Scanner scan = new Scanner(System.in);
       
                System.out.println("Choose an option: ");
                System.out.println("1 - List offers");
                System.out.println("2 - Add and shift offers");
                System.out.println("3 - Accept offer");
                System.out.println("4 - Display assets"); 
                String input = scan.nextLine();
                int i;
                try {
                    i = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    i = 0;
                }
                switch(i){
                    case 0:
                        break;
                    case 1: 
                        batch.printRequests();
                        break;
                    case 2: 
                        batch.addAndShift();
                        break;
                    case 3:
                        System.out.println("Which offer do you wish to accept");
                        int x = (scan.nextInt()-1);
                        acceptAndUpdate(batch, x, user);
                        break;
                    case 4: 
                        System.out.println("Cash - " + user.getCash());
                        System.out.println("Pork Bellies - " + user.getAsset("Pork Bellies"));
                        System.out.println("Frozen Orange Juice Concentrate - " + user.getAsset("Frozen Orange Juice Concentrate"));
                        System.out.println("Soybeans - " + user.getAsset("Soybeans"));
                        break;
                    case 5:
                        System.out.println("Buy Volume is: " + batch.getBuyVolume() + " Sell Volume is: " + batch.getSellVolume());
                        break;
                }   
            
        }
    }
    
    public static void acceptAndUpdate(RequestsArray array, int loc, Player user){
        if(user.acceptOffer(array.getRequest(loc))==true){
            if(array.getRequest(loc)instanceof BuyRequest){
                array.incBuyVolume();
            }
            else if(array.getRequest(loc)instanceof SellRequest){
                array.incSellVolume();
            }
            array.removeRequest(loc);
        }
    }
}

