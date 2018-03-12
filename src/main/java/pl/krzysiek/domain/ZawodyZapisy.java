package pl.krzysiek.domain;

public class ZawodyZapisy {

    private Long id;
    private String imie;
    private String nazwisko;
    private int wiek;
    private int kategoria;
    private String type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public int getKategoria() {
        return kategoria;
    }

    public void setKategoria(int kategoria) {
        this.kategoria = kategoria;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


