INSERT INTO sequence VALUES('ordernum', 1000);
INSERT INTO sequence VALUES('linenum', 1000);

INSERT INTO signon VALUES('j2ee','j2ee');
INSERT INTO signon VALUES('ACID','ACID');

INSERT INTO account VALUES('j2ee','yourname@yourdomain.com','ABC', 'XYX', 'OK', '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA',  '555-555-5555');
INSERT INTO account VALUES('ACID','acid@yourdomain.com','ABC', 'XYX', 'OK', '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA',  '555-555-5555');

INSERT INTO profile VALUES('j2ee','english','ACTADV',1,1);
INSERT INTO profile VALUES('ACID','english','SPORTS',1,1);

INSERT INTO bannerdata VALUES ('ACTADV','<img src="images/banner_actadv.gif"/>');
INSERT INTO bannerdata VALUES ('SPORTS','<img src="images/banner_sports.gif"/>');
INSERT INTO bannerdata VALUES ('STRATEGY','<img src="images/banner_strategy.gif"/>');
INSERT INTO bannerdata VALUES ('TEEN','<img src="images/banner_teen.gif"/>');
INSERT INTO bannerdata VALUES ('CHILDREN','<img src="images/banner_children.gif"/>');

INSERT INTO category VALUES ('ACTADV','Action/Adventure','#008F00','','<font size="5">Action/Adventure</font>');
INSERT INTO category VALUES ('SPORTS','Sports','#FF8000','','<font size="5">Sports</font>');
INSERT INTO category VALUES ('STRATEGY','Strategy','#660099','','<font size="5">Strategy</font>');
INSERT INTO category VALUES ('TEEN','Teen','#FFCC00','','<font size="5">Teen</font>');
INSERT INTO category VALUES ('CHILDREN','Children','#00248F','','<font size="5">Children</font>');

INSERT INTO product VALUES ('AA-01','ACTADV','007','007','<img src="images/aa_007.jpg" alt="007"/>');
INSERT INTO product VALUES ('AA-02','ACTADV','Oni','Oni','<img src="images/aa_oni.jpg" alt="ONI"/>');
INSERT INTO product VALUES ('AA-03','ACTADV','Deus X','Deus X','<img src="images/aa_deusx.jpg" alt="Deus-X"/>');
INSERT INTO product VALUES ('AA-04','ACTADV','Unreal','Unreal','<img src="images/aa_unreal.jpg" alt="Unreal Tournament"/>');
INSERT INTO product VALUES ('AA-05','ACTADV','Savage Skies','Savage Skies','<img src="images/aa_savageskies.jpg" alt="Savage Skies"/>');
INSERT INTO product VALUES ('AA-06','ACTADV','Splashdown','Splashdown','<img src="images/aa_splashdown.jpg" alt="Splashdown"/>');

INSERT INTO product VALUES ('SP-01','SPORTS','Breeders Cup','Breeders Cup','<img src="images/sp_breederscup.jpg" alt="Breeders Cup"/>');
INSERT INTO product VALUES ('SP-02','SPORTS','MLB','MLB','<img src="images/sp_mlb06.jpg" alt="MLB ''06"/>');
INSERT INTO product VALUES ('SP-03','SPORTS','Outlaw Ball','Outlaw Ball','<img src="images/sp_outlawvball.jpg" alt="Outlaw Volleyball"/>');
INSERT INTO product VALUES ('SP-04','SPORTS','Snow Cross 2','Snow Cross 2','<img src="images/sp_snowcross2.jpg" alt="Snow Cross 2"/>');
INSERT INTO product VALUES ('SP-05','SPORTS','World Soccer','World Soccer','<img src="images/sp_worldsoccer.jpg" alt="World Soccer"/>');
INSERT INTO product VALUES ('SP-06','SPORTS','WWE','WWE','<img src="images/sp_wwe.jpg" alt="WWE"/>');

INSERT INTO product VALUES ('ST-01','STRATEGY','Risk','Risk','<img src="images/st_risk.jpg" alt="RISK"/>');
INSERT INTO product VALUES ('ST-02','STRATEGY','Sims 2','Sims 2','<img src="images/st_sims2.jpg" alt="Sims 2"/>');
INSERT INTO product VALUES ('ST-03','STRATEGY','Wild Arms 3','Wild Arms 3','<img src="images/st_wildarms3.jpg" alt="Wild Arms 3"/>');

