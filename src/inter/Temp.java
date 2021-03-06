package inter;

import lexer.Word;
import symbol.Type;

public class Temp extends Expr {
	static int count = 0;
	int number = 0;

	public Temp(Type type) {
		super(Word.temp, type);
		number = ++count;
	}

	public String toString() {
		return Word.temp.lexeme + number;
	}
}
