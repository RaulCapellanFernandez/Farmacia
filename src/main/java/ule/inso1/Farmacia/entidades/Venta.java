package ule.inso1.Farmacia.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	@Column(name = "DNI")
	private String idEmpleadoVenta;

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

	public String getIdEmpleadoVenta() {
		return idEmpleadoVenta;
	}

	public void setIdEmpleadoVenta(String idEmpleadoVenta) {
		this.idEmpleadoVenta = idEmpleadoVenta;
	}
	
}
