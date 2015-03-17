package com.almas.font;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;



public class FCXmlParser extends DefaultHandler{

	Locator locator;
	private File outFile = null;//new File("d:\\mdic.txt");
	private FileWriter fileWriter = null;//new FileWriter(outFile);
	//File file = new File(file_name);
	//FileWriter filewriter = new FileWriter(file);
	private BufferedWriter bbWriter = null;//new BufferedWriter(filewriter);
	private ArrayList<Composite> glyfList = null ;
	private Stack<Elem> elemStack = null;
	public FCXmlParser() throws IOException
	{
		outFile = new File("xml\\parsed.txt");
		fileWriter = new FileWriter(outFile);
		bbWriter = new BufferedWriter(fileWriter);
		glyfList = new ArrayList<Composite>();
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream theStreamToParse = null;
		InputSource inputsource = null;
		
		try {
			String current = new java.io.File( "." ).getCanonicalPath();
	        System.out.println("Current dir:"+current);
			theStreamToParse = new FileInputStream("C:\\Program Files (x86)\\High-Logic FontCreator\\Composites\\CompositeData.xml");
			inputsource = new InputSource(theStreamToParse);
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();

            // ハンドラの生成
			FCXmlParser handler = new FCXmlParser();


            // 解析
            parser.parse(inputsource, handler);
            handler.writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	public void writeToFile() throws IOException
	{
		int i = 0;
		try{
			for( i = 0; i < glyfList.size(); i++)
			{
				if(glyfList.get(i).ToString() == null)
				{
					System.out.println("error AAAAAAAA");
				}
				bbWriter.write(glyfList.get(i).ToString());
				bbWriter.flush();
			}
		}
		catch(java.lang.NullPointerException ex)
		{
			System.out.println("error line:"+ i + ", glyfList.size()+ "+ glyfList.size());
			ex.printStackTrace();
		}
	}
    public void startDocument() throws SAXException {
    	System.out.println("startDocument()");

    	elemStack = new Stack<Elem>();

    }
    public void endDocument() throws SAXException {
	    System.out.println("endDocument()");
	    
    }
    public void startElement(java.lang.String uri,
            java.lang.String localName,
            java.lang.String qName,
            Attributes atts)
     throws SAXException {
		//System.out.println("startElement()");
		//System.out.println("\tnamespace=" + uri);
		//System.out.println("\tlocal name=" + localName);
		//System.out.println("\tqualified name=" + qName);
		Elem elem = null; 
		switch (qName) 
		{
		case "Composite":
		 	elem = new Composite();
		 	elem.name = "Composite";break;
		case "GlyphMapping":
		 	elem = new GlyphMapping();
		 	elem.name = "GlyphMapping";break;
		case "Member":
		 
		 	elem = new Member();
		 	elem.name = "Member";
		 	break;
		case "UseMetrics":
		 
			elem = new UseMetrics();
		 	elem.name = "UseMetrics";
		 	break;
		default:
			break;
		}
		if(elem != null)
		{
			elemStack.push(elem);
			
			System.out.println("<"+elem.name+">");
		}
	}
    public void endElement(java.lang.String uri,
            java.lang.String localName,
            java.lang.String qName)
     throws SAXException {
	//try {
	//	bWriter.write("endElement()\n");
	//} catch (IOException e) {
	//	// TODO Auto-generated catch block
	//	e.printStackTrace();
	//}
    	if(qName != "DATA" && qName != "Composites")
    	{
			Elem elem = elemStack.pop();
			System.out.println("</"+elem.name+">");
			if(elemStack.size() != 0)
			{
				Elem elemParent = elemStack.lastElement();
				
				if(elemParent.name != "DATA" && elemParent.name != "Composites")
				{
					elemParent.putElem(elem);
				}
			}
			else
			{
				glyfList.add((Composite)elem);
			}
    	}
	}
    public void characters(char[] ch,
                       int start,
                       int length)
                throws SAXException {
    	if(elemStack != null &&  elemStack.size() > 0 && length > 0)
    	{
    		if(true)//elemStack.firstElement().name != "Composite" && elemStack.firstElement().name != "Member")
    		{
    			elemStack.lastElement().text = new String(ch, start, length);
    			System.out.println("[" + new String(ch, start, length).trim() + "] " + elemStack.lastElement().name);
    		}
    	}
    }
    public void warning (SAXParseException e)
	    throws SAXException
	{
	System.out.println("Warning:"+e.getMessage()
	              + "line:" + locator.getLineNumber()
	              + ", column:" + locator.getColumnNumber());
	}
	
	public void error (SAXParseException e)
	    throws SAXException
	{
	System.out.println("Error:"+e.getMessage()
	              + "line:" + locator.getLineNumber()
	              + ", column:" + locator.getColumnNumber());
	throw e;
	}
	
	
	public void fatalError (SAXParseException e)
	    throws SAXException
	{
	System.out.println("Fatal error:"+e.getMessage()
	              + "line:" + locator.getLineNumber()
	              + ", column:" + locator.getColumnNumber());
	throw e;
	}

}
