#Rakennekuvaus

Ohjelman logiikka koostuu kolmesta eri integroivasta luokasta (Suorakulmio-
Metodista, PuolisuunnikasMetodista ja SimpsoninMetodista), funktion määritte-
levästä ja sen arvoja laskevasta Funktio-luokasta ja muuttujan vaihdon suorittavasta
AarettomienRajojenMuunnin-luokasta. SimpsoninMetodi perii PuolisuunnikasMetodin.

Käyttöliittymä käyttää jokaista näistä luokista. Käyttöliittymän kautta kysytään
ohjelman käyttäjältä integroiva metodi ja sen tarvitsemat parametrit sekä 
suoritetaan mahdollisesti tarvittava muuttujanvaihto. Jokainen integroiva metodi
käyttää Funktio-luokkaa integraalin laskemiseen.
