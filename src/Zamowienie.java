import java.util.Arrays;

public class Zamowienie {
    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosci;
    private String dataZamowienia;
    private String status;

    public Zamowienie(int id, Klient klient, Produkt[] produkty, int[] ilosci, String dataZamowienia, String status) {
        this.id = id;
        this.klient = klient;
        this.produkty = produkty;
        this.ilosci = ilosci;
        this.dataZamowienia = dataZamowienia;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Klient getKlient() {
        return klient;
    }

    public Produkt[] getProdukty() {
        return produkty;
    }

    public int[] getIlosci() {
        return ilosci;
    }

    public String getDataZamowienia() {
        return dataZamowienia;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public void setProdukty(Produkt[] produkty) {
        this.produkty = produkty;
    }

    public void setIlosci(int[] ilosci) {
        this.ilosci = ilosci;
    }

    public void setDataZamowienia(String dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double obliczWartoscZamowienia() {
        double wartosc = 0.0;
        for (int i = 0; i < produkty.length; i++) {
            wartosc += produkty[i].getCena() * ilosci[i];
        }
        return wartosc;
    }

    public double zastosujZnizke() {
        if (klient.isCzyStaly()) {
            double wartosc = obliczWartoscZamowienia();
            return wartosc * 0.9; // 10%
        }
        return obliczWartoscZamowienia();
    }

    public void wyswietlSzczegoly() {
        System.out.println("Zamówienie ID: " + id);
        System.out.println("Klient: " + klient.getImie() + " " + klient.getNazwisko());
        System.out.println("Data zamówienia: " + dataZamowienia);
        System.out.println("Status: " + status);
        System.out.println("Produkty: ");
        for (int i = 0; i < produkty.length; i++) {
            System.out.println(produkty[i].getNazwa() + " - Ilość: " + ilosci[i] + " - Cena jednostkowa: " + produkty[i].getCena());
        }
        System.out.println("Łączna wartość zamówienia (bez zniżki): " + obliczWartoscZamowienia() + " PLN");
        System.out.println("Łączna wartość zamówienia (po zniżce): " + zastosujZnizke() + " PLN");
    }
}
