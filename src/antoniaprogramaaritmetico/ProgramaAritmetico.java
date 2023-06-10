/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antoniaprogramaaritmetico;

/**
 *
 * @author Santiago Rodriguez
 */
import java.security.SecureRandom;
import java.util.Scanner;

public class ProgramaAritmetico {
    private Scanner scanner;
    private SecureRandom random;
    private int rCorrectas;
    private int rIncorrectas;
    private int rRealizadas;
    private int nivelDificultad;
    private int tipoProblema;

    public ProgramaAritmetico() {
        scanner = new Scanner(System.in);
        random = new SecureRandom();
        rCorrectas = 0;
        rIncorrectas = 0;
        rRealizadas = 0;
    }

    public void iniciarPrograma() {
        System.out.println("*********Programa Aritmetico***********");
        NivelDificultad();
        TipoProblema();
        generarProblemasAritmeticos();
        mostrarResultados();
        mostrarMensaje();
        scanner.close();
    }

    private void NivelDificultad() {
        System.out.println("**********Nivel de Dificultad************");
        System.out.println("1. Problemas de un digito");
        System.out.println("2. Problemas de dos digitos");
        System.out.println("3. Problemas de tres digitos");
        System.out.println("4. Problemas de cuatro digitos");
        nivelDificultad = scanner.nextInt();
    }

    private void TipoProblema() {
        System.out.println("Elige el tipo de problema:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Mezcla de operaciones aleatorias");
        tipoProblema = scanner.nextInt();
    }

    private void generarProblemasAritmeticos() {
        while (rRealizadas < 10 && (rCorrectas + rIncorrectas) < 10) {
            int numero1, numero2, resultado;
            String operador;

            int rangoNumeros;
            switch (nivelDificultad) {
                case 1:
                    rangoNumeros = 10;
                    break;
                case 2:
                    rangoNumeros = 100;
                    break;
                case 3:
                    rangoNumeros = 1000;
                    break;
                default:
                    rangoNumeros = 10000;
                    break;
            }

            numero1 = random.nextInt(rangoNumeros);
            numero2 = random.nextInt(rangoNumeros);

            switch (tipoProblema) {
                case 1:
                    operador = "+";
                    resultado = numero1 + numero2;
                    break;
                case 2:
                    operador = "-";
                    resultado = numero1 - numero2;
                    break;
                case 3:
                    operador = "*";
                    resultado = numero1 * numero2;
                    break;
                case 4:
                    operador = "/";
                    while (numero2 == 0 || numero1 % numero2 != 0) {
                        numero1 = random.nextInt(rangoNumeros);
                        numero2 = random.nextInt(rangoNumeros);
                    }
                    resultado = numero1 / numero2;
                    break;
                default:
                    int randomTipoProblema = random.nextInt(4) + 1;
                    switch (randomTipoProblema) {
                        case 1:
                            operador = "+";
                            resultado = numero1 + numero2;
                            break;
                        case 2:
                            operador = "-";
                            resultado = numero1 - numero2;
                            break;
                        case 3:
                            operador = "*";
                            resultado = numero1 * numero2;
                            break;
                        case 4:
                            operador = "/";
                            while (numero2 == 0 || numero1 % numero2 != 0) {
                                numero1 = random.nextInt(rangoNumeros);
                                numero2 = random.nextInt(rangoNumeros);
                            }
                            resultado = numero1 / numero2;
                            break;
                        default:
                            operador = "";
                            resultado = 0;
                            break;
                    }
                    break;
            }

            System.out.println("Resuelve el siguiente problema:");
            System.out.println(numero1 + " " + operador + " " + numero2 + " = ?");
            int respuestaUsuario = scanner.nextInt();

            while (respuestaUsuario != resultado && rRealizadas < 10) {
                System.out.println("Respuesta incorrecta. Inténtalo nuevamente:");
                rIncorrectas++;
                rRealizadas++;
                respuestaUsuario = scanner.nextInt();
            }

            if (respuestaUsuario == resultado) {
                rCorrectas++;
                rRealizadas++;
                int seleccion = random.nextInt(4) + 1;
                switch (seleccion) {
                    case 1:
                        System.out.println("Muy Bien");
                        break;
                    case 2:
                        System.out.println("Excelente!");
                        break;
                    case 3:
                        System.out.println("Buen Trabajo");
                        break;
                    case 4:
                        System.out.println("Sigue Así");
                        break;
                }
            }
        }
    }

    private void mostrarResultados() {
        double porcentajeCorrectas = (double) rCorrectas / rRealizadas * 100;
        System.out.println("Respuestas correctas: " + rCorrectas);
        System.out.println("Respuestas incorrectas: " + rIncorrectas);
        System.out.println("Porcentaje Obtenido: " + porcentajeCorrectas + "%");
    }

    private void mostrarMensaje() {
        double porcentajeCorrectas = (double) rCorrectas / rRealizadas * 100;
        if (porcentajeCorrectas < 75) {
            System.out.println("Por favor, pide ayuda adicional a tu instructor.");
        } else {
            System.out.println("¡Felicidades! Listo para pasar al siguiente nivel.");
        }
    }

    public static void main(String[] args) {
        ProgramaAritmetico programa = new ProgramaAritmetico();
        programa.iniciarPrograma();
    }
}