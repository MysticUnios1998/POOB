package aplicacion;
import java.util.*;


/**
 * @author ECI 2014
 * 
 */
/**
 * @author ECI
 *
 */
public class Teatro{
    public static final int MAXIMO = 500;
    private static Teatro teatro = null;
    
    public static Teatro demeTeatro() {
        if (teatro==null){
            teatro=new Teatro();
        }
        return teatro;
    }
    
    private static void nuevoTeatro() {
        teatro=new Teatro();
    }   
    
    public static void cambieTeatro(Teatro d) {
        teatro=d;
    }       


    private ArrayList<EnEscena> elementos;
    
    private Teatro() {
        elementos= new ArrayList<EnEscena>();
    }
    
    public void algunosEnEscena(){ 
        Actor romeo = new Actor(Teatro.demeTeatro(),"romeo", 10, 10); 
        Actor julieta = new Actor(Teatro.demeTeatro(),"julieta", 100, 10);
        adicione(romeo);
        adicione(julieta);
        ActorNecio homer = new ActorNecio(Teatro.demeTeatro(), "homer", 190, 10);
        ActorNecio bard = new ActorNecio(Teatro.demeTeatro(), "bard", 280, 10);
        adicione(homer);
        adicione(bard);
        Luz centralDerecha = new Luz(Teatro.demeTeatro(), "centralDerecha", 220, 250);
        Luz centralIzquierda = new Luz(Teatro.demeTeatro(), "centralIzquierda", 280, 250);
        adicione(centralDerecha);
        adicione(centralIzquierda);
        ActorPerezoso bella = new ActorPerezoso(Teatro.demeTeatro(), "bella", 390, 10);
        ActorPerezoso edward = new ActorPerezoso(Teatro.demeTeatro(), "edward", 480, 10);
        adicione(bella);
        adicione(edward);
        ActorTimido juan = new ActorTimido(Teatro.demeTeatro(), "juan", 390, 80);
        ActorTimido eduard = new ActorTimido(Teatro.demeTeatro(), "eduard", 480, 80);
        adicione(juan);
        adicione(eduard);
        Pantalla izquierda = new Pantalla(Teatro.demeTeatro(), "izquierda", 100, 450);
        Pantalla derecha = new Pantalla(Teatro.demeTeatro(), "derecha", 400, 450);
        adicione(izquierda);
        adicione(derecha);
    }  
    
    
    public EnEscena demeEnEscena(int n){
        EnEscena h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }
    
    
    public void adicione(EnEscena e){
	    elementos.add(e);
    }
	
    public int numeroEnEscena(){
        return elementos.size();
    }  
    
    public void accion(){
        for (EnEscena e: elementos) e.actue();
    }

    
    public void corten(){
        for (EnEscena e: elementos) e.corte();
    }    

    public void decidan(){
        for (EnEscena e: elementos) e.decida();
    }  
    
}
