package Pikinim;

public class Muralla extends Zona{
    private int vida;

    public Muralla(int vida, boolean completado){ // Constructor de Muralla
        super(completado);
        this.vida = vida;
    }

    public int getVida(){ // Get Vida Muralla
        return vida;
    }

    public void setVida(int vida){ // Set Vida Muralla
        this.vida = vida;
    }

    /*
        # Metodo TryRomper la muralla:
        En este metodo intentamos romper la muralla para asi poder seguir avanzando por el tablero
        y esta vida que tiene la muralla se le resta con la suma de la cantidad * ataque de los 3
        colores de Pikinim. Si es que la vida de la muralla llega a 0 se marca la zona como completada,
        si es que la vida no llega  0 se debe seguir intentando romper hasta que sea 0.
    */
    public boolean tryRomper(Cyan p1, Magenta p2, Amarillo p3){ // Metodo TryRomper
        int suma_p1 = p1.getCantidad() * p1.getAtaque();
        int suma_p2 = p2.getCantidad() * p2.getAtaque();
        int suma_p3 = p3.getCantidad() * p3.getAtaque();
        this.vida -= suma_p1 + suma_p2 + suma_p3;
        if(vida < 0){
            System.out.println("Haz logrado romper la muralla, puedes seguir avanzando");
            System.out.println("");
            setCompletado(true);
        }
        else{
            System.out.println("No haz logrado romper la muralla, por ende no puedes avanzar");
            System.out.println("");
        }
        return true;
    }

    /*
        # Metodo Interactuar Con Muralla:
        Existe sobrecarga tambien en este metodo, al interactuar con la muralla, intentamos romper la 
        muralla siempre que la vida sea > 0.
    */
    public void interactuar(Cyan p1, Magenta p2, Amarillo p3) { // Metodo Interactuar con la muralla
        if(super.getCompletado() == true){
            super.interactuar(p1, p2, p3);
            return;
        }
        System.out.println("Guau haz encontrado una muralla en tu camino, para poder seguir avanzando debes quitarle vida - ");
        System.out.println("con tu peloton de Pikinim, te espera una lucha para poder tirar abajo esa muralla.");
        System.out.println("");
        System.out.println("La vida de la muralla es: " + getVida());
        System.out.println("");
        tryRomper(p1, p2, p3);
    }
}
