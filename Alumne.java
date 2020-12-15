/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquet1;

public class Alumne extends Persona {

        private Integer matricula;
	
	
	/**
	 * Els getters i els setters
	 * 
	 */

        public Integer getMatricula() {
            return matricula;
        }

        public void setMatricula(Integer matricula) {
            this.matricula = matricula;
        }        
	
	public String toString(boolean MostrarID, boolean format) {
		
		if (format) {
			return (MostrarID ? "ID: " + this.getId() + ", " : "") + 
					"Nom: " + this.getNom() + 
					", Primer Cognom: " + this.getPrimerCognom() + 
					", Segon Cognom" + this.getSegonCognom() +
					", Institut: " + this.getInstitut();
		} else {
			return (MostrarID ? "ID: " + this.getId() : "") + 
					" - Nom: " + this.getNom() + 
					"\n - Primer Cognom: " + this.getPrimerCognom() + 
					"\n - Segon Cognom: " + this.getSegonCognom() +
					"\n - Institut: " + this.getInstitut();
		}
	}
	
	public void updateAlumne(String nom, String primerCognom, String segonCognom, String institut) {
		
		this.setNom(nom != null ? nom : this.getNom());
		this.setPrimerCognom((primerCognom != null ? primerCognom : this.getPrimerCognom()));
		this.setSegonCognom((segonCognom != null ? segonCognom : this.getSegonCognom()));
		this.setInstitut((institut != null ? institut : this.getInstitut()));

	}
	
	/**
	 * Constructor per a la classe Alumne
	 * 
	 * @param nom El nom del alumne
	 * @param primerCognom El primer cognom del alumne
	 * @param segonCognom El segon cognom del alumne
	 * @param id El identificador ID del alumne
	 */
	public Alumne(String nom, String primerCognom, String segonCognom, String institut, Integer id) {
            super(id, nom, primerCognom, segonCognom, institut);
		this.matricula = matricula;
	}
}
