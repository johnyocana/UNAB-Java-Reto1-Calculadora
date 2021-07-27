package unab.reto1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operaciones {
    //Se declaran las variables
    int opcion, num;
    double resultado, num2;
    char continuar = 'S';
    boolean operador = true;
    boolean confirmacion = true;
    String tipo;
    Scanner lee = new Scanner(System.in);
    
    public void limpiar() {//Funcion que limnpia pantalla haciendo saltos de linea
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }
    
    public void menu() {// Funcion menu
        do {//Ciclo para mostrar en pantalla en el menu
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Operaciones enteros positivos (Suma - Resta - Division - Multiplicacion).");
            System.out.println("2. Operaciones numeros positivos y negativos. (Suma - Resta - Division - Multiplicacion - Raiz - Potencia).");
            System.out.println("3. Salir.");
            System.out.print("Ingrese la opcion: ");
            try {//Excepcion cuando se ingresa un valor diferente a un numero
                opcion = lee.nextInt();
                if (opcion >= 1 && opcion <= 3) {
                    switch (opcion) {//Se ejecuta accion segun la opcion ingresada
                        case 1:
                            leeNumerosP();//Invoca funcion que lee numeros enteros
                            break;
                        case 2:
                            leeNumerosPN();//Invoca funcion que lee numeros negativos y/o positivos
                            break;
                        case 3:
                            limpiar();//Se finaliza el programa
                            System.out.println("Programa finalizado.");
                            continuar = 'N';
                            break;
                    }
                } else {
                    limpiar();
                    System.out.println("\n!!! Opcion no existe, cargando el menu ¡¡¡\n");//Error generado cuando se ingresa opcion diferente a 1-3
                }
            } catch (InputMismatchException e) {
                limpiar();
                System.out.println("\n!!! Opcion errada, cargando el menu ¡¡¡\n");//Error generado al recibir dato diferente a numero
                lee = new Scanner(System.in);//Detiner el codido debido a que se genera un ciclo infinito
            }
        } while (continuar == 'S');//Fin del ciclo de menu
    }

    public void leeNumerosP() {//Funcion que lee numeros enteros positivos
        do {//Inicio ciclo que lee numeros enteros
            limpiar();
            System.out.println("OPERACIONES ENTEROS POSITIVOS \n(Suma - Resta - Division - Multiplicacion).");
            int num1 = capturaNumerosP("Ingrese primer numero: ");//Solicita primer numero y envia a funcion capturaNumerosP para vallidacion
            do {//Ciclo que se ejecuta mientras se ingresa el valor requerido
                System.out.print("Operacion a realizar (+) (-) (*) (/): ");//Pide el tipo de operacion
                tipo = lee.next();
                operador = !("+".equals(tipo) || "-".equals(tipo) || "*".equals(tipo) || "/".equals(tipo));//Se define en la variable lo que no corresponde, hasta que si se cumple y cambia estado a false
            } while (operador == true);//Finalia el ciclo
            int num2 = capturaNumerosP("Ingrese segundo numero: ");//Solicita segundo numero y envia a funcion capturaNumerosP para vallidacion
            System.out.println(num1 + " " + tipo + " " + num2 + " = " + operaDatos(num1, num2, tipo));//Imprime en pantalla la operacin realizada en operaDatos
            System.out.print("Otra operacion (Si / No) : ");//Pregunta si se desea continuar
            continuar = lee.next().toUpperCase().charAt(0);//Cambiar el texto ingresado a mayuscula y toma la primera letra
        } while (continuar == 'S');
        limpiar();
        menu();//Retorna al menu al finalizar la funcion
    }

    public int capturaNumerosP(String mensaje) {//Funcion que muestra mensaje, captura dato y hace manejo de excepcion
        do {//Ciclo que se realiza hasta que se confirma que los datos son correctos (que el dato sea numero y que sea positivo
            num = -1;//se inicia cada ciclo con un -1 para que se ejecute hasta que se retrona el dato correcto
            do {//Ciclo que se ejcuta hasta que el numero ingresado es mayor que 0
                try {//Inicio de manejo de excepcion
                    System.out.print(mensaje);//Muestra el mensaje recibido en la funcion
                    num = lee.nextInt();//Captura el dato
                } catch (InputMismatchException f) {//Tipo de excepcion que se genera al recibir un texto
                    lee = new Scanner(System.in);//Accion realizada al presentarse la excepcion
                }
            } while (num < 0);//Comprobacion de variable para repetir o detener el ciclo
            confirmacion = false;//Se deja variable en false para dar por terminado el ciclo
            return num;//Retorna el numero positivo entero
        } while (confirmacion == true);//Comprobacion de variable para repetir o detener el ciclo
    }

    public void leeNumerosPN() {//Funcion que lee numeros negativos y positivos
        do {
            limpiar();
            System.out.println("OPERACIONES NEGATIVOS Y/O POSITIVOS \n(Suma - Resta - Division - Multiplicacion - Raiz - Potencia).");
            double num1 = capturaNumerosPN("Ingrese primer numero: ");//Solicita primer numero
            do {//Ciclo que se ejecuta hasta capturar los datos requeridos
                operador = true;//variable en true para iniciar en cada ciclo
                System.out.print("Operacion a realizar (+) (-) (*) (/) (R -> Raiz) (P -> Potencia): ");//Pide el tipo de operacion
                tipo = lee.next().toUpperCase();
                if ("+".equals(tipo) || "-".equals(tipo) || "*".equals(tipo) || "/".equals(tipo) || "R".equals(tipo) || "P".equals(tipo)) {//Valida que lo ingresado corresponda a los valores requeridos
                    switch (tipo){//Al pasar la validacion se solicitara numero dos con mensaje segun la opcion
                        case "R":
                            num2 = capturaNumerosPN("Ingrese raiz: ");//Mensaje cuando se opera con raiz
                            break;
                        case "P":
                            num2 = capturaNumerosPN("Ingrese potencia: ");//Mensaje cuando se opera con potencia
                            break;
                        default:
                            num2 = capturaNumerosPN("Ingrese segundo numero: ");//Mensaje cuando se opera con suma, resta, multiplicacion y division
                            break;
                    }
                    operador = false;//Se deja variable en false para dar por terminado el ciclo
                }
            } while (operador == true);//Comprobacion de variable para repetir o detener el ciclo
            System.out.println(num1 + " " + tipo + " " + num2 + " = " + operaDatos(num1, num2, tipo));//Imprime en pantalla la operacin realizada en operaDatos
            System.out.print("Otra operacion (Si / No) : ");//Pregunta si se desea continuar
            continuar = lee.next().toUpperCase().charAt(0);//Cambiar el texto ingresado a mayuscula y toma la primera letra
        } while (continuar == 'S');//Comprobacion de variable para repetir o detener el ciclo
        limpiar();
        menu();
    }
    
    public double capturaNumerosPN(String mensaje) {//Funcion que muestra mensaje, captura dato y hace manejo de excepcion
        do {
            Double numPN = null;//Se define variable de comprobacion del ciclo antes de iniciar
            String valorLeido;//Se define variable
            do {//Inicio de ciclo que comprueba que el numero no sea nulo mediante la excepcion
                System.out.print(mensaje);//Imprime mensaje recibido
                try {
                    valorLeido = lee.next();//Captura el dato ingresado
                    numPN = Double.parseDouble(valorLeido);//pasa el dato ingresado a Double
                } catch (NumberFormatException error) {//Tipo de excepcion que se genera al recibir un texto
                    numPN = null;//Deja variable en null para que se repita el ciclo
                }
            } while (numPN == null);//Comprobacion de variable para repetir o detener el ciclo
            confirmacion = false;//Deja variable en false para que se termine el ciclo
            return numPN;//Retorna el numero capturado
        } while (confirmacion == true);//Comprobacion de variable para repetir o detener el ciclo
    }

    public double operaDatos(double num1, double num2, String tipo) {//Funcion que realiza las operaciones
        switch (tipo) {//Segun el operador ingresado realizara proceso
            case "+"://Operador al recibir suma
                return resultado = num1 + num2;
            case "-"://Operador al recibir resta
                return resultado = num1 - num2;
            case "*"://Operador al recibir multiplicacion
                return resultado = num1 * num2;
            case "/"://Operador al recibir division
                return resultado = num1 / num2;
            case "R"://Operador al recibir raiz definido con R
                return resultado = Math.pow(num1, (double) 1 / num2);
            case "P"://Operador al recibir potencia definido con P
                return resultado = Math.pow(num1, num2);
        }
        return resultado;
    }
}
