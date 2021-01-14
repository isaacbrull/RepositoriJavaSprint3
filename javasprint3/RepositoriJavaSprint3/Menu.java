package javasprint3.RepositoriJavaSprint3.javasprint3.RepositoriJavaSprint3;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Menu extends JFrame {
    Color bg = new Color(255, 187, 156);//Color de fons
    JPanel tPanel = crearPanel(bg,0,30,600,280);//Panel titol
    JPanel bPanel = crearPanel(bg,50,320,500,160); //Panel botons
    /*Un label es un element per a mostrar text, imatges o els dos*/
    JLabel titol = new JLabel(); //Crear una nova label amb instruccions per al programa
    //Objecte font per a importar

    Font f = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("rsc/Title.ttf"));
    //Array de botons
    JButton[] botons;


    private final String[] MENUPRINCIPAL = {"Gestionar Professors","Gestionar Alumnes","Gestionar Grups",
                    "Gestionar Propostes","Gestionar Matricules", "Sortir"};

    private final String[] MENUGESTIONARPROFESSORS = {"Llistar Professors","Creació de Professors",
            "Modificar","Eliminar Professors", "Tornar"};
    private final String[] MENUGESTIONARALUMNES = {"Listar Alumnes","Crear Alumnes","Modificar Alumnes",
            "Eliminar Alumnes","Tornar"};

    private final String[] MENUGESTIONARGRUPS ={"Crear grups","Llistar grups","Consultar grups","Tornar"};


    private final String[] MENUGESTIONARPROPOSTES = {"Listar Propostes","Crear  Propostes","Modificar Propostes",
                    "Eliminar Propostes","Tornar"};
    private final String[] MENUGESTIOMATRICULES ={"Matricular Alumne","Desmatricular Alumne","Assignar Professor",
                    "Desassignar Professor","Tornar"};
    private final String []crearForm = {"Crear", "Tornar"};
    private final GestorDades gestor = new GestorDades();

    Menu () throws IOException, FontFormatException {
        final int width = 600;
        final int heigth = 500;
        this.setTitle("Programa G2 S3");//Set text nom del programa
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//comportament al tancar el programa
        this.setSize(width,heigth); //Set tamany
        this.setResizable(true); //Set su es pot reescalar el tamany
        this.getContentPane().setBackground(bg); //Set color background
        ImageIcon icono = new ImageIcon("javasprint3/RepositoriJavaSprint3/rsc/ico.png");//Crear objecte icona para el programa
        this.setIconImage(icono.getImage());//Setejar la icona del programa
        this.setLayout(null);
       this.setLocationRelativeTo(this);
        this.setVisible(true);//mostrar la finestra true

    }

    public void MenuPrincipal(){
        bPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            /*Per a carregar la font custom tindrem que fer una classe que crearla com a un derivat de font*/
            f = f.deriveFont(Font.BOLD, 24);
            titol.setFont(f); //Setejem la font
 titol.setText("Benvingut, tria que vols gestionar!"); //Setejar text titol
 titol.setHorizontalTextPosition(JLabel.CENTER);//Setejar posicio del text seguit de posicio del label
 titol.setVerticalTextPosition(JLabel.TOP);
 titol.setHorizontalAlignment(JLabel.CENTER);
 titol.setVerticalAlignment(JLabel.CENTER);
 titol.setBounds(100,0,360,400);
 ImageIcon logo = new ImageIcon("javasprint3/RepositoriJavaSprint3/rsc/logo.png");
 titol.setIcon(logo);
 tPanel.add(titol);
 // Secció botons - Un Jbutton es un botó que executa una acció quan es clicat
    botons = new JButton[MENUPRINCIPAL.length];//aray de botons
    for (int i = 0;i<botons.length;i++){//Bucle en el que assignarem la posicio, text i tamany dels botons
        botons[i] = new JButton();
        botons[i].setText(MENUPRINCIPAL[i]);//Li assignem el text de la String array MENUPRINCIPAL
        bPanel.add(botons[i]);//Finalment afegim al panel el boto

    }
/* Aqui podem afegir les accions de cada botó*/
        //Gestionar Professors
        botons[0].addActionListener(e -> {
            clearFrame();//Limpiem la pantalla de elements
            ImageIcon ico = new ImageIcon("javasprint3/RepositoriJavaSprint3/rsc/teacher.png");//carreguem la imatge de logo
            //Invoquem el metode crearMenu i passem per parametre les caracteristiques del nostre menú

             crearMenu("Gestionar Professors",ico,MENUGESTIONARPROFESSORS);//Titol,logo,Text dels botons
            //Secció de botons
                //Boto llistar Professors
                    botons[0].addActionListener(a -> {llistarForm("Llistat de Professors");});
                //Boto Crear Professors
                    botons[1].addActionListener(a -> {
                        //JTextfield = Un element de GUI que es una caixa de text on podem setejar, afegir o agafar text.
                        crearForm("Donar d'alta Professor",new String[] {"Nom: ","Primer Cognom: ", "Segon Cognom: ",
                        "Institut: ", "Nombre Colegiat"},new String[]{"Donar d'Alta", "Tornar"});
                    });
            //Assignem l'accio de llimpiar la pantalla i reimprimir el menu principal al ultim botó, el de "Sortir"
            botons[botons.length-1].addActionListener(a -> {
                    clearFrame();
                    MenuPrincipal();
            });

        });
        //Gestionar Alumnes
        botons[1].addActionListener(e -> {
            clearFrame();
            ImageIcon ico = new ImageIcon("javasprint3/RepositoriJavaSprint3/rsc/alumne.png");
            crearMenu("Gestionar Alumnes",ico,MENUGESTIONARALUMNES);
            botons[botons.length-1].addActionListener(a -> {
                clearFrame();
                MenuPrincipal();
            });

        });
        //---------------------------------------------
        //Gestionar Grups
        botons[2].addActionListener(e -> {
            clearFrame();
            ImageIcon ico = new ImageIcon("javasprint3/RepositoriJavaSprint3/rsc/grup.png");
            crearMenu("Gestionar Grups",ico,MENUGESTIONARGRUPS);
            botons[botons.length-1].addActionListener(a -> {
                clearFrame();
                MenuPrincipal();
            });

        });
        //Gestionar Propostes
        botons[3].addActionListener(e -> {
            clearFrame();
            ImageIcon ico = new ImageIcon("javasprint3/RepositoriJavaSprint3/rsc/proposta.png");
            crearMenu("Gestionar Propostes",ico,MENUGESTIONARPROPOSTES);
            botons[botons.length-1].addActionListener(a -> {
                clearFrame();
                MenuPrincipal();
            });

        });
        //Gestionar Matricules
        botons[4].addActionListener(e -> {
            clearFrame();
            ImageIcon ico = new ImageIcon("javasprint3/RepositoriJavaSprint3/rsc/matricula.png");
            crearMenu("Gestionar Matrícules",ico,MENUGESTIOMATRICULES);
            botons[botons.length-1].addActionListener(a -> {
                clearFrame();
                MenuPrincipal();
            });

        });
        //Tancar el programa
        botons[5].addActionListener(e ->System.exit(0));
//---------------------------------------------------------------------

        this.add (bPanel);
        this.add(tPanel);//Afegim el panel a la finestra
        this.getContentPane().repaint();
        validate();
    }
    /**
     * Metode per a crear panells de forma senzilla
     * @param bgColor : Objecte color per a definir color de fons
     * @param x : pos x
     * @param y : pos y
     * @param height: altura en px
     * @param width : llargaria en px**/
    public JPanel crearPanel(Color bgColor, int x, int y, int width, int height){
        /*Un panel es un espai on inserir elements per a limitar l'espai que ocupen en un frame*/
        JPanel Panel = new JPanel();
        //Bounds i coloro de fons del panel
        Panel.setBounds(x,y,width,height);
        Panel.setBackground(bgColor);
        return Panel;
    }

