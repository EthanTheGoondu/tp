package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Student;

/**
 * Panel containing the list of persons.
 */
public class StudentListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private ListView<Student> studentListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public StudentListPanel(ObservableList<Student> personList) {
        super(FXML);
        studentListView.setItems(personList);
        studentListView.setCellFactory(listView -> new StudentListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class StudentListViewCell extends ListCell<Student> {
        @Override
        protected void updateItem(Student student, boolean empty) {
            super.updateItem(student, empty);

            if (empty || student == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new StudentCard(student, getIndex() + 1).getRoot());
            }
        }
    }

}