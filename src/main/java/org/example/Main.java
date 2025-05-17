package org.example;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
    public static JSONObject rezolva(double a, double b) {
        JSONObject rezultat = new JSONObject();

        if (a == 0) {
            rezultat.put("situatie", (b == 0) ? "infinit_soluții" : "fara_soluție");
            rezultat.put("mesaj", (b == 0) ? "Orice x este soluție." : "Nu există soluții.");
        } else {
            rezultat.put("situatie", "soluție_unică");
            rezultat.put("x", -b / a);
        }

        return rezultat;
    }

    public static void salveazaJson(JSONObject rezultat, String filename) {
        try {
            Files.write(Paths.get(filename), rezultat.toString(4).getBytes());
        } catch (IOException e) {
            System.out.println("Eroare la salvare: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JSONObject solutie = rezolva(2, -4);
        System.out.println(solutie.toString(4));
        salveazaJson(solutie, "solutie.json");
    }
}
