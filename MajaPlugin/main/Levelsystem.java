/*     */ package main;
/*     */ 
/*     */ import de.tevOnce.MajaQuery.MajaQuery;
/*     */ import de.tevOnce.MajaQuery.objects.Client;
/*     */ import de.tevOnce.MajaQuery.objects.ServerGroup;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Levelsystem
/*     */ {
/*     */   private Client client;
/*  14 */   private int level = 1;
/*  15 */   private String anrede = "";
/*  16 */   private String rank = "";
/*  17 */   private String rechte = "";
/*     */   
/*     */   private boolean fehler = false;
/*     */   
/*     */   private boolean abfrageRechte = false;
/*     */   
/*     */   private boolean abfrageAnrede = false;
/*     */   private boolean abfrageRank = false;
/*     */   private Datenbank datenbank;
/*     */   private Clientinfos clientinfo;
/*     */   private Prefix prefix;
/*     */   
/*     */   public Levelsystem(Client client) {
/*  30 */     this.client = client;
/*     */     
/*  32 */     this.datenbank = new Datenbank(client);
/*  33 */     this.clientinfo = new Clientinfos(client);
/*  34 */     this.prefix = new Prefix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLevel(int level) {
/*  39 */     this.level = level;
/*     */   }
/*     */   public void setAnrede(String anrede) {
/*  42 */     this.anrede = anrede;
/*     */   }
/*     */   public void setRank(String rank) {
/*  45 */     this.rank = rank;
/*     */   }
/*     */   public void setRechte(String rechte) {
/*  48 */     this.rechte = rechte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void upranked() {
/*  55 */     if (this.anrede != "") {
/*  56 */       this.abfrageAnrede = true;
/*  57 */     } else if (this.anrede == "") {
/*  58 */       this.abfrageAnrede = false;
/*     */     } else {
/*  60 */       this.abfrageAnrede = false;
/*  61 */       this.clientinfo.adminUuid().sendOfflineMessage("setAnrede>> Fehler ", "Der Client: " + this.client.getName() + " bekam keine neue Anrede beim Upranken (Fehler bei der Bearbeitung) Angaben:" + this.level + this.anrede + this.rank + this.rechte);
/*  62 */       this.fehler = true;
/*     */     } 
/*     */ 
/*     */     
/*  66 */     if (this.rechte != "") {
/*  67 */       boolean setRechte = setGroupRechte();
/*  68 */       if (setRechte) {
/*  69 */         this.abfrageRechte = true;
/*     */       } else {
/*  71 */         this.abfrageRechte = false;
/*  72 */         this.clientinfo.adminUuid().sendOfflineMessage("setRechte>> Fehler ", "Der Client: " + this.client.getName() + " bekam keine neuen Rechte beim Upranken (Fehler bei der Bearbeitung, falsche Angabe im Code) Angaben:" + this.level + this.anrede + this.rank + this.rechte);
/*  73 */         this.fehler = true;
/*     */       } 
/*     */     } else {
/*     */       
/*  77 */       this.abfrageRechte = false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  82 */     if (this.rank != "") {
/*  83 */       boolean setRank = setGroupRank();
/*  84 */       if (setRank) {
/*  85 */         this.abfrageRank = true;
/*     */       } else {
/*  87 */         this.abfrageRank = false;
/*  88 */         this.clientinfo.adminUuid().sendOfflineMessage("setRank>> Fehler ", "Der Client: " + this.client.getName() + " bekam keinen neuen Rank beim Upranken (Fehler bei der Bearbeitung, falsche Angabe im Code) Angaben:" + this.level + this.anrede + this.rank + this.rechte);
/*  89 */         this.fehler = true;
/*     */       } 
/*     */     } else {
/*     */       
/*  93 */       this.abfrageRank = false;
/*     */     } 
/*     */ 
/*     */     
/*  97 */     String msg = this.datenbank.clientExistDB();
/*     */     
/*  99 */     if (msg == "eingetragen") {
/* 100 */       this.datenbank.setLevel(this.level, this.rechte, this.rank, this.client.getUID());
/* 101 */     } else if (msg == "nichtEingetragen") {
/* 102 */       this.datenbank.clientAddDB();
/* 103 */       this.datenbank.setLevel(this.level, this.rechte, this.rank, this.client.getUID());
/*     */     } else {
/* 105 */       this.clientinfo.adminUuid().sendOfflineMessage("DB-Überprüfung>> Fehler ", "Der Client: " + this.client.getName() + " ist nicht in der Datenbank und konnte auch nicht in die Datenbank eingeschrieben werden Angaben:" + this.level + this.anrede + this.rank + this.rechte);
/* 106 */       this.fehler = true;
/*     */       
/*     */       return;
/*     */     } 
/* 110 */     upRankMessage();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean setGroupRechte() {
/* 115 */     boolean hatServerGruppe = false;
/* 116 */     if (this.rechte == "beschreibung") {
/* 117 */       ArrayList<ServerGroup> sergroups = this.client.getServerGroups();
/* 118 */       for (int i = 0; i < sergroups.size(); i++) {
/* 119 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 96) {
/* 120 */           hatServerGruppe = true;
/*     */         }
/*     */       } 
/* 123 */       if (!hatServerGruppe) {
/* 124 */         ServerGroup description = MajaQuery.connection.getServer().getServerGroupByServerGroupID(96);
/* 125 */         this.client.addToServerGroup(description);
/*     */       } 
/*     */       
/* 128 */       return true;
/* 129 */     }  if (this.rechte == "filebrowser") {
/* 130 */       ArrayList<ServerGroup> sergroups = this.client.getServerGroups();
/* 131 */       for (int i = 0; i < sergroups.size(); i++) {
/* 132 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 95) {
/* 133 */           hatServerGruppe = true;
/*     */         }
/*     */       } 
/* 136 */       if (!hatServerGruppe) {
/* 137 */         ServerGroup description = MajaQuery.connection.getServer().getServerGroupByServerGroupID(95);
/* 138 */         this.client.addToServerGroup(description);
/*     */       } 
/* 140 */       return true;
/* 141 */     }  if (this.rechte == "musicbot") {
/* 142 */       ArrayList<ServerGroup> sergroups = this.client.getServerGroups();
/* 143 */       for (int i = 0; i < sergroups.size(); i++) {
/* 144 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 97) {
/* 145 */           hatServerGruppe = true;
/*     */         }
/*     */       } 
/* 148 */       if (!hatServerGruppe) {
/* 149 */         ServerGroup description = MajaQuery.connection.getServer().getServerGroupByServerGroupID(97);
/* 150 */         this.client.addToServerGroup(description);
/*     */       } 
/* 152 */       return true;
/* 153 */     }  if (this.rechte == "ownChannel") {
/* 154 */       ArrayList<ServerGroup> sergroups = this.client.getServerGroups();
/* 155 */       for (int i = 0; i < sergroups.size(); i++) {
/* 156 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 94) {
/* 157 */           hatServerGruppe = true;
/*     */         }
/*     */       } 
/* 160 */       if (!hatServerGruppe) {
/* 161 */         ServerGroup description = MajaQuery.connection.getServer().getServerGroupByServerGroupID(94);
/* 162 */         this.client.addToServerGroup(description);
/*     */       } 
/*     */       
/* 165 */       return true;
/*     */     } 
/* 167 */     this.rechte = "";
/* 168 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean setGroupRank() {
/* 174 */     if (this.rank == "senpai") {
/* 175 */       ServerGroup ranked = MajaQuery.connection.getServer().getServerGroupByServerGroupID(46);
/* 176 */       removeRank();
/* 177 */       this.client.addToServerGroup(ranked);
/* 178 */       return true;
/* 179 */     }  if (this.rank == "kouhai")
/* 180 */       return true; 
/* 181 */     if (this.rank == "sensei") {
/* 182 */       ServerGroup ranked = MajaQuery.connection.getServer().getServerGroupByServerGroupID(47);
/* 183 */       removeRank();
/* 184 */       this.client.addToServerGroup(ranked);
/* 185 */       return true;
/* 186 */     }  if (this.rank == "shisho") {
/* 187 */       ServerGroup ranked = MajaQuery.connection.getServer().getServerGroupByServerGroupID(48);
/* 188 */       removeRank();
/* 189 */       this.client.addToServerGroup(ranked);
/* 190 */       return true;
/* 191 */     }  if (this.rank == "hikkimori") {
/* 192 */       ServerGroup ranked = MajaQuery.connection.getServer().getServerGroupByServerGroupID(49);
/* 193 */       removeRank();
/* 194 */       this.client.addToServerGroup(ranked);
/* 195 */       return true;
/* 196 */     }  if (this.rank == "otaku") {
/* 197 */       ServerGroup ranked = MajaQuery.connection.getServer().getServerGroupByServerGroupID(50);
/* 198 */       removeRank();
/* 199 */       this.client.addToServerGroup(ranked);
/* 200 */       return true;
/* 201 */     }  if (this.rank == "otaku-senpai") {
/* 202 */       ServerGroup ranked = MajaQuery.connection.getServer().getServerGroupByServerGroupID(56);
/* 203 */       removeRank();
/* 204 */       this.client.addToServerGroup(ranked);
/* 205 */       return true;
/* 206 */     }  if (this.rank == "otaku-sensei") {
/* 207 */       ServerGroup ranked = MajaQuery.connection.getServer().getServerGroupByServerGroupID(57);
/* 208 */       removeRank();
/* 209 */       this.client.addToServerGroup(ranked);
/* 210 */       return true;
/* 211 */     }  if (this.rank == "otaku-shisho") {
/* 212 */       ServerGroup ranked = MajaQuery.connection.getServer().getServerGroupByServerGroupID(58);
/* 213 */       removeRank();
/* 214 */       this.client.addToServerGroup(ranked);
/* 215 */       return true;
/* 216 */     }  if (this.rank == "otaku-god") {
/* 217 */       ServerGroup ranked = MajaQuery.connection.getServer().getServerGroupByServerGroupID(59);
/* 218 */       removeRank();
/* 219 */       this.client.addToServerGroup(ranked);
/* 220 */       return true;
/*     */     } 
/* 222 */     this.rank = "";
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void upRankMessage() {
/* 230 */     this.client.sendPrivateMessage("[COLOR=#ffaa00]████████████████████████████████████████████████████████████████████████████████[/COLOR]");
/* 231 */     this.client.sendPrivateMessage(String.valueOf(this.prefix.preSystem) + "Du wurdest soeben auf Level>> [B]" + this.level + "[/B] aufgelevelt! ");
/*     */     
/* 233 */     if (this.abfrageRechte) {
/* 234 */       this.client.sendPrivateMessage("Du hast eine neue Gruppe/Rechte bekommen >> [B]" + this.rechte + "[/B]");
/*     */     }
/* 236 */     if (this.abfrageAnrede) {
/* 237 */       this.client.sendPrivateMessage("Du hast die Anrede [B]" + this.anrede + "[/B] freigeschalten. Ändere sie mit dem Befehl 'switch " + this.anrede + "' ");
/*     */     }
/* 239 */     if (this.abfrageRank) {
/* 240 */       this.client.sendPrivateMessage("Dir wurde ein neuer Rangzugeteilt >> [B]" + this.rank + " [/B]");
/*     */     }
/* 242 */     this.client.sendPrivateMessage("[COLOR=#ffaa00]████████████████████████████████████████████████████████████████████████████████[/COLOR]");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeRank() {
/* 253 */     ArrayList<ServerGroup> sergroups = this.client.getServerGroups();
/* 254 */     for (int i = 0; i < sergroups.size(); i++) {
/* 255 */       if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 42) {
/* 256 */         this.client.removeFromServerGroup(new ServerGroup(42));
/*     */       }
/* 258 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 46) {
/* 259 */         this.client.removeFromServerGroup(new ServerGroup(46));
/*     */       }
/* 261 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 47) {
/* 262 */         this.client.removeFromServerGroup(new ServerGroup(47));
/*     */       }
/* 264 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 48) {
/* 265 */         this.client.removeFromServerGroup(new ServerGroup(48));
/*     */       }
/* 267 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 49) {
/* 268 */         this.client.removeFromServerGroup(new ServerGroup(49));
/*     */       }
/* 270 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 50) {
/* 271 */         this.client.removeFromServerGroup(new ServerGroup(50));
/*     */       }
/* 273 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 56) {
/* 274 */         this.client.removeFromServerGroup(new ServerGroup(56));
/*     */       }
/* 276 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 57) {
/* 277 */         this.client.removeFromServerGroup(new ServerGroup(57));
/*     */       }
/* 279 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 58) {
/* 280 */         this.client.removeFromServerGroup(new ServerGroup(58));
/*     */       }
/* 282 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 59) {
/* 283 */         this.client.removeFromServerGroup(new ServerGroup(59));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mmlpv\OneDrive\Desktop\Java programmiert\Tuti_Query.jar!\main\Levelsystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */