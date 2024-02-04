package com.cosmicnet.patterns.structural.composite;

public class HtmlListItem implements IHtmlList{
	String listItem;
	
	HtmlListItem(String listItem) {
		this.listItem = listItem;
	}

	@Override
	public String build() {
		
		StringBuilder s = new StringBuilder("<li>");
		s.append(listItem);
		s.append("</li>");
		return s.toString();
		
		
	}
	

}
