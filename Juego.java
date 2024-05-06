package Pikinim;

import java.util.Scanner;
public class Juego{
    static int cont_pieza = 3;
    public static void main(String[] args){
        int pos_actual = 5;
        Zona[] zonas = new Zona[11];
        zonas[0] = new Pieza(50,false);
        zonas[1] = new Enemigo(130,20,25,false);
        zonas[2] = new Enemigo(50,10,15,false);
        zonas[3] = new Pildora(25,false);
        zonas[4] = new Muralla(50,false);
        zonas[5] = new Pieza(100,false);
        zonas[6] = new Enemigo(45, 8, 10, false);
        zonas[7] = new Pieza(35,false);
        zonas[8] = new Pildora(15, false);
        zonas[9] = new Enemigo(75,15,20,false);
        zonas[10] = new Muralla(150,false);
        Cyan p1 = new Cyan(1,1,10);
        Magenta p2 = new Magenta(2, 1, 10);
        Amarillo p3 = new Amarillo(1, 3, 10);
        System.out.println("!Bienvenido a la Exploracion Compañer@¡");
        System.out.println("Gracias por ayudarme con la busqueda de las piezas de mi nave - ");
        System.out.println("esta no es una tarea sencilla pero todos juntos vamos a poder - ");
        System.out.println("lograr todo lo que nos depare. !Lets Go¡");
        System.out.println("");
        for(int turnos = 0; turnos < 30; turnos++){
            System.out.println("==========================================================================================");
            System.out.println("[Turno " + (turnos+1) + "] Tu peloton de Pikinim son: " + "(Cyan - " + p1.getCantidad() + " | Magenta - " + p2.getCantidad() + " | Amarillo - " + p3.getCantidad() + ")");
            System.out.println("");
            String pos = zonas[pos_actual].getClass().getCanonicalName();
            pos = pos.replaceAll("Pikinim."," ");
            String pos_sig;
            if(pos_actual + 1 > 10) {
                pos_sig = zonas[0].getClass().getCanonicalName();
            } 
            else {
                pos_sig = zonas[pos_actual+1].getClass().getCanonicalName();
            }
            pos_sig = pos_sig.replaceAll("Pikinim."," ");
            String pos_ant;
            if(pos_actual - 1 < 0){
                pos_ant = zonas[10].getClass().getCanonicalName();
            }
            else{
                pos_ant = zonas[pos_actual-1].getClass().getCanonicalName();
            }
            pos_ant = pos_ant.replaceAll("Pikinim."," ");
            System.out.println("¿Que accion haras para ayudar al capitan?");
            System.out.println("");
            System.out.println("1. Mov. Izquierda (<----) en este lugar hay "+ " [" + pos_ant + " ]");
            System.out.println("2. Mov. Derecha (---->) en este lugar hay " + " [" + pos_sig + " ]");
            System.out.println("3. Quedarse en el lugar (====) en este lugar hay " + " [" + pos + " ]");
            System.out.println("");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            if(opcion == 1){
                System.out.println("");
                System.out.println("Te moviste a la Izquieda (<----)");
                System.out.println("");
                pos_actual = pos_actual - 1;
                if(pos_actual < 0){
                    System.out.println("Llegaste al principio por ende te devuelves al final para seguir con la investigacion");
                    System.out.println("");
                    pos_actual = 10;
                }
            }
            if(opcion == 2){
                System.out.println("");
                System.out.println("Te moviste a la Derecha (---->)");
                System.out.println("");
                pos_actual = pos_actual + 1;
                if(pos_actual > 10){
                    System.out.println("Llegaste al final por ende te devuelves al principio para seguir con la investigacion");
                    System.out.println("");
                    pos_actual = 0;
                }
            }
            if(opcion == 3){
                System.out.println("");
                System.out.println("Te quedaste en el mismo sitio (====)");
                System.out.println("");
            }
            if(zonas[pos_actual].getCompletado()){
                zonas[pos_actual].interactuar(p1, p2, p3);
            }
            else{
                zonas[pos_actual].interactuar(p1, p2, p3);
                if(zonas[pos_actual].getCompletado()==true && zonas[pos_actual] instanceof Pieza){
                cont_pieza --;
                System.out.println("Increible ahora solo nos quedan "+ cont_pieza + " piezas por encontrar.");
                System.out.println("");
                    if(cont_pieza == 0){
                        System.out.println("!Felicidades¡ Muchas gracias a ti y a los Pikinim por su ayuda en esta aventura, - ");
                        System.out.println("si no hubiera sido por ti, quizas nunca habria logrado encontrar las piezas restantes - ");
                        System.out.println("de mi nave. Ahora el capitan podra reparar su nave y asi el podra seguir viajando - ");
                        System.out.println("por muchos lugares nuevos. Muchas gracias, pronto nos volveremos hasta luegooooo.");
                        System.out.println("");
                        turnos = 30;
                    }
                }
            }
        }
    }
}  
