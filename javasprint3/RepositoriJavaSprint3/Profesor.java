package javasprint3.RepositoriJavaSprint3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class Profesor extends Persona {
    //inizialitzem una array de professors y posems alguns de exemple



    // Atributos de la clase
    private String numColegiado;

    // Constructor vacío
    public Profesor(String nom, String primerCognom, String segonCognom, String institut, Integer id, String numColegiado) {
            super(id, nom, primerCognom, segonCognom, institut);
                this.numColegiado = numColegiado;
    }


    // Getters & Setters

    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }
    
    // Método toString
    public String toString(boolean MostrarID, boolean format) {

       if (format) {
               return (MostrarID ? "Nº Colegiat: " + this.getNumColegiado() + ", " : "") +
                               "Nom: " + this.getNom() +
                               ", Primer Cognom: " + this.getPrimerCognom() +
                               ", Segon Cognom: " + this.getSegonCognom() +
                               ", Institut: " + this.getInstitut();

       } else {
               return (MostrarID ? " - Nº Colegiat: " + this.getNumColegiado()+"\n" : "") +
                               " - Nom: " + this.getNom() +
                               "\n - Primer Cognom: " + this.getPrimerCognom() +
                               "\n - Segundo Cognom" + this.getSegonCognom() +
                               "\n - Institut: " + this.getInstitut()
                                +"\n:-------------------------------------------------------:\n";
       }
   }
}

