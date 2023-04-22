package com.example.pascal;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Objects;

public class PascalGen {
    public static void betterGenerate(TextFlow node, String arg) {
        int n = 0;
        boolean fault = false;
        if (Objects.equals(arg, "")){
            node.getChildren().add(new Text("Proszę podać liczbę"));
            fault = true;
        }else {
        try {
            n = Integer.parseInt(arg);
        } catch (NumberFormatException ex) {
            node.getChildren().add(new Text("argument nie jest liczbą całkowitą"));
            fault = true;
        }}
        if (!fault) {
            betterConstruct(node, n);
        }
    }

    public static void betterConstruct(TextFlow node, int n) {
        outer:for (int i = 0; i <= n; i++) {
            long binom = 1;
            StringBuilder line = new StringBuilder();
            line.append("1  ");
            for (int j = 1; j <= i; j++) {
                try {
                    binom = Math.multiplyExact(binom, (i - j + 1));
                    binom = Math.divideExact(binom, j);
                }catch (ArithmeticException ex){
                    node.getChildren().add(new Text("Wiersz: " + Long.toString(i) + " Przekroczono zakres liczbowy, dalsze operacje nie zwrócą poprawnych wyników"));
                    break outer;
                }
                line.append(binom).append("  ");
            }
            line.deleteCharAt(line.length() - 1);
            line.setCharAt(line.length() - 1, '\n');
            node.getChildren().add(new Text(line.toString()));
        }
    }

    public static String generate(String arg) {
        int n;
        try {
            n = Integer.parseInt(arg);
        } catch (NumberFormatException ex) {
            return "argument nie jest liczbą całkowitą";
        }
        return construct(n);
    }

    private static String construct(int n) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            long binom = 1;
            output.append("1 ");
            for (int j = 1; j <= i; j++) {
                binom *= (i - j + 1);
                binom /= j;
                output.append(binom).append(" ");
            }
            output.append("\n");
        }
        return output.toString();
    }
}
