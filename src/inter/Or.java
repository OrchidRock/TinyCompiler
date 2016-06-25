package inter;

import lexer.Token;

public class Or extends Logical{

	public Or(Token t, Expr expr1, Expr expr2) {
		super(t, expr1, expr2);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void jumping(int t,int f){
		int lable=(t!=0) ? t : newlabel();
		expr1.jumping(lable, 0);
		expr2.jumping(t, f);
		if(t==0)
			emitlable(lable);
	}
}
