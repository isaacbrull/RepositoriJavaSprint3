/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepositoriJavaSprint3.RepositoriJavaSprint3.RepositoriJavaSprint3;

public class Persona {
    private Integer id;
    private String nom;
    private String primerCognom;
    private String segonCognom;
    private String institut;



    public Persona(Integer id, String nom, String primerCognom, String segonCognom, String institut) {
        this.id = id;
        this.nom = nom;
        this.primerCognom = primerCognom;
        this.segonCognom = segonCognom;
        this.institut = institut;
    }
    //@Override
    public String toString(boolean MostrarID, boolean format){
        return null; 
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrimerCognom() {
        return primerCognom;
    }

    public void setPrimerCognom(String primerCognom) {
        this.primerCognom = primerCognom;
    }

    public String getSegonCognom() {
        return segonCognom;
    }

    public void setSegonCognom(String segonCognom) {
        this.segonCognom = segonCognom;
    }

    public String getInstitut() {
        return institut;
    }

    public void setInstitut(String institut) {
        this.institut = institut;
    }
}