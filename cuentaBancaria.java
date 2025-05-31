/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuenta;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;

/**
 *
 * @author Jess
 */
public class cuentaBancaria {

    private int numeroCuenta;
    private String nombreTitular;
    private double saldo;
    private boolean cuentaCreada;
    private Scanner scanner;
    private ArrayList<String> historial; 

    public cuentaBancaria() {
        scanner = new Scanner(System.in);
        historial = new ArrayList<>();
    }

    public void crearCuenta() {
        if (cuentaCreada) {
            System.out.println("La cuenta ya ha sido creada.");
            return;
        }

        try {
            System.out.print("Numero de cuenta: ");
            numeroCuenta = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Nombre del titular: ");
            nombreTitular = scanner.nextLine();

            System.out.print("Saldo inicial: ");
            double saldoInicial = scanner.nextDouble();

            if (saldoInicial < 0) {
                System.out.println("El saldo inicial no puede ser negativo.");
            } else {
                saldo = saldoInicial;
                cuentaCreada = true;
                System.out.println("Cuenta creada exitosamente.");
                historial.add("Cuenta creada con saldo inicial: " + saldoInicial);
            }
        } catch (Exception e) {
            System.out.println("Ingreso invalido.");
            scanner.nextLine(); 
        }
    }

    public void depositar() {
        if (!cuentaCreada) {
            System.out.println("Debe crear una cuenta primero.");
            return;
        }

        try {
            System.out.print("Monto a depositar: ");
            double monto = scanner.nextDouble();

            if (monto > 0) {
                saldo += monto;
                System.out.println("Deposito exitoso: + " + monto + "\n Saldo actual: "+ saldo);
                historial.add("Deposito: + " + monto);
            } else {
                System.out.println("El monto debe ser mayor que cero.");
            }
        } catch (Exception e) {
            System.out.println(" Monto invalido.");
            scanner.nextLine();
        }
    }

    public void retirar() {
        if (!cuentaCreada) {
            System.out.println("Debe crear una cuenta primero.");
            return;
        }

        try {
            System.out.print("Monto a retirar: ");
            double monto = scanner.nextDouble();

            if (monto > 0 && monto <= saldo) {
                saldo -= monto;
                System.out.println("Retiro exitoso: - " + monto + "\nSaldo actual: "+ saldo);
                historial.add("Retiro: - " + monto );
            } else {
                System.out.println("Fondo insuficiente o monto invalido");
            }
        } catch (Exception e) {
            System.out.println("Monto invalido.");
            scanner.nextLine();
        }
    }

    public void mostrarDatos() {
        if (!cuentaCreada) {
            System.out.println("Debe crear una cuenta primero.");
            return;
        }

        System.out.println("\nNumero de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + nombreTitular);
        System.out.println("Saldo actual: " + saldo);

        System.out.println("\nHistorial de transacciones");
        for (String transaccion : historial) {
            System.out.println(transaccion);
        }
    }
    
}