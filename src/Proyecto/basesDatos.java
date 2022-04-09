
package Proyecto;

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class basesDatos {
    public Scanner entry;
    ArrayList temp_list = new ArrayList();
    String str, return_precio, return_nombre, com_adl, prec_adl, n_nombre, n_precio;
    String[] arrOfBase;
    String[][] arrOfTable;
    int selmenu, lcounter, del_menu, mod_menu, nop_menu;
    
 
    public String[][] menu_matrix() throws FileNotFoundException{ //Método que será implementado en el panel de facturación cuando esté más completo. Funcional pero no implementado aun. 
        File menu = new File("Precios.txt");
        Scanner scan = new Scanner(menu);
        while (scan.hasNext()){
                scan.nextLine();
                lcounter+=1;
            } scan.close(); 
            arrOfTable = new String[lcounter][3]; 
        Scanner scan_2 = new Scanner(menu);
        while (scan_2.hasNext()){
            str = scan_2.nextLine();
            arrOfBase = str.split("%", 5);
            arrOfTable[(Integer.parseInt(arrOfBase[0]))-1] = arrOfBase; 
            arrOfBase = null;
        } scan_2.close();
        lcounter = 0;
        str = "";
        /*System.out.print("modis//////"); PRUEBAS
        for (String[] f: arrOfTable){
            for (String c: f){
                System.out.print(c);
            }
        }*/
        return arrOfTable;
        
    }
    public String[][] admin_matrix() throws FileNotFoundException{
        lcounter = 0;
        File login = new File("Login.txt");
        Scanner scan = new Scanner(login);
        
        while (scan.hasNext()){
                scan.nextLine();
                lcounter+=1;
            } scan.close(); 
        arrOfTable = new String[lcounter][2];
        Scanner scan_2 = new Scanner(login);
        for (int i=0; i<lcounter; i++){
            while (scan_2.hasNext()){
                str = scan_2.nextLine();
                arrOfBase = str.split("%", 5);
                arrOfTable[i]=arrOfBase;
                arrOfBase=null;
                break;
        } 
    } scan_2.close();
    return arrOfTable;
    }
    public String[][] history_matrix() throws FileNotFoundException{
        lcounter = 0;
        File login = new File("Facturas.txt");
        Scanner scan = new Scanner(login);
        
        while (scan.hasNext()){
                scan.nextLine();
                lcounter+=1;
            } scan.close(); 
        arrOfTable = new String[lcounter][11];
        Scanner scan_2 = new Scanner(login);
        for (int i=0; i<lcounter; i++){
            while (scan_2.hasNext()){
                str = scan_2.nextLine();
                arrOfBase = str.split("%", 15);
                arrOfTable[i]=arrOfBase;
                arrOfBase=null;
                break;
        } 
        } scan_2.close();
        return arrOfTable;
    }
    public void mod_menu(int mode, String par1, String par2) throws FileNotFoundException, IOException{ // Método que adiciona, borra y modifica componentes del menú (archivo de texto). Trabaja por modos. Si el argumento==1, adiciona. Argumento==2, borra. Argumento==3, modifica.                                                                  
        //1: Adicionar, 2: Borrar , 3: Modificar elementos; 
        /*REQUERIMIENTOS DE LOS ARGUMENTOS: 
            MODE 1 = Al llamarse, necesita el int del mode, par1 como nombre de lo que se va adicionar como String, par2 como precio de lo que se va adicionar como String. 
            MODE 2 = Al llamarse, necesita el int del mode, par1 como el identificador en el menú (en este caso, temp_vector[0]), par2 como cualquier String (es indiferente; se puede poner "").
            MODE 3 = Al llamarse, necesita el int del mode, par1 como el identificador en el menú (en este caso, temp_vector[0]), par2 como el identificador como String de si se quiere modificar el nombre ("0") o el precio ("1") del elemento. 
        */
        if (mode==1){
            //Adquiere posición dentro del menú 
            File file = new File("Precios.txt");
            Scanner scan = new Scanner(file);
            
            while (scan.hasNext()){
                str = scan.nextLine();
                arrOfBase = str.split("%", 5); 
            } scan.close();
            FileWriter fw = new FileWriter("Precios.txt", true);
            fw.write("\n"+(Integer.valueOf(arrOfBase[0])+1)+"%"+par1+"%"+par2);
            fw.close(); 
            System.out.print("Process completed.");
        }
        else if (mode==2){
            //Lectura del archivo y paso a la lista temp_list
            File file = new File("Precios.txt");
            Scanner scan = new Scanner(file);
            
            while (scan.hasNext()){
                str = "";
                str = scan.nextLine();
                arrOfBase = str.split("%", 5);
                if (Integer.valueOf(arrOfBase[0])!= Integer.parseInt(par1)){
                    temp_list.add(arrOfBase[1]+"%"+arrOfBase[2]); 
                } else {
                    //continue
                }
            } scan.close();
            //Borrar file viejo
            FileWriter fw = new FileWriter("Precios.txt", false);
            fw.write("");
            //Rescribir 
            for (int i=0; i<temp_list.size(); i++){
                if (i!=temp_list.size()-1){
                    fw.write((i+1)+"%"+temp_list.get(i).toString()+"\n");
                } else {
                    fw.write((i+1)+"%"+temp_list.get(i).toString());
                }
            } fw.close();     
            temp_list.clear();
        }
        else if (mode==3){ 
            File precios = new File("Precios.txt");
            if (Integer.valueOf(par2) == 0){
                Scanner scan = new Scanner(precios);
                while (scan.hasNext()){
                str = "";
                str = scan.nextLine();
                arrOfBase = str.split("%", 5);
                
                if (Objects.equals(Integer.valueOf(arrOfBase[0]), Integer.valueOf(par1))){
                    String n_nombre = JOptionPane.showInputDialog(
                    null, 
                    "Nuevo nombre: ", 
                    "Cambiar nombre",
                    JOptionPane.QUESTION_MESSAGE
                    );
                    if (n_nombre==null){
                        temp_list.add(arrOfBase[1]+"%"+arrOfBase[2]);
                    } else {
                        arrOfBase[1]=n_nombre;
                        temp_list.add(arrOfBase[1]+"%"+arrOfBase[2]);
                    }
                } else {
                    temp_list.add(arrOfBase[1]+"%"+arrOfBase[2]);
                }
            } scan.close(); arrOfBase=null;
            //Borrar file viejo
            FileWriter fw = new FileWriter("Precios.txt", false);
            fw.write("");
            //Rescribir
                for (int i=0; i<temp_list.size(); i++){
                    if (i!=temp_list.size()-1){
                        fw.write((i+1)+"%"+temp_list.get(i).toString()+"\n");
                    } else {
                        fw.write((i+1)+"%"+temp_list.get(i).toString());
                    }
                } fw.close();     
                temp_list.clear();
                }
            if (Integer.valueOf(par2)==1){
                Scanner scan = new Scanner(precios);
                while (scan.hasNext()){
                str = "";
                str = scan.nextLine();
                arrOfBase = str.split("%", 5);
                
                if (Objects.equals(Integer.valueOf(arrOfBase[0]), Integer.valueOf(par1))){
                    String n_precio = JOptionPane.showInputDialog(
                    null, 
                    "Nuevo precio: ", 
                    "Cambiar precio",
                    JOptionPane.QUESTION_MESSAGE
                    );
                    if (n_precio==null){
                        temp_list.add(arrOfBase[1]+"%"+arrOfBase[2]);
                    } else {
                        arrOfBase[2]=n_precio;
                        temp_list.add(arrOfBase[1]+"%"+arrOfBase[2]);
                    }   
                } else {
                    temp_list.add(arrOfBase[1]+"%"+arrOfBase[2]);
                }
            } scan.close();
            //Borrar file viejo
            FileWriter fw = new FileWriter("Precios.txt", false);
            fw.write("");
            // Reescribir 
            for (Object i: temp_list){
                System.out.print(i);
            }
            for (int i=0; i<temp_list.size(); i++){
                    if (i!=temp_list.size()-1){
                        fw.write((i+1)+"%"+temp_list.get(i).toString()+"\n");
                    } else {
                        fw.write((i+1)+"%"+temp_list.get(i).toString());
                    }
                } fw.close();     
            temp_list.clear();
                
            }
        }
    } //Ver control de errores de mode==2
    public void mod_admin (int mode, String par1, String par2) throws FileNotFoundException, IOException{
        //1: Adicionar, 2: Borrar , 3: Modificar elementos; 
        /*REQUERIMIENTOS DE LOS ARGUMENTOS: 
            MODE 1 = Al llamarse, necesita el int del mode, par1 como login de lo que se va adicionar como String, par2 como la contraseña de lo que se va adicionar como String. 
            MODE 2 = Al llamarse, necesita el int del mode, par1 el String contenedor de la selección, par2 como cualquier String (es indiferente; se puede poner "").
            MODE 3 = Al llamarse, necesita el int del mode, par1 como el identificador en el menú (en este caso, temp_vector[0]), par2 como el identificador como String de si se quiere modificar el nombre ("0") o el precio ("1") del elemento. 
        */
        if (mode==1){
            File file = new File("Login.txt");
            FileWriter fw = new FileWriter("Login.txt", true);
            if (file.length()==0){
                fw.write(par1+"%"+par2);
            } else {
                fw.write("\n"+par1+"%"+par2);
            }
            
            fw.close();
        } else if (mode==2){
            //Lectura del archivo y paso a la lista temp_list
            File file = new File("Login.txt");
            Scanner scan = new Scanner(file);
            
            while (scan.hasNext()){
                str = "";
                str = scan.nextLine();
                if (str.equals(par1)){
                    //continue;
                } else {
                    temp_list.add(str);
                }
            } scan.close(); 
            //Borrar file viejo
            FileWriter fw = new FileWriter("Login.txt", false);
            fw.write("");
            //Rescribir
            for (int i=0; i<temp_list.size(); i++){
                if (i!=temp_list.size()-1){
                    fw.write(temp_list.get(i).toString()+"\n");
                } else {
                    fw.write(temp_list.get(i).toString());
                }
            } fw.close();     
            temp_list.clear();
        } else {
            File file = new File("Login.txt");
            if (Integer.valueOf(par2) == 0){
                Scanner scan = new Scanner(file);
                while (scan.hasNext()){
                str = "";
                str = scan.nextLine();
                arrOfBase = str.split("%", 5);
                
                if (Objects.equals(str, par1)){
                    String n_usuario = JOptionPane.showInputDialog(
                    null, 
                    "Nuevo Usuario: ", 
                    "Cambiar Usuario",
                    JOptionPane.QUESTION_MESSAGE
                    );
                    if (n_usuario==null){
                        temp_list.add(arrOfBase[0]+"%"+arrOfBase[1]);
                    } else {
                        arrOfBase[0]=n_usuario;
                        temp_list.add(arrOfBase[0]+"%"+arrOfBase[1]);
                    }
                } else {
                    temp_list.add(arrOfBase[0]+"%"+arrOfBase[1]);
                }
            } scan.close();
            // Borrar file viejo
            FileWriter fw = new FileWriter("Login.txt", false);
            fw.write("");
            //Rescribir
            for (int i=0; i<temp_list.size(); i++){
                if (i!=temp_list.size()-1){
                    fw.write(temp_list.get(i).toString()+"\n");
                } else {
                    fw.write(temp_list.get(i).toString());
                }
            } fw.close();     
            temp_list.clear();
            } else {
                Scanner scan = new Scanner(file);
                while (scan.hasNext()){
                str = "";
                str = scan.nextLine();
                arrOfBase = str.split("%", 5);
                
                if (Objects.equals(str, par1)){
                String n_contra = JOptionPane.showInputDialog(
                null, 
                "Nueva Contraseña: ", 
                "Cambiar Contraseña",
                JOptionPane.QUESTION_MESSAGE
                );
                if (n_contra==null){
                    temp_list.add(arrOfBase[0]+"%"+arrOfBase[1]);
                } else {
                    arrOfBase[1]=n_contra;
                    temp_list.add(arrOfBase[0]+"%"+arrOfBase[1]);
                }
                
                     
                } else {
                    temp_list.add(arrOfBase[0]+"%"+arrOfBase[1]);
                }
            } scan.close();
            // Borrar file viejo
            FileWriter fw = new FileWriter("Login.txt", false);
            fw.write("");
            //Rescribir
            for (int i=0; i<temp_list.size(); i++){
                if (i!=temp_list.size()-1){
                    fw.write(temp_list.get(i).toString()+"\n");
                } else {
                    fw.write(temp_list.get(i).toString());
                }
            } fw.close();     
            temp_list.clear();
            }
        }
    
    }
    public int facturaCant_lectura() throws FileNotFoundException{
        int cant = 0; 
        File file = new File("Facturas.txt");
        Scanner scan = new Scanner(file);
        
        while (scan.hasNext()){
            cant+=1; 
            scan.nextLine();
        }
        scan.close();
        return cant;
    }
    

    
}
