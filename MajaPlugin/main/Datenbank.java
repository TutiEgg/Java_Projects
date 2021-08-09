/*     */ package main;
/*     */ 
/*     */ import de.tevOnce.MajaQuery.objects.Client;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Datenbank
/*     */ {
/*     */   private Client client;
/*     */   private String name;
/*     */   private String uuid;
/*  16 */   private String rank = "kouhai";
/*  17 */   private String rechte = "keine";
/*  18 */   private String anrede = "keine";
/*  19 */   private int level = 1;
/*  20 */   private int punkte = 1;
/*     */ 
/*     */ 
/*     */   
/*     */   private Clientinfos clientinfo;
/*     */ 
/*     */ 
/*     */   
/*     */   public Datenbank(Client client) {
/*  29 */     this.client = client;
/*  30 */     this.clientinfo = new Clientinfos(client);
/*  31 */     this.uuid = this.clientinfo.uuid;
/*  32 */     this.name = this.clientinfo.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public Datenbank(Client client, String anrede) {
/*  37 */     this.client = client;
/*  38 */     this.anrede = anrede;
/*  39 */     this.uuid = client.getUID();
/*  40 */     this.name = client.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLevel(int level, String rechte, String rank, String uuid) {
/*  45 */     this.level = level;
/*  46 */     this.rechte = rechte;
/*  47 */     this.rank = rank;
/*  48 */     this.uuid = uuid;
/*     */     
/*  50 */     updateDBLevel(level);
/*  51 */     updateDBRank();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateDBAnrede(String anrede) {
/*     */     try {
/*  58 */       PreparedStatement preparedStatement = (Main.getMain()).con.prepareStatement("UPDATE teamspeak SET Anrede = '" + anrede + "' WHERE UUID = '" + this.uuid + "'");
/*  59 */       preparedStatement.executeUpdate();
/*  60 */     } catch (SQLException e) {
/*     */       
/*  62 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateDBLevel(int level) {
/*     */     try {
/*  68 */       PreparedStatement preparedStatement = (Main.getMain()).con.prepareStatement("UPDATE teamspeak SET Level = '" + level + "' WHERE UUID = '" + this.uuid + "'");
/*  69 */       preparedStatement.executeUpdate();
/*  70 */     } catch (SQLException e) {
/*     */       
/*  72 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateDBRank() {
/*     */     try {
/*  78 */       PreparedStatement preparedStatement = (Main.getMain()).con.prepareStatement("UPDATE teamspeak SET Rank = '" + this.rank + "' WHERE UUID = '" + this.uuid + "'");
/*  79 */       preparedStatement.executeUpdate();
/*  80 */     } catch (SQLException e) {
/*     */       
/*  82 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnrede(String anrede) {
/*  89 */     this.anrede = anrede;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean clientAddDB() {
/*     */     try {
/* 101 */       PreparedStatement preparedStatement = (Main.getMain()).con.prepareStatement("INSERT INTO teamspeak (Name, UUID, Rank, Anrede, Level, Punkte) VALUES ('" + this.name + "', '" + this.uuid + "', '" + this.rank + "', '" + this.anrede + "', '" + this.level + "', '" + this.punkte + "')");
/* 102 */       preparedStatement.executeUpdate();
/* 103 */       return true;
/*     */     }
/* 105 */     catch (SQLException e1) {
/*     */       
/* 107 */       e1.printStackTrace();
/* 108 */       this.clientinfo.adminUuid().sendOfflineMessage("Fehler bei DB Eintrag ", "Der Client " + this.name + " mit der UUID " + this.uuid + " konnte nichtin die Datenbank eingetragen werden. Fehler >> " + e1.getMessage());
/* 109 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String clientExistDB() {
/*     */     try {
/* 118 */       PreparedStatement preparedStatement = (Main.getMain()).con.prepareStatement("SELECT UUID FROM teamspeak WHERE UUID = '" + this.uuid + "'");
/* 119 */       ResultSet resultSet = preparedStatement.executeQuery();
/*     */ 
/*     */       
/* 122 */       if (resultSet.next()) {
/* 123 */         String userExist = resultSet.getString(1);
/* 124 */         if (userExist.equals(this.uuid)) {
/* 125 */           return "eingetragen";
/*     */         }
/*     */         
/* 128 */         return "eingetragen";
/*     */       } 
/*     */ 
/*     */       
/* 132 */       return "nichtEingetragen";
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 137 */     catch (SQLException e1) {
/*     */       
/* 139 */       e1.printStackTrace();
/* 140 */       this.clientinfo.adminUuid().sendOfflineMessage("Client DB eintrag Abfragung", "Der Client " + this.name + " hat einen Fehler bei seiner DB-Abfrage (ob er eingetragen ist) bekommen. Fehler >> " + e1.getMessage());
/* 141 */       System.out.println("Fehler in der Bearbeitung");
/* 142 */       return "fehler";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRank() {
/*     */     try {
/* 152 */       PreparedStatement preparedStatement = (Main.getMain()).con.prepareStatement("SELECT Rank FROM teamspeak WHERE UUID = '" + this.uuid + "');");
/* 153 */       ResultSet resultSet = preparedStatement.executeQuery();
/*     */       
/* 155 */       boolean nextZeile = resultSet.next();
/* 156 */       if (nextZeile) {
/* 157 */         String rankValue = resultSet.getString(1);
/* 158 */         if (rankValue != "") {
/* 159 */           return rankValue;
/*     */         }
/* 161 */         return "keineAngabe";
/*     */       } 
/*     */       
/* 164 */       return "clientNotExist";
/*     */ 
/*     */     
/*     */     }
/* 168 */     catch (SQLException e1) {
/*     */       
/* 170 */       e1.printStackTrace();
/* 171 */       return "fehlerDBBefehl";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAnrede() {
/*     */     try {
/* 181 */       PreparedStatement preparedStatement = (Main.getMain()).con.prepareStatement("SELECT Anrede FROM teamspeak WHERE UUID = '" + this.uuid + "'");
/* 182 */       ResultSet resultSet = preparedStatement.executeQuery();
/*     */       
/* 184 */       boolean nextZeile = resultSet.next();
/* 185 */       if (nextZeile) {
/* 186 */         String anredeValue = resultSet.getString(1);
/* 187 */         if (anredeValue != "") {
/* 188 */           return anredeValue;
/*     */         }
/* 190 */         return "keineAngabe";
/*     */       } 
/*     */       
/* 193 */       return "clientNotExist";
/*     */ 
/*     */     
/*     */     }
/* 197 */     catch (SQLException e1) {
/*     */       
/* 199 */       e1.printStackTrace();
/* 200 */       return "fehlerDBBefehl";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLevel(String uuid) {
/*     */     try {
/* 216 */       PreparedStatement preparedStatement = (Main.getMain()).con.prepareStatement("SELECT Level FROM teamspeak WHERE UUID = '" + uuid + "'");
/* 217 */       ResultSet resultSet = preparedStatement.executeQuery();
/*     */       
/* 219 */       boolean nextZeile = resultSet.next();
/* 220 */       if (nextZeile) {
/* 221 */         int punkteValue = resultSet.getInt(1);
/* 222 */         if (punkteValue != 0) {
/* 223 */           return punkteValue;
/*     */         }
/* 225 */         return -1;
/*     */       } 
/*     */       
/* 228 */       return -2;
/*     */ 
/*     */     
/*     */     }
/* 232 */     catch (SQLException e1) {
/*     */       
/* 234 */       e1.printStackTrace();
/* 235 */       return -3;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String updateClientBD() {
/* 245 */     int setLevel = this.punkte;
/*     */     
/*     */     try {
/* 248 */       String userExist = clientExistDB();
/* 249 */       if (userExist == "eingetragen") {
/* 250 */         PreparedStatement preparedStatement = (Main.getMain()).con.prepareStatement("UPDATE teamspeak SET Level = '" + setLevel + "' WHERE UUID = '" + this.uuid + "'");
/* 251 */         preparedStatement.executeUpdate();
/* 252 */         return "erfolgreichUpranked";
/*     */       } 
/* 254 */       boolean registerErfolgreich = clientAddDB();
/* 255 */       if (registerErfolgreich) {
/* 256 */         PreparedStatement preparedStatement = (Main.getMain()).con.prepareStatement("UPDATE teamspeak SET Level = '" + setLevel + "' WHERE UUID = '" + this.uuid + "'");
/* 257 */         preparedStatement.executeUpdate();
/*     */         
/* 259 */         return "erfolgreichEingetragen";
/*     */       } 
/* 261 */       return "fehlerBeimEintragen";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 267 */     catch (SQLException e1) {
/*     */       
/* 269 */       e1.printStackTrace();
/* 270 */       return "fehlerBeimUpranken";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mmlpv\OneDrive\Desktop\Java programmiert\Tuti_Query.jar!\main\Datenbank.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */