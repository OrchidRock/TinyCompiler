package inter;

import symbol.Type;

public class If extends Stmt {
	Expr expr;
	Stmt stmt;
	public If(Expr x,Stmt s){
		expr=x;
		stmt=s;
		if(expr.type!=Type.Bool) 
			expr.error("boolean required in if");
	}
	@Override
	public void gen(int b,int a){
		int label=newlabel();
		expr.jumping(0, a);
		emitlable(label);
		stmt.gen(label, a);
	}
}
