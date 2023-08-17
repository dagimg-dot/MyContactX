package components.container.leftBar;

import components.container._container.Container;
import components.text.TextGenerator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class LeftBar extends Container{
    public Scene scene;

    public LeftBar(Scene scene, double widthPercentage, double heightPercentage) {
        super(scene, widthPercentage, heightPercentage);
        this.scene = scene;
        setPrefWidth(scene.getWidth() * widthPercentage);
        setPrefHeight(scene.getHeight() * heightPercentage);
        this.getStylesheets().add("components/container/_container/Container.css");
        this.getStyleClass().add("container");
    }

    public void render(GridPane grid) { 
        grid.add(this, 1, 0, 1, 2);


        VBox leftBarContainer = new VBox();
        leftBarContainer.prefWidthProperty().bind(this.widthProperty());
        leftBarContainer.prefHeightProperty().bind(this.heightProperty());
        leftBarContainer.setStyle("-fx-background-color: white; -fx-background-radius: 15;");

        
        HBox title = new HBox();
        
        // set the height and width of the title
        title.setPrefHeight(this.getPrefHeight() / 15);
        title.prefWidthProperty().bind(leftBarContainer.prefWidthProperty());

        // create the title text
        Text details = TextGenerator.generateText("Details","Poppins-SemiBold",20,"#554D4D");

        // set the alignment and style of the title
        title.setAlignment(Pos.CENTER);
        title.setStyle("-fx-background-color: #E3E0E0; -fx-background-radius: 15;");
        
        // add the title text to the title HBox
        title.getChildren().add(details);

        // set margin for the title
        VBox.setMargin(title, new Insets(10,10,10,10));

        // create details wrapper for the VBox
        StackPane detailsWrapper = new StackPane();


        // set the width and height of the details container
        detailsWrapper.prefWidthProperty().bind(leftBarContainer.prefWidthProperty());
        detailsWrapper.setPrefHeight(this.getPrefHeight() / 2);

        // add listener to the left bar container to update the details container
        leftBarContainer.heightProperty().addListener((obs, oldVal, newVal) -> {
            detailsWrapper.setPrefHeight(newVal.doubleValue() / 2);
        });

        // create the details container for the selected contact
        VBox detailsContainer = new VBox();
        
        // set the width and height of the details container
        detailsContainer.prefWidthProperty().bind(detailsWrapper.prefWidthProperty());
        detailsContainer.prefHeightProperty().bind(detailsWrapper.prefHeightProperty());

        Circle contactPhoto = new Circle(50, 50, 50);
        contactPhoto.setFill(Color.web("#A39696"));

        HBox contactPhotoContainer = new HBox();
        contactPhotoContainer.setAlignment(Pos.CENTER);
        contactPhotoContainer.getChildren().add(contactPhoto);

        VBox.setMargin(contactPhotoContainer, new Insets(10,10,10,10));

        detailsContainer.getChildren().add(contactPhotoContainer);

        detailsWrapper.getChildren().add(detailsContainer); 


        // set the style of the details container
        detailsWrapper.setStyle("-fx-background-color: #E3E0E0; -fx-background-radius: 15;");

        // set margin for the details container
        VBox.setMargin(detailsWrapper, new Insets(0,10,10,10));


        // add the title to the left bar container
        leftBarContainer.getChildren().addAll(title, detailsWrapper);
        this.getChildren().addAll(leftBarContainer);

    };
}