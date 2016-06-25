package inter;

public class Seq extends Stmt{
	Stmt stmt1;Stmt stmt2;
	public Seq(Stmt s1,Stmt s2){
		stmt1=s1;
		stmt2=s2;
	}
	public void gen(int b,int a){
		int label=newlabel();
		stmt1.gen(b, label);
		emitlable(label);
		stmt2.gen(label, a);
	}
}

