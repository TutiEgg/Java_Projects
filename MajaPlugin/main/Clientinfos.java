/*    */ package main;
/*    */ 
/*    */ import de.tevOnce.MajaQuery.MajaQuery;
/*    */ import de.tevOnce.MajaQuery.objects.Client;
/*    */ import de.tevOnce.MajaQuery.objects.OfflineClient;
/*    */ import de.tevOnce.MajaQuery.objects.ServerGroup;
/*    */ 
/*    */ public class Clientinfos
/*    */ {
/*    */   private Client client;
/*    */   private ServerGroup servergroup;
/*    */   public String name;
/*    */   public String uuid;
/*    */   
/*    */   public Clientinfos(Client client, ServerGroup servergroup) {
/* 16 */     this.client = client;
/* 17 */     this.servergroup = servergroup;
/* 18 */     String name = client.getName();
/* 19 */     String uuid = client.getUID();
/* 20 */     this.name = name;
/* 21 */     this.uuid = uuid;
/*    */   }
/*    */   public Clientinfos(Client client) {
/* 24 */     this.client = client;
/*    */     
/* 26 */     this.name = client.getName();
/* 27 */     this.uuid = client.getUID();
/*    */   }
/*    */   
/*    */   public OfflineClient adminUuid() {
/* 31 */     OfflineClient admin = MajaQuery.connection.getServer().getOfflineClientByUID("AGznjpcsnKbEQQQyYLAV7cUdUJI=");
/* 32 */     return admin;
/*    */   }
/*    */ 
/*    */   
/*    */   public String clientRank() {
/* 37 */     String rank = "";
/*    */ 
/*    */     
/* 40 */     return rank;
/*    */   }
/*    */ }


/* Location:              C:\Users\mmlpv\OneDrive\Desktop\Java programmiert\Tuti_Query.jar!\main\Clientinfos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */