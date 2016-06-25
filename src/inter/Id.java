package inter;

import lexer.Word;
import symbol.Type;
/**
 * The Id node represent a identifier leaf node.
 */
public class Id extends Expr{
	public int offset=0; /*relative address */
	public Id(Word id,Type p,int b){
		super(id, p);
		offset=b;
	}
}
