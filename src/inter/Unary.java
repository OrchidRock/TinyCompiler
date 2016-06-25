package inter;

import lexer.Token;
import symbol.Type;
/**
 * The Unary subtraction 
 *
 */
public class Unary extends Op{
	public Expr expr;
	public Unary(Token tok, Expr expr) {
		super(tok, null);
		this.expr=expr;
		Type type=Type.max(Type.Int, expr.type);
		if(type==null) error("type error");
	}
	public Expr gen(){
		return new Unary(op,expr.reduce());
	}
	public String toString(){
		return op.toString()+" "+expr.toString();
	}
}
