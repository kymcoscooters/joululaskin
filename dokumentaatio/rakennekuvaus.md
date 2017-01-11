##Kymcolaskimen rakennekuvaus

Laskimessa on Main-luokka laskin-ohjelman käynnistystä varten. Main-luokassa luodaan uusi Käyttöliittymä-olio ja liitetään siihen uusi Laskinlogiikka-olio.

Käyttöliittymä-luokka on vastuussa graafisesta sisällöstä. Käyttöliittymä-luokka luo laskimen näytön ja kaikki näppäimet.

Klikkausten käsittelyä varten on kaksi ActionListener-rajapintaa toteuttavaa luokkaa, Numerokuuntelija ja Operaatiokuuntelija.

Numerokuuntelija kuuntelee kaikkia numeronäppäimiä sekä pilkkunäppäintä. Numerokuuntelija hoitaa siis lukujen syöttämistä näytölle.

Operaatiokuuntelija hoitaa kaikki muut näppäimet, eli matemaattiset operaatiot. Operaatiokuuntelijaan on liitetty Laskin-rajapintaa toteuttava Laskinlogiikka-luokka, jotta operaatiot saadaan tehtyä. Käyttäjän painaessa operaationäppäintä, kuuntelija välittää näytöllä olevan luvun laskinlogiikalle sekä haluttu operaatio.

Laskinlogiikka-luokka hoitaa siis kaiken laskemiseen liittyvän logiikan. Luokassa on arvo oliomuuttujana ja sitä muutetaan eri metodien avulla. Luokassa on myös memory-oliomuuttuja jonka avulla käyttäjä voi tallentaa jonkun arvon ns. muistiin.


