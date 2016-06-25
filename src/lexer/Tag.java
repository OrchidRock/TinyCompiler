package lexer;

public class Tag {
	public final static int 
		AND=256,  BASIC=257,  BREAK=258,  DO=259,  ELSE=260,
		EQ =261,  FALSE=262,  GE   =263,  ID=264,  IF  =265,
		INDEX=266,LE   =267,  MINUS=268,  NE=269,  NUM =270,
		OR =271,  REAL =272,  TEMP =273,  TRUE=274,WHILE=275;
	public static String getTagName(int t){
		String rString;
		switch (t) {
		case 256:
			rString="NUM";
			break;
		case 257:
			rString="ID";
			break;
		case 258:
			rString="TRUE";
			break;
		case 259:
			rString="FALSE";
			break;
		default:
			rString="";
			break;
		}
		return rString;
	}
}
