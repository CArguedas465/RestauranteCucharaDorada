
package Proyecto;

import java.util.*;
import java.io.*;

public class Autenticacion {
    public Scanner entry;
    String user, pass, newuser, newpass, str;
    String[] arrOfStr;
    boolean res = false;


    public int cred_check(String user, String pass) throws IOException{ //Checkea las credenciales del archivo de texto. Implementado y llamado en el método boton_ingresomousePressed(), en GUIMain.
        while (res==false){
            File file = new File("Login.txt");
            Scanner scan = new Scanner(file); 
            while (scan.hasNext()){
                str = scan.nextLine();
                arrOfStr = str.split("%", 5);
                if (str.equals("")){
                    //continue
                }
                else if ((user.equals(arrOfStr[0])) & (pass.equals(arrOfStr[1]))){
                    res = true;
                    scan.close();
                    break;
                } else {
                    //continue
                }
            } scan.close();
            if (res == false){
                System.out.print("Autenticación no pasada. Vuelva a intentar.\n");
                return 0; 
            } 
        }  
        System.out.print("Autenticación pasada. Bienvenido a la plataforma, "+user+".\n");
        return 1;
        }
    }

    //Implementar código para eliminar a un usuario
    
  
    

   
    
