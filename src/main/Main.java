package main;

import parser.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import lexer.*;

public class Main {

	public static void main(String[] args) {
		// if(args.length > 1)
		try {
			File file=new File("src/input2.txt");
			InputStream inputStream=Files.newInputStream(file.toPath());
			Lexer lexer = new Lexer(inputStream);
			Parser parser;
			parser = new Parser(lexer);
			parser.program();
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
