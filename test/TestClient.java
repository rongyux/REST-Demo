

import java.io.IOException;

import org.junit.Test;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.google.gson.Gson;

public class TestClient {

	@Test
	public void test01() throws IOException{
		ClientResource client = new ClientResource("http://localhost:12345/threshold/register");
		Representation result =  client.get() ;		
		System.out.println(result.getText());  
	}
	
	@Test
	public void test02() throws IOException{
		ClientResource client = new ClientResource("http://localhost:12345/threshold/register"); 
		Gson gson = new Gson();
		String str =gson.toJson("1");
		Representation result =  client.post(str) ;	
		System.out.println(result.getText());  
	}
	@Test
	public void test03() throws IOException{
		ClientResource client = new ClientResource("http://localhost:12345/threshold/metricRegister");
		Representation result =  client.get() ;		
		System.out.println(result.getText());  
	}
	
	@Test
	public void test04() throws IOException{
		ClientResource client = new ClientResource("http://localhost:12345/threshold/metricRegister"); 
		Gson gson = new Gson();
		String str =gson.toJson("1");
		Representation result =  client.post(str) ;	
		System.out.println(result.getText());  
	}
	@Test
	public void test05() throws IOException{
		ClientResource client = new ClientResource("http://localhost:12345/threshold/info");
		Representation result =  client.get() ;		
		System.out.println(result.getText());  
	}
	
	@Test
	public void test06() throws IOException{
		ClientResource client = new ClientResource("http://localhost:12345/threshold/info"); 
		Gson gson = new Gson();
		String str =gson.toJson("1");
		Representation result =  client.post(str) ;	
		System.out.println(result.getText());  
	}
	
}
