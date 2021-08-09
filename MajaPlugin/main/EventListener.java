/*     */ package main;
/*     */ 
/*     */ import de.tevOnce.MajaQuery.MajaQuery;
/*     */ import de.tevOnce.MajaQuery.event.Listener;
/*     */ import de.tevOnce.MajaQuery.event.channel.ChannelCreatedEvent;
/*     */ import de.tevOnce.MajaQuery.event.client.ClientConnectedEvent;
/*     */ import de.tevOnce.MajaQuery.event.client.ClientGotServerGroupEvent;
/*     */ import de.tevOnce.MajaQuery.event.client.ClientJoinedChannelEvent;
/*     */ import de.tevOnce.MajaQuery.event.client.ClientMovedClientEvent;
/*     */ import de.tevOnce.MajaQuery.event.client.ClientSentQueryPrivateMessageEvent;
/*     */ import de.tevOnce.MajaQuery.objects.Channel;
/*     */ import de.tevOnce.MajaQuery.objects.ChannelGroup;
/*     */ import de.tevOnce.MajaQuery.objects.Client;
/*     */ import de.tevOnce.MajaQuery.objects.Server;
/*     */ import de.tevOnce.MajaQuery.objects.ServerGroup;
/*     */ import de.tevOnce.MajaQuery.objects.enumerations.ChannelType;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EventListener
/*     */   implements Listener
/*     */ {
/*  37 */   public String preServer = "[B][COLOR=#ffaa00][ServerNachricht]>>[/COLOR][/B] ";
/*  38 */   public String preAnimeManga = "[B][COLOR=#ffaa00][Anime/Manga]>>[/COLOR][/B] ";
/*  39 */   public String preAlter = "[B][COLOR=#ffaa00][Alter]>>[/COLOR][/B] ";
/*  40 */   public String preSwitch = "[B][COLOR=#ffaa00][Switch]>>[/COLOR][/B] ";
/*  41 */   public String preMaleFemale = "[B][COLOR=#ffaa00][Male/Female]>>[/COLOR][/B] ";
/*  42 */   public String preSystem = "[B][COLOR=#ffaa00][System]>>[/COLOR][/B] ";
/*  43 */   public String preRundruf = "[B][COLOR=#ffaa00][Rundruf]>>[/COLOR][/B] ";
/*     */   
/*  45 */   public String preError = "[B][COLOR=#dc143c][FEHLER]>>[/COLOR][/B] ";
/*  46 */   public String preRegister = "[B][COLOR=#aa0000][Registrierung]>>[/COLOR][/B] ";
/*  47 */   public String preSuc = "[COLOR=#005500]";
/*  48 */   public String preLevelsytem = "[B][COLOR=#1e90ff][Levelsystem]>>[/COLOR][/B] ";
/*     */   
/*     */   private Main main;
/*     */   
/*     */   private static boolean b1 = false;
/*     */   
/*     */   private static boolean warten = true;
/*     */   
/*     */   private static boolean befehlPause = false;
/*     */   private String meldung;
/*     */   public boolean verbindung;
/*     */   private ArrayList<Client> warte;
/*     */   Prefix prefix;
/*     */   
/*     */   public EventListener(Main main) {
/*  63 */     this.verbindung = false;
/*     */ 
/*     */ 
/*     */     
/*  67 */     this.warte = new ArrayList<>();
/*  68 */     this.prefix = new Prefix();
/*     */     this.main = main;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void MySQLConnection() {
/*     */     try {
/*  76 */       this.main.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/phpmyadmin?user=query&password=Q3pNG287");
/*  77 */       this.verbindung = true;
/*     */     }
/*  79 */     catch (SQLException e) {
/*  80 */       System.out.println("Verbindung nicht moglich");
/*  81 */       System.out.println("SQLException: " + e.getMessage());
/*  82 */       System.out.println("SQLState: " + e.getSQLState());
/*  83 */       System.out.println("VendorError: " + e.getErrorCode());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void MySQLAbfrage() {
/*     */     try {
/*  90 */       if (this.main.con.isClosed()) {
/*  91 */         MySQLConnection();
/*     */       }
/*  93 */     } catch (SQLException e1) {
/*  94 */       System.out.println("Abfrage der Verbindung ist nicht moglich (serverGroups)");
/*  95 */       System.out.println("SQLException: " + e1.getMessage());
/*  96 */       System.out.println("SQLState: " + e1.getSQLState());
/*  97 */       System.out.println("VendorError: " + e1.getErrorCode());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void serverGroups(ClientGotServerGroupEvent e) {
/* 103 */     MySQLAbfrage();
/*     */     
/* 105 */     Levelsystem levelsystem = new Levelsystem(e.getClient());
/*     */     
/* 107 */     int levelUser = e.getServerGroup().getServerGroupID();
/* 108 */     switch (levelUser) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 20:
/* 118 */         levelsystem.setLevel(2);
/* 119 */         levelsystem.setAnrede("");
/* 120 */         levelsystem.setRank("kouhai");
/* 121 */         levelsystem.setRechte("");
/* 122 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 21:
/* 126 */         levelsystem.setLevel(3);
/* 127 */         levelsystem.setAnrede("");
/* 128 */         levelsystem.setRank("kouhai");
/* 129 */         levelsystem.setRechte("");
/* 130 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 23:
/* 134 */         levelsystem.setLevel(4);
/* 135 */         levelsystem.setAnrede("kun/chan");
/* 136 */         levelsystem.setRank("kouhai");
/* 137 */         levelsystem.setRechte("");
/* 138 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 24:
/* 142 */         levelsystem.setLevel(5);
/* 143 */         levelsystem.setAnrede("");
/* 144 */         levelsystem.setRank("kouhai");
/* 145 */         levelsystem.setRechte("");
/* 146 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 69:
/* 150 */         levelsystem.setLevel(6);
/* 151 */         levelsystem.setAnrede("");
/* 152 */         levelsystem.setRank("kouhai");
/* 153 */         levelsystem.setRechte("");
/* 154 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 70:
/* 158 */         levelsystem.setLevel(7);
/* 159 */         levelsystem.setAnrede("senpai");
/* 160 */         levelsystem.setRank("senpai");
/* 161 */         levelsystem.setRechte("");
/* 162 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 71:
/* 166 */         levelsystem.setLevel(8);
/* 167 */         levelsystem.setAnrede("");
/* 168 */         levelsystem.setRank("senpai");
/* 169 */         levelsystem.setRechte("beschreibung");
/* 170 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 72:
/* 174 */         levelsystem.setLevel(9);
/* 175 */         levelsystem.setAnrede("");
/* 176 */         levelsystem.setRank("senpai");
/* 177 */         levelsystem.setRechte("");
/* 178 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 73:
/* 182 */         levelsystem.setLevel(10);
/* 183 */         levelsystem.setAnrede("");
/* 184 */         levelsystem.setRank("senpai");
/* 185 */         levelsystem.setRechte("filebrowser");
/* 186 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 74:
/* 190 */         levelsystem.setLevel(11);
/* 191 */         levelsystem.setAnrede("");
/* 192 */         levelsystem.setRank("senpai");
/* 193 */         levelsystem.setRechte("");
/* 194 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 75:
/* 198 */         levelsystem.setLevel(12);
/* 199 */         levelsystem.setAnrede("sensei");
/* 200 */         levelsystem.setRank("sensei");
/* 201 */         levelsystem.setRechte("");
/* 202 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 76:
/* 206 */         levelsystem.setLevel(13);
/* 207 */         levelsystem.setAnrede("");
/* 208 */         levelsystem.setRank("sensei");
/* 209 */         levelsystem.setRechte("");
/* 210 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 77:
/* 214 */         levelsystem.setLevel(14);
/* 215 */         levelsystem.setAnrede("");
/* 216 */         levelsystem.setRank("sensei");
/* 217 */         levelsystem.setRechte("musicbot");
/* 218 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 78:
/* 222 */         levelsystem.setLevel(15);
/* 223 */         levelsystem.setAnrede("");
/* 224 */         levelsystem.setRank("sensei");
/* 225 */         levelsystem.setRechte("");
/* 226 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 79:
/* 230 */         levelsystem.setLevel(16);
/* 231 */         levelsystem.setAnrede("shisho");
/* 232 */         levelsystem.setRank("shisho");
/* 233 */         levelsystem.setRechte("");
/* 234 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 80:
/* 238 */         levelsystem.setLevel(17);
/* 239 */         levelsystem.setAnrede("");
/* 240 */         levelsystem.setRank("shisho");
/* 241 */         levelsystem.setRechte("");
/* 242 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 81:
/* 246 */         levelsystem.setLevel(18);
/* 247 */         levelsystem.setAnrede("");
/* 248 */         levelsystem.setRank("shisho");
/* 249 */         levelsystem.setRechte("");
/* 250 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 82:
/* 254 */         levelsystem.setLevel(19);
/* 255 */         levelsystem.setAnrede("");
/* 256 */         levelsystem.setRank("shisho");
/* 257 */         levelsystem.setRechte("");
/* 258 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 83:
/* 262 */         levelsystem.setLevel(20);
/* 263 */         levelsystem.setAnrede("sama");
/* 264 */         levelsystem.setRank("hikkimori");
/* 265 */         levelsystem.setRechte("ownChannel");
/* 266 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 84:
/* 270 */         levelsystem.setLevel(21);
/* 271 */         levelsystem.setAnrede("");
/* 272 */         levelsystem.setRank("hikkimori");
/* 273 */         levelsystem.setRechte("");
/* 274 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 85:
/* 278 */         levelsystem.setLevel(22);
/* 279 */         levelsystem.setAnrede("");
/* 280 */         levelsystem.setRank("hikkimori");
/* 281 */         levelsystem.setRechte("");
/* 282 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 86:
/* 286 */         levelsystem.setLevel(23);
/* 287 */         levelsystem.setAnrede("dono/hime-sama");
/* 288 */         levelsystem.setRank("otaku");
/* 289 */         levelsystem.setRechte("");
/* 290 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 87:
/* 294 */         levelsystem.setLevel(24);
/* 295 */         levelsystem.setAnrede("");
/* 296 */         levelsystem.setRank("otaku");
/* 297 */         levelsystem.setRechte("");
/* 298 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 88:
/* 302 */         levelsystem.setLevel(25);
/* 303 */         levelsystem.setAnrede("");
/* 304 */         levelsystem.setRank("otaku");
/* 305 */         levelsystem.setRechte("");
/* 306 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 89:
/* 310 */         levelsystem.setLevel(26);
/* 311 */         levelsystem.setAnrede("otouto-chan/imouto-chan");
/* 312 */         levelsystem.setRank("otaku-senpai");
/* 313 */         levelsystem.setRechte("");
/* 314 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 90:
/* 318 */         levelsystem.setLevel(27);
/* 319 */         levelsystem.setAnrede("onii-san/onee-san");
/* 320 */         levelsystem.setRank("otaku-sensei");
/* 321 */         levelsystem.setRechte("");
/* 322 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 91:
/* 326 */         levelsystem.setLevel(28);
/* 327 */         levelsystem.setAnrede("onii-chan/onee-chan");
/* 328 */         levelsystem.setRank("otaku-shisho");
/* 329 */         levelsystem.setRechte("");
/* 330 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 92:
/* 334 */         levelsystem.setLevel(29);
/* 335 */         levelsystem.setAnrede("onii-sama/onee-sama");
/* 336 */         levelsystem.setRank("otaku-shisho");
/* 337 */         levelsystem.setRechte("");
/* 338 */         levelsystem.upranked();
/*     */         break;
/*     */       
/*     */       case 93:
/* 342 */         levelsystem.setLevel(30);
/* 343 */         levelsystem.setAnrede("");
/* 344 */         levelsystem.setRank("otaku-god");
/* 345 */         levelsystem.setRechte("");
/* 346 */         levelsystem.upranked();
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void newbieJoin(ClientConnectedEvent e) {
/* 356 */     ServerGroup s = MajaQuery.connection.getServer().getServerGroupByServerGroupID(8);
/* 357 */     boolean group = e.getClient().getServerGroups().contains(s);
/*     */     
/* 359 */     MySQLAbfrage();
/* 360 */     if (this.verbindung)
/*     */     {
/*     */       
/* 363 */       if (group)
/*     */       {
/*     */         
/* 366 */         e.getClient().sendPrivateMessage("\n " + this.prefix.pretext + "████████████████████████████████████████████████████████████████\n\nHay [B]" + e.getClient().getName() + "[/B][/COLOR]\nWerde ein Mitglied indem du den Channel '(❤)Registrieren? [join](❤)' betrittst\n \n[COLOR=#aa0000]████████████████████████████████████████████████████████████████\n[/COLOR]");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void channelJoinEvent(ClientJoinedChannelEvent e) {
/* 376 */     Channel vChannel = e.getOldChannel();
/*     */     
/* 378 */     if (e.getChannelID() == 131) {
/*     */       
/* 380 */       ServerGroup Botgruppe = MajaQuery.connection.getServer().getServerGroupByServerGroupID(99);
/* 381 */       boolean abfrageBot = e.getClient().getServerGroups().contains(Botgruppe);
/* 382 */       e.getClient().move(vChannel, null);
/*     */       
/* 384 */       if (!abfrageBot)
/*     */       {
/* 386 */         e.getClient().sendPrivateMessage("\nWie kann ich behilflich sein ? ^^\n\n ● Sende mir einen beliebigen Befehl \n ● Du brauchst eine Liste der Befehle? Schreibe 'command' in den Chat");
/*     */       
/*     */       }
/*     */     }
/* 390 */     else if (e.getChannelID() == 184) {
/*     */       
/* 392 */       MySQLAbfrage();
/*     */       
/* 394 */       Registrieren register = new Registrieren(e.getOldChannelID(), e.getClient(), e.getChannelID());
/* 395 */       register.register();
/*     */     
/*     */     }
/* 398 */     else if (e.getChannelID() == 172) {
/*     */       
/* 400 */       ServerGroup s = MajaQuery.connection.getServer().getServerGroupByServerGroupID(8);
/* 401 */       boolean group = e.getClient().getServerGroups().contains(s);
/* 402 */       e.getClient().move(vChannel, null);
/*     */       
/* 404 */       if (!group) {
/* 405 */         e.getClient().sendPrivateMessage("[COLOR=#0000ff]\n╔════════════════╣ BefehlsListe ╠════════════════════════╗\n╠● [B]'Male'[/B] >> [COLOR=#000000]aendere/setzte dein Geschlecht[/COLOR]\n╠● [B]'Female'[/B] >> [COLOR=#000000]aendere/setzte dein Geschlecht[/COLOR]\n╠● [B]'alter <zahl>'[/B] >> [COLOR=#000000]aendere/setzte dein Alter[/COLOR]\n╠● [B]'anime <zahl>'[/B] >> [COLOR=#000000]Gib deine derzeitige Anzahl an geschauten Anime/Manga an[/COLOR]\n╠● [B]'switch [Anrede]'[/B] >> [COLOR=#000000]aender deine Anrede, z.B -> 'switch kun'[/COLOR]\n╠● [B]'switch anreden'[/B] >> [COLOR=#000000]Oeffne eine Liste aller Anreden [Commands][/COLOR]\n╠● [I][COLOR=#ffaa00]Naechste Seite -> 'command 2' eingeben[/COLOR][/I]\n╚══════════════════════════════════════════════════╝[/COLOR]");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 418 */         e.getClient().sendPrivateMessage("Registriere dich zuerst indem du in den Channel '[JOIN] Registrieren ?' joinst");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clientGotMovedEvent(ClientMovedClientEvent e) {
/* 427 */     Datenbank datenbank = new Datenbank(e.getMovedClient());
/*     */     
/* 429 */     if (e.getChannelID() == 131) {
/*     */       
/* 431 */       e.getMovedClient().sendPrivateMessage("\nWie kann ich behilflich sein ? ^^\n\n ● Sende mir einen beliebigen Befehl \n ● Du brauchst eine Liste der Befehle? Schreibe 'command' in den Chat");
/* 432 */       Channel vChannel = e.getSourceChannel();
/* 433 */       e.getMovedClient().move(vChannel);
/*     */     
/*     */     }
/* 436 */     else if (e.getChannelID() == 184) {
/*     */       
/* 438 */       MySQLAbfrage();
/*     */ 
/*     */       
/* 441 */       ServerGroup s = new ServerGroup(8);
/* 442 */       boolean group = e.getMovedClient().getServerGroups().contains(s);
/* 443 */       Channel vChannel = e.getSourceChannel();
/* 444 */       e.getMovedClient().move(vChannel);
/*     */       
/* 446 */       String eingetragen = datenbank.clientExistDB();
/*     */       
/* 448 */       if (eingetragen == "eingetragen") {
/* 449 */         e.getMovedClient().sendPrivateMessage(String.valueOf(this.prefix.preError) + "Du bist schon in der Datenbank eingetragen, falls dir Gruppen fehlen kontaktiere TuTi");
/*     */       } else {
/*     */         
/* 452 */         boolean suc = datenbank.clientAddDB();
/* 453 */         if (suc) {
/* 454 */           e.getMovedClient().sendPrivateMessage(String.valueOf(this.prefix.preServer) + "Du wurdest in die Datenbank eingetragen, da du noch nicht eingetragen warst");
/*     */         } else {
/* 456 */           e.getMovedClient().sendPrivateMessage(String.valueOf(this.prefix.preError) + "Ein Fehler ist bei der Bearbeitung vorgefallen, kontaktiere TuTi");
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/* 461 */       if (group) {
/*     */         
/* 463 */         String name = e.getMovedClient().getName();
/*     */         
/* 465 */         Server server = MajaQuery.connection.getServer();
/* 466 */         ServerGroup s1 = server.getServerGroupByServerGroupID(41);
/* 467 */         ServerGroup s2 = server.getServerGroupByServerGroupID(42);
/* 468 */         ServerGroup s3 = server.getServerGroupByServerGroupID(62);
/* 469 */         ServerGroup s4 = server.getServerGroupByServerGroupID(53);
/* 470 */         ServerGroup s5 = server.getServerGroupByServerGroupID(61);
/* 471 */         ServerGroup s6 = server.getServerGroupByServerGroupID(110);
/* 472 */         ServerGroup s7 = server.getServerGroupByServerGroupID(63);
/* 473 */         ServerGroup s8 = server.getServerGroupByServerGroupID(19);
/*     */         
/* 475 */         e.getMovedClient().addToServerGroup(s1);
/* 476 */         e.getMovedClient().addToServerGroup(s2);
/* 477 */         e.getMovedClient().addToServerGroup(s3);
/* 478 */         e.getMovedClient().addToServerGroup(s4);
/* 479 */         e.getMovedClient().addToServerGroup(s5);
/* 480 */         e.getMovedClient().addToServerGroup(s6);
/* 481 */         e.getMovedClient().addToServerGroup(s7);
/* 482 */         e.getMovedClient().addToServerGroup(s8);
/*     */         
/* 484 */         MajaQuery.connection.getQuery().sendServerMessage(String.valueOf(this.prefix.preServer) + "[COLOR=#55aa00][B]" + name + "[/B] ist von nun an ein neues Otaku-Mitglied[/COLOR]");
/*     */         
/* 486 */         e.getMovedClient().sendPrivateMessage("\n>--------------------------->Male oder Female ^^ >--------------------------->\n \n Bist du ein    [B]Male[/B]      oder      [B]Female[/B]       ???\t[Eingeben]");
/*     */       } else {
/*     */         
/* 489 */         e.getMovedClient().sendPrivateMessage("Du hast dich schon einmal registriert !");
/*     */       }
/*     */     
/* 492 */     } else if (e.getChannelID() == 172) {
/*     */ 
/*     */       
/* 495 */       ServerGroup s = MajaQuery.connection.getServer().getServerGroupByServerGroupID(8);
/* 496 */       boolean group = e.getMovedClient().getServerGroups().contains(s);
/* 497 */       Channel vChannel = e.getSourceChannel();
/* 498 */       e.getMovedClient().move(vChannel);
/*     */       
/* 500 */       if (!group) {
/* 501 */         e.getMovedClient().sendPrivateMessage("[COLOR=#0000ff]\n╔════════════════╣ BefehlsListe ╠════════════════════════╗\n╠● [B]'Male'[/B] >> [COLOR=#000000]aendere/setzte dein Geschlecht[/COLOR]\n╠● [B]'Female'[/B] >> [COLOR=#000000]aendere/setzte dein Geschlecht[/COLOR]\n╠● [B]'alter <zahl>'[/B] >> [COLOR=#000000]aendere/setzte dein Alter[/COLOR]\n╠● [B]'anime <zahl>'[/B] >> [COLOR=#000000]Gib deine derzeitige Anzahl an geschauten Anime/Manga an[/COLOR]\n╠● [B]'switch [Anrede]'[/B] >> [COLOR=#000000]aender deine Anrede, z.B -> 'switch kun'[/COLOR]\n╠● [B]'switch anreden'[/B] >> [COLOR=#000000]Oeffne eine Liste aller Anreden [Commands][/COLOR]\n╠● [I][COLOR=#ffaa00]Naechste Seite -> 'command 2' eingeben[/COLOR][/I]\n╚══════════════════════════════════════════════════╝[/COLOR]");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 514 */         e.getMovedClient().sendPrivateMessage("Registriere dich zuerst indem du in den Channel 'Registrieren ?' joinst");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ClientSendQueryPrivateMsg(ClientSentQueryPrivateMessageEvent e) {
/* 523 */     MySQLAbfrage();
/*     */ 
/*     */     
/* 526 */     Commands msgM = new Commands(e.getMessage(), e.getClient());
/* 527 */     Clientinfos clientinfo = new Clientinfos(e.getClient());
/* 528 */     Datenbank db = new Datenbank(e.getClient());
/*     */ 
/*     */ 
/*     */     
/* 532 */     String msg = e.getMessage();
/* 533 */     String msgEqual = msg;
/* 534 */     msgEqual = msgEqual.toLowerCase();
/*     */     
/* 536 */     if (msg.equalsIgnoreCase("reset")) {
/* 537 */       this.warte.remove(e.getClient());
/*     */       
/*     */       return;
/*     */     } 
/* 541 */     if (this.warte.contains(e.getClient())) {
/* 542 */       e.getClient().sendPrivateMessage("[B]Nicht so schnell![/B]  Warte bis der Befehl fertig bearbeitet ist ! [I]Sollte diese Meldung auch nach einer Wartezeit von 5 Sekunden auftauchen - > Gib den Befehl 'reset' ein[/I]");
/*     */       return;
/*     */     } 
/* 545 */     this.warte.add(e.getClient());
/*     */ 
/*     */     
/* 548 */     ServerGroup s = MajaQuery.connection.getServer().getServerGroupByServerGroupID(8);
/* 549 */     boolean registriert = e.getClient().getServerGroups().contains(s);
/*     */ 
/*     */ 
/*     */     
/* 553 */     if (!registriert) {
/*     */       
/* 555 */       if (msg.equalsIgnoreCase("male") || msg.equalsIgnoreCase("female")) {
/*     */ 
/*     */ 
/*     */         
/* 559 */         this.meldung = msgM.chooseMaleOrFemale();
/*     */         
/* 561 */         if (this.meldung == "switchToMale") {
/* 562 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preMaleFemale) + this.prefix.preSuc + "Dein Geschlecht wurde veraendert, gib dir eine Anrede mit dem 'switch' - Befehl !");
/* 563 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preMaleFemale) + this.prefix.preSuc + "Du bist nun als Junge/Mann registriert[/COLOR]");
/* 564 */         } else if (this.meldung == "switchToFemale") {
/* 565 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preMaleFemale) + this.prefix.preSuc + "Dein Geschlecht wurde veraendert, gib dir eine Anrede mit dem 'switch' - Befehl !");
/* 566 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preMaleFemale) + this.prefix.preSuc + "Du bist nun als Maedchen/Frau registriert[/COLOR]");
/* 567 */         } else if (this.meldung == "setMale") {
/* 568 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preMaleFemale) + this.prefix.preSuc + "Du bist nun als Junge/Mann registriert[/COLOR]");
/* 569 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preSystem) + "Du kannst dein Alter sowie deine bisher angeschauten Anime angeben mit den Befehlen: [B]'anime <zahl>'[/B] oder [B]'alter <zahl>'[/B] \n Befehlsliste: [B]'commands'[/B]");
/* 570 */         } else if (this.meldung == "setFemale") {
/* 571 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preMaleFemale) + this.prefix.preSuc + "Du bist nun als Maedchen/Frau registriert[/COLOR]");
/* 572 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preSystem) + "Du kannst dein Alter sowie deine bisher angeschauten Anime angeben mit den Befehlen: [B]'anime <zahl>'[/B] oder [B]'alter <zahl>'[/B] \n Befehlsliste: [B]'commands'[/B]");
/* 573 */         } else if (this.meldung == "alreadyMale") {
/* 574 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preMaleFemale) + this.prefix.preError + "Du bist schon als Junge/Mann registriert");
/* 575 */         } else if (this.meldung == "alreadyFemale") {
/* 576 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preMaleFemale) + this.prefix.preError + "Du bist schon als Maedchen/Frau registriert");
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
/*     */         }
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
/*     */       
/*     */       }
/* 624 */       else if (msgEqual.startsWith("help") || msgEqual.startsWith("befehle") || (msgEqual.startsWith("command") | msgEqual.startsWith("befehl")) != 0) {
/*     */         
/* 626 */         this.meldung = msgM.commandListe();
/*     */         
/* 628 */         if (this.meldung == "ersteSeite") {
/* 629 */           e.getClient().sendPrivateMessage("[COLOR=#0000ff]\n╔════════════════╣ BefehlsListe ╠════════════════════════╗\n╠● [B]'Male'[/B] >> [COLOR=#000000]aendere/setzte dein Geschlecht[/COLOR]\n╠● [B]'Female'[/B] >> [COLOR=#000000]aendere/setzte dein Geschlecht[/COLOR]\n╠● [B]'alter <zahl>'[/B] >> [COLOR=#000000]aendere/setzte dein Alter[/COLOR]\n╠● [B]'anime <zahl>'[/B] >> [COLOR=#000000]Gib deine derzeitige Anzahl an geschauten Anime/Manga an[/COLOR]\n╠● [B]'switch [Anrede]'[/B] >> [COLOR=#000000]aender deine Anrede, z.B -> 'switch kun'[/COLOR]\n╠● [B]'switch anreden'[/B] >> [COLOR=#000000]Oeffne eine Liste aller Anreden [Commands][/COLOR]\n╠● [I][COLOR=#ffaa00]Naechste Seite -> 'befehle 2' eingeben[/COLOR][/I]\n╚══════════════════════════════════════════════════╝[/COLOR]");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 639 */         else if (this.meldung == "zweiteSeite") {
/* 640 */           e.getClient().sendPrivateMessage("[COLOR=#0000ff]\n╔════════════════╣ BefehlsListe ╠═════════════════════════╗\n╠● [B]'befehle <seitenzahl>'[/B] >> [COLOR=#000000]oeffne eine Befehlsliste[/COLOR]\n╠● [B]'poke'[/B] >> [COLOR=#000000]Eine Gruppe, die dich vor anstupsern vor Anderen schuetzt[/COLOR]\n╚══════════════════════════════════════════════════╝[/COLOR]");
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/* 646 */           e.getClient().sendPrivateMessage("unbekannter Befehl !");
/*     */         }
/*     */       
/*     */       }
/* 650 */       else if (msgEqual.startsWith("alter")) {
/* 651 */         String meldung = msgM.alterChange();
/*     */         
/* 653 */         if (meldung == "keineAngabe") {
/* 654 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preError) + "Du hast keine Alters-Angabe angegeben!");
/* 655 */         } else if (meldung == "error") {
/* 656 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preError) + "etwas ist bei der Verarbeitung schief gelaufen, versuche es nocheinmal mit einer Altersangabe (alter 16) oder kontaktiere TuTi | Luca!");
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 661 */       else if (msgEqual.startsWith("anime") || msgEqual.startsWith("manga")) {
/* 662 */         String meldung = msgM.animeChange();
/*     */         
/* 664 */         if (meldung == "keineAngabe") {
/* 665 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preError) + "Du hast keine Anime-Angabe zur Information angegeben!");
/*     */         }
/* 667 */         else if (meldung == "[<25]") {
/* 668 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preAnimeManga) + "Du bekommst die [B]Anime/Manga " + meldung + " [/B] Gruppe");
/* 669 */         } else if (meldung == "") {
/* 670 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preAnimeManga) + "Du bekommst die [B]Anime/Manga " + meldung + " [/B] Gruppe");
/* 671 */         } else if (meldung == "[+25]") {
/* 672 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preAnimeManga) + "Du bekommst die [B]Anime/Manga " + meldung + " [/B] Gruppe");
/* 673 */         } else if (meldung == "[+50]") {
/* 674 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preAnimeManga) + "Du bekommst die [B]Anime/Manga " + meldung + " [/B] Gruppe");
/* 675 */         } else if (meldung == "[+75]") {
/* 676 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preAnimeManga) + "Du bekommst die [B]Anime/Manga " + meldung + " [/B] Gruppe");
/* 677 */         } else if (meldung == "[+100]") {
/* 678 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preAnimeManga) + "Du bekommst die [B]Anime/Manga " + meldung + " [/B] Gruppe");
/* 679 */         } else if (meldung == "[+250]") {
/* 680 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preAnimeManga) + "Du bekommst die [B]Anime/Manga " + meldung + " [/B] Gruppe");
/* 681 */         } else if (meldung == "[+500]") {
/* 682 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preAnimeManga) + "Du bekommst die [B]Anime/Manga " + meldung + " [/B] Gruppe");
/* 683 */         } else if (meldung != "error") {
/*     */ 
/*     */           
/* 686 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preError) + "etwas ist bei der Verarbeitung schief gelaufen, versuche es nocheinmal oder kontaktiere TuTi | Luca!");
/*     */         }
/*     */       
/* 689 */       } else if (msg.startsWith("msg") || msg.startsWith("Msg")) {
/* 690 */         msgM.msgTuti();
/*     */       }
/* 692 */       else if (msgEqual.startsWith("switch")) {
/*     */ 
/*     */         
/* 695 */         String[] msgTeile = msg.split(" ");
/* 696 */         String anrede = "";
/*     */         
/*     */         try {
/* 699 */           if (msgTeile.length >= 1) {
/* 700 */             anrede = String.valueOf(anrede) + msgTeile[1];
/*     */           } else {
/* 702 */             anrede = "";
/*     */           } 
/* 704 */         } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */         
/* 708 */         String meldung = msgM.anredeChange(anrede);
/*     */         
/* 710 */         if (meldung == "") {
/* 711 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preError) + "Du hast KEINE/FALSCHE Angaben zum Switch-Befehl gegeben! Versuche >> 'switch anreden'");
/* 712 */         } else if (meldung == "sucSwitchAnrede") {
/* 713 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preSwitch) + "Du hast nun folgende Anrede als Suffix (hinter deinem Namen) >> [B]-" + anrede + "[/B]");
/* 714 */         } else if (meldung == "noMale") {
/* 715 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preSwitch) + "Du besitz nicht die Gruppe [B]Male[/B] und kannst somit auch nicht zu einer maennliche Anrede wechseln ! >> Benutze den Befehl>> 'male'");
/* 716 */         } else if (meldung == "noFemale") {
/* 717 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preSwitch) + "Du besitz nicht die Gruppe [B]Female[/B] und kannst somit auch nicht zu einer weiblichen Anrede wechseln ! >> Benutze den Befehl>> 'Female'");
/* 718 */         } else if (meldung == "nichtFreigeschaltet") {
/* 719 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preSwitch) + "Du hast diese Anrede noch NICHT freigeschalten. Level dich hoch, um diese freizuschalten. (durch Aufenthalt auf dem Teamspeak-Server)");
/* 720 */         } else if (meldung == "noGender") {
/* 721 */           e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preSwitch) + "Du besitz nicht keine [B]Geschlechts-Gruppe[/B] und kannst somit auch nicht zu einer Anrede wechseln ! >> Benutze den Befehl>> 'male' oder 'female'");
/* 722 */         } else if (meldung == "anreden") {
/* 723 */           e.getClient().sendPrivateMessage("[COLOR=#0000ff]\n╔════════════════╣ AnredenListe ╠════════════════════════╗\n╠● [Level]       [MALE]             [FEMALE]\n║\n╠● [04]            kun                   chan\n╠● [07]            senpai              senpai\n╠● [12]            sensei              sensei\n╠● [16]            hakase             hakase\n╠● [20]            sama                sama\n╠● [23]            dono                hime-sama\n╠● [26]            otouto-chan     imouto-chan\n╠● [27]            onii-san            onee-san\n╠● [28]            onii-chan          onee-chan\n╠● [30]            onii-sama         onee-sama\n╚══════════════════════════════════════════════════╝[/COLOR]");
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
/*     */ 
/*     */         
/*     */         }
/* 738 */         else if (meldung != "liste") {
/*     */ 
/*     */           
/* 741 */           e.getClient().sendPrivateMessage("\n[COLOR=#aa0000][B][Switch] >> [/B]Der Switch Befehl war NICHT Korrekt. Versuche z.B : [B]'switch kun'[/B][/COLOR] \n [B]>>[/B] Geben diesen Befehl ein um eine Liste an Switch-Befehlen zubekommen: [B]'switch anreden'[/B] ");
/*     */         }
/*     */       
/*     */       }
/* 745 */       else if (msgEqual.startsWith("poke") || msgEqual.startsWith("anstupsen")) {
/* 746 */         msgM.poke();
/*     */       
/*     */       }
/* 749 */       else if (msg.equalsIgnoreCase("resetanituber")) {
/* 750 */         b1 = false;
/*     */       }
/* 752 */       else if (msg.equalsIgnoreCase("anituber157")) {
/*     */         
/* 754 */         msgM.aniTuber();
/* 755 */         e.getClient().sendPrivateMessage("Dein Channel wurde erfolgreich erstellt. Bei Fragen PrivatMessage an Luca/TuTI EgG >> msg tuti <deine Nachricht>");
/* 756 */         b1 = true;
/*     */       }
/* 758 */       else if (msgEqual.startsWith("rundruf") || msgEqual.startsWith("broadcast")) {
/* 759 */         msgM.rundruf();
/*     */       }
/*     */       else {
/*     */         
/* 763 */         e.getClient().sendPrivateMessage("unbekannter Befehl !");
/*     */       } 
/*     */     } else {
/* 766 */       e.getClient().sendPrivateMessage(String.valueOf(this.prefix.preSystem) + "[COLOR=#ff0000]Du hast dich noch nicht [B]registriert[/B], weshalb du auch nicht berechtigt bist Befehle einzugeben![/COLOR]");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 772 */     this.warte.remove(e.getClient());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void afk(Client cl) {
/* 781 */     Channel c1 = new Channel(245);
/* 782 */     int channel1 = c1.getChannelID();
/* 783 */     Channel c2 = new Channel(246);
/* 784 */     int channel2 = c2.getChannelID();
/* 785 */     Channel c3 = new Channel(247);
/* 786 */     int channel3 = c3.getChannelID();
/* 787 */     Channel c4 = new Channel(248);
/* 788 */     int channel4 = c4.getChannelID();
/* 789 */     Channel c5 = new Channel(250);
/* 790 */     int channel5 = c5.getChannelID();
/* 791 */     Channel c6 = new Channel(237);
/* 792 */     int channel6 = c6.getChannelID();
/* 793 */     Channel c7 = new Channel(238);
/* 794 */     int channel7 = c7.getChannelID();
/* 795 */     Channel c8 = new Channel(259);
/* 796 */     int channel8 = c8.getChannelID();
/* 797 */     Channel c9 = new Channel(268);
/* 798 */     int channel9 = c9.getChannelID();
/*     */ 
/*     */     
/* 801 */     int client = cl.getChannel().getChannelID();
/*     */     
/* 803 */     if (client != channel1 && client != channel2 && client != channel3 && client != channel4 && client != channel5 && client != channel6 && client != channel7 && client != channel8 && client != channel9) {
/* 804 */       Channel cAfk = new Channel(250);
/* 805 */       int channelAfk = cAfk.getChannelID();
/* 806 */       cl.move(channelAfk, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void temporaryHighRights(ChannelCreatedEvent e) {
/* 816 */     ChannelType wennTemporary = e.getChannel().getChannelType();
/*     */ 
/*     */ 
/*     */     
/* 820 */     if (wennTemporary == ChannelType.TEMPORARY) {
/*     */       
/* 822 */       ServerGroup highRights = MajaQuery.connection.getServer().getServerGroupByServerGroupID(66);
/* 823 */       boolean abfrageHighRights = e.getClient().getServerGroups().contains(highRights);
/*     */       
/* 825 */       if (abfrageHighRights) {
/*     */         
/* 827 */         ChannelGroup channeladmin = MajaQuery.connection.getServer().getChannelGroupByChannelGroupID(12);
/*     */         
/* 829 */         e.getClient().setChannelGroup(channeladmin);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mmlpv\OneDrive\Desktop\Java programmiert\Tuti_Query.jar!\main\EventListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */