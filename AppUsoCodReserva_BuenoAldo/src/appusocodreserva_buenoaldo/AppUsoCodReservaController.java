/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appusocodreserva_buenoaldo;

import codreserva_buenoaldo.CodReserva;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 *
 * @author Aldobg
 */
public class AppUsoCodReservaController implements Initializable {
    
    @FXML
    private CodReserva ventanaCodReserva;
    @FXML
    private Label labelResultado;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        labelResultado.setWrapText(true);
        /*
        ventanaCodReserva.accesoProperty().addListener(new ChangeListener() {
 

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
             
                
                if((ventanaCodReserva.accesoProperty().get())){
                    
                    labelResultado.setText("Número de reserva: " + ventanaCodReserva.getNumreserva() + " Válido");
                    labelResultado.setTextFill(Color.GREEN);
                
                }else{                
                    labelResultado.setText("Número de reserva o PIN Erróneo");
                    labelResultado.setTextFill(Color.RED);
                }
            }
        });*/
            ventanaCodReserva.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if ((ventanaCodReserva.accesoProperty().get())) {

                    labelResultado.setText("Número de reserva: " + ventanaCodReserva.getNumreserva() + " Válido");
                    labelResultado.setTextFill(Color.GREEN);

                } else {
                    labelResultado.setText("Número de reserva o PIN Erróneo");
                    labelResultado.setTextFill(Color.RED);
                }
            }
        });
      
    }//fin init    
    
}//fin clase
