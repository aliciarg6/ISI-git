package com.comparadorsamialicia;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;



@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
      
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    response.getWriter().print("Hello App Engine!\r\n");
    
    String producto="agua";
    obtenerEAN(producto);
    
    
    //String resultado = ejecutar();
    //response.getWriter().print(resultado);

  }
  
  public void obtenerEAN( String producto) {
	  Document doc = Jsoup.connect("https://www.hipercor.es/supermercado/buscar/?term="+producto).get();
	  Elements ean = doc.select("p.info-item");
	  
	  for (int i=0; i<ean.size();i++) {
		  System.out.println(ean.get(i));
	  }
	  
	  
  }
  
 
  /*
  public String ejecutar() {

		//System.out.println("Mete el nombre del producto:");
		//Scanner entrada = new Scanner(System.in);
		//String nombre = entrada.nextLine();
		//String resultado = entrada.nextLine();
		
		String nombre = "agua";
		String resultado = "agua";
		
		try {
			//Obtener HTML
			Document document = Jsoup.connect("https://www.carrefour.es/supermercado/c?Ntt="+nombre+"&sb=true").get();
			Document doc = Jsoup.connect("https://www.hipercor.es/supermercado/buscar/?term="+nombre).get();
			
			//CARREFOUR
			//Titulo de la página Web
			String title = document.title();
			System.out.println("Nombre Supermercado: " + title);
		
			//Array de elementos con todos los precios
			Elements info = document.select("article.item"); 
			
			//Imprimir todos los elementos
			
			for (int i=0; i < info.size(); i++) {
				
				System.out.print(info.get(i).text());
				System.out.println(" ");
			}
			System.out.println("\n");
			
			
			//HIPERCOR
			String title1 = doc.title();
			System.out.println("Nombre Supermercado: " + title1);
			
			//Array de elementos con todos los precios
			Elements prices1 = doc.select("div.product_tile-price_holder"); 
			Elements names1 = doc.select("h3.product_tile-description"); //Obtener nombre
			
			//Imprimir todos los elementos
			for (int i=0; i < prices1.size(); i++) {
				System.out.print(names1.get(i).text() );
				System.out.print(" ");
				System.out.print(prices1.get(i).text());
				System.out.println(" ");
			}
			
			System.out.println(" ");
			System.out.println(" ");
			
			//SUPERMERCADO DIA
			Document dia = Jsoup.connect("https://www.dia.es/compra-online/search?text="+nombre+"&x=0&y=0").get();
			
			String titleDia = dia.title();
			System.out.println("Nombre Supermercado: " + titleDia);
			
			Elements nameDia = dia.select("span.details"); 
			Elements  precioDia= dia.select("p.price");
			
			for (int i=0; i < nameDia.size(); i++) {
				System.out.print(nameDia.get(i).text() );
				System.out.print(" ");
				System.out.print(precioDia.get(i).text());
				System.out.println(" ");
			}
			
			System.out.println(" ");
			System.out.println(" ");
			
			//SUPERMERCADO EROSKI
			Document eroski = Jsoup.connect("https://www.compraonline.grupoeroski.com/es/search/results/?q="+nombre).get();
			
			String titleEroski = eroski.title();
			System.out.println("Nombre Supermercado: Eroski" + titleEroski);
			
			Elements nameEroski = eroski.select("h2[role]"); 
			Elements  precioEroski= eroski.select("span.price-offer-now");
			
			for (int i=0; i < precioEroski.size(); i++) {
				System.out.print(nameEroski.get(i).text() );
				System.out.print(" ");
				System.out.print(precioEroski.get(i).text());
				System.out.println(" ");
				resultado = nameEroski.get(i).text();
			}
			
			System.out.println(" ");
			System.out.println(" ");
			
		

		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultado;
  }
  
  */
  
}