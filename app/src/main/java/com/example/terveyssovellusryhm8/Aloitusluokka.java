package com.example.terveyssovellusryhm8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Aloitusluokka extends AppCompatActivity {
    boolean ensimmaistaKertaaKayttamassa;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_aloitusluokka);
            ArrayList<Positiivisetsanat> positivisetSanatLista = new ArrayList<>();
            positivisetSanatLista.add(new Positiivisetsanat("Pieni positiivinen muutos voi muuttaa koko päivän tai koko elämäsi.", "Nishant Grover."));
            positivisetSanatLista.add(new Positiivisetsanat("Kun korvaat negatiiviset ajatukset positiivisilla, aloitat positiiviset tulokset.", "Willie Nelson."));
            positivisetSanatLista.add(new Positiivisetsanat("Hyviä asioita tapahtuu joka päivä. Meidän täytyy vain kertoa niistä.", "Anne Wilson Schaef."));
            positivisetSanatLista.add(new Positiivisetsanat("Voit muuttaa vain itseäsi, mutta joskus se muuttaa kaikkea.", "Gary W Goldstein."));
            positivisetSanatLista.add(new Positiivisetsanat("Me heräämme toisissa samalla henkisellä asenteella, jota meillä on heitä kohtaan.", "Elbert Hubbard."));
            positivisetSanatLista.add(new Positiivisetsanat("Negatiivinen tilanne muunnetaan aina positiiviseksi.", "Michael Jordan."));
            positivisetSanatLista.add(new Positiivisetsanat("Olemme mitä ajattelemme. Kaikki mitä me olemme peräisin ajatuksistamme. Ajatamme me rakentaa maailmaa.", "Buddha."));
            positivisetSanatLista.add(new Positiivisetsanat("Voimme muuttaa elämäämme. Voimme tehdä, olla ja olla juuri sitä, mitä haluamme.","Tony Robbins"));
            positivisetSanatLista.add(new Positiivisetsanat("Kaikki ajatus on siemen. Jos istut mätäsi siemeniä, älä luota herkullisten omenoiden poimintaan.","Bill Meyer"));
            positivisetSanatLista.add(new Positiivisetsanat("Kaikki on joko kasvumahdollisuus tai este, joka estää sinua kasvamasta. Voit päättää.","Wayne Dyer"));
            positivisetSanatLista.add(new Positiivisetsanat("Positiivinen asenne voi todellakin tehdä unelmi;hän teki sen minulle.","David Bailey"));
            positivisetSanatLista.add(new Positiivisetsanat("Pessimisti näkee vaikeuksia jokaisella mahdollisuudella. Optimisti näkee mahdollisuuden kaikissa vaikeuksissa.","Winston Churchill")); 
            positivisetSanatLista.add(new Positiivisetsanat("Mitä sinusta tulee, on paljon tärkeämpää kuin mitä saat. Mitä sinä saat, vaikuttaa siihen, mitä olet.","Jim Rohn"));
            positivisetSanatLista.add(new Positiivisetsanat("Opi olemaan tyytyväisiä siihen, mitä sinulla on, kun jatkat sitä, mitä haluat.","Jim Rohn"));
            positivisetSanatLista.add(new Positiivisetsanat("Onnellisuus ei ole lykkääminen tulevaisuuteen. Se on jotain, jota suunnittelet nykyiselle.","Jim Rohn"));
            positivisetSanatLista.add(new Positiivisetsanat("Elämän suurin arvo ei ole se, mitä saat. Elämän suurin arvo on se, mitä sinusta tulee.","Jim Rohn"));
            positivisetSanatLista.add(new Positiivisetsanat("Et voi olla positiivinen elämä ja negatiivinen mieli.","Joyce Meyer"));
            positivisetSanatLista.add(new Positiivisetsanat("Mikään ei voi pelottaa sinua, jos kieltäydyt pelkäämästä.","Mahatma Gandhi"));
            positivisetSanatLista.add(new Positiivisetsanat("Ainoa paikka, jossa unelmasi ovat mahdotonta, on ajatuksissanne.","Robert H Schulle"));
            positivisetSanatLista.add(new Positiivisetsanat("Oppiminen on lahja. Vaikka kipu on opettajasi.","Maya Watson"));
            positivisetSanatLista.add(new Positiivisetsanat("Rakasta elämää, jota sinun täytyy elää elämässäsi, jota rakastat.","Huseein Nishah"));
            positivisetSanatLista.add(new Positiivisetsanat("Hymynne antaa sinulle positiivisen ilmeen, joka saa ihmiset tuntemaan itsesi paremmin.","Les Brown"));
            positivisetSanatLista.add(new Positiivisetsanat("Henkilö, joka voi tuoda naurun hengen huoneeseen, on siunattu.","Bennet Cerf"));
            positivisetSanatLista.add(new Positiivisetsanat("Kun olet innostunut siitä, mitä teet, tuntuu positiiviselta energialta. Se on hyvin yksinkertaista.","Paulo Coelho")); 
            positivisetSanatLista.add(new Positiivisetsanat("Kun henkilö todella haluaa jotain, koko maailmankaikkeus salaa auttaa häntä ymmärtämään unelmansa.","Paulo Coelho"));
            positivisetSanatLista.add(new Positiivisetsanat("Voittajilla on tapana luoda omia odotuksiaan ennen tapahtumaa.","Brian Tracy"));
            positivisetSanatLista.add(new Positiivisetsanat("Ihminen ei ole mitään muuta kuin hänen ajatuksensa tuotetta. Siitä tulee mitä hän ajattelee.","Mahatma Gandhi"));
            positivisetSanatLista.add(new Positiivisetsanat("Et ole koskaan liian vanha saamaan toisen tavoitteen tai toisen unelman.","C.S Lewis"));
            positivisetSanatLista.add(new Positiivisetsanat("Pahimmat ajat voivat olla parhaita, jos ajattelet positiivista energiaa.","Domenico Dolce"));
            positivisetSanatLista.add(new Positiivisetsanat("Pidä kasvosi aurinkoa kohti ja et näe yhtä varjoa.","Helen Keller"));
            positivisetSanatLista.add(new Positiivisetsanat("Olet kykenevä paljon enemmän kuin ajattelet, kuvittelet tai teet nyt.","Myles Munroe"));
            positivisetSanatLista.add(new Positiivisetsanat("Elävä elämä täysin ja keskittyä positiiviseen.","Matt Cameron"));
            positivisetSanatLista.add(new Positiivisetsanat("Maailma on se, mitä me ajattelemme. Jos voimme muuttaa ajatuksiamme, voimme muuttaa maailmaa.","HM. Tomlinson"));
            positivisetSanatLista.add(new Positiivisetsanat("Monta kertaa ihmiset katsovat negatiivisen puolen siitä, mitä he eivät voi tehdä. Katson aina sitä, mitä voin tehdä.","Chuck Norris"));
            positivisetSanatLista.add(new Positiivisetsanat("Jatkuva optimismi on voimankertoja.","Colin Powell"));
            positivisetSanatLista.add(new Positiivisetsanat("Olemme kaikki täällä erityisestä syystä. Lopeta oleminen menneisyyden vanki. Ryhdy tulevaisuuden arkkitehtiksi.","Robin Sharma"));
            positivisetSanatLista.add(new Positiivisetsanat("Ainoa ero hyvän ja huonon päivän välillä on asenne.","Dennis S. Brown"));
            positivisetSanatLista.add(new Positiivisetsanat("Ainoa asia, joka seisoo ihmisen ja sen, mitä hän haluaa elämässä, on usein halukkuus kokeilla ja usko, että se on mahdollista saavuttaa.","Richard M.DeVos"));
            positivisetSanatLista.add(new Positiivisetsanat("Oikean asenteen ottaminen voi kääntää negatiivisen stressin positiiviseksi .","Dr. Hans Selye"));
            positivisetSanatLista.add(new Positiivisetsanat("Kaikesta huolimatta mielestäni ihmiset ovat hyviä sydämessä.","Anne Frank"));
            positivisetSanatLista.add(new Positiivisetsanat("Vahva ja positiivinen itsekuva on paras mahdollinen valmistautuminen menestykseen.","Joyce Brothers"));
            positivisetSanatLista.add(new Positiivisetsanat("Etsi paikka sisustuksessasi, jossa on iloa, ja ilo polttaa kipua.","Joseph Campbell"));
            positivisetSanatLista.add(new Positiivisetsanat("Sinun täytyy alkaa ajatella itseäsi sellaisena kuin haluat.","David Viscott"));
            positivisetSanatLista.add(new Positiivisetsanat("Voimakkaasti positiivinen asenne luo enemmän ihmeitä kuin mikään lääke.","Patricia Neal"));
            positivisetSanatLista.add(new Positiivisetsanat("Pessimismi johtaa heikkouteen, optimismin valtaan.","William James"));
            positivisetSanatLista.add(new Positiivisetsanat("Tilanne ei ole huono, ajatuksesi tilanteesta ovat kielteisiä. Muuta niitä.","Tuntematon kirjoittaja")); 
            positivisetSanatLista.add(new Positiivisetsanat("Ainoa elämässä oleva vamma on huono asenne.","Scott Hamilton"));
            positivisetSanatLista.add(new Positiivisetsanat("Positiivisen toiminnan toteuttamiseksi meidän on kehitettävä myönteinen näkemys.","Dalai Lama"));
            positivisetSanatLista.add(new Positiivisetsanat("Sano ja tee jotain myönteistä, mikä parantaa tilannetta; se ei ota aivoja valittamaan.","Robert A.Cook"));
            positivisetSanatLista.add(new Positiivisetsanat("Jos et tee virheitä, et tee mitään.","John Wooden"));
            positivisetSanatLista.add(new Positiivisetsanat("Onnistumiseen sinun on löydettävä jotain kiinni, jotain, joka motivoi sinua, jotain, joka inspiroi sinua.","Tony Dorsett"));
            positivisetSanatLista.add(new Positiivisetsanat("Nämä ovat viimeisimmät sanani sinulle. Älä pelkää elämää. Usko, että kannattaa elää ja uskonne luo tosiasian.","William James"));
            positivisetSanatLista.add(new Positiivisetsanat("Pieni positiivinen ajatus aamulla voi muuttaa koko päivänsi.","Tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Mielemme voi muokata mitä asia on, koska toimimme odotuksemme mukaisesti.","Federico Fellini")); 
            positivisetSanatLista.add(new Positiivisetsanat("Olen optimistinen. Ei ole mitään järkeä olla mitään muuta.","Winston Churchill"));
            positivisetSanatLista.add(new Positiivisetsanat("Kun olet laaksossa, pidä tavoite mielessäsi ja sinulla on uusi energia, jotta voit jatkaa kiipeilyä.","Denis Waitley"));
            positivisetSanatLista.add(new Positiivisetsanat("Ruokaa mieli niin kuin olisit kehossasi. Mieli ei voi selviytyä roskaruonnosta.","Jim Rohn"));
            positivisetSanatLista.add(new Positiivisetsanat("Tämä on vetovoiman laki: et houkuttele mitä haluat. Voit houkutella mitä olet.","Wayne Dyer"));
            positivisetSanatLista.add(new Positiivisetsanat("Kirjoita sydämessäsi, että jokainen päivä on vuoden paras päivä.","Ralph Waldo Emerson"));
            positivisetSanatLista.add(new Positiivisetsanat("Positiivisten odotusten asenne on ylemmän persoonallisuuden merkki.","Brian Tracy"));
            positivisetSanatLista.add(new Positiivisetsanat("Positiivinen ajattelija näkee mahdottoman, tuntee aineettoman ja saavuttaa mahdottoman.","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Älä anna maailman negatiivisuuden estää sinua. Sen sijaan anna itsellesi se, mikä motivoi sinua.","Les Brown"));
            positivisetSanatLista.add(new Positiivisetsanat("On surkea on tapa; Onnellinen on tapana; ja valinta on sinun.","Tom Hopkins"));
            positivisetSanatLista.add(new Positiivisetsanat("Työskentele kovasti, olla positiivinen ja nousta aikaisin. Se on päivän paras osa.","George Allen"));
            positivisetSanatLista.add(new Positiivisetsanat("Optimismi on tärkein ihmisen piirre, koska sen avulla voimme parantaa tilannettamme ja toivoa parempaa huomista.","Seth Godin"));
            positivisetSanatLista.add(new Positiivisetsanat("Kieltäydy antamasta tilannetta asenneasi.","Charles R. Swindoll"));
            positivisetSanatLista.add(new Positiivisetsanat("Maailma liikkuu niin nopeasti näinä päivinä, että mies, joka sanoo, että et voi tehdä jotakin, keskeytyy joku, joka tekee sen.","Elbert Hubbard"));
            positivisetSanatLista.add(new Positiivisetsanat("Jos joku sanoo et voi se todella tarkoittaa en voi .","Sean Stephenson"));
            positivisetSanatLista.add(new Positiivisetsanat("Valoa on kaksi tapaa: olla kynttilä tai peili, joka heijastaa sitä.","Edith Wharton"));
            positivisetSanatLista.add(new Positiivisetsanat("Vaikka turhautuminen on joskus tuskallista, se on erittäin myönteinen ja olennainen osa menestystä.","Kirjailija tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Positiivinen ajattelu antaa sinulle mahdollisuuden tehdä jotain parempaa kuin negatiivinen ajattelu.","Zig Ziglar"));
            positivisetSanatLista.add(new Positiivisetsanat("Jos et suojaa jotakin, lankesi mitään.","Malcolm X"));
            positivisetSanatLista.add(new Positiivisetsanat("Rakasta itseäsi. On tärkeää pysyä positiivisena, koska kauneus tulee ulospäin.","Jenn Proske"));
            positivisetSanatLista.add(new Positiivisetsanat("Henkilö on loistava, koska hänellä on suuria ominaisuuksiaan, ei vikojen puuttumisen vuoksi.","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Älä anna ihmisten kunnioittaa sinua. Ympäröi itsesi positiivisten ihmisten kanssa.","Kuba Gooding, Jr"));
            positivisetSanatLista.add(new Positiivisetsanat("Menneisyydellä ei ole valtaa tällä hetkellä.","Eckhart Tolle"));
            positivisetSanatLista.add(new Positiivisetsanat("Kun teen hyvää, tuntuu hyvältä. Kun teen pahan, tunnen pahaa. Tämä on minun uskontoni.","Abraham Lincoln"));
            positivisetSanatLista.add(new Positiivisetsanat("Paras tapa saada itsetunto on tehdä se, mitä pelkäämme.","Tekijä tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Meillä on kyky päättää, mihin ajatuksiin me lopetamme.","David DeNotaris"));
            positivisetSanatLista.add(new Positiivisetsanat("Keskinkertainen ajatus, joka herättää innostusta, menee pidemmälle kuin loistava idea, joka ei innosta ketään.","Mary Kay Ash"));
            positivisetSanatLista.add(new Positiivisetsanat("On hienoa olla optimistinen. Pitää sinut terveenä ja joustavana.","Daniel Kahneman"));
            positivisetSanatLista.add(new Positiivisetsanat("Se on hämmästyttävää Jos jätät sen, elämä muuttuu nopeasti positiivisella tavalla.","Lindsey Vonn"));
            positivisetSanatLista.add(new Positiivisetsanat("Kun kohtaat negatiivisen tilanteen, älä ajattele sitä. Tee se positiiviseksi.","Yoko Ono"));
            positivisetSanatLista.add(new Positiivisetsanat("Työskentele energian ja rauhan parissa tietäen, että oikeat ajatukset ja ponnistelut aiheuttavat väistämättä oikeat tulokset.","James Allen"));
            positivisetSanatLista.add(new Positiivisetsanat("En ehkä ole saanut sitä, minne yritin mennä, mutta luulen, että olen valmis siellä, missä minun täytyi olla.","Douglas Adams"));
            positivisetSanatLista.add(new Positiivisetsanat("Joka päivä tuo uusia mahdollisuuksia.","Martha Beck"));
            positivisetSanatLista.add(new Positiivisetsanat("Jatkuva toistaminen johtaa vakaumukseen.","Robert Collier"));
            positivisetSanatLista.add(new Positiivisetsanat("Vihaa on aiheuttanut monia ongelmia tässä maailmassa eikä ole ratkaissut sitä.","Maya Angelou"));
            positivisetSanatLista.add(new Positiivisetsanat("Henkilö on heidän unelmiensa tuote. Varmista siis, että unelmoit suuria unia. Ja sitten yritä elää unelmasi.","Maya Angelou"));
            positivisetSanatLista.add(new Positiivisetsanat("Jos et pidä jotain, muuta sitä. Jos et voi muuttaa sitä, vaihda asenne.","Maya Angelou"));
            positivisetSanatLista.add(new Positiivisetsanat("Iloitsemme perhonen kauneudesta, mutta harvoin tunnustamme muutokset, jotka ovat tapahtuneet tämän kauneuden saavuttamiseksi.","Maya Angelou"));
            positivisetSanatLista.add(new Positiivisetsanat("Haluan mieluummin kuolla jahtaa sitä, mitä haluan, elää tekemässäni mitä elämääni.","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Me kutsumme onnea hyvästä asenteesta, pyrkimyksestä, riskeistä, jatkuvuudesta ja näyttelystä.","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Tärkein vapauden tyyppi on se, mitä todella olet. ","Jim Morrison"));
            positivisetSanatLista.add(new Positiivisetsanat("Jos löydät polun ilman esteitä, se todennäköisesti johtaa mihinkään.","Frank A. Clark"));
            positivisetSanatLista.add(new Positiivisetsanat("Kyse ei ole tavoitteesta. Kyse on siitä, että siitä tulee henkilö, joka pystyy saavuttamaan tämän tavoitteen.","Tony Robbins"));
            positivisetSanatLista.add(new Positiivisetsanat("Lopeta päivä positiivisella ajatuksella. Huomenna sinulla on mahdollisuus tehdä paremmin","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Jos tilaisuus ei soita, rakenna ovi.","Milton Berle"));
            positivisetSanatLista.add(new Positiivisetsanat("Jos kasvamme, olemme aina pois meidän mukavuusalueestamme.","John C Maxwell"));
            positivisetSanatLista.add(new Positiivisetsanat("Hope on unelma herätetystä miehestä.","Aristoteles"));
            positivisetSanatLista.add(new Positiivisetsanat("Ole kiitollinen siitä, mitä sinulla on; päädyt saamaan enemmän. Jos keskityt siihen, mitä sinulla ei ole, sinulla ei ole koskaan tarpeeksi","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Olen positiivinen ajattelija, ja mielestäni se auttaa minua vaikeimmissa tilanteissa.","Roger Federer"));
            positivisetSanatLista.add(new Positiivisetsanat("En tiedä, että mies, minun täytyy tuntea hänet paremmin.","Abraham Lincoln"));
            positivisetSanatLista.add(new Positiivisetsanat("Ilman nöyrää, mutta kohtuullista luottamusta omaan vahvuuteesi, et voi olla onnistunut tai onnellinen.","Norman Vincent Peale"));
            positivisetSanatLista.add(new Positiivisetsanat("Inspiraatio tulee sinusta. On oltava positiivinen. Kun olet, hyviä asioita tapahtuu.","Deep Roy"));
            positivisetSanatLista.add(new Positiivisetsanat("Paras, mitä voit antaa vihollisesi, on anteeksianto; vastustajalle, suvaitsevaisuus; ystävälle, sydämellesi; hyvä lapsi, hyvä esimerkki; isälle, kunnioitus; äidillesi, olla ylpeä; itsellesi, rakastaa sinua; jokaiselle, hyväntekeväisyyteen.","Benjamin Franklin"));
            positivisetSanatLista.add(new Positiivisetsanat("Kun seuraavan kerran tuntuu hieman epämukavalta elämäsi paineesta, muista, että ilman painetta ei ole timantteja. Paine on osa menestystä.","Eric Thomas"));
            positivisetSanatLista.add(new Positiivisetsanat("Kuinka hienoa on, ettei kenenkään tarvitse odottaa yhtä hetkiä ennen kuin parannetaan maailmaa.","Anne Frank"));
            positivisetSanatLista.add(new Positiivisetsanat("Myötätuntoa, rakkautta, onnea, meillä kaikilla on näitä ominaisuuksia, mutta emme yleensä käytä niitä.","Anne Frank"));
            positivisetSanatLista.add(new Positiivisetsanat("En halua asua turhaan kuten useimmat ihmiset. Haluan olla hyödyllinen tai tuoda iloa ihmisille, jopa niille, joita en ole koskaan tavannut. Haluan jatkaa elämääni myös kuoleman jälkeen.","Anne Frank"));
            positivisetSanatLista.add(new Positiivisetsanat("Et voi asettaa mitään rajoitusta. Mitä enemmän unelmoit, sitä kauempana saat.","Michael Phelps"));
            positivisetSanatLista.add(new Positiivisetsanat("Ajattele ensin, mitä todella haluat. Sitten vainoa häntä sitkeästi, älä anna periksi. Kun putoat, mieti palkintoja. Sillä olet saavuttanut 50% tavoitteestasi.","Tekijä tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Asenne on kaikki; Se kattaa sen, mitä teemme, mitä sanomme, mitä ajattelemme ja mitä saamme.","Tekijä tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Paras on vielä tulossa, niin kauan kuin haluat","Tekijä tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Positiiviset ajatukset eivät automaattisesti saa mahdottomia asioita, mutta mahdottomia asioita ei voida saavuttaa ilman positiivisia ajatuksia","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Menestyksen salaisuus on oppia käyttämään kipua ja mielihyvää kivun ja ilon sijasta. Jos teet niin, hallitset elämääsi. Jos ei, elämä ohjaa sinua","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Emme näe asioita sellaisina kuin ne ovat, näemme ne sellaisina kuin olemme.","Anais Nin"));
            positivisetSanatLista.add(new Positiivisetsanat("Onnellisuus, kuten onnettomuus, on ennakoiva valinta.","Stephen Covey"));
            positivisetSanatLista.add(new Positiivisetsanat("Et voi tehdä positiivisia valintoja elämääsi ilman ympäristöä, joka tekee niistä yksinkertaisia, luonnollisia ja miellyttäviä valintoja.","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Positiivinen asenne aiheuttaa ajatusten, tapahtumien ja positiivisten tulosten ketjureaktion. Se on katalysaattori ja tuottaa poikkeuksellisia tuloksia.","Wade Boggs"));
            positivisetSanatLista.add(new Positiivisetsanat("Tässä maailmassa ei ole käytännöllisesti katsoen mitään mahdotonta, jos yksinkertaisesti laitat mielesi siihen ja säilytätte myönteisen asenteen.","Lou Holtz"));
            positivisetSanatLista.add(new Positiivisetsanat("Aika, jona nautit tuhlasta, ei ollut hukkaan.","John Lennon"));
            positivisetSanatLista.add(new Positiivisetsanat("Älä koskaan sano mitään itsestäsi, ettet halua tulla todellisuuteen.","Brian Tracy"));
            positivisetSanatLista.add(new Positiivisetsanat("Ole rohkea Ota riskejä Mitään ei voi korvata kokemusta.","Paulo Coelho"));
            positivisetSanatLista.add(new Positiivisetsanat("Mitä enemmän olemme tietoisia siitä, mitä olemme todella, sitä vähemmän ongelmia meillä on.","Lynn Grabhorn"));
            positivisetSanatLista.add(new Positiivisetsanat("Et voi pysäyttää aaltoja, mutta voit oppia surffaamaan.","Jon KabatZinn"));
            positivisetSanatLista.add(new Positiivisetsanat("Ajattele, mitä tarvitset, miettiä, mitä tarvitsette muille.","Tekijä tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Niille, jotka haluavat nähdä heitä, on aina kukkia.","Henri Matise"));
            positivisetSanatLista.add(new Positiivisetsanat("Lopeta päivä aina positiivisella ajatuksella. Riippumatta siitä, kuinka kovia asioita oli, huomenna on hyvä tilaisuus tehdä niistä parempia","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Ihmisistä tulee todella poikkeuksellisia, kun he alkavat ajatella, että he voivat tehdä asioita. Kun he uskovat itseensä, heillä on ensimmäinen menestyksen salaisuus.","Norman Vincent Peale"));
            positivisetSanatLista.add(new Positiivisetsanat("Opi hymyilemään kaikissa tilanteissa. Katso se tilaisuutena testata vahvuutesi ja kykysi.","Joe Brown"));
            positivisetSanatLista.add(new Positiivisetsanat("Päivä on se, mitä te teette hänestä. Miksi ei tehdä hyvää päivää?.","Steve Schulte"));
            positivisetSanatLista.add(new Positiivisetsanat("Me olemme vastuussa siitä, keitä me olemme, ja riippumatta siitä, mitä haluamme olla, meillä on valta tehdä itseämme.","Swami Vivekanand"));
            positivisetSanatLista.add(new Positiivisetsanat("Olette tehneet sen aikaisemmin ja voit tehdä sen nyt. Katsokaa positiivisia mahdollisuuksia. Ohjaa turhautumisenne merkittävä energia ja muuta se positiiviseksi, tehokkaaksi ja pysäyttämättömäksi määrittelyksi.","Ralph Marston"));
            positivisetSanatLista.add(new Positiivisetsanat("Positiivinen asenne on se, että jokainen voi työskennellä ja oppia käyttämään sitä.","Joan Lunden"));
            positivisetSanatLista.add(new Positiivisetsanat("Muista unelmasi ja taistele niiden puolesta. Sinun täytyy tietää, mitä haluat elämästä. On vain yksi asia, joka tekee unelmastasi mahdottomaksi: epäonnistumisen pelko.","Paulo Coelho"));
            positivisetSanatLista.add(new Positiivisetsanat("Miten voin elää tänään huomenna olen sitoutunut?.","Tony Robbins"));
            positivisetSanatLista.add(new Positiivisetsanat("Uskon, että kaikki on mahdollista, jos sinulla on mentaliteetti, tahto ja halu tehdä se ja omistautua aikaa.","Roger Clemes"));
            positivisetSanatLista.add(new Positiivisetsanat("Ihmisissä on pieni ero, mutta tämä ero on suuri ero. Pieni ero on asenne. Suuri ero on se, onko se positiivinen vai negatiivinen.","W. Clement Stone"));
            positivisetSanatLista.add(new Positiivisetsanat("Positiivinen ajattelu on enemmän kuin iskulause. Se muuttaa tapaa, jolla käyttäytymme. Uskon vakaasti, että kun olen positiivinen, olen parempi ja teen muutkin paremmin.","Harvey Mackay"));
            positivisetSanatLista.add(new Positiivisetsanat("Se on meidän pimeimpien hetkien aikana, kun meidän on keskityttävä katsomaan valoa.","Aristoteles"));
            positivisetSanatLista.add(new Positiivisetsanat("Loppujen lopuksi emme muista vihollistemme sanoja, vaan ystävien hiljaisuutta.","Martin Luther King Jr."));
            positivisetSanatLista.add(new Positiivisetsanat("Meidän on hyväksyttävä rajallinen pettymys, mutta emme koskaan menetä ääretöntä toivoa.","Martin Luther King, Jr."));
            positivisetSanatLista.add(new Positiivisetsanat("Sinun on hyväksyttävä se, mikä on tulossa, ja ainoa tärkeä asia on se, että kohtaatte sen rohkeudella ja parhaalla mahdollisella tavalla.","Eleanor Roosevelt"));
            positivisetSanatLista.add(new Positiivisetsanat("Ensin on opittava pelin säännöt. Sitten sinun täytyy pelata paremmin kuin kukaan.","Albert Einstein"));
            positivisetSanatLista.add(new Positiivisetsanat("Korjaus tekee paljon, mutta mieliala tekee paljon enemmän.","Johann Wolfgang von Goethe"));
            positivisetSanatLista.add(new Positiivisetsanat("Kyse ei ole tilanteesta, vaan siitä, reagoimmeko tilanteeseen kielteisesti tai myönteisesti.","Zig Ziglar"));
            positivisetSanatLista.add(new Positiivisetsanat("Voiton ja menettämisen välinen ero ei usein anna periksi.","Walt Disney"));
            positivisetSanatLista.add(new Positiivisetsanat("Positiivinen asenne ei ehkä ratkaise kaikkia ongelmia, mutta se häiritsee tarpeeksi ihmisiä ponnistelemaa.","Herm Albright"));
            positivisetSanatLista.add(new Positiivisetsanat("Jos et ole innostunut, sinut sytytetään innokkaasti.","Vince Lombardi"));
            positivisetSanatLista.add(new Positiivisetsanat("Huoli antaa usein varjon jotain pienelle.","Sveitsin sananlasku"));
            positivisetSanatLista.add(new Positiivisetsanat("Paras valmistautuminen huomenna on antaa tänään sinulle paras .","H. Jackson Brown, Jr"));
            positivisetSanatLista.add(new Positiivisetsanat("Laita sydämesi, mielesi ja sielusi jopa pienimpiin tekoihin. Se on menestyksen salaisuus.","Swami Sivananda"));
            positivisetSanatLista.add(new Positiivisetsanat("Optimismi on usko, joka ohjaa saavutuksia. Nade on mahdollista ilman toivoa ja luottamusta.","Helen Keller"));
            positivisetSanatLista.add(new Positiivisetsanat("Jos voit unelmoida, voit tehdä sen.","Walt Disney"));
            positivisetSanatLista.add(new Positiivisetsanat("Pidä silmäsi tähdet ja jalkasi maan päällä.","Theodore Roosevelt")); 
            positivisetSanatLista.add(new Positiivisetsanat("Muista: kirja, kynä, lapsi ja opettaja voivat muuttaa maailmaa.","Malala Yousafzai"));
            positivisetSanatLista.add(new Positiivisetsanat("Tarvitset vain suunnitelman, etenemissuunnitelman ja rohkeuden mennä kohteeseen.","Earl Nightingale"));
            positivisetSanatLista.add(new Positiivisetsanat("Aloita missä olet, käytä mitä sinulla on. Tee mitä voit.","Arthur Ashe"));
            positivisetSanatLista.add(new Positiivisetsanat("Pidä unelmasi elossa. Ymmärrä, että kaiken saavuttamiseksi tarvitaan uskoa itseesi, visioon, kovaan työhön, päättäväisyyteen ja omistautumiseen.","Gail Devers"));
            positivisetSanatLista.add(new Positiivisetsanat("Usko on lintu, joka tuntee valon, kun aamunkoitto on vielä tumma.","Rabindranath Tagore"));
            positivisetSanatLista.add(new Positiivisetsanat("Ota joka päivä positiivinen asenne, yrittäen olla parempi.","Stefon Diggs"));
            positivisetSanatLista.add(new Positiivisetsanat("Älä anna eilen ottaa paljon tänään.","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Lisätietoja epäonnistumisesta kuin onnistumisesta. Älä anna sen pysäyttää sinua. Epäonnistuminen rakentaa merkkiä.","Kirjoittaja tuntematon"));
            positivisetSanatLista.add(new Positiivisetsanat("Pysy positiivisena ja onnellisena. Työskentele kovasti ja älä menetä toivoa. Pysy avoimena kritiikille ja pidä oppia.","Tena Desae"));
            positivisetSanatLista.add(new Positiivisetsanat("Positiiviset toimet yhdistettynä positiivisiin ajatuksiin tuottavat menestystä.","Shiv Khera"));
            positivisetSanatLista.add(new Positiivisetsanat("Onnistuneet ihmiset pitävät myönteistä huomiota elämään riippumatta siitä, mitä heidän ympärillään tapahtuu.","Jack Canfield"));
            positivisetSanatLista.add(new Positiivisetsanat("Joka päivä on 1440 minuuttia. Tämä tarkoittaa, että meillä on päivittäin 1440 mahdollisuutta vaikuttaa myönteisesti.","Les Brown"));
            positivisetSanatLista.add(new Positiivisetsanat("Jos sinulla on positiivinen asenne ja pyritte jatkuvasti tekemään parhaansa, voit lopulta voittaa välittömät ongelmat ja huomaa, että olet valmis suurempiin haasteisiin.","Pat Riley"));
            positivisetSanatLista.add(new Positiivisetsanat("Asenne on kuin merkki, joka antaa värin maailmallesi. Väritä harmaata kuvaa jatkuvasti, ja kuva on aina synkkä. Yritä lisätä värejä kuviin, mukaan lukien mieliala, ja he alkavat selvittää.","Allen Klein"));
            positivisetSanatLista.add(new Positiivisetsanat("Harvat asiat maailmassa ovat vahvempia kuin positiivinen impulssi. Hymy Optimismin ja toivon maailma. Voit tehdä se. kun asiat ovat vaikeita.","Richard M. DeVos"));
            positivisetSanatLista.add(new Positiivisetsanat("Hyvä naurua on aurinko talossa.","William Makepeace Thackeray"));
            positivisetSanatLista.add(new Positiivisetsanat("Tärkeintä on innostaa ihmisiä niin, että he voivat olla suuria, mitä he haluavat tehdä.","Kobe Bryant"));
            positivisetSanatLista.add(new Positiivisetsanat("Riippumatta siitä, mitä olet menossa läpi, tunnelin päässä on valo, ja se saattaa tuntua vaikealta saavuttaa se, mutta voit löytää asian positiivisen puolen, jos jatkat työtä.","Demi Lovato"));
            positivisetSanatLista.add(new Positiivisetsanat("Luota unelmiin, koska niissä ikuisuus ikuisuuteen on piilossa.","Khalil Gibran"));
            positivisetSanatLista.add(new Positiivisetsanat("Kyky pysyä rauhallisena ja keskittyneenä stressaaviin tilanteisiin on ratkaisevan tärkeää positiivisten päätösten tekemiseksi.","Goldie Hawn"));
            positivisetSanatLista.add(new Positiivisetsanat("Sinun täytyy pystyä käsittelemään stressiä, koska vaikeita aikoja tulee, ja positiivinen näkymä on, mitä voit voittaa ne.","Marie Osmond"));
            positivisetSanatLista.add(new Positiivisetsanat("Joka päivä kun heräät, sinulla on kaksi vaihtoehtoa. Voit olla positiivinen tai negatiivinen; optimistia tai pessimistiä.","Harvey Mackay"));
            positivisetSanatLista.add(new Positiivisetsanat("Voit tehdä kaiken estääkseen huonojen asioiden tapahtumisen teille, mutta lopulta tapahtuu jotain pahaa, joten paras ehkäisy on myönteinen asenne.","Marie Osmond"));
            positivisetSanatLista.add(new Positiivisetsanat("Jos valitset, jopa odottamattomat takaiskut voivat tuoda uusia ja myönteisiä mahdollisuuksia.","Ralph Marston"));
            positivisetSanatLista.add(new Positiivisetsanat("Ole rehellinen kanssasi ja ympärilläsi on positiivisia ihmisiä.","Payal Kadakia"));
            positivisetSanatLista.add(new Positiivisetsanat("Aurinko ei paista muutamille kukkille ja puille, vaan koko maailman iloksi.","Henry Ward"));
            
            
            // Positiivisetsanatlistaoffline.positivisetSanatListaLuontiOffline();
            TextView aloitusTekstinakyma = (TextView) findViewById(R.id.textView21);
            TextView aloitusTekstinakyma2 = (TextView) findViewById(R.id.textView22);
            TextView aloitusTekstinakyma3 = (TextView) findViewById(R.id.textView23);
            if (!ensimmaistaKertaaKayttamassa){
                aloitusTekstinakyma.setText(getApplicationContext().getResources().getString(R.string.textViewAloitusEka));
                aloitusTekstinakyma2.setText(getApplicationContext().getResources().getString(R.string.textViewAloitusToka));
                ensimmaistaKertaaKayttamassa = true;
            } else {
                aloitusTekstinakyma.setText(R.string.textViewAloitusVanha);
                aloitusTekstinakyma2.setText(R.string.textViewAloitusVanha2);

            }
            int i2=(int)(Math.random() * positivisetSanatLista.size());
            Log.i("my_app", " "+i2);
            Log.i("my_app", " "+positivisetSanatLista.get(i2) + " \n"+" -"+ positivisetSanatLista.get(i2).getPositiivisetSanatTekija());
            aloitusTekstinakyma3.setText(positivisetSanatLista.get(i2) + " \n"+" -"+ positivisetSanatLista.get(i2).getPositiivisetSanatTekija());
            Thread welcomeThread = new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    // 7 sekunnin viive
                    sleep(7000);
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(Aloitusluokka.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }



}

