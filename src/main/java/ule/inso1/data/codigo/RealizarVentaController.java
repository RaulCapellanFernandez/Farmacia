package ule.inso1.data.codigo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ule.inso1.data.entidades.Almacen;
import ule.inso1.data.entidades.Venta;
import ule.inso1.data.entidades.VentaAlmacen;
import ule.inso1.data.persistencia.PersistAlmacen;

public class RealizarVentaController implements Initializable {
	
	private List<Almacen> listaAlmacen;
    private PersistAlmacen pAlmacen = new PersistAlmacen();
    private List<VentaAlmacen> listaComprar;
    
    ObservableList<Aux> lista = FXCollections.observableArrayList(
    		new Aux("COME PITOS", "Nabo", "Picha"),
    		new Aux("Rabo", "Nabo", "Picha"),
    		new Aux("Rabo", "Nabo", "Picha")
    );


    
    public void initialize(URL location, ResourceBundle resources) {
		
		listaAlmacen = pAlmacen.recuperar();
		listVenta.getItems().add("POLLAA");
				
		for(int i = 0; i < listaAlmacen.size(); i++) {
			comboBox.getItems().addAll(listaAlmacen.get(i).getNombre());
			System.out.println(listaAlmacen.get(i).getIdAlmacen());
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
    private ComboBox<String> comboBox;

    @FXML
    private Button buttonAniadir;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonComprar;

    @FXML
    private Button buttonBorrar;

    @FXML
    private Label labelItems;

    @FXML
    private ListView<String> listVenta;
    
    @FXML
    private Label labelTotal;
    
    private Integer contador = 0;
    private double totalCompra = 0;
    
    @FXML
    void clickAniadir(MouseEvent event) {
    	for(int i = 0; i < listaAlmacen.size(); i++) {
    		if(listaAlmacen.get(i).getNombre().equals(comboBox.getSelectionModel().getSelectedItem())) {
    			String intro = listaAlmacen.get(i).getNombre()+"              "+listaAlmacen.get(i).getPrecio()+"              "+
				LogController.empleadoGlobal.getNombre();
    			//Lista para el ListView
    			listVenta.getItems().add(intro);
    			//Añade al label de items en la cesta
    			contador++;
    			labelItems.setText(contador.toString());
    			//Para saber el total de la compra
    			totalCompra = totalCompra + listaAlmacen.get(i).getPrecio();
    			labelTotal.setText("Total................. "+totalCompra+"  €");
    		}
    	}
    }

    @FXML
    void clickBorrar(MouseEvent event) {

    }
 
    @FXML
    void clickNuevo(MouseEvent event) {

    }

    @FXML
    void clickhBoxAlmacen(MouseEvent event) {

    }

    @FXML
    void clickhBoxEmpleados(MouseEvent event) {

    }

    @FXML
    void clickhBoxVentas(MouseEvent event) {

    }

    @FXML
    void clickhBoxrealizarVentas(MouseEvent event) {

    }
    
    public ObservableList<Almacen> getProductos(){
    	ObservableList<Almacen> listaTabla = FXCollections.observableArrayList(); 
    	
    	for(int i = 0; i < listaAlmacen.size(); i++) {
    		listaTabla.add(listaAlmacen.get(i));
    	}
    	
    	return listaTabla;
    }

}














