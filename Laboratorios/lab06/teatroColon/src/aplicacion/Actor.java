package aplicacion;


/**
 * Clase actor que mueve un elemento Persona en el escenario.
 * @author Eduard Arias, ECI 2019-2
 * @version 2.0
 */
public class Actor extends Persona implements EnEscena{    

    protected String palabras;
    
    
    /**
     * Constructor principal de la clase Actor
     * @param teatro lugar en donde se dibujará el objeto
     * @param name nombre del actor
     * @param posicionx posicion en el eje horizontal del elemento
     * @param posiciony posicion en el eje vertical del elemento
     */
    public Actor(Teatro teatro,String name,int posicionx, int posiciony){
        super(name,posicionx,posiciony);
        palabras="Â¡Hola!";
    }


    private boolean puedeMover(char direccion) {
        boolean puede=false;
        int posX = getPosicionX();
        int posY = getPosicionY();
        switch(direccion){
            case 'N' : puede = (posY+1 < Teatro.MAXIMO);
            break;
            case 'E' : puede = (posX+1 < Teatro.MAXIMO);
            break;
            case 'S' :  puede = (posY-1 >= 0);
            break;
            case 'O':puede = (posX-1 >= 0);
            break; 
        } 
        return puede;
    }
    
    
    /**
     * Detiene el movimiento del actor. regresa a su posición inicial en las coordenadas en donde está.
     */
    public void corte(){
        muevaBrazo('I','B'); 
        muevaPierna('I','P');
        muevaBrazo('D','B'); 
        muevaPierna('D','P');       
        palabras="";
    }
    
    
    /**
     * Mueve al actor.
     */
    public void actue(){             
        if (getPosicionBrazo('I')==ABAJO && getPosicionBrazo('D')==ABAJO){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } else if  (getPosicionBrazo('I')==FRENTE){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } else if (getPosicionBrazo('I')==ARRIBA){
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
        }else if (getPosicionBrazo('D')==FRENTE){
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
        }else if (getPosicionBrazo('D')==ARRIBA){
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        }
        if(puedeMover('S')) muevase('S');   
        palabras="Soy " + this;
    }    
    
    
    /**
     * Retorna el mensaje del objeto. 
     * @return String con el mensaje que tiene este actor
     */
    public String mensaje(){
        return  palabras;
    }

}

