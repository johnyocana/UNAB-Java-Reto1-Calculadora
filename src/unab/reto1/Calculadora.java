package unab.reto1;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);
        char continuar ='S';
        Operaciones func = new Operaciones();
        boolean operador = true;
        
        while (continuar == 'S') {
            double num1 = func.capturaDatos("Ingrese el primer numero: ");
            String tipo;
            do {
                System.out.print("Operacion a realizar (+) (-) (*) (/): ");
                tipo = lee.next();
                if ("+".equals(tipo) || "-".equals(tipo) || "*".equals(tipo) || "/".equals(tipo)) {
                    operador = false;
                }
            } while (operador == true);
            double num2 = func.capturaDatos("Ingrese el segundo numero: ");
            System.out.println(num1 + " " + tipo + " " + num2 + " = " + func.operaDatos(num1, num2, tipo));
            System.out.print("Desea realizar otra operacion Si o No: ");
            continuar = lee.next().toUpperCase().charAt(0);
        }
    }
}
