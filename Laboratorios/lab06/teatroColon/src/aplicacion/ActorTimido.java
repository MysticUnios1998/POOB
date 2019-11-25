package aplicacion;

/**
 * Clase especializada de Actor que no dice nada además de no moverse.
 * 
 */
public class ActorTimido extends Actor{  

	
	/**
	 * Constructor principal de la clase ActorTimido
	 * @param teatro lugar en donde se dibujará el objeto
     * @param name nombre del actor
     * @param posicionx posicion en el eje horizontal del elemento
     * @param posiciony posicion en el eje vertical del elemento
	 */
    public ActorTimido(Teatro teatro,String name,int posicionx, int posiciony){
        super(teatro,name,posicionx,posiciony);        
        setColor("rojo");
        palabras="...";
    }

    @Override
    public void actue(){                   
        muevaBrazo('D','S');
        muevaBrazo('D','S'); 
    }

    @Override
    public void corte(){
        muevaBrazo('D','B'); 
        muevaBrazo('D','B');
    }

    @Override
    public void decida(){
        corte();
    }

}