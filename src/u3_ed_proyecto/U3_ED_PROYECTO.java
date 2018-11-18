package u3_ed_proyecto;

import java.util.Scanner;

/**
 *
 * @author Javier Ismael Sampablo Cuevas && David Oliver Cano Pizano
 */
public class U3_ED_PROYECTO {

    static Boolean bol = true;

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        Platos p = new Platos();
        Mesa m = new Mesa();
        int opc = 0;
        do {
            System.out.println("~~~~~~~~~~Restaurante~~~~~~~~~~~~~~\n");
            System.out.println("1.- Registro de clientes."); //altas
            System.out.println("2.- Mostrar mesas."); //mostrar
            System.out.println("3.- Salida de clientes."); //bajas
            System.out.println("4.- Salida del menú.");
            do {
                System.out.print("Opción: ");
                try {
                    opc = leer.nextInt();
                    bol = true;
                    leer.nextLine();
                } catch (java.util.InputMismatchException e) {
                    leer.nextLine();
                    System.out.println("No es un dato entero");
                    bol = false;
                }
            } while (bol == false);

            switch (opc) {
                case 1:
                    int nummes = 0;
                    System.out.println("\n\tAsignación de Mesa");
                    System.out.println("Seleccione una mesa (1-5)");
                    do {
                        try {
                            nummes = leer.nextInt();
                            leer.nextLine();
                        } catch (java.util.InputMismatchException e) {
                            leer.nextLine();
                            System.out.println("No es valido el dato");
                        }
                    } while (nummes < 1 && nummes > 5);
                    m.Registro(nummes);
                    break;
                case 2:
                    m.Mostrar();
                    break;
                case 3:
                    System.out.println("Salida de clientes");
                    m.Eliminar();
                    break;
            }
        } while (opc != 4);

    }

}
