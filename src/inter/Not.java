package inter;

import lexer.Token;

public class Not extends Logical{

	public Not(Token t, Expr expr2) {
		super(t, expr2, expr2);
	}
	@Override
	public void jumping(int t,int f){
		expr2.jumping(f, t);
	}
	@Override
	public String toString(){
		return op.toString()+" "+expr2.toString();
	}
}
