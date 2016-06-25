package inter;

import lexer.*;
import symbol.*;

public class Expr extends Node {
	public Type type;
	public Token op;  /* the operator token.like '+', '*'  */
	public Expr(Token t,Type p){
		op=t;type=p;
	}
	public Expr gen(){return this;}
	public Expr reduce(){return this;}
	
	public void jumping(int t,int f){
		emitjumps(toString(), t, f);
	}
	public void emitjumps(String test,int t,int f){
		if(t!=0 && f!=0){
			emit("if "+test+" goto L"+t);
			emit("goto L"+f);
		}
		else if(t!=0) emit("if "+test + " goto L"+t);
		else if(f!=0) emit("iffalse "+test +" goto L"+f);
		else;
	}
	public String toString(){
		return op.toString();
	}
}
