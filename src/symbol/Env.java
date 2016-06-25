package symbol;
import java.util.Hashtable;

import lexer.*;
import inter.*;
/*
 *Enviroment for every block.Each Env-object
 *hold a symbol table and a prev  Env-object.
 *All Env-block build a table tree.
 */
public class Env {
	private Hashtable<Token, Id> table;
	protected Env prev;
	public Env(Env e) {
		table=new Hashtable<>();
		prev=e;
	}
	public void put(Token t,Id i){
		table.put(t, i);
	}
	public Id get(Token w){
		for(Env e=this;e!=null;e=e.prev){
			Id found=(Id)e.table.get(w);
			if(found!=null)
				return found;
		}
		return null;
	}
}
