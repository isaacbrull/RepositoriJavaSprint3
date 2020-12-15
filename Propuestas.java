/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquet1;

public class Propuestas {

	private String nompropuesta;
	private String descripciopropuesta;
	private Integer id;
	
	
	/**
	 * Els getters i els setters
	 * 
	 */
	public String getNomPropuesta() {
		return this.nompropuesta;
		
	}

	public void setNomPropuesta(String nompropuesta) {
		this.nompropuesta = nompropuesta;
		
	}

	public String getDescripcioPropuesta() {
		return this.descripciopropuesta;
		
	}

	public void setDescripcioPropuesta(String descripciopropuesta) {
		this.descripciopropuesta = descripciopropuesta;
		
	}

	public Integer getId() {
		return this.id;
		
	}
	
	public void setId(int id) {
		this.id = id;
		
	}
	
	public String toString(boolean MostrarID, boolean format) {
		
		if (format) {
			return (MostrarID ? "ID: " + this.id + ", " : "") + 
					"Nombre de la Propuesta: " + this.nompropuesta + 
					", Descripicón de la Propuesta: " + this.descripciopropuesta;
		} else {
			return (MostrarID ? "ID: " + this.id : "") + 
					" - Nombre de la Propuesta: " + this.nompropuesta + 
					"\n - Descripicón de la Propuesta: " + this.descripciopropuesta;
		}
	}
	
	public void updateProposta(String nompropuesta, String descripciopropuesta) {
		//variable es = (variable es diferent a null, pases parametre a this.loquesigue, sino s'estableix a ell mateix)
		this.nompropuesta = (nompropuesta != null ? nompropuesta : this.nompropuesta);
		this.descripciopropuesta = (descripciopropuesta != null ? descripciopropuesta : this.descripciopropuesta);
	}
	
	/**
	 * Constructor per a la classe Proposta
	 * 
	 * @param nompropuesta El nom del proposta
	 * @param descripciopropuesta El primer cognom del proposta
	 * @param id El identificador ID del proposta
	 */
	public Propuestas(String nompropuesta, String descripciopropuesta, Integer id) {
		this.nompropuesta = nompropuesta;
		this.descripciopropuesta = descripciopropuesta;
		this.id = id;
	}
}
