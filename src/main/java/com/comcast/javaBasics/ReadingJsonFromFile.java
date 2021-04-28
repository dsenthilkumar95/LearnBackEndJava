package com.comcast.javaBasics;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class ReadingJsonFromFile {
    public static void commonLinks() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        java.lang.Object obj = parser.parse(new FileReader("/Users/skumar236/codeRepo/LearnBackEndJava/src/main/resources/jsons/profileLinks.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray companyList = (JSONArray) jsonObject.get("entries");
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(companyList.toString(), JsonArray.class);
        for (JsonElement json : jsonArray){
            JsonObject jsonObject1 = json.getAsJsonObject();
            String profileId = gson.fromJson(jsonObject1.get("id"),String.class);
            System.out.println("profileId -> " + profileId);
            JsonArray linkIds = gson.fromJson(jsonObject1.get("publishProfileIds"), JsonArray.class);
            List<String> linkIdList = new ArrayList<>();
            for(JsonElement link : linkIds){
                linkIdList.add(link.getAsString());
            }
            System.out.println(linkIdList.toString());
        }
    }
    public static void main(String[] args) throws IOException, ParseException {
        ReadingJsonFromFile.commonLinks();
    }
}