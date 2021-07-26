package unab.reto1;

import java.util.Scanner;

public class Operaciones {

    double num, num1, num2, resultado;
    String tipo;
    Scanner lee = new Scanner(System.in);
//    public float capturaDatos(String mensaje) {
//        do {
//            
//            System.out.print(mensaje);
//            num = lee.nextFloat();
//        } while (num < 0);
//        return num;
//    }

    public double capturaDatos(String mensaje) {
        Double num = null;
        String valorleido;
        do {
            System.out.print(mensaje);
            try {
                valorleido = lee.next();
                num = Double.parseDouble(valorleido);

            } catch (NumberFormatException error) {
                num = null;
            }
        } while (num == null);
        return num;
    }

    public double operaDatos(double num1, double num2, String tipo) {
        switch (tipo) {
            case "+":
                return resultado = num1 + num2;
            case "-":
                return resultado = num1 - num2;
            case "*":
                return resultado = num1 * num2;
            case "/":
                return resultado = num1 / num2;
            case "":
                return resultado = num1 / num2;
        }
        return resultado;
    }
}
