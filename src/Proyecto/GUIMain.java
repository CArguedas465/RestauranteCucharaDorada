
package Proyecto;

import java.awt.event.*;
import javax.swing.*;
//import Proyecto.Autenticacion;
import Proyecto.GUIApp;
import java.awt.*;

public class GUIMain extends JFrame {      
        public static String username;
        private int pX, pY;
        private JLabel hojaprin;
        private JLabel hojalogo;
        private JLabel logo;
        private JLabel bienvenido;
        private JLabel label_nomusuario;
        private JLabel rest;
        private JLabel boton_ingreso;
        private JLabel label_contra;
        private JLabel cerrar;
        private JLabel window_motion;
        private JPanel panelLogin; 
        private JPasswordField contra_Field;
        private JTextField user_Field;
        private JLabel label_aut;
    
        public GUIMain(){        
        setUndecorated(true);       
        this.setBackground(new Color(0,0,0,0));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/4, dim.height/5-100);
        
        panelLogin = new JPanel();
        panelLogin.setBackground(new Color(0,0,0,0)); 
        contra_Field = new JPasswordField();
        user_Field = new JTextField();
        window_motion = new JLabel();
        cerrar = new JLabel();
        label_contra = new JLabel();
        label_nomusuario = new JLabel();
        label_aut = new JLabel();
        boton_ingreso = new JLabel();
        rest = new JLabel();
        bienvenido = new JLabel();
        logo = new JLabel();
        hojaprin = new JLabel();
        hojalogo = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        // <editor-fold defaultstate="collapsed" desc="DiseñoUXLOGIN"> 
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contra_Field.setBackground(new java.awt.Color(255, 255, 255));
        contra_Field.setBorder(null);

        panelLogin.add(contra_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 500, 50));

        user_Field.setBackground(new Color(255, 255, 255));
        user_Field.setFont(new Font("Sylfaen", 0, 18)); 
        user_Field.setForeground(new Color(102, 102, 102));
        user_Field.setHorizontalAlignment(JTextField.LEFT);
        user_Field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panelLogin.add(user_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 500, 50));
 
        window_motion.setHorizontalAlignment(SwingConstants.CENTER);
        window_motion.setIcon(new ImageIcon("ImagesLOGIN\\Separator option 2 resized.png")); 
        window_motion.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent me) {
                window_motionmouseDragged(me);
            }
        });
        window_motion.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                window_motionmousePressed(me);
            }
        });
        panelLogin.add(window_motion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 530, 60));

        cerrar.setFont(new Font("Berlin Sans FB Demi", 0, 36)); 
        cerrar.setForeground(new Color(255, 255, 255));
        cerrar.setHorizontalAlignment(SwingConstants.CENTER);
        cerrar.setIcon(new ImageIcon("ImagesLOGIN\\exitr.png")); 
        cerrar.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                window_close(me); 
            }
        });       
        panelLogin.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 20, 20));

        label_contra.setFont(new Font("Sylfaen", 0, 20)); 
        label_contra.setForeground(new Color(0, 0, 0));
        label_contra.setText("Contraseña:");
        panelLogin.add(label_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 220, 60));

        label_nomusuario.setFont(new Font("Sylfaen", 0, 20)); 
        label_nomusuario.setForeground(new Color(0, 0, 0));
        label_nomusuario.setText("Nombre de usuario: ");
        panelLogin.add(label_nomusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 220, 60));
        
        label_aut.setFont(new Font("Sylfaen", 0, 20));
        label_aut.setForeground(new Color(255,0,0));
        label_aut.setText("Autenticación fallida. Volver a intentar.");
        label_aut.setHorizontalAlignment(SwingConstants.CENTER);
        label_aut.setVerticalAlignment(SwingConstants.CENTER);
        panelLogin.add(label_aut, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, 500, 20));
        label_aut.setVisible(false);
        

        boton_ingreso.setHorizontalAlignment(SwingConstants.CENTER);
        boton_ingreso.setIcon(new ImageIcon("ImagesLOGIN\\Loginr.png")); 
        boton_ingreso.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                boton_ingresomousePressed(evt);
            }
        });
        panelLogin.add(boton_ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 600, 110, 100));

        rest.setFont(new Font("Berlin Sans FB Demi", 0, 36)); 
        rest.setForeground(new Color(255, 255, 255));
        rest.setHorizontalAlignment(SwingConstants.CENTER);
        rest.setText("La cuchara dorada");
        panelLogin.add(rest, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 420, 120));

        bienvenido.setFont(new Font("Berlin Sans FB Demi", 0, 36)); 
        bienvenido.setForeground(new Color(88, 81, 153));
        bienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        bienvenido.setText("Bienvenido");
        panelLogin.add(bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 420, 40));

        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setIcon(new ImageIcon("ImagesLOGIN\\Modified Logo2r.png")); 
        panelLogin.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 330, 330));

        hojaprin.setHorizontalAlignment(SwingConstants.CENTER);
        hojaprin.setIcon(new ImageIcon("ImagesLOGIN\\Rounded corners 2r.png")); 
        panelLogin.add(hojaprin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 600, 740));

        hojalogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hojalogo.setIcon(new ImageIcon("ImagesLOGIN\\Rounded Corners 1r.png")); 
        panelLogin.add(hojalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 760, 860));

        getContentPane().add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1040, 800));

        pack();
        // </editor-fold>
    
    }
        
        
        private void window_motionmousePressed(MouseEvent me){
            pX = me.getX();
            pY = me.getY();
        }
        
        private void window_motionmouseDragged(MouseEvent me){
            setLocation(getLocation().x+me.getX()-pX, getLocation().y+me.getY()-pY);
        }
        
        private void window_close(MouseEvent me){
            System.exit(0);
        }
        
        private void boton_ingresomousePressed(MouseEvent me) {                                     
            String user = user_Field.getText();
            String pass = String.valueOf(contra_Field.getPassword());
            Autenticacion aut = new Autenticacion();
            try {
                if (aut.cred_check(user, pass)==1){
                    JOptionPane.showMessageDialog(null, "Bienvenido(a) a la plataforma, "+user+".");
                    username = user; //Prueba
                    dispose(); 
                    GUIApp guiApp = new GUIApp();
                    guiApp.setVisible(true);
                } else {
                    label_aut.setVisible(true);
                }
            }
            catch (Exception e){
                System.out.print("Exception: "+e);
            }    
        }                 
        
        public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
            /*NOTA IMPORTANTE: PARA INGRESAR AL SISTEMA, UTILIZAR UNA DE LAS CREDENCIALES VÁLIDAS: 
            Usuario: Hello World
            Pass: 123       
            
            El resto de credenciales válidas están en el archivo Login.txt, que se encuentra en la carpeta del proyecto. 
            */
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            GUIMain window = new GUIMain();
            window.setVisible(true);
            }
            
    }