INSERT INTO product VALUES ('TN-01','TEEN','Blowout','Blowout','<img src="images/tn_blowout.jpg" alt="Blowout"/>');
INSERT INTO product VALUES ('TN-02','TEEN','Desert Storm','Desert Storm','<img src="images/tn_desertstorm.jpg" alt="Conflict: Desert Storm"/>');
INSERT INTO product VALUES ('TN-03','TEEN','Tomb Raider','Tomb Raider','<img src="images/tn_tombraider.jpg" alt="Tomb Raider"/>');

INSERT INTO product VALUES ('CH-01','CHILDREN','Cat in the Hat','Cat in the Hat','<img src="images/ch_catnhat.jpg" alt="Cat in the Hat"/>');
INSERT INTO product VALUES ('CH-02','CHILDREN','Finding Nemo','Finding Nemo','<img src="images/ch_findingnemo.jpg" alt="Finding Nemo"/>');

INSERT INTO supplier VALUES (1,'XYZ Games','AC','600 Avon Way','','Los Angeles','CA','94024','212-947-0797');
INSERT INTO supplier VALUES (2,'ABC Games','AC','600 Avon Way','','Los Angeles','CA','94024','212-947-0797');

/*ITEM*/

/*AA*/
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('007-PS2','AA-01','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('007-XBOX','AA-01','XBOX','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('ONI-PS2','AA-02','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('ONI-PC','AA-02','PC','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('DEX-PC','AA-03','PC','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('DEX-XBOX','AA-03','XBOX','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('UNR-PS2','AA-04','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('UNR-XBOX','AA-04','XBOX','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('SVG-PC','AA-05','PC','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('SVG-XBOX','AA-05','XBOX','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('SPD-PS2','AA-06','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('SPD-XBOX','AA-06','XBOX','',15.00,12.00,1,'P','Teen');

/*SP BRD,MLB,OVB,SC2,WSC,WWE*/
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('BRD-PS2','SP-01','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('BRD-XBOX','SP-01','XBOX','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('MLB-PS2','SP-02','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('MLB-PC','SP-02','PC','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('OVB-PS2','SP-03','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('OVB-XBOX','SP-03','XBOX','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('SC2-PC','SP-04','PC','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('SC2-XBOX','SP-04','XBOX','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('WSC-PS2','SP-05','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('WSC-XBOX','SP-05','XBOX','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('WWE-PC','SP-06','PC','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('WWE-XBOX','SP-06','','',15.00,12.00,1,'P','Teen');


/*ST RSK,SM2,WA3*/
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('RSK-PS2','ST-01','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('RSK-XBOX','ST-01','XBOX','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('SM2-PS2','ST-02','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('SM2-PC','ST-02','PC','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('WA3-PC','ST-03','PC','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('WA3-XBOX','ST-03','XBOX','',15.00,12.00,1,'P','Teen');

/*TN BLO,DSS,TMR*/
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('BLO-PS2','TN-01','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('BLO-XBOX','TN-01','XBOX','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('DSS-PS2','TN-02','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('DSS-PC','TN-02','PC','',15.00,12.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('TMR-PS2','TN-03','PS2','',20.00,17.00,1,'P','Teen');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('TMR-XBOX','TN-03','XBOX','',15.00,12.00,1,'P','Teen');

/*CH CNH,FDN*/
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('CNH-PS2','CH-01','PS2','',20.00,17.00,1,'P','Children');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('CNH-XBOX','CH-01','XBOX','',15.00,12.00,1,'P','Children');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('FDN-PS2','CH-02','PS2','',20.00,17.00,1,'P','Children');
INSERT INTO  item (itemid, productid, name, description, listprice, unitcost, supplier, status, attr1) VALUES('FDN-PC','CH-02','PC','',15.00,12.00,1,'P','Children');

INSERT INTO inventory (itemid, qty ) VALUES ('007-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('007-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('ONI-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('ONI-PC',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('DEX-PC',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('DEX-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('UNR-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('UNR-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('SVG-PC',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('SVG-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('SPD-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('SPD-XBOX',10000);

INSERT INTO inventory (itemid, qty ) VALUES ('BRD-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('BRD-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('MLB-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('MLB-PC',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('OVB-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('OVB-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('SC2-PC',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('SC2-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('WSC-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('WSC-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('WWE-PC',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('WWE-XBOX',10000);

INSERT INTO inventory (itemid, qty ) VALUES ('RSK-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('RSK-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('SM2-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('SM2-PC',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('WA3-PC',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('WA3-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('BLO-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('BLO-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('DSS-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('DSS-PC',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('TMR-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('TMR-XBOX',10000);

INSERT INTO inventory (itemid, qty ) VALUES ('CNH-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('CNH-XBOX',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('FDN-PS2',10000);
INSERT INTO inventory (itemid, qty ) VALUES ('FDN-PC',10000);