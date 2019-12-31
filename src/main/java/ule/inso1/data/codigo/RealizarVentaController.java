package ule.inso1.data.codigo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ule.inso1.data.entidades.Venta;

public class RealizarVentaController {

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
    private TableView<Venta> tableBuy;

    @FXML
    private TableColumn<String, String> columnNombre;

    @FXML
    private TableColumn<String, String> columnPrecio;

    @FXML
    private TableColumn<String, String> columnEmpleado;

    @FXML
    void clickAniadir(MouseEvent event) {
    	VBox hola =new VBox();
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

}
