package com.almas.font;

import java.util.ArrayList;
//
//解析FontCreator的XML文件
//
public abstract class Elem {
	String name;
	String text;
	abstract void putElem(Elem e);
	//abstract void write(FileWriter writer);
	
}
class GlyphMapping extends Elem{

	@Override
	void putElem(Elem e) {
		// TODO Auto-generated method stub
		//do nothing
	}
	String getCode()
	{
		if(text != null)
			return String.format("0x%X", Integer.parseInt(text) );
		else
			return new String("");
	}
//	@Override
//	void write(FileWriter writer) {
//		// TODO Auto-generated method stub
//		writer.write(str);
//	}
	
}
class UseMetrics extends Elem{

	@Override
	void putElem(Elem e) {
		// TODO Auto-generated method stub
		//do nothing
	}
	
}
class Member extends Elem{
	private int id;
	GlyphMapping map;
	UseMetrics useMetrics;
	@Override
	void putElem(Elem e) {
		// TODO Auto-generated method stub
		if(e.name == "GlyphMapping")
		{
			map = (GlyphMapping)e;
		}
		else if (e.name == "UseMetrics")
		{
			useMetrics = (UseMetrics)e;
		}
	}
}

class Composite extends Elem{
	private GlyphMapping map = null;
	private ArrayList<Member> memberList = null;
	Composite()
	{
		memberList = new ArrayList<Member>();
	}
	@Override
	void putElem(Elem e) {
		// TODO Auto-generated method stub
		if(e.name == "GlyphMapping")
		{
			map = (GlyphMapping)e;
		}
		else if (e.name == "Member")
		{
			memberList.add((Member)e);
		}
	}
	
	String ToString()
	{
		String comp = new String();
		comp += "\tput(" + map.getCode() + ", new Integer[]{";
		//comp +=  " : ";
		for(int i= 0; memberList != null && i < memberList.size(); i++)
		{
			try{
				if(i > 0) 
					comp += ", ";
				comp += (memberList.get(i).map.getCode());
				
			}
			catch(java.lang.NullPointerException ex)
			{
				@SuppressWarnings("unused")
				int stop=1;
			}
		}
		comp += "});\r\n";
		return comp;
	}
}