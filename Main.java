import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application{

    Building buil = new Building();

    private Map<String, String> userCredentials = new HashMap<>();


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch();
    }

    public void start (Stage stage)
    {
        //heading
        Label heading = new Label();
        Text text = new Text("Welcome to Online Auction System");
        text.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 35));
        text.setFill(Color.WHITE);
        text.setUnderline(true);
        heading.setGraphic(text);
        StackPane stackPane = new StackPane(text);
        stackPane.setPadding(new Insets(0, 10, 0, 35)); // Add left padding of 20 pixels
        heading.setGraphic(stackPane);


        Label l2 = new Label("Do you want to login in as  Admin ,Customer or Seller ?");
        l2.setStyle("-fx-text-fill: white;");
        HBox hb2 = new HBox(10);
        hb2.getChildren().addAll(l2);
        hb2.setStyle("-fx-alignment: center;");
        Button btn1 = new Button("Admin");
        btn1.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        btn1.setPrefWidth(80);
        btn1.setOnMouseEntered(event -> {
            // Set hover style
        	btn1.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        btn1.setOnMouseExited(event -> {
            // Set normal style
        	btn1.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });
        Button btn2 = new Button("Auction");
        btn2.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        btn2.setPrefWidth(80);
        btn2.setOnMouseEntered(event -> {
            // Set hover style
        	btn2.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        btn2.setOnMouseExited(event -> {
            // Set normal style
        	btn2.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });
        
        Button btn3 = new Button("Seller");
        btn3.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        btn3.setPrefWidth(80);
        btn3.setOnMouseEntered(event -> {
            // Set hover style
        	btn3.setStyle("-fx-background-color:#dea5a4 ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        btn3.setOnMouseExited(event -> {
            // Set normal style
        	btn3.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#c96d6c ; -fx-font-size: 13px;");
        });


        HBox hb3 = new HBox(10);
        hb3.getChildren().addAll(btn1,btn2,btn3);
        hb3.setStyle("-fx-alignment: center;");

        btn1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                stage.close();

                openAdminScene();
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                stage.close();

                openCustomer();
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                stage.close();

                openSellerScene();
            }
        });


        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(heading,hb2);
        hbox.setStyle("-fx-alignment: center;");
        VBox vbox = new VBox(20);

        Pane pane = new HBox(50);
        Image image = new Image("auction.png");
        BackgroundImage im=new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bGround=new Background(im);
        pane.setBackground(bGround);
        pane.getChildren().addAll(vbox);

        vbox.getChildren().addAll(hbox,hb2,hb3);
        vbox.setStyle("-fx-alignment: center;");
        Scene scene = new Scene(pane, 700, 400);

        stage.setScene(scene);
        stage.setTitle("Online Auction System");
        stage.show();

    }
    //second stage(admin)
    private void openAdminScene() {

        Stage adminStage = new Stage();
//        Building buil = new Building();

        Label adminLabel = new Label("Welcome to Admin");
        adminLabel.setFont(Font.font("Caspian", FontWeight.BOLD, 20));
        adminLabel.setTextFill(Color.WHITE);

        StackPane adminStackPane = new StackPane(adminLabel);
        adminStackPane.setPadding(new Insets(60, 0, 0, 280));

        VBox adminVBox = new VBox(20);
        adminVBox.getChildren().addAll(adminStackPane);

        Label usernameLabel = new Label("Username");
        usernameLabel.setStyle("-fx-text-fill: white;");
        TextField usernameTextField = new TextField();

        Label passwordLabel = new Label("Password");
        passwordLabel.setStyle("-fx-text-fill: white;");
        PasswordField passwordField = new PasswordField();

        HBox usernameBox = new HBox(20);
        usernameBox.getChildren().addAll(usernameLabel, usernameTextField);
        usernameBox.setStyle("-fx-alignment: center;");

        HBox passwordBox = new HBox(20);
        passwordBox.getChildren().addAll(passwordLabel, passwordField);
        passwordBox.setStyle("-fx-alignment: center;");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            String username = usernameTextField.getText();
            String password = passwordField.getText();
            if (username.equalsIgnoreCase("admin") && password.equals("123")) {
                adminStage.close();
                openthirdScene();
            } else {
            	 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Error");
                 alert.setHeaderText(null);
                 alert.setContentText("incorrect password / email");
                 alert.showAndWait();
            }
        });
        
        loginButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        loginButton.setPrefWidth(100);
        loginButton.setOnMouseEntered(event -> {
            // Set hover style
        	loginButton.setStyle("-fx-background-color:#A52A2A ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        loginButton.setOnMouseExited(event -> {
            // Set normal style
        	loginButton.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        });

        VBox loginBox = new VBox(20);
        loginBox.getChildren().addAll(usernameBox, passwordBox, loginButton);
        loginBox.setStyle("-fx-alignment: center;");

        adminVBox.getChildren().addAll(loginBox);
        adminVBox.setStyle("-fx-alignment: center;");

        Pane pane = new HBox(50);
        Image image = new Image("admin.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        pane.setBackground(background);
        pane.getChildren().addAll(adminVBox);

        Scene adminScene = new Scene(pane, 700, 400);

        adminStage.setScene(adminScene);
        adminStage.setTitle("Admin");
        adminStage.show();
    }

    //third stage (admin)
    private void openthirdScene() {

        Stage adminStage = new Stage();

        Label adminLabel = new Label("Welcome Admin");
        adminLabel.setFont(Font.font("Caspian", FontWeight.BOLD, 20));
        adminLabel.setTextFill(Color.WHITE);

        StackPane adminStackPane = new StackPane(adminLabel);
        adminStackPane.setPadding(new Insets(80, 0, 0, 250));
        adminStackPane.setStyle("-fx-alignment: center;");


        Label l2 = new Label("Data of All Auction >>>");
        l2.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Button btn1 = new Button("Click");
        btn1.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        btn1.setPrefWidth(50);
        btn1.setOnMouseEntered(event -> {
            // Set hover style
        	btn1.setStyle("-fx-background-color:#A52A2A ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        btn1.setOnMouseExited(event -> {
            // Set normal style
        	btn1.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        });

        HBox hb2 = new HBox(20);
        hb2.getChildren().addAll(l2, btn1);
        hb2.setStyle("-fx-alignment: center;");
        hb2.setPadding(new Insets(10, 0, 0, 250));
        btn1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                buil.rent();

            }
        });

        Label l3 = new Label("Seller Data >>>");
        l3.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Button btn2 = new Button("Click");
        btn2.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        btn2.setPrefWidth(50);
        btn2.setOnMouseEntered(event -> {
            // Set hover style
        	btn2.setStyle("-fx-background-color:#A52A2A ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        btn2.setOnMouseExited(event -> {
            // Set normal style
        	btn2.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        });
        HBox hb3 = new HBox(20);
        hb3.getChildren().addAll(l3, btn2);
        hb3.setStyle("-fx-alignment: center;");
        hb3.setPadding(new Insets(10, 0, 0, 250));
        btn2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                buil.showResidents();

            }
        });




        Label l4 = new Label("Auction Rules >>>");
        l4.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        Button btn3 = new Button("Click");
        btn3.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        btn3.setPrefWidth(50);
        btn3.setOnMouseEntered(event -> {
            // Set hover style
        	btn3.setStyle("-fx-background-color:#A52A2A ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        btn3.setOnMouseExited(event -> {
            // Set normal style
        	btn3.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        });
        HBox hb4 = new HBox(20);
        hb4.getChildren().addAll(l4, btn3);
        hb4.setStyle("-fx-alignment: center;");
        hb4.setPadding(new Insets(10, 0, 0, 250));
        btn3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                buil.showResidents();

            }
        });



        Button btn4 = new Button("Logout");
        btn4.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        btn4.setPrefWidth(80);
        btn4.setOnMouseEntered(event -> {
            // Set hover style
        	btn4.setStyle("-fx-background-color:#A52A2A ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        btn4.setOnMouseExited(event -> {
            // Set normal style
        	btn4.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        });
        HBox hb5 = new HBox(20);
        hb5.getChildren().addAll( btn4);
        hb5.setPadding(new Insets(65, 0, 0,0));
        btn4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                adminStage.close();

            }
        });

        VBox adminVBox = new VBox(20);
        adminVBox.getChildren().addAll(adminStackPane,hb2,hb3,hb4,hb5);

        Pane pane = new HBox(50);
        Image image = new Image("admin.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        pane.setBackground(background);
        pane.getChildren().addAll(adminVBox);

        Scene adminScene = new Scene(pane, 700, 400);

        adminStage.setScene(adminScene);
        adminStage.setTitle("Admin");
        adminStage.show();
    }
    private void openCustomer() {

        Stage CustomerStage = new Stage();

        Label CustomerLabel = new Label("Welcome To Auction");
        CustomerLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD , FontPosture.ITALIC, 40));
        CustomerLabel.setTextFill(Color.WHITE);


        StackPane CustomerStackPane = new StackPane(CustomerLabel);
        CustomerStackPane.setPadding(new Insets(90, 0, 0, 220));
        CustomerStackPane.setStyle("-fx-alignment: center;");


        HBox hb1 = new HBox(30);
        Label l2 = new Label("Are you looking to partcipate in Auction?");
        l2.setFont(Font.font("Times New Roman", 20));
        l2.setTextFill(Color.WHITE);
        hb1.setStyle("-fx-alignment: center;");
        hb1.setPadding(new Insets(10, 0, 0, 220));
        hb1.getChildren().addAll(l2);


        HBox hb2 = new HBox(30);
        Button btn1 = new Button("Yes");
        btn1.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        btn1.setPrefWidth(100);
        btn1.setOnMouseEntered(event -> {
            // Set hover style
            btn1.setStyle("-fx-background-color:#A52A2A ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        btn1.setOnMouseExited(event -> {
            // Set normal style
            btn1.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        });
        hb2.setStyle("-fx-alignment: center;");
        hb2.setPadding(new Insets(10, 0, 0, 190));
        //actionHandler
        btn1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                CustomerStage.close();
                SecondCustomer();

            }
        });
        hb2.getChildren().addAll(btn1);

        HBox hb3 = new HBox(30);
        Button btn2 = new Button("No");
        btn2.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        btn2.setPrefWidth(100);
        btn2.setOnMouseEntered(event -> {
            // Set hover style
            btn2.setStyle("-fx-background-color:#A52A2A ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        btn2.setOnMouseExited(event -> {
            // Set normal style
            btn2.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        });
        hb3.setStyle("-fx-alignment: center;");
        hb3.setPadding(new Insets(10, 0, 0, 190));
        btn2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                CustomerStage.close();
            }
        });
        hb3.getChildren().addAll(btn2);




        VBox adminVBox = new VBox(20);
        adminVBox.getChildren().addAll(CustomerStackPane,hb1,hb2,hb3);

        Pane pane = new HBox(50);
        Image image = new Image("cutomer1.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        pane.setBackground(background);
        pane.getChildren().addAll(adminVBox);

        Scene CustomerScene = new Scene(pane, 700, 400);

        CustomerStage.setScene(CustomerScene);
        CustomerStage.setTitle("Auction Participation");
        CustomerStage.show();
    }

    TextField nameTextField = new TextField();
    TextField ageTextField = new TextField();
    TextField cellTextField = new TextField();
    TextField emailTextField = new TextField();

    String name = nameTextField.getText();
    String age = ageTextField.getText();
    String cellNo = cellTextField.getText();
    String email = emailTextField.getText();

    //info-about-customer
    private void SecondCustomer() {

        Stage CustomerStage = new Stage();

        Label CustomerLabel = new Label("Personal Information");
        CustomerLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD , FontPosture.ITALIC, 40));
        CustomerLabel.setTextFill(Color.WHITE);

        StackPane CustomerStackPane = new StackPane(CustomerLabel);
        CustomerStackPane.setPadding(new Insets(40, 0, 0, 150));
        CustomerStackPane.setStyle("-fx-alignment: center;");

        HBox hb1 = new HBox(40);
        Label l2 = new Label("We kindly request you to submit the necessary information.");
        l2.setFont(Font.font("Times New Roman", 16));
        l2.setTextFill(Color.WHITE);
        hb1.setStyle("-fx-alignment: center;");
        hb1.setPadding(new Insets(0, 0, 0,150));
        hb1.getChildren().addAll(l2);

        HBox hb2 = new HBox(40);
        Label l3 = new Label("Name:");
        l3.setFont(Font.font("Times New Roman", 16));
        l3.setStyle("-fx-text-fill: white;");
        hb2.getChildren().addAll(l3, nameTextField);
        hb2.setPadding(new Insets(0, 0, 0, 150));
        hb2.setStyle("-fx-alignment: center;");

        HBox hb3 = new HBox(20);
        Label l4 = new Label("Age:");
        l4.setFont(Font.font("Times New Roman", 16));
        l4.setStyle("-fx-text-fill: white;");
        ageTextField.setTextFormatter(new TextFormatter<>(change -> {
            if (!change.getControlNewText().matches("\\d*")) {
                return null;
            }
            return change;
        }));
        hb3.getChildren().addAll(l4, ageTextField);
        hb3.setPadding(new Insets(0, 0, 0, 150));
        hb3.setStyle("-fx-alignment: center;");

        HBox hb4 = new HBox(20);
        Label l5 = new Label("Phone No:");
        l5.setFont(Font.font("Times New Roman", 16));
        l5.setStyle("-fx-text-fill: white;");
        cellTextField.setTextFormatter(new TextFormatter<>(change -> {
            if (!change.getControlNewText().matches("\\d*")) {
                return null;
            }
            return change;
        }));

        hb4.getChildren().addAll(l5, cellTextField);
        hb4.setPadding(new Insets(0, 0, 0, 150));
        hb4.setStyle("-fx-alignment: center;");

        HBox hb5 = new HBox(20);
        Label l6 = new Label("Email:");
        l6.setFont(Font.font("Times New Roman", 16));
        l6.setStyle("-fx-text-fill: white;");

        hb5.getChildren().addAll(l6, emailTextField);
        hb5.setPadding(new Insets(0, 0, 0, 150));
        hb5.setStyle("-fx-alignment: center;");

        HBox hb6 = new HBox(20);
        Button btn1 = new Button("Start Auction");
        btn1.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        btn1.setPrefWidth(100);
        btn1.setOnMouseEntered(event -> {
            // Set hover style
            btn1.setStyle("-fx-background-color:#A52A2A ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        btn1.setOnMouseExited(event -> {
            // Set normal style
            btn1.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        });
        hb6.setStyle("-fx-alignment: center;");
        hb6.setPadding(new Insets(6, 0, 0, 190));
        btn1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                String name = nameTextField.getText();
                String age = ageTextField.getText();
                String cellNo = cellTextField.getText();
                String email = emailTextField.getText();


                if (name.isEmpty() || age.isEmpty() || cellNo.isEmpty() || email.isEmpty()) {
                    // Display error message
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please complete all the information.");
                    alert.showAndWait();
                } else {
                    // Proceed to the next stage
                    CustomerStage.close();
                    thirdCustomer();
                    buil.availableFlats();
                }
            }
        });
        hb6.getChildren().addAll(btn1);




        VBox adminVBox = new VBox(20);
        adminVBox.getChildren().addAll(CustomerStackPane,hb1,hb2,hb3,hb4,hb5,hb6);

        Pane pane = new HBox(50);
        Image image = new Image("cutomer1.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        pane.setBackground(background);
        pane.getChildren().addAll(adminVBox);




        Scene CustomerScene = new Scene(pane, 700, 400);

        CustomerStage.setScene(CustomerScene);
        CustomerStage.setTitle("Customer Information");
        CustomerStage.show();
    }
    //after list rent or buy opt
    private TextField itemNumberTextField;
    private TextField BidTextField;
    private void thirdCustomer() {

        Stage CustomerStage = new Stage();
        itemNumberTextField = new TextField();
        BidTextField = new TextField();

        Label CustomerLabel = new Label("Important Info");
        CustomerLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD , FontPosture.ITALIC, 40));
        CustomerLabel.setTextFill(Color.WHITE);

        StackPane CustomerStackPane = new StackPane(CustomerLabel);
        CustomerStackPane.setPadding(new Insets(70, 0, 0, 115));
        CustomerStackPane.setStyle("-fx-alignment: center;");


        HBox hb2 = new HBox(20);
        Label l2 = new Label("Choose your mode of payment   ");
        l2.setFont(Font.font("Times New Roman", 16));
        l2.setTextFill(Color.WHITE);

        ToggleGroup tg = new ToggleGroup();
        RadioButton cash = new RadioButton("Cash");
        cash.setStyle("-fx-text-fill: white;");

        RadioButton credit = new RadioButton("Credit ");
        credit.setStyle("-fx-text-fill: white;");

        cash.setToggleGroup(tg);
        credit.setToggleGroup(tg);
        hb2.setStyle("-fx-alignment: center;");
        hb2.setPadding(new Insets(6, 0, 0, 120));
        hb2.getChildren().addAll(l2,cash,credit);

        HBox hb3 = new HBox(20);
        Label l3 = new Label("Item Number:");
        l3.setFont(Font.font("Times New Roman", 16));
        l3.setTextFill(Color.WHITE);
