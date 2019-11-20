package ule.inso1.data.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="ALMACENVENTA")
public class VentaAlmacen {
	
	@Id
	@Column(name = "ID_ALMACENVENTA")
	private Integer idVentaAlmacen;
	
	@ManyToOne
	@JoinColumn(name = "ID_ALMACEN")
	private Almacen almacen;
	
	@ManyToOne
	@JoinColumn(name = "ID_VENTA")
	private Venta venta;

	//Getters y setters generados automaticamente
	public Integer getIdVentaAlmacen() {
		return idVentaAlmacen;
	}

	public void setIdVentaAlmacen(Integer idVentaAlmacen) {
		this.idVentaAlmacen = idVentaAlmacen;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}	
	
}
