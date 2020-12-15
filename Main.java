/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepositoriJavaSprint3.RepositoriJavaSprint3.RepositoriJavaSprint3;

public class Main {
    private final InputOutput IO = new InputOutput();
    private final GestionDatos DB = new GestionDatos();
    private final Menu UI = new Menu();

    /**
     * Método que inicia el programa
     * @param args
     */
    public static void main(String[] args) {
        Main programa = new Main();
        programa.inicio();
    }

    /**
     * Método con todas las sentencias necesarias para ejecutar el programa
     */
    public void inicio() {
        int opcion; // Permite introducir opciones del menú
        int posicion; // Indica en que posición se encuentra un determinado objeto de la clase Profesor
        boolean status; // Indica TRUE si encuentra alumnos/profesores al realizar una búsqueda
        String busqueda; // Almacena una palabra clave para realizar una busqueda en la clase Alumno
        String nom, nom2;

        do {
            // Menú principal
            IO.imprimir((Object[]) UI.getMenuPrincipal());
            opcion = IO.entradaNumero("Elige una opción");

            switch (opcion) {
                case 1:
                    do {
                        // Gestión Profesores
                        IO.imprimir("ADMINISTRACIÓN DE PROFESORES");
                        IO.imprimir((Object[]) UI.getMenuGestionProfesores());
                        opcion = IO.entradaNumero("Elige una opción");

                        switch (opcion) {
                            case 1:
                                // Listado completo de profesores
                                IO.imprimir("LISTADO COMPLETO DE PROFESORES");
                                DB.consultarProfesores();
                                break;
                            case 2:
                                // Alta de profesores
                                IO.imprimir("ALTA DE PROFESORES");
                                DB.altaProfesor();
                                break;
                            case 3:
                                // Modificar / Eliminar Profesores
                                IO.imprimir("MODIFICACIÓN / ELIMINACIÓN DE PROFESORES");
                                do {
                                    IO.imprimir((Object[]) UI.getMenuModificarEliminar());
                                    opcion = IO.entradaNumero("Elige una opción");

                                    switch (opcion) {
                                        case 1:
                                            // MODIFICAR
                                            do {
                                                IO.imprimirTexto("FILTRADO DE PROFESORES");
                                                IO.imprimir((Object[]) UI.getMenuFiltrado());
                                                opcion = IO.entradaNumero("Elige una opción");

                                                switch (opcion) {
                                                    case 1:
                                                        // Filtro por nombre
                                                        status = DB.consultarNombreProfesor();

                                                        // Si existe el profesor
                                                        if (status) {
                                                            posicion = DB.posicionNumColegiadoProfesor();
                                                            DB.modificarProfesor(posicion);
                                                        }
                                                        break;
                                                    case 2:
                                                        // Filtro por apellido
                                                        status = DB.consultarApellidoProfesor();

                                                        // Si existe el profesor
                                                        if (status) {
                                                            posicion = DB.posicionNumColegiadoProfesor();
                                                            DB.modificarProfesor(posicion);
                                                        }
                                                        break;
                                                    case 3:
                                                        // Filtro por instituto
                                                        status = DB.consultarInstitutoProfesor();

                                                        // Si existe el profesor
                                                        if (status) {
                                                            posicion = DB.posicionNumColegiadoProfesor();
                                                            DB.modificarProfesor(posicion);
                                                        }
                                                        break;
                                                }
                                            }
                                            while (opcion != UI.getMenuFiltrado().length); // SALIR
                                            break;
                                        case 2:
                                            // ELIMINAR
                                            do {
                                                IO.imprimirTexto("FILTRADO DE PROFESORES");
                                                IO.imprimir((Object[]) UI.getMenuFiltrado());
                                                opcion = IO.entradaNumero("Elige una opción");

                                                switch (opcion) {
                                                    case 1:
                                                        // Filtro por nombre
                                                        status = DB.consultarNombreProfesor();

                                                        // Si existe el profesor
                                                        if (status) {
                                                            posicion = DB.posicionNumColegiadoProfesor();
                                                            DB.bajaProfesor(posicion);
                                                        }
                                                        break;
                                                    case 2:
                                                        // Filtro por apellido
                                                        status = DB.consultarApellidoProfesor();

                                                        // Si existe el profesor
                                                        if (status) {
                                                            posicion = DB.posicionNumColegiadoProfesor();
                                                            DB.bajaProfesor(posicion);
                                                        }
                                                        break;
                                                    case 3:
                                                        // Filtro por Instituto
                                                        status = DB.consultarInstitutoProfesor();

                                                        // Si existe el profesor
                                                        if (status) {
                                                            posicion = DB.posicionNumColegiadoProfesor();
                                                            DB.bajaProfesor(posicion);
                                                        }
                                                        break;
                                                }
                                            }
                                            while (opcion != UI.getMenuFiltrado().length); // Atrás
                                            break;
                                    }
                                }
                                while (opcion != UI.getMenuModificarEliminar().length); // Atrás
                                break;
                        }
                    }
                    while (opcion != UI.getMenuGestionProfesores().length); // Atrás
                    break;
                case 2:
                    do {
                        // Gestión Alumnos
                        IO.imprimir("ADMINISTRACIÓN DE ALUMNOS");
                        IO.imprimir((Object[]) UI.getMenuGestionAlumnos());
                        opcion = IO.entradaNumero("Elige una opción");

                        switch (opcion) {
                            case 1:
                                // Listado de alumnos
                                IO.imprimir("LISTADO DE ALUMNOS");
                                DB.llistaAlumnes(false);
                                break;
                            case 2:
                                // Creación de alumnos
                                IO.imprimir("CREACIÓN DE ALUMNOS");
                                DB.altaAlumne();
                                break;
                            case 3:
                                // Modificar / Eliminar alumnos
                                IO.imprimir("MODIFICACIÓN / ELIMINACIÓN DE ALUMNOS");
                                do {
                                    IO.imprimir((Object[]) UI.getMenuFiltradoDos()); // Menú filtrado
                                    opcion = IO.entradaNumero("Elige una opción");

                                    if (opcion != UI.getMenuFiltradoDos().length) {
                                        IO.imprimirTexto("Introduce la palabra a buscar");
                                        busqueda = IO.insertarString();

                                        status = DB.cercarAlumnes(busqueda, opcion, true);

                                        if (status) {
                                            do {
                                                IO.imprimir((Object[]) UI.getMenuModEliminarAlumnos());
                                                opcion = IO.entradaNumero("Elige una opción");

                                                switch (opcion) {
                                                    case 1:
                                                        // Modificar
                                                        opcion = IO.entradaNumero("Introduce la ID del alumno a modificar");
                                                        DB.modificarAlumne(opcion); // Pedir ID
                                                        break;
                                                    case 2:
                                                        // Eliminar
                                                        opcion = IO.entradaNumero("Introduce la ID del alumno a eliminar");
                                                        DB.baixaAlumne(opcion);
                                                        break;
                                                }
                                            }
                                            while (opcion != UI.getMenuModEliminarAlumnos().length);
                                        }
                                    }
                                }
                                while (opcion != UI.getMenuFiltradoDos().length); // ATRÁS
                                break;
                        }
                    }
                    while (opcion != UI.getMenuGestionAlumnos().length); // ATRÁS
                    break;
                case 3:
                    // Gestión Grupos
                    do {
                        IO.imprimir((Object[]) UI.getMenuGestionGrups());
                        opcion = IO.entradaNumero("Elige una opción");

                        switch (opcion) {
                            case 1:
                                // Alta grups
                            	IO.imprimirTexto("---------Creació  grup:----------");
                            	
                            	IO.imprimirTexto("Introdueix el nom del grup");
                            	String nomG = IO.insertarString();
                            	status = false;

                                do {
                                	IO.imprimir("Cercar tutor del grup");
                                	status = DB.consultarNombreProfesor();
                                	
                                	if (status) {
                                		IO.imprimir("Escollir tutor del grup");
                                        posicion = DB.posicionNumColegiadoProfesor();
                                        DB.altaGrup(nomG, posicion);
                                        break;
                                	} else {
                                		break;
                                	}
                                	
                                } while(true);
                                continue;
                            case 2:
                                // Llistar grups
                                DB.llistarGrup();
                                continue;
                            case 3:
                                // Consultar grup
                                IO.imprimir("MODIFICACIÓN / ELIMINACIÓN DE GRUPOS");

                                IO.imprimirTexto("Introduce el nombre del grupo a buscar");
                                busqueda = IO.insertarString();

                                status = DB.consultarGrup(busqueda);

                                if (status) {
                                    do {
                                        IO.imprimir((Object[]) UI.getMenuModEliminarGrupos());
                                        opcion = IO.entradaNumero("Elige una opción");

                                        switch (opcion) {
                                            case 1:
                                                // Modificar
                                                opcion = IO.entradaNumero("Introduce la ID del grupo a modificar");
                                                DB.modificarGrup(opcion); // Pedir ID
                                                break;
                                            case 2:
                                                // Eliminar
                                                opcion = IO.entradaNumero("Introduce la ID del grupo a eliminar");
                                                DB.eliminarGrup(opcion);
                                                break;
                                        }
                                    }
                                    while (opcion != UI.getMenuModEliminarGrupos().length);
                                    opcion = 0;
                                    break;
                                }
                        }
                    }
                    while (opcion != UI.getMenuGestionGrups().length); // Atrás
                    opcion = 0;
                    break;
                    
                case 4:
                    do {
                        // Gestión Propuestas
                        IO.imprimir("ADMINISTRACIÓN DE PROPUESTAS");
                        IO.imprimir((Object[]) UI.getMenuGestionPropuestas());
                        opcion = IO.entradaNumero("Elige una opción");

                        switch (opcion) {
                            case 1:
                                // Listado de Propuestas
                                IO.imprimir("LISTADO DE PROPUESTAS");
                                DB.llistarPropostes(false);
                                break;
                            case 2:
                                // Creación de Propuestas
                                IO.imprimir("CREACIÓN DE PROPUESTAS");
                                DB.afegirProposta();
                                break;
                            case 3:
                                // Modificar / Eliminar Propuestas
                                IO.imprimir("MODIFICACIÓN / ELIMINACIÓN DE PROPUESTAS");
                                do {
                                    IO.imprimir((Object[]) UI.getMenuIdentificarPropuestas()); 
                                    opcion = IO.entradaNumero("Elige una opción");

                                    if (opcion != UI.getMenuIdentificarPropuestas().length) {
                                        IO.imprimirTexto("Introduce la palabra a buscar");
                                        busqueda = IO.insertarString();

                                        status = DB.cercarPropostes(busqueda, opcion, true);

                                        if (status) {
                                            do {
                                                IO.imprimir((Object[]) UI.getMenuModEliminarPropuestas());
                                                opcion = IO.entradaNumero("Elige una opción");

                                                switch (opcion) {
                                                    case 1:
                                                        // Modificar
                                                        opcion = IO.entradaNumero("Introduce la ID de la proposta");
                                                        DB.modificarProposta(opcion); // Pedir ID
                                                        break;
                                                    case 2:
                                                        // Eliminar
                                                        opcion = IO.entradaNumero("Introduce la ID de la proposta eliminar");
                                                        DB.baixaPropuestas(opcion);
                                                        break;
                                                }
                                            }
                                            while (opcion != UI.getMenuModEliminarPropuestas().length);
                                        }
                                    }
                                }
                                while (opcion != UI.getMenuIdentificarPropuestas().length); // ATRÁS
                                break;
                        }
                    }
                    while (opcion != UI.getMenuGestionPropuestas().length); // ATRÁS
                    break;
                case 5:
                    // Matriculas
                    do{
                        IO.imprimir("ADMINISTRACIÓN DE MATRICULAS");
                        IO.imprimir((Object[]) UI.getMenuMatriculaDesmatricula());
                        opcion = IO.entradaNumero("Elige una opción");
                        //
                        int idgrup;
                        int idalumne;
                        //Creació objectes
                        Grup grup;
                        Alumne alumne;
                        Profesor profesor;
                        String idprofesor;
                        
                        switch(opcion){
                            case 1:
                                DB.llistarGrup();
                                IO.imprimir("Escull el grup al que vols matricular: ");
                                idgrup = IO.insertarInt();
                                grup = DB.getGrup(idgrup);
                                
                                //Passem true para que llistigue ja que es boolean
                                DB.llistaAlumnes(true);
                                IO.imprimir("Escull l'alumne que vols matricular: ");
                                idalumne = IO.insertarInt();
                                alumne = DB.getAlumne(idalumne);
                                
                                if(grup != null && alumne != null){
                                   DB.afegirAlumneGrup(alumne, grup);
                                }else {
                                    IO.imprimir("Grup o alumne innexistent");
                                }
                                
                            break;
                            case 2:
                                DB.llistarGrup();
                                IO.imprimir("Escull el grup al que vols desmatricular: ");
                                idgrup = IO.insertarInt();
                                grup = DB.getGrup(idgrup);

                                IO.imprimir("Escull l'alumne que vols desmatricular: ");
                                idalumne = IO.insertarInt();
                                if(grup != null && idalumne != 0){
                                   DB.eliminarAlumneGrup(idalumne, grup);
                                }else {
                                   IO.imprimir("Grup o alumne innexistent");    
                                }    
                            break;
                            
                            case 3:
                                DB.llistarGrup();
                                IO.imprimir("Escull al grup al que vols assignar-lo: ");
                                idgrup = IO.insertarInt();
                                grup = DB.getGrup(idgrup);
                                
                                DB.consultarProfesores();
                                IO.imprimir("Escull el professor que vols assignar: ");
                                idprofesor = IO.insertarString();
                                profesor = DB.getProfesor(idprofesor);
                                
                                if(grup != null && profesor != null){
                                   DB.afegirProfessorGrup(profesor, grup);
                                }else {
                                    IO.imprimir("Grup o professor innexistent");
                                }
                            break;
                            
                            case 4:
                                DB.llistarGrup();
                                IO.imprimir("Escull el grup al que vols desassignar: ");
                                idgrup = IO.insertarInt();
                                grup = DB.getGrup(idgrup);

                                IO.imprimir("Escull al professor que vols desassignar: ");
                                idprofesor = IO.insertarString();
                                if(grup != null && idprofesor != null){
                                   DB.eliminarProfessorGrup(idprofesor, grup);
                                }else {
                                   IO.imprimir("Grup o professor innexistent");    
                                }  
                                
                            break;
                        }
                    }

                        
                while (opcion != UI.getMenuMatriculaDesmatricula().length); // ATRÁS
                break;
                
                case 6:
                    IO.imprimirTexto("Adéu");
                    break;
            }
        }
        while (opcion != UI.getMenuPrincipal().length); // Salir
    }
}