//        TextField flatNumberTextField = new TextField();
        itemNumberTextField.setTextFormatter(new TextFormatter<>(change -> {
            if (!change.getControlNewText().matches("\\d*")) {
                return null;
            }
            return change;
        }));
        hb3.setStyle("-fx-alignment: center;");
        hb3.setPadding(new Insets(6, 0, 0, 120));
        hb3.getChildren().addAll(l3,itemNumberTextField);


        HBox hb4 = new HBox(20);
        Label l4 = new Label("Bid :");
        l4.setFont(Font.font("Times New Roman", 16));
        l4.setTextFill(Color.WHITE);
//        TextField securityDepositTextField = new TextField();
        BidTextField.setTextFormatter(new TextFormatter<>(change -> {
            if (!change.getControlNewText().matches("\\d*")) {
                return null;
            }
            return change;
        }));
        hb4.setStyle("-fx-alignment: center;");
        hb4.setPadding(new Insets(6, 0, 0, 120));
        hb4.getChildren().addAll(l4,BidTextField);


        HBox hb5 = new HBox(20);

        Button btn3 = new Button("Submit");
        btn3.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        btn3.setPrefWidth(100);
        btn3.setOnMouseEntered(event -> {
            // Set hover style
            btn3.setStyle("-fx-background-color:#A52A2A ; -fx-text-fill:#FFFFFF ; -fx-font-size: 13px;");
        });

        btn3.setOnMouseExited(event -> {
            // Set normal style
            btn3.setStyle("-fx-background-color:#FFFFFF ; -fx-text-fill:#A52A2A ; -fx-font-size: 13px;");
        });
        

        hb5.setStyle("-fx-alignment: center;");
        hb5.setPadding(new Insets(6, 0, 0, 190));
        hb5.getChildren().addAll(btn3);



        btn3.setOnAction(event -> {
            String name = nameTextField.getText();
            String age = ageTextField.getText();
            String cellNo = cellTextField.getText();
            String email = emailTextField.getText();
            String flatNumber = itemNumberTextField.getText();
            String bid= BidTextField.getText();

            if (name.isEmpty() || age.isEmpty() || cellNo.isEmpty() || email.isEmpty() ||
                    flatNumber.isEmpty() || bid.isEmpty() ||
                    (!cash.isSelected() && !credit.isSelected())) {
            	  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Error");
                  alert.setHeaderText(null);
                  alert.setContentText("Please complete all the information.");
                  alert.showAndWait();
            }
            else {
            
            
            String txt = "Name: " + name + "\nPhone: " + cellNo + "\nAge: " + age + "\nEmail: " + email +
                    "\nItem Number: " + flatNumber + "\nTotal bid: " + bid  ;
            

            if (cash.isSelected()) {
                txt += "\nCash";
            } else if (credit.isSelected()) {
                txt += "\nCredit";
            }

            Label output = new Label(txt);
            output.setFont(Font.font(STYLESHEET_CASPIAN, 30));
            output.setTextFill(Color.GREEN);

            Scene scene2 = new Scene(output, 600, 600);
            CustomerStage.setScene(scene2);
            CustomerStage.setTitle("Output");

            Connection connection = new Connection();
            try {
                connection.writeToFile(txt);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                connection.readfile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }});

        VBox CVBox = new VBox(20);
        CVBox.getChildren().addAll(CustomerStackPane,hb2,hb3,hb4,hb5);



        Pane pane = new HBox(50);
        Image image = new Image("customer2.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        pane.setBackground(background);
        pane.getChildren().addAll(CVBox);

        Scene CustomerScene = new Scene(pane, 700, 400);

        CustomerStage.setScene(CustomerScene);
        CustomerStage.setTitle("Customer");
        CustomerStage.show();


    }
    
    //seller



    private void openSellerScene() {
        // Create a new stage for the Seller scene
        Stage sellerStage = new Stage();
        sellerStage.setTitle("Seller Dashboard");

         
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");

        TextField usernameTextField = new TextField();
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        Button signUpButton = new Button("Sign Up");
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(150, 100, 200, 250));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        GridPane.setConstraints(usernameLabel, 0, 0);
        GridPane.setConstraints(usernameTextField, 1, 0);
        GridPane.setConstraints(passwordLabel, 0, 1);
        GridPane.setConstraints(passwordField, 1, 1);
        GridPane.setConstraints(loginButton, 1, 2);
        GridPane.setConstraints(signUpButton, 1, 3);

        // Add components to the layout
        gridPane.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordField, loginButton, signUpButton);

        // Set up event handlers
        loginButton.setOnAction(e -> handleLogin(usernameTextField.getText(), passwordField.getText()));
        signUpButton.setOnAction(e -> handleSignUp(usernameTextField.getText(), passwordField.getText()));

        // Set up the scene
        Scene scene = new Scene(gridPane, 700, 400);
        sellerStage.setScene(scene);

        sellerStage.show();
    }

    private void handleLogin(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            showAlert("Login Successful", "Welcome, " + username + "!");
        } else {
            showAlert("Login Failed", "Invalid username or password.");
        }
    }

    private void handleSignUp(String username, String password) {
        if (userCredentials.containsKey(username)) {
            showAlert("Sign-Up Failed", "Username already exists. Choose a different username.");
        } else {
            userCredentials.put(username, password);
            saveUserCredentialsToFile();
            showAlert("Sign-Up Successful", "Account created successfully.");
        }
    }

    private void saveUserCredentialsToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("userCredentials.dat"))) {
            outputStream.writeObject(userCredentials);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    
public void stop() throws Exception {
    saveUserCredentialsToFile();
    super.stop();
}
}