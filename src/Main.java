import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0;
		
		List<Article> articles = new ArrayList<>(); 
		
		while (true) {
			System.out.println("명령어) ");
			String cmd = sc.nextLine();
			
			if (cmd.equals("exit")) {
				break;
			}
				
			if (cmd.equals("article write")) {
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				
				int id = ++lastArticleId;
				Article article = new Article(id, title, body);
				articles.add(article);
				
				System.out.printf("%d번 글이 생성되었습니다.\n", lastArticleId);
				
			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("존재하는 게시물이 없습니다.");
					continue;
				}
				
				System.out.println("번호	|	제목");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d	|	%s\n", article.id, article.title);
				}
			System.out.println();
			} 		
		}
		sc.close();
		
		System.out.println("== 프로그램 끝 ==");
	}
}

class Article {
	int id;
	String title;
	String body;
	
	Article (int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
		
	}
}
