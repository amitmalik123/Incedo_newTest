package com.amk.cucumber.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;


public class Prac3 extends Prac22 {
	
	private int z= 19;
	String b="Prac3";
	public static final String pdfPreviewDisclosuresParagraphText = "The performance of the recommended Model Portfolio shown above is hypothetical and does "
			+ "not represent the actual performance of any single client account. The performance includes the deduction of the estimated Portfolio Fee "
			+ "as shown in the proposal under "+"\""+ "Portfolio Administration."+"\""+ " Custody fees are typically included in the Portfolio Fee. If separate custody "
			+ "fees are applicable pursuant to the selected custodian’s client agreement, then it does not include the deduction of separate custody fees. "
			+ "In calculating the hypothetical returns of the recommended portfolio, AssetMark assumed any systematic withdrawals or additions as "
			+ "specified by the client, the estimated fees in this proposal and the hypothetical performance calculations as further described below.";

	
	public Prac3() {
		this(10);
		System.out.println("prac3 cons");
	}

	public Prac3(int a) {
		System.out.println("prac3 cons" + a);
	}
	 
	
	public void a() {
		System.out.println("prac 3 class method "+ z);
	}	
	
	public static void main(String[] args) {
		Prac3 d= new Prac3();	
	//	d.star(3);
		d.dup1();
		/*
		 * LocalDate a= LocalDate.now(); DateUtil dateUtil = new DateUtil();
		 * System.out.println(dateUtil.date()); LocalDate a1=
		 * LocalDate.now().plusDays(6); String dd=
		 * a1.format(DateTimeFormatter.ofPattern("M/d/yy")); System.out.println(dd);
		 */
	}
	
	public static void mm1() {
		LinkedHashMap<String, Integer> jh= new LinkedHashMap<String, Integer>();
//		Map<String, Integer> jh = new HashMap<String, Integer>();
		jh.put("A", 1);
		jh.put("B", 2);
		jh.put("C", 1);
		jh.put("D", 2);
		Set<Entry<String, Integer>> ko= jh.entrySet();
		Iterator<Entry<String, Integer>> po= ko.iterator();
		while(po.hasNext()) {
		System.out.println(po.next());
		}
		jh.forEach((key, value) -> System.out.println(key +" "+ value));
		
		jh.entrySet().stream().forEach(input -> System.out.println(input.getKey()+" "+ input.getValue()));
	}
	
	public void dup() {
		String s= "geeksforgeeks";
		char [] c= s.toCharArray();
		Map<Character, Integer> oi= new HashMap<Character, Integer>();
		for(char c1 :c) {
			int o=1;
			if(oi.containsKey(c1)) {
				oi.put(c1, oi.get(c1)+1);
			}else {
			oi.put(c1, o);
			}
		}
		oi.entrySet().stream().forEach(input -> System.out.println(input.getKey()+" "+ input.getValue()));
	}
	
	public void commonEle() {
		Map<String, Integer> e1= new HashMap<String, Integer>();
		e1.put("A", 1);
		e1.put("B", 2);
		
		Map<String, Integer> e2= new HashMap<String, Integer>();
		e2.put("C", 1);
		e2.put("D", 2);
		e2.put("B", 2);
		
		Map<String, Integer> e3= new HashMap<String, Integer>(e1);
		if(e3.containsKey(e2.keySet())){
			System.out.println();
		}
	}
	
	public void dup1() {
		String s= "geeksforgeeks";
		char [] c= s.toCharArray();
		Map<Character, Integer> oi= new HashMap<Character, Integer>();
		for(char c1 :c) {			
				oi.put(c1, oi.getOrDefault(c1,0)+1);			
		}
		oi.entrySet().stream().forEach(input -> System.out.println(input.getKey()+" "+ input.getValue()));
	}
	
