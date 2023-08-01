import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

public class TEST0 {
	
	/*鴻揚科技面試專用，請勿外洩予他人
	 *題目0:
	 * 將一個字串作以下處理
	 * 1. 將",""."全部移除
	 * 2. 切割為WORD後,將句子倒置
	 * 3. 列印出不重複字元及其出現次數
	 * */	
	
	public static void execute(String stInp) {
		if (stInp==null)
			return;
		String[] word = stInp.replace(",", " ").replace(".", " ").split(" ");
		ArrayList<String> arrWord = new ArrayList<String>();
		HashMap hm = new HashMap();
		for (String st:word) {
			if (st!=null && st.length()>0) {
				arrWord.add(0, st);
				if (!hm.containsKey(st)) {
					hm.put(st, st);					
				}
			}
		}
		System.out.println("Reversed String=");
		for (String st:arrWord) {
			System.out.print(st+" ");
		}		
		System.out.println();
		System.out.println();
		System.out.println("All Words=");
		for (Object key:hm.keySet()) {
			System.out.print(key+" ");
		}		
	}
	/* You can test your program here*/
	@Test
	public void testExecute() {

		TEST0.execute("I, Jimmy, saw a saw saw a saw");
	}
	
}
