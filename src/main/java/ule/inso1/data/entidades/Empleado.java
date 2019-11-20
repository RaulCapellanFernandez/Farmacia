package ule.inso1.data.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EMPLEADOS")
public class Empleado {
	
	@Id
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "CONTRASENIA")
	private String contrasenia;
	 
	@Column(name = "FECHA_CONTRATACION")
	private Date fechaContra;
	
	@Column(name = "DNI")
	private Integer admin;

	//Getters y setters generados automaticamente
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Date getFechaContra() {
		return fechaContra;
	}

	public void setFechaContra(Date fechaContra) {
		this.fechaContra = fechaContra;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	
	
}
