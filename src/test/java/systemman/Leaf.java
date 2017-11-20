package systemman;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 测试this
 * @author zzy
 *
 */
public class Leaf {
	private int i = 0;
	
	public Leaf incremment(){
		i++;
		return this;
	}
	
	public void print(){
		System.out.println("i="+i);
	}
	public static void main(String[] args) {
		Leaf l = new Leaf();
		
		l.incremment().incremment().print();
		System.out.println(l.equals(l.incremment()));
		System.out.println(l == l.incremment());
		System.out.println(l.equals(new Leaf()));
		System.out.println("===================================");
		String a = new String("11");
		String b = "11";
		String c = "11";
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(a == c);
		StringBuffer buf = new StringBuffer();
		StringBuilder bul = new StringBuilder();
		bul.append("a").append("b");
		bul.append("中");
		bul.append("国");
		System.out.println(bul.toString());
		ArrayList list = new ArrayList();
		HashMap map = new HashMap();
		
		System.out.println(10 + (10 >> 1));
		
		System.out.println("=========================");
		byte[] bb = {0x00};
		System.out.println("aaaa["+new String(bb)+"]");
	}
}
