package practice.Book;

public class ISBNNotFoundException extends Exception{
	private String isbn;
	
	public ISBNNotFoundException(String isbn) {
		super(isbn + "해당 isbn을 가진 책이 존재하지 않습니다.");
		this.isbn= isbn;
	
	}
	
	public String getisbn() {
		return isbn;		
	}
}

