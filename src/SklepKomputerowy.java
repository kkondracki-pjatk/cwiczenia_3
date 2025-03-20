public class SklepKomputerowy {

    private Produkt[] produkty;
    private Klient[] klienci;
    private Zamowienie[] zamowienia;
    private int liczbaProduktow;
    private int liczbaKlientow;
    private int liczbaZamowien;

    public SklepKomputerowy() {
        this.produkty = new Produkt[100];
        this.klienci = new Klient[100];
        this.zamowienia = new Zamowienie[100];
        this.liczbaProduktow = 0;
        this.liczbaKlientow = 0;
        this.liczbaZamowien = 0;
    }

    public void dodajProdukt(Produkt produkt) {
        if (liczbaProduktow < produkty.length) {
            produkty[liczbaProduktow++] = produkt;
            System.out.println("Produkt " + produkt.getNazwa() + " został dodany do sklepu.");
        }
    }

    public void dodajKlienta(Klient klient) {
        if (liczbaKlientow < klienci.length) {
            klienci[liczbaKlientow++] = klient;
            System.out.println("Klient " + klient.getImie() + " " + klient.getNazwisko() + " został dodany do sklepu.");
        }
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {
        if (liczbaZamowien < zamowienia.length) {
            double suma = 0;
            for (int i = 0; i < produkty.length; i++) {
                suma += produkty[i].getCena() * ilosci[i];
            }

            Zamowienie noweZamowienie = new Zamowienie(liczbaZamowien + 1, klient, produkty, suma, "Nowe");
            zamowienia[liczbaZamowien++] = noweZamowienie;
            System.out.println("Zamówienie dla klienta " + klient.getImie() + " zostało utworzone.");
        }
        return null;
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        for (Produkt produkt : zamowienie.getProdukty()) {
            if (produkt != null) {
                produkt.setIlosc(produkt.getIlosc() - 1);
                System.out.println("Stan magazynowy produktu " + produkt.getNazwa() + " został zaktualizowany.");
            }
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getId() == idZamowienia) {
                zamowienia[i].setStatus(nowyStatus);
                System.out.println("Status zamówienia " + idZamowienia + " został zmieniony na " + nowyStatus);
            }
        }
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        System.out.println("Produkty w kategorii: " + kategoria);
        for (Produkt produkt : produkty) {
            if (produkt != null && produkt.getKategoria().equals(kategoria)) {
                System.out.println(produkt.getNazwa() + " - " + produkt.getCena());
            }
        }
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        System.out.println("Zamówienia klienta ID: " + idKlienta);
        for (Zamowienie zamowienie : zamowienia) {
            if (zamowienie != null && zamowienie.getKlient().getId() == idKlienta) {
                System.out.println("Zamówienie ID: " + zamowienie.getId() + ", Status: " + zamowienie.getStatus());
            }
        }
    }
}
