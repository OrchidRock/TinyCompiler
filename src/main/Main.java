package main;
import  parser.*;
import lexer.*;
public class Main {

	public static void main(String[] args) {
		Lexer lexer=new Lexer(System.in);
		Parser parser=new Parser(lexer);
		parser.program();
		System.out.println();
	}

}
