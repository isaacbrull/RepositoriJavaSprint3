/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquet1;

class Profesor extends Persona {

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
               return (MostrarID ? "Nº Colegiado: " + this.getNumColegiado() + ", " : "") + 
                               "Nombre: " + this.getNom() + 
                               ", Primer Apellido: " + this.getPrimerCognom() + 
                               ", Segundo Apellido" + this.getSegonCognom() +
                               ", Instituto: " + this.getInstitut();

       } else {
               return (MostrarID ? "Nº Colegiado: " + this.getNumColegiado() : "") + 
                               " - Nombre: " + this.getNom() + 
                               "\n - Primer Apellido: " + this.getPrimerCognom() + 
                               "\n - Segundo Apellido" + this.getSegonCognom() +
                               "\n - Instituto: " + this.getInstitut();
       }
   }  
}

