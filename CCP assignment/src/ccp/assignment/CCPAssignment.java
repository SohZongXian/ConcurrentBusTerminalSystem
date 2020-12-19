package ccp.assignment;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CCPAssignment {


    public static void main(String[] args) {
        Semaphore pnum=new Semaphore(100);//semaphore declaration 
        
        foyer f=new foyer();//
        Passenger p[]=new Passenger[150];//creating 150 passenger threads 
        ticketstatus t=new ticketstatus(false,0);
        
        for (int i=0;i<p.length;i++)
        {
            p[i]=new Passenger("Passenger-"+Integer.toString(i),pnum,f,t);
        }
        for (int i=0;i<p.length;i++)
        {
            p[i].start();//starting all threads 
        }
       
        for(int i=0;i<p.length;i++){
            try {
                p[i].join();//ending all threads 
            } catch (InterruptedException ex) {
                Logger.getLogger(CCPAssignment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
       

 

        
        
        
    
}
}
