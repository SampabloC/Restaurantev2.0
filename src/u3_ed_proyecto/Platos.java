package u3_ed_proyecto;

import static u3_ed_proyecto.U3_ED_PROYECTO.leer;

/**
 *
 * @author Javier Ismael Sampablo Cuevas
 */
public class Platos {

    class platos {

        int comensal;
        platos sigue;
        double precio;
        String platillo;
    }

    platos p = new platos();
    platos inicio;
    platos fin;

    void registroPlatos() {
        int op;
        do {
            System.out.println("Menú para los platillos");
            System.out.println("1.- Alta de platos");
            System.out.println("2.- Mostrar ordenes y costos"); //mostrar platos
            op = leer.nextInt();
            switch (op) {
                case 1:
                    this.Registro();
                    break;
                case 2:
                    this.Mostrar();
                    this.Cuenta();
                    break;
            }
        } while (op != 3);
    }

    void Registro() {
//        platos nuevo = new platos();
        System.out.println(" Cuenta ");
        System.out.print("Número de comensales: ");
        int num = leer.nextInt();
        for (int i = 1; i <= num; i++) {
            platos nuevo = new platos();
//            System.out.print("Registre número de comensal: ");
        nuevo.comensal = i;
        System.out.println("Registre plato del comensal no. " + i);
        nuevo.platillo = leer.next();
        System.out.print("Precio del platillo: ");
        nuevo.precio = leer.nextDouble();
        nuevo.sigue = null;
        Insertar(nuevo);
        }
        /*System.out.print("Registre número de comensal: ");
        nuevo.comensal = leer.nextInt();
        System.out.println("Registre plato del comensal no. " + nuevo.comensal);
        nuevo.platillo = leer.next();
        System.out.print("Precio del platillo: ");
        nuevo.precio = leer.nextDouble();
        nuevo.sigue = null;
        Insertar(nuevo);*/
    }

    void Insertar(platos nuevo) {
        System.out.println(nuevo);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.sigue = nuevo;
            fin = nuevo;
        }
    }

    void Mostrar() {
        platos aux = inicio;
        if (aux == null) {
            System.out.println("Mesas vacias");
        } else {
            System.out.println("Comensal\tPlatillo\tCosto");
            while (aux != null) {
                System.out.println(aux.comensal + " " + aux.platillo + " " + aux.precio);
                aux = aux.sigue;
            }
        }
    }

    void Cuenta() {
        platos aux = inicio;
        double cuenta = 0;
        while (aux != null) {
            cuenta = cuenta + aux.precio;
            aux = aux.sigue;
        }
        System.out.println("La cuenta es de $" + cuenta + " pesos.");
    }
}
