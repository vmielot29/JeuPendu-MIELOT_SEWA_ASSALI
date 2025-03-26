package controleur;

import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

//import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
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
	/////////////////////////////////////////////////
	// ajout d'attribut pour la gestion des images///
	/////////////////////////////////////////////////
	/*private ArrayList<Image> Avatars = new ArrayList<>();
	private int indiceImage = 0;
	
	/****************************************************************************************************
	 * 
	 * gestion du bouton quitter, pour la methode:
	 * Plateform.exit() 
	 * voici la source: https://www.javaguides.net/2020/09/javafx-quit-button-example-terminate.html
	 * 
	 ***************************************************************************************************/
/*	@FXML
	public void initialize() {
		 /************************************************************************************
	     * 
	     * Ici, la gestion des images pour pouvoir la changer a chaque clic
	     * 
	     ***********************************************************************************/
	  /*  Avatars.add(new Image(getClass().getResourceAsStream("/gestionPseudo/avatar/avatars1.PNG")));
	    Avatars.add(new Image(getClass().getResourceAsStream("/gestionPseudo/avatar/avatars2.PNG")));
	    Avatars.add(new Image(getClass().getResourceAsStream("/gestionPseudo/avatar/avatars3.PNG")));
	    Avatars.add(new Image(getClass().getResourceAsStream("/gestionPseudo/avatar/avatars4.PNG"))); 
	    System.out.println("taille de la liste" +Avatars.size()); 
	}
	*/
	@FXML
	public void initialize() {
		
	}
	
	
	
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
				 DialogueQuitter.setHeaderText("Le Pendu");
				 DialogueQuitter.setContentText("Règles");
				 /*******************************************
				  * Creation de la vbox pour les élements
				  *******************************************/
				 Image image = new Image(getClass().getResourceAsStream("src/ressources/ImagesRegles/imageRegles.png"));
				 imagesRegles.setImage(image);
				 imagesRegles.setFitWidth(300);
				 imagesRegles.setFitHeight(500);
				 imagesRegles.setPreserveRatio(true);
				 VBox conteneur = new VBox(50);
				 //on veut que les elements soit : CENTER
				 conteneur.setAlignment(Pos.CENTER);
				 conteneur.getChildren().add(imagesRegles);
				 //on va ajouter la vbox a l'interieur de la boite de dialogue
				 DialogueQuitter.getDialogPane().setContent(conteneur);
				 //on va mettre la taille qu'on a choisi par défaut (1000,750)
				 DialogueQuitter.getDialogPane().setPrefSize(1000, 750);
				 //pas oublier de mettre la boite de dialogue en mode showandWait
				 DialogueQuitter.showAndWait();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	} 	 
//	@FXML
//	public void gestionAvatar(){
//		try {
//			//on va charger la page
//		 	FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestionPseudo/fenetreAvatar.fxml"));
//	        Parent root = loader.load();
//	        //creation de la boite de dialogue
//	        Dialog<Void> boiteDialogue = new Dialog<>();
//			//on affiche dans la boite de dialogue le contenu
//			boiteDialogue.getDialogPane().setContent(root);
//			/*******************************************************************************
//			 * 
//			 * ici on va créer un bouton ok pour valider, et un bouton close pour annuler
//			 * 
//			 ******************************************************************************/
//			boiteDialogue.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
//			boiteDialogue.getDialogPane().getButtonTypes().add(ButtonType.OK);
//			//customisation des boutons via le css
//			boiteDialogue.getDialogPane().getStylesheets().add("/application/application.css");
//			Button boutonAnnulerAv = (Button) root.lookup("#boutonAnnulerAvatar"); 
//		    //on veut que le bouton j'ai compris agisse comme un buton close
//			boutonAnnulerAv.setOnAction(e -> boiteDialogue.close());
//		    //et pas oublier showAndWait
//		    boiteDialogue.showAndWait();
//		}catch(Exception e) {
//			 e.printStackTrace();
//		 }
//		/*ajout de ce bloc, car il y avait un erreur image nul lorsqu'on voulait modifier l'image,
//		 * mais qui n'affectait pas l
//		 */
//		try {
//			images.setImage(Avatars.get(indiceImage));
//		}catch(NullPointerException e) {
//			
//		}
//		
//		
//	}
//	@FXML 
//	public void imagePrecedente() {
//        indiceImage = (indiceImage - 1 + Avatars.size()) % Avatars.size();
//        images.setImage(Avatars.get(indiceImage));
//    }
//	
//	@FXML
//	public void imageSuivante() {
//        indiceImage = (indiceImage + 1) % Avatars.size();
//        images.setImage(Avatars.get(indiceImage));
//    }
//*/	 
}
			 
		 
