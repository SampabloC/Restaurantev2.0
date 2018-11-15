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
    Cuenta c = new Cuenta();

    static class mesa {
        mesa sigue;
        String mesero;
        double cuenta;
        String nombre;
        int mesa;
        
    }

    void Insertar() {
        mesa aux;
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            if (nuevo.mesa < inicio.mesa) {
                nuevo.sigue = inicio;
            }
        }
    }
}
