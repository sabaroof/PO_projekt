package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import model.LoggedUser;
import model.Plan;
import model.Student;
import model.Teacher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Runtime.getRuntime;

public class HomeController implements Initializable {

    @FXML
    private Button userButton, teacherButton;

    private Student student;
    private Teacher teacher;

    public Student getStudent() { return student; }
    public Teacher getTeacher() { return teacher; }

    public void windowChange(ActionEvent event, Stage window, String name) throws IOException {
        window.close();

        Parent resource = FXMLLoader.load(getClass().getResource(name));
        Scene scene = new Scene(resource);

        Stage newwindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        newwindow.setScene(scene);
        newwindow.show();
    }

    public void userButtonPressed(ActionEvent event) {
        Stage window = new Stage();

        TextField name = new TextField();
        TextField surname = new TextField();
        Button setButton = new Button("Create user");
        setButton.setOnAction(e -> {
            try {
                LoggedUser login = LoggedUser.getInstance();
                login.init(name.getText(), surname.getText());
                windowChange(e, window, "User.fxml");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(name, surname, setButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();


        //Parent user = FXMLLoader.load(getClass().getResource("User.fxml"));
        //Scene userScene = new Scene(user);

        //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        //window.setScene(userScene);
        //window.show();

    }

    public void teacherButtonPressed(ActionEvent event) {
        Stage window = new Stage();

        TextField name = new TextField();
        TextField surname = new TextField();
        Button setButton = new Button("Create user");
        setButton.setOnAction(e -> {
            try {
                Plan empty = new Plan();
                Teacher teach = new Teacher(name.getText(), surname.getText());
                teacher = teach;
                windowChange(e, window, "Teacher.fxml");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(name, surname, setButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        //Parent teacher = FXMLLoader.load(getClass().getResource("Teacher.fxml"));
        //Scene teacherScene = new Scene(teacher);

        //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        //window.setScene(teacherScene);
        //window.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
/*
    @FXML
    private void initialize() {
        // Handle Button event.
        userButton.setOnAction((event) -> {
            primaryStage.setScene();
        });

        teacherButton.setOnAction((event) -> {
            outputTextArea.appendText("Button Action\n");
        });

        // Handle CheckBox event.
        myCheckBox.setOnAction((event) -> {
            boolean selected = myCheckBox.isSelected();
            outputTextArea.appendText("CheckBox Action (selected: " + selected + ")\n");
        });

        // Init ComboBox items.
        myComboBox.setItems(myComboBoxData);

        // Define rendering of the list of values in ComboBox drop down.
        myComboBox.setCellFactory((comboBox) -> {
            return new ListCell<Person>() {
                @Override
                protected void updateItem(Person item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getFirstName() + " " + item.getLastName());
                    }
                }
            };
        });

        // Define rendering of selected value shown in ComboBox.
        myComboBox.setConverter(new StringConverter<Person>() {
            @Override
            public String toString(Person person) {
                if (person == null) {
                    return null;
                } else {
                    return person.getFirstName() + " " + person.getLastName();
                }
            }

            @Override
            public Person fromString(String personString) {
                return null; // No conversion fromString needed.
            }
        });

        // Handle ComboBox event.
        myComboBox.setOnAction((event) -> {
            Person selectedPerson = myComboBox.getSelectionModel().getSelectedItem();
            outputTextArea.appendText("ComboBox Action (selected: " + selectedPerson.toString() + ")\n");
        });

        // Handle Hyperlink event.
        myHyperlink.setOnAction((event) -> {
            outputTextArea.appendText("Hyperlink Action\n");
        });

        // Init ListView.
        myListView.setItems(listViewData);
        myListView.setCellFactory((list) -> {
            return new ListCell<Person>() {
                @Override
                protected void updateItem(Person item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getFirstName() + " " + item.getLastName());
                    }
                }
            };
        });

        // Handle ListView selection changes.
        myListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            outputTextArea.appendText("ListView Selection Changed (selected: " + newValue.toString() + ")\n");
        });

        // Handle Slider value change events.
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            outputTextArea.appendText("Slider Value Changed (newValue: " + newValue.intValue() + ")\n");
        });

        // Handle TextField text changes.
        myTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            outputTextArea.appendText("TextField Text Changed (newValue: " + newValue + ")\n");
        });

        // Handle TextField enter key event.
        myTextField.setOnAction((event) -> {
            outputTextArea.appendText("TextField Action\n");
        });

    }
*/
}