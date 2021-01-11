/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class GestionDatos {
    // Permiten contabilizar los objetos creados de las clases: Alumno, Profesor, Propuesta y Grupo
    private int contadorProfesor;
    private int contadorAlumne;
    private int comptadorGrups = 0;
    private int contadorProposta;

    // Scanner
    private final Scanner teclado = new Scanner(System.in);

    // Instancias de clase InputOutput (Biblioteca de E/S) y clase Menú (Almacena texto delos menús)
    private final static InputOutput IO = new InputOutput();
    private final Menu UI = new Menu();

    // Longitud máxima de arrays que almacenan objetos
    private final int MAX_PROFESORES = 10;
    private final int MAX_ALUMNES = 10;
    private final int MAXIMGRUPS = 10;
    private final int MAXIMPROPOSTES = 30;


    // Declaración de arrays
    private final Profesor[] listaProfesores = new Profesor[MAX_PROFESORES];
    private final Alumne[] listaAlumnos = new Alumne[MAX_ALUMNES];
    private final Grup[] llistatGrups = new Grup[MAXIMGRUPS];
    private final Alumne[] Alumne = new Alumne[MAXIMGRUPS];
    private final Propuestas[] Propuestas = new Propuestas[MAXIMPROPOSTES];


    // Constructor vacío con arrays inicializados para datos de muestra
    public GestionDatos() throws IOException, FontFormatException {
        // Inicializamos array con 2 objetos de tipo Profesor
        listaProfesores[0] = this.nuevoProfesor("Carles", "Poma", "Martínez", "INS Eduardo Blanco Amor","dakdla");
        listaProfesores[1] = this.nuevoProfesor("Marc", "Galicia", "Quinquilla", "INS Montsià","uauau");
        listaProfesores[2] = this.nuevoProfesor("José", "Lopo", "Rodrigo", "IES Terra Alta","idqajd");
        listaProfesores[3] = this.nuevoProfesor("Vlad", "Udos", "Notengo", "IES Deltebre", "14112");
        listaProfesores[4] = this.nuevoProfesor("Oriol", "Martínez", "Poma", "IES Deltebre","6969");
        listaAlumnos[0] = this.nouAlumne("Carlos", "Masana", "Martínez","INS Montsià");
        listaAlumnos[1] = this.nouAlumne("Pepe","Bernaltes", "Jiménez", "IES Alfacs");
        listaAlumnos[2] = this.nouAlumne("Vlad", "Udod", "","INS Montsià");
        listaAlumnos[3] = this.nouAlumne("Marc", "España", "Quinquilla","INS Montsià");
    }

    // PROFESOR

    /**
     * Método para contar el número total de Profesores creados
     *
     * @param nombre          String - nombre del profesor
     * @param primerApellido  String - primer apellido del profesor
     * @param segundoApellido String - segundo apellido del profesor
     * @param instituto       String - nombre del instituto al que pertenece el profesor
     * @param numColegiado    String - nº de identificación de cada profesor
     * @return Profesor - objeto de ese tipo
     */
    public Profesor nuevoProfesor(String nombre, String primerApellido, String segundoApellido, String instituto, String numColegiado) {
        contadorProfesor++; // Se incrementa cada vez que se crea un objeto de tipo profesor
        return new Profesor(nombre, primerApellido, segundoApellido, instituto, contadorProfesor, numColegiado);
    }
    
    public Profesor getProfesor(String numColegiado) {
        for (int i=0;i<contadorProfesor;i++) {
            if (this.listaProfesores[i] != null) {
                if (this.listaProfesores[i].getNumColegiado().equals(numColegiado)) {
                    return this.listaProfesores[i];
                }
            }
        }
        return null;

    }

    // Getters
    public int getContadorProfesor() {
        return contadorProfesor;
    }

    public int getContadorAlumne() {
        return contadorAlumne;
    }

    public int getContador() {
        return comptadorGrups;
    }

    // Setters
    public void setContador(int comptador) {
        this.comptadorGrups = comptador;
    }


    // CRUD PROFESOR

    /**
     * Método que permite dar de alta un usuario de tipo Profesor (CREATE)
     */
    public void altaProfesor() {
        String [] datos = this.obtenerDatosProfesor();
        int contador = this.contadorProfesor; // Nº total de objetos de tipo Profesor creados
        int opcion;

        // Condición para verificar si hay espacio en el array
        if (contador == MAX_PROFESORES) {
            IO.imprimir("No hay espacio disponible para crear más profesores.");
            IO.imprimirTexto("\r");
        } else {
            // Confirmación
            IO.imprimirTexto("Está seguro de guardar los cambios? ");
          //  IO.imprimir((Object[]) UI.getMenuConfirmacion());
            opcion = IO.insertarInt();

            if (opcion != 2) {
                // Añadimos nuevos valores a array de objetos de tipo Profesor
                listaProfesores[contador] = nuevoProfesor(datos[0], datos[1], datos[2], datos[3], datos[4]);
                IO.imprimirTexto("Profesor creado satisfactoriamente");
                IO.imprimir(listaProfesores[contador].toString());
                IO.imprimirTexto("\r");
            }

        }
    }

    /**
     * Método que permite consultar la lista de Profesores (READ)
     */
    public void consultarProfesores() {
        int contador = this.contadorProfesor;
        for (int i = 0; i < contador; i++) {
            System.out.println(listaProfesores[i].toString(true, true));
        }

        IO.imprimirTexto("Presiona ENTER para continuar...");
        teclado.nextLine();
    }

    /**
     * Método que permite filtrar profesores por su nombre (READ)
     *
     * @return Devuelve TRUE si se ha encontrado el Nombre
     */
    public boolean consultarNombreProfesor() {
        int contador = this.contadorProfesor;
        String busqueda;
        boolean status = false;

        IO.imprimirTexto("Introduce un nombre: ");
        busqueda = IO.insertarString().toLowerCase();

        for (int i = 0; i < contador; i++) {
            if (listaProfesores[i].getNom().toLowerCase().contains(busqueda)) {
                IO.imprimir(listaProfesores[i]);
                status = true;
            }
        }

        // Si busqueda fallida
        if (!status) {
            IO.imprimir("No se han encontrado coincidencias");
            IO.imprimirTexto("\r");
        }
        return status;
    }

    /**
     * Método que permite filtrar profesores por su apellido (READ)
     *
     * @return Devuelve TRUE si se ha encontrado el apellido
     */
    public boolean consultarApellidoProfesor() {
        int contador = this.contadorProfesor;
        String busqueda;
        boolean status = false;

        IO.imprimirTexto("Introduce un apellido: ");
        busqueda = IO.insertarString().toLowerCase();

        for (int i = 0; i < contador; i++) {
            if (listaProfesores[i].getPrimerCognom().toLowerCase().contains(busqueda) || listaProfesores[i].getSegonCognom().toLowerCase().contains(busqueda)) {
                IO.imprimir(listaProfesores[i]);
                status = true;
            }
        }

        // Si busqueda fallida
        if (!status) {
            IO.imprimir("No se han encontrado coincidencias");
            IO.imprimirTexto("\r");
        }

        return status;
    }

    /**
     * Método que permite filtrar profesores por el instituto al que pertenecen (READ)
     *
     * @return Devuelve TRUE si se ha encontrado en Instituto
     */
    public boolean consultarInstitutoProfesor() {
        int contador = this.contadorProfesor;
        String busqueda;
        boolean status = false;

        IO.imprimirTexto("Introduce el nombre de un instituto: ");
        busqueda = IO.insertarString().toLowerCase();

        for (int i = 0; i < contador; i++) {
            if (listaProfesores[i].getInstitut().toLowerCase().contains(busqueda)) {
                IO.imprimir(listaProfesores[i]);
                status = true;
            }
        }

        // Si busqueda fallida
        if (!status) {
            IO.imprimir("No se han encontrado coincidencias");
            IO.imprimirTexto("\r");
        }

        return status;
    }

    /**
     * Método que permite actualizar un profesor (UPDATE)
     *
     * @param posicion int - Indica la posición de un Profesor en el array
     */
    public void modificarProfesor(int posicion) {
        int opcion;

        if (posicion != -1) {
            String [] datos = this.obtenerDatosProfesor();

            // Confirmación
            IO.imprimirTexto("Está seguro de guardar los cambios? ");
            //IO.imprimir((Object[]) UI.getMenuConfirmacion());
            opcion = IO.insertarInt();

            if (opcion != 2) {
                listaProfesores[posicion].setNom(datos[0]);
                listaProfesores[posicion].setPrimerCognom(datos[1]);
                listaProfesores[posicion].setSegonCognom(datos[2]);
                listaProfesores[posicion].setInstitut(datos[3]);
                // Mostramos mensaje
                IO.imprimirTexto("El usuario ha sido modificado correctamente");
                IO.imprimir(listaProfesores[posicion].toString());
                IO.imprimirTexto("\r");
            }
        }
    }

    /**
     * Método que permite dar de baja un profesor (DELETE)
     *
     * @param posicion int - Indica la posición de un Profesor en el array
     */
    public void bajaProfesor(int posicion) {
        int opcion;

        // Si no hay coincidencias no se muestra el menú de confirmación
        if (posicion != -1) {
            IO.imprimirTexto("Está seguro de realizar esta operación?");
           // IO.imprimir((Object[])UI.getMenuConfirmacion());
            opcion = IO.insertarInt();

            if (opcion != 2) {
                // Permite reasignar las posiciones
                for (int i = posicion; i < (MAX_PROFESORES - 1); i++) {
                    listaProfesores[i] = listaProfesores[i + 1];
                }

                // Borramos registro
                listaProfesores[MAX_PROFESORES - 1] = null;

                // Reducimos el contador de Profesores
                contadorProfesor--;

                // Mostramos mensaje
                IO.imprimirTexto("El profesor se ha eliminado satisfactoriamente");
                IO.imprimirTexto("\r");
            }
        }
    }

    // OBTENER DATOS PARA ALTA Y MODIFICACIÓN

    /**
     * Método que permite rellenar los datos de un profesor
     *
     * @return Array con los datos de un profesor
     */
    public String[] obtenerDatosProfesor(){
        String nombre;
        String primerApellido;
        String segundoApellido;
        String instituto;
        String numColegiado;

        // Obtenemos datos
        IO.imprimirTexto("Introduce el nombre:");
        nombre = IO.validarDatosPersonales();

        IO.imprimirTexto("Introduce el primer apellido:");
        primerApellido = IO.validarDatosPersonales();

        IO.imprimirTexto("Introduce el segundo apellido:");
        segundoApellido = IO.validarDatosPersonales();

        IO.imprimirTexto("Introduce el instituto:");
        instituto = IO.validarDatosPersonales();

        IO.imprimirTexto("Introduce el nº de colegiado");
//        String numColegiado = this.validaNumColegiado(); // Validación nº único
        numColegiado = IO.validarDatosPersonales();

        return new String[]{nombre, primerApellido, segundoApellido, instituto, numColegiado};
    }

    // AVERIGUAR POSICIÓN DE UN OBJETO DETERMINADO

    /**
     * Método que permite averiguar la posición de un determinado profesor en el
     * array a través de su nº de colegiado
     *
     * @return La posición de un determinado profesor en el array de objetos
     */
    public int posicionNumColegiadoProfesor() {
        int contador = this.contadorProfesor;
        String busqueda;
        boolean status = false;
        int posicion = -1;

        busqueda = IO.entradaText("Introduce el nº de colegiado");

        for (int i = 0; i < contador; i++) {
            if (listaProfesores[i].getNumColegiado().equals(busqueda)) {
                //IO.imprimir(lista[i]);
                status = true;
                posicion = i;
            }
        }

        // Si busqueda fallida
        if (!status) {
            IO.imprimir("No se han encontrado coincidencias");
            IO.imprimirTexto("\r");
        }
        return posicion;
    }

    // MÉTODOS DE VALIDACIÓN CAMPOS PROFESOR

    /**
     * Método que permite validar que el nº de colegiado sea único
     *
     * @return cadenaNum int Devuelve un String validado de numeros
     */
    // DEPRECATED
     /*
      public String validaNumColegiado() {
        int contador = this.contadorProfesor;
        String numColegiado = IO.insertarString();

        for (int i = 0; i < contador; i++) {
            while (listaProfesores[i].getNumColegiado().equals(numColegiado)) {
                IO.imprimir("Error: El valor introducido ya se encuentra en nuestro sistema.");
                numColegiado = IO.insertarString();
            }
        }

        return numColegiado;
     }
     */
    // ALUMNOS

    /**
     * Métode pera crear nous alumnes
     *
     * @param nombre 	Nom del alumne
     * @param primerApellido 	Primer cognom del alumne
     * @param segundoApellido 	Segon cognom del alumne
     * @param instituto 		Institut del alumne
     * @return L'objecte creat
     */
    public Alumne nouAlumne(String nombre, String primerApellido, String segundoApellido, String instituto) {
        contadorAlumne++;
        return new Alumne(nombre, primerApellido, segundoApellido,instituto, contadorAlumne);
    }

    /**
     * Metode que retorna l'alumne a partir de la seva ID
     *
     * @param id	Id del alumne
     * @return 		Retorna el alumne
     */
    public Alumne getAlumne(int id) {
        for (int i=0;i<contadorAlumne;i++) {
            if (this.listaAlumnos[i] != null) {
                if (this.listaAlumnos[i].getId() == id) {
                    return this.listaAlumnos[i];
                }
            }
        }
        return null;

    }
    
    // CRUD ALUMNES

    /**
     * Metode per donar d'alta un alumne
     *
     */
    public void altaAlumne(){

        Integer contador = this.contadorAlumne;

        String nom = null;
        String primerCognom = null;
        String segonCognom = null;
        String institut = null;

        if (contador+1 <= MAX_ALUMNES) {

            IO.imprimir("Introdueix el nom");
            nom = IO.validarDatosPersonales();

            IO.imprimir("Introdueix el primer cognom");
            primerCognom = IO.validarDatosPersonales();

            IO.imprimir("Introdueix el segon cognom");
            segonCognom = IO.validarDatosPersonales();

            IO.imprimir("Introdueix el institut");
            institut = IO.validarDatosPersonales();

            listaAlumnos[contador] = nouAlumne(nom, primerCognom, segonCognom, institut);

            IO.imprimir("S'ha afegit un nou alumne");
            IO.imprimir(listaAlumnos[contador].toString(false,false));

        } else {
            IO.imprimir("No queda plaçes lliures");
        }

    }

    /**
     * Metode per a donar de baixa un alumne
     *
     * @param id	L'ID del alumne
     */
    public void baixaAlumne(Integer id){

        Integer posicio = null;

        for (int i=0;i<contadorAlumne;i++) {
            if (listaAlumnos[i] != null) {
                if (listaAlumnos[i].getId() == id) {
                    posicio = i;
                }

            }

        }


        if (posicio != null) {
            IO.imprimir("Dades del alumne");

            listaAlumnos[posicio] = null;

            IO.imprimir("S'ha donat de baixa al alumne");

        } else {
            IO.imprimir("Error: ID inexistent");
        }

    }

    /**
     * Mètode que permet modificar un alumne
     *
     * @param id	La ID del alumne que es vol modificar
     */
    public void modificarAlumne(Integer id){

        String nom = null;
        String primerCognom = null;
        String segonCognom = null;
        String institut = null;
        Integer opcio;

        Alumne alumne = getAlumne(id);

        if (alumne != null) {

            do {
                IO.imprimir("Dades del alumne");
                IO.imprimir("Nom: " + alumne.getNom(),
                        "Primer Cognom: " + alumne.getPrimerCognom(),
                        "Segon Cognom: " + alumne.getSegonCognom(),
                        "Institut: " + alumne.getInstitut(),
                        "Cancel·lar");

                IO.imprimirTexto("Escull una opció");
                opcio = IO.insertarInt();

                switch(opcio) {
                    case 1:
                        IO.imprimirTexto("Introdueix el nom");
                        nom = IO.validarDatosPersonales();
                        break;

                    case 2:
                        IO.imprimirTexto("Introdueix el primer cognom");
                        primerCognom = IO.validarDatosPersonales();
                        break;

                    case 3:
                        IO.imprimirTexto("Introdueix el segon cognom");
                        segonCognom = IO.validarDatosPersonales();
                        break;

                    case 4:
                        IO.imprimirTexto("Introdueix el institut");
                        institut = IO.validarDatosPersonales();
                        break;
                }

                alumne.updateAlumne(nom, primerCognom, segonCognom, institut);

            } while(opcio != 5);

        } else {
            IO.imprimir("Error: ID inaccessible");

        }

    }

    /**
     * Métode que permet consultar alumnes
     *
     * @param clau			Paraula clau per a cercar alumnes
     * @param filtre		El numero del filtre, 0: nom, 1: cognoms, 2: institut, 3: tot
     * @param MostrarID		Si es vol o no mostrar la id dels alumnes
     * @return				Retorna si s'ha trobat algun alumne
     */
    public boolean cercarAlumnes(String clau, int filtre, boolean MostrarID){

        Boolean resultat = false;
        Alumne alumne;

        clau = clau.toLowerCase();

        for(int i=0;i<this.contadorAlumne;i++) {

            alumne = this.listaAlumnos[i];

            if (alumne != null) {

                String nom = alumne.getNom().toLowerCase();
                String primerCognom = alumne.getPrimerCognom().toLowerCase();
                String segonCognom = alumne.getSegonCognom().toLowerCase();
                String institut = alumne.getInstitut().toLowerCase();
                String missatge = alumne.toString(MostrarID,true);

                switch(filtre) {

                    case 1:
                        if(nom.contains(clau)) {
                            IO.imprimir(missatge);
                            resultat = true;
                        }
                        break;

                    case 2:
                        if(	primerCognom.contains(clau) ||
                                segonCognom.contains(clau)) {

                            IO.imprimir(missatge);
                            resultat = true;
                        }
                        break;

                    case 3:
                        if(institut.contains(clau)) {
                            IO.imprimir(missatge);
                            resultat = true;
                        }
                        break;

                    case 4:
                        if(	nom.contains(clau) ||
                                primerCognom.contains(clau) ||
                                segonCognom.contains(clau) ||
                                institut.contains(clau)) {

                            IO.imprimir(missatge);
                            resultat = true;
                        }
                        break;
                }
            }
        }

        return resultat;
    }


    /**
     * Mostrar llistat complet d'alumnes
     *
     * @param MostrarID		Mostrar o no les ID's dels alumnes
     */
    public void llistaAlumnes(boolean MostrarID){
        for(int i = 0; i < contadorAlumne; i++){
            if (listaAlumnos[i] != null) {
                System.out.println(listaAlumnos[i].toString(MostrarID,true));
            }
        }

        IO.imprimirTexto("Presiona ENTER para continuar...");
        teclado.nextLine();
    }

    // GRUPOS

    /**
     * Métode per crear grups
     *
     */

    public int altaGrup(String nomG, Integer tutorG) {
    	if (this.comptadorGrups + 1 <= MAXIMGRUPS) {
	    	for(Integer i=0;i<MAXIMGRUPS;i++) {
	    		if (llistatGrups[i] == null) {
	    			this.comptadorGrups++;
	        		llistatGrups[i] = new Grup(nomG, listaProfesores[tutorG], comptadorGrups);
	                return i;
	        	}
	    	}
    	}

    	return -1;
       
    }

    /**
     * Métode per llistar tots els grups
     *
     */
    public void llistarGrup() {
        for (int i = 0; i < this.comptadorGrups; i++) {
        	if (llistatGrups[i] != null) {
        		IO.imprimirTexto(llistatGrups[i].toString());
        		llistatGrups[i].llistarProfessors();
        		llistatGrups[i].llistarAlumnes();
        	}
        }
    }

    
    public Grup getGrup(Integer id) {
        for (int i = 0; i < this.comptadorGrups; i++) {
        	if (llistatGrups[i] != null) {
        		 if (llistatGrups[i].getId() == id) {
                     return llistatGrups[i];
                 }
        	}
        }
        return null;
    }
    
    /**
     * Método per consultar un grup
     *
     */
    public boolean consultarGrup(String nom) {
        for (int i = 0; i < this.comptadorGrups; i++) {
        	if (llistatGrups[i] != null) {
        		 if (llistatGrups[i].getNom().equals(nom)) {
        			 System.out.println(llistatGrups[i].toString());
                     return true;
                 }
        	}
        }
        return false;
    }

    /**
     * Método per modificar el nom dels grups
     *
     */

    public void modificarGrup(Integer id) {

        String nom = null;
        Integer opcio;
        
        Grup grup = getGrup(id);

        if (grup != null) {

            do {
                IO.imprimir("Dades del grup");
                IO.imprimir("Nom: " + grup.getNom(),
                        "Cancel·lar");

                IO.imprimirTexto("Escull una opció");
                opcio = IO.insertarInt();

                switch(opcio) {
                    case 1:
                        IO.imprimirTexto("Introdueix el nom");
                        nom = IO.insertarString();
                        grup.setNom(nom);
                        break;
                }

            } while(opcio != 2);

        } else {
            IO.imprimir("Error: ID inaccessible");

        }


    }

    /**
     * Método per eliminar un grup
     *
     */

    public void eliminarGrup(Integer id){

        Integer posicio = null;

        for (int i=0;i<this.comptadorGrups;i++) {
            if (llistatGrups[i] != null) {
                if (llistatGrups[i].getId() == id) {
                    posicio = i;
                }

            }

        }


        if (posicio != null) {
            IO.imprimir("Datos del grupo");
            
            IO.imprimir(llistatGrups[posicio].toString());
            
            llistatGrups[posicio] = null;

            IO.imprimir("Se ha eliminado el grupo");

        } else {
            IO.imprimir("Error: ID inexistent");
        }

    }

    public void afegirAlumneGrup(Alumne alumne, Grup grup) {
    	
    	boolean resultat = grup.setAlumneGrup(alumne);
    	
    	if (!resultat) {
    		System.out.println("No queda plaçes per a mes alumnes en aquest grup");
    	}

    }
    
    public void afegirProfessorGrup(Profesor professor, Grup grup) {
    	
    	boolean resultat = grup.setProfessorGrup(professor);
    	
    	if (!resultat) {
    		System.out.println("No queda plaçes per a mes professors en aquest grup");
    	}

    }
    
    public void eliminarProfessorGrup(String numColegiado, Grup grup) {

        boolean resultat = grup.eliminarProfessorGrup(numColegiado);

        if (!resultat) {
            System.out.println("Professor inexistent en aquest grup");
        }

    }
    
    public void eliminarAlumneGrup(Integer id, Grup grup) {

        boolean resultat = grup.eliminarAlumneGrup(id);

        if (!resultat) {
            System.out.println("Alumne inexistent en aquest grup");
        }

    }

    //PROPOSTES

    /**
     * Métode pera crear noves propostes
     *
     * @param nom 	Nom de proposta
     * @param descripcioproposta 	descripicó proposta
     * @return L'objecte creat
     */
    public Propuestas nouProposta(String nom, String descripcioproposta) {
        contadorProposta++;
        return new Propuestas(nom, descripcioproposta, contadorAlumne);
    }

    /**
     * Metode que retorna la proposta a partir de la seva ID
     *
     * @param id	Id de la proposta
     * @return 		Retorna el proposta
     */
    public Propuestas getProposta(int id) {

        //Propuestas[i] conté el contador de propostes
        for (int i=0;i<contadorProposta;i++) {
            if (this.Propuestas[i].getId() == id) {
                return this.Propuestas[i];
            }
        }

        return null;

    }
    
    //this.contador... THIS fa referencia a l'objecte
    public void afegirProposta() {
        String nomA, descripcio;

            IO.imprimirTexto("Introdueix nom de proposta");
            nomA = IO.insertarString();
        if (this.contadorProposta + 1 <= MAXIMPROPOSTES){
            for(int i= 0;i<MAXIMPROPOSTES;i++) {
                //if(!nomA.equals(Propuestas[i].getNomPropuesta())){
                if(Propuestas[i] == null){
                descripcio = IO.entradaText("Introdueix la descripcio de la proposta");

                Propuestas[this.contadorProposta] = new Propuestas(nomA,descripcio,this.contadorProposta); 
                System.out.println("Afegit!");
                contadorProposta++;
                return;
                }else {
                    System.out.println("Error, el nom de la proposta ja esta ocupat");

                }
            }
        }
    }
    
        /**
     * Mètode que permet modificar una Propuesta
     *
     * @param id	La ID de la proposta que es vol modificar
     */
    public void modificarProposta(Integer id){

        String nompropuesta = null;
        String descripciopropuesta = null;
        Integer opcio;

        Propuestas propuestas = getProposta(id);

        if (propuestas != null) {

            do {
                IO.imprimir("Dades de la Proposta");
                IO.imprimir("Nom Proposta: " + propuestas.getNomPropuesta(),
                        "Descripció: " + propuestas.getDescripcioPropuesta(),
                        "Atras");

                IO.imprimirTexto("Escull una opció");
                opcio = IO.insertarInt();

                switch(opcio) {
                    case 1:
                        IO.imprimirTexto("Introdueix el nom Proposta");
                        nompropuesta = IO.validarDatosPersonales();
                        break;

                    case 2:
                        IO.imprimirTexto("Introdueix la nova descripcio");
                        descripciopropuesta = IO.validarDatosPersonales();
                        break;
                }

                propuestas.updateProposta(nompropuesta, descripciopropuesta);

            } while(opcio != 3);

        } else {
            IO.imprimir("Error: ID inaccessible");

        }

    }

    /**
     * Métode que permet consultar Propuestas
     *
     * @param clau			Paraula clau per a cercar propostes
     * @param filtre		El numero del filtre, 0: ID, 1: Nom
     * @param MostrarID		Si es vol o no mostrar la id de les propostes
     * @return				Retorna si s'ha trobat alguna proposta, en cas de ser false, no retorna cap resultat de l'array
     */
    public boolean cercarPropostes(String clau, int filtre, boolean MostrarID){

        Boolean resultat = false;
        Propuestas propuestas;

        clau = clau.toLowerCase();

        for(int i=0;i<this.contadorProposta;i++) {

            propuestas = this.Propuestas[i];

            if (propuestas != null) {

                String nom = propuestas.getNomPropuesta().toLowerCase();
                //String descripcio = propuestas.getDescripcioPropuesta().toLowerCase();
                //MostrarID crida a Propuestas.java la funció toString
                String missatge = propuestas.toString(MostrarID,true);
                Integer ID = propuestas.getId();

                switch(filtre) {

                    case 1:
                        if(nom.contains(clau)) {
                            IO.imprimir(missatge);
                            resultat = true;
                        }
                        break;
                }
            }
        }

        return resultat;
    }


    /**
     * Mostrar llistat complet de propostes
     *
     * @param MostrarID		Mostrar o no les ID's de les propostes
     */
    public void llistarPropostes(boolean MostrarID){
        for(int i = 0; i < contadorProposta; i++){
            if (Propuestas[i] != null) {
                System.out.println(Propuestas[i].toString(MostrarID,true));
            }
        }

        IO.imprimirTexto("Presiona ENTER para continuar...");
        teclado.nextLine();
    }
    
    public void baixaPropuestas(Integer id){

        Integer posicio = null;

        for (int i=0;i<contadorProposta;i++) {
            if (Propuestas[i] != null) {
                if (Propuestas[i].getId() == id) {
                    posicio = i;
                }

            }

        }


        if (posicio != null) {
            IO.imprimir("Proposta");

            Propuestas[posicio] = null;

            IO.imprimir("S'ha esborrat la proposta");

        } else {
            IO.imprimir("Error: ID inexistent");
        }

    }
    

    /*public void matricularAlumne(peruanofachero){
        
        
        
    }
    
    public void desmatricularAlumne(peruanofachero){
        
        
    }
    
    public void assignarProfessorGrup(peruanofachero){
        
        
    }
    
    public void eliminarProfessorGrup(peruanofachero){
        
        
    }*/

}
