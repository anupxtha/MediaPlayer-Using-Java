/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Anup-Xtha
 */
public class MediaPlayerFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private String filePath;
    private MediaPlayer mediaPlayer;
    
    @FXML
    private MediaView mediaView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButton(ActionEvent event) {
        
//        System.out.print("Hello World");
        try{
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file (*.mp4)", "*.mp4");
                fileChooser.getExtensionFilters().add(filter);
                File file = fileChooser.showOpenDialog(null);
                
                    if(file != null){
                        
                        filePath = file.toURI().toString();
                        Media med = new Media(filePath);
                        
                        if(mediaPlayer != null){
                            mediaPlayer.dispose();
                        }
                        
                        mediaPlayer = new MediaPlayer(med);
                        mediaView.setMediaPlayer(mediaPlayer);
                        
                                DoubleProperty mvw = mediaView.fitWidthProperty();
                                DoubleProperty mvh = mediaView.fitHeightProperty();
                                mvw.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
                                mvh.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height")); 
                                mediaView.setPreserveRatio(true);
                            
                           
                        mediaPlayer.play();
                    }
                    else{
                        System.out.println("File is not Selected");
                    }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
