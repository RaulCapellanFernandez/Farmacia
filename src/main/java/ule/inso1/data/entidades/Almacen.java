package ule.inso1.data.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALMACEN")
public class Almacen {
	@Id
	@Column(name  = "ID_ALMACEN")
	private Integer idAlmacen;
	
	@Column(name  = "NOMBRE_PRODUCTO")
	private String nombre;
	
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	
	private String detalles;

	
	//Getters y setters generados automaticamente
	public Integer getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
}
