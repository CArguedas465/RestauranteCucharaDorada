
package Proyecto;

import java.awt.event.*;
import javax.swing.*;
import Proyecto.GUIMain;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;

public class GUIApp extends JFrame {
    TableModel tableModel_add, tableModel_remove, tableModel_file;
    
    int order_matrix_counter = 0, lcounter, lcounter_2=0, lcounter_fac=0, fac_counter=0, ventas_diarias = 0, cierre_matrix_counter = 0;
    
    float total, desc, ganancia_cierre = 0; 
    
    private String[][] order_matrix_1, order_matrix_2, history_matrix, cierre_matrix;
    
    private String[] temp_vector, cierre_temp_vector;
    
    public String temp_str_addOrder, temp_str_removeOrder, temp_str_menuMod, order_confirm, order_confirm_2, temp_str_adminMod; 
    
    private int pX, pY; //Variables para posición. 
    
    private JPanel mainPanel, facPanel, menuPanel, homePanel, adminPanel, cierrePanel; // Paneles del programa
    
    private JLabel mainLabel; //Label principal con el diseño de la interfaz.
    
    private JLabel menuPanel_button, facPanel_button, homePanel_button, adminPanel_button, min_button,              //Botones
            bg_button, addOrder_button, removeOrder_button, addMenu_button, removeMenu_button, modifyMenu_button, 
            addAdmin_button,removeAdmin_button, modifyAdmin_button, historialFac_button, 
            creacionFacPro_button, cerrarCierre_button, logOut_button, close_button;    
    
    private JLabel filtroBase_menuPanel, filtroBase_facPanel, filtroBase_homePanel, filtroBase_adminPanel; // Filtros de todos los paneles. 
    
    private JLabel bienvenido_Label;
    private JLabel menuPanel_Label; 
    private JLabel facturacionPanel_Label;
    private JLabel fecha_Label;
    private JLabel numesa_Label;
    private JLabel cliente_Label;
    private JLabel tipo_Label;
    private JLabel menu_Label;
    private JLabel pago_Label;
    private JLabel employee_Label;
    private JLabel descr_Label;
    private JLabel desc_Label; 
    private JLabel orden_Label;  
    private JLabel homePanel_Label;
    private JLabel adminPanel_Label;
    private JLabel adminLogoiCon;   
    private JLabel fondo_cierrePanel;
    private JLabel gananciaDiaria_Label; 
    private JLabel ventasDiarias_Label; 
    private JLabel facturasHistorial_Label; 
    private JLabel gananciaDiariaCalc_Label; 
    private JLabel ventasDiariasCalc_Label;
    private JLabel facturasHistorialCalc_Label;
    private JLabel cierre_Label; 
    private JLabel appwindow_motion;
    private JLabel user_name; 
    private JLabel date_Label;
    private JLabel ventasCierre_Label;
    private JLabel gananciasCierre_Label; 
    private JRadioButton efectivo_rb_bGPago, tarjeta_rb_bGPago, nA_rB_bGPago; // JRadioButtons para modo de pago. 
    private JRadioButton factura_rb_bGTipo, proforma_rb_bGTipo; // JRadioButtons para tipo de documento. 
    private ButtonGroup bG_Pago, bG_Tipo; //Button Groups para modo de pago y tipo de documento.
    private JScrollPane desc_scrollpanel, menuTable_scrollpanel, orderTable_scrollpanel, menuTable2_scrollpanel, adminTable_scrollpanel, cierreTable_scrollpanel, historyTable_scrollpanel;
    private JTextArea descr_TextArea; //Text Area para descripción de facturación. 
    private JTextField fecha_TextField, numesa_TextField, cliente_TextField, employee_TextField; //Text Fields para facturación.
    private JTable menu_Table, menu_Table_2, order_Table, admin_Table, cierre_Table, history_Table; //Tablas mostradas a través del programa. 
    private JComboBox descuento_ComboBox; //ComboBox para definir la cantidad de descuento a aplicar. 

    public GUIApp() throws FileNotFoundException{
        setUndecorated(true);       
        this.setBackground(new Color(0,0,0,0));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/5-50, dim.height/6-50);
        
