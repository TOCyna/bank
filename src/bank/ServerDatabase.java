package bank;

import java.math.BigInteger;
import java.util.ArrayList;

public class ServerDatabase
{
	public static final ArrayList<ArrayList<Conta>> contas;
	public static final int N = 100;
	static
	{
		contas = new ArrayList<ArrayList<Conta>>();
		for(int i=0;i<N;i++)
		{
			contas.add(new ArrayList<Conta>());
		}
	}
	public static int hashCode(String md5)
	{
		BigInteger bi = new BigInteger(md5, 16);
		BigInteger m = new BigInteger(Integer.toString(N), 10);
		int pos;
		pos = bi.mod(m).intValue();
		return pos;
	}
	public static void insereConta(Conta conta)
	{
		contas.get(hashCode(conta.getMd5())).add(conta);
	}
	public static Conta getConta(String md5)
	{
		Conta conta = null;
		int pos = hashCode(md5);
		if(pos >= 0 && pos < N){
			ArrayList<Conta> Tcontas = contas.get(hashCode(md5));
			if(!Tcontas.isEmpty()){
				for(int i = 0; i < Tcontas.size(); i++){
					if(Tcontas.get(i).getMd5().equals(md5))
						conta = Tcontas.get(i);
				}
			}
		}
		return conta;
	}
}