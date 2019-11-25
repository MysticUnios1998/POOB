package aplicacion;

public class Luz extends Elemento implements EnEscena{
    
    public Luz(Teatro teatro,String name,int posicionx, int posiciony){
        super(name,posicionx,posiciony);
        color="black";        
    }
    
    public void actue(){
        this.setColor("amarillo");       
    }
    
    public void corte(){
        this.setColor("negro");
    }
    
    public String forma(){
        return FORMAS[1];
    }
}
