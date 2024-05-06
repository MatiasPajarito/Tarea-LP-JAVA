package Pikinim;

public class Magenta extends Pikinim{
    
    public Magenta(int ataque, int capacidad, int cantidad){ // Constructor de Magenta
        super(ataque, capacidad, cantidad);
        super.setAtaque(2);
        super.setCapacidad(1);
    }

    /*
        # Metodo Multiplicar de Magenta:
        En este metodo lo que realizamos es aumentar la cantidad de tu peloton de color
        Magenta, gracias a la formula especual para este color, la cual es: cant = la
        cantidad actual del color Magenta + ataque de Magenta * una cantidad que sera
        un valor pasado por parametro como sale en el metodo. Con todo eso al final 
        seteamos la nueva cantidad con esa formula.
    */
    public void multiplicar(int cantidad){ // Metodo Multiplicar de Magenta
        int cant = super.getCantidad();
        super.setCantidad(cant + cantidad * super.getAtaque());
    }
}
