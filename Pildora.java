package Pikinim;

import java.util.Scanner;

public class Pildora extends Zona{
    private int canti;

    public Pildora(int canti, boolean completado){ // Constructor de Pildora
        super(completado);
        this.canti = canti;
    }
    public int getCanti(){ // Get Cantidad para multiplicar
        return canti;
    }

    public void setCanti(int canti){ // Set Cantidad para multiplicar
        this.canti = canti;
    }

    /*
        # Metodo Interactuar con Pildora:
        En este metodo lo que realiza es una mejora a tu peloton de Pikinim, este aumenta la cantidad
        de un color en especifico que nosotros debemos indicarle, dependiendo la opcion que escojamos
        se multiplica uno u otro y cada uno con su respectiva formula de multiplicacion.
        Una vez que se haya aumentado la cantidad de un color de Pikinim, marcamos la zona como
        completada.
    */
    public void interactuar(Cyan p1, Magenta p2, Amarillo p3){ // Metodo Interactuar
        if(super.getCompletado() == true){
            super.interactuar(p1, p2, p3);
            return;
        }
        System.out.println("Guau parece que encontraste una pildora. Esta tiene efecto especiales en los Pikinim - ");
        System.out.println("¿A que color de tu peloton quieres darle esta super pildora?");
        System.out.println("");
        System.out.println("Escoja un color de Pikinim: ");
        System.out.println("");
        System.out.println("1. Cyan - 2. Magenta - 3. Amarillo");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        if(opcion == 1){
            p1.multiplicar(canti);
            System.out.println("Tu peloton de pikimin se agrando y ahora son: "+ p1.getCantidad());
            System.out.println("");
            super.setCompletado(true);
        }
        if(opcion == 2){
            p2.multiplicar(canti);
            System.out.println("Tu peloton de pikimin se agrando y ahora son: "+ p2.getCantidad());
            System.out.println("");
            super.setCompletado(true);
        }
        if(opcion == 3){
            p3.multiplicar(canti);
            System.out.println("Tu peloton de pikimin se agrando y ahora son: "+ p3.getCantidad());
            System.out.println("");
            super.setCompletado(true);
        }
    }
}
