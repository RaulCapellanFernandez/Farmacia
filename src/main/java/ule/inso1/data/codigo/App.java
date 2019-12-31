package ule.inso1.data.codigo;

import java.util.Date;
import java.util.List;

import ule.inso1.data.entidades.Almacen;
import ule.inso1.data.entidades.Empleado;
import ule.inso1.data.entidades.Venta;
import ule.inso1.data.entidades.VentaAlmacen;
import ule.inso1.data.persistencia.PersistAlmacen;
import ule.inso1.data.persistencia.PersistAlmacenVenta;
import ule.inso1.data.persistencia.PersistEmpleado;
import ule.inso1.data.persistencia.PersistVenta;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Empleado empleado = new Empleado();
        Date fecha = new Date();
        
        empleado.setDni("3");
        empleado.setContrasenia("HOLA");
        empleado.setNombre("Yeah");
        empleado.setFechaContra(fecha);
        empleado.setAdmin(1);
        
        Almacen almacen = new Almacen();
        almacen.setCantidad(20);
        almacen.setIdAlmacen(5);
        almacen.setNombre("Condones");
        almacen.setPrecio(12.12);
        
        Venta venta = new Venta();
        venta.setEmpleado(empleado);
        venta.setFechaVenta(fecha);
        venta.setTotalVenta(12.12);
        venta.setIdVenta(1);
        
        VentaAlmacen vAlmacen = new VentaAlmacen();
        vAlmacen.setAlmacen(almacen);
        vAlmacen.setVenta(venta);
        vAlmacen.setPrecioProd(12.23);
       
        
        /*PersistAlmacen pAlmacen = new PersistAlmacen();
        pAlmacen.save(almacen);
        
        PersistEmpleado pEmpleado = new PersistEmpleado();
        pEmpleado.save(empleado);
        
        
        PersistVenta pventa = new PersistVenta();
        pventa.save(venta);
        List<Venta> listaVentas = pventa.recuperar();
        System.out.println(listaVentas.get(0).getTotalVenta());*/
        
       PersistAlmacenVenta pAlmacenVenta = new PersistAlmacenVenta();
       //pAlmacenVenta.save(vAlmacen);
       List<VentaAlmacen> listaVAlmacen = pAlmacenVenta.recuperar();
       System.out.println( listaVAlmacen.get(0).getAlmacen().getNombre());

    }
}
