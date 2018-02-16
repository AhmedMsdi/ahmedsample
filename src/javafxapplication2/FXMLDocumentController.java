/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import Services.ServicePub;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import entity.publicite;
import static java.awt.SystemColor.window;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


/**
 *
 * @author a7med
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private TextArea text3;
    @FXML
    private Button button;
    @FXML
    private Label label1;
    @FXML
    private Label label11;
    @FXML
    private Label label2;
    @FXML
    private TableView<publicite> Tab;
    @FXML
    private TableColumn<publicite,String > id;
    @FXML
    private TableColumn<publicite,String> titre;
    @FXML
    private TableColumn<publicite,String> desc;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private ImageView img;
      
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Ajout d'une ligne!");
        int a=Integer.parseInt(text1.getText());
        //label.setText("hi");
       // System.out.println(ch);
       ServicePub se= new ServicePub();
      se.ajouterPub(a,text2.getText(),text3.getText());
 
        afficher();
 
     
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       afficher();
        // TODO
        
    }    

    @FXML
    private void handleButton1Action(ActionEvent event) {
        System.out.println("Suppression d'une ligne !");
          ServicePub se= new ServicePub();
           int a=Integer.parseInt(text1.getText());
          se.supprimerPub(a);
           afficher();
    }
    
 /*   public ObservableList<publicite> getPub(){
        ObservableList<publicite> data = FXCollections.observableArrayList(
        new publicite(5858,"Laptop","kjl"),
        new publicite(5454,"Bouncy Ball", "lkjd")
        );
        return data;
    }*/
    
String b;
String c;
    @FXML
    private void handleButton2Action(ActionEvent event) {
        System.out.println("Pub prete a modifier !");
         ServicePub se= new ServicePub();
           int a=Integer.parseInt(text1.getText());
       
          text2.setText(se.modifierPub(a,1)); 
          
           text3.setText(se.modifierPub(a,0));
          
         
    }

    @FXML
    private void handleButton3Action(ActionEvent event) {
        System.out.println("Modification terminée !");
       ServicePub se= new ServicePub();
       int a=Integer.parseInt(text1.getText());
       se.modifier2Pub(a,text2.getText(),text3.getText());
        afficher();
    }

    @FXML
    private void handleButton4Action(ActionEvent event)throws Exception {
        Stage stage = new Stage();
       Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
      
        Scene scene = new Scene(root);
      
      stage.setScene(scene);  
        stage.show();
    }
    
    private void afficher(){
           System.out.println("Affichage du tableau !");
                ServicePub se= new ServicePub();
        //se.selectPub();
        id.setCellValueFactory(new PropertyValueFactory<publicite, String>("id_pub"));
        titre.setCellValueFactory(new PropertyValueFactory<publicite, String>("titre_pub"));
        desc.setCellValueFactory(new PropertyValueFactory<publicite, String>("description"));
        
        titre.setCellFactory(TextFieldTableCell.forTableColumn());
         titre.setOnEditCommit(
            new EventHandler<CellEditEvent<publicite, String>>() {
                @Override
                public void handle(CellEditEvent<publicite, String> t) {
                    ((publicite) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setTitre_pub(t.getNewValue());
                    String z=((publicite) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).getDescription();
                    int y=((publicite) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).getId_pub();
                    se.modifier2Pub(y, t.getNewValue(), z);
                  
                }
            }
        );
          desc.setCellFactory(TextFieldTableCell.forTableColumn());
         desc.setOnEditCommit(
            new EventHandler<CellEditEvent<publicite, String>>() {
                @Override
                public void handle(CellEditEvent<publicite, String> t) {
                    ((publicite) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setDescription(t.getNewValue());
                    String z=((publicite) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).getTitre_pub();
                    int y=((publicite) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).getId_pub();
                    se.modifier2Pub(y,z, t.getNewValue());
                  
                }
            }
        );
        
        ObservableList<publicite> data = FXCollections.observableArrayList(se.selectPub());
 Tab.setEditable(true);
     Tab.setItems(data);
    //  Tab.getColumns().addAll(id, titre, desc);
        System.out.println("Affichage terminé !");
    }


    @FXML
    private void handleButtonAction5(MouseEvent event) {
          System.out.println("Ajout d'une ligne!");
        int a=Integer.parseInt(text1.getText());
        //label.setText("hi");
       // System.out.println(ch);
       ServicePub se= new ServicePub();
      se.ajouterPub(a,text2.getText(),text3.getText());
 
        afficher();
    }
    
}
