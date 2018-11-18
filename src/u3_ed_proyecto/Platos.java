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

    /*void registroPlatos() {
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
    }*/
    void Registro(int nummesa) {
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
        this.Menu();
        for (int i = 1; i <= num; i++) {
            platos nuevo = new platos();
            nuevo.comensal = i;
            System.out.println("Registre plato del comensal no. " + i + " (Seleccione el número del menú).");
            int plato = leer.nextInt();
            nuevo.nummesa = nummesa;
            this.Platillo(plato, nuevo, nummesa);
            /* System.out.print("Precio del platillo: ");
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
             */
            nuevo.sigue = null;
            //  Insertar(nuevo);
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

    void Eliminar() {
        /*
        platos aux = null;
        platos ant = null;
          int num = leer.nextInt();
          if(eliminar < inicio || eliminar > fin.edad) {
            System.out.println("El dato no existe");
          }else {
            if(num == inicio.edad) {
              if(inicio == fin) { //validar si hay un solo nodo
                inicio = null;
                fin == null;
              }else {
                inicio = incio.sigue;
              }
            }else {
              atras = inicio;
              aux = inicio.sigue;
              while(aux != null) {
                if(eliminar == aux.edad) {
                  atras.sigue = aux.sigue;
                  i
                  f(aux == fin) {
                    fin = atras;
                  }
                  System.out.println("El\b" + elminar + "\bfue eliminado");
                  aux = null;
                }else {
                  if(aux.edad > eliminar) {
                    System.out.println("El dato no existe");
                    aux = null;
                  }else {  
                    atras = aux;  // avanza de nodos para seguir buscando
                    aux = atras.sigue;
                  }
                }
              }//while
            }//else
          }//else
        }//void
         */
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
}
