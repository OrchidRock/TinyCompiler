package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import lexer.*;
public class LexerTest {
	private static final String testFileName="src/input1.txt";
	public static void main(String[] args) {
		try {
			String srcfile;
			
			if(args.length>1)
				srcfile=args[1];
			else
				srcfile=testFileName;
			File file=new File(srcfile);
			Token temp;
			Lexer lexer = new Lexer(Files.newInputStream(file.toPath()));
			System.out.print(">");
			while((temp=lexer.scan())!=null){
				System.out.println(temp);
				System.out.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
