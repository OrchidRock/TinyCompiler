package lexer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

import symbol.Type;

public class Lexer {

	private InputStream in;
	public static int line = 1;
	private final static int EOF = 65535;
	private char peak = ' ';
	private Hashtable<String, Word> words = new Hashtable<>();

	public Lexer(InputStream stream) {
		/* reserved word */
		reserve(new Word("if", Tag.IF));
		reserve(new Word("else", Tag.ELSE));
		reserve(new Word("while", Tag.WHILE));
		reserve(new Word("do", Tag.DO));
		reserve(new Word("break", Tag.BREAK));
		reserve(Word.True);
		reserve(Word.False);
		reserve(Type.Int);
		reserve(Type.Char);
		reserve(Type.Float);
		reserve(Type.Bool);
		in = stream;
	}

	public Token scan() throws IOException {
		/* ignore blank or tab or annotation */
		for (;; peak = (char) in.read()) {
			if (peak == EOF)
				return null;
			else if (peak == ' ' || peak == '\t')
				continue;
			else if (peak == '\n')
				line++;
			else if (peak == '/') {
				readch();
				if (peak == '/') {
					while (peak != '\n')
						readch();
				} else if (peak == '*') {
					readch();
					while (true) {
						if (peak == '\n')
							line++;
						if (peak == EOF) {
							System.out.println("Syntax error at line " + line);
							return null;
						}
						if (peak == '*' && readch('/'))
							break;
						else
							readch();
					}
				} else {
					System.out.println("Syntax error at line " + line);
				}
			} else
				break;
		}
		/* logical and compare symbol */
		switch (peak) {
		case '&':
			if (readch('&'))
				return Word.and;
			else
				return new Token('&');
		case '|':
			if (readch('|'))
				return Word.or;
			else
				return new Token('|');
		case '=':
			if (readch('='))
				return Word.eq;
			else
				return new Token('=');
		case '!':
			if (readch('='))
				return Word.ne;
			else
				return new Token('!');
		case '<':
			if (readch('='))
				return Word.le;
			else
				return new Token('<');
		case '>':
			if (readch('='))
				return Word.ge;
			else
				return new Token('>');
		default:
			break;
		}
		/* integer or float but .xxxx is invalid */
		if (Character.isDigit(peak) || peak == '.') {
			int v = 0;
			do {
				if(peak=='.')
					break;
				v = v * 10 + Character.digit(peak, 10);
				readch();
			} while (Character.isDigit(peak));
			if (peak != '.')
				return new Num(v);
			float f = v;
			float d = 10;
			for (;;) {
				readch();
				if (!Character.isDigit(peak))
					break;
				f = f + Character.digit(peak, 10) / d;
				d *= 10;
			}
			return new Real(f);
		}
		/* keyword or identifier */
		if (Character.isLetter(peak)) {
			StringBuffer buffer = new StringBuffer();
			do {
				buffer.append(peak);
				peak = (char) in.read();
			} while (Character.isLetterOrDigit(peak));
			String s = buffer.toString();
			Word w = words.get(s);
			if (w == null) { /* identifier */
				w = new Word(s, Tag.ID);
				words.put(s, w);
			}
			return w;
		}
		Token token = new Token(peak);
		peak = ' ';
		return token;
	}

	private void reserve(Word w) {
		words.put(w.lexeme, w);
	}

	private void readch() throws IOException {
		peak = (char) in.read();
	}

	private boolean readch(char c) throws IOException {
		readch();
		if (peak != c)
			return false;
		peak = ' '; /* next peak still equal c */
		return true;
	}
}
