/*      */ package main;
/*      */ 
/*      */ import de.tevOnce.MajaQuery.MajaQuery;
/*      */ import de.tevOnce.MajaQuery.objects.Channel;
/*      */ import de.tevOnce.MajaQuery.objects.ChannelGroup;
/*      */ import de.tevOnce.MajaQuery.objects.Client;
/*      */ import de.tevOnce.MajaQuery.objects.OfflineClient;
/*      */ import de.tevOnce.MajaQuery.objects.Permission;
/*      */ import de.tevOnce.MajaQuery.objects.Server;
/*      */ import de.tevOnce.MajaQuery.objects.ServerGroup;
/*      */ import de.tevOnce.MajaQuery.objects.enumerations.ChannelType;
/*      */ import de.tevOnce.MajaQuery.objects.enumerations.PermissionType;
/*      */ import java.util.ArrayList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Commands
/*      */ {
/*      */   private String msg;
/*      */   private Client client;
/*      */   
/*      */   public Commands(String msg, Client client) {
/*   24 */     this.msg = msg;
/*   25 */     this.client = client;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isMale() {
/*   30 */     return this.client.getServerGroups().contains(new ServerGroup(67));
/*      */   }
/*      */   public boolean isFemale() {
/*   33 */     return this.client.getServerGroups().contains(new ServerGroup(68));
/*      */   }
/*      */ 
/*      */   
/*      */   public void anredeRemoveMale() {
/*   38 */     ArrayList<ServerGroup> sergroups = this.client.getServerGroups();
/*   39 */     for (int i = 0; i < sergroups.size(); i++) {
/*   40 */       if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 53) {
/*   41 */         this.client.removeFromServerGroup(new ServerGroup(53));
/*      */       }
/*   43 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 28) {
/*   44 */         this.client.removeFromServerGroup(new ServerGroup(28));
/*      */       }
/*   46 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 29) {
/*   47 */         this.client.removeFromServerGroup(new ServerGroup(29));
/*      */       }
/*   49 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 30) {
/*   50 */         this.client.removeFromServerGroup(new ServerGroup(30));
/*      */       }
/*   52 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 31) {
/*   53 */         this.client.removeFromServerGroup(new ServerGroup(31));
/*      */       }
/*   55 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 32) {
/*   56 */         this.client.removeFromServerGroup(new ServerGroup(32));
/*      */       }
/*   58 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 33) {
/*   59 */         this.client.removeFromServerGroup(new ServerGroup(33));
/*      */       }
/*   61 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 101) {
/*   62 */         this.client.removeFromServerGroup(new ServerGroup(101));
/*      */       }
/*   64 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 102) {
/*   65 */         this.client.removeFromServerGroup(new ServerGroup(102));
/*      */       }
/*   67 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 103) {
/*   68 */         this.client.removeFromServerGroup(new ServerGroup(103));
/*      */       }
/*   70 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 104) {
/*   71 */         this.client.removeFromServerGroup(new ServerGroup(104));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void anredeRemoveFemale() {
/*   80 */     ArrayList<ServerGroup> sergroups = this.client.getServerGroups();
/*   81 */     for (int i = 0; i < sergroups.size(); i++) {
/*   82 */       if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 53) {
/*   83 */         this.client.removeFromServerGroup(new ServerGroup(53));
/*      */       }
/*   85 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 34) {
/*   86 */         this.client.removeFromServerGroup(new ServerGroup(34));
/*      */       }
/*   88 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 35) {
/*   89 */         this.client.removeFromServerGroup(new ServerGroup(35));
/*      */       }
/*   91 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 36) {
/*   92 */         this.client.removeFromServerGroup(new ServerGroup(36));
/*      */       }
/*   94 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 37) {
/*   95 */         this.client.removeFromServerGroup(new ServerGroup(37));
/*      */       }
/*   97 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 38) {
/*   98 */         this.client.removeFromServerGroup(new ServerGroup(38));
/*      */       }
/*  100 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 39) {
/*  101 */         this.client.removeFromServerGroup(new ServerGroup(39));
/*      */       }
/*  103 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 108) {
/*  104 */         this.client.removeFromServerGroup(new ServerGroup(108));
/*      */       }
/*  106 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 105) {
/*  107 */         this.client.removeFromServerGroup(new ServerGroup(105));
/*      */       }
/*  109 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 106) {
/*  110 */         this.client.removeFromServerGroup(new ServerGroup(106));
/*      */       }
/*  112 */       else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 107) {
/*  113 */         this.client.removeFromServerGroup(new ServerGroup(107));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String chooseMaleOrFemale() {
/*  124 */     Server server = MajaQuery.connection.getServer();
/*      */     
/*  126 */     boolean groupFemale = isFemale();
/*  127 */     boolean groupMale = isMale();
/*      */     
/*  129 */     if (this.msg.equalsIgnoreCase("male")) {
/*  130 */       if (groupFemale) {
/*      */ 
/*      */         
/*  133 */         this.client.removeFromServerGroup(server.getServerGroupByServerGroupID(68));
/*  134 */         this.client.addToServerGroup(server.getServerGroupByServerGroupID(67));
/*      */         
/*  136 */         anredeRemoveFemale();
/*  137 */         this.client.addToServerGroup(server.getServerGroupByServerGroupID(53));
/*      */         
/*  139 */         return "switchToMale";
/*      */       } 
/*  141 */       if (groupMale) {
/*  142 */         return "alreadyMale";
/*      */       }
/*      */       
/*  145 */       this.client.addToServerGroup(server.getServerGroupByServerGroupID(67));
/*  146 */       return "setMale";
/*      */     } 
/*      */ 
/*      */     
/*  150 */     if (this.msg.equalsIgnoreCase("female")) {
/*  151 */       if (groupMale) {
/*      */         
/*  153 */         this.client.removeFromServerGroup(server.getServerGroupByServerGroupID(67));
/*  154 */         this.client.addToServerGroup(server.getServerGroupByServerGroupID(68));
/*      */         
/*  156 */         anredeRemoveMale();
/*  157 */         this.client.addToServerGroup(server.getServerGroupByServerGroupID(53));
/*      */         
/*  159 */         return "switchToFemale";
/*      */       } 
/*  161 */       if (groupFemale) {
/*  162 */         return "alreadyFemale";
/*      */       }
/*      */       
/*  165 */       this.client.addToServerGroup(server.getServerGroupByServerGroupID(68));
/*  166 */       return "setFemale";
/*      */     } 
/*      */     
/*  169 */     return "fail";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String commandListe() {
/*  176 */     String msgEqual = this.msg;
/*  177 */     msgEqual = msgEqual.toLowerCase();
/*      */     
/*  179 */     if (msgEqual.endsWith("befehl") || msgEqual.endsWith("befehle") || msgEqual.startsWith("1", 8) || msgEqual.startsWith("1", 7) || msgEqual.endsWith("commands") || msgEqual.endsWith("command"))
/*      */     {
/*  181 */       return "ersteSeite";
/*      */     }
/*  183 */     if (msgEqual.startsWith("2", 8) || msgEqual.startsWith("2", 7))
/*      */     {
/*  185 */       return "zweiteSeite";
/*      */     }
/*  187 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void aniTuber() {
/*  193 */     Server server = MajaQuery.connection.getServer();
/*  194 */     String name = this.client.getName();
/*  195 */     String channelname = String.valueOf(name) + "'s Youtube Channel";
/*      */     
/*  197 */     ServerGroup serverGruppe = server.getServerGroupByServerGroupID(100);
/*  198 */     int channelOberhaupt = server.getChannelByName("【★】TuTi EgG's YT-Channel").getChannelID();
/*  199 */     ChannelGroup channelGroup = server.getChannelGroupByChannelGroupID(13);
/*  200 */     Channel botChannel = server.getChannelByName("[spacer](❤)Home of the Command-Bots(❤)");
/*      */     
/*  202 */     this.client.addToServerGroup(serverGruppe);
/*  203 */     Channel channel = MajaQuery.connection.getQuery().createChannel(channelname, 0, 0, ChannelType.PERMANENT);
/*      */     
/*  205 */     channel.setTopic(name);
/*  206 */     channel.setPermission(new Permission(PermissionType.i_ft_needed_file_browse_power, 100, false, false));
/*  207 */     channel.move(channelOberhaupt);
/*  208 */     this.client.move(channel);
/*      */ 
/*      */     
/*  211 */     this.client.setChannelGroup(channelGroup);
/*  212 */     MajaQuery.connection.getQuery().getClient().move(botChannel);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String alterChange() {
/*  218 */     String meldung = "";
/*  219 */     String msgEqual = this.msg;
/*  220 */     msgEqual = msgEqual.toLowerCase();
/*      */     
/*  222 */     if (msgEqual.startsWith("alter")) {
/*      */       
/*  224 */       String[] msgTeile = this.msg.split(" ");
/*      */       
/*  226 */       int alter = -1;
/*  227 */       for (int i = 1; i < msgTeile.length; i++) {
/*  228 */         if (!msgTeile[i].equals("")) {
/*      */           try {
/*  230 */             alter = Integer.parseInt(msgTeile[i]);
/*  231 */           } catch (Exception e) {
/*      */             
/*  233 */             this.client.sendPrivateMessage("[B][COLOR=#ffaa00][Alter]>>[/COLOR][/B]  [I][B]" + msgTeile[i] + "[/B][/I]     ist keine Zahl");
/*  234 */             this.client.sendPrivateMessage("[B][COLOR=#ffaa00][Alter]>>[/COLOR][/B] Gib eine Zahl als Altersangabe an! :");
/*  235 */             return "Fehler";
/*      */           } 
/*      */         }
/*      */       } 
/*      */       
/*  240 */       boolean returnSuc = setAlter(alter, this.client);
/*  241 */       if (returnSuc) {
/*  242 */         this.client.sendPrivateMessage("[B][COLOR=#ffaa00][Alter]>>[/COLOR][/B] Du hast folgendes Alter angegeben: " + alter);
/*      */       }
/*  244 */       else if (alter == -1) {
/*  245 */         meldung = "keineAngabe";
/*      */       } else {
/*      */         
/*  248 */         meldung = "error";
/*      */       } 
/*      */     } 
/*  251 */     return meldung;
/*      */   }
/*      */   
/*      */   public String animeChange() {
/*  255 */     String[] msgTeile = this.msg.split(" ");
/*      */     
/*  257 */     int anime = -1;
/*  258 */     for (int i = 1; i < msgTeile.length; i++) {
/*  259 */       if (!msgTeile[i].equals("")) {
/*      */         try {
/*  261 */           anime = Integer.parseInt(msgTeile[i]);
/*      */         }
/*  263 */         catch (Exception fehler) {
/*  264 */           this.client.sendPrivateMessage("[B][COLOR=#ffaa00][Anime/Manga]>>[/COLOR][/B] [I][B]" + msgTeile[i] + "[/B][/I]     ist keine Zahl");
/*  265 */           this.client.sendPrivateMessage("[B][COLOR=#ffaa00][Anime/Manga]>>[/COLOR][/B] Gib eine Zahl als Angabe an! :");
/*  266 */           return "error";
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  271 */     String returnMeldung = setAnime(anime, this.client);
/*      */     
/*  273 */     if (returnMeldung != "keineAngabe")
/*      */     {
/*      */       
/*  276 */       this.client.sendPrivateMessage("[B][COLOR=#ffaa00][Anime/Manga]>>[/COLOR][/B] Du hast folgendes angegeben: " + anime);
/*      */     }
/*      */     
/*  279 */     return returnMeldung;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String anredeChange(String msgAnrede) {
/*  285 */     OfflineClient clientM = MajaQuery.connection.getServer().getOfflineClientByUID("AGznjpcsnKbEQQQyYLAV7cUdUJI=");
/*  286 */     String clientName = this.client.getName();
/*  287 */     String clientUID = this.client.getUID();
/*      */     
/*  289 */     String msgEqual = this.msg;
/*  290 */     msgEqual = msgEqual.toLowerCase();
/*  291 */     Datenbank db = new Datenbank(this.client, this.msg);
/*      */     
/*  293 */     String meldung = "";
/*  294 */     int abfrageRechte = db.getLevel(clientUID);
/*      */ 
/*      */     
/*  297 */     if (abfrageRechte == -3) {
/*  298 */       clientM.sendOfflineMessage("Anrede Change von " + clientName, "Bei der Bearbeitung des Clienten: " + clientUID + "  ->Ein Fehler ist aufgetreten!!!!!!!!!!!!!!!");
/*  299 */     } else if (abfrageRechte == -2) {
/*  300 */       this.client.sendPrivateMessage("Du hast noch keine Punkte bekommen, kontaktiere TuTi!");
/*  301 */       clientM.sendOfflineMessage("Anrede Change von " + clientName, "Bei der Bearbeitung des Clienten: " + clientUID + "  ->keine Punkte in der DB!!!!!!!!!!!!!!!");
/*  302 */     } else if (abfrageRechte == -1) {
/*  303 */       this.client.sendPrivateMessage("Du wurdest noch nicht in die Datenbank eingetragen, joine dem 'Registieren ?' Channel oder kontaktiere TuTi !");
/*  304 */     } else if (msgEqual.startsWith("kun", 7)) {
/*  305 */       if (abfrageRechte >= 4) {
/*  306 */         if (isMale()) {
/*  307 */           anredeRemoveMale();
/*  308 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(28);
/*  309 */           this.client.addToServerGroup(anrede);
/*  310 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  312 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  314 */           meldung = "noMale";
/*      */         } 
/*      */       } else {
/*  317 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  320 */     } else if (msgEqual.startsWith("chan", 7)) {
/*  321 */       if (abfrageRechte >= 4) {
/*  322 */         if (isFemale()) {
/*      */           
/*  324 */           anredeRemoveFemale();
/*  325 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(34);
/*  326 */           this.client.addToServerGroup(anrede);
/*  327 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  329 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  331 */           meldung = "noFemale";
/*      */         } 
/*      */       } else {
/*  334 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  337 */     } else if (msgEqual.startsWith("senpai", 7)) {
/*  338 */       if (abfrageRechte >= 7) {
/*  339 */         if (isMale()) {
/*      */           
/*  341 */           anredeRemoveMale();
/*  342 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(29);
/*  343 */           this.client.addToServerGroup(anrede);
/*  344 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  346 */           meldung = "sucSwitchAnrede";
/*      */         }
/*  348 */         else if (isFemale()) {
/*      */           
/*  350 */           anredeRemoveFemale();
/*  351 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(35);
/*  352 */           this.client.addToServerGroup(anrede);
/*  353 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  355 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*      */           
/*  358 */           meldung = "noGender";
/*      */         } 
/*      */       } else {
/*  361 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  364 */     } else if (msgEqual.startsWith("sensei", 7)) {
/*  365 */       if (abfrageRechte >= 12) {
/*  366 */         if (isMale()) {
/*      */           
/*  368 */           anredeRemoveMale();
/*  369 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(30);
/*  370 */           this.client.addToServerGroup(anrede);
/*  371 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  373 */           meldung = "sucSwitchAnrede";
/*      */         }
/*  375 */         else if (isFemale()) {
/*      */           
/*  377 */           anredeRemoveFemale();
/*  378 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(36);
/*  379 */           this.client.addToServerGroup(anrede);
/*  380 */           db.updateDBAnrede(msgAnrede);
/*  381 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*      */           
/*  384 */           meldung = "noGender";
/*      */         } 
/*      */       } else {
/*  387 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  390 */     } else if (msgEqual.startsWith("hakase", 7)) {
/*  391 */       if (abfrageRechte >= 16) {
/*  392 */         if (isMale()) {
/*      */           
/*  394 */           anredeRemoveMale();
/*  395 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(31);
/*  396 */           this.client.addToServerGroup(anrede);
/*  397 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  399 */           meldung = "sucSwitchAnrede";
/*      */         }
/*  401 */         else if (isFemale()) {
/*      */           
/*  403 */           anredeRemoveFemale();
/*  404 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(37);
/*  405 */           this.client.addToServerGroup(anrede);
/*  406 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  408 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*      */           
/*  411 */           meldung = "noGender";
/*      */         } 
/*      */       } else {
/*  414 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  417 */     } else if (msgEqual.startsWith("sama", 7)) {
/*  418 */       if (abfrageRechte >= 20) {
/*  419 */         if (isMale()) {
/*      */           
/*  421 */           anredeRemoveMale();
/*  422 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(32);
/*  423 */           this.client.addToServerGroup(anrede);
/*  424 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  426 */           meldung = "sucSwitchAnrede";
/*      */         }
/*  428 */         else if (isFemale()) {
/*      */           
/*  430 */           anredeRemoveFemale();
/*  431 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(38);
/*  432 */           this.client.addToServerGroup(anrede);
/*  433 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  435 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*      */           
/*  438 */           meldung = "noGender";
/*      */         } 
/*      */       } else {
/*  441 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  444 */     } else if (msgEqual.startsWith("dono", 7)) {
/*  445 */       if (abfrageRechte >= 23) {
/*  446 */         if (isMale()) {
/*      */           
/*  448 */           anredeRemoveMale();
/*  449 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(33);
/*  450 */           this.client.addToServerGroup(anrede);
/*  451 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  453 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  455 */           meldung = "noMale";
/*      */         } 
/*      */       } else {
/*  458 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  461 */     } else if (msgEqual.startsWith("hime-sama", 7)) {
/*  462 */       if (abfrageRechte >= 23) {
/*  463 */         if (isFemale()) {
/*      */           
/*  465 */           anredeRemoveFemale();
/*  466 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(39);
/*  467 */           this.client.addToServerGroup(anrede);
/*  468 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  470 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  472 */           meldung = "noFemale";
/*      */         } 
/*      */       } else {
/*  475 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  478 */     } else if (msgEqual.startsWith("otouto-chan", 7)) {
/*  479 */       if (abfrageRechte >= 26) {
/*  480 */         if (isMale()) {
/*      */           
/*  482 */           anredeRemoveMale();
/*  483 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(101);
/*  484 */           this.client.addToServerGroup(anrede);
/*  485 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  487 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  489 */           meldung = "noMale";
/*      */         } 
/*      */       } else {
/*  492 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  495 */     } else if (msgEqual.startsWith("imouto-chan", 7)) {
/*  496 */       if (abfrageRechte >= 26) {
/*  497 */         if (isFemale()) {
/*      */           
/*  499 */           anredeRemoveFemale();
/*  500 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(108);
/*  501 */           this.client.addToServerGroup(anrede);
/*  502 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  504 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  506 */           meldung = "noFemale";
/*      */         } 
/*      */       } else {
/*  509 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  512 */     } else if (msgEqual.startsWith("onii-san", 7)) {
/*  513 */       if (abfrageRechte >= 27) {
/*  514 */         if (isMale()) {
/*      */           
/*  516 */           anredeRemoveMale();
/*  517 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(102);
/*  518 */           this.client.addToServerGroup(anrede);
/*  519 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  521 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  523 */           meldung = "noMale";
/*      */         } 
/*      */       } else {
/*  526 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  529 */     } else if (msgEqual.startsWith("onee-san", 7)) {
/*  530 */       if (abfrageRechte >= 27) {
/*  531 */         if (isFemale()) {
/*      */           
/*  533 */           anredeRemoveFemale();
/*  534 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(105);
/*  535 */           this.client.addToServerGroup(anrede);
/*  536 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  538 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  540 */           meldung = "noFemale";
/*      */         } 
/*      */       } else {
/*  543 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  546 */     } else if (msgEqual.startsWith("onii-chan", 7)) {
/*  547 */       if (abfrageRechte >= 28) {
/*  548 */         if (isMale()) {
/*      */           
/*  550 */           anredeRemoveMale();
/*  551 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(103);
/*  552 */           this.client.addToServerGroup(anrede);
/*  553 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  555 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  557 */           meldung = "noMale";
/*      */         } 
/*      */       } else {
/*  560 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  563 */     } else if (msgEqual.startsWith("onee-chan", 7)) {
/*  564 */       if (abfrageRechte >= 28) {
/*  565 */         if (isFemale()) {
/*      */           
/*  567 */           anredeRemoveFemale();
/*  568 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(106);
/*  569 */           this.client.addToServerGroup(anrede);
/*  570 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  572 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  574 */           meldung = "noFemale";
/*      */         } 
/*      */       } else {
/*  577 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  580 */     } else if (msgEqual.startsWith("onii-sama", 7)) {
/*  581 */       if (abfrageRechte >= 29) {
/*  582 */         if (isMale()) {
/*      */           
/*  584 */           anredeRemoveMale();
/*  585 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(104);
/*  586 */           this.client.addToServerGroup(anrede);
/*  587 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  589 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  591 */           meldung = "noMale";
/*      */         } 
/*      */       } else {
/*  594 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  597 */     } else if (msgEqual.startsWith("onee-sama", 7)) {
/*  598 */       if (abfrageRechte >= 29) {
/*  599 */         if (isFemale()) {
/*      */           
/*  601 */           anredeRemoveFemale();
/*  602 */           ServerGroup anrede = MajaQuery.connection.getServer().getServerGroupByServerGroupID(107);
/*  603 */           this.client.addToServerGroup(anrede);
/*  604 */           db.updateDBAnrede(msgAnrede);
/*      */           
/*  606 */           meldung = "sucSwitchAnrede";
/*      */         } else {
/*  608 */           meldung = "noFemale";
/*      */         } 
/*      */       } else {
/*  611 */         meldung = "nichtFreigeschaltet";
/*      */       }
/*      */     
/*  614 */     } else if (msgEqual.startsWith("anreden", 7)) {
/*      */       
/*  616 */       this.client.sendPrivateMessage("[COLOR=#0000ff]\n╔════════════════╣ AnredenListe ╠════════════════════════╗\n╠● [Level]       [MALE]             [FEMALE]\n║\n╠● [04]            kun                   chan\n╠● [07]            senpai              senpai\n╠● [12]            sensei              sensei\n╠● [16]            hakase             hakase\n╠● [20]            sama                sama\n╠● [23]            dono                hime-sama\n╠● [26]            otouto-chan     imouto-chan\n╠● [27]            onii-san            onee-san\n╠● [28]            onii-chan          onee-chan\n╠● [30]            onii-sama         onee-sama\n╚══════════════════════════════════════════════════╝[/COLOR]");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  631 */       meldung = "liste";
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  636 */     return meldung;
/*      */   }
/*      */ 
/*      */   
/*      */   public void poke() {
/*  641 */     ServerGroup poke = MajaQuery.connection.getServer().getServerGroupByServerGroupID(120);
/*      */ 
/*      */     
/*  644 */     if (this.client.getServerGroups().contains(poke)) {
/*  645 */       this.client.removeFromServerGroup(poke);
/*  646 */     } else if (!this.client.getServerGroups().contains(poke)) {
/*  647 */       this.client.sendPrivateMessage("[B][COLOR=#ffaa00][System]>>[/COLOR][/B] Gebe den selben Befehl nocheinmal ein oder reconnect um diese Gruppe zu entfernen!");
/*  648 */       this.client.addToServerGroup(poke);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void rundruf() {
/*  653 */     ServerGroup anituber = MajaQuery.connection.getServer().getServerGroupByServerGroupID(100);
/*  654 */     boolean anituberAbfrage = this.client.getServerGroups().contains(anituber);
/*      */     
/*  656 */     ServerGroup kami = MajaQuery.connection.getServer().getServerGroupByServerGroupID(10);
/*  657 */     boolean kamiAbfrage = this.client.getServerGroups().contains(kami);
/*      */     
/*  659 */     if (anituberAbfrage || kamiAbfrage) {
/*      */ 
/*      */       
/*  662 */       String[] msgTeile = this.msg.split(" ");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  671 */       int l = msgTeile.length;
/*      */       
/*  673 */       String msgToS = "";
/*      */       
/*  675 */       for (int i = 1; i < l; i++) {
/*  676 */         msgToS = String.valueOf(msgToS) + " " + msgTeile[i];
/*      */       }
/*  678 */       String name = this.client.getName();
/*  679 */       String rundruf = "[COLOR=#23ccff][B][COLOR=#ffaa00][Rundruf]>>[/COLOR]" + msgToS + "   [/B][I]~by " + name + "[/I][/COLOR]";
/*  680 */       MajaQuery.connection.getQuery().sendServerMessage(rundruf);
/*      */     } else {
/*      */       
/*  683 */       this.client.sendPrivateMessage("[B][COLOR=#ffaa00][System]>>[/COLOR][/B] Du bist nicht berechtigt diesen Befehl einzugeben!");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void msgTuti() {
/*  689 */     String msgEqual = this.msg;
/*  690 */     msgEqual = msgEqual.toLowerCase();
/*      */     
/*  692 */     String Luca = "AGznjpcsnKbEQQQyYLAV7cUdUJI=";
/*      */     
/*  694 */     if (msgEqual.startsWith("tuti", 4)) {
/*      */       
/*  696 */       OfflineClient nameZielPerson = MajaQuery.connection.getServer().getOfflineClientByUID(Luca);
/*  697 */       String name = nameZielPerson.getLastName();
/*  698 */       String sender = this.client.getName();
/*      */       
/*  700 */       nameZielPerson.sendOfflineMessage("Nachricht von " + sender, this.msg.substring(9));
/*  701 */       this.client.sendPrivateMessage("Folgende Nachricht wurde [COLOR=#005500]erfolgreich[/COLOR] an TuTi versendet >> \n\n[I][COLOR=#ffaa00] '" + this.msg.substring(9) + "'[/I]");
/*      */     }
/*  703 */     else if (msgEqual.startsWith("kirino", 4)) {
/*      */       
/*  705 */       OfflineClient nameZielPerson = MajaQuery.connection.getServer().getOfflineClientByUID("");
/*  706 */       String name = nameZielPerson.getLastName();
/*  707 */       String sender = this.client.getName();
/*      */       
/*  709 */       nameZielPerson.sendOfflineMessage("Nachricht von " + sender, this.msg.substring(11));
/*  710 */       this.client.sendPrivateMessage("Folgende Nachricht wurde [COLOR=#005500]erfolgreich[/COLOR] an " + name + " versendet >> \n\n[I][COLOR=#ffaa00] '" + this.msg + "'[/I]");
/*      */     } else {
/*      */       
/*  713 */       this.client.sendPrivateMessage("[COLOR=#aa0000]FEHLER >>[/COLOR] Diese Zielperson gibt es nicht oder der Befehl wurde falsche eingegeben. Versuche diesen Befehl zu benutzen: [COLOR=#ffaa00]'msg <Emfaenger/Zielperson(z.B tuti)> <deine Nachricht>'[/COLOR] (Achte auf Groß-, und Kleinschreibung [Bei diesem Befehl])");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAlter(int alter, Client client) {
/*  721 */     if (alter == -1) {
/*  722 */       return false;
/*      */     }
/*      */     
/*  725 */     if (alter < 12) {
/*      */       
/*  727 */       ServerGroup s1 = new ServerGroup(119);
/*      */       
/*  729 */       if (!client.getServerGroups().contains(s1)) {
/*  730 */         client.addToServerGroup(s1);
/*      */       }
/*      */       
/*  733 */       ArrayList<ServerGroup> sergroups = client.getServerGroups();
/*  734 */       for (int i = 0; i < sergroups.size(); i++) {
/*  735 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 112) {
/*  736 */           client.removeFromServerGroup(new ServerGroup(112));
/*      */         }
/*  738 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 113) {
/*  739 */           client.removeFromServerGroup(new ServerGroup(113));
/*      */         }
/*  741 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 114) {
/*  742 */           client.removeFromServerGroup(new ServerGroup(114));
/*      */         } 
/*      */       } 
/*      */       
/*  746 */       return true;
/*      */     } 
/*  748 */     if (alter >= 12 && alter < 16) {
/*      */       
/*  750 */       ServerGroup s1 = new ServerGroup(112);
/*      */       
/*  752 */       if (!client.getServerGroups().contains(s1)) {
/*  753 */         client.addToServerGroup(s1);
/*      */       }
/*      */       
/*  756 */       ArrayList<ServerGroup> sergroups = client.getServerGroups();
/*  757 */       for (int i = 0; i < sergroups.size(); i++) {
/*  758 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 119) {
/*  759 */           client.removeFromServerGroup(new ServerGroup(119));
/*      */         }
/*  761 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 113) {
/*  762 */           client.removeFromServerGroup(new ServerGroup(113));
/*      */         }
/*  764 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 114) {
/*  765 */           client.removeFromServerGroup(new ServerGroup(114));
/*      */         } 
/*      */       } 
/*      */       
/*  769 */       return true;
/*      */     } 
/*  771 */     if (alter >= 16 && alter < 18) {
/*      */       
/*  773 */       ServerGroup s1 = new ServerGroup(113);
/*  774 */       if (!client.getServerGroups().contains(s1)) {
/*  775 */         client.addToServerGroup(s1);
/*      */       }
/*      */       
/*  778 */       ArrayList<ServerGroup> sergroups = client.getServerGroups();
/*  779 */       for (int i = 0; i < sergroups.size(); i++) {
/*  780 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 112) {
/*  781 */           client.removeFromServerGroup(new ServerGroup(112));
/*      */         }
/*  783 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 119) {
/*  784 */           client.removeFromServerGroup(new ServerGroup(119));
/*      */         }
/*  786 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 114) {
/*  787 */           client.removeFromServerGroup(new ServerGroup(114));
/*      */         } 
/*      */       } 
/*      */       
/*  791 */       return true;
/*      */     } 
/*  793 */     if (alter >= 18) {
/*      */       
/*  795 */       ServerGroup s1 = new ServerGroup(114);
/*      */       
/*  797 */       if (!client.getServerGroups().contains(s1)) {
/*  798 */         client.addToServerGroup(s1);
/*      */       }
/*      */       
/*  801 */       ArrayList<ServerGroup> sergroups = client.getServerGroups();
/*  802 */       for (int i = 0; i < sergroups.size(); i++) {
/*  803 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 112) {
/*  804 */           client.removeFromServerGroup(new ServerGroup(112));
/*      */         }
/*  806 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 113) {
/*  807 */           client.removeFromServerGroup(new ServerGroup(113));
/*      */         }
/*  809 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 119) {
/*  810 */           client.removeFromServerGroup(new ServerGroup(119));
/*      */         } 
/*      */       } 
/*      */       
/*  814 */       return true;
/*      */     } 
/*      */ 
/*      */     
/*  818 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String setAnime(int zahl, Client client) {
/*  824 */     int anime = zahl;
/*      */     
/*  826 */     String meldung = "";
/*      */     
/*  828 */     if (anime == -1) {
/*  829 */       meldung = "keineAngabe";
/*      */     
/*      */     }
/*  832 */     else if (anime < 25) {
/*      */       
/*  834 */       ServerGroup s1 = new ServerGroup(123);
/*      */       
/*  836 */       if (!client.getServerGroups().contains(s1)) {
/*  837 */         client.addToServerGroup(s1);
/*      */       }
/*      */       
/*  840 */       ArrayList<ServerGroup> sergroups = client.getServerGroups();
/*  841 */       for (int i = 0; i < sergroups.size(); i++) {
/*  842 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 115) {
/*  843 */           client.removeFromServerGroup(new ServerGroup(115));
/*      */         }
/*  845 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 116) {
/*  846 */           client.removeFromServerGroup(new ServerGroup(116));
/*      */         }
/*  848 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 117) {
/*  849 */           client.removeFromServerGroup(new ServerGroup(117));
/*      */         }
/*  851 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 118) {
/*  852 */           client.removeFromServerGroup(new ServerGroup(118));
/*      */         }
/*  854 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 121) {
/*  855 */           client.removeFromServerGroup(new ServerGroup(121));
/*      */         }
/*  857 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 122) {
/*  858 */           client.removeFromServerGroup(new ServerGroup(122));
/*      */         } 
/*      */       } 
/*      */       
/*  862 */       meldung = "[<25]";
/*      */     
/*      */     }
/*  865 */     else if (anime >= 25 && anime < 50) {
/*      */       
/*  867 */       ServerGroup s1 = new ServerGroup(122);
/*      */       
/*  869 */       if (!client.getServerGroups().contains(s1)) {
/*  870 */         client.addToServerGroup(s1);
/*      */       }
/*      */       
/*  873 */       ArrayList<ServerGroup> sergroups = client.getServerGroups();
/*  874 */       for (int i = 0; i < sergroups.size(); i++) {
/*  875 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 115) {
/*  876 */           client.removeFromServerGroup(new ServerGroup(115));
/*      */         }
/*  878 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 116) {
/*  879 */           client.removeFromServerGroup(new ServerGroup(116));
/*      */         }
/*  881 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 117) {
/*  882 */           client.removeFromServerGroup(new ServerGroup(117));
/*      */         }
/*  884 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 118) {
/*  885 */           client.removeFromServerGroup(new ServerGroup(118));
/*      */         }
/*  887 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 121) {
/*  888 */           client.removeFromServerGroup(new ServerGroup(121));
/*      */         }
/*  890 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 123) {
/*  891 */           client.removeFromServerGroup(new ServerGroup(123));
/*      */         } 
/*      */       } 
/*      */       
/*  895 */       meldung = "[+25]";
/*      */     
/*      */     }
/*  898 */     else if (anime >= 50 && anime < 75) {
/*      */       
/*  900 */       ServerGroup s1 = new ServerGroup(121);
/*      */       
/*  902 */       if (!client.getServerGroups().contains(s1)) {
/*  903 */         client.addToServerGroup(s1);
/*      */       }
/*      */       
/*  906 */       ArrayList<ServerGroup> sergroups = client.getServerGroups();
/*  907 */       for (int i = 0; i < sergroups.size(); i++) {
/*  908 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 115) {
/*  909 */           client.removeFromServerGroup(new ServerGroup(115));
/*      */         }
/*  911 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 116) {
/*  912 */           client.removeFromServerGroup(new ServerGroup(116));
/*      */         }
/*  914 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 117) {
/*  915 */           client.removeFromServerGroup(new ServerGroup(117));
/*      */         }
/*  917 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 118) {
/*  918 */           client.removeFromServerGroup(new ServerGroup(118));
/*      */         }
/*  920 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 123) {
/*  921 */           client.removeFromServerGroup(new ServerGroup(123));
/*      */         }
/*  923 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 122) {
/*  924 */           client.removeFromServerGroup(new ServerGroup(122));
/*      */         } 
/*      */       } 
/*      */       
/*  928 */       meldung = "[+50]";
/*      */     
/*      */     }
/*  931 */     else if (anime >= 75 && anime < 100) {
/*      */       
/*  933 */       ServerGroup s1 = new ServerGroup(115);
/*      */       
/*  935 */       if (!client.getServerGroups().contains(s1)) {
/*  936 */         client.addToServerGroup(s1);
/*      */       }
/*      */       
/*  939 */       ArrayList<ServerGroup> sergroups = client.getServerGroups();
/*  940 */       for (int i = 0; i < sergroups.size(); i++) {
/*  941 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 118) {
/*  942 */           client.removeFromServerGroup(new ServerGroup(118));
/*      */         }
/*  944 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 116) {
/*  945 */           client.removeFromServerGroup(new ServerGroup(116));
/*      */         }
/*  947 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 117) {
/*  948 */           client.removeFromServerGroup(new ServerGroup(117));
/*      */         }
/*  950 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 123) {
/*  951 */           client.removeFromServerGroup(new ServerGroup(123));
/*      */         }
/*  953 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 121) {
/*  954 */           client.removeFromServerGroup(new ServerGroup(121));
/*      */         }
/*  956 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 122) {
/*  957 */           client.removeFromServerGroup(new ServerGroup(122));
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  962 */       meldung = "[+75]";
/*      */     
/*      */     }
/*  965 */     else if (anime >= 100 && anime < 250) {
/*      */       
/*  967 */       ServerGroup s1 = new ServerGroup(116);
/*      */       
/*  969 */       if (!client.getServerGroups().contains(s1)) {
/*  970 */         client.addToServerGroup(s1);
/*      */       }
/*      */       
/*  973 */       ArrayList<ServerGroup> sergroups = client.getServerGroups();
/*  974 */       for (int i = 0; i < sergroups.size(); i++) {
/*  975 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 115) {
/*  976 */           client.removeFromServerGroup(new ServerGroup(115));
/*      */         }
/*  978 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 123) {
/*  979 */           client.removeFromServerGroup(new ServerGroup(123));
/*      */         }
/*  981 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 117) {
/*  982 */           client.removeFromServerGroup(new ServerGroup(117));
/*      */         }
/*  984 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 118) {
/*  985 */           client.removeFromServerGroup(new ServerGroup(118));
/*      */         }
/*  987 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 121) {
/*  988 */           client.removeFromServerGroup(new ServerGroup(121));
/*      */         }
/*  990 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 122) {
/*  991 */           client.removeFromServerGroup(new ServerGroup(122));
/*      */         } 
/*      */       } 
/*      */       
/*  995 */       meldung = "[+100]";
/*      */     
/*      */     }
/*  998 */     else if (anime >= 250 && anime < 500) {
/*      */       
/* 1000 */       ServerGroup s1 = new ServerGroup(117);
/*      */       
/* 1002 */       if (!client.getServerGroups().contains(s1)) {
/* 1003 */         client.addToServerGroup(s1);
/*      */       }
/*      */       
/* 1006 */       ArrayList<ServerGroup> sergroups = client.getServerGroups();
/* 1007 */       for (int i = 0; i < sergroups.size(); i++) {
/* 1008 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 115) {
/* 1009 */           client.removeFromServerGroup(new ServerGroup(115));
/*      */         }
/* 1011 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 116) {
/* 1012 */           client.removeFromServerGroup(new ServerGroup(116));
/*      */         }
/* 1014 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 123) {
/* 1015 */           client.removeFromServerGroup(new ServerGroup(123));
/*      */         }
/* 1017 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 118) {
/* 1018 */           client.removeFromServerGroup(new ServerGroup(118));
/*      */         }
/* 1020 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 121) {
/* 1021 */           client.removeFromServerGroup(new ServerGroup(121));
/*      */         }
/* 1023 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 122) {
/* 1024 */           client.removeFromServerGroup(new ServerGroup(122));
/*      */         } 
/*      */       } 
/*      */       
/* 1028 */       meldung = "[+250]";
/*      */     
/*      */     }
/* 1031 */     else if (anime >= 500) {
/*      */       
/* 1033 */       ServerGroup s1 = new ServerGroup(118);
/*      */       
/* 1035 */       if (!client.getServerGroups().contains(s1)) {
/* 1036 */         client.addToServerGroup(s1);
/*      */       }
/*      */       
/* 1039 */       ArrayList<ServerGroup> sergroups = client.getServerGroups();
/* 1040 */       for (int i = 0; i < sergroups.size(); i++) {
/* 1041 */         if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 115) {
/* 1042 */           client.removeFromServerGroup(new ServerGroup(115));
/*      */         }
/* 1044 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 116) {
/* 1045 */           client.removeFromServerGroup(new ServerGroup(116));
/*      */         }
/* 1047 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 117) {
/* 1048 */           client.removeFromServerGroup(new ServerGroup(117));
/*      */         }
/* 1050 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 123) {
/* 1051 */           client.removeFromServerGroup(new ServerGroup(123));
/*      */         }
/* 1053 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 121) {
/* 1054 */           client.removeFromServerGroup(new ServerGroup(121));
/*      */         }
/* 1056 */         else if (((ServerGroup)sergroups.get(i)).getServerGroupID() == 122) {
/* 1057 */           client.removeFromServerGroup(new ServerGroup(122));
/*      */         } 
/*      */       } 
/*      */       
/* 1061 */       meldung = "[+500]";
/*      */     }
/*      */     else {
/*      */       
/* 1065 */       meldung = "error";
/*      */     } 
/* 1067 */     return meldung;
/*      */   }
/*      */ }


/* Location:              C:\Users\mmlpv\OneDrive\Desktop\Java programmiert\Tuti_Query.jar!\main\Commands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */