/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuenta;

import java.util.Scanner;

/**
 *
 * @author Jess
 */
public class Cuenta {

    public static void main(String[] args) {
        cuentaBancaria cuenta = new cuentaBancaria();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("===MENU ===");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Consultar saldo e historial");
            System.out.println("5. Salir");

            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cuenta.crearCuenta();
                    break;
                case 2:
                    cuenta.depositar();
                    break;
                case 3:
                    cuenta.retirar();
                    break;
                case 4:
                    cuenta.mostrarDatos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 5);

        scanner.close();
    }

}
