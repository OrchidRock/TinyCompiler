package inter;

import symbol.Type;

public class Else extends Stmt {
	Expr expr;Stmt stmt1;Stmt stmt2;
	public Else(Expr x,Stmt s1,Stmt s2){
		expr=x;
		stmt1=s1;
		stmt2=s2;
		if(expr.type!=Type.Bool) 
			expr.error("boolean required in if");
	}
	public void gen(int b,int a){
		int lable1=newlabel();//for stmt1
		int label2=newlabel();//for stmt2
		expr.jumping(0, label2);
		emitlable(lable1);
		stmt1.gen(lable1, a);
		emit("goto L"+a);
		emitlable(label2);
		stmt2.gen(label2, a);
	}
}