	public void conv() {
		HashMap<String, Integer> jh = new HashMap<String, Integer>();
		jh.put("A", 1);
		jh.put("B", 2);
		jh.put("C", 1);
		jh.put("D", 2);
		
		jh.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry:: getValue));
	}
	
	public void fa() {
		SimpleDateFormat sd= new SimpleDateFormat("YYYY-MM-dd");
		Faker faker= Faker.instance();
		String a= sd.format(faker.date().future(5, TimeUnit.DAYS));
		System.out.println(a);
	}
	
	public void str() {
		String s="TOAR Record created successfully (TTN # 99241630000121)";
		String s1= s.split("#")[1].trim();
		String s2= s1.substring(0, s1.length()-1);
		System.out.println(s2);
	}
	public void permutation() {
		String s= "JSP";
		
	}
	public void preSpace() {
		String s="this is me";
		String s2="";
		String [] sSplit= s.toLowerCase().split(" ");
		for(String s1: sSplit) {
			for(int i=s1.length()-1;i>=0;i--) {
				s2= s2+ s1.charAt(i);
			}
			s2=s2+" ";
		}
		System.out.println(s2);
	}
	
	public void duplicateChars() {
		String s= "Super Man Bat Man";
		char [] sSplit= s.toLowerCase().replaceAll("\\s", "").toCharArray();		
		HashMap<Character, Integer> hm= new HashMap<Character, Integer>();		
		for(Character s1 :sSplit ) {
			int count=1;
			if(hm.containsKey(s1)) {
				hm.put(s1, hm.get(s1)+1);
			}else {
			hm.put(s1, count++);
			}
		}
		System.out.println(hm);
	}	
	
	public void duplicateWords() {
		String s= "Super Man Bat Man Spider Man super spider";
		String [] sSplit= s.toLowerCase().split(" ");		
		HashMap<String, Integer> hm= new HashMap<String, Integer>();		
		for(String s1 : sSplit) {
			int count=1;
			if(hm.containsKey(s1)) {
				hm.put(s1, hm.get(s1)+1);
			}else {
			hm.put(s1, count++);
			}
		}	
		/*
		 * Set<Entry<String, Integer>> es= hm.entrySet(); es.stream().forEach(e->
		 * e.getKey());
		 */
		System.out.println(hm);
	}
	
	public void magicNumber() {
		int i= 9867;
		int sum=0;
		while(i>0   ||   sum > 9) {
			if(i==0) {
				i=sum;
				sum=0;
			}	
			sum=sum+ i%10;
			i=i/10;
		}
		System.out.println(sum);
	}
	
	public void addMetrics() {
		int [] [] a= {
				{1,2,3},
				{4,5,6},
				{7,8,9}};
		int p=0;
		
		for(int i=0;i<1;i++) {
			System.out.println(a.length);
			System.out.println(a[i].length);
			for(int j=a[i].length-1;j>=a.length-1;j--) {				
				p=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=p;
			}
			}
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");		
		}
				
	}
	
	public void rotaryArray() {
		int arr[] = {1, 2, 3, 4, 5, 6, 7};	
		int l= arr.length;
		int [] ar= new int[arr.length];
		int diff= 2;
		int k=0;
		for(int i=diff;i<l;i++) {
			ar[k]=arr[i];
			k++;
		}
		for(int j=0;j<diff;j++) {
			ar[k]=arr[j];
			k++;
		}
		for(int m=0;m<ar.length;m++) {
			System.out.print(ar[m]+" ");
		}
	}
	
	public void star(int a) {
		for(int l=1;l<a;l++) {
			for(int m=l;m<=a;m++) {
				System.out.print(" ");
			}			
			for(int n=1;n<=l;n++) {
				System.out.print("* ");				
			}
			System.out.println("");
		}
		
		
		for (int i = 1; i <= a; i++) {
			for (int j = a - i; j < a; j++) {
				System.out.print(" ");
			}
			for (int k = i; k <= a; k++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
		 
	}
	
	public void distinctElements() {
		ArrayList<String> as1= (ArrayList<String>) List.of("a", "b","c","a","c");
		ArrayList<String> as= new ArrayList<>(List.of("a", "b","c","a","c"));
		System.out.println(as.stream().distinct().collect(Collectors.toList()));
	}
	
	public void evenOdd() {
		ArrayList<Integer> as= new ArrayList<>(List.of(10,23,87,90));
		Map<Boolean, List<Integer>> kl=  as.stream().collect(Collectors.partitioningBy(i -> i%2==0));	
	}
	
	public void strfreq() {		
		ArrayList<String> as= new ArrayList<>(List.of("indiaismycountry"));
	//	System.out.println(as.stream().);
	}
	
	/*
	 * public void abc(String a) { System.out.println("method abc");
	 * "amit".compareTo("aMit"); }
	 */
	
	public void jhu() {		
		  ArrayList<String> as= new ArrayList<>(List.of("a", "b")); 
		  //HashMap<String, String > mss= as.stream().collect(Collectors.toMap(as., null));
		 Map<Boolean, List<String>> newList=  as.stream().collect(Collectors.partitioningBy(s -> s.contains("b")));
		 List<String> top3= as.stream().sorted(Comparator.comparingDouble(null).reversed()).limit(3).collect(Collectors.toList());
		 Map<Boolean, List<String>> newList2=as.stream().collect(Collectors.groupingBy(null));
		 as.stream().collect(Collectors.groupingBy(null, Collectors.counting()));
		 as.stream().collect(Collectors.groupingBy(null, Collectors.averagingDouble(null)));
		 as.stream().collect(Collectors.maxBy(Comparator.comparingDouble(null)));
	}
	
	
	public void abc(String a, String b) {
		boolean sd= "amit".compareTo("aMit")>0;
		System.out.println(sd);
		
	}
	 
	 public void sb() {
		 StringBuffer sb= new StringBuffer();
		 StringBuilder sbb = new StringBuilder();
		 sb.append("amit");
		 System.out.println(sb);
		 sb.insert(2, "sumit");
		 System.out.println(sb);
		 char c= sb.charAt(3);
		 System.out.println(c);
		int i= sb.indexOf("m");
		 System.out.println(i);
		 String su= sb.substring(4);
		 System.out.println(su);
		 String sbs= sb.substring(2, 5);
		 System.out.println(sbs);
	 }
	
	public static  void sPrac() {
		String str1="java";
		String str2="C++";
		String str3="java";
		String str4= new String ("java");
		String str5= new String ("C++");
		String str6= new String ("java").intern();
		System.out.println(str1==str6);
		System.out.println(str4==str6);
	}

}
