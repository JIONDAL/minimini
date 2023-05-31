package login;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class anounceManageFormController implements Initializable{
	@FXML
	private TableView<BoardDTO> anounceTableView;
	@FXML
	private TableColumn<BoardDTO, String> numColumn;
	@FXML
	private TableColumn<BoardDTO, String> titleColumn;
	@FXML
	private TableColumn<BoardDTO, String> contentColumn;
	@FXML
	private TableColumn<BoardDTO, String> writeTimeColumn;
	
	@FXML
	TextField titleFld;
	@FXML
	TextArea contentArea;

	private anounceManageFormService service;
	private BoardDTO board;
	
	ObservableList<BoardDTO> observableList;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new anounceManageFormService();
	}

	public void insertProc() {
		board = new BoardDTO();
		board.setTitle(titleFld.getText());
		board.setContent(contentArea.getText());
		board.setWriter(Login.getId());
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		board.setWriteTime(dtf.format(now));

		service.insert(board);
	}


}
