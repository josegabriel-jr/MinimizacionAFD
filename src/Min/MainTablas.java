package Min;
import java.util.Arrays;

/**
 *
 * @author Gabriel Jaimes
 */
public class MainTablas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String simbolos = "0,1,2";
        String estados = "A,B,C,D,E,F";
        String transcripcion ="CD,E,A,F,E,D,B,C,F,B,DE,F,F,F,E,A,B,C";
        String finalizador = "F";

        String []arreglo = transcripcion.split(",");
        String transcripcionPC="";

        for (int i = 0; i < arreglo.length; i++) {
            transcripcionPC+=arreglo[i];
            if((i+1)%simbolos.split(",").length==0){
                transcripcionPC+=";";
            }else{
                transcripcionPC+=",";
            }
        }

        Tablas p = new Tablas(simbolos, estados, transcripcion,transcripcionPC,finalizador);
        p.cargarTabla();
        p.minimizar();
        System.out.println(p.mostrar());



    }

}

