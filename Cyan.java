package Pikinim;

public class Cyan extends Pikinim{

    public Cyan(int ataque, int capacidad, int cantidad){ // Constructor de Cyan
        super(ataque, capacidad, cantidad);
        super.setAtaque(1);
        super.setCapacidad(1);
    }

    /*
        # Metodo Multiplicar de Cyan:
        En este metodo lo que hacemos es aumentar la cantidad de tu peloton de Pikinim de 
        color Cyan, gracias a la formula especifica para este color, la cual es: cant = la 
        cantidad actual de Pikinim de color Cyan + 3 * una cantidad x que sera establecida
        dependiendo el caso. Con todo eso al final seteamos la nueva cantidad con esa formula.
    */
    public void multiplicar(int cantidad){ // Metodo Multiplicar de Cyan
        int cant = super.getCantidad();
        super.setCantidad(cant + cantidad * 3);
    }
}
