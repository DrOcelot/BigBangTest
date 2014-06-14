package model;

public class MainModel {
    
    public static void main(String[] args) {
        RequestsArray Batch;
        Batch = new RequestsArray("pb", 15, 1000, 300);
        
        while(true){
           Batch.addAndShift();
        }
        
    }
}

