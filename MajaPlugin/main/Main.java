/*    */ package main;
/*    */ 
/*    */ import de.tevOnce.MajaQuery.MajaQuery;
/*    */ import de.tevOnce.MajaQuery.plugin.Plugin;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Main
/*    */   extends Plugin
/*    */ {
/*    */   private Thread loopThread;
/*    */   public EventListener evl;
/*    */   public Prefix prefix;
/*    */   public Levelsystem levelsystem;
/*    */   public Datenbank datenbank;
/*    */   public Clientinfos clientinfos;
/*    */   public Connection con;
/*    */   private static Main main;
/*    */   
/*    */   public void disable() {
/*    */     try {
/* 31 */       this.loopThread.interrupt();
/*    */     }
/* 33 */     catch (Exception exception) {}
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void enable() {
/* 40 */     main = this;
/*    */     
/* 42 */     this.evl = new EventListener(this);
/* 43 */     this.prefix = new Prefix();
/*    */     
/* 45 */     MajaQuery.eventHandler.registerListener(this, this.evl);
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 50 */       this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/phpmyadmin?user=query&password=Q3pNG287");
/* 51 */       this.evl.verbindung = true;
/*    */     }
/* 53 */     catch (SQLException e) {
/* 54 */       System.out.println("Verbindung nicht moglich");
/* 55 */       System.out.println("SQLException: " + e.getMessage());
/* 56 */       System.out.println("SQLState: " + e.getSQLState());
/* 57 */       System.out.println("VendorError: " + e.getErrorCode());
/*    */       
/* 59 */       this.evl.verbindung = false;
/*    */     } 
/*    */     
/* 62 */     this.loopThread = new Thread(new LoopThread(this.evl));
/* 63 */     this.loopThread.start();
/*    */   }
/*    */ 
/*    */   
/*    */   public static Main getMain() {
/* 68 */     return main;
/*    */   }
/*    */ }


/* Location:              C:\Users\mmlpv\OneDrive\Desktop\Java programmiert\Tuti_Query.jar!\main\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */