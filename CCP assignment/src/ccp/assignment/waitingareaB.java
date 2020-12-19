/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccp.assignment;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class waitingareaB {
    public void enterB(Passenger p,Semaphore tB, Semaphore bB){
        try {
            tB.acquire(1);
            System.out.println(p.getName()+ " Entered waiting area, waiting for bus B");//passenger entered designated waiting area
            enterbusB(p,bB);
            if(bB.availablePermits()==0){
                    
                System.out.println("Bus B full with 12 people, departing to LRT Bukit Jalil");//bus full and departed at regular intervals
                //pnum.release(10);
                //Thread.sleep(10000);
                bB.release(12);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(waitingareaA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public void enterbusB(Passenger p,Semaphore bB){
        try {
            bB.acquire(1);
            System.out.println(p.getName()+ " Entered bus B");//passenger enters bus
        } catch (InterruptedException ex) {
            Logger.getLogger(waitingareaA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
