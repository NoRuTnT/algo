package practice.Book;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {

	private static final int MAX_SIZE = 100;
	private List<Book> bookList = new ArrayList<>();

	private static BookManagerImpl bm = new BookManagerImpl();

	private BookManagerImpl() {
	};

	public static BookManagerImpl getInstance() {
		return bm;
	}

	public void add(Book book) {
		if (bookList.size() < MAX_SIZE) {
			bookList.add(book);

		} else {
			System.out.println("책의 수가 100을 넘었습니다. 등록 불가.");
		}
	}

	public void remove(String isbn) {
		for (int i = 0; i < bookList.size(); i++) {
			if (isbn.equals(bookList.get(i).getIsbn())) {
				bookList.remove(i);
			}
		}

	}

	public Book[] getList() {
		Book[] result = new Book[bookList.size()];
		return this.bookList.toArray(result);
	}

	public Book[] getBooks() {

		List<Book> list = new ArrayList<>();

		for (int i = 0; i < bookList.size(); i++) {
			// 리스트안의 객체가 VipUser 클래스의 인스턴스인지 검사
			if (!(bookList.get(i) instanceof Magazine)) {
				list.add(bookList.get(i));
			}
		}

		Book[] res = new Book[list.size()];

		return list.toArray(res);
	}

	public Magazine[] getMagazine() {

		List<Book> list = new ArrayList<>();

		for (int i = 0; i < bookList.size(); i++) {
			// 리스트안의 객체가 VipUser 클래스의 인스턴스인지 검사
			if (bookList.get(i) instanceof Magazine) {
				list.add((Magazine) bookList.get(i));
			}
		}
		Magazine[] res = new Magazine[list.size()];

		return list.toArray(res);
	}

	public Book[] searchByTitle(String title) {

		List<Book> list = new ArrayList<>();

		for (int i = 0; i < bookList.size(); i++) {
			// 주어진 이름을 포함하는 사용자인지 검사
			if (bookList.get(i).getTitle().contains(title)) {
				list.add(bookList.get(i));
			}
		}

		Book[] res = new Book[list.size()];

		return list.toArray(res);
	}

	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < bookList.size(); i++) {
			sum += bookList.get(i).getPrice();
		}

		return sum;
	}

	public double getPriceAvg() {

		int sum = 0;

		for (int i = 0; i < bookList.size(); i++) {
			sum += bookList.get(i).getPrice();
		}

		return sum / bookList.size();

	}

	public Book searchByIsbn(String isbn) {

		for (int i = 0; i < MAX_SIZE; i++) {
			if (isbn.equals(bookList.get(i).getIsbn())) {
				return bookList.get(i);
			}
		}

		return null;
	}

	public Book sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {

		List<Book> list = new ArrayList<>();
		
		for (int i = 0; i < bookList.size(); i++) {
			if (isbn.equals(bookList.get(i).getIsbn())) {
				if (bookList.get(i).getQuantity() >= quantity) {
					list.add(bookList.get(i));
					bookList.get(i).setQuantity(bookList.get(i).getQuantity() - quantity);
					for(Book buy:list) {
						System.out.println(buy+" ");
					}
					System.out.println();
				} else {
					throw new QuantityException();
				}

			}
		}
		if (list.size() == 0) {
			throw new ISBNNotFoundException(isbn);
		}
		return null;
	}
	
	public Book buy(String isbn, int quantity) throws ISBNNotFoundException {
		
		List<Book> list = new ArrayList<>();
		for (int i = 0; i < bookList.size(); i++) {
			if (isbn.equals(bookList.get(i).getIsbn())) {
				list.add(bookList.get(i));
				bookList.get(i).setQuantity(bookList.get(i).getQuantity() + quantity);
				for(Book buy:list) {
					System.out.println(buy+" ");
				}
				System.out.println();
			}				
			
		}
		if(list.size() == 0) {
			throw new ISBNNotFoundException(isbn);			
		}
		return null;
	}

	

}

