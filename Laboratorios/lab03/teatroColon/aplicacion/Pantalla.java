package aplicacion;
import java.awt.Color;

public class Pantalla extends Elemento implements EnEscena{
    
    private Teatro teatro;
    
    public Pantalla(Teatro teatro,String name,int posicionx, int posiciony){
        super(name,posicionx,posiciony);
        this.teatro=teatro;
        color=Color.BLACK;        
    }
    
    public void actue(){
        this.setColor("azul");       
    }
    
    public void corte(){
        this.setColor("rojo");
    }
    
    @Override
    public void decida(){
        this.setColor("verde");
    }
    
    public String forma(){
        return FORMAS[2];
    }
}