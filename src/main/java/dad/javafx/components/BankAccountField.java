package dad.javafx.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class BankAccountField extends HBox implements Initializable {

	// properties

	private StringProperty numeroCuenta = new SimpleStringProperty();
	
	// model

	private StringProperty numero1 = new SimpleStringProperty("");
	private StringProperty numero2 = new SimpleStringProperty("");
	private StringProperty numero3 = new SimpleStringProperty("");
	private StringProperty numero4 = new SimpleStringProperty("");
	private StringProperty numero5 = new SimpleStringProperty("");

	// view

	@FXML
	private TextField numero1Text;
	
	@FXML
	private TextField numero2Text;
	
	@FXML
	private TextField numero3Text;

	@FXML
	private TextField numero4Text;

	@FXML
	private TextField numero5Text;

	public BankAccountField() {
		super();

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BankAccountField.fxml"));
			loader.setController(this);
			loader.setRoot(this); // indicamos que esta misma clase es el nodo raíz
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		numero1Text.textProperty().bindBidirectional(numero1);
		numero2Text.textProperty().bindBidirectional(numero2);
		numero3Text.textProperty().bindBidirectional(numero3);
		numero4Text.textProperty().bindBidirectional(numero4);
		numero5Text.textProperty().bindBidirectional(numero5);

		numeroCuenta.bind(Bindings.concat(numero1, "-", numero2, "-", numero3, "-", numero4, "-", numero5));		
	}

	public final StringProperty numeroCuentaProperty() {
		return this.numeroCuenta;
	}

	public final String getNumeroCuenta() {
		return this.numeroCuentaProperty().get();
	}

	public final void setNumeroCuenta(final String numeroCuenta) {
		this.numeroCuentaProperty().set(numeroCuenta);
	}

}
