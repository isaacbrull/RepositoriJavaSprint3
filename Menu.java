/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menu extends JFrame {
    private final String[] MENUPRINCIPAL =
            {
                    "Gestionar Professors",
                    "Gestionar Alumnes",
                    "Gestionar Grups",
                    "Gestionar Propostes",
                    "Gestionar Matricules",
                    "Sortir"
            };
    Menu (){
        final int width = 600;
        final int heigth = 500;
        this.setTitle("Programa G2 S3");//Set text nom del programa
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//comportament al tancar el programa
        this.setVisible(true);//mostrar la finestra true
        this.setSize(width,heigth); //Set tamany
        this.setResizable(false); //Set su es pot reescalar el tamany
        this.getContentPane().setBackground(new Color(255, 187, 156)); //Set color background
        ImageIcon icono = new ImageIcon("rsc/ico.png");//Crear objecte icona para el programa
        this.setIconImage(icono.getImage());//Setejar la icona del programa
        this.setLayout(null);
       this.setLocationRelativeTo(null);


    }

    public void MenuPrincipal(){


        Color bg = new Color(255, 187, 156);
       JPanel tPanel = crearPanel(bg,0,30,600,280);//Panel titol
        JPanel bPanel = crearPanel(bg,0,320,600,160); //Panel botons
        bPanel.setLayout(null);

        /*Un label es un element per a mostrar text, imatges o els dos*/
 JLabel titol = new JLabel(); //Crear una nova label amb instruccions per al programa
        //Objecte font per a importar
        try {
            /*Per a carregar la font custom tindrem que fer una classe que crearla com a un derivat de font
            usant la classe GraphicsEnvironment que conte los objectes de font disponibles per a java
            sino no la reconeix*/
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Font f = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("rsc/Title.ttf"));
            f = f.deriveFont(Font.BOLD, 24);
            titol. setFont(f); //Setejem la font
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
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
    JButton botons[] = new JButton[6];//aray de botons
        int[] botoBounds = {1,10,200,40}; //array que determina la x, la y, la width i la height en aquest ordre
    for (int i = 0,posx = 0;i<botons.length;i++){//Bucle en el que assignarem la posicio, text i tamany dels botons
        botons[i] = new JButton();
        //Si la posicio del ultim botó (determinada per la var posx) es major al tamany de la finestra
        //pasarem el proxim botó abaix
        if (((botoBounds [2]*posx)+botoBounds [0])>600) {
            if (i== botons.length-1)posx =1;
            else posx =0;
            botoBounds [1] = botoBounds [1] +botoBounds [3];
        }
        //Li assignem la seva posició i tamany a partir de la array mencionada
        botons[i].setBounds((botoBounds [2]*posx)+botoBounds [0],botoBounds [1],botoBounds [2],botoBounds [3]);
        botons[i].setText(MENUPRINCIPAL[i]);//Li assignem el text de la String array MENUPRINCIPAL
        bPanel.add(botons[i]);//Finalment afegim al panel el boto
        posx++;//i iterem la var posx per a menejar cap a la dreta la posicio deel proxim boto
    }

/* Aqui podem afegir les accions de cada botó */
//Ens podem ahorrar implementar un Action listener a la classe i  un metode usant una expressio lambda com a substitut
        botons[0].addActionListener(e ->System.out.println(MENUPRINCIPAL[0]));
        botons[1].addActionListener(e ->System.out.println(MENUPRINCIPAL[1]));
        botons[2].addActionListener(e ->System.out.println(MENUPRINCIPAL[2]));
        botons[3].addActionListener(e ->System.out.println(MENUPRINCIPAL[3]));
        botons[4].addActionListener(e ->System.out.println(MENUPRINCIPAL[4]));
        botons[5].addActionListener(e ->System.exit(0));
//---------------------------------------------------------------------

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

