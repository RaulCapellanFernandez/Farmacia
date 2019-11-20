package ule.inso1.data.codigo;

import java.util.Date;

import ule.inso1.data.entidades.Empleado;
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
        empleado.setDni("71471266P");
        empleado.setContrasenia("HOLA");
        empleado.setNombre("Yeah");
        Date fecha = new Date();
        empleado.setFechaContra(fecha);
        empleado.setAdmin(1);
        
        PersistEmpleado pEmpleado = new PersistEmpleado();
        pEmpleado.save(empleado);
    }
}
