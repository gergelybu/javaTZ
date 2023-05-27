package buraigergely_1zaro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private Eredmenyek[] eredmenyek;

    public Main() throws IOException {
        List<String> sorok = Files.readAllLines(Path.of("eredmenyek.csv"));

        eredmenyek = new Eredmenyek[sorok.size() - 1];
        for (int i = 0; i < sorok.size() - 1; i++) {
            String sor = sorok.get(i + 1);
            Eredmenyek eredmeny = new Eredmenyek(sor);
            eredmenyek[i] = eredmeny;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().feladatok();
    }

    private void feladatok() throws IOException {
        feladat1();
        feladat2();
        feladat3();
        feladat4();
        feladat5();
        feladat6();
        feladat7();
    }

    private void feladat1() {
        System.out.println("1. Hányszor játszott hazai és hányszor idegen pályán a Real Madrid?");
        System.out.println("");
        int hazai = 0;
        int idegen = 0;
        for (int i = 0; i < eredmenyek.length; i++) {
            if (eredmenyek[i].getHazai().equals("Real Madrid")) {
                hazai++;
            } else if (eredmenyek[i].getIdegen().equals("Real Madrid")) {
                idegen++;
            }
        }
        System.out.println("A Real Madrid " + hazai + " hazai mérkőzést játszott, míg idegen pályán " + idegen + " mérkőzést.");
        feladatVege();
    }

    private void feladat2() {
        System.out.println("2. Mennyi a Real Madrid hazai mérkőzésének átlag pontja 2 tizedes pontossággal?");
        System.out.println("");
        int pontok = 0;
        int db = 0;
        for (int i = 0; i < eredmenyek.length; i++) {
            if (eredmenyek[i].getHazai().equals("Real Madrid")) {
                pontok += eredmenyek[i].getHazaipont();
                db++;
            }
        }
        float atlag = pontok / db;
        System.out.printf("A Real Madrid hazai pontjainak átlaga: %.2f\n", atlag);
        System.out.println("");
        feladatVege();
    }

    private void feladat3() {
        System.out.println("3. Mikor játszott a Reál Madrid idegenben, ahol a hazaiak pontja 55 volt?");
        System.out.println("");
        int i = 0;
        while (i < eredmenyek.length && !(eredmenyek[i].getIdegen().equals("Real Madrid") && eredmenyek[i].getHazaipont() == 55)) {
            i++;
        }
        System.out.printf("A mérkőzés dátuma, ahol a Real Madrid idegenben 55 pontot szerzett: %S\n", eredmenyek[i].getDatum());
        feladatVege();
    }

    private void feladat4() {
        System.out.println("4. Volt olyan mérkőzés, ahol a Real Madrid döntetlent játszott?");
        System.out.println("");
        int i = 0;
        while (i < eredmenyek.length && eredmenyek[i].getHazaipont() != eredmenyek[i].getIdegenpont() && !(eredmenyek[i].getHazai().equals("Real Madrid") && eredmenyek[i].getIdegen().equals("Real Madrid"))) {
            i++;
        }
        System.out.println(i < eredmenyek.length ? "A Real Madrid játszott döntetlen mérkőzést." : "A Real Madrid nem játszott döntetlen mérkőzést.");
        feladatVege();
    }

    private void feladat5() {
        System.out.println("5. Milyen helyszíneken kerültek megrendezére a mérkőzések?");
        System.out.println("");
        Set<String> helyszin = new HashSet<>();
        for (Eredmenyek eredmeny : eredmenyek) {
            helyszin.add(eredmeny.getHelyszin());
        }
        System.out.println("Az alábbi helyszíneken kerültek megrendezésre mérkőzések:");
        for (String hely : helyszin) {
            System.out.println(hely);
        }
        feladatVege();
    }

    private void feladat6() throws IOException {
        System.out.println("6. Írd ki a 'datumok.txt' fájlba, hogy melyik dátumnál hány darab mérkőzés volt?");
        System.out.println("");
        Map<String, Integer> datumok = new HashMap<>();
        for (Eredmenyek eredmeny : eredmenyek) {
            String kulcs = eredmeny.getDatum();
            if (datumok.containsKey(kulcs)) {
                int ertek = datumok.get(kulcs);
                datumok.put(kulcs, ++ertek);

            } else {
                datumok.put(kulcs, 1);
            }
        }
        String kimenet = "";
        for (Map.Entry<String, Integer> entry : datumok.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            kimenet += key + ": " + value + "\n";
        }
        Files.writeString(Path.of("datumok.txt"), kimenet);
        System.out.println("Az adatok kiírása megtörtént a 'datumok.txt' fájlba!");

        feladatVege();
    }

    private void feladat7() {
        System.out.println("7. Tárold el tömb adatszerkezetben a hazai csapatok nevét, majd írd is ki a neveket sorba rendezve a konzolra.");
        System.out.println("");
        Set<String> hazaiCsapat = new HashSet<>();
        for (Eredmenyek eredmeny : eredmenyek) {
            hazaiCsapat.add(eredmeny.getHazai());
        }
        String[] hazaiCsapatok = new String[hazaiCsapat.size()];
        int i = 0;
        for (String elem : hazaiCsapat) {
            hazaiCsapatok[i] = elem;
            i++;
        }
        Arrays.sort(hazaiCsapatok);
        System.out.println("A hazai Csapatok:");
        for (String csapat : hazaiCsapatok) {
            System.out.println(csapat);
        }
        feladatVege();
    }

    private void feladatVege() {
        System.out.println("-------------------");
        System.out.println("");
    }
}
