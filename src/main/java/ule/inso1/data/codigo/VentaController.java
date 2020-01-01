package ule.inso1.data.codigo;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javassist.CtField.Initializer;
import ule.inso1.data.entidades.Venta;
import ule.inso1.data.entidades.VentaAlmacen;
import ule.inso1.data.persistencia.PersistAlmacenVenta;
import ule.inso1.data.persistencia.PersistVenta;

public class VentaController implements Initializable{
	
	public void initialize(URL location, ResourceBundle resources) {
		PersistVenta pVenta = new PersistVenta();
		List<Venta> listaVentasHechas = pVenta.recuperar();
		
		PersistAlmacenVenta pAlmacenVenta = new PersistAlmacenVenta();
		List<VentaAlmacen> listaAlmacenVenta = pAlmacenVenta.recuperar();
		
		listaVentas.getItems().add("			LISTA DE TODAS LAS VENTAS");
		
		for(int i  = 0; i < listaVentasHechas.size(); i++) {
			String fecha = listaVentasHechas.get(i).getFechaVenta().toString();
			fecha = fecha.substring(0,10);
			String cadena = listaVentasHechas.get(i).getIdVenta()+"  		"+fecha+"  		"+listaVentasHechas.get(i).getTotalVenta()+"€  			"
			 		+listaVentasHechas.get(i).getEmpleado().getNombre();
			listaVentas.getItems().add(cadena);
			for(int j = 0; j < listaAlmacenVenta.size(); j++) {
				if(listaVentasHechas.get(i).getIdVenta().equals(listaAlmacenVenta.get(j).getVenta().getIdVenta())) {
					String cadena1 = listaAlmacenVenta.get(j).getVenta().getIdVenta()+"  		"+listaAlmacenVenta.get(j).getAlmacen().getNombre()+"					"
									+listaAlmacenVenta.get(j).getPrecioProd()+"€";
					listaVentas.getItems().add(cadena1);
				}
			}
		}
		
		
		
		
	}

    @FXML
    private Label idNombre;

    @FXML
    private HBox hBoxEmpleados;

    @FXML
    private HBox hBoxAlmacen;

    @FXML
    private HBox hBoxVentas;

    @FXML
    private HBox hBoxRealizarVentas;

    @FXML
    private ListView<String> listaVentas;

    @FXML
    void clickhBoxAlmacen(MouseEvent event) throws IOException {
    	Stage stage = (Stage) hBoxAlmacen.getScene().getWindow();
        stage.close();
        //Abrir nueva ventana
		Parent root1 = FXMLLoader.load(getClass().getResource("/ule/inso1/data/interfaces/AlmacenInterfaz.fxml"));
        Scene scene2 = new Scene(root1);
        Stage satage = new Stage();
        satage.setScene(scene2);
        satage.show();
    }

    @FXML
    void clickhBoxEmpleados(MouseEvent event) throws IOException {
    	Stage stage = (Stage) hBoxAlmacen.getScene().getWindow();
        stage.close();
        //Abrir nueva ventana
		Parent root1 = FXMLLoader.load(getClass().getResource("/ule/inso1/data/interfaces/EmpleadoInterfaz.fxml"));
        Scene scene2 = new Scene(root1);
        Stage satage = new Stage();
        satage.setScene(scene2);
        satage.show();
    }

    @FXML
    void clickhBoxVentas(MouseEvent event) throws IOException {
    	
    }

    @FXML
    void clickhBoxrealizarVentas(MouseEvent event) throws IOException {
    	Stage stage = (Stage) hBoxAlmacen.getScene().getWindow();
        stage.close();
        //Abrir nueva ventana
		Parent root1 = FXMLLoader.load(getClass().getResource("/ule/inso1/data/interfaces/RealizarVenta.fxml"));
        Scene scene2 = new Scene(root1);
        Stage satage = new Stage();
        satage.setScene(scene2);
        satage.show();
    }

}
