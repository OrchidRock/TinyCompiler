package symbol;

import lexer.*;
public class Type extends Word{
	public int width=0;
	public Type(String s, int t,int w) { /*width is the byte-size of type(include array)*/
		super(s, t);
		this.width=w;
	}
	public static final Type
		Int=new Type("int", Tag.BASIC, 4),
		Float=new Type("float", Tag.BASIC, 8),
		Char=new Type("char", Tag.BASIC, 1),
		Bool=new Type("bool", Tag.BASIC, 1);
	/*if type is int or char or float return true*/
	public static boolean numeric(Type p){
		if(p==Type.Char || p==Type.Int || p==Type.Float) return true;
		return false;
	}
	public static Type max(Type p1,Type p2){
		if(!numeric(p1) || !numeric(p2)) return null;
		else if(p1==Type.Float || p2==Type.Float) return Type.Float;
		else if(p1==Type.Int   || p2==Type.Int  ) return Type.Int;
		else return Type.Char;
	}
}
