package u3_ed_proyecto;

import java.util.Scanner;

/**
 *
 * @author Javier Ismael Sampablo Cuevas
 */
public class U3_ED_PROYECTO {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        Platos p = new Platos();
        Mesa m = new Mesa();
        int opc = 0;
        // Restaurante
        do {
            System.out.println("- - - - - Menú de opciones - - - - -");
            System.out.println("1.- Llegada de clientes"); //altas
            System.out.println("2.- Salida de clientes"); //bajas
            System.out.println("3.- Mostrar mesas"); //mostrar
            System.out.println("4.- Mostrar disponibilidad de mesas"); //¿vacio?
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    Platos nuevo = new Platos();
                    System.out.println("\n\tAsignación de Mesa");
                    System.out.println("\tRegistro de platillos");
                    p.registroPlatos();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (opc != 20);

    }

}
