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
    private static final int NUM_PREGUNTAS = 10;

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
        reiniciarPrograma();
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
        String[] respuestasPositivas = {"Muy bien", "Excelente", "Buen trabajo", "Sigue así"};
        String[] respuestasNegativas = {"Incorrecto", "Inténtalo de nuevo", "Respuesta incorrecta"};

        while (rRealizadas < NUM_PREGUNTAS && (rCorrectas + rIncorrectas) < NUM_PREGUNTAS) {
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

            while (respuestaUsuario != resultado && rRealizadas < NUM_PREGUNTAS) {
                System.out.println(respuestasNegativas[random.nextInt(respuestasNegativas.length)]);
                rIncorrectas++;
                rRealizadas++;
                respuestaUsuario = scanner.nextInt();
            }

            if (respuestaUsuario == resultado) {
                rCorrectas++;
                rRealizadas++;
                System.out.println(respuestasPositivas[random.nextInt(respuestasPositivas.length)]);
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
            System.out.println("¡Felicidades! Estás listo para pasar al siguiente nivel.");
        }
    }

    private void reiniciarPrograma() {
        System.out.println("¿Deseas iniciar el programa nuevamente? (Sí: 1 / No: 0)");
        int reiniciar = scanner.nextInt();
        if (reiniciar == 1) {
            rCorrectas = 0;
            rIncorrectas = 0;
            rRealizadas = 0;
            NivelDificultad();
            TipoProblema();
            generarProblemasAritmeticos();
            mostrarResultados();
            mostrarMensaje();
            reiniciarPrograma();
        }
    }

    public static void main(String[] args) {
        ProgramaAritmetico programa = new ProgramaAritmetico();
        programa.iniciarPrograma();
    }
}
