package Pikinim;

import java.util.Random;
import java.util.Scanner;
public class Enemigo extends Zona implements ILevantable{
    private int vida_ene;
    private int peso_ene;
    private int ataq_ene;

    Enemigo(int vida_ene, int peso_ene, int ataq_ene,boolean completado){ // Constructor de Enemigo
        super(completado);
        this.vida_ene = vida_ene;
        this.peso_ene = peso_ene;
        this.ataq_ene = ataq_ene;
    }

    public int getVida_ene() { // Get vida enemigo
        return vida_ene;
    }

    public void setVida_ene(int vida_ene) { // Set vida enemigo
        this.vida_ene = vida_ene;
    }

    public int getPeso_ene(){ // Get peso enemigo
        return peso_ene;
    }

    public void setPeso_ene(int peso_ene) { // Set peso enemigo
        this.peso_ene = peso_ene;
    }
    public int getAtaq_ene(){ // Get ataque enemigo
        return ataq_ene;
    }

    public void setAtaq_ene(int ataq_ene) { // Set ataque enemigo
        this.ataq_ene = ataq_ene;
    }

    /*
        # Metodo Levantar que viene implementado desde ILevantable:
        En este metodo debemos intentar levantar al enemigo si es que la suma de cantidad * capacidad
        de los 3 colores es mayor o igual al peso del enemigo, si es asi debe multiplicar 1 color de 
        Pikinm por el peso del enemigo, el jugador escoje que color quiere multiplicar.
    */
    public void levantar(Cyan p1, Magenta p2, Amarillo p3){ // Metodo Levantar enemigo. Debe faltar algo
        int suma_p1 = p1.getCantidad() * p1.getCapacidad();
        int suma_p2 = p2.getCantidad() * p2.getCapacidad();
        int suma_p3 = p3.getCantidad() * p3.getCapacidad();
        int suma_maxima = suma_p1 + suma_p2 + suma_p3;
        if(suma_maxima >= peso_ene){
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            if(opcion == 1){
                p1.multiplicar(peso_ene);
            }
            if(opcion == 2){
                p2.multiplicar(peso_ene);
            }
            if(opcion == 3){
                p3.multiplicar(peso_ene);
            }
        }
    }

    /*
        # Metodo Pelear contra los Pikinim
        Este metodo resta la vida del Deborador de Pik en la suma de la cantidad * ataque de los 3 colores,
        el enemigo siempre ataca a un color de Pikinim al azar, se le resta a la cantidad el ataque del enemigo.
        Si es que la vida del Deborador de Pik no es 0 la pelea debe continuar hasta que este sea 0.
    */
    public boolean pelear(Cyan p1, Magenta p2, Amarillo p3){ // Metodo Pelear contra el enemigo
        int suma_p1 = p1.getCantidad() * p1.getAtaque();
        int suma_p2 = p2.getCantidad() * p2.getAtaque();
        int suma_p3 = p3.getCantidad() * p3.getAtaque();
        this.vida_ene -= suma_p1 + suma_p2 + suma_p3;
        Random random = new Random();
        int numeroAleatorio = random.nextInt(3) + 1;
        if(numeroAleatorio == 1){
            p1.setCantidad(p1.getCantidad() - ataq_ene);
        }
        if(numeroAleatorio == 2){
            p2.setCantidad(p2.getCantidad() - ataq_ene);
        }
        if(numeroAleatorio == 3){
            p3.setCantidad(p3.getCantidad() - ataq_ene);
        }
        return true;
    }

    /*
        # Metodo Interactuar de Enemigo
        En este metodo existe una sobrecarga ya que usa el mismo nombre que su clase padre Zona.
        al interactuar con esta zona se debe realizar una pelea contra tu peloton de Pikinim, si es que 
        la vida del Deborardor de Pik llega a 0, lo intentamos levantar al instante, y marcamos la zona
        como completado para que asi no se vuelva a realizar la accion nuevamente.
    */
    public void interactuar(Cyan p1, Magenta p2, Amarillo p3){ // Metodo interactuar con el enemigo
        if(super.getCompletado() == true){
            super.interactuar(p1, p2, p3);
            return;
        }
        System.out.println("Vaya! acaba de aparecer un Deborador de los Pik salvaje. Este al verte no pudo - ");
        System.out.println("contener las ganas de tener un enfrentamiento contra tus Pikinim aliados.");
        System.out.println("");
        System.out.println("Datos del Deborador de los Pik: ");
        System.out.println("");
        System.out.println("(Ataque: " + getAtaq_ene() + " | Vida: " + getVida_ene() + " | Peso: " + getPeso_ene()+")");
        pelear(p1, p2, p3);
        if(vida_ene < 0){
            System.out.println("");
            System.out.println("Haz logrado derrotar al Deborador de Pik, al momento de derrotarlo intentas - ");
            System.out.println("leventar inmediatamente para que asi pueda aumentar un poco tu peloton de Pikinim.");
            System.out.println("");
            System.out.println("1. Cyan - 2. Magenta - 3. Amarillo");
            System.out.println("");
            levantar(p1, p2, p3);
            super.setCompletado(true);
            System.out.println("");
        }
    }
}