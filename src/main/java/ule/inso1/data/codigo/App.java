package ule.inso1.data.codigo;

import java.util.Date;
import java.util.List;

import ule.inso1.data.entidades.Almacen;
import ule.inso1.data.entidades.Empleado;
import ule.inso1.data.persistencia.PersistAlmacen;
import ule.inso1.data.persistencia.PersistEmpleado;

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
        
        PersistAlmacen pAlmacen = new PersistAlmacen();
        pAlmacen.save(almacen);
        
        List<Almacen> hola = pAlmacen.recuperar();
        System.out.println(hola.get(0).getNombre());
        
        
        
        //PersistEmpleado pEmpleado = new PersistEmpleado();
        //pEmpleado.save(empleado);
        //pEmpleado.remove(empleado);
        
        
        
       //List<Empleado> hola = pEmpleado.recuperar();
        //System.out.println(hola.get(0).getDni());
    }
}
