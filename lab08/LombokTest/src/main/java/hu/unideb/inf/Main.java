package hu.unideb.inf;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        LegoSet lego1 = new LegoSet("CODE", "THEME", 5);
        LegoSet lego2 = new LegoSet("CODE2", "THEME2", 10);
        System.out.println(lego1);
        System.out.println(lego2);
        System.out.println(Objects.equals(lego1, lego2));
        System.out.println(lego1.getBricks());
        lego2.setTheme("SETTHEME");
        System.out.println(lego2);
        LegoSet lego3 = new LegoSet("CODEFINAL");
        System.out.println(lego3);
    }
}