package vremenskaPrognoza;

import java.io.IOException;
import java.net.*;
import java.util.Calendar;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import java.io.*;

public class VremenskaPrognoza {

	static long lastRequestTimestamp;

	public static enum Type {
		CURRENT, FORECAST
	};

	public static String getWeatherInfo(String city, String countryCode, Type type) throws IOException {
		String authToken = "d0f1969fd9856fe09e3f7d0753d84ed4";
		String addr = String.format("http://api.openweathermap.org/data/2.5/%s?q=%s,%s&appid=%s&units=metric",
				type == Type.CURRENT ? "weather" : "forecast", city, countryCode, authToken);
		if (System.currentTimeMillis() - lastRequestTimestamp < 5) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		URLConnection yc = new URL(addr).openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		StringBuilder buffer = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			buffer.append(inputLine);
		in.close();
		lastRequestTimestamp = System.currentTimeMillis();
		return buffer.toString();

	}

	public static void main(String[] args) {
		JSONObject jsonRead = new JSONObject();
		String minTemperatura = "";
		String temperatura = "";
		String maxTemperatura = "";

		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodošli u konzolnu vremensku prognozu!");
		System.out.println("------------------------------------------");

		int a = 99;
		String city = "Belgrade";
		String kod="RS";
		do {

			try {

				String result = getWeatherInfo(city, kod, Type.CURRENT);
				JSONParser parser = new JSONParser();
				jsonRead = (JSONObject) parser.parse(result);
				jsonRead = (JSONObject) parser.parse(jsonRead.get("main").toString());
				minTemperatura = jsonRead.get("temp_min").toString();
				maxTemperatura = jsonRead.get("temp_max").toString();
				temperatura = jsonRead.get("temp").toString();
				////////////////////////////////////////////////////
				Calendar calendar = Calendar.getInstance();
				int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
				Kalendar k = new Kalendar();
				calendar = Calendar.getInstance(); 
				int[] nizDana = k.petDana(calendar);
				String[] stringDana = new String[5];
				for (int i = 0; i < nizDana.length; i++) {
				
					stringDana[i] = k.dani(nizDana[i]);
				}

				String forecast = "";

				forecast = getWeatherInfo(city, kod, Type.FORECAST);
		
				parser = new JSONParser();
				jsonRead = (JSONObject) parser.parse(forecast);
				System.out.println();
				JSONArray array = (JSONArray) jsonRead.get("list");
			
				////////////////////////////////////////////////////
	

			switch (a) {
			case -1:
				break;
			case 0:
				System.out.println("Unesi grad");
				city =promenaGrada(sc.next());
				System.out.println("Unesi kod");
				kod=promenaKoda(sc.next());
				break;
			case 1:
				System.out.println(trenutna(minTemperatura, temperatura, maxTemperatura));
				;
				break;
			case 2:
				ispis5dana(stringDana,array);
				break;
			case 99:
				ispisMenija();
				break;
			}
			System.out.println("komanda:");
				a = sc.nextInt();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} while (a != -1);

	}

	public static void ispisMenija() {
		System.out.println("Komande:\n" + "-1) izlaz iz programa\n 0) promena grada\n 1) trenutna temperatura\n "
				+ "2) prognoza za 5 dana\n 99) ispis komandnog menija\n-----------------------------");
	}

	public static String trenutna(String min, String temp, String max) {
		String s = "Trenutna: " + temp + "\u00B0C\nMaksimalna: " + max + "\u00B0C\nMinimalna: " + min
				+ "\u00B0C\n-----------------------------";
		return s;
	}

	public static void ispis5dana(String[] stringDana,JSONArray array){
		int brojac=0;
		for (int i = 0; i < array.size(); i++) {
			JSONObject obj = (JSONObject) array.get(i);
			JSONObject tempInfo = (JSONObject) obj.get("main");
			
			if ((i + 1) % 8 == 0) {
				System.out.println(stringDana[brojac] + ": " + tempInfo.get("temp")+ "\u00B0C");
				
				brojac++;

			}
		}
	System.out.println("-----------------------------");

	}	

	public static String promenaGrada(String grad) {
		return grad;
	}
	
	public static String promenaKoda(String kod) {
		return kod;
	}
}
