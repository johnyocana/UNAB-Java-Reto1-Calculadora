package unab.reto1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operaciones {

    int opcion, num;
    double resultado, num2;
    char continuar = 'S';
    boolean operador = true;
    boolean confirmacion = true;
    Scanner lee = new Scanner(System.in);

    public void limpiar() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

    public void menu() {
        do {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Operaciones enteros positivos (Suma - Resta - Division - Multiplicacion).");
            System.out.println("2. Operaciones numeros positivos y negativos. (Suma - Resta - Division - Multiplicacion - Raiz - Potencia).");
            System.out.println("3. Salir.");
            System.out.print("Ingrese la opcion: ");
            try {
                opcion = lee.nextInt();
                if (opcion >= 1 && opcion <= 3) {
                    switch (opcion) {
                        case 1:
                            leeNumerosP();
                            break;
                        case 2:
                            leeNumerosPN();
                            break;
                        case 3:
                            System.out.println("Programa finalizado.");
                            continuar = 'N';
                            break;
                    }
                } else {
                    limpiar();
                    System.out.println("\n!!! Opcion no existe, cargando el menu ¡¡¡\n");
                }
            } catch (InputMismatchException e) {
                limpiar();
                System.out.println("\n!!! Opcion errada, cargando el menu ¡¡¡\n");
                lee = new Scanner(System.in);
            }
        } while (continuar == 'S');
    }

    public void leeNumerosP() {
        do {
            limpiar();
            System.out.println("OPERACIONES ENTEROS POSITIVOS \n(Suma - Resta - Division - Multiplicacion).");
            int num1 = capturaNumerosP("Ingrese primer numero: ");
            String tipo;
            do {
                System.out.print("Operacion a realizar (+) (-) (*) (/): ");
                tipo = lee.next();
                if ("+".equals(tipo) || "-".equals(tipo) || "*".equals(tipo) || "/".equals(tipo)) {
                    operador = false;
                }
            } while (operador == true);
            int num2 = capturaNumerosP("Ingrese segundo numero: ");
            System.out.println(num1 + " " + tipo + " " + num2 + " = " + operaDatos(num1, num2, tipo));
            System.out.print("Otra operacion (Si / No) : ");
            continuar = lee.next().toUpperCase().charAt(0);
        } while (continuar == 'S');
        limpiar();
        menu();
    }

    public int capturaNumerosP(String mensaje) {
        do {
            num = -1;
            do {
                try {
                    System.out.print(mensaje);
                    num = lee.nextInt();
                } catch (InputMismatchException f) {
                    lee = new Scanner(System.in);
                }
            } while (num < 0);
            confirmacion = false;
            return num;
        } while (confirmacion == true);
    }

    public void leeNumerosPN() {
        do  {
            limpiar();
            System.out.println("OPERACIONES NEGATIVOS Y/O POSITIVOS \n(Suma - Resta - Division - Multiplicacion - Raiz - Potencia).");
            double num1 = capturaNumerosPN("Ingrese el primer numero: ");
            String tipo;
            do {
                System.out.print("Operacion a realizar (+) (-) (*) (/) (R -> Raiz) (P -> Potencia): ");
                tipo = lee.next().toUpperCase();
                               
                if ("+".equals(tipo) || "-".equals(tipo) || "*".equals(tipo) || "/".equals(tipo) || "R".equals(tipo) || "P".equals(tipo)){
                    if("+".equals(tipo) || "-".equals(tipo) || "*".equals(tipo) || "/".equals(tipo)){
                        num2 = capturaNumerosPN("Ingrese el segundo numero: ");
                    }else if("R".equals(tipo)){
                        num2 = capturaNumerosPN("Ingrese la raiz: ");
                    }else if("P".equals(tipo)){
                        num2 = capturaNumerosPN("Ingrese la potencia: ");
                    }
                    operador = false;
                }
            } while (operador == true);
            
            System.out.println(num1 + " " + tipo + " " + num2 + " = " + operaDatos(num1, num2, tipo));
            System.out.print("Otra operacion (Si / No) : ");
            continuar = lee.next().toUpperCase().charAt(0);
        }while (continuar == 'S');
        limpiar();
        menu();
    }

    public double capturaNumerosPN(String mensaje) {
        do {
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
        } while (confirmacion == true);
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
            case "R":
                return resultado = Math.pow(num1, (double) 1 / num2);
            case "P":
                return resultado = Math.pow(num1, num2);
        }
        return resultado;
    }
}
