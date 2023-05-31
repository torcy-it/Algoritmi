
package algestudiante.p0;

public class MatrizOperacionesTest {
    public static void main(String[] args) {
        
        MatrizOperaciones matrizOperaciones = new MatrizOperaciones(7 , 30 , 720 );

        System.out.println( matrizOperaciones.getTam());

        matrizOperaciones.escribir();

        MatrizOperaciones matrizOperaciones2 = new MatrizOperaciones("src/main/java/algestudiante/p0/matriz01.txt");

        System.out.println(matrizOperaciones2.getTam());

        matrizOperaciones2.escribir();
        
        System.out.println();
        
        System.out.println(matrizOperaciones2.sumarDiagonal1() );
        
        System.out.println(matrizOperaciones2.sumarDiagonal2());
        
        matrizOperaciones2.recorrerCamino( 0 , 0);
        
        
        matrizOperaciones2.escribir();
        
    }
}
