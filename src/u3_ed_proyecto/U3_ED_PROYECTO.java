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
            System.out.println("4.- Reorden de platos");
            System.out.println("5.- Salida del menú.");
            System.out.printf("%12s%12s\n", "texto","texto2");
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
                    boolean pasa = true;
                    System.out.println("\n\tAsignación de Mesa");
                    do {
                    System.out.println("Seleccione una mesa (1-5)");
                        try {
                            nummes = leer.nextInt();
                            leer.nextLine();
                        } catch (java.util.InputMismatchException e) {
                            leer.nextLine();
                            System.out.println("No es valido el dato");
                            pasa = false;
                        }
                    } while (nummes < 1 || nummes > 5);
                    if (pasa == true) {
                        m.Registro(nummes);
                    }
                    break;
                case 2:
                    m.Mostrar();
                    break;
                case 3:
                    System.out.println("Salida de clientes");
                    m.Eliminar();
                    break;
                case 4:
                    int nummesa = 0;
                    System.out.println("\nReorden de platillos.");
                    System.out.println("Selecciones la mesa (1-5)");
                    do {
                        try{
                            nummesa = leer.nextInt();
                        }catch(Exception e) {
                            System.out.println("Dato invalido");
                        }
                    } while (nummesa <1 && nummesa >5);
                    m.Reordenar(nummesa);
                    break;
            }
        } while (opc != 5);

    }

}
