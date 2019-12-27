package ule.inso1.data.codigo;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ule.inso1.data.entidades.Empleado;
import ule.inso1.data.persistencia.PersistEmpleado;

public class LogController {

    @FXML
    private TextField textField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button logButton;

    @FXML
    void clickEntrar(MouseEvent event) throws IOException {
    	boolean estado = compruebaEmpleado();
    	
    	if(estado) {
    		System.out.println("Esta biene");
    		//Para cerrar la ventana
    		Stage stage = (Stage) logButton.getScene().getWindow();
            stage.close();
            //Abrir nueva ventana
    		Parent root1 = FXMLLoader.load(getClass().getResource("/ule/inso1/data/interfaces/AlmacenInterfaz.fxml"));
            Scene scene2 = new Scene(root1);
            Stage satage = new Stage();
            satage.setScene(scene2);
            satage.show();
            
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Mensaje de error");
    		alert.setHeaderText("Error en el loggin");
    		alert.setContentText("Usuario o contraseña incorrectos");

    		alert.showAndWait();
    	}
    }
    
    private boolean compruebaEmpleado() {
    	String id = textField.getText();
        String contrasenia = passwordField.getText();
        
    	 List<Empleado> empleadoLista = recuperaLista();
    	 
    	for(int i  = 0;  i < empleadoLista.size(); i++) {
    		if(empleadoLista.get(i).getDni().equals(id)) {
    			if(empleadoLista.get(i).getContrasenia().contentEquals(contrasenia)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
   
    private List<Empleado> recuperaLista() {
    	PersistEmpleado pEmpleado = new PersistEmpleado();
    	List<Empleado> listaEmpleado =  pEmpleado.recuperar();
    	return listaEmpleado;
    }

}
