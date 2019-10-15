package aplicacion;

/**
 * Write a description of class ActorTimido here. *
 * 
 */
public class ActorTimido extends Actor{  

    public ActorTimido(Teatro teatro,String name,int posicionx, int posiciony){
        super(teatro,name,posicionx,posiciony);        
        setColor("rojo");
        palabras="...";
    }

    @Override
    public void actue(){                   
        muevaBrazo('D','S');
        muevaBrazo('D','S'); 
        palabras="";
    }

    @Override
    public void corte(){
        muevaBrazo('D','B'); 
        muevaBrazo('D','B');
        palabras="";
    }

    @Override
    public void decida(){
        corte();
    }

}