package inter;

import lexer.Token;
import symbol.Type;

public class Op extends Expr {
	
	public Op(Token t, Type p) {
		super(t, p);
	}
	@Override
	public Expr reduce(){
		Expr x=gen();
		Temp t=new Temp(type);
		this.emit(t.toString()+" = "+x.toString());
		return t;
	}
}
