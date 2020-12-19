/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccp.assignment;

import java.util.concurrent.Semaphore;

//thread extension for passenger
public class Passenger extends Thread{
    Semaphore pnum;
    String pname;
    foyer f;
    ticketstatus t;
    public Passenger(String pname,Semaphore pnum,foyer f,ticketstatus t){//passenger parameters
        this.setName(pname);
        this.pnum=pnum;
        this.f=f;
        this.t=t;
    }

    
     public void run()
    {
        
            try{
                f.enterfoyer(this,pnum);//passenger enters foyer
                //f.ticketmb(this);
                //f.ticketmb(this);
                //Thread.sleep(1000);
                if(pnum.availablePermits()==0){
                    
                System.out.println("100 people entered the foyer, foyer full, please wait");//semaphore countdown reaches 0, which indicates full foyer
                //pnum.release(10);
                Thread.sleep(10000);
                pnum.release(100);
                //f.ticketmb(this);
                }
                //f.ticketmb(this);
                
            }catch(Exception e){}
        
    }
}

