package buraigergely_1zaro;

public class Eredmenyek {

    private String hazai;
    private String idegen;
    private Integer hazaipont;
    private Integer idegenpont;
    private String helyszin;
    private String datum;

    public Eredmenyek(String sor) {
        String[] s = sor.split(";");
        this.hazai = s[0];
        this.idegen = s[1];
        this.hazaipont = Integer.parseInt(s[2]);
        this.idegenpont = Integer.parseInt(s[3]);
        this.helyszin = s[4];
        this.datum = s[5];
    }

    public Eredmenyek(String hazai, String idegen, Integer hazaipont, Integer idegenpont, String helyszin, String datum) {
        this.hazai = hazai;
        this.idegen = idegen;
        this.hazaipont = hazaipont;
        this.idegenpont = idegenpont;
        this.helyszin = helyszin;
        this.datum = datum;
    }

    public String getHazai() {
        return hazai;
    }

    public String getIdegen() {
        return idegen;
    }

    public Integer getHazaipont() {
        return hazaipont;
    }

    public Integer getIdegenpont() {
        return idegenpont;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public String getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return "Eredmenyek{" + "hazai=" + hazai + ", idegen=" + idegen + ", hazaipont=" + hazaipont + ", idegenpont=" + idegenpont + ", helyszin=" + helyszin + ", datum=" + datum + '}';
    }

}
