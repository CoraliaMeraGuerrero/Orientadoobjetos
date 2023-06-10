/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antoniaprogramaaritmetico;

/**
 *
 * @author Santiago Rodriguez
 */
import java.util.Scanner;

public class ProgramaAritmetico {
    private Scanner scanner;
    private int nivelDificultad;
    private int tipoProblema;

    public ProgramaAritmetico() {
        scanner = new Scanner(System.in);
    }

    public void iniciarPrograma() {
        System.out.println("*********Programa Aritmetico***********");
        nivelDificultad = seleccionarNivelDificultad();
        tipoProblema = seleccionarTipoProblema();
        scanner.close();

        // Resto del código omitido
    }

    private int seleccionarNivelDificultad() {
        System.out.println("**********Nivel de Dificultad************");
        System.out.println("1. Problemas de un digito");
        System.out.println("2. Problemas de dos digitos");
        System.out.println("3. Problemas de tres digitos");
        System.out.println("4. Problemas de cuatro digitos");
        return scanner.nextInt();
    }

    private int seleccionarTipoProblema() {
        System.out.println("Elige el tipo de problema:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Mezcla de operaciones aleatorios");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        ProgramaAritmetico programa = new ProgramaAritmetico();
        programa.iniciarPrograma();
    }
}
