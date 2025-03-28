package controleur;

import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;

//import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
//import javafx.scene.image.Image;

public class ControleurIntroduction {
	@FXML Button boutonJouer;
	@FXML Button boutonQuitter;
	@FXML Button boutonRegles;
	@FXML Button boutonParametres;
	@FXML Button boutonCp;
	@FXML Button boutonAnnulerAvatar;
	ImageView imagesRegles = new ImageView();

	
	@FXML
	public void initialize() {
		
	}
	
	/****************************************************************************************************
	 * 
	 * gestion du bouton quitter, pour la methode:
	 * Plateform.exit() 
	 * voici la source: https://www.javaguides.net/2020/09/javafx-quit-button-example-terminate.html
	 * 
	 ***************************************************************************************************/	
	@FXML
	public void quitterLeJeu() {
		Platform.exit();
	}
	
	@FXML
	public void ouvrirRegle() {
		 try {
				 Alert DialogueQuitter = new Alert(AlertType.INFORMATION);
				 ButtonType bOK = new ButtonType("J'ai compris",ButtonData.OK_DONE);
				 //clear des boutons pour pouvoir obtenir seulement le bouton j'ai compris
				 DialogueQuitter.getButtonTypes().clear();
				 DialogueQuitter.getButtonTypes().add(bOK);
				 DialogueQuitter.setTitle("Règles Pendu");
				 DialogueQuitter.setHeaderText(null);
				 DialogueQuitter.setContentText(null);
			
				 /*******************************************
				  * Creation de la vbox pour les élements
				  *******************************************/
				 Image image = new Image(getClass().getResourceAsStream("/ressources/imageRegles.png"));
				 imagesRegles.setImage(image);
				 imagesRegles.setFitWidth(400);
				 imagesRegles.setFitHeight(650);
				 imagesRegles.setPreserveRatio(true);
				 //
				 Label titre = new Label("Le Pendu\nRègles");
			     titre.setStyle("-fx-text-fill: white; -fx-font-size: 50px; -fx-font-family:Chiller;");
				 VBox conteneur = new VBox(50);
				 conteneur.getChildren().addAll(titre);
				 //on veut que les elements soit : CENTER
				 conteneur.setAlignment(Pos.CENTER);
				 conteneur.getChildren().add(imagesRegles);
				 //on va ajouter la vbox a l'interieur de la boite de dialogue
				 DialogueQuitter.getDialogPane().setContent(conteneur);
				 //on va mettre la taille qu'on a choisi par défaut (1000,750)
				 DialogueQuitter.getDialogPane().setPrefSize(1000, 750);
				 //ajout de la feuille CSS
				 DialogueQuitter.getDialogPane().getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				 //pas oublier de mettre la boite de dialogue en mode showandWait
				 DialogueQuitter.showAndWait();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 	 
	}
	
	//ajout du throws car quand j'ai ecris loader.load, eclipse m'a dit d'ajouter 
	@FXML
	public void gestionJouer() throws IOException  {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfacesFXML/fenetreAvatar.FXML"));
        Parent root = loader.load();
        // ici on va recuperer le controleur associé au FXML
        ControleurAvatar controleurAvatar = loader.getController();
        //on appelle la methode gestionAvatar 
        controleurAvatar.gestionAvatar();
	}

}
			 
		 
