  package ule.inso1.Farmacia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ALMACENVENTA")
public class VentaAlmacen {
	
	@Id
	@Column(name = "ID_ALMACENVENTA")
	private Integer idVentaAlmacen;
	
	@Column(name = "ID_ALMACEN")
	private Integer idAlmacen;
	
	@Column(name = "ID_VENTA")
	private Integer idVenta;

	//Getters y setters generados automaticamente
	public Integer getIdVentaAlmacen() {
		return idVentaAlmacen;
	}

	public void setIdVentaAlmacen(Integer idVentaAlmacen) {
		this.idVentaAlmacen = idVentaAlmacen;
	}

	public Integer getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	
	
}
