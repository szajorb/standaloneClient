package sample;

import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import com.jfoenix.controls.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private JFXHamburger hamburgerMenu;
    @FXML
    private JFXDrawer drawerMenu;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            VBox vbox = FXMLLoader.load(getClass().getResource("sidePanel.fxml"));
            drawerMenu.setSidePane(vbox);

        } catch (IOException e) {
            e.printStackTrace();
        }


        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburgerMenu);
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
