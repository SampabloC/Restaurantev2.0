package u3_ed_proyecto;

import static u3_ed_proyecto.U3_ED_PROYECTO.leer;

/**
 *
 * @author Javier Ismael Sampablo Cuevas
 */
public class Platos {

    platos p = new platos();
    platos inicio;
    platos fin;

    class platos {

        int comensal;
        platos sigue;
        double precio;
        String platillo;
    }

    void registroPlatos() {
        platos nuevo = new platos();
        System.out.println(" Cuenta ");
        System.out.print("Registre número de comensal: ");
        nuevo.comensal = leer.nextInt();
        System.out.println("Registre plato del comensal no. " + nuevo.comensal);
        nuevo.platillo = leer.next();
        System.out.print("Precio del platillo: ");
        nuevo.precio = leer.nextDouble();
        nuevo.sigue = null;
        Insertar(nuevo);
    }

    void Insertar(platos nuevo) {
        System.out.println(nuevo);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            if (nuevo.comensal == nuevo.comensal) {
                System.out.println("Ya se registro el comensal");
            } else {
                fin.sigue = nuevo;
            }
        }
    }

    void Mostrar() {
        platos aux = inicio;
        if (aux == null) {
            System.out.println("Mesas vacias");
        } else {
            System.out.println("Comensal\tPlatillo\tCosto");
            while (aux != null) {
                System.out.println(p.comensal + " " + p.platillo + " " + p.precio);
                aux = aux.sigue;
            }
        }
    }
}
