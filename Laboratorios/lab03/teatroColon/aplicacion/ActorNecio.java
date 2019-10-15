package aplicacion;

/**
 * Write a description of class ActorNecio here. *
 * 
 */
public class ActorNecio extends Actor{
    
    private boolean actuo;
    private int cont;
    
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
