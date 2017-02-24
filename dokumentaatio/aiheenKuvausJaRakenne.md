#Integraattori

##Aihemäärittely

**Aihe:**
integraattori
Toteutetaan ohjelmisto, joka osaa laskea numeerisesti määrättyjä 1D-integraaleja eri menetelmillä.

Yksiulotteiset integraalit kertovat käyrän ja koordinaattiakselin väliin jäävän pinta-alan 
suuruuden. Tämä on hyödyllistä monissa sovelluksissa, sillä esimerkiksi monet fysiikan ilmiöt
riippuvat pinta-aloista.

Jos käyrä on suora, käyrän rajoittama pinta-ala saadaan helposti laskettua kolmioiden ja 
suorakulmioiden alojen summana, mutta epälineaaristen funktioiden tapauksessa täytyy käyttää
integraalia. Pinta-alan suuruutta voi arvioida täyttämällä käyrän alle jäävän alan 
suunnikkailla. Näin saatu arvio lähestyy oikeaa arvoa, kun suunnikkaiden leveyttä pienennetään.
Integraaliin päädytään rajalla, jossa tämä leveys lähestyy nollaa.

Useilla funktioilla on tunnettu integraali, niin sanottu antiderivaatta. Kaikkien funktioiden
antiderivaatoilla ei kuitenkaan ole alkeisfunktioiden avulla ilmaistavissa olevaa muotoa.
Myös dataa, jonka funktionaalista muotoa ei tunneta tarkasti tai kokonaan, voidaan 
integroida numeerisesti.

Aluksi toteutetaan Newton-Cotes kaavojen mukaan suorakulmioiden summiin perustuva ratkaisu, 
kun funktiolla on analyyttinen muoto tai saatavilla on dataa, jonka pisteet ovat tasavälein,
ja integrointirajat ovat äärelliset. Parannetaan ratkaisua toteuttamalla puolisuunnikassääntöön 
ja Simpsonin sääntöön perustuvat numeeriset integraalit samoilla ehdoilla. Tämän jälkeen 
harkitaan ohjelman laajentamista äärettömiin integrointirajoihin, monimutkaisempiin
ja tarkempiin yksiulotteisiin integrointimenetelmiin, kaksiulotteisiin integraaleihin tai
panostamista visuaaliseen käyttöliittymään, joka piirtää annetun funktion määräämän käyrän 
ja sen rajaaman alan.

**Käyttäjät:**
Laskija

**Laskijan toiminnot:**
- antaa integroitavan funktion
- valitsee käytettävän integrointimenetelmän
- asettaa mahdolliset menetelmään liittyvät parametrit
- antaa integrointirajat
- näkee vastauksen

## Luokkakaavio
![Luokkakaavio](/dokumentaatio/luokkakaavio4.png)

## Sekvenssikaaviot
**Laskija antaa integroitavan funktion:**
![Sekvenssikaavio1](/dokumentaatio/funktionAntaminen.png)

**Laskija antaa integrointirajat:**
![Sekvenssikaavio2](/dokumentaatio/kayttotapaus2.png)