        //Constructor para ponerle fecha al programa
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = new Date();
        //declaraciones iniciales
        order_matrix_1 = new String[100][2];
        order_matrix_2 = new String[100][2]; 
        cierre_matrix = new String[100][11]; 
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(0,0,0,0));
        facPanel = new JPanel();
        homePanel = new JPanel();
        menuPanel = new JPanel();
        adminPanel = new JPanel();
        cierrePanel = new JPanel();
        adminLogoiCon = new JLabel();
        logOut_button = new JLabel();
        adminPanel_button = new JLabel();
        facPanel_button = new JLabel();
        homePanel_button = new JLabel();
        menuPanel_button = new JLabel();
        addOrder_button = new JLabel(); 
        removeOrder_button = new JLabel();
        addMenu_button = new JLabel();
        removeMenu_button = new JLabel(); 
        modifyMenu_button = new JLabel(); 
        addAdmin_button = new JLabel();
        removeAdmin_button = new JLabel(); 
        modifyAdmin_button = new JLabel(); 
        historialFac_button = new JLabel(); 
        creacionFacPro_button = new JLabel();  
        cerrarCierre_button = new JLabel(); 
        bienvenido_Label = new JLabel();
        efectivo_rb_bGPago = new JRadioButton();
        tarjeta_rb_bGPago = new JRadioButton();
        nA_rB_bGPago = new JRadioButton();
        bG_Pago = new ButtonGroup();
        factura_rb_bGTipo = new JRadioButton();
        proforma_rb_bGTipo = new JRadioButton();
        bG_Tipo = new ButtonGroup();
        facturacionPanel_Label = new JLabel();
        fecha_Label = new JLabel();
        numesa_Label = new JLabel();
        cliente_Label = new JLabel();
        tipo_Label = new JLabel();
        menu_Label = new JLabel();
        pago_Label = new JLabel();
        employee_Label = new JLabel();
        descr_Label = new JLabel();
        orden_Label = new JLabel(); 
        desc_Label = new JLabel(); 
        filtroBase_homePanel = new JLabel();
        homePanel_Label = new JLabel();
        adminPanel_Label = new JLabel();
        filtroBase_adminPanel = new JLabel();
        appwindow_motion = new JLabel();
        close_button = new JLabel();
        min_button = new JLabel();
        bg_button = new JLabel();
        user_name = new JLabel();
        date_Label = new JLabel(); 
        ventasCierre_Label = new JLabel();
        gananciasCierre_Label = new JLabel();
        gananciaDiaria_Label = new JLabel();
        ventasDiarias_Label = new JLabel(); 
        facturasHistorial_Label = new JLabel(); 
        gananciaDiariaCalc_Label = new JLabel();
        ventasDiariasCalc_Label = new JLabel();
        facturasHistorialCalc_Label = new JLabel();
        cierre_Label = new JLabel(); 
        employee_TextField = new JTextField();
        fecha_TextField = new JTextField();
        numesa_TextField = new JTextField();
        cliente_TextField = new JTextField();
        desc_scrollpanel = new JScrollPane();
        menuTable_scrollpanel = new JScrollPane();
        orderTable_scrollpanel = new JScrollPane();
        menuTable2_scrollpanel = new JScrollPane();
        adminTable_scrollpanel = new JScrollPane();
        cierreTable_scrollpanel = new JScrollPane();
        historyTable_scrollpanel = new JScrollPane(); 
        descr_TextArea = new JTextArea();
        filtroBase_facPanel = new JLabel();
        menuPanel_Label = new JLabel();
        filtroBase_menuPanel = new JLabel();
        fondo_cierrePanel = new JLabel();
        mainLabel = new JLabel(); 
        //Tabla del menú en facturación
        menu_Table = new JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        menu_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Tabla de la órden en facturación
        order_Table = new JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        order_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Tabla del menú en menú
        menu_Table_2 = new JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        menu_Table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Tabla de credenciales en admin
        admin_Table = new JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        admin_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        cierre_Table = new JTable() {
            public boolean isCellEditable(int row, int column){
                return false; 
            }
        };
        cierre_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        descuento_ComboBox = new JComboBox(); 
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\Close.png"));
        close_button.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me){
                close_buttonAction(me);
            }
        });
        mainPanel.add(close_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150,19,60,60));
        
        min_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\Minimize.png"));
        min_button.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me){
                min_buttonAction(me);
            }
        });
        mainPanel.add(min_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110,19,60,60));
        
        bg_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\buttonbg.png"));
        mainPanel.add(bg_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100,19,120,60));

        logOut_button.setHorizontalAlignment(SwingConstants.CENTER);
        logOut_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\LogOutr.png")); 
        logOut_button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                logOut_buttonAction(me);
            }
        });
        mainPanel.add(logOut_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 760, 60, 60));

        adminPanel_button.setHorizontalAlignment(SwingConstants.CENTER);
        adminPanel_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\PanelAdmin.png")); 
        adminPanel_button.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me){
                adminPanel_buttonAction(me);
            }
        });
        mainPanel.add(adminPanel_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 180, 70));

        facPanel_button.setHorizontalAlignment(SwingConstants.CENTER);
        facPanel_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\PanelFactu.png")); 
        facPanel_button.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me){
                facPanel_buttonAction(me);
            }
        });
        mainPanel.add(facPanel_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, 260, 70));

        homePanel_button.setHorizontalAlignment(SwingConstants.CENTER);
        homePanel_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\PanelHome.png"));
        homePanel_button.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me){
                homePanel_buttonAction(me);
            }
        });
        mainPanel.add(homePanel_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 220, 70));

        menuPanel_button.setHorizontalAlignment(SwingConstants.CENTER);
        menuPanel_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\PanelMenu.png")); 
        menuPanel_button.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me){
                menuPanel_buttonAction(me);
            }
        });
        mainPanel.add(menuPanel_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 220, 70));

        bienvenido_Label.setFont(new Font("Calibri", 2, 36)); // NOI18N
        bienvenido_Label.setForeground(new Color(255, 255, 255));
        bienvenido_Label.setHorizontalAlignment(SwingConstants.CENTER);
        bienvenido_Label.setText("Bienvenido(a)");
        mainPanel.add(bienvenido_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 20, 260, 160));
        
        user_name.setFont(new Font("Calibri", 1, 36));
        user_name.setForeground(new Color(255, 255, 255));
        user_name.setHorizontalAlignment(SwingConstants.CENTER);
        GUIMain user = new GUIMain(); //Línea de prueba; aún no funciona correctamente (no se muestra). 
        user_name.setText(user.username); //Línea de prueba; aún no funciona correctamente (no se muestra).
        mainPanel.add(user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 65, 260, 160));
        
        date_Label.setFont(new Font("Calibri", 1, 16));
        date_Label.setForeground(new Color(255,255,255));
        date_Label.setHorizontalAlignment(SwingConstants.CENTER);
        date_Label.setText("Fecha: "+dateFormat.format(fecha));
        mainPanel.add(date_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 20, 260, 160)); //720       
        
        
        // <editor-fold defaultstate="collapsed" desc="facPanel config"> 
        
        facPanel.setOpaque(false);
        facPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        facPanel.setVisible(false);
            
            //Tabla de menu - Inicio
        basesDatos matriz = new basesDatos();
        menu_Table.setModel(new DefaultTableModel(matriz.menu_matrix(), new String[]{"Número", "Comida", "Precio"}));
        menu_Table.setFont(new Font("Calibri", 0, 16));
        menu_Table.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                temp_str_addOrder = ""; 
                for (int i=1; i<3; i++){
                    if (i==2){
                        temp_str_addOrder+=String.valueOf(menu_Table.getValueAt(menu_Table.getSelectedRow(), i));
                    } else {
                        temp_str_addOrder+=String.valueOf(menu_Table.getValueAt(menu_Table.getSelectedRow(), i))+"%";
                    }
                }
            } 
        });
        menu_Table.getColumnModel().getColumn(0).setMaxWidth(60);
        menu_Table.getColumnModel().getColumn(2).setMaxWidth(50);
        menuTable_scrollpanel.setViewportView(menu_Table);
        facPanel.add(menuTable_scrollpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60,350,610,120)); //710
        
        addOrder_button.setIcon(new ImageIcon("ImagesMain\\Botones\\Adicionarr.png"));
        addOrder_button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                add_buttonOrderAction(me);
            }
        });
        facPanel.add(addOrder_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 387, 50, 50));
        
        efectivo_rb_bGPago.setText("Efectivo");
        efectivo_rb_bGPago.setFont(new Font("Calibri", 0, 14));
        efectivo_rb_bGPago.setForeground(new Color(255,255,255,255));
        bG_Pago.add(efectivo_rb_bGPago);
        facPanel.add(efectivo_rb_bGPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 190, -1, 50));
        
        nA_rB_bGPago.setText("N/A");
        nA_rB_bGPago.setFont(new Font("Calibri", 0, 14));
        nA_rB_bGPago.setForeground(new Color(255,255,255,255));
        bG_Pago.add(nA_rB_bGPago);
        facPanel.add(nA_rB_bGPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 190, -1, 50)); 
             //Tabla de menu - Final 
             
             //Tabla de orden - Inicio
        order_Table.setModel(new DefaultTableModel(order_matrix_1, new String[]{"Comida", "Precio"}));
        order_Table.setFont(new Font("Calibri", 0, 16));
        orderTable_scrollpanel.setViewportView(order_Table);
        order_Table.getColumnModel().getColumn(0).setMaxWidth(560);
        order_Table.getColumnModel().getColumn(1).setMaxWidth(50);
        order_Table.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                temp_str_removeOrder = ""; 
                for (int i=0; i<2; i++){
                    if (i==1){
                        temp_str_removeOrder+=String.valueOf(order_Table.getValueAt(order_Table.getSelectedRow(), i));
                    } else {
                        temp_str_removeOrder+=String.valueOf(order_Table.getValueAt(order_Table.getSelectedRow(), i))+"%";
                    }
                } 
            } 
        });
        facPanel.add(orderTable_scrollpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60,520,610,120)); //710
        removeOrder_button.setIcon(new ImageIcon("ImagesMain\\Botones\\Borrarr.png"));
        removeOrder_button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                remove_buttonOrderAction(me);
            }
        }); 
        facPanel.add(removeOrder_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 557, 50, 50));
             //Tabla de orden - Final 
        
        tarjeta_rb_bGPago.setText("Tarjeta");   
        tarjeta_rb_bGPago.setFont(new Font("Calibri", 0, 14));
        tarjeta_rb_bGPago.setForeground(new Color(255,255,255,255));
        bG_Pago.add(tarjeta_rb_bGPago);
        facPanel.add(tarjeta_rb_bGPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 190, -1, 50));

        factura_rb_bGTipo.setText("Factura");
        factura_rb_bGTipo.setFont(new Font("Calibri", 0, 14));
        factura_rb_bGTipo.setForeground(new Color(255,255,255,255));
        bG_Tipo.add(factura_rb_bGTipo);
        facPanel.add(factura_rb_bGTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, -1, 50));

        proforma_rb_bGTipo.setText("Proforma");
        proforma_rb_bGTipo.setFont(new Font("Calibri", 0, 14));
        proforma_rb_bGTipo.setForeground(new Color(255,255,255,255));
        bG_Tipo.add(proforma_rb_bGTipo);
        facPanel.add(proforma_rb_bGTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, 50));

        facturacionPanel_Label.setFont(new Font("Calibri", 1, 36)); // NOI18N
        facturacionPanel_Label.setHorizontalAlignment(SwingConstants.CENTER);
        facturacionPanel_Label.setText("FACTURACIÓN");
        facturacionPanel_Label.setForeground(new Color(255,255,255,255));
        facPanel.add(facturacionPanel_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        fecha_Label.setFont(new Font("Calibri", 1, 16)); // NOI18N
        fecha_Label.setHorizontalAlignment(SwingConstants.CENTER);
        fecha_Label.setText("Fecha:");
        fecha_Label.setForeground(new Color(255,255,255,255));
        facPanel.add(fecha_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 120, 40));

        numesa_Label.setFont(new Font("Calibri", 1, 16)); // NOI18N
        numesa_Label.setHorizontalAlignment(SwingConstants.CENTER);
        numesa_Label.setText("# de mesa:");
        numesa_Label.setForeground(new Color(255,255,255,255));
        facPanel.add(numesa_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 120, 40));

        cliente_Label.setFont(new Font("Calibri", 1, 16)); // NOI18N
        cliente_Label.setHorizontalAlignment(SwingConstants.CENTER);
        cliente_Label.setText("Cliente:");
        cliente_Label.setForeground(new Color(255,255,255,255));
        facPanel.add(cliente_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 120, 40));

        tipo_Label.setFont(new Font("Calibri", 1, 16)); // NOI18N
        tipo_Label.setHorizontalAlignment(SwingConstants.CENTER);
        tipo_Label.setText("Tipo:");
        tipo_Label.setForeground(new Color(255,255,255,255));
        facPanel.add(tipo_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 190, 50));

        menu_Label.setFont(new Font("Calibri", 1, 26)); // NOI18N
        menu_Label.setHorizontalAlignment(SwingConstants.CENTER);
        menu_Label.setText("Por favor seleccione del menú: ");
        menu_Label.setForeground(new Color(255,255,255,255));
        facPanel.add(menu_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 310, 350, 40));

        pago_Label.setFont(new Font("Calibri", 1, 16)); // NOI18N
        pago_Label.setHorizontalAlignment(SwingConstants.CENTER);
        pago_Label.setText("Pago: ");
        pago_Label.setForeground(new Color(255,255,255,255));
        facPanel.add(pago_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 120, 40));

        employee_Label.setFont(new Font("Calibri", 1, 16)); // NOI18N
        employee_Label.setHorizontalAlignment(SwingConstants.CENTER);
        employee_Label.setText("Empleado:");
        employee_Label.setForeground(new Color(255,255,255,255));
        facPanel.add(employee_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 130, 40)); 

        descr_Label.setFont(new Font("Calibri", 1, 16)); // NOI18N
        descr_Label.setHorizontalAlignment(SwingConstants.CENTER);
        descr_Label.setText("Descripción:");
        descr_Label.setForeground(new Color(255,255,255,255));
        facPanel.add(descr_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 120, 40));
        
        orden_Label.setFont(new Font("Calibri", 1 , 26));
        orden_Label.setHorizontalAlignment(SwingConstants.CENTER);
        orden_Label.setText("Órden: ");
        orden_Label.setForeground(new Color(255,255,255,255));
        facPanel.add(orden_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 475, 100,40));

        employee_TextField.setHorizontalAlignment(JTextField.CENTER);
        employee_TextField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        employee_TextField.setFont(new Font("Calibri", 2, 20));
        facPanel.add(employee_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 130, 40));

        fecha_TextField.setHorizontalAlignment(JTextField.CENTER);
        fecha_TextField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fecha_TextField.setFont(new Font("Calibri", 2, 20));
        fecha_TextField.setText(dateFormat.format(fecha));
        facPanel.add(fecha_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 120, 40));

        numesa_TextField.setHorizontalAlignment(JTextField.CENTER);
        numesa_TextField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        numesa_TextField.setFont(new Font("Calibri", 2, 20));
        facPanel.add(numesa_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 120, 40));

        cliente_TextField.setHorizontalAlignment(JTextField.CENTER);
        cliente_TextField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cliente_TextField.setFont(new Font("Calibri", 2, 20));
        facPanel.add(cliente_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 610, 40));

        descr_TextArea.setColumns(20);
        descr_TextArea.setRows(5);
        descr_TextArea.setBorder(null);
        descr_TextArea.setFont(new Font("Calibri", 2, 20));
        desc_scrollpanel.setViewportView(descr_TextArea);
        facPanel.add(desc_scrollpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 610, 70));
        
        historialFac_button.setHorizontalAlignment(SwingConstants.CENTER);
        historialFac_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\Historialr.png"));
        historialFac_button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                try {
                    historialFac_buttonAction(me);
                } catch (IOException ex) {
                    Logger.getLogger(GUIApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //Adicionar el mouseListener cuando se tenga el algoritmo para el historial. 
        facPanel.add(historialFac_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 672, 120, 40)); //140
        
        creacionFacPro_button.setHorizontalAlignment(SwingConstants.CENTER);
        creacionFacPro_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\Creacionr.png"));
        creacionFacPro_button.addMouseListener(new MouseAdapter(){
           public void mousePressed(MouseEvent me){
               try { 
                   creacionFacPro_buttonAction(me);
               } catch (IOException ex) {
                   Logger.getLogger(GUIApp.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        });
        facPanel.add(creacionFacPro_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 672, 120, 40));
        
        descuento_ComboBox.addItem("Sin descuento");
        descuento_ComboBox.addItem("5"); 
        descuento_ComboBox.addItem("10"); 
        descuento_ComboBox.addItem("15"); 
        descuento_ComboBox.addItem("20"); 
        descuento_ComboBox.addItem("25"); 
        descuento_ComboBox.addItem("50"); 
        facPanel.add(descuento_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140,670,120,40)); //296
        
        desc_Label.setHorizontalAlignment(SwingConstants.CENTER);
        desc_Label.setFont(new Font("Calibri", 1, 16));
        desc_Label.setText("Desc.:");
        desc_Label.setForeground(new Color(255,255,255,255));
        facPanel.add(desc_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140,638,120,40));
        
        filtroBase_facPanel.setHorizontalAlignment(SwingConstants.CENTER);
        filtroBase_facPanel.setIcon(new ImageIcon("ImagesMAIN\\FiltroBlanco2roundedr.png")); // NOI18N
        facPanel.add(filtroBase_facPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 790, 710));

        mainPanel.add(facPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 820, 770));
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="menuPanel config"> 
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        menuPanel.setVisible(false); 
            
        menu_Table_2.setModel(new DefaultTableModel(matriz.menu_matrix(), new String[]{"Número", "Comida", "Precio"}));
        menu_Table_2.setFont(new Font("Calibri", 0, 32));
        menu_Table_2.getColumnModel().getColumn(0).setMaxWidth(75);
        menu_Table_2.getColumnModel().getColumn(2).setMaxWidth(100);
        menu_Table_2.setRowHeight(35);
        menu_Table_2.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                temp_str_menuMod = ""; 
                for (int i=0; i<3; i++){
                    if (i==2){
                        temp_str_menuMod+=String.valueOf(menu_Table_2.getValueAt(menu_Table_2.getSelectedRow(), i));
                    } else {
                        temp_str_menuMod+=String.valueOf(menu_Table_2.getValueAt(menu_Table_2.getSelectedRow(), i))+"%";
                    }
                } System.out.print(temp_str_menuMod); 
            } 
        });
        menuTable2_scrollpanel.setViewportView(menu_Table_2);
        menuPanel.add(menuTable2_scrollpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60,100,710,550));
        
        menuPanel_Label.setFont(new Font("Calibri", 1, 36)); // NOI18N
        menuPanel_Label.setForeground(new Color(255,255,255,255));
        menuPanel_Label.setHorizontalAlignment(SwingConstants.CENTER);
        menuPanel_Label.setText("MENÚ");
        menuPanel.add(menuPanel_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 50, -1, -1));
        
        addMenu_button.setHorizontalAlignment(SwingConstants.CENTER);
        addMenu_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\AdicionarMenu.png"));
        addMenu_button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                try { //Investigar por qué me pide esto cuando lo pusimos abajo. 
                    addMenu_buttonAction(me);
                } catch (IOException ex) {
                    Logger.getLogger(GUIApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menuPanel.add(addMenu_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 643, 172, 62));
        
        removeMenu_button.setHorizontalAlignment(SwingConstants.CENTER);
        removeMenu_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\BorrarMenu.png"));
        removeMenu_button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                try { //Investigar por qué me pide esto cuando lo pusimos abajo. 
                    removeMenu_buttonAction(me);
                } catch (IOException ex) {
                    Logger.getLogger(GUIApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menuPanel.add(removeMenu_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 643, 172, 62));
        
        modifyMenu_button.setHorizontalAlignment(SwingConstants.CENTER);
        modifyMenu_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\ModificarMenu.png"));
        modifyMenu_button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                try { 
                    modifyMenu_buttonAction(me);
                } catch (IOException ex) {
                    Logger.getLogger(GUIApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menuPanel.add(modifyMenu_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 641, 200, 62));
        

        filtroBase_menuPanel.setHorizontalAlignment(SwingConstants.CENTER);
        filtroBase_menuPanel.setIcon(new ImageIcon("ImagesMAIN\\FiltroBlanco2roundedr.png")); // NOI18N
        menuPanel.add(filtroBase_menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 790, 710));

        mainPanel.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 820, 770));
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="homePanel config"> 
        homePanel.setOpaque(false);
        homePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        homePanel.setVisible(true);
        
        gananciaDiariaCalc_Label.setHorizontalAlignment(SwingConstants.CENTER);
        gananciaDiariaCalc_Label.setForeground(new Color(255,255,255,255));
        gananciaDiariaCalc_Label.setFont(new Font("Calibri", 1, 36));
        gananciaDiariaCalc_Label.setText(String.valueOf(ganancia_cierre));
        homePanel.add(gananciaDiariaCalc_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(187,256,300,100));
        
        gananciaDiaria_Label.setHorizontalAlignment(SwingConstants.CENTER);
        gananciaDiaria_Label.setIcon(new ImageIcon("ImagesMAIN\\Ganancia diariar.png"));
        homePanel.add(gananciaDiaria_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(80,235,385,137));
        
        facturasHistorialCalc_Label.setHorizontalAlignment(SwingConstants.CENTER);
        facturasHistorialCalc_Label.setForeground(new Color(255,255,255,255));
        facturasHistorialCalc_Label.setFont(new Font("Calibri", 1, 36)); 
        basesDatos factura = new basesDatos();
        facturasHistorialCalc_Label.setText(String.valueOf(String.valueOf(factura.facturaCant_lectura())));
        homePanel.add(facturasHistorialCalc_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(635,255,100,100));

        facturasHistorial_Label.setHorizontalAlignment(SwingConstants.CENTER);
        facturasHistorial_Label.setIcon(new ImageIcon("ImagesMAIN\\Facturas Historialr.png"));
        homePanel.add(facturasHistorial_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(492,232,260,137));
        
        ventasDiariasCalc_Label.setHorizontalAlignment(SwingConstants.CENTER);
        ventasDiariasCalc_Label.setForeground(new Color(255,255,255,255));
        ventasDiariasCalc_Label.setFont(new Font("Calibri", 1, 36));
        ventasDiariasCalc_Label.setText(String.valueOf(ventas_diarias));
        homePanel.add(ventasDiariasCalc_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(435,462,100,100));
        
        ventasDiarias_Label.setHorizontalAlignment(SwingConstants.CENTER);
        ventasDiarias_Label.setIcon(new ImageIcon("ImagesMAIN\\Ventas del díar.png"));
        homePanel.add(ventasDiarias_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(290,440,260,137));
        
         
        homePanel_Label.setFont(new Font("Calibri", 1, 36)); // NOI18N
        homePanel_Label.setHorizontalAlignment(SwingConstants.CENTER);
        homePanel_Label.setText("PÁGINA PRINCIPAL");
        homePanel_Label.setForeground(new Color(255,255,255,255));
        homePanel.add(homePanel_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));
        
        filtroBase_homePanel.setHorizontalAlignment(SwingConstants.CENTER);
        filtroBase_homePanel.setIcon(new ImageIcon("ImagesMAIN\\FiltroBlanco2roundedr.png"));
        homePanel.add(filtroBase_homePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 790, 710)); 
        mainPanel.add(homePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 820, 770));
        
        
        
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="adminPanel config"> 
        
        adminPanel.setOpaque(false);
        adminPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        adminPanel.setVisible(false);
        
        addAdmin_button.setHorizontalAlignment(SwingConstants.CENTER);
        addAdmin_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\AdicionarAdmin.png"));
        addAdmin_button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                try {
                    addAdmin_buttonAction(me);
                } catch (IOException ex) {
                    Logger.getLogger(GUIApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        adminPanel.add(addAdmin_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(88,450,243,79));
        
        removeAdmin_button.setHorizontalAlignment(SwingConstants.CENTER);
        removeAdmin_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\BorrarAdmin.png"));
        removeAdmin_button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                try {
                    removeAdmin_buttonAction(me);
                } catch (IOException ex) {
                    Logger.getLogger(GUIApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        adminPanel.add(removeAdmin_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(500,450,243,79));
        
        modifyAdmin_button.setHorizontalAlignment(SwingConstants.CENTER);
        modifyAdmin_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\ModificarAdmin.png"));
        modifyAdmin_button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                try { 
                    modifyAdmin_buttonAction(me);
                } catch (IOException ex) {
                    Logger.getLogger(GUIApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        adminPanel.add(modifyAdmin_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(300,610,243,79));
        
        adminLogoiCon.setHorizontalAlignment(SwingConstants.CENTER);
        adminLogoiCon.setIcon(new ImageIcon("ImagesMAIN\\adminLogoiConr.png"));
        adminPanel.add(adminLogoiCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(75,150,270,227));
        
        basesDatos admin = new basesDatos();
        admin_Table.setModel(new DefaultTableModel(admin.admin_matrix(), new String[]{"Usuario", "Contraseña"}));
        
        admin_Table.setFont(new Font("Calibri", 0, 24));
        admin_Table.setRowHeight(30);
        admin_Table.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                temp_str_adminMod = "";
                for (int i=0; i<2; i++){
                    if (i==1){
                        temp_str_adminMod+=admin_Table.getValueAt(admin_Table.getSelectedRow(), i);
                    } else {
                        temp_str_adminMod+=admin_Table.getValueAt(admin_Table.getSelectedRow(), i)+"%";
                    }
                }
                System.out.print(temp_str_adminMod);
            }  
        });
        adminTable_scrollpanel.setViewportView(admin_Table);
        adminPanel.add(adminTable_scrollpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 150, 395, 225));
        
        adminPanel_Label.setFont(new Font("Calibri", 1, 36)); // NOI18N
        adminPanel_Label.setHorizontalAlignment(SwingConstants.CENTER);
        adminPanel_Label.setText("ADMIN");
        adminPanel_Label.setForeground(new Color(255,255,255,255));
        adminPanel.add(adminPanel_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 50, -1, -1));
        
        filtroBase_adminPanel.setHorizontalAlignment(SwingConstants.CENTER);
        filtroBase_adminPanel.setIcon(new ImageIcon("ImagesMAIN\\FiltroBlanco2roundedr.png"));
        adminPanel.add(filtroBase_adminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 790, 710)); 
        mainPanel.add(adminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 820, 770));
        
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="cierrePanel_config">
        
        cierrePanel.setOpaque(false);
        cierrePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        cierrePanel.setVisible(false);
       
        cierreTable_scrollpanel.setViewportView(cierre_Table);
        cierre_Table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                if (me.getClickCount()==2){
                    if (cierre_matrix[cierre_Table.getSelectedRow()][0]==null) { // Si una sola cosa es null, no hay factura ahí. 
                        // Do nothing. 
                    } else {
                        JOptionPane.showMessageDialog(
                            null, 
                            "Detalles de factura: \n\n"
                          + "Fecha de creación: "+cierre_matrix[cierre_Table.getSelectedRow()][0]+".\n\n"
                          + "Empleado que creó la factura: "+cierre_matrix[cierre_Table.getSelectedRow()][1]+".\n\n"
                          + "Nombre del cliente: "+cierre_matrix[cierre_Table.getSelectedRow()][2]+".\n\n"
                          + "Número de mesa: "+cierre_matrix[cierre_Table.getSelectedRow()][3]+".\n\n"
                          + "Descripción: "+cierre_matrix[cierre_Table.getSelectedRow()][4]+".\n\n"
                          + "Método de Pago: "+cierre_matrix[cierre_Table.getSelectedRow()][5]+".\n\n"
                          + "Tipo de documento: "+cierre_matrix[cierre_Table.getSelectedRow()][6]+".\n\n"
                          + "Órden: "+cierre_matrix[cierre_Table.getSelectedRow()][7]+"\n\n"
                          + "Total sin impuestos: "+cierre_matrix[cierre_Table.getSelectedRow()][8]+".\n\n"
                          + "Total con impuestos: "+cierre_matrix[cierre_Table.getSelectedRow()][9]+".\n\n"
                          + "Total con/sin descuento: "+cierre_matrix[cierre_Table.getSelectedRow()][10]+".\n\n"
                    );
                    }   
                }
            }
        });
        
        cerrarCierre_button.setHorizontalAlignment(SwingConstants.CENTER);
        cerrarCierre_button.setIcon(new ImageIcon("ImagesMAIN\\Botones\\Cerrarr.png"));
        cerrarCierre_button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                int confirm = JOptionPane.showOptionDialog(
                    null,
                    "¿Salir del sistema?", 
                    "Cierre de caja",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Salir", "Cancelar"},
                    "Cancelar"
                    );
                if ((confirm==-1)||(confirm==1)){
                    //Do nothing. 
                } else {
                    System.exit(0);
                }
            }
        });
        cierrePanel.add(cerrarCierre_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(350,650,120,40));
        
        cierrePanel.add(ventasCierre_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 500, 300, 100));

        cierrePanel.add(gananciasCierre_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 300, 100));
        
        cierrePanel.add(cierreTable_scrollpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 725, 300));

        cierre_Label.setHorizontalAlignment(SwingConstants.CENTER);
        cierre_Label.setFont(new Font("Calibri", 1, 50));
        cierre_Label.setForeground(new Color(70,70,70,255));
        cierre_Label.setText("Cierre de caja");
        cierrePanel.add(cierre_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(275,65,-1,-1));
                
        fondo_cierrePanel.setHorizontalAlignment(SwingConstants.CENTER);
        fondo_cierrePanel.setIcon(new ImageIcon("ImagesMAIN\\CierreFondo.png"));
        cierrePanel.add(fondo_cierrePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-35,-35, 896, 847)); 
        
                
        // </editor-fold>
        
        appwindow_motion.setHorizontalAlignment(SwingConstants.CENTER);
        appwindow_motion.setIcon(new ImageIcon("ImagesMAIN\\Motionr.png"));
        appwindow_motion.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent me){
                appwindow_motionmouseDragged(me);
            }
        });
        appwindow_motion.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                appwindow_motionmousePressed(me); 
            }
        });
        mainPanel.add(appwindow_motion, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 17, 660, 75));
        
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainLabel.setIcon(new ImageIcon("ImagesMAIN\\MainLayourOP2r.png")); 
        mainPanel.add(mainLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 1200, 800));
        
        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -20, 1310, 860));
        getContentPane().add(cierrePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430,40,1310,860));

        pack();
    }
        
    private void appwindow_motionmousePressed(MouseEvent me){
            pX = me.getX();
            pY = me.getY();
        }
        
    private void appwindow_motionmouseDragged(MouseEvent me){
            setLocation(getLocation().x+me.getX()-pX, getLocation().y+me.getY()-pY);
    }
    
    private void close_buttonAction(MouseEvent me){
        int confirm = JOptionPane.showOptionDialog(
            null,
            "Si selecciona aceptar, se le rediccionará a la pantalla del cierre de caja.", 
            "Cierre de caja",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[]{"Aceptar", "Cancelar"},
            "Aceptar"
            );
            if ((confirm==-1)||(confirm==1)){
                //Do nothing. 
            } else {
                cierre_Table.setModel(new DefaultTableModel(cierre_matrix, new String[] {"Fecha", "Empleado", "Cliente", "# de mesa", "Descripción", "Pago", "Tipo", "Órden", "Total sin imp.", "Total c/ imp.", "Total c/ descuento"}));
                cierre_Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                
                ventasCierre_Label.setHorizontalAlignment(SwingConstants.CENTER);
                ventasCierre_Label.setFont(new Font("Calibri", 1, 20));
                ventasCierre_Label.setText("Ventas de hoy: "+ventas_diarias);
                
                gananciasCierre_Label.setHorizontalAlignment(SwingConstants.CENTER);
                gananciasCierre_Label.setFont(new Font("Calibri", 1 , 20));
                gananciasCierre_Label.setText("Ganancias de hoy: "+ganancia_cierre);
                
                mainPanel.setVisible(false);
                cierrePanel.setVisible(true);
            }
        
        
        //System.exit(0);
    }
    
    private void logOut_buttonAction(MouseEvent me){
        int confirm = JOptionPane.showOptionDialog(
            null,
            "Si cierra sesión, será redirigido al panel de cierre de caja. ¿Continuar?", 
            "Cerrar sesión",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[]{"Aceptar", "Cancelar"},
            "Aceptar"
            );
        if ((confirm==-1)|(confirm==1)){
            //Do nothing.
        } else {
            cierre_Table.setModel(new DefaultTableModel(cierre_matrix, new String[] {"Fecha", "Empleado", "Cliente", "# de mesa", "Descripción", "Pago", "Tipo", "Órden", "Total sin imp.", "Total c/ imp.", "Total c/ descuento"}));
            cierre_Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                
            ventasCierre_Label.setHorizontalAlignment(SwingConstants.CENTER);
            ventasCierre_Label.setFont(new Font("Calibri", 1, 20));
            ventasCierre_Label.setText("Ventas de hoy: "+ventas_diarias);
                
            gananciasCierre_Label.setHorizontalAlignment(SwingConstants.CENTER);
            gananciasCierre_Label.setFont(new Font("Calibri", 1 , 20));
            gananciasCierre_Label.setText("Ganancias de hoy: "+ganancia_cierre);
                
            mainPanel.setVisible(false);
            cierrePanel.setVisible(true);
        }
        
    }
    
    private void min_buttonAction(MouseEvent me){
        this.setState(JFrame.ICONIFIED);
    }
    
    private int order_matrix_pos(String[][] matrix){
        //System.out.print("Pre val: "+order_matrix_counter);
        order_matrix_counter = 0; 
        for (String[] f: matrix){
            for (String c: f){
                if (c!=null){
                    order_matrix_counter+=1;
                    break;
                } else {
                    //continue
                }
            }
        }
        //System.out.print("New val: "+order_matrix_counter);
        return order_matrix_counter;
    }

    private void add_buttonOrderAction(MouseEvent me){ // Trabajar este algoritmo
        if (temp_str_addOrder==null){
            JOptionPane.showMessageDialog(null, "Debes seleccionar algo del menú.");
        } else {
            temp_vector = temp_str_addOrder.split("%", 5);
            System.out.print(order_matrix_1.length);
            //System.out.print(temp_str_addOrder); PRUEBA
            order_matrix_1[order_matrix_pos(order_matrix_1)] = temp_vector;     
            DefaultTableModel tableModel_add = new DefaultTableModel(order_matrix_1, new String[]{"Comida", "Precio"});
            order_Table.setModel(tableModel_add); 
            /*for (String[] i: order_matrix_1){
                for (String s: i){
                    System.out.print("\n"+s+" ");
                    if (s==null){
                        //continue
                    } else {
                        System.out.print(s+" ");
                    }   
                }
            }*/
        } 
    }
       
    private void remove_buttonOrderAction(MouseEvent me){
        int om1_counter = 0;
        int om2_counter = 0; 
    if (temp_str_removeOrder==null || temp_str_removeOrder==""){
        JOptionPane.showMessageDialog(null, "Debes seleccionar algo de la órden");
    } else {   
        for (String[] f: order_matrix_1){
            if (om1_counter!=order_Table.getSelectedRow()){
                order_matrix_2[om2_counter]=order_matrix_1[om1_counter];
                om1_counter+=1;
                om2_counter+=1; 
            } else {
                om1_counter+=1;
            }
        } order_matrix_1 = order_matrix_2; 
        DefaultTableModel tableModel_remove = new DefaultTableModel(order_matrix_1, new String[]{"Comida", "Precio"});
        order_Table.setModel(tableModel_remove);
        /*for (String [] f: order_matrix_1){ // PRUEBA 
            for (String c: f){
                if (c==null){
                    //continue
                } else {
                    System.out.print(c+" ");
                }
                
            }
        }*/
    } 
        
    }
    basesDatos mod_menu = new basesDatos(); //Acceso a la clase basesDatos por medio del objeto mod_menu. 
    private void addMenu_buttonAction(MouseEvent me) throws IOException{
        String nom = JOptionPane.showInputDialog(
                null, 
                "Nombre de elemento a adicionar: ", 
                "Adicionar elemento",
                JOptionPane.QUESTION_MESSAGE
                );
        if (nom==null){
            //Do nothing.
        } else {
            String price = JOptionPane.showInputDialog(
                null, 
                "Precio respectivo: ", 
                "Adicionar elemento",
                JOptionPane.QUESTION_MESSAGE
                );
                if (price == null){
                    //Do nothing. 
                } else {
                    int confirm = JOptionPane.showOptionDialog(
                        null,
                        "¿Confirmar el cambio?", 
                        "Confirmar adición",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Aceptar", "Cancelar"},
                        "Aceptar"
                        );
                    if ((confirm==-1)||(confirm==1)){
                        //Do nothing.
                    } else {
                        mod_menu.mod_menu(1, nom, price);
                    }
                }
            
            menu_Table_2.setModel(new DefaultTableModel(mod_menu.menu_matrix(), new String[]{"Número", "Comida", "Precio"}));
            menu_Table_2.getColumnModel().getColumn(0).setMaxWidth(75);
            menu_Table_2.getColumnModel().getColumn(2).setMaxWidth(100);
            menu_Table_2.setRowHeight(35);
            
            menu_Table.setModel(new DefaultTableModel(mod_menu.menu_matrix(), new String[]{"Número", "Comida", "Precio"}));
            menu_Table.setFont(new Font("Calibri", 0, 16));
            menu_Table.getColumnModel().getColumn(0).setMaxWidth(60);
            menu_Table.getColumnModel().getColumn(2).setMaxWidth(50);
        } menu_Table_2.clearSelection(); 
        
    }
    private void removeMenu_buttonAction(MouseEvent me) throws IOException{
        if (temp_str_menuMod==null){
            JOptionPane.showMessageDialog(null, "Debes seleccionar algo del menú.");
        } else {
            int confirm = JOptionPane.showOptionDialog(
                null,
                "¿Eliminar el elemento seleccionado?", 
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Aceptar", "Cancelar"},
                "Cancelar"
                );
            if (confirm==0){
                temp_vector = temp_str_menuMod.split("%", 5); 
                mod_menu.mod_menu(2, temp_vector[0], "");
                menu_Table_2.setModel(new DefaultTableModel(mod_menu.menu_matrix(), new String[]{"Número", "Comida", "Precio"}));
                menu_Table_2.getColumnModel().getColumn(0).setMaxWidth(75);
                menu_Table_2.getColumnModel().getColumn(2).setMaxWidth(100);
                menu_Table_2.setRowHeight(35);

                menu_Table.setModel(new DefaultTableModel(mod_menu.menu_matrix(), new String[]{"Número", "Comida", "Precio"}));
                menu_Table.setFont(new Font("Calibri", 0, 16));
                menu_Table.getColumnModel().getColumn(0).setMaxWidth(60);
                menu_Table.getColumnModel().getColumn(2).setMaxWidth(50);
            }
        } menu_Table_2.clearSelection(); temp_str_menuMod=null;
        
    }
    private void modifyMenu_buttonAction(MouseEvent me) throws IOException{
        if (temp_str_menuMod==null){
            JOptionPane.showMessageDialog(null, "Debes seleccionar algo del menú.");
        } else {
            int confirm = JOptionPane.showOptionDialog(
                null,
                "¿Modificar el elemento seleccionado?", 
                "Confirmar modificación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Modificar", "Cancelar"},
                "Cancelar"
                );
            if ((confirm==-1)||(confirm==1)){
                //Do nothing.
            } else {
                int nop = JOptionPane.showOptionDialog(
                null,
                "¿Qué desea modificar?", 
                "Selección de modificación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Nombre", "Precio"},
                "Nombre"
                );
                if (nop==-1){
                    //Do nothing.
                } else {
                    temp_vector = temp_str_menuMod.split("%", 5); 
                    if (nop==0){
                        mod_menu.mod_menu(3, temp_vector[0], "0"); 
                    } else {
                        mod_menu.mod_menu(3, temp_vector[0], "1"); 
                    }    
                }    
            }
            menu_Table_2.setModel(new DefaultTableModel(mod_menu.menu_matrix(), new String[]{"Número", "Comida", "Precio"}));
            menu_Table_2.getColumnModel().getColumn(0).setMaxWidth(75);
            menu_Table_2.getColumnModel().getColumn(2).setMaxWidth(100);
            menu_Table_2.setRowHeight(35);
            
            menu_Table.setModel(new DefaultTableModel(mod_menu.menu_matrix(), new String[]{"Número", "Comida", "Precio"}));
            menu_Table.setFont(new Font("Calibri", 0, 16));
            menu_Table.getColumnModel().getColumn(0).setMaxWidth(60);
            menu_Table.getColumnModel().getColumn(2).setMaxWidth(50);
        } menu_Table_2.clearSelection(); temp_str_menuMod=null;
    }
    basesDatos mod_admin = new basesDatos(); //Acceso a la clases basesDatos por medio del objeto mod_admin.
    private void addAdmin_buttonAction(MouseEvent me) throws IOException{
        String user = JOptionPane.showInputDialog(
                null, 
                "Nombre de usuario a adicionar: ", 
                "Adicionar usuario",
                JOptionPane.QUESTION_MESSAGE
                );
        if ((user==null)){ //Recurre acá si el usuario cierra la ventana. 
            //Do nothing.
        } else {
        String pass = JOptionPane.showInputDialog(
                null, 
                "Contraseña respectiva: ", 
                "Adicionar contraseña",
                JOptionPane.QUESTION_MESSAGE
                );
            if (pass==null){ //Recurre acá si el usuario cierra la ventana. 
                //Do nothing. 
            } else {
                int confirm = JOptionPane.showOptionDialog(
                null,
                "¿Confirmar el cambio?", 
                "Confirmar adición",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Aceptar", "Cancelar"},
                "Aceptar"
                );
                if (confirm==0){
            mod_admin.mod_admin(1, user, pass);
            DefaultTableModel tablemodel_adminAdd = new DefaultTableModel(mod_admin.admin_matrix(), new String[]{"Usuario", "Contraseña"});
            admin_Table.setModel(tablemodel_adminAdd);
            admin_Table.setFont(new Font("Calibri", 0, 24));
            admin_Table.setRowHeight(30);
        }
            }
        }  admin_Table.clearSelection();
    }
    private void removeAdmin_buttonAction(MouseEvent me) throws IOException{
        if (temp_str_adminMod==null){
            JOptionPane.showMessageDialog(null, "Debes seleccionar algún usuario de la tabla.");
        } else {
            int confirm = JOptionPane.showOptionDialog(
                null,
                "¿Eliminar el elemento seleccionado?", 
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Aceptar", "Cancelar"},
                "Cancelar"
                );
            if (confirm==0){
                mod_admin.mod_admin(2, temp_str_adminMod, "");
                DefaultTableModel tablemodel_adminAdd = new DefaultTableModel(mod_admin.admin_matrix(), new String[]{"Usuario", "Contraseña"});
                admin_Table.setModel(tablemodel_adminAdd);
                admin_Table.setFont(new Font("Calibri", 0, 24));
                admin_Table.setRowHeight(30);
            }
        } admin_Table.clearSelection(); temp_str_adminMod=null;
    }
    private void modifyAdmin_buttonAction(MouseEvent me) throws IOException{
        if (temp_str_adminMod==null){
            JOptionPane.showMessageDialog(null, "Debes seleccionar algún usuario de la tabla.");
        } else {
            int confirm = JOptionPane.showOptionDialog(
                null,
                "¿Modificar el elemento seleccionado?", 
                "Confirmar modificación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Modificar", "Cancelar"},
                "Cancelar"
                );
                if ((confirm==-1)||(confirm==1)){
                    //Do nothing.
                } else {
                    if (confirm==0){
                    int nop = JOptionPane.showOptionDialog(
                    null,
                    "¿Qué desea modificar?", 
                    "Selección de modificación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Usuario", "Contraseña"},
                    "Usuario"
                    );
                    if (nop==-1){
                        //Do nothing.
                    } else {
                        if (nop==0){
                            mod_admin.mod_admin(3, temp_str_adminMod, "0");

                        } else {
                            mod_admin.mod_admin(3, temp_str_adminMod, "1"); 
                        }    
                        DefaultTableModel tablemodel_adminAdd = new DefaultTableModel(mod_admin.admin_matrix(), new String[]{"Usuario", "Contraseña"});
                        admin_Table.setModel(tablemodel_adminAdd);
                        admin_Table.setFont(new Font("Calibri", 0, 24));
                        admin_Table.setRowHeight(30);
                    }
                    
                }
            } 
        } admin_Table.clearSelection(); temp_str_adminMod=null;
    }
    basesDatos history = new basesDatos();
    private void historialFac_buttonAction(MouseEvent me) throws FileNotFoundException, IOException {
        File file = new File("Facturas.txt");
        Scanner scan = new Scanner(file);
        
        lcounter_fac = 0;
        
        while (scan.hasNext()){
            scan.nextLine();
            lcounter_fac+=1; 
        }
        scan.close();
        history_matrix = new String[lcounter_fac][11];
        history_matrix = history.history_matrix(); 
        
        history_Table = new JTable(){
            public boolean isCellEditable(int row, int column){
                return false; 
            }
        };
        history_Table.setModel(new DefaultTableModel(history_matrix, new String[]{"Fecha", "Empleado", "Cliente", "# de mesa", "Descripción", "Pago", "Tipo", "Órden", "Total sin imp.", "Total c/ imp.", "Total c/ descuento"}));
        history_Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        history_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        historyTable_scrollpanel.setViewportView(history_Table);
        history_Table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                if (me.getClickCount()==2){
                    JOptionPane.showMessageDialog(
                            null, 
                            "Detalles de factura: \n\n"
                          + "Fecha de creación: "+history_matrix[history_Table.getSelectedRow()][0]+".\n\n"
                          + "Empleado que creó la factura: "+history_matrix[history_Table.getSelectedRow()][1]+".\n\n"
                          + "Nombre del cliente: "+history_matrix[history_Table.getSelectedRow()][2]+".\n\n"
                          + "Número de mesa: "+history_matrix[history_Table.getSelectedRow()][3]+".\n\n"
                          + "Descripción: "+history_matrix[history_Table.getSelectedRow()][4]+".\n\n"
                          + "Método de Pago: "+history_matrix[history_Table.getSelectedRow()][5]+".\n\n"
                          + "Tipo de documento: "+history_matrix[history_Table.getSelectedRow()][6]+".\n\n"
                          + "Órden: "+history_matrix[history_Table.getSelectedRow()][7]+"\n\n"
                          + "Total sin impuestos: "+history_matrix[history_Table.getSelectedRow()][8]+".\n\n"
                          + "Total con impuestos: "+history_matrix[history_Table.getSelectedRow()][9]+".\n\n"
                          + "Total con/sin descuento: "+history_matrix[history_Table.getSelectedRow()][10]+".\n\n"
                    );
                }
            }
        });
        JOptionPane.showMessageDialog(
                null, 
                historyTable_scrollpanel);
        
        
        
    }
    
    private void creacionFacPro_buttonAction(MouseEvent me) throws FileNotFoundException, IOException{
        order_confirm = new String();
        total = 0;
        desc = 0; 
        lcounter = 0;
        lcounter_2 = 0; 
        for (String[] f: order_matrix_1){
            for (String c: f){
                if (c!=null){
                    lcounter+=1;
                } else {
                    //
                }
            }
        }
        
        for (int f=0; f<order_matrix_pos(order_matrix_1); f++){
            total+=Integer.parseInt(order_matrix_1[f][1]);
        } //System.out.print(total); //PRUEBA
        
        
        if ("Sin descuento".equals(descuento_ComboBox.getSelectedItem())){
            desc = (float) (total*1.13); 
        } else {
            String selec = (String) descuento_ComboBox.getSelectedItem();
            desc = (float) ((total*1.13)-((total*1.13)*((float)Integer.parseInt(selec)/100)));
        }
        
        for (String[] f: order_matrix_1){ 
            for (String c: f){
                if (c!=null){
                    order_confirm+=(c+" "); 
                    lcounter_2+=1;
                } else {
                    break;
                }
            } if (lcounter_2!=lcounter){
                order_confirm+="\n"; 
            } else {
                break; 
            }
        } 
        
        JRadioButton selection1 = null;
        JRadioButton selection2 = null; 
        
        if (efectivo_rb_bGPago.isSelected()){
            selection1 = efectivo_rb_bGPago; 
        } else if(tarjeta_rb_bGPago.isSelected()) {
            selection1 = tarjeta_rb_bGPago; 
        } else {
            selection1 = nA_rB_bGPago; 
        }
        
        if (factura_rb_bGTipo.isSelected()){
            selection2 = factura_rb_bGTipo;
        } else {
            selection2 = proforma_rb_bGTipo; 
        }   
        
        //(employee_TextField.getText()==null)||("".equals(employee_TextField.getText()))

        if (("".equals(employee_TextField.getText()))||("".equals(fecha_TextField.getText()))||("".equals(numesa_TextField.getText()))
                ||("".equals(cliente_TextField.getText()))||("".equals(descr_TextArea.getText()))||(bG_Pago.getSelection()==null)||bG_Tipo.getSelection()==null){
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos y realizar todas las selecciones para crear la factura.");
        } else {
            if ("".equals(order_confirm)){
                order_confirm = "No se eligieron alimentos."; 
            }
            int confirm = JOptionPane.showOptionDialog(
                    null, 
                    "¿Confirmar la orden?\n\n\n"
                    +"Empleado que crea la orden:\n          "+employee_TextField.getText()+".\n\n" //
                    +"Fecha:\n          "+fecha_TextField.getText()+".\n\n" //
                    +"Número de mesa:\n          "+numesa_TextField.getText()+".\n\n" //
                    +"Cliente:\n          "+cliente_TextField.getText()+".\n\n" //
                    +"Descripción:\n          "+descr_TextArea.getText()+".\n\n" //
                    +"Método de Pago:\n          "+selection1.getText()+"\n\n" 
                    +"Tipo de orden:\n          "+selection2.getText()+"\n\n"
                    +"Órden:\n\n"+order_confirm+"\n\n"
                    +"Total: "+total+"\n"
                    +"Total c/impuestos (13%): "+(float) total*1.13+"\n"
                    +"Total c/ descuento: "+desc, 
                    "Confirme la orden",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Aceptar", "Cancelar"},
                    "Cancelar"
                    );
            if (confirm==0){   
                lcounter_2=0;
                order_confirm_2 = ""; 
                for (String[] f: order_matrix_1){
                    for (String c: f){
                        if (c!=null){
                            lcounter_2+=1; 
                            if (lcounter_2%2!=0){
                                order_confirm_2+=(c+" ");
                            } else {
                                if (lcounter_2==lcounter){
                                    order_confirm_2+=c;
                                    break; 
                                } else {
                                    order_confirm_2+=(c+", ");
                            }  
                        }
                    } else {
                        //continue
                    }
                        
                    }
                    if (lcounter_2==lcounter){
                        break; 
                    }
                }
                gananciaDiariaCalc_Label.setText(String.valueOf(ganancia_cierre));
                String temp_desc = descr_TextArea.getText().replace("\n", "\\n");
                FileWriter fw = new FileWriter("Facturas.txt", true);
                fw.write(fecha_TextField.getText()+"%"+employee_TextField.getText()+"%"+cliente_TextField.getText()
                +"%"+numesa_TextField.getText()+"%"+temp_desc+"%"+selection1.getText()+"%"+selection2.getText()+"%"+order_confirm_2+"%"+total+"%"+(total*1.13)+"%"+desc+"\n");
                fw.close();
                fac_counter+=1;
                JOptionPane.showMessageDialog(null, "La factura/proforma de "+cliente_TextField.getText()+" ha sido adicionada correctamente.");
                cierre_temp_vector = new String[11];
                cierre_temp_vector[0]=fecha_TextField.getText();
                cierre_temp_vector[1]=employee_TextField.getText();
                cierre_temp_vector[2]=cliente_TextField.getText();
                cierre_temp_vector[3]=numesa_TextField.getText();
                cierre_temp_vector[4]=temp_desc;
                cierre_temp_vector[5]=selection1.getText();
                cierre_temp_vector[6]=selection2.getText();
                cierre_temp_vector[7]=order_confirm_2;
                cierre_temp_vector[8]=String.valueOf(total);
                cierre_temp_vector[9]=String.valueOf(total*1.13);
                cierre_temp_vector[10]=String.valueOf(desc);
                cierre_matrix[cierre_matrix_counter]=cierre_temp_vector;
                cierre_matrix_counter+=1;
                if (selection2.getText()=="Factura"){
                    gananciaDiariaCalc_Label.setText(String.valueOf(ganancia_cierre+=desc));
                    ventasDiariasCalc_Label.setText(String.valueOf(ventas_diarias+=1));
                } else {
                    //Do nothing. 
                }
                
  
                //Reseteo de espacios y selecciones. 
                employee_TextField.setText("");
                cliente_TextField.setText("");
                numesa_TextField.setText("");
                descr_TextArea.setText("");
                bG_Pago.clearSelection();
                bG_Tipo.clearSelection();
                order_matrix_1 = new String[100][2];
                DefaultTableModel tablemodel = new DefaultTableModel(order_matrix_1, new String[] {"Comida", "Precio"});
                order_Table.setModel(tablemodel);
                order_Table.getColumnModel().getColumn(0).setMaxWidth(560);
                order_Table.getColumnModel().getColumn(1).setMaxWidth(50);
                menu_Table.clearSelection();
                basesDatos factura = new basesDatos();
                facturasHistorialCalc_Label.setText(String.valueOf(factura.facturaCant_lectura()));
                temp_str_addOrder=null; 
                temp_str_removeOrder=null;
            } else {
                //Continue, do nothing. 
            }
        }
        
    }
    
    private void menuPanel_buttonAction(MouseEvent me){
        homePanel.setVisible(false);
        adminPanel.setVisible(false); 
        facPanel.setVisible(false);
        menuPanel.setVisible(true);
    }
    private void facPanel_buttonAction(MouseEvent me){
        homePanel.setVisible(false); 
        menuPanel.setVisible(false); 
        adminPanel.setVisible(false); 
        facPanel.setVisible(true); 
        
    }
    private void homePanel_buttonAction(MouseEvent me){
        menuPanel.setVisible(false); 
        adminPanel.setVisible(false); 
        facPanel.setVisible(false); 
        homePanel.setVisible(true); 
    }
    private void adminPanel_buttonAction(MouseEvent me){
        if (adminPanel.isVisible()==false){
            String access = "admin";
            String selection = JOptionPane.showInputDialog(
                null, 
                "Digite la contraseña de acceso:"
            );
            try {
                if (selection.equals(access)){
                    JOptionPane.showMessageDialog(null, "Acceso permitido.");
                    homePanel.setVisible(false); 
                    menuPanel.setVisible(false); 
                    facPanel.setVisible(false); 
                    adminPanel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Acceso denegado; contraseña incorrecta.");
                }
            } catch (NullPointerException e){
                System.out.print("Nada introducido como contraseña. Cancelado."); 
            }
        }
    }
    
    //El Main a continuación se utilizó para realizar pruebas directamente con el GUI de la aplicación principal. Si se quisiera probar solo esta ventana, remover los /**/. 
    // Aplicación principal corre desde la clase GUIMain. 
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, FileNotFoundException {
            
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            GUIApp window = new GUIApp();
            window.setVisible(true);
            
}

}
