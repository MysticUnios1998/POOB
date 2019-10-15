package aplicacion;

/**
 * Write a description of class ActorPerezoso here. *
 * 
 */
public class ActorPerezoso extends Actor{  

    public ActorPerezoso(Teatro teatro,String name,int posicionx, int posiciony){
        super(teatro,name,posicionx,posiciony);        
        setColor("verde");        
    }

    @Override
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
        palabras="";
    }

    @Override
    public void corte(){
        muevaBrazo('I','B'); 
        muevaPierna('I','S');
        muevaPierna('I','S');
        muevaBrazo('D','B'); 
        muevaPierna('D','S');
        muevaPierna('D','S');
        palabras="¡Aqui perezosos!";
    }

    @Override
    public void decida(){
        corte();
    }

}