package inter;

import lexer.Token;
import symbol.Type;

public class Arith extends Op{
	public Expr expr1;
	public Expr expr2;
	public Arith(Token tok,Expr expr1,Expr expr2 ) {
		super(tok, null);
		this.expr1=expr1;
		this.expr2=expr2;
		Type type=Type.max(expr1.type, expr2.type);
		if(type==null) error("type error");
	}
	public Expr gen(){
		return new Arith(this.op, expr1.reduce(), expr2.reduce());
	}
	public String toString(){
		return expr1.toString()+" "+op.toString()+" "+expr2.toString();
	}
}
