package aron;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.almas.mongol.encode.MongolianConverter;

public class DoConvert {
	//public static String uniqueString = "";
	public static Set<String> uniqueStringSet = new TreeSet<String>();;
	public static int repeatValue = 5;
	public static Map<Character, Integer> CodeRMap = new TreeMap<Character, Integer>()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 6692349167581832122L;

		{
			for(int i = 0xe800; i < 0xe80b ; i++)
			{
				put((Character)((char)i), 0);
			}
			for(int i = 0xe80f; i <= 0xea27 ; i++)
			{
				put((Character)((char)i), 0);
			}
		}
	};
	public DoConvert() throws IOException
	{
		


	}
	
//	static
//	{
//		CodeRMap = new HashMap<Character, Integer>();
//		//SaiYin code
//		
//		
//	}
	public static boolean isValidateMongolianWord(String word)
	{
		if(word == null || word.isEmpty() ||  word.length() == 0)
			return false;
		char chArray[] = new char[word.length()];
		word.getChars(0, chArray.length, chArray, 0);
		for(int i = 0; i < chArray.length; i++)
		{
			if(!MongolianConverter.isMonglianCharacter(chArray[i]))
				return false;
		}
		return true;
	}
	public static void Hi() throws IOException
	{
		File outFile = new File("d:\\mdic.txt");
		FileWriter fileWriter = new FileWriter(outFile);
		for(int i = 0; i <= 10; i++)
		{
			File inFile = new File("E:\\Compiere\\eclipse_ws\\MDIC\\assets\\dictxt\\mdic" + i + ".txt");
	        
	        FileReader fileReader = new FileReader(inFile);
	        int j = 0;
	        try (BufferedReader br = new BufferedReader(fileReader)) {
	            String line;
	            while ((line = br.readLine()) != null) {
	               // process the line.
	            	String words[] = line.split("\\|");
	            	if(j != 0)
	            		fileWriter.write("\r\n");
	            	j++;
	            	if(words.length > 0 && words[0].length() > 0 && isValidateMongolianWord(words[0]))
	            	{
	            		fileWriter.write( MongolianConverter.TrimE8Word(MongolianConverter.convert(words[0])));
	            	}
	            }
	        }
		}
		//fileWriter.write("\r\nEOF");
        fileWriter.close();
        System.out.print("gen to file \""+ outFile.getAbsolutePath()+ "\"");
	}
	public static void main(String[] args) throws Exception {
		//Hi();;
		File inFile = new File("d:\\delehi_tig.txt");
		File outFile = new File("d:\\delehi_tig_e8.txt");
		FileWriter fileWriter = new FileWriter(outFile);
		FileReader fileReader = new FileReader(inFile);
		//int j = 0;
		boolean newLine = false;
        try (BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
            	String words[] = line.split("\\s");
            	for(int j = 0; j < words.length; j++)
            	{
	            	
	            	
	            	if(words.length > 0 && words[j].length() > 0 && isValidateMongolianWord(words[j]))
	            	{
	            		if( newLine)
		            		fileWriter.write("\r\n");
	            		fileWriter.write( MongolianConverter.TrimE8Word(MongolianConverter.convert(words[j])));
	            		fileWriter.flush();
	            		newLine = true;
	            	}
	            	else 
	            	{
	            		System.out.println(words[j]);
	            	}
            	}
            }
        }
        
		new DoConvert().pickWord("d:\\delehi_tig_e8.txt");
		
	}
	public void putToUniqueString(String word) throws Exception
	{
		char[] charArray = new char[word.length()] ;
		word.getChars(0, word.length(), charArray, 0);
		boolean flag = true;
		for(int i = 0; i < charArray.length; i++)
		{
			char ch = charArray[i];
			if(!CodeRMap.containsKey(ch) || CodeRMap.containsKey(ch) && CodeRMap.get(ch) == 0)
			{
				flag = true ;
				break;
			}
			else if(!CodeRMap.containsKey(ch) /*|| CodeRMap.get(ch) >= repeatValue*/)
			{
				flag = false;
			}
		}


		if(flag)
		{
			for(int i = 0; i < charArray.length ; i++)
			{
				if(charArray[i] == 0x0020)
				{
					System.out.println("found space");
				}
				CodeRMap.put(charArray[i], CodeRMap.containsKey(charArray[i]) ? (CodeRMap.get(charArray[i]) + 1) : 1);
			}
			uniqueStringSet.add(word);
		}
	}
	private boolean removeFromUniqueStringSetIfNeed(String word)
	{
		int stop =0;
		char[] charArray = new char[word.length()] ;
		word.getChars(0, word.length(), charArray, 0);
		for(int i = 0; i < charArray.length; i++)
		{
			if(CodeRMap.containsKey(charArray[i]) && CodeRMap.get(charArray[i]) == 1)
			{
				return false;
			}
		}
		for(int i = 0; i < charArray.length; i++)
		{
			try{
				CodeRMap.put(charArray[i], CodeRMap.get(charArray[i]) - 1);
			}
			catch(java.lang.NullPointerException ex)
			{
				 stop =1;
			}
		}
		return true;
	}
	public void pickWord(String fileName ) throws Exception
	{
		Set<String> set = new TreeSet<String>();
		set.clear();
		FileReader fileReader = new FileReader(fileName);
		FileWriter fileWriter = new FileWriter("d:\\E8_word.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))){//new FileReader(fileName), )) {
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
            	String words[] = line.split("\\s");
            	for(int  i = 0; i < words.length  ; i++)
            	{
//            		fileWriter.write( MongolianConverter.convert(words[0]) + "\r\n" );
            		//System.out.println(words[i]);
            		String word = words[i].trim();
            		Character chBom0 = 0xfeff;
            		Character chBom1 = 0xffef;
            		word.replace(chBom0.toString(), " ");
            		word.replace(chBom1.toString(), " ");
            		char[] charArray = new char[word.length()];
            		word.getChars(0, word.length(), charArray, 0);
//            		if()
//            		{
//            			int stop = 1;
//            		}
            		if(charArray.length == 1 && (charArray[0] == 0xfeff || charArray[0] == 0xffef))
            		{
            			continue;
            		}
            		else if(charArray.length > 1 && (charArray[0] == 0xfeff || charArray[0] == 0xffef))
            		{
            			word = word.substring(1);
            		}
            		if(!word.isEmpty() && word != "\ufeff" && word != "\ufffe" )
            		{
            			@SuppressWarnings("unused")
						int stop =1;
            			//System.out.println(word);
            			set.add(word);
            		}
            		
            	}
            	fileReader.close();
            }
            Iterator<String> it = set.iterator();
        	int i = 0;
        	while(it.hasNext())
        	{
        		i++;
        		String word = (String) it.next();//Integer.toString(i++)  + 
        		putToUniqueString(word);
        		//fileWriter.write( word + "\r\n" );
        	}
        	
        	it = uniqueStringSet.iterator();
        	i = 0;
        	while(it.hasNext())
        	{
        		//System.out.println(i);
        		i++;
        		String word = (String) it.next();//Integer.toString(i++)  + 
        		if(removeFromUniqueStringSetIfNeed(word))
        		{
        			it.remove();
        		}
        	}
        	
        	
        	
        	Iterator<Entry<Character, Integer>> itor = CodeRMap.entrySet().iterator();
        	i = 0;
        	while(itor.hasNext())
        	{
        		Entry<Character, Integer> entry = (Entry<Character, Integer>) itor.next();
        		//System.out.println(entry.getKey() + " : " + entry.getValue());
        		i++;
        		fileWriter.write( entry.getKey() + " : " + entry.getValue() + "\r\n" );
        		//String word = (String) it.next();//Integer.toString(i++)  + 
        		//fileWriter.write( word + "\r\n" );
        	}
        	
        	it = uniqueStringSet.iterator();
        	i = 0;
        	while(it.hasNext())
        	{
        		//System.out.println(i);
        		i++;
        		String word = (String) it.next();//Integer.toString(i++)  + 
        		fileWriter.write( word + "\r\n" );
        	}
        	fileWriter.close();
        }
        
        
        
	}


}
