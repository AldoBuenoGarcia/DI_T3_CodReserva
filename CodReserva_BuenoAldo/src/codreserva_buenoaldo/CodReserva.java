/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codreserva_buenoaldo;

import java.io.IOException;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Aldobg
 */
public class CodReserva extends VBox {

    @FXML
    private TextField labelReserva;
    @FXML
    private PasswordField passFieldPin;
    @FXML
    private Button btnIr;

    private IntegerProperty numReserva; 
    private BooleanProperty acceso;
    
    
    private ObjectProperty<EventHandler<ActionEvent>> onAction= new ObjectPropertyBase<EventHandler<ActionEvent>>(){
        @Override
        protected void invalidated(){
            setEventHandler(ActionEvent.ACTION,get());
        }
        @Override
        public Object getBean(){
            return CodReserva.this;
        }
        @Override
        public String getName(){
            return "onAction";}
    };
    /*
    
    

    Una propiedad NumReserva que contendrá el valor numérico indicado en el TextField1.

    Una propiedad Acceso booleana para indicar si se podrá realizar el acceso.

    Además de las propiedades necesarias para la vista (ya que este componente se implementará con fxml)
*/
    public CodReserva(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CodReserva.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        
        
        this.numReserva = new SimpleIntegerProperty(0);
        this.acceso = new SimpleBooleanProperty(false);
    
        btnIr.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
   
                
                long reserva = Long.parseLong(labelReserva.getText());
                int pin = Integer.parseInt(passFieldPin.getText());
                if(pin == 1928 && (reserva >= 10000001 && reserva <=19999999 && reserva != 12348765)){
                    acceso.set(true);
                    fireEvent(event);
                
                }else{
                    acceso.set(false);
                    fireEvent(event);
                }
                   
                
                
            }
        });
    }//FIN CONSTRUCTOR
    
   
    
    //GETTERS AND SETTERS
    
    
    public int getNumreserva(){

        return numReserva.get();
    }
    
    public boolean getAcceso(){
        return acceso.get();
    }
    
    public final BooleanProperty accesoProperty(){
    
        return acceso;
    } 
    
    
    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty(){
       return onAction;
   }
   public final void setOnAction(EventHandler<ActionEvent> value){
       onActionProperty().set(value);
   }
   public final EventHandler<ActionEvent>getOnAction(){
       return onActionProperty().get();
   }
   
}//FIN CLASE
