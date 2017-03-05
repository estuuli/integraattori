#Testausdokumentaatio

Integroivien metodien toimintaa on testattu lähinnä integroinnin tuloksen 
kautta. Testeissä on tätä varten vain muutama testi, mutta käsin testausta on 
toteutettu huomattavasti suuremmalla ja monimuotoisemmalla funktio- ja 
integrointirajajoukolla.

Epäoleellisten integraalien laskua on testattu testeissä varsin vähän, koska 
laskut vievät usein paljon aikaa. Näin käy erityisesti, jos lasketaan 
hajaantuvaa integraalia, jolloin ohjelma laskee läpi maksimimäärän iteraatioita, 
koska integraalin arvo ja virhe kasvavat iteraatio iteraatiolta. Ohjelmakoodissa 
iteraatioiden maksimimääräksi on asetettu 25 ja jopa näin pienellä määrällä 
niiden kaikkien laskemiseen menee varsin kauan. Ohjelma varoittaa käyttäjää 
mahdollisesti hajaantuvasta integraalista aina, kun integraalin arvo on 
suurempi kuin 1000 000, mutta käyttäjän tulee aina varmistua itse siitä, että 
integraali todella hajaantuu.
 
Epäoleellisia integraaleja on testattu käsin erilaisilla funktioilla siten, 
että iteraatioiden maksimimäärää on pienennetty ohjelmakoodista käsin. Ohjelma 
antaa useimmissa tapauksissa Wolfram Alphan kanssa yhtenevän vastauksen.

Epäoleellisten integraalien laskemiseksi ohjelma tekee muuttujanvaihdoksen 
u = tan x, jolloin +/- ääretön muuttuu +/- pii/2:ksi. Tämä on useissa 
tapauksissa ihan hyvä muuttujanvaihto, mutta on tiettyjä funktioita ja 
integrointirajoja, joille tämä toimii huonosti. Esimerkiksi integroitaessa 
funktiota 1/x^2 yhdestä äärettömään, ohjelma saa vastaukseksi noin 0,1, kun 
oikea vastaus on yksi. Kuitenkin, jos samaa funktiota integroidaan 0,1:stä 
äärettömään, saadaan oikea vastaus eli 10. Ohjelmaa pitää kehittää niin, että 
epäoleellisten integraalien laskemiseksi on mahdollista valita useista eri 
muuttujanvaihtovaihtoehdoista, jolloin ongelmalliset pisteet saa katettua 
paremmin.

