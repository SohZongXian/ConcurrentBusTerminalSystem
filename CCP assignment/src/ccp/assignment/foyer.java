
package ccp.assignment;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class foyer {
    int r;
    int a;
    int b;
    int toiletbreak;
    int machinecheck;
    waitingareaA w1=new waitingareaA();
    waitingareaB w2=new waitingareaB();
    waitingareaC w3=new waitingareaC();
    Semaphore tA = new Semaphore(10);
    Semaphore tB = new Semaphore(10);
    Semaphore tC = new Semaphore(10);
    Semaphore bA = new Semaphore(12);
    Semaphore bB = new Semaphore(12);
    Semaphore bC = new Semaphore(12);
    
       public void enterfoyer(Passenger p,Semaphore pnum){// passenger enters foyer
         try{
                int a=new Random().nextInt(5);
                int r = new Random().nextInt(2);
                
                if(r==0){
                    
                    pnum.acquire(1);
                    System.out.println(p.getName()+ " entered foyer through west entrance");//passenger enters through different entrance
                    Thread.sleep(1000+(a*1000));
                    ticketmb(p);
                    
                    
                }else{
                    
                    pnum.acquire(1);
                    System.out.println(p.getName()+ " entered foyer through east entrance");//passenger enters through different entrance
                    Thread.sleep(1000+(a*1000));
                    ticketmb(p);
                    
                    
                }
            }catch(Exception e){}
         
         
        
         
    }
     synchronized public void ticketmb(Passenger p){
         int c=new Random().nextInt(2);
         int d=new Random().nextInt(3);
         
         try{
             Thread.currentThread().sleep(1000+(a*1000));
             int b=new Random().nextInt(3);
             if(b==0){
                 System.out.println(p.getName()+ " is buying ticket from booth A");//passenger buying ticket from booth
                 int toiletbreak=new Random().nextInt(2);
                 if(toiletbreak==1){
                     System.out.println(p.getName()+ " staff is on toilet break, please hold");//staff on toilet break
                     Thread.sleep(3000);
                 }
                 System.out.println("Staff from booth A says:"+ p.getName()+ " ticket bought");
                 if(c==0){//setting ticket parameter values for different thread 
                     p.t.ticketcheck=true;
                     p.t.waitareacheck=d;
                 }else{
                     p.t.ticketcheck=false;
                     
                 }
                 ticketinspector(p);
                 
                 
             }else if(b==1){
                 System.out.println(p.getName()+ " is buying ticket from booth B");//passenger buying ticket from booth
                 int toiletbreak=new Random().nextInt(2);
                 if(toiletbreak==1){
                     System.out.println(p.getName()+ " staff is on toilet break, please hold");//staff on toilet break
                     Thread.sleep(3000);
                 }
                 System.out.println("Staff from booth B says:"+ p.getName()+ " ticket bought");
                 if(c==0){//setting ticket parameter values for different thread 
                     p.t.ticketcheck=true;
                     p.t.waitareacheck=d;
                 }else{
                     p.t.ticketcheck=false;
                     
                 }
                 ticketinspector(p);
             }else{
                 
                 System.out.println(p.getName()+ " is using ticket machine");//ticket machine 
                 int machinecheck=new Random().nextInt(2);
                 if(machinecheck==0){
                    System.out.println(p.getName()+ " ticket bought");
                    if(c==0){
                     p.t.ticketcheck=true;
                     p.t.waitareacheck=d;
                 }else{
                     p.t.ticketcheck=false;
                     
                 }
                    ticketinspector(p);
                    
                 }else{
                     System.out.println(p.getName()+ " machine broke down, please retry or move to ticketing booths");//ticket machine broke down
                     ticketmb(p);
                     
                     
                 }
             
             }
         }catch(Exception e){
                     
                     }
         
     }
     synchronized public void ticketinspector(Passenger p){
         System.out.println("Ticket inspector is checking the ticket of " + p.getName());//ticket inspector checking ticket
         if(p.t.ticketcheck==true){
             if(p.t.waitareacheck==0){
                 System.out.println("Ticket inspector says: " + p.getName() + "please enter waiting area A, your destination is Asia Pacific University");//ticket inspector leading to destination
                 w1.enterA(p,tA,bA);
                 if(tA.availablePermits()==0){
                    
                    System.out.println("10 people entered the waiting area, its full, please enter bus A");//waiting area full
                     try {
                         //pnum.release(10);
                         Thread.sleep(10000);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(foyer.class.getName()).log(Level.SEVERE, null, ex);
                     }
                tA.release(10);
             }
             }else if(p.t.waitareacheck==1){
                 System.out.println("Ticket inspector says: " + p.getName() + "please enter waiting area B, your destination is LRT Bukit Jalil");
                 w2.enterB(p,tB,bB);
                 if(tB.availablePermits()==0){
                    
                    System.out.println("10 people entered the waiting area, its full, please enter bus B");//waiting area full
                     try {
                         //pnum.release(10);
                         Thread.sleep(10000);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(foyer.class.getName()).log(Level.SEVERE, null, ex);
                     }
                tB.release(10);
             }
                 
             }else{
                 System.out.println("Ticket inspector says: " + p.getName() + "please enter waiting area B, your destination is Parkhill");
                 w3.enterC(p,tC,bC);
                 if(tC.availablePermits()==0){
                    
                    System.out.println("10 people entered the waiting area, its full, please enter bus C");//waiting area full
                     try {
                         //pnum.release(10);
                         Thread.sleep(10000);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(foyer.class.getName()).log(Level.SEVERE, null, ex);
                     }
                tC.release(10);
             }
             }
         }else{
             System.out.println("Ticket inspector says, ticket broken, please rebuy a ticket, "+p.getName());//ticket broken 
             ticketmb(p);
         }
         
     }
     
    
}
