package Pikinim;

abstract public class Pikinim {
    private int ataque;
    private int capacidad;
    private int cantidad;

    /*
        # Metodo Dismiuir Cantidad Pikinim:
        En este metodo simplemente recude la cantidad tu peloton de pikinim por el parametro cantidad
        que este sera entregado dependiendo la situacion x.
    */
    public void disminuir(int cantidad){ // Metodo Disminuir cantidad de los Pikinim
        this.cantidad -= cantidad;
    }
    /* 
        # Metodo Abstracto Multiplicar:
        Este metodo al ser abstracto debe implementarse en las clases hijas de esta.
    */
    abstract public void multiplicar(int cantidad); // Metodo Abstracto Multiplicar

    public Pikinim(int ataque, int capacidad, int cantidad) { // Constructor de Pikinim
        this.ataque = ataque;
        this.capacidad = capacidad;
        this.cantidad = cantidad;
    }

    public int getAtaque() { // Get Ataque Pikinim
        return ataque;
    }

    public void setAtaque(int ataque) { // Set Ataque Pikinim
        this.ataque = ataque;
    }

    public int getCapacidad() { // Get Capacidad Pikinim
        return capacidad;
    }

    public void setCapacidad(int capacidad) { // Set Capacidad Pikinim
        this.capacidad = capacidad;
    }

    public int getCantidad() { // Get Cantidad Pikinim
        if (cantidad < 0){
            cantidad = 0;
        }
        return cantidad;
    }

    public void setCantidad(int cantidad) { // Set Cantidad Pikinim
        this.cantidad = cantidad;
    }
}
