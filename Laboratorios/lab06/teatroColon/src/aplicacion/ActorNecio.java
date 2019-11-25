package aplicacion;

/**
 * Clase especializada de  Actor que solo actua cada tres ordenes, además de ir en contra la accion de decidir.
 * 
 * @author Eduard Arias
 * @version 1.0
 * 
 */
public class ActorNecio extends Actor{
    
    private boolean actuo;
    private int cont;
    
    /**
     * Constructor principal de la clase ActorNecio
     * @param teatro lugar en donde se dibujará el objeto
     * @param name nombre del actor
     * @param posicionx posicion en el eje horizontal del elemento
     * @param posiciony posicion en el eje vertical del elemento
     */
    public ActorNecio(Teatro teatro,String name,int posicionx, int posiciony){
        super(teatro,name,posicionx,posiciony);        
        setColor("azul"); 
        actuo = false;
        cont = 0;
    }
    
    @Override
    public void actue(){
        if(cont%3==0){
            super.corte(); 
            actuo = true;
            cont+=1;
       }else{
           super.actue();
           cont+=1;
        }
    }
    
    @Override
    public void corte(){
        if(cont%3==0){
            super.actue();
            actuo = false;
            cont+=1;
        }else{
            super.corte();
            cont+=1;
        }
    }
    
    @Override
    public void decida(){
        if(actuo) actue();
        else corte();
    }
    
}
