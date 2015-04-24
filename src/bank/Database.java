package bank;

import java.util.ArrayList;

public class Database {
	public static final ArrayList<Letra> caracteres;
	static {
		caracteres = new ArrayList<Letra>();
		Letra l = null;
		for(int i = 0; i < 26; i++) {
			//a to z
			l = new Letra(Character.toString((char)(i + 'a')));
			caracteres.add(l);
			//A to Z
			l = new Letra(Character.toString((char)(i + 'A')));
			caracteres.add(l);
		}
		for(int i = 0; i < 10; i++) {
			//0 to 9
			l = new Letra(Character.toString((char)(i + '0')));
			caracteres.add(l);
		}
		//" "
		caracteres.add(new Letra(Character.toString((char)(32))));
	}
	public static Letra getLetra(String md5) {
		for(int i = 0; i < caracteres.size(); i++)
			if(caracteres.get(i).getMd5Code().equals(md5))
				return caracteres.get(i);
		return null;
	}
	public static Conta getConta(String[] chars) {
		String str = ""; //cleans str
		
		//decode chars and build a string
		for(int i = 1; i < chars.length; i++) {
			Letra l = getLetra(chars[i]);
			str += l.getCaractere();
		}
		
		//split informations in str
		chars = str.split(" ");
		
		//build name
		str = chars[0]; //first name
		for(int i = 1; i < chars.length-1; i++)
			str += " " + chars[i]; //others name
		
		//Conta(nome, saldo)
		return new Conta(str, chars[chars.length-1]);
	}
}
