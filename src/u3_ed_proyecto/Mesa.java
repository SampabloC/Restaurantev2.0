package u3_ed_proyecto;

import static u3_ed_proyecto.U3_ED_PROYECTO.leer;

/**
 *
 * @author Javier Ismael Sampablo Cuevas
 */
public class Mesa {

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

   

    void Datos() {

    }

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
            }
        }
    }

    void Registro() {
        int nummes = 0;
        mesa nuevo = new mesa();
        System.out.println("Teclea el número de mesa: ");
        do {
            try {
                nummes = leer.nextInt();
                bol = true;
                leer.nextLine();
            } catch (java.util.InputMismatchException e) {
                leer.nextLine();
                System.out.println("No es un dato entero");
                bol = false;
            }
        } while (bol == false);
        nuevo.mesa=nummes;
        System.out.print("Teclea el nombre del mesero: ");
        nuevo.mesero= leer.nextLine();
        System.out.print("Teclea el Nombre del Cliente: ");
        nuevo.nombre=leer.nextLine();
    }
        void Mostrar() {
        mesa aux = inicio;
        if (aux == null) {
            System.out.println("Mesas vacias");
        } else {
            System.out.println("Número de mesa\tMesero\tNombre");
            while (aux != null) {
                System.out.println(aux.mesa + " " + aux.mesero + " " + aux.nombre);
                aux = aux.sigue;
            }
        }
    }

}
