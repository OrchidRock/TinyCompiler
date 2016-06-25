package inter;

import lexer.Token;
import symbol.Type;

public class Logical extends Expr{
	public Expr expr1;
	public Expr expr2;
	public Logical(Token t, Expr expr1,Expr expr2) {
		super(t, null);
		this.expr1=expr1;
		this.expr2=expr2;
		if(check(expr1.type, expr2.type)==null)
			error("type error");
	}
	@Override
	public Expr gen(){
		int f=newlabel();
		int a=newlabel();
		Temp temp=new Temp(this.type);
		this.jumping(0, f);
		emit(temp.toString()+" =true");
		emit("goto L"+a);
		emitlable(f);
		emit(temp.toString()+" =false");
		emitlable(a);
		return temp;
	}
	private Type check(Type p1,Type p2){
		if(p1==Type.Bool && p2==Type.Bool) return Type.Bool;
		else return null;
	}
	public String toString(){
		return expr1.toString()+" "+op.toString()+" "+expr2.toString();
	}
}
