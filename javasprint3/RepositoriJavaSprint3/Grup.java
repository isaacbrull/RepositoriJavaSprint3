/*package javasprint3.RepositoriJavaSprint3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


class Grup {
	
	//Atributs de la classe Grup
	private final int MaximAlumnesGrups = 10;
	private final int MaximProfessorsGrups = 10;

	private int id;
	private String nom;
	
	private Profesor tutor;
	private Alumne[] alumneGrup = new Alumne[MaximAlumnesGrups];
	private Profesor[] professorGrup = new Profesor[MaximAlumnesGrups];
	
	//Getters i setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Alumne getAlumneGrup(Integer id) {
		for (Integer i=0;i<this.MaximProfessorsGrups;i++) {
			if (this.alumneGrup[i] != null) {
				if (this.alumneGrup[i].getId() == id) {
					return this.alumneGrup[i];
				}
				
			}
		}
		return null;
	}

	public boolean setAlumneGrup(Alumne alumne) {
		for (Integer i=0;i<this.MaximAlumnesGrups;i++) {
			if (this.alumneGrup[i] == null) {
				this.alumneGrup[i] = alumne;
				return true;
			}
		}
		return false;
	}

	public Profesor getProfessorGrup(String numColegiado) {
		for (Integer i=0;i<this.MaximProfessorsGrups;i++) {
			if (this.professorGrup[i] != null) {
				if (this.professorGrup[i].getNumColegiado() == numColegiado) {
					return this.professorGrup[i];
				}
				
			}
		}
		return null;
	}

	public boolean setProfessorGrup(Profesor professor) {
		for (Integer i=0;i<this.MaximProfessorsGrups;i++) {
			if (this.professorGrup[i] == null) {
				this.professorGrup[i] = professor;
				return true;
			}
		}
		return false;
	}
	
	public void llistarAlumnes() {
			boolean flag = false;
			
			for (Integer i=0;i<this.MaximAlumnesGrups;i++) {
				if (this.alumneGrup[i] != null) {
					if (!flag) {
						System.out.println(" - Inclou alumnes:");
					}
					System.out.println("   + " + this.alumneGrup[i].toString(true, true));
					flag = true;
				}
			}
	}
	
	public void llistarProfessors() {
		boolean flag = false;
		
		for (Integer i=0;i<this.MaximProfessorsGrups;i++) {
			if (this.professorGrup[i] != null) {
				if (!flag) {
					System.out.println(" - Inclou professors:");
				}
				System.out.println("   + " + this.professorGrup[i].toString(true, true));
			}
		}
	}
        
        public boolean eliminarProfessorGrup(String numColegiado) {
            for (Integer i=0;i<this.MaximProfessorsGrups;i++) {
                if (this.professorGrup[i] != null) {
                    if (this.professorGrup[i].getNumColegiado().equals(numColegiado)) {
                        this.professorGrup[i] = null;
                        return true;
                    }

                }
            }
            return false;
        }
        
        public boolean eliminarAlumneGrup(Integer id) {
            for (Integer i=0;i<this.MaximProfessorsGrups;i++) {
                if (this.alumneGrup[i] != null) {
                    if (this.alumneGrup[i].getId() == id) {
                        this.alumneGrup[i] = null;
                        return true;
                    }

                }
            }
        return false;
        }
	
	//Metode toString
	public String toString() {
		return ("ID: " + this.id + " Grup: " + this.nom + " Coordinat pel tutor: " + this.tutor.getNom());
	}

	//Constructor amb tots els atributs
	public Grup(String nomG, Profesor tutorG, Integer idG) {
		this.id = idG;
		this.nom = nomG;
		this.tutor = tutorG;
	}
}
*/