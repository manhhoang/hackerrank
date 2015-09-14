package com.jd.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ERoad {
  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/eroad";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    while (sc.hasNext()) {
      String lines = sc.nextLine();
      if(lines.isEmpty()){
        break;
      }
      String[] line = lines.split(",");
      String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
      DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
      formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
      Date date = formatter.parse(line[0]);
      long timestamp = date.getTime() / 1000;
      String location = line[1] + "," + line[2];
      String key = "AIzaSyBpAl8_fHfdhWjMNv0qzVT813hDNbRwpqI";
      String api = "https://maps.googleapis.com/maps/api/timezone/json";
      URL url =
          new URL(api + "?" + "location=" + location + "&timestamp=" + timestamp + "&key=" + key);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("GET");
      BufferedReader resp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      StringBuilder result = new StringBuilder();
      while (true) {
        String value = resp.readLine();
        if (value != null) {
          result.append(value);
        } else {
          break;
        }
      }
      JSONParser jsonParser = new JSONParser();
      JSONObject jobj = (JSONObject) jsonParser.parse(result.toString());
      String timeZoneId = jobj.get("timeZoneId").toString();
      formatter.setTimeZone(TimeZone.getTimeZone(timeZoneId));
      String zoneDate = formatter.format(date);
      System.out.println(lines + "," + timeZoneId + "," + zoneDate);
    }
  }
}
