package practice.Book;

public class BookTest {
	public static void main(String[] args) {
		
		Book book1 = new Book();
		book1.setIsbn("21424");
		book1.setTitle("Java Pro"); 
		book1.setAuthor("김하나");
		book1.setPublisher("jaen.kr"); 
		book1.setPrice(15000); 
		book1.setDesc("Java 기본 문법"); 
		book1.setQuantity(10);
		
		Book book2 = new Book("21425", "Java pro2", "김하나", "jaen.kr", 25000,"Java 응용",20);
		Book book3 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000,"SW 모델링",30);
		Magazine book4 = new Magazine("45678", "월간 알고리즘","홍길동","jaen.kr",10000,"1월 알고리즘",40,2021,1);
		
		IBookManager bm = BookManagerImpl.getInstance();
		
		bm.add(book1);
		bm.add(book2);
		bm.add(book3);
		bm.add(book4);
		
		
		System.out.println("*********************도서목록**********************");
		Book[] bookList = bm.getList();
		for(Book f : bookList) {
			System.out.println(f);
		}
		System.out.println("*********************일반도서목록********************");
		Book[] searchbookList = bm.getBooks();
		for(Book f : searchbookList) {
			System.out.println(f);
		}
		System.out.println("**********************잡지 목록*********************");
		Book[] searchMagazineList = bm.getMagazine();
		for(Book f : searchMagazineList) {
			System.out.println(f);
		}
		System.out.println("****************도서 제목 포함검색:Java***************");
		Book[] searchByTitle = bm.searchByTitle("Java");
		for(Book f : searchByTitle) {
			System.out.println(f);
		}
		System.out.println("****************도서 판매:21424,11개***************");
		try {
			bm.sell("21424", 11);
		} catch(ISBNNotFoundException e){	
		} catch(QuantityException e) {
		}
		System.out.println("****************도서 구매:21424,10개***************");
		try {
			bm.buy("21424", 10);
		} catch(ISBNNotFoundException e){	
		} 
		System.out.println("****************도서 판매:21424,11개***************");
		try {
			bm.sell("21424", 11);
		} catch(ISBNNotFoundException e){	
		} catch(QuantityException e) {
		}
		System.out.println("도서 가격 총합 : "+bm.getTotalPrice());
		System.out.println("도서 가격 평균 : "+bm.getPriceAvg());
		
		
	}
}
