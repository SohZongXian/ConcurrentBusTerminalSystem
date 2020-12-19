/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccp.assignment;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class waitingareaA {
    
    public void enterA(Passenger p,Semaphore tA, Semaphore bA){
        try {
            tA.acquire(1);
            System.out.println(p.getName()+ " Entered waiting area, waiting for bus A");//passenger entered designated waiting area
            enterbusA(p,bA);
            if(bA.availablePermits()==0){
                    
                System.out.println("Bus A full with 12 people, departing to Asia Pacific University");//bus full and departed at regular intervals
                //pnum.release(10);
                //Thread.sleep(10000);
                bA.release(12);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(waitingareaA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public void enterbusA(Passenger p,Semaphore bA){
        try {
            bA.acquire(1);
            System.out.println(p.getName()+ " Entered bus A");//passenger enters bus
        } catch (InterruptedException ex) {
            Logger.getLogger(waitingareaA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
