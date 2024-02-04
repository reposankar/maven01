package com.cosmicnet.patterns.structural.composite;

import java.util.List;
import java.util.ArrayList;

public class HtmlList implements IHtmlList{
	
	private List<IHtmlList> list;
	private String listItem;
	
	HtmlList(String listItem) {
		this.listItem = listItem;
	}
	
	public void add(IHtmlList listItem) {
		if(list == null)
			list = new ArrayList<>();
		list.add(listItem);
	}
	public void remove(IHtmlList listItem) {
		list.remove(listItem);
	}


	@Override
	public String build() {
		StringBuilder s = new StringBuilder("<li>");
		s.append(listItem);
		s.append("</li>\n<ul>");
		for(IHtmlList l:list) {
			s.append(l.build());
		}
		s.append("</ul>");
		return s.toString();
		
	}

}
