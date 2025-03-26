package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*******************************************************
			 * on va charger le fichier son.
			 * on s'est aidé de: https://www.delftstack.com/fr/howto/java/javafx-media-player/ 
			 * On s'est également aperçu apres une discussion que la musique choisie
			 * initialement pouvoit etre aperçu comme satanique c'est pour cela qu'on a décidé
			 * de la changer pour eviter un quelconque soucis
			 * 
			 ****************************************************/
			String path = new File("src/son.mp3").toURI().toString();
	        Media media = new Media(path);
	        MediaPlayer mediaPlayer = new MediaPlayer(media);
	        /*pour la lecture en boucle, voici la source qui nous a inspiré
	         * https://fr.sourcetrail.com/Java/javafx/comment-boucler-le-lecteur-multim%C3%A9dia-javafx/
	         */
	        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	        mediaPlayer.play();
	        
	       //ajout d'un titre pour faire propre
	        primaryStage.setTitle("Le Pendu par MIELOT Vincent, SEWA Adjetey et ASSALI Fatima Ezzahra");
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1000,750);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
