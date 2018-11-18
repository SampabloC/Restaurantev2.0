package u3_ed_proyecto;

import java.util.Locale;
import static u3_ed_proyecto.U3_ED_PROYECTO.leer;

/**
 *
 * @author Javier Ismael Sampablo Cuevas
 */
public class Mesa {

    Platos p = new Platos();
    Boolean bol = true;

    class mesa {

        mesa sigue;
        mesa atras;
        String mesero;
        double cuenta;
        String nombre;
        int mesa;
        mesa platos;
    }

    mesa sigue;
    mesa ant;
    mesa inicio;
    mesa fin;

    /* void Disponibilidad(int n) {
        mesa aux = inicio;
        boolean pasa = false;
        while (aux != null) {
            if (n == aux.mesa) {
                System.out.println("Mesa ocupada");
                aux = null;
                pasa = true;
            } else {
                aux = aux.sigue;
            }
        }
        if (pasa == false) {
            Registro(n);
        }
    }*/
    void Insertar(mesa nuevo) {
        mesa aux;
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            if (nuevo.mesa < inicio.mesa) {
                nuevo.sigue = inicio;
                inicio.atras = nuevo;
                inicio = nuevo;
            } else {
                inicio.sigue = nuevo;
                nuevo.atras = inicio;
                fin = nuevo;
            }
        }
    }

    void Registro(int nummesa) {
        // int nummesa = 0;
        mesa nuevo = new mesa();
        /*System.out.println("Teclea el número de mesa: ");
        do {
            try {
                nummesa = leer.nextInt();
                bol = true;
                leer.nextLine();
            } catch (java.util.InputMismatchException e) {
                leer.nextLine();
                System.out.println("No es un dato entero");
                bol = false;
            }
        } while (bol == false);
         */
        System.out.println(nummesa);
        nuevo.mesa = nummesa;
        System.out.println(nuevo.mesa);
        System.out.print("Teclea el nombre del mesero: ");
        nuevo.mesero = leer.nextLine();
        System.out.print("Teclea el Nombre del Cliente: ");
        nuevo.nombre = leer.nextLine().toLowerCase();
        this.Insertar(nuevo);
        System.out.println("¿Tomar pedido?[S/N]");
        String ch = leer.next().toUpperCase();
        if ("S".equals(ch) || "N".equals(ch)) {
            if ("S".equals(ch)) {
                p.Registro();
            } else {
                System.out.println("Vuelva en unos min.");
            }
        } else {
            System.out.println("Selección invalida");
        }
    }

    void Mostrar() {
        mesa aux = inicio;
        if (aux == null) {
            System.out.println("Mesas vacias");
        } else {
            System.out.println("Seleccione mesa a mostrar (1-5)");
            int num = leer.nextInt();
            System.out.println("Número de mesa\tMesero\tNombre");
            while (aux != null) {
                if (num == aux.mesa) {
                    while (aux != null) {
                        System.out.println(aux.mesa + " " + aux.mesero + " " + aux.nombre);
                        aux = null;
                    }
                    //       System.out.println(aux.mesa + " " + aux.mesero + " " + aux.nombre); 
                    //     aux = null;
                } else {
                    aux = aux.sigue;
                }
            }
            /*System.out.println("Número de mesa\tMesero\tNombre");
            while (aux != null) {
                System.out.println(aux.mesa + " " + aux.mesero + " " + aux.nombre);
                aux = aux.sigue;
            }
             */
            System.out.println("Cuenta");
            p.Cuenta();
            System.out.println("¿Mostrar Platos?[S/N]");
            String ch = leer.next().toUpperCase();
            if ("S".equals(ch) || "N".equals(ch)) {
                if ("S".equals(ch)) {
                    p.Mostrar();
                }
            } else {
                System.out.println("Selección invalida");
            }
        }
    }

    void Eliminar() {
        String salida;
        boolean salio = false;
        System.out.print("Cliente a salir: ");
        salida = leer.next().toLowerCase();
        if (salida.equals(inicio.nombre)) {
            if (inicio == fin) {
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.sigue;
                inicio.atras = null;
            }
            salio = true;
        } else {
            if (salida.equals(fin.nombre)) {
                fin = fin.atras;
                fin.sigue = null;
                salio = true;
            } else {
                mesa aux = inicio.sigue;
                while (aux != null) {
                    if (salida.equals(aux.nombre)) {
                        aux.atras.sigue = aux.sigue;
                        aux.sigue.atras = aux.atras;
                        salio = true;
                        aux = null;
                    } else {
                        aux = aux.sigue;
                    }
                }
            }
        }
        salida = salida.toUpperCase(Locale.ITALY);
        if (!salio) {
            System.out.println("No está el cliente registrado");
        } else {
            System.out.println("Sale el cliente " + salida);
            p.Cuenta();
        }
    }

}
