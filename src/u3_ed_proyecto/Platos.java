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
        int nummesa;
    }

    platos p = new platos();
    platos inicio;
    platos fin;

    void Registro(int nummesa) {
        int num = 0;
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
        this.Menu();
        System.out.println("Selección de platillos");
        for (int i = 1; i <= num; i++) {
            platos nuevo = new platos();
            nuevo.comensal = i;
            int plato=0;
            do {
                System.out.println("Comensal no. " + i + ".");
                try {
                    plato = leer.nextInt();
                    bol = true;
                    leer.nextLine();
                } catch (java.util.InputMismatchException e) {
                    leer.nextLine();
                    System.out.println("No es un dato entero");
                    bol = false;
                }
            } while (bol == false);
            
            nuevo.nummesa = nummesa;
            this.Platillo(plato, nuevo, nummesa);
            nuevo.sigue = null;
        }
    }

    void Insertar(platos nuevo) {
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.sigue = nuevo;
            fin = nuevo;
        }
    }

    void Mostrar(int nummesa) {
        platos aux = inicio;
        if (aux == null) {
            System.out.println("Mesas vacias");
        } else {
            System.out.println("\n_______________________________________");
            System.out.println("Comensal\tPlatillo\tCosto");
            System.out.println("-------------------------------------------------------");
            while (aux != null) {
                if (aux.nummesa == nummesa) {
                    System.out.printf("%-25s%-23s%s\n",aux.comensal,aux.platillo,aux.precio);
                    if (aux.sigue != null) {
                        aux = aux.sigue;
                    } else {
                        aux = null;
                    }
                } else {
                    aux = aux.sigue;
                }
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

    void Menu() {
        System.out.println("                Menú");
        System.out.println("Platillo\tPrecio");
        System.out.println("1. Pasta\t$85.50");
        System.out.println("2. Sopa    \t$42.00");
        System.out.println("3. Ensalada\t$62.90");
        System.out.println("4. Arroz\t$50.00");
        System.out.println("5. Pizza\t$99.99");
        System.out.println("6. Lasagna\t$62.50");
        System.out.println("\n\n(Todos los alimentos incluyen bebida)");
    }

    void Platillo(int n, Platos.platos nuevo, int nummesa) {
        switch (n) {
            case 1:
                nuevo.platillo = "Pasta";
                nuevo.precio = 85.50;
                break;
            case 2:
                nuevo.platillo = "Sopa";
                nuevo.precio = 42;
                break;
            case 3:
                nuevo.platillo = "Ensalada";
                nuevo.precio = 62.90;
                break;
            case 4:
                nuevo.platillo = "Arroz";
                nuevo.precio = 50;
                break;
            case 5:
                nuevo.platillo = "Pizza";
                nuevo.precio = 99.99;
                break;
            case 6:
                nuevo.platillo = "Lasagna";
                nuevo.precio = 62.50;
                break;
        }
        nuevo.nummesa = nummesa;
        this.Insertar(nuevo);
    }

    void Eliminar(int nummesa) {
        platos aux = inicio;
        platos atras = null;
        if (!this.Vacio()) {
            atras = inicio;
            aux = inicio.sigue;
            if (inicio == fin) {
                inicio = null;
                fin = null;
            }
            while (aux != null) {
                if (aux.nummesa == nummesa) {
                    atras.sigue = aux.sigue;
                    if (aux == fin) {
                        fin = atras;
                    }
                    if (aux.sigue != null) {
                        aux = aux.sigue;
                    } else {
                        aux = null;
                    }
                } else {
                    atras = aux;
                    aux = atras.sigue;
                }
            }
        } else {
            System.out.println("No hay platos");
        }
    }

    void cuentaGeneral() {
        int opc = 0;
        System.out.println("¿De qué mesa quiere la cuenta? (1-5)");
        do {
            try {
                opc = leer.nextInt();
            } catch (Exception e) {
                System.out.println("Dato Invalido");
            }
        } while (opc < 1 && opc > 5);
        System.out.println("Mostrar platillos");
        this.Cuenta1(opc);
    }

    void Cuenta1(int n) {
        platos aux = inicio;
        double cuenta = 0;
        while (aux != null) {
            if (aux.nummesa == n) {
                cuenta = cuenta + aux.precio;
                if (aux.sigue != null) {
                    aux = aux.sigue;
                } else {
                    aux = null;
                }
            } else {
                aux = aux.sigue;
            }
        }
        System.out.println("La cuenta de la mesa " + n + " es de $" + cuenta);
    }

    boolean Vacio() {
        return inicio == null;
    }
}
