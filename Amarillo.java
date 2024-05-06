package Pikinim;

public class Amarillo extends Pikinim{

    public Amarillo(int ataque, int capacidad, int cantidad){ // Constructor de Amarillo
        super(ataque, capacidad, cantidad);
        super.setAtaque(1);
        super.setCapacidad(3);
    }

    /*
        # Metodo Multiplicar de Amarillo
        En este metodo lo que hacemos es aumentar la cantidad de tu peloton de Pikinim de 
        color Cyan, gracias a la formula especifica para este color, la cual es: cant = la 
        cantidad actual de Pikinim de color Cyan + Math.ceil es una funcion la cual redondea
        para arriba en caso de quedar un decimal, dentro de esa funcion esta cantidad que es
        un parametro * 1,5. Con todo eso al final seteamos la nueva cantidad con esa formula.
    */
    public void multiplicar(int cantidad){ // Metodo Multiplicar de Amarillo
        int cant = super.getCantidad();
        super.setCantidad(cant + (int) Math.ceil(cantidad * 1.5));
    }
}