/**Metode per a carregar Menús li posem el titol, imatge, array de text amb el
 text dels botons i podrem generar un  menu simple
 @param Titol: String amb el titol de caoçalera del menú
 @param logo: Objecte ImageIcon que carregara la imatge logo del menú
 @param Botons : Array String amb el text que contindran els botons, util també per a contar quants botons hi hauran
                al menú.
 **/
    public void crearMenu (String Titol, ImageIcon logo, String [] Botons){
        JLabel titol = new JLabel();
        f = f.deriveFont(Font.BOLD, 24);
        titol. setFont(f);
        titol.setText(Titol);
        titol.setIcon(logo);
        tPanel.add(titol);
        botons = new JButton[Botons.length];
        for (int i = 0;i<botons.length;i++){
            botons[i] = new JButton();
            botons[i].setText(Botons[i]);
            bPanel.add(botons[i]);
        }
        this.add (bPanel);
        this.add(tPanel);//Afegim el panel a la finestra
        this.getContentPane().repaint();
        validate();
        tPanel.setVisible(true);
        bPanel.setVisible(true);
    }

    //Metodo aixi de gratis per a llimpiar la pantalla
    public void clearFrame(){
        tPanel.removeAll();
        bPanel.removeAll();
    }

    public void crearForm(String Titol, String [] text, String [] botonstxt){
        clearFrame();
        titol.setText(Titol);
        //Bounds i coloro de fons del panel
        titol.setHorizontalTextPosition(JLabel.CENTER);//Setejar posicio del text seguit de posicio del label
        titol.setVerticalTextPosition(JLabel.TOP);
        titol.setHorizontalAlignment(JLabel.CENTER);
        titol.setVerticalAlignment(JLabel.TOP);
        titol.setBounds(100,0,360,100);
        f = f.deriveFont(Font.BOLD, 24);
        titol.setFont(f); //Setejem la font
        tPanel.add(titol);
        bPanel.setBounds(200,100,200,300);
        bPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //Afegir textfields + labels
        JLabel [] labels = new JLabel[text.length];
        JTextField [] textField = new JTextField [text.length];
        for (int i=0; i<textField.length;i++){
            labels[i] = new JLabel();
            labels[i].setText(text[i]);
            textField[i] = new JTextField(15);
            bPanel.add(labels[i]);
            bPanel.add(textField[i]);
        }
        for (int i= 0; i<botonstxt.length; i++){
            botons[i] = new JButton();
            botons[i].setText(botonstxt[i]);
            bPanel.add(botons[i]);
        }
        this.getContentPane().repaint();
        validate();
        tPanel.setVisible(true);
        bPanel.setVisible(true);
    }

    public void llistarForm(String Titol){
        clearFrame();
        titol.setText(Titol);
        titol.setHorizontalTextPosition(JLabel.CENTER);//Setejar posicio del text seguit de posicio del label
        titol.setVerticalTextPosition(JLabel.TOP);
        titol.setHorizontalAlignment(JLabel.CENTER);
        titol.setVerticalAlignment(JLabel.TOP);
        titol.setBounds(100,0,360,100);
        f = f.deriveFont(Font.BOLD, 24);
        titol.setFont(f); //Setejem la font
        tPanel.add(titol);
        bPanel.setBounds(120,180,360,300);
        JTextArea llista = new JTextArea(4, 30);
        llista.setEditable(false); // set textArea non-editable
        JScrollPane scroll = new JScrollPane(llista);//Afegim barra de scroll
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        StringBuilder print = new StringBuilder();
        ArrayList <Profesor> profes = gestor.getProfessors();
        for (Profesor profe : profes) {
            print.append(profe.toString(true, false));
        }
        //Afegim Textarea al mig
        llista.setText(print.toString());
        bPanel.add(llista);
        bPanel.add(scroll);
        bPanel.setBorder(new TitledBorder(new EtchedBorder(), "Llistat"));

        this.getContentPane().repaint();
        validate();
        tPanel.setVisible(true);
        bPanel.setVisible(true);
    }
/*


;


    
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



    
    private final String[] MENUMODELIMINARGRUPOS =
            {
                    "Modificar grupo",
                    "Eliminar grupo",
                    "Atrás"
            };

  */
}

