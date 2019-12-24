package ule.inso1.data.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LogControlador {
	@FXML
    private Label label;
	
	@FXML
    private JFXTextField idLog;

    @FXML
    private JFXPasswordField pasLog;


    @FXML
    private void handleClose(ActionEvent event) {
       System.exit(0);
    }
    
}
