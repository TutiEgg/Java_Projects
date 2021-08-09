/*    */ package main;
/*    */ 
/*    */ import de.tevOnce.MajaQuery.MajaQuery;
/*    */ import de.tevOnce.MajaQuery.objects.Channel;
/*    */ import de.tevOnce.MajaQuery.objects.Client;
/*    */ import de.tevOnce.MajaQuery.objects.Server;
/*    */ import de.tevOnce.MajaQuery.objects.ServerGroup;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Registrieren
/*    */ {
/*    */   private int oldChannelID;
/*    */   private Client client;
/*    */   private int channelID;
/*    */   
/*    */   public Registrieren(int oldChannelID, Client client, int channelID) {
/* 19 */     this.oldChannelID = oldChannelID;
/* 20 */     this.client = client;
/* 21 */     this.channelID = channelID;
/*    */   }
/*    */   
/*    */   public void register() {
/* 25 */     Datenbank datenbank = new Datenbank(this.client);
/* 26 */     Prefix prefix = new Prefix();
/*    */     
/* 28 */     this.client.move(new Channel(this.oldChannelID));
/*    */     
/* 30 */     ServerGroup s = new ServerGroup(8);
/* 31 */     boolean group = this.client.getServerGroups().contains(s);
/*    */     
/* 33 */     String eingetragen = datenbank.clientExistDB();
/*    */     
/* 35 */     if (eingetragen == "eingetragen") {
/* 36 */       this.client.sendPrivateMessage(String.valueOf(prefix.preError) + "Du bist schon in der Datenbank eingetragen, falls dir Gruppen fehlen gebe den Befehl 'update' ein");
/*    */     } else {
/*    */       
/* 39 */       boolean suc = datenbank.clientAddDB();
/* 40 */       if (suc) {
/* 41 */         this.client.sendPrivateMessage(String.valueOf(prefix.preServer) + "Du wurdest in die Datenbank eingetragen, da du noch nicht eingetragen warst");
/*    */       } else {
/* 43 */         this.client.sendPrivateMessage(String.valueOf(prefix.preError) + "Ein Fehler ist bei der Bearbeitung vorgefallen, kontaktiere TuTi");
/*    */         
/*    */         return;
/*    */       } 
/*    */     } 
/* 48 */     if (group) {
/*    */       
/* 50 */       String name = this.client.getName();
/*    */       
/* 52 */       Server server = MajaQuery.connection.getServer();
/* 53 */       ServerGroup s1 = server.getServerGroupByServerGroupID(41);
/* 54 */       ServerGroup s2 = server.getServerGroupByServerGroupID(42);
/* 55 */       ServerGroup s3 = server.getServerGroupByServerGroupID(62);
/* 56 */       ServerGroup s4 = server.getServerGroupByServerGroupID(53);
/* 57 */       ServerGroup s5 = server.getServerGroupByServerGroupID(61);
/* 58 */       ServerGroup s6 = server.getServerGroupByServerGroupID(110);
/* 59 */       ServerGroup s7 = server.getServerGroupByServerGroupID(63);
/* 60 */       ServerGroup s8 = server.getServerGroupByServerGroupID(19);
/*    */       
/* 62 */       this.client.addToServerGroup(s1);
/* 63 */       this.client.addToServerGroup(s2);
/* 64 */       this.client.addToServerGroup(s3);
/* 65 */       this.client.addToServerGroup(s4);
/* 66 */       this.client.addToServerGroup(s5);
/* 67 */       this.client.addToServerGroup(s6);
/* 68 */       this.client.addToServerGroup(s7);
/* 69 */       this.client.addToServerGroup(s8);
/*    */       
/* 71 */       MajaQuery.connection.getQuery().sendServerMessage(String.valueOf(prefix.preServer) + "[COLOR=#55aa00][B]" + name + "[/B] ist von nun an ein neues Mitglied[/COLOR]");
/*    */       
/* 73 */       this.client.sendPrivateMessage("\n>--------------------------->Male oder Female ^^ >--------------------------->\n \n Bist du ein    [B]Male[/B]      oder      [B]Female[/B]       ???\t[Eingeben]");
/*    */     } else {
/*    */       
/* 76 */       this.client.sendPrivateMessage("Du hast dich schon einmal registriert !");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\mmlpv\OneDrive\Desktop\Java programmiert\Tuti_Query.jar!\main\Registrieren.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */