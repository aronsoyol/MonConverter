package com.almas.mogol;

import java.util.Set;
import java.util.TreeSet;

import org.xml.sax.Attributes;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class GlyfMinSet  {
	
	static Set<Set<Character>> allGlyfSet= new TreeSet<Set<Character>>();
	static
	{
		Set<Character> sameGlfSet = new TreeSet<Character>();
		//sameGlfSet.add(e)
	}
	char glyf[][]= {
			{0xe820},
			{0xe821,0xe828},
			{0xe822,0xe82B},
			{0xe823,0xe82C},
	};
	public  static void main(String[] args)
	{
		try {
            // SAXパーサの生成
            XMLReader parser = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
            // フィーチャーの設定
            parser.setFeature("http://xml.org/sax/features/validation",true);
            parser.setFeature("http://apache.org/xml/features/validation/schema",true);
            parser.setFeature("http://xml.org/sax/features/namespaces",true);
            // ハンドラの生成
            DefaultHandler handler = new MySAXHandler();
            // ハンドラの登録
            parser.setContentHandler(handler);
            parser.setDTDHandler(handler);
            parser.setErrorHandler(handler);
            // 解析
            parser.parse(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
class MySAXHandler extends DefaultHandler {
    // ContentHandlerの実装
    public void startDocument() throws SAXException {
	    System.out.println("startDocument()");
    }
    public void endDocument() throws SAXException {
	    System.out.println("endDocument()");
    }
    public void startElement(java.lang.String uri,
                       java.lang.String localName,
                       java.lang.String qName,
                       Attributes atts)
                throws SAXException {
	    System.out.println("startElement()");
	    System.out.println("\tnamespace=" + uri);
	    System.out.println("\tlocal name=" + localName);
	    System.out.println("\tqualified name=" + qName);
	    for (int i = 0; i < atts.getLength(); i++) {
		    System.out.println("\tattribute name=" + atts.getLocalName(i));
		    System.out.println("\tattribute qualified name=" + atts.getQName(i));
		    System.out.println("\tattribute value=" + atts.getValue(i));
		}
    }
    public void endElement(java.lang.String uri,
                       java.lang.String localName,
                       java.lang.String qName)
                throws SAXException {
        System.out.println("endElement()");
    }
    public void characters(char[] ch,
                       int start,
                       int length)
                throws SAXException {
        System.out.println("characters()" + new String(ch, start, length));
    }
    // ErrorHandlerの実装
    public void warning(SAXParseException e) {
        System.out.println("警告: " + e.getLineNumber() +"行目");
        System.out.println(e.getMessage());
    }
    public void error(SAXParseException e) {
        System.out.println("エラー: " + e.getLineNumber() +"行目");
        System.out.println(e.getMessage());
    }
    public void fatalError(SAXParseException e) {
        System.out.println("深刻なエラー: " + e.getLineNumber() +"行目");
        System.out.println(e.getMessage());
    }
}