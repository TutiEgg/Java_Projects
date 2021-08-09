/*    */ package main;
/*    */ 
/*    */ import de.tevOnce.MajaQuery.MajaQuery;
/*    */ import de.tevOnce.MajaQuery.objects.Client;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoopThread
/*    */   implements Runnable
/*    */ {
/*    */   private EventListener eventL;
/*    */   
/*    */   public LoopThread(EventListener eventListen) {
/* 15 */     this.eventL = eventListen;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/*    */     while (true) {
/* 22 */       ArrayList<Client> clients = MajaQuery.connection.getServer().getClientsOnline();
/* 23 */       for (int i = 0; i < clients.size(); i++) {
/* 24 */         if (((Client)clients.get(i)).getIdleTime() > 3600000L || ((!((Client)clients.get(i)).hasHardwareInput() || !((Client)clients.get(i)).hasHardwareOutput()) && ((Client)clients.get(i)).getIdleTime() > 1800000L))
/*    */         {
/*    */ 
/*    */           
/* 28 */           this.eventL.afk(clients.get(i));
/*    */         }
/*    */       } 
/*    */       
/*    */       try {
/* 33 */         Thread.sleep(60000L);
/* 34 */       } catch (InterruptedException interruptedException) {}
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\mmlpv\OneDrive\Desktop\Java programmiert\Tuti_Query.jar!\main\LoopThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */