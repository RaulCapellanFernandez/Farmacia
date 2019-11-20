package ule.inso1.data.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "VENTAS")
public class Venta {
	@Id
	@Column(name = "ID_VENTA")
	private Integer idVenta;
	
	@Column(name = "TOTAL_VENTA")
	private double totalVenta;
	
	@Column(name = "FECHA_VENTA")
	private Date fechaVenta;
	
	@ManyToOne
	@JoinColumn(name = "DNI")
	private Empleado empleado;

	//Getters y setters generados automaticamente
	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
