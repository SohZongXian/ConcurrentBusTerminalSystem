/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccp.assignment;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class waitingareaC {
    public void enterC(Passenger p,Semaphore tC, Semaphore bC){
        try {
            tC.acquire(1);
            System.out.println(p.getName()+ " Entered waiting area, waiting for bus C");//passenger entered designated waiting area
            enterbusC(p,bC);
            if(bC.availablePermits()==0){
                    
                System.out.println("Bus C full with 12 people, departing to Parkhill, opps, muzamil fell out the window");//bus full and departed at regular intervals
                //pnum.release(10);
                //Thread.sleep(10000);
                bC.release(12);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(waitingareaA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public void enterbusC(Passenger p,Semaphore bC){
        try {
            bC.acquire(1);
            System.out.println(p.getName()+ " Entered bus C");//passenger enters bus
        } catch (InterruptedException ex) {
            Logger.getLogger(waitingareaA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
