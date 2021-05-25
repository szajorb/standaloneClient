package sample;

import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import com.jfoenix.controls.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static String childName;
    @FXML
    private JFXHamburger hamburgerMenu;

    @FXML
    private JFXDrawer drawerMenu;
    @FXML
    private AnchorPane contentContainer;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            VBox vbox = FXMLLoader.load(getClass().getResource("sidePanel.fxml"));
            drawerMenu.setSidePane(vbox);
            for(Node node : vbox.getChildren()){
                if(node.getAccessibleText() != null){
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->{
                        Node anchorNode;
                        switch(node.getAccessibleText().toLowerCase()){
                            case "foods":
                                try {
                                    anchorNode = (Node)FXMLLoader.load(getClass().getResource("foods.fxml"));
                                    contentContainer.getChildren().setAll(anchorNode);
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                                break;
                            case "drinks":
                                try {
                                    anchorNode = (Node)FXMLLoader.load(getClass().getResource("drinks.fxml"));
                                    contentContainer.getChildren().setAll(anchorNode);
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                                break;
                            case "offers":
                                try {
                                    anchorNode = (Node)FXMLLoader.load(getClass().getResource("offers.fxml"));
                                    contentContainer.getChildren().setAll(anchorNode);
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                                break;

                        }
                    });
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburgerMenu);
        transition.setRate(-1);
        drawerMenu.open();

        hamburgerMenu.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            if(drawerMenu.isOpened()){
                drawerMenu.close();
            }else{
                drawerMenu.open();

            }
        });
    }
}
