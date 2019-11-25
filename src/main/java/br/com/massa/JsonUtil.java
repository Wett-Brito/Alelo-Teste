package br.com.massa;

import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {

	static String jsonURL = "./arquivos/Diretores.json";
	
	public static ArrayList<Object> getArrayInArray (String parentArray, int index, String childArray)
	{
		//Opening file
		JsonObject arquivoInteiro = carregar(jsonURL);
		
		//Acessing JsonObjects
		JsonObject currentObject = arquivoInteiro;
		JsonArray jsonArray = new JsonArray();
		int lastBarIndex = 0;
		for (int i =0;i < parentArray.length();i++)
		{
			if (parentArray.charAt(i) == '/')
			{
				if (lastBarIndex == 0)
				{
					currentObject = (JsonObject)currentObject.get(parentArray.substring(lastBarIndex, i));
				}
				else
				{
					try {
						jsonArray = currentObject.get(parentArray.substring(lastBarIndex +1, i)).getAsJsonArray();
					} catch(IllegalStateException e) {
						currentObject = (JsonObject)currentObject.get(parentArray.substring(lastBarIndex +1, i));
					}

				}
				lastBarIndex = i;
			}
		}
		jsonArray = (JsonArray)currentObject.get(parentArray.substring(lastBarIndex +1, parentArray.length()));
			
			JsonObject obj = (JsonObject)jsonArray.get(index);
			JsonArray finalArray = obj.get(childArray).getAsJsonArray();
			String[] stringArray = new String[finalArray.size()];
			ArrayList<Object> StringList = new ArrayList<Object>();
			
			for (int i=0; i < stringArray.length; i++)
			{
				StringList.add(finalArray.get(i));
			}
			
			return StringList;
	}
	
	
	public static String getValue (String key)
	{
		
		//Opening file
		JsonObject arquivoInteiro = carregar(jsonURL);		
		//Acessing JsonObjects
		JsonObject currentObject = arquivoInteiro;
		int lastBarIndex = 0;
		String desiredValueName = "";
		for (int i =0;i < key.length();i++)
		{
			if (key.charAt(i) == '/')
			{
				if (lastBarIndex == 0)
				{
						currentObject = (JsonObject)currentObject.get(key.substring(lastBarIndex, i));
				}
				else {
//					String teste = key.substring(lastBarIndex +1, i);
					try
					{
						currentObject = (JsonObject)currentObject.get(key.substring(lastBarIndex +1, i));
					}
					catch (IllegalStateException ex)
					{
						return currentObject.getAsString();
					}
					catch (NullPointerException ex)
					{
						return "";
					}
				}
				lastBarIndex = i;
			}
			else if (i == key.length() -1) //Last char
			{
				//Defining desiredValueName
				desiredValueName = key.substring(lastBarIndex +1, i +1);
			}
		}
		
		//Acessing desired value
		try
		{
			return currentObject.get(desiredValueName).getAsString();
		}
		catch (Exception ex)
		{
			return "";
		}
	}
	
	public static String getValue (String key, int index)
	{
		//Opening file
		JsonObject arquivoInteiro = carregar(jsonURL);	
		
		//Acessing JsonObjects
		JsonObject currentObject = arquivoInteiro;
		JsonArray jsonArray = new JsonArray();
		int lastBarIndex = 0;
		String desiredValueName = "";
		for (int i =0;i < key.length();i++)
		{
			if (key.charAt(i) == '/')
			{
				if (lastBarIndex == 0)
				{
					currentObject = (JsonObject)currentObject.get(key.substring(lastBarIndex, i));
				}
				else
				{
					try
					{
						jsonArray = currentObject.get(key.substring(lastBarIndex +1, i)).getAsJsonArray();
					}
					catch(IllegalStateException e)
					{
						currentObject = (JsonObject)currentObject.get(key.substring(lastBarIndex +1, i));
					}
					catch (NullPointerException ex)
					{
						return "";
					}

				}
				lastBarIndex = i;
			}
			else if (i == key.length() -1) //Last char
			{
				//Defining desiredValueName
				desiredValueName = key.substring(lastBarIndex +1, i +1);
			}
		}
		
		//Acessing desired value
		try
		{
			return ((JsonObject)jsonArray.get(index)).get(desiredValueName).getAsString();
		}
		catch (Exception ex)
		{
			return "";
		}
	}
	
	
	public static ArrayList<Object> getArray(String parentArray, int index)
	{
		//Opening file
		JsonObject arquivoInteiro = carregar(jsonURL);
		
		//Acessing JsonObjects
		JsonObject currentObject = arquivoInteiro;
		JsonArray jsonArray = new JsonArray();
		
		int lastBarIndex = 0;
		for (int i =0;i < parentArray.length();i++)
		{
			if (parentArray.charAt(i) == '/')
			{
				if (lastBarIndex == 0)
				{
					currentObject = (JsonObject)currentObject.get(parentArray.substring(lastBarIndex, i));
				}
				else
				{
					try {
						jsonArray = currentObject.get(parentArray.substring(lastBarIndex +1, i)).getAsJsonArray();
					} catch(IllegalStateException e) {
						currentObject = (JsonObject)currentObject.get(parentArray.substring(lastBarIndex +1, i));
					}

				}
				lastBarIndex = i;
			}
		}
		
		jsonArray = (JsonArray)currentObject.get(parentArray.substring(lastBarIndex +1, parentArray.length()));	
		ArrayList<Object> StringList = new ArrayList<Object>();
		StringList.add(jsonArray.get(index));

		return StringList;
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public static JsonObject carregar( String caminhoDoArquivo )
	{
		JsonObject jsonObject;
		JsonParser parser = new JsonParser();
		try
		{
			FileReader reader = new FileReader("./arquivos/Diretores.json");
			jsonObject = (JsonObject) parser.parse(reader);
			
			return jsonObject;
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			return null;
		}
	}
}
