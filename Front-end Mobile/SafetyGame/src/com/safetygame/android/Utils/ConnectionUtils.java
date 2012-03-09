/*
 * Name: ConnectionUtils.java
 * Package: com.safetygame.android.Utils
 * Author: Lorenzo Braghetto
 * Date: {Data di approvazione del file}
 * Version: 0.2
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+------------------+---------------------
 * |   Date   | Programmer       | Changes
 * +----------+------------------+---------------------
 * | 20120306 |Lorenzo Braghetto | + HttpCreateClient
 * |          |                  | + rootXML
 * |          |                  | + parseXML
 * +----------+------------------+---------------------
 *
*/
package com.safetygame.android.Utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.safetygame.android.condivisi.Dati;
import com.safetygame.android.condivisi.Domanda;
import com.safetygame.android.condivisi.Punteggi;
import com.safetygame.android.condivisi.Quest;

import android.util.Log;

public class ConnectionUtils
{
	
	public static Object HttpCreateClient(String url, List<NameValuePair> nameValuePairs)
	{
		Element xml;
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
 
		try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			
			xml = rootXML(response);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		if(parseXML(xml, "status", 0).equals("OK"))
		{
			if(url.contains("login"))
			{
				return parseXML(xml, "status", 0);
			}else if(url.contains("domanda"))
			{
				String type = parseXML(xml, "type", 0);
				if(type.equals("sino"))
					return new Domanda(type, parseXML(xml, "title", 0), parseXML(xml, "testo", 0));
				else
				{
					String[] risposte = new String[3];
					risposte[0] = parseXML(xml, "risposta", 0);
					risposte[1] = parseXML(xml, "risposta", 1);
					risposte[2] = parseXML(xml, "risposta", 2);
					return new Domanda(type, parseXML(xml, "title", 0), parseXML(xml, "testo", 0), risposte, 3);
				}
				
			}else if(url.contains("quest"))
			{
				return new Quest(parseXML(xml, "title", 0), parseXML(xml, "testo", 0));
			}else if(url.contains("dati"))
			{
				return new Dati(parseXML(xml, "nome", 0), parseXML(xml, "cognome", 0));
			}else if(url.contains("punteggi"))
			{
				String[] badges = new String[2];
				badges[0] = parseXML(xml, "testo", 0);
				badges[1] = parseXML(xml, "testo", 1);
				return new Punteggi(parseXML(xml, "rispostedate", 0), parseXML(xml, "rispostecorrette", 0), parseXML(xml, "risposteerrate", 0),  parseXML(xml, "punti", 0), badges, 2);
			}
		}

		return null;

	}
	
	private static Element rootXML(HttpResponse response)
	{
		Document docs=null;
		try {
			docs = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(response.getEntity().getContent());
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
        Element root=docs.getDocumentElement();	 

		return root;		
	}
	
	public static String parseXML(Element root, String stringa, int position)
	{
		if(root!=null)
		{
			NodeList nodelist = root.getElementsByTagName(stringa);
			return nodelist.item(position).getFirstChild().getNodeValue();
		}else
		{
			return "";
		}
	}

	
}