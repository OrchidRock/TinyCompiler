package symbol;

import lexer.*;
public class Array extends Type{
	private Type of;     // element type
	private int size=1;  // element count
	public Array(int sz, Type t) {
		super("[]",Tag.INDEX, sz*t.width);
		of=t;
		size=sz;
	}
	public String toString(){
		return "["+size+"] "+of.toString();
	}
}
