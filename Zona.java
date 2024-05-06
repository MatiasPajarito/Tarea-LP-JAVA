package Pikinim;

public class Zona {
    private boolean completado;
    
    public Zona(){ // Constructor 1 Zona
    }
    
    public Zona(boolean completado){ // Constructor 2 Zona
        this.completado = completado;
    }
    public boolean getCompletado(){ // Get Zona
        return completado;
    }
    public void setCompletado(boolean completado){ // Set Zona
        this.completado = completado;
    }

    /*
        # Metodo Interactuar de Zona
        En este metodo solo lo implementamos para el caso base que seria cuando la Zona
        este completada y no se pueda realizar nada mas en ese lugar.
    */
    public void interactuar(Cyan p1, Magenta p2, Amarillo p3){ // Metodo Interactuar de Zona
        if(completado == true){
            System.out.println("No se puede realizar nada mas en este lugar");
        }
    }
}
