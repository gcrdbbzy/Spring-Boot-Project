package com.bobAPI;

import static org.junit.Assert.*;

import org.junit.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class addIntegerTest {
	IntegerAdd test = new IntegerAdd();

	@Test
    public void NumTest() throws Exception {
        String url = "http://localhost:8080/addTwoNumbers?digit1=233&digit2=100";
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(url);
        HttpResponse response = httpclient.execute(request);
        String respHtml = EntityUtils.toString(response.getEntity());
        assertEquals("333", respHtml);
    }

    @Test
    public void NegTest() throws Exception {
        String url = "http://localhost:8080/addTwoNumbers?digit1=-233&digit2=-100";
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(url);
        HttpResponse response = httpclient.execute(request);
        String respHtml = EntityUtils.toString(response.getEntity());
        assertEquals("-333", respHtml);

    }

    @Test
    public void NegPosTest() throws Exception {
        String url = "http://localhost:8080/addTwoNumbers?digit1=-233&digit2=100";
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(url);
        HttpResponse response = httpclient.execute(request);
        String respHtml = EntityUtils.toString(response.getEntity());
        assertEquals("-133", respHtml);
    }

    @Test
    public void IntegerMaxTest() throws Exception {
        String url = "http://localhost:8080/addTwoNumbers?digit1=" + Integer.MAX_VALUE + "&digit2=1";
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(url);
        HttpResponse response = httpclient.execute(request);
        String respHtml = EntityUtils.toString(response.getEntity());
        assertEquals(String.valueOf(Integer.MIN_VALUE), respHtml);
    }

    @Test
    public void IntegerMINTest() throws Exception {
        String url = "http://localhost:8080/addTwoNumbers?digit1=" + Integer.MIN_VALUE + "&digit2=-1";
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(url);
        HttpResponse response = httpclient.execute(request);
        String respHtml = EntityUtils.toString(response.getEntity());
        assertEquals(String.valueOf(Integer.MAX_VALUE), respHtml);
    }

    @Test
    public void IntegerMINMAXTest() throws Exception {
        String url = "http://localhost:8080/addTwoNumbers?digit1=" + Integer.MIN_VALUE + "&digit2=" + Integer.MAX_VALUE;
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(url);
        HttpResponse response = httpclient.execute(request);
        String respHtml = EntityUtils.toString(response.getEntity());
        assertEquals(String.valueOf(-1), respHtml);
    }

    @Test
    public void IntegerOutOfRangeTest() throws Exception {
        String url = "http://localhost:8080/addTwoNumbers?digit1=21474836472&digit2=12";
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(url);
        HttpResponse response = httpclient.execute(request);
        String respHtml = EntityUtils.toString(response.getEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readValue(respHtml, new TypeReference<JsonNode>(){});
        assertEquals(400, jsonNode.get("status").asInt());
    }

    @Test
    public void StringTest() throws Exception {
        String url = "http://localhost:8080/addTwoNumbers?digit1=a&digit2=-1";
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(url);
        HttpResponse response = httpclient.execute(request);
        String respHtml = EntityUtils.toString(response.getEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readValue(respHtml, new TypeReference<JsonNode>(){});
        assertEquals(400, jsonNode.get("status").asInt());
    }

    @Test
    public void SymbolTest() throws Exception {
        String url = "http://localhost:8080/addTwoNumbers?digit1=&=&digit2=-1";
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(url);
        HttpResponse response = httpclient.execute(request);
        String respHtml = EntityUtils.toString(response.getEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readValue(respHtml, new TypeReference<JsonNode>(){});
        assertEquals(500, jsonNode.get("status").asInt());
    }

    @Test
    public void MultipleInputTest() throws Exception {
        String url = "http://localhost:8080/addTwoNumbers?digit1=0&digit2=-1&digit2=-1";
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(url);
        HttpResponse response = httpclient.execute(request);
        String respHtml = EntityUtils.toString(response.getEntity());
        assertEquals("-1", respHtml);
    }
}
