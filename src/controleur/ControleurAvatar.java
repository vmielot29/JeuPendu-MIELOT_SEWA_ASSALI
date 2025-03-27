package controleur;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControleurAvatar {
	// ajout d'attribut pour la gestion des images///
	private ArrayList<Image> Avatars = new ArrayList<>();
	private int indiceImage = 0;
	//attribut FXML
	@FXML Button boutonAnnulerAvatar;
	@FXML private ImageView images;
	
	@FXML
	public void initialize() {
		 /************************************************************************************
	     * 
	     * Ici, la gestion des images pour pouvoir la changer a chaque clic
	     * 
	     ***********************************************************************************/
	    Avatars.add(new Image(getClass().getResourceAsStream("/ressources/avatars1.PNG")));
	    Avatars.add(new Image(getClass().getResourceAsStream("/ressources/avatars2.PNG")));
	    Avatars.add(new Image(getClass().getResourceAsStream("/ressources/avatars3.PNG")));
	    Avatars.add(new Image(getClass().getResourceAsStream("/ressources/avatars4.PNG"))); 
	    System.out.println("taille de la liste" +Avatars.size()); 
	}
	    
	    @FXML
		public void gestionAvatar(){
			try {
				//on va charger la page
			 	FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfacesFXML/fenetreAvatar.FXML"));
		        Parent root = loader.load();
		        //creation de la boite de dialogue
		        Dialog<Void> boiteDialogue = new Dialog<>();
				//on affiche dans la boite de dialogue le contenu
				boiteDialogue.getDialogPane().setContent(root);
				/*******************************************************************************
				 * 
				 * ici on va créer un bouton ok pour valider, et un bouton close pour annuler
				 * 
				 ******************************************************************************/
				boiteDialogue.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
				boiteDialogue.getDialogPane().getButtonTypes().add(ButtonType.OK);
				//customisation des boutons via le css
				boiteDialogue.getDialogPane().getStylesheets().add("/application/application.css");
				Button boutonAnnulerAv = (Button) root.lookup("#boutonAnnulerAvatar"); 
			    //on veut que le bouton j'ai compris agisse comme un buton close
				boutonAnnulerAv.setOnAction(e -> boiteDialogue.close());
			    //et pas oublier showAndWait
			    boiteDialogue.showAndWait();
			}catch(Exception e) {
				 e.printStackTrace();
			}
	}
			@FXML 
		public void imagePrecedente() {
		        indiceImage = (indiceImage - 1 + Avatars.size()) % Avatars.size();
		        images.setImage(Avatars.get(indiceImage));
		    }
	
			@FXML
			public void imageSuivante() {
		        indiceImage = (indiceImage + 1) % Avatars.size();
		        images.setImage(Avatars.get(indiceImage));
		    }

}
