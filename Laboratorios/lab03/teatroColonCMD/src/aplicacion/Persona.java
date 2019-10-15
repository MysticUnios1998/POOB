package aplicacion;
import java.awt.Color;

public class Persona {

    //Posiciones
    public final static int ARRIBA=0;
    public final static int FRENTE=1;
    public final static int ABAJO=2;
    
    //Dimension pasos
    private final static int PASO=20;

    private String nombre;  
    private int brazoIzq;
    private int brazoDer;
    private int piernaIzq;
    private int piernaDer;
    protected Color color;

    private int posicionx,posiciony;

    /**Crea un nuevo persona en la posicion <i>(posicionx, posiciony)</i> 
    @param nombre nombre de la persona
    @param posicionx coordenada x de la posicion 
    @param posiciony coordenada y de la posicion
    */
    public Persona(String nombre, int posicionx, int posiciony){
        this.posicionx=posicionx;
        this.posiciony=posiciony;
        this.nombre=nombre;
        brazoIzq=ABAJO;
        brazoDer=ABAJO;
        piernaIzq=ABAJO;
        piernaDer=ABAJO;
        color=Color.BLACK;
    }

    /**Retorna el color del vestido*/
    public Color getColor(){
        return color;
    }
    
    /**Cambia el color del vestido. Puede ser rojo, azul, naranja, amarillo, verde*/
    public void setColor(String color){
        if(color.equals("rojo")) this.color=Color.RED;
        else if(color.equals("azul")) this.color=Color.BLUE; 
        else if(color.equals("naranja")) this.color=Color.ORANGE; 
        else if(color.equals("amarillo")) this.color=Color.YELLOW; 
        else if(color.equals("verde")) this.color=Color.GREEN; 
        else this.color=Color.BLACK;
    }


    /**Mueve un brazo segun las indicaciones
    @param c el brazo a mover: I(zquierdo) o D(erecho)
    @param d el modo de moverlo: S(ubir) o B(ajar)
    */
    public final void muevaBrazo(char c,char d){
        if ((c=='I') && (d=='S') && ((brazoIzq-1)>=0)) {
             brazoIzq-=1;
        } else if ( (c=='I') && (d=='B') && ((brazoIzq+1)<3)){
            brazoIzq+=1;
        } else if ((c=='D') && (d=='S') && ((brazoDer-1)>=0)){
            brazoDer-=1;
        }  else if ((c=='D') && (d=='B') && ((brazoDer+1)<3)){
            brazoDer+=1;
        }
    }

    /**Mueve una pierna segun las indicaciones
    @param c la pierna a mover: I(zquierdo) o D(erecho)
    @param d el modo de moverlo: S(ubir), B(ajar), P(iso)
    */
    public final void muevaPierna(char c,char d){
        if ((c=='I') && (d=='S') && ((piernaIzq-1)>=0)){
             piernaIzq-=1;
        } else if ((c=='I') && (d=='B') && ((piernaIzq+1)<3)){
            piernaIzq+=1;
        } else if ((c=='D') && (d=='S') && ((piernaDer-1)>=0)){
            piernaDer-=1;
        }  else if ((c=='D') && (d=='B') && ((piernaDer+1)<3)){
            piernaDer+=1;
        } else if ((c=='D') && (d=='P')){
            piernaDer=ABAJO;
        } else if ((c=='I') && (d=='P')){
            piernaIzq=ABAJO;
        }
    }

    /**Retorna la posicion de un brazo
    @param c el brazo de interes: I(zquierdo) o D(erecho)
    @return la posicion del brazo indicada
    */
    public final int getPosicionBrazo(char c){
        return (c=='I'? brazoIzq: brazoDer);
    }

    /**Retorna la posicion de una pierna
    @param c la pierna de interes: I(zquierda) o D(erecha)
    @return la posicion de la pierna indicada
    */
    public final int getPosicionPierna(char c){
        return (c=='I'? piernaIzq: piernaDer);
    }
    
    /**Se mueve en la direccion indicada
    @param c indica la direccion. N(orte), S(ur), E(ste), O(este)
    */
    public void muevase(char c){
        if (c=='E') {
            posicionx=getPosicionX()+PASO;
        } else if (c=='O'){
           posicionx=getPosicionX()-PASO;   
        } else if (c=='N'){
            posiciony=getPosicionY()-PASO;
        } else if (c=='S'){
            posiciony=getPosicionY()+PASO;
        }
    }

    /**Retorna la coordenada x de la posicion*/
    public final int getPosicionX(){
        return posicionx;
    }

    /**Retorna la coordenada y de la posicion*/
    public final int getPosicionY(){
        return posiciony;
    }
    
    /**
     * Retorna el nombre de la persona
     * @return Cadena con la información requerida
     */
    public String toString(){
        return nombre;
    }

}

