package u3_ed_proyecto;

import static u3_ed_proyecto.U3_ED_PROYECTO.leer;

/**
 *
 * @author Javier Ismael Sampablo Cuevas && David Oliver Cano 
 */
public class Platos {

    boolean bol = true;

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
        int op = 0;
        do {
            System.out.println("Menú para los platillos");
            System.out.println("1.- Alta de platos");
            System.out.println("2.- Mostrar ordenes y costos"); //mostrar platos
            do {
                System.out.println("////Elección////");
                try {
                    op = leer.nextInt();
                    bol = true;
                    leer.nextLine();
                } catch (java.util.InputMismatchException e) {
                    leer.nextLine();
                    System.out.println("No es un dato entero");
                    bol = false;
                }
            } while (bol == true);

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
        int num = 0;
//        platos nuevo = new platos();
        System.out.println(" Cuenta ");
        System.out.print("Número de comensales: ");
        do {
            try {
                num = leer.nextInt();
                bol = true;
                leer.nextLine();
            } catch (java.util.InputMismatchException e) {
                leer.nextLine();
                System.out.println("No es un dato entero");
                bol = false;
            }

        } while (bol == false);
        for (int i = 1; i <= num; i++) {
            platos nuevo = new platos();
            nuevo.comensal = i;
            System.out.println("Registre plato del comensal no. " + i);
            nuevo.platillo = leer.next();
            System.out.print("Precio del platillo: ");
            do {
                try {
                    nuevo.precio = leer.nextDouble();
                    bol = true;
                    leer.nextLine();
                } catch (java.util.InputMismatchException e) {
                    leer.nextLine();
                    System.out.println("No es un dato entero");
                    bol = false;
                }

            } while (bol == false);
            nuevo.sigue = null;
            Insertar(nuevo);
        }
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
        /*                              //sacar la cuenta de una sola mesa
        if (aux == null) {
            System.out.println("Mesas vacias");
        } else {
            System.out.println("Seleccione mesa a sacar cuenta (1-5)");
            int num = leer.nextInt();
            while (aux != null) {
                if (num == aux.mesa) {
                    while (aux != null) {
            cuenta = cuenta + aux.precio;        
                        aux = null;
                    }
                    //       System.out.println(aux.mesa + " " + aux.mesero + " " + aux.nombre); 
                    //     aux = null;
                } else {
                    aux = aux.sigue;
                }
            }
        */
       while (aux != null) {
            cuenta = cuenta + aux.precio;
            aux = aux.sigue;
        }
        System.out.println("La cuenta es de $" + cuenta + " pesos.");
    }
}
