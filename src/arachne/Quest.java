
package arachne;

public class Quest {
   private String title; 
   private int reqSilk; 
   private double popInc; 
   
   private boolean questDone = false; 
   
   public Quest(String t, int r, int p) {
       this.title = t; 
       this.reqSilk = r;
       this.popInc = p; 
   }
   
   public String getTitle() { 
       return this.title; 
   }
   public int getReqSilk() {
       return this.reqSilk; 
   }
   public double getPopInc() {
       return this.popInc; 
   }
   
   public void complete() {
       questDone = true; 
   }
}
