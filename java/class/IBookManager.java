package practice.Book;

public interface IBookManager {
	void add(Book book);
	void remove(String isbn);
	Book[] getList();
	Book[] getBooks();
	Magazine[] getMagazine();
	Book[] searchByTitle(String title);
	int getTotalPrice();
	double getPriceAvg();
	Book searchByIsbn(String isbn);
	Book sell(String string, int i) throws QuantityException, ISBNNotFoundException;
	Book buy(String string, int i) throws ISBNNotFoundException;

}
