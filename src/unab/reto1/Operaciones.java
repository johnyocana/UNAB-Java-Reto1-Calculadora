package unab.reto1;

import java.util.Objects;
import java.util.Scanner;

public class Operaciones {

    int opcion, num;
    float numP, resultadoP;
    double numPN, resultadoPN, numPN2;
    char continuar = 'S';
    boolean operador = true;
    Scanner lee = new Scanner(System.in);

    public void limpiar() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void menu() {
        continuar = 'S';
        while (continuar == 'S') {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Operaciones solo con numeros positivos (Suma - Resta - Division - Multiplicacion).");
            System.out.println("2. Operaciones con numeros positivos y negativos. (Suma - Resta - Division - Multiplicacion - Raiz - Potencia).");
            System.out.println("3. Salir.");
            System.out.print("Ingrese la opcion: ");
            opcion = lee.nextInt();
            if (opcion >= 1 && opcion <= 3) {
                switch (opcion) {
                    case 1:
                        limpiar();
                        leeNumerosP();
                        break;
                    case 2:
                        limpiar();
                        leeNumerosPN();
                        break;
                    case 3:
                        continuar = 'N';
                        break;
                }
            } else {
                System.out.println("\nOPCION NO VALIDA - CARGANDO DE NUEVO EL MENU.\n");
                limpiar();
                menu();
            }
        }
    }

    public void leeNumerosP() {
        while (continuar == 'S') {
            float numP1 = capturaNumerosP("Ingrese el primer numero: ");
            String tipo;
            do {
                System.out.print("Operacion a realizar (+) (-) (*) (/): ");
                tipo = lee.next();
                if ("+".equals(tipo) || "-".equals(tipo) || "*".equals(tipo) || "/".equals(tipo)) {
                    operador = false;
                }
            } while (operador == true);
            float numP2 = capturaNumerosP("Ingrese el segundo numero: ");
            System.out.println(numP1 + " " + tipo + " " + numP2 + " = " + operaDatosP(numP1, numP2, tipo));
            System.out.print("Desea realizar otra operacion Si o No: ");
            continuar = lee.next().toUpperCase().charAt(0);
        }
        limpiar();
        menu();
    }

    public float capturaNumerosP(String mensaje) {
        do {
            System.out.print(mensaje);
            numP = lee.nextFloat();
        } while (numP < 0);
        return numP;
    }

    public float operaDatosP(float numP1, float numP2, String tipo) {
        switch (tipo) {
            case "+":
                return resultadoP = numP1 + numP2;
            case "-":
                return resultadoP = numP1 - numP2;
            case "*":
                return resultadoP = numP1 * numP2;
            case "/":
                return resultadoP = numP1 / numP2;
        }
        return resultadoP;
    }

    public void leeNumerosPN() {
        while (continuar == 'S') {
            double numPN1 = capturaNumerosPN("Ingrese el primer numero: ");
            String tipo;
            do {
                System.out.print("Operacion a realizar (+) (-) (*) (/) (R -> Raiz) (P -> Potencia): ");
                tipo = lee.next().toUpperCase();
                               
                if ("+".equals(tipo) || "-".equals(tipo) || "*".equals(tipo) || "/".equals(tipo) || "R".equals(tipo) || "P".equals(tipo)){
                    if("+".equals(tipo) || "-".equals(tipo) || "*".equals(tipo) || "/".equals(tipo)){
                        numPN2 = capturaNumerosPN("Ingrese el segundo numero: ");
                    }else if("R".equals(tipo)){
                        numPN2 = capturaNumerosPN("Ingrese la raiz: ");
                    }else if("P".equals(tipo)){
                        numPN2 = capturaNumerosPN("Ingrese la potencia: ");
                    }
                    operador = false;
                }
            } while (operador == true);
            
            System.out.println(numPN1 + " " + tipo + " " + numPN2 + " = " + operaDatosPN(numPN1, numPN2, tipo));
            System.out.print("Desea realizar otra operacion Si o No: ");
            continuar = lee.next().toUpperCase().charAt(0);
        }
        limpiar();
        menu();
    }

    public double capturaNumerosPN(String mensaje) {
        Double numPN = null;
        String valorLeido;
        do {
            System.out.print(mensaje);
            try {
                valorLeido = lee.next();
                numPN = Double.parseDouble(valorLeido);

            } catch (NumberFormatException error) {
                numPN = null;
            }
        } while (numPN == null);
        return numPN;
    }

    public double operaDatosPN(double numPN1, double numPN2, String tipo) {
        switch (tipo) {
            case "+":
                return resultadoPN = numPN1 + numPN2;
            case "-":
                return resultadoPN = numPN1 - numPN2;
            case "*":
                return resultadoPN = numPN1 * numPN2;
            case "/":
                return resultadoPN = numPN1 / numPN2;
            case "R":
                return resultadoPN = Math.pow(numPN1, (double) 1 / numPN2);
            case "P":
                return resultadoPN = Math.pow(numPN1, numPN2);
        }
        return resultadoP;
    }
}
