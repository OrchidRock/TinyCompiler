package symbol;

import lexer.*;
public class Array extends Type{
	public Type of;     // element type
	public int size=1;  // element count
	public Array(int sz, Type t) {
		super("[]",Tag.INDEX, sz*t.width);
		of=t;
		size=sz;
	}
	public String toString(){
		return "["+size+"] "+of.toString();
	}
}
