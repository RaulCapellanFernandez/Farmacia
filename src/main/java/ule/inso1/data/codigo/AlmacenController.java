package ule.inso1.data.codigo;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.sound.midi.Soundbank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ule.inso1.data.entidades.Almacen;
import ule.inso1.data.entidades.Empleado;
import ule.inso1.data.entidades.Venta;
import ule.inso1.data.entidades.VentaAlmacen;
import ule.inso1.data.persistencia.PersistAlmacen;
import ule.inso1.data.persistencia.PersistAlmacenVenta;
import ule.inso1.data.persistencia.PersistVenta;

public class AlmacenController implements Initializable{

	public List<Almacen> listaAlmacen;
	public PersistAlmacen pAlmacen = new PersistAlmacen();
	
	public void initialize(URL location, ResourceBundle resources) {
		
		listaAlmacen = pAlmacen.recuperar();
		
		for(int i = 0; i < listaAlmacen.size(); i++) {
			comboBox.getItems().addAll(listaAlmacen.get(i).getNombre());
			System.out.println(listaAlmacen.get(i).getIdAlmacen());
		}
	}

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
    private Button buttonBorrar;

    @FXML
    private Button buttonModificar;

    @FXML
    private Button buttonNuevo;
    
    @FXML
    private Button buttonCerrarSesion;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldCantidad;
    
    @FXML 
    private TextField textFieldPrecio;

    
    @FXML
    void clickCerrarSesion(MouseEvent event) throws IOException {
    	Stage stage = (Stage) hBoxAlmacen.getScene().getWindow();
        stage.close();
        //Abrir nueva ventana
		Parent root1 = FXMLLoader.load(getClass().getResource("/ule/inso1/data/interfaces/Loggin.fxml"));
        Scene scene2 = new Scene(root1);
        Stage satage = new Stage();
        satage.setScene(scene2);
        satage.show();
    }
    
    @FXML
    void clickAniadir(MouseEvent event) {
    	System.out.println(comboBox.getSelectionModel().getSelectedItem());
    	for(int i = 0; i < listaAlmacen.size(); i++) {
    		if(listaAlmacen.get(i).getNombre().contentEquals(comboBox.getSelectionModel().getSelectedItem())) {
    			textFieldID.setText(listaAlmacen.get(i).getIdAlmacen().toString());
    			textFieldCantidad.setText(listaAlmacen.get(i).getCantidad().toString());
    			textFieldNombre.setText(listaAlmacen.get(i).getNombre());
    			textFieldPrecio.setText(String.valueOf(listaAlmacen.get(i).getPrecio()));
    		}
    	}
    }

    @FXML
    void clickBorrar(MouseEvent event) {
    	
    	int j = 1;
    	System.out.println("BORRA");
    	
    	if(!textFieldNombre.getText().isEmpty() || !textFieldNombre.getText().isEmpty()) {
	    	for(int i = 0; i < listaAlmacen.size(); i++) {
	    		if(textFieldID.getText().equals(listaAlmacen.get(i).getIdAlmacen().toString())) {
	    			if(textFieldNombre.getText().equals(listaAlmacen.get(i).getNombre())){
	    				borrarAlmacenVentas(listaAlmacen.get(i));
	    				pAlmacen.remove(listaAlmacen.get(i));
	    				//System.out.println(listaAlmacen.get(i).getIdAlmacen());
	    				recargaComboBox();
	    				j=0;
	    			}
	    		}
	    	}
    	}
    	
    	if( j == 1) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Mensaje de error");
    		alert.setHeaderText("Error al borrar un producto");
    		alert.setContentText("El nombre o su ID no son correctos");
    		
    		alert.showAndWait();
    	}
    }

	private void borrarAlmacenVentas(Almacen almacen) {
		PersistAlmacenVenta pAlmacenVentaBorrar = new PersistAlmacenVenta();
		List<VentaAlmacen> listaVentaAlmacen = pAlmacenVentaBorrar.recuperar();
		
		for(int i = 0; i < listaVentaAlmacen.size(); i++) {
			if(listaVentaAlmacen.get(i).getAlmacen().getIdAlmacen().equals(almacen.getIdAlmacen())) {
				pAlmacenVentaBorrar.remove(listaVentaAlmacen.get(i));
			}
		}
	}

    @FXML
    void clickModificar(MouseEvent event) {
    	System.out.println("MODIFICA");
    	int j = 1;
    	
    	if(!textFieldID.getText().isEmpty()){
    		for(int i  = 0; i < listaAlmacen.size(); i++) {
    			if(listaAlmacen.get(i).getIdAlmacen().toString().equals(textFieldID.getText())) {
    				if(!textFieldNombre.getText().isEmpty() && !textFieldNombre.getText().equals(listaAlmacen.get(i).getNombre())) {
    					for(int t  = 0; t < listaAlmacen.size(); t++) {
    						if(textFieldNombre.getText().equals(listaAlmacen.get(t).getNombre())) {
    							Alert alert = new Alert(AlertType.ERROR);
    			        		alert.setTitle("Mensaje de error");
    			        		alert.setHeaderText("Error al modificar producto");
    			        		alert.setContentText("Ya hay un producto con ese nombre");
    			        		alert.showAndWait();
    			        		return;
    						}
    					}
    				}
    				if(!textFieldCantidad.getText().isEmpty())
    					listaAlmacen.get(i).setCantidad(Integer.parseInt(textFieldCantidad.getText()));
    				if(!textFieldNombre.getText().isEmpty())
    					listaAlmacen.get(i).setNombre(textFieldNombre.getText());
    				if(!textFieldPrecio.getText().isEmpty()) {
    					if(textFieldPrecio.getText().contains(",")) {
    						Alert alert = new Alert(AlertType.ERROR);
			        		alert.setTitle("Mensaje de error");
			        		alert.setHeaderText("Error al modificar producto");
			        		alert.setContentText("Utiliza . en vez de ,");
			        		alert.showAndWait();
			        		return;
    					}else
    						listaAlmacen.get(i).setPrecio(Double.parseDouble(textFieldPrecio.getText()));
    				}
    				pAlmacen.update(listaAlmacen.get(i));
    				System.out.println("hola");
    				recargaComboBox();
    				j=0;
    			}
    		}
    	}
    	
    	if( j == 1) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Mensaje de error");
    		alert.setHeaderText("Error al modificar producto");
    		alert.setContentText("No dejes el DNI vacio");
    		
    		alert.showAndWait();
    	}
    }

    @FXML
    void clickNuevo(MouseEvent event) {
    	Almacen almacen = new Almacen();
    	System.out.println("NUEVO");
    	
    	if(!textFieldID.getText().isEmpty() || !textFieldNombre.getText().isEmpty()) {
    		for(int i = 0; i < listaAlmacen.size(); i++) {
    			if(listaAlmacen.get(i).getIdAlmacen().toString().equals(textFieldID.getText()) ||
    					listaAlmacen.get(i).getNombre().equals(textFieldNombre.getText())) {
    				Alert alert = new Alert(AlertType.ERROR);
	        		alert.setTitle("Mensaje de error");
	        		alert.setHeaderText("Error al introducir producto");
	        		alert.setContentText("No puedes meter el mismo nombre o ID del producto");
	        		alert.showAndWait();
	        		return;
    				
    			}
    		}
 
	    	almacen.setIdAlmacen(Integer.parseInt(textFieldID.getText()));
	    	almacen.setNombre(textFieldNombre.getText());
	    	
	    	if(!textFieldPrecio.getText().isEmpty()) {
				if(textFieldPrecio.getText().contains(",")) {
					Alert alert = new Alert(AlertType.ERROR);
	        		alert.setTitle("Mensaje de error");
	        		alert.setHeaderText("Error al modificar producto");
	        		alert.setContentText("Utiliza . en vez de ,");
	        		alert.showAndWait();
	        		return;
				}else
					almacen.setPrecio(Double.parseDouble(textFieldPrecio.getText()));
			}
	    	
	    	if(!textFieldCantidad.getText().isEmpty())
	    		almacen.setCantidad(Integer.parseInt(textFieldCantidad.getText()));
	    	else {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("Mensaje de error");
	    		alert.setHeaderText("Error al introducir producto");
	    		alert.setContentText("No dejes campos vacios");
	    		alert.showAndWait();
	    		return;
	    	}
	    	pAlmacen.save(almacen);
	    	recargaComboBox();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Mensaje de error");
    		alert.setHeaderText("Error al introducir producto");
    		alert.setContentText("No dejes campos vacios");
    		alert.showAndWait();
    	}
    }

    @FXML
    void clickhBoxAlmacen(MouseEvent event) {

    }

    @FXML
    void clickhBoxEmpleados(MouseEvent event) throws IOException {
    	if(LogController.empleadoGlobal.getAdmin() == 1) {
			Stage stage = (Stage) hBoxAlmacen.getScene().getWindow();
	        stage.close();
	        //Abrir nueva ventana
			Parent root1 = FXMLLoader.load(getClass().getResource("/ule/inso1/data/interfaces/EmpleadoInterfaz.fxml"));
	        Scene scene2 = new Scene(root1);
	        Stage satage = new Stage();
	        satage.setScene(scene2);
	        satage.show();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Mensaje de error");
    		alert.setHeaderText("Error en Empleados");
    		alert.setContentText("Debe ser administrador para poder acceder");
    		alert.showAndWait();
		}
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
    private void recargaComboBox() {
    	comboBox.getItems().clear();
    	listaAlmacen = pAlmacen.recuperar();
    	
    	for(int i=0; i < listaAlmacen.size(); i++) {
    		comboBox.getItems().addAll(listaAlmacen.get(i).getNombre());
    		System.out.println(listaAlmacen.get(i).getNombre());
    	}
    }

}
