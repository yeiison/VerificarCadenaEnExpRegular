
package exp_reg;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Yeison
 */
public class Exp_Reg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String expRegular, cadena;
       
        Scanner leer = new Scanner (System.in) ;
        
        System.out.println("Escriba expresión regular:");
        expRegular = leer.next();
        
        System.out.println("Escriba la cadena a comprobar:");
        cadena = leer.next();
        
        boolean salir = false;
        int opcion;
        
        while (!salir) {
        System.out.println("1. Comprobar Cadena");
        System.out.println("2. Cambiar Cadena");
        System.out.println("3. Cambiar Expresion Regular");
        System.out.println("4. Salir");
            
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = leer.nextInt();
 
                switch (opcion) {
                    case 1:
                        mostrarInformacion(cadena, expRegular);
                        break;
                    case 2:                      
                        System.out.println("Escriba la cadena a comprobar:");
                        cadena = leer.next();
                        mostrarInformacion(cadena, expRegular);
                        break;
                    case 3:
                        System.out.println("Escriba expresión regular:");
                        expRegular = leer.next();
                        mostrarInformacion(cadena, expRegular);
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                leer.next();
            }
        }          
        
        
    }
    
    public static void mostrarInformacion(String cadena, String expRegular){
        
        System.out.println("/////////////////////////////////////////////////////////////////////");
        System.out.println("//VERIFICAR SI UN PATRÓN SE ENCUENTRA CONTENIDO EN UNA CADENA DADA");
        System.out.println("//   CADENA: "+ cadena);
        System.out.println("//   EXPRESION REGULAR: "+ expRegular);
        System.out.println("//   "+verificarPatron(expRegular,cadena));
        System.out.println("//////////////////////////////////////////////////////////////////////");       
    }
                   
    public static String verificarPatron (String expRegular,String  cadena){
        String res;
        Pattern pat;
        pat = Pattern.compile(expRegular);
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            res = "SI, se encuentra contenida en la Expresion Regular";
        }else {
            res = "NO, se encuentra contenida en la Expresion Regular";
        }     

        return res;
    }
    
}
