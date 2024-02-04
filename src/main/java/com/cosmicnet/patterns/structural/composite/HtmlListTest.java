package com.cosmicnet.patterns.structural.composite;

public class HtmlListTest {
	public static void main(String[] args) {
		String htmlStart = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"utf-8\" />\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "    <title>GoF Design Patterns</title>\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n"
				+ "    <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css\\main.css\" />\r\n"
				+ "    <script src=\"js\\main.js\"></script>\r\n"
				+ "  </head>\r\n"
				+ "  <body>\r\n"
				+ "    <h1>Gang of Four Design Patterns</h1>";
		String htmlEnd = "  </body>\r\n"
				+ "</html>";
		String htmlMid = "";
		

		HtmlList lg1 = new HtmlList("Creational Pattern");
		lg1.add(new HtmlListItem("Singleton Pattern"));
		lg1.add(new HtmlListItem("Builder Pattern"));
		lg1.add(new HtmlListItem("Prototype Pattern"));
		
		HtmlList lg11 = new HtmlList("Factory Patterns");
		lg11.add(new HtmlListItem("Factory Method Pattern"));
		lg11.add(new HtmlListItem("Abstract Factory Pattern"));
		lg1.add(lg11);
		
		HtmlList lg2 = new HtmlList("Structural Pattern");
		lg2.add(new HtmlListItem("Adapter Pattern"));
		lg2.add(new HtmlListItem("Bridge Pattern"));
		lg2.add(new HtmlListItem("Composite Pattern"));
		lg2.add(new HtmlListItem("Decorator Pattern"));
		lg2.add(new HtmlListItem("Facade Pattern"));
		lg2.add(new HtmlListItem("Flyway Pattern"));
		lg2.add(new HtmlListItem("Proxy Pattern"));
		HtmlList lg3 = new HtmlList("Behavioural Pattern");
		lg3.add(new HtmlListItem("Iterator Pattern"));
		lg3.add(new HtmlListItem("Interpreter Pattern"));
		lg3.add(new HtmlListItem("Mediator"));
		lg3.add(new HtmlListItem("Memento Pattern"));
		lg3.add(new HtmlListItem("Observation Pattern"));
		lg3.add(new HtmlListItem("Strategy pattern"));
		lg3.add(new HtmlListItem("State Pattern"));
		lg3.add(new HtmlListItem("Template Method Pattern"));
		lg3.add(new HtmlListItem("Visitor Pattern"));
		lg3.add(new HtmlListItem("Chain of responsibility Pattern"));
		lg3.add(new HtmlListItem("Command"));
		HtmlList lg = new HtmlList("GoF Design Patterns");
		lg.add(lg1);
		lg.add(lg2);
		lg.add(lg3);
		htmlMid = lg.build();
		System.out.println(htmlStart+"<ul>"+htmlMid+"</ul>"+htmlEnd);
		
		
	}

}
