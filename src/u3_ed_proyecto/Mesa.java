package u3_ed_proyecto;

/**
 *
 * @author Javier Ismael Sampablo Cuevas
 */
public class Mesa {

    mesa sigue;
    mesa ant;
    mesa inicio;
    mesa nuevo;
    mesa fin;

    class mesa {
        mesa sigue;
        mesa atras;
        String mesero;
        double cuenta;
        String nombre;
        int mesa;
        mesa platos;
    }

    void Insertar() {
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
}
