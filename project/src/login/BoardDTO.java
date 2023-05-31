package login;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BoardDTO {
	private SimpleIntegerProperty num;
	private SimpleStringProperty title;
	private SimpleStringProperty content;
	private SimpleStringProperty writer;
	private SimpleStringProperty writeTime;
	private SimpleIntegerProperty hits;
	private SimpleIntegerProperty likes;
	
	public BoardDTO(int num, String title, String content, String writer, String writeTime, int hits, int likes) {
		super();
		this.num = new SimpleIntegerProperty(num);
		this.title = new SimpleStringProperty(title);
		this.content = new SimpleStringProperty(content);
		this.writer = new SimpleStringProperty(writer);
		this.writeTime = new SimpleStringProperty(writeTime);
		this.hits = new SimpleIntegerProperty(hits);
		this.likes = new SimpleIntegerProperty(likes);
	}
	
	public int getNum() {
		return num.get();
	}
	public void setNum(int num) {
		this.num = new SimpleIntegerProperty(num);
	}
	public String getTitle() {
		return title.get();
	}
	public void setTitle(String title) {
		this.title = new SimpleStringProperty(title);
	}
	public String getContent() {
		return content.get();
	}
	public void setContent(String content) {
		this.content = new SimpleStringProperty(content);
	}
	public String getWriter() {
		return writer.get();
	}
	public void setWriter(String writer) {
		this.writer = new SimpleStringProperty(writer);
	}
	public String getWriteTime() {
		return writeTime.get();
	}
	public void setWriteTime(String writeTime) {
		this.writeTime = new SimpleStringProperty(writeTime);
	}
	public int getHits() {
		return hits.get();
	}
	public void setHits(int hits) {
		this.hits = new SimpleIntegerProperty(hits);
	}
	public int getLikes() {
		return likes.get();
	}
	public void setLikes(int likes) {
		this.likes = new SimpleIntegerProperty(likes);
	}

}
