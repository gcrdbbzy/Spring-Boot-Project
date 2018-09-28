package com.bobAPI;

import static org.junit.Assert.assertEquals;

import java.net.URLEncoder;

import org.apache.http.HttpEntity;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


public class addStringTest {
	StringAdd test = new StringAdd();
	
	@Test
	public void HttpTest() throws Exception {
        String url = "http://localhost:8080/addString?a=233&b=100";
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        HttpPost request = new HttpPost(url);
        CloseableHttpResponse response = httpclient.execute(request);;
        try {  
            HttpEntity myEntity = response.getEntity();  
            String respHtml = EntityUtils.toString(myEntity);
            assertEquals("233100", respHtml);
              
              
        } finally {  
            response.close();  
        }  
       
    }
	@Test
	public void LanguageAdd()throws Exception {
        String url = "http://localhost:8080/addString?a=小姐撤走&b=士大夫";
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        HttpPost request = new HttpPost(url);
        CloseableHttpResponse response = httpclient.execute(request);;
        try {  
            HttpEntity myEntity = response.getEntity();  
            String respHtml = EntityUtils.toString(myEntity);
            assertEquals("小姐撤走士大夫", respHtml);
              
              
        } finally {  
            response.close();  
        }  
       
    }
	@Test
	public void StringAdd()throws Exception {
        String url = "http://localhost:8080/addString?a=.,/.,&b=!!?????~~";
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        HttpPost request = new HttpPost(url);
        CloseableHttpResponse response = httpclient.execute(request);;
        try {  
            HttpEntity myEntity = response.getEntity();  
            String respHtml = EntityUtils.toString(myEntity);
            assertEquals(".,/.,!!?????~~", respHtml);
              
              
        } finally {  
            response.close();  
        }  
       
    }
	@Test
	public void LettersAdd()throws Exception {
        String url = "http://localhost:8080/addString?a=asdsd&b=sadasd";
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        HttpPost request = new HttpPost(url);
        CloseableHttpResponse response = httpclient.execute(request);
        try {  
            HttpEntity myEntity = response.getEntity();  
            String respHtml = EntityUtils.toString(myEntity);
            assertEquals("asdsdsadasd", respHtml);
              
              
        } finally {  
            response.close();  
        }  
       
    }
	 @Test
	    public void SymbolTest() throws Exception {
	        String url = "http://localhost:8080/addString?a=&=&b=-1";
	        CloseableHttpClient httpclient = HttpClients.createDefault();  
	        HttpPost request = new HttpPost(url);
	        CloseableHttpResponse response = httpclient.execute(request);
	        String respHtml = EntityUtils.toString(response.getEntity());
	        assertEquals("-1", respHtml);
	 }

	    @Test
	    public void EncodeSymbolTest() throws Exception {
	        String url = "http://localhost:8080/addString?a=" + URLEncoder.encode("&=", "UTF-8") + "&b=-1";
	        CloseableHttpClient httpclient = HttpClients.createDefault();  
	        HttpPost request = new HttpPost(url);
	        CloseableHttpResponse response = httpclient.execute(request);
	        String respHtml = EntityUtils.toString(response.getEntity());
	        assertEquals("&=-1", respHtml);
	    }

	    @Test
	    public void MultipleInputTest() throws Exception {
	        String url = "http://localhost:8080/addString?a=c&b=d&b=-1";
	        CloseableHttpClient httpclient = HttpClients.createDefault();  
	        HttpPost request = new HttpPost(url);
	        CloseableHttpResponse response = httpclient.execute(request);
	        String respHtml = EntityUtils.toString(response.getEntity());
	        assertEquals("cd,-1", respHtml);
	    }

	    @Test
	    public void OtherInputTest() throws Exception {
	        String url = "http://localhost:8080/addString?a=c&b=d&b=-1&c=9";
	        CloseableHttpClient httpclient = HttpClients.createDefault();  
	        HttpPost request = new HttpPost(url);
	        CloseableHttpResponse response = httpclient.execute(request);
	        String respHtml = EntityUtils.toString(response.getEntity());
	        assertEquals("cd,-1", respHtml);
	    }
	 
}
