package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {

    @FXML
    private Button home_btn, groups_btn, grades_btn, calendar_btn, settings_btn, logout_btn;
    @FXML
    private Pane homePane, groupsPane, gradesPane, calendarPane, settingsPane;

    public void logoutButtonPressed(ActionEvent event) throws IOException
    {
        Parent home = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene homeScene = new Scene(home);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homeScene);
        window.show();
    }

    @FXML
    private void buttonHandler(ActionEvent event){
        if(event.getSource()==home_btn){
            homePane.toFront();
        }else if(event.getSource()==groups_btn){
            groupsPane.toFront();
        }else if(event.getSource()==grades_btn){
            gradesPane.toFront();
        }else if(event.getSource()==calendar_btn){
            calendarPane.toFront();
        }else if(event.getSource()==settings_btn){
            settingsPane.toFront();
        }
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