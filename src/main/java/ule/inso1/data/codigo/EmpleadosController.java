package ule.inso1.data.codigo;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

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
import ule.inso1.data.entidades.Empleado;
import ule.inso1.data.persistencia.PersistEmpleado;

public class EmpleadosController implements Initializable{
	
	public List<Empleado> listaEmpleado;
	public PersistEmpleado pEmpleado = new PersistEmpleado();
	
	public void initialize(URL location, ResourceBundle resources) {
		
    	listaEmpleado = pEmpleado.recuperar();
    	
    	for(int i=0; i < listaEmpleado.size(); i++) {
    		comboBox.getItems().addAll(listaEmpleado.get(i).getDni());
    		System.out.println(listaEmpleado.get(i).getDni());
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
    private TextField textFieldDNI;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldContrasenia;

    @FXML
    private TextField textFieldFecha;

    @FXML
    private CheckBox checkBoxAdmin;

    @FXML
    void clickAniadir(MouseEvent event) {
    	System.out.println(comboBox.getSelectionModel().getSelectedItem());
    	for(int i  = 0; i < listaEmpleado.size(); i++) {
    		if(listaEmpleado.get(i).getDni().equals(comboBox.getSelectionModel().getSelectedItem())) {
    			textFieldDNI.setText(listaEmpleado.get(i).getDni());
    			textFieldNombre.setText(listaEmpleado.get(i).getNombre());
    			textFieldContrasenia.setText(listaEmpleado.get(i).getContrasenia());
    			textFieldFecha.setText(listaEmpleado.get(i).getFechaContra().toString());
    			if(listaEmpleado.get(i).getAdmin() == 1)
    				checkBoxAdmin.setSelected(true);
    		}
    	}
    	
    }

    @FXML
    void clickBorrar(MouseEvent event) {
    	
    	int j  = 1;
    	System.out.println("BORRA");
    	System.out.println(listaEmpleado.size());
    	
    	if(! textFieldDNI.getText().isEmpty()) {
	    	for(int i  = 0; i < listaEmpleado.size(); i++) {
	    		if(listaEmpleado.get(i).getDni().equals(textFieldDNI.getText())) {
	    			System.out.println("------"+listaEmpleado.get(i).getDni());
	    			pEmpleado.remove(listaEmpleado.get(i));
	    			recargaComboBox();
	    			j= 0;
	    		}
	    	}
    	}
    
    	if( j == 1) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Mensaje de error");
    		alert.setHeaderText("Error al borrar empleado");
    		alert.setContentText("El DNI no es correcto");
    		
    		alert.showAndWait();
    	}
    }

    @FXML
    void clickModificar(MouseEvent event) {
    	int j  = 1;
    	System.out.println("MODIFICA");
    	System.out.println(listaEmpleado.size());
    	
    	if(! textFieldDNI.getText().isEmpty()) {
	    	for(int i  = 0; i < listaEmpleado.size(); i++) {
	    		if(listaEmpleado.get(i).getDni().equals(textFieldDNI.getText())) {
	    			
	    			if(!textFieldContrasenia.getText().isEmpty())
	    				listaEmpleado.get(i).setContrasenia(textFieldContrasenia.getText());
	    			if(!textFieldNombre.getText().isEmpty())
	    				listaEmpleado.get(i).setNombre(textFieldNombre.getText());
	    			if(checkBoxAdmin.isSelected())
	    				listaEmpleado.get(i).setAdmin(1);
    				else
    					listaEmpleado.get(i).setAdmin(0);
	    					
	    			pEmpleado.update(listaEmpleado.get(i));
	    			recargaComboBox();
	    			j= 0;
	    		}
	    	}
    	}
    
    	if( j == 1) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Mensaje de error");
    		alert.setHeaderText("Error al modificar empleado");
    		alert.setContentText("El DNI no es correcto");
    		
    		alert.showAndWait();
    	}
    }

    @FXML
    void clickNuevo(MouseEvent event) {
    	Empleado empleado = new Empleado();
    	
    	System.out.println("NUEVO");
    	
    	if(! textFieldDNI.getText().isEmpty()) {
	    	for(int i= 0; i < listaEmpleado.size(); i++) {
	    		if(listaEmpleado.get(i).getDni().equals(textFieldDNI.getText())) {
	    			System.out.println("JODEEEEER");
	    			Alert alert = new Alert(AlertType.ERROR);
	        		alert.setTitle("Mensaje de error");
	        		alert.setHeaderText("Error al introducir empleado");
	        		alert.setContentText("No puedes meter el mismo DNI");
	        		alert.showAndWait();
	        		return;
	    		}
	    	}
	    	
	    		empleado.setDni(textFieldDNI.getText());
	    	if(! textFieldNombre.getText().isEmpty())
	    		empleado.setNombre(textFieldNombre.getText());
	    	if(! textFieldContrasenia.getText().isEmpty())
	    		empleado.setContrasenia(textFieldContrasenia.getText());
	    	if(checkBoxAdmin.isSelected())
	    		empleado.setAdmin(1);
	    	else
	    		empleado.setAdmin(0);
	    	
	    	Date fecha = new Date();
	    	empleado.setFechaContra(fecha);
	    	
	    	if(!textFieldDNI.getText().isEmpty() || !textFieldNombre.getText().isEmpty() || !textFieldContrasenia.getText().isEmpty()) {
	    		pEmpleado.save(empleado);
	        	recargaComboBox();
	    	}else {
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("Mensaje de error");
	    		alert.setHeaderText("Error al introducir empleado");
	    		alert.setContentText("No dejes cambios vacios excepto la fecha");
	    		
	    		alert.showAndWait();
	    	}
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Mensaje de error");
    		alert.setHeaderText("Error al introducir empleado");
    		alert.setContentText("No dejes cambios vacios excepto la fecha");
    		
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
    void clickhBoxEmpleados(MouseEvent event) {

    }

    @FXML
    void clickhBoxVentas(MouseEvent event) {

    }

    @FXML
    void clickhBoxrealizarVentas(MouseEvent event) {

    }
    private void recargaComboBox() {
    	comboBox.getItems().clear();
    	listaEmpleado = pEmpleado.recuperar();
    	
    	for(int i=0; i < listaEmpleado.size(); i++) {
    		comboBox.getItems().addAll(listaEmpleado.get(i).getDni());
    		System.out.println(listaEmpleado.get(i).getDni());
    	}
    }

}
