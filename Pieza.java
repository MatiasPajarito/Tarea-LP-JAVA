package Pikinim;

public class Pieza extends Zona implements ILevantable{
    private int peso;

    public Pieza(int peso,boolean completado){ // Constructor de Pieza
        super(completado);
        this.peso = peso;
    }

    public int getPeso(){ // Get Peso de pieza
        return peso;
    }

    public void setPeso(int peso){ // Set Peso de pieza
        this.peso = peso;
    }

    /*
        # Metodo Levantar Pieza que viene implementado desde ILevantable:
        Nos llevamos la pieza si es que la suma de la cantidad * capacidad de los 3 colores
        de Pikinim es >= al peso de la pieza. Si es que se cumple lo anterior marcamos como 
        completada y restamos 1 en la cantidad de piezas totales.
    */
    public void levantar(Cyan p1, Magenta p2, Amarillo p3){ // Metodo Levantar de la pieza
        int suma_p1 = p1.getCantidad() * p1.getCapacidad();
        int suma_p2 = p2.getCantidad() * p2.getCapacidad();
        int suma_p3 = p3.getCantidad() * p3.getCapacidad();
        if(suma_p1 + suma_p2 + suma_p3 >= peso){
            super.setCompletado(true);
            System.out.println("Se logro levantar la pieza y te la llevas para poder arreglar la nave");
        }
        else{
            System.out.println("No se puede levantar la pieza");
        }
    }

    /*
        # Metodo Interactuar con Pieza:
        En este metodo intentamos llevarnos la pieza para poder reparar la nave.
    */
    public void interactuar(Cyan p1, Magenta p2, Amarillo p3){ // Metodo intercatuar con la pieza
        if(super.getCompletado() == true){
            super.interactuar(p1, p2, p3);
            return;
        }
        System.out.println("Vaya haz encontrado una pieza faltante para la nave, si es que puedes levantarla con tu - ");
        System.out.println("peloton de Pikinim seria genial para que ayudemos al capitan con el arreglo de su nave.");
        System.out.println("");
        levantar(p1, p2, p3);
    }
}
