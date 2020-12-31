/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private final String[] MENUPRINCIPAL =
            {
                    "Gestionar Professors",
                    "Gestionar Alumnes",
                    "Gestionar Grups",
                    "Gestionar Propostes",
                    "Gestionar Matricules",
                    "placeholder"
            };
    Menu (){
        final int width = 600;
        final int heigth = 500;
        this.setTitle("Programa G2 S3");//Set text nom del programa
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//comportament al tancar el programa
        this.setVisible(true);//mostrar la finestra true
        this.setSize(width,heigth); //Set tamany
        this.setResizable(true); //Set su es pot reescalar el tamany
        this.getContentPane().setBackground(new Color(255, 187, 156)); //Set color background
        ImageIcon icono = new ImageIcon("rsc/ico.png");//Crear objecte icona para el programa
        this.setIconImage(icono.getImage());//Setejar la icona del programa
       // this.setLayout(null);


    }

    public void MenuPrincipal(){

Color bg = new Color(255, 187, 156);
       JPanel tPanel = crearPanel(bg,0,-40,600,340);//Panel titol
        JPanel bPanel = crearPanel(Color.red,0,320,600,160); //Panel botons
        Font titolF = new Font("rsc/Title.ttf",Font.BOLD,20); //Objecte font per a importar
        /*Un label es un element per a mostrar text, imatges o els dos*/
 JLabel titol = new JLabel(); //Crear una nova label amb instruccions per al programa
        titol.setFont(titolF); //Setejem la font
 titol.setText("Benvingut, tria que vols gestionar!"); //Setejar text titol
 titol.setHorizontalTextPosition(JLabel.CENTER);//Setejar posicio del text seguit de posicio del label
 titol.setVerticalTextPosition(JLabel.TOP);
 titol.setHorizontalAlignment(JLabel.CENTER);
 titol.setVerticalAlignment(JLabel.CENTER);
 titol.setBounds(100,0,360,400);
 ImageIcon logo = new ImageIcon("rsc/logo.png");
 titol.setIcon(logo);
 tPanel.add(titol);
 // Secció botons - Un Jbutton es un botó que executa una acció quan es clicat
    int botoBounds [] = {0,120,0};
    JButton botons[] = new JButton[4];
    for (int i = 0,posx = 0;i<botons.length;i++){
        botons[i] = new JButton();

        //botons[i].setBounds((botoBounds [1]*posx),botoBounds [0],botoBounds [1],botoBounds [2]);
        botons[i].setSize(30,70);
        botons[i].setText(MENUPRINCIPAL[i]);
        if (botoBounds [1]*posx ==360) {
            posx=0;
            botoBounds [1]=50;
        }
        else posx++;
        bPanel.add(botons[i]);
    }
        this.add (bPanel);
        this.add(tPanel);//Afegim el panel a la finestra
  this.getContentPane().repaint();
  validate();
    }

    public JPanel crearPanel(Color bgColor, int x, int y, int width, int height){
        /*Un panel es un espai on inserir elements per a limitar l'espai que ocupen en un frame*/
        JPanel Panel = new JPanel();
        //Bounds i coloro de fons del panel
        Panel.setBounds(x,y,width,height);
        Panel.setBackground(bgColor);
        return Panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
/*


    private final String[] MENUGESTIONPROFESORES =
            {
                    "Listado de profesores",
                    "Creación de profesores",
                    "Modificación / Eliminación de profesores",
                    "Atrás",
            };

    private final String[] MENUGESTIONALUMNOS =
            {
                    "Listado de alumnos",
                    "Creación de alumnos",
                    "Modificación / Eliminación de alumnos",
                    "Atrás",
            };

   
    private final String[] MENUGESTIONPROPUESTAS =
            {
                    "Listado de Propuestas",
                    "Creación de Propuestas",
                    "Modificación / Eliminación de Propuestas",
                    "Atrás",
            };
    
    private final String[] MENUIDENTIFICARPROPUESTAS =
            {
                    "Nom de Proposta",
                    "Atrás"
            };
    
    private final String[] MENUMODELIMINARPROPUESTAS =
            {
                    "Modificar Propuesta",
                    "Eliminar Propuesta",
                    "Atrás"
            };

    
    private final String[] MENUMODIFICARELIMINAR =
            {
                    "Modificar profesor",
                    "Eliminar profesor",
                    "Atrás"
            };

    private final String[] MENUMODELIMINARALUMNOS =
            {
                    "Modificar alumno",
                    "Eliminar alumno",
                    "Atrás"
            };

    private final String[] MENUFILTRADO =
            {
                    "Busqueda por nombre",
                    "Busqueda por apellido",
                    "Busqueda por instituto",
                    "Atrás"
            };

    private final String[] MENUFILTRADODOS =
            {
                    "Busqueda por nombre",
                    "Busqueda por apellido",
                    "Busqueda por instituto",
                    "Busqueda por todos los campos",
                    "Atrás"
            };

    private final String[] MENUCONFIRMACION =
            {
                    "Aceptar",
                    "Cancelar"
            };

    private final String[] MENUGESTIONGRUPS =
            {
                    "Crear grups",
                    "Llistar grups",
                    "Consultar grups",
                    "Atrás"
            };
    
    private final String[] MENUMATRICULADESMATRICULA =
        {
                "Matricular Alumne",
                "Desmatricular Alumne",
                "Assignar Professor",
                "Desassignar Professor",
                "Atrás"
        };
    
    private final String[] MENUMODELIMINARGRUPOS =
            {
                    "Modificar grupo",
                    "Eliminar grupo",
                    "Atrás"
            };

    // Getters

    public String[] getMenuGestionGrups() {
        return MENUGESTIONGRUPS;
    }

    public String[] getMenuPrincipal(){
        return MENUPRINCIPAL;
    }

    public String[] getMenuGestionProfesores() {
        return MENUGESTIONPROFESORES;
    }
    
    public String[] getMenuGestionPropuestas() {
        return MENUGESTIONPROPUESTAS;
    }
    public String[] getMenuModEliminarPropuestas() {
        return MENUMODELIMINARPROPUESTAS;
    }
    public String[] getMenuIdentificarPropuestas() {
        return MENUIDENTIFICARPROPUESTAS;
    }

    public String[] getMenuModificarEliminar() { return MENUMODIFICARELIMINAR; }

    public String[] getMenuFiltrado() {
        return MENUFILTRADO;
    }

    public String[] getMenuConfirmacion() {
        return MENUCONFIRMACION;
    }

    public String[] getMenuGestionAlumnos() {
        return MENUGESTIONALUMNOS;
    }

    public String[] getMenuModEliminarAlumnos() {
        return MENUMODELIMINARALUMNOS;
    }

    public String[] getMenuFiltradoDos() {
        return MENUFILTRADODOS;
    }
    public String[] getMenuModEliminarGrupos() {
        return MENUMODELIMINARGRUPOS;
    }

    public String[] getMenuMatriculaDesmatricula() {
        return MENUMATRICULADESMATRICULA;
    }
  */
}

