package view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    private Button homeButton, classesButton, enrollButton, gradesButton, calendarButton, overviewButton, settingsButton, setButton, logoutButton;
    @FXML
    private Pane homePane, classesPane, gradesPane, calendarPane, overviewPane, settingsPane;
    @FXML
    private ListView<Lesson> classesList;
    @FXML
    private ListView infoList;
    @FXML
    private TableView<GradesModel> gradesTable;
    @FXML
    private TableView<Lesson> pricesTable;
    @FXML
    private TableColumn<GradesModel, String> gradesNames;
    @FXML
    private TableColumn<GradesModel, Integer> gradesNumbers;
    @FXML
    private TableColumn<Lesson, String> pricesNames;
    @FXML
    private TableColumn<Lesson, Integer> pricesNumbers;
    @FXML
    private TitledPane infoBox;
    @FXML
    private Label currentName, currentSurname, fullPrice;
    @FXML
    private TextField setName, setSurname;

    private ObservableList<GradesModel> gradesModels = FXCollections.observableArrayList();

    private LoggedUser logged;
    private Plan plan;
    public void setPlan(Plan plan){
        this.plan = plan;
    }

   private ObservableList<Lesson> enrolledLessons = FXCollections.observableArrayList();

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
        if(event.getSource()==homeButton){
            homePane.toFront();
        }else if(event.getSource()==classesButton){
            classesPane.toFront();
        }else if(event.getSource()==gradesButton){
            gradesPane.toFront();
        }else if(event.getSource()==calendarButton){
            calendarPane.toFront();
        }else if(event.getSource()==overviewButton){
            overviewPane.toFront();
        }else if(event.getSource()==settingsButton){
            settingsPane.toFront();
        }
    }

    /*private void refresh(){
        currentName.setText(logged.getStudent().getName());
        currentSurname.setText(logged.getStudent().getSurname());
    }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //basic data population
        Plan fullplan = new Plan();
        Plan roofPlan = new Plan();
        Plan grzybPlan = new Plan();
        setPlan(fullplan);
        System.out.println(LoggedUser.getInstance());
        Student logged = LoggedUser.getInstance().getStudent();
        System.out.println(logged.getName());
        Student roof = new Student("miłosz", "sabadach", roofPlan);
        Student grzyb = new Student("marcin", "dobrucki", grzybPlan);
        ArrayList ar1 = new ArrayList();
        ar1.add(roof);
        ar1.add(grzyb);
        ArrayList ar2 = new ArrayList<Student>();
        ar2.add(roof);
        ArrayList ar3 = new ArrayList<Student>();
        ar3.add(grzyb);
        Lesson les1 = new Lesson("salsa","wtorek", 13, ar1, 15, 100);
        Lesson les2 = new Lesson("tango","sroda", 16, ar2, 10, 200);
        Lesson les3 = new Lesson("walczyk","czwartek", 17, ar3, 15, 140);
        fullplan.addLesson(les1);
        fullplan.addLesson(les2);
        fullplan.addLesson(les3);
        logged.getPlan().addLesson(les2);
        //

        ObservableList<Lesson> lista = FXCollections.observableArrayList(plan.getLessons());

        classesList.setItems(lista);

        classesList.setCellFactory(lv -> new ListCell<Lesson>() {
            @Override
            public void updateItem(Lesson lesson, boolean empty) {
                super.updateItem(lesson, empty);
                if (empty) {
                    setText(null);
                } else {
                    String text = lesson.getName(); // get text from item
                    setText(text);
                }
            }
        });

        classesList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList info = FXCollections.observableArrayList(classesList.getSelectionModel().selectedItemProperty().get().getInfo());
            infoList.setItems(info);
        });

        enrollButton.setOnAction(event -> {
            logged.getPlan().addLesson(classesList.getSelectionModel().getSelectedItem());
            gradesModels.add(new GradesModel(logged.getPlan().getLessons().get(logged.getPlan().getLessons().size()-1).getName(), logged.getPlan().getLessons().get(logged.getPlan().getLessons().size()-1).getHour()));
            enrolledLessons.add(new Lesson(logged.getPlan().getLessons().get(logged.getPlan().getLessons().size()-1).getName(), logged.getPlan().getLessons().get(logged.getPlan().getLessons().size()-1).getPrice()));
            fullPrice.setText(String.valueOf(logged.getPlan().getPrice()));
        });

        gradesNames.setCellValueFactory(new PropertyValueFactory<GradesModel, String>("nazwa"));
        gradesNumbers.setCellValueFactory(new PropertyValueFactory<GradesModel, Integer>("ocena"));
        gradesTable.setItems(gradesModels);

        pricesNames.setCellValueFactory(new PropertyValueFactory<Lesson, String>("nameGUI"));
        pricesNumbers.setCellValueFactory(new PropertyValueFactory<Lesson, Integer>("priceGUI"));
        pricesTable.setItems(enrolledLessons);

        currentName.setText(logged.getName());
        currentSurname.setText(logged.getSurname());

        setButton.setOnAction(event -> {
            logged.setName(setName.getText());
            logged.setSurname(setSurname.getText());
            currentName.setText(logged.getName());
            currentSurname.setText(logged.getSurname());
        });

        fullPrice.setText(String.valueOf(logged.getPlan().getPrice()));

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