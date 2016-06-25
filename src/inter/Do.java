package inter;

import symbol.Type;

public class Do extends Stmt{
	Expr expr;Stmt stmt;
	public Do(){expr=null;stmt=null;}
	public void init(Expr x,Stmt s){
		expr=x;
		stmt=s;
		if(expr.type!=Type.Bool) 
			expr.error("boolean required in do");
	}
	@Override
	public void gen(int b,int a){
		after=a;
		int label=newlabel();
		stmt.gen(b,label);
		emitlable(label);
		//emit("goto L" + b);
		expr.jumping(b,0);
	}
}
