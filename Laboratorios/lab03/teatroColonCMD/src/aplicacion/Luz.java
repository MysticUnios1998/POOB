package aplicacion;
import java.awt.Color;

public class Luz extends Elemento implements EnEscena{
    
    private Teatro teatro;
    
    public Luz(Teatro teatro,String name,int posicionx, int posiciony){
        super(name,posicionx,posiciony);
        this.teatro=teatro;
        color=Color.BLACK;        
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
