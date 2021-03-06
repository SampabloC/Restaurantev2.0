package u3_ed_proyecto;

import static u3_ed_proyecto.U3_ED_PROYECTO.leer;

/**
 *
 * @author Javier Ismael Sampablo Cuevas && David Oliver Cano Pizano
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

    void Insertar(mesa nuevo) {
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            if (nuevo.mesa < inicio.mesa) {
                nuevo.sigue = inicio;
                inicio.atras = nuevo;
                inicio = nuevo;
            } else {
                /*inicio.sigue = nuevo;
                nuevo.atras = inicio;
                fin = nuevo;*/
                if (nuevo.mesa > fin.mesa) {
                    fin.sigue = nuevo;
                    nuevo.atras = fin;
                    fin = nuevo;
                } else {
                    mesa aux = inicio.sigue;
                    while (aux != null) {
                        if (nuevo.mesa <= aux.mesa) {
                            nuevo.atras = aux;
                            nuevo.sigue = aux;
                            aux.atras = nuevo;
                            aux = null;
                        } else {
                            aux = aux.sigue;
                        }
                    }
                }
            }
        }
    }

    void Registro(int nummesa) {
        boolean libre = true, k = true;
        if (!this.Vacio()) {
            mesa aux = inicio;
            while (aux != null) {
                if (aux.mesa == nummesa) {
                    System.out.println("Mesa ocupada");
                    k = false;
                    libre = false;
                    aux = null;
                } else {
                    aux = aux.sigue;
                }
            }
        }
        if (libre == true) {
            mesa nuevo = new mesa();
            nuevo.mesa = nummesa;
            System.out.print("Teclea el nombre del mesero: ");
            nuevo.mesero = leer.nextLine();
            System.out.print("Teclea el Nombre del Cliente: ");
            nuevo.nombre = leer.nextLine().toLowerCase();
            nuevo.platos = null;
            this.Insertar(nuevo);
            System.out.println("¿Tomar pedido?[S/N]");
            String ch = leer.next().toUpperCase();
            if ("S".equals(ch) || "N".equals(ch)) {
                if ("S".equals(ch)) {
                    p.Registro(nummesa);
                } else {
                    System.out.println("Vuelva en unos min.");
                }
            } else {
                System.out.println("Selección invalida");
            }
        }
    }

    void Reordenar(int nummesa) {
        if (!this.Vacio()) {
            mesa aux2 = inicio;
            while (aux2 != null) {
                if (aux2.mesa == nummesa) {
                    p.Eliminar(nummesa);
                    if (aux2.sigue != null) {
                        aux2 = aux2.sigue;
                    } else {
                        aux2 = null;
                    }
                } else {
                    aux2 = aux2.sigue;
                }
            }
            mesa aux = inicio;
            while (aux != null) {
                if (aux.mesa == nummesa) {
                    p.Registro(nummesa);
                    aux = null;
                } else {
                    aux = aux.sigue;
                }
            }
        }
    }

    void Mostrar() {
        mesa aux = inicio;
        if (aux == null) {
            System.out.println("Mesas vacias");
        } else {
            //   System.out.println("Seleccione mesa a mostrar (1-5)");
            // int num = leer.nextInt();
            System.out.println("_____________________________________________________");
            System.out.println("Número de mesa\tMesero\tNombre");
            System.out.println("--------------------------------------------------------------------------");
            while (aux != null) {
                //    if (num == aux.mesa) {
                //   while (aux != null) {
                //System.out.println(aux.mesa + "\t" + aux.mesero + "\t" + aux.nombre);
                System.out.printf("%-51s%-23s%s\n", aux.mesa, aux.mesero, aux.nombre);
                //   aux = null;
                // }
                //  } else {
                aux = aux.sigue;
            }
            //   }
            System.out.println("¿Mostrar platillos?[S/N]");
            String ch = leer.next().toUpperCase();
            if ("S".equals(ch) || "N".equals(ch)) {
                if ("S".equals(ch)) {
                    //System.out.println("Cuenta");
                    int n=0;
                    do {
                        System.out.println("Número de mesa: ");
                        try {
                            n = leer.nextInt();
                            bol = true;
                            leer.nextLine();
                        } catch (java.util.InputMismatchException e) {
                            leer.nextLine();
                            System.out.println("No es un dato entero");
                            bol = false;
                        }
                    } while (bol == false);
                    // p.cuentaGeneral();
                    p.Mostrar(n);
                }
            } else {
                System.out.println("Selección invalida");
            }
        }
    }

    boolean Vacio() {
        return inicio == null;
    }

    void Eliminar() {
        String salida = "";
        int n = 0;
        boolean salio = false;
        if (!this.Vacio()) {
            System.out.print("Cliente a salir: ");
            salida = leer.next().toLowerCase();
            mesa aux2 = inicio;
            while (aux2 != null) {
                if (aux2.nombre.equals(salida)) {
                    n = aux2.mesa;
                    aux2 = null;
                } else {
                    aux2 = aux2.sigue;
                }
            }
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
            if (!salio) {
                System.out.println("No está el cliente registrado");
            } else {
                System.out.println("Sale el cliente " + salida);
                p.Cuenta1(n);
                p.Eliminar(n);
            }
        } else {
            System.out.println("Restaurante vacio");
        }
    }

}
