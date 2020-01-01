package ule.inso1.data.codigo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ule.inso1.data.entidades.Almacen;
import ule.inso1.data.entidades.Venta;
import ule.inso1.data.entidades.VentaAlmacen;
import ule.inso1.data.persistencia.PersistAlmacen;
import ule.inso1.data.persistencia.PersistAlmacenVenta;
import ule.inso1.data.persistencia.PersistVenta;

public class RealizarVentaController implements Initializable {
	
	private List<Almacen> listaAlmacen;
    private PersistAlmacen pAlmacen = new PersistAlmacen();
    
    public void initialize(URL location, ResourceBundle resources) {
    	buttonBorrar.setVisible(false);

		listaAlmacen = pAlmacen.recuperar();
		listVenta.getItems().add("	LISTA DE PRODUCTOS A COMPRAR");
				
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
    private ArrayList<Almacen> listAlmacenPersistir = new ArrayList<Almacen>();
    PersistAlmacenVenta pAlmacenVenta = new PersistAlmacenVenta();
    
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
    			//Productos que hay que persistir
    			listAlmacenPersistir.add(listaAlmacen.get(i));
    		}
    	}
    }

    @FXML
    void clickBorrar(MouseEvent event) {
    }
 
    @FXML
    void clickCancel(MouseEvent event) {
    	listVenta.getItems().clear();
    	listVenta.getItems().add("	LISTA DE PRODUCTOS A COMPRAR");
    	totalCompra = 0;
    	labelTotal.setText("Total................. "+totalCompra+"  €");
    	contador = 0;
    	labelItems.setText(contador.toString());
    	listAlmacenPersistir.clear();
    }

    @FXML
    void clickComprar(MouseEvent event) throws InterruptedException {
    	PersistVenta pVenta = new PersistVenta();
    	VentaAlmacen vAlmacenVenta = new VentaAlmacen();
    	Venta venta = new Venta();
    	Venta ventaAux = new Venta();
    	
    	//Venta que vamos a persistir
    	Date fecha = new Date();
    	venta.setEmpleado(LogController.empleadoGlobal);
    	venta.setFechaVenta(fecha);
    	venta.setTotalVenta(totalCompra);
    	if(listAlmacenPersistir.isEmpty()) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Mensaje de error");
    		alert.setHeaderText("Error en la compra");
    		alert.setContentText("Introduce algun articulo en la cesta");

    		alert.showAndWait();
    	}else {
	    	pVenta.save(venta);
	    	//Persistir cada producto de la compra
	    	List<Venta> listaVentaAux = pVenta.recuperar();
			ventaAux = listaVentaAux.get(listaVentaAux.size()-1);
	
			for(int i = 0; i < listAlmacenPersistir.size(); i++) {
				
				vAlmacenVenta = new VentaAlmacen();
				vAlmacenVenta.setVenta(ventaAux);
				vAlmacenVenta.setPrecioProd(listAlmacenPersistir.get(i).getPrecio());
				vAlmacenVenta.setAlmacen(listAlmacenPersistir.get(i));
				pAlmacenVenta.save(vAlmacenVenta);			
			}
			
			
			//Borra todo para realizar otra compra
			listVenta.getItems().clear();
	    	listVenta.getItems().add("	LISTA DE PRODUCTOS A COMPRAR");
	    	totalCompra = 0;
	    	labelTotal.setText("Total................. "+totalCompra+"  €");
	    	contador = 0;
	    	labelItems.setText(contador.toString());
	    	listAlmacenPersistir.clear();
	    	
	    	//Mensaje de confirmacion
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Mensaje de informacion");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Compra realizada con exito");

	    	alert.showAndWait();
    	}
    }


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
    	Stage stage = (Stage) hBoxAlmacen.getScene().getWindow();
        stage.close();
        //Abrir nueva ventana
		Parent root1 = FXMLLoader.load(getClass().getResource("/ule/inso1/data/interfaces/Ventas.fxml"));
        Scene scene2 = new Scene(root1);
        Stage satage = new Stage();
        satage.setScene(scene2);
        satage.show();
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