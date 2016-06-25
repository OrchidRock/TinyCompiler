package inter;
/**
 *The abstract syntax tree's node class. 
 *
 */
import lexer.*;
public class Node {
	private int lexline=0;
	public Node(){
		lexline=Lexer.line;
	}
	void error(String s){
		throw new Error("near line " + lexline +": "+s);
	}
	static int labels=0; /* be used to branch goto goal address */
	public int newlabel(){return ++labels;} 
	public void emitlable(int i){System.out.print("L"+i+":");}
	public void emit(String s){System.out.println("\t"+s);}
}
