/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepositoriJavaSprint3.RepositoriJavaSprint3.RepositoriJavaSprint3;

public class Menu {
    private final String[] MENUPRINCIPAL =
            {
                    "Gestionar profesores",
                    "Gestionar alumnos",
                    "Gestionar grupos",
                    "Gestionar propuestas",
                    "Gestionar matriculas",
                    "Salir"
            };

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
    
}

