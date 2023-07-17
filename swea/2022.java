import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GabjaTest {
	public static void main(String[] args) {
		String[] gan = {"갑","을","병","정","무","기","경","신","임","계"};
		String[] zi = {"자","축","인","묘","진","사","오","미","신","유","술","해"};
		Scanner sc = new Scanner(System.in);
		System.out.print("60갑자를 입력하세요: ");
		String gabja = sc.next();
		String[] gabja_lst = gabja.split("");
		String a = gabja_lst[0];
		String b = gabja_lst[1];
		String finish = "종료";
		List<String> ganList = new ArrayList<>(Arrays.asList(gan));
		List<String> ziList = new ArrayList<>(Arrays.asList(zi));
		while(!gabja.equals(finish)) {
			if(ganList.contains(a) && ziList.contains(b)) {
				int index_gan = Arrays.asList(gan).indexOf(a);
				int index_zi = Arrays.asList(zi).indexOf(b);
				int year = 0;
				
				switch(Math.abs(index_gan-index_zi)) {
				
				case 0:
					year = 1444+index_gan;	
					break;
				case 2:
					if (index_gan-index_zi>0) {
						year = 1454+index_gan;
					} else {
						year = 1494+index_gan;
					}
					
					
					break;
				case 4:
					if (index_gan-index_zi>0) {
						year = 1464+index_gan;
					} else {year = 1484+index_gan;
						
					}			
					break;
				case 6:
					year = 1474+index_gan;
					break;
				case 8:
					year = 1464+index_gan;
					break;
				case 10:
					year = 1444+index_zi;
					break;
				}
				for (int i=5; i<11; i++) {
					if (year+(60*i)>=1800 && year+(60*i)<=2100) {
						System.out.print(year+(60*i)+" ");
					}	
				}
				System.out.println();
				System.out.print("60갑자를 입력하세요: ");
				gabja = sc.next();
				gabja_lst = gabja.split("");
				a = gabja_lst[0];
				b = gabja_lst[1];
				ganList = new ArrayList<>(Arrays.asList(gan));
				ziList = new ArrayList<>(Arrays.asList(zi));
				
				
				
				
			} else {
				System.out.println("잘못된 입력");
				System.out.print("60갑자를 입력하세요: ");
				gabja = sc.next();
				gabja_lst = gabja.split("");
				a = gabja_lst[0];
				b = gabja_lst[1];
				ganList = new ArrayList<>(Arrays.asList(gan));
				ziList = new ArrayList<>(Arrays.asList(zi));
				
			}
				
			
		}
		
		
		
	}

}
