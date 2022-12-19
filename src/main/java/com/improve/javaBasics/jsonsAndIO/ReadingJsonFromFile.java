package com.improve.javaBasics.jsonsAndIO;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

    public static void teachersList() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        java.lang.Object obj = parser.parse(new FileReader("E:\\repo\\LearnBackEndJava\\src\\main\\resources\\jsons\\selfevaluationfilled.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject result = (JSONObject) jsonObject.get("result");
        JSONArray completedTeacherList = (JSONArray) result.get("teacherinfo");

        JSONParser parser1 = new JSONParser();
        java.lang.Object obj1 = parser1.parse(new FileReader("E:\\repo\\LearnBackEndJava\\src\\main\\resources\\jsons\\allteachers.json"));
        JSONObject jsonObject1 = (JSONObject) obj1;
        JSONArray allTeacherList = (JSONArray) jsonObject1.get("teacherslist");

        Set<String> completedSet = new HashSet<>();
        Set<String> allTeachersSet = new HashSet<>();
        Map<String,String> uidNameMap = new HashMap<>();

        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(completedTeacherList.toString(), JsonArray.class);
        for (JsonElement json : jsonArray){
            JsonObject jsonObject2 = json.getAsJsonObject();
            String profileId = gson.fromJson(jsonObject2.get("u_id"),String.class);
            System.out.println("completed profileId -> " + profileId);
            completedSet.add(profileId);
        }

        Gson gson1 = new Gson();
        JsonArray jsonArray1 = gson1.fromJson(allTeacherList.toString(), JsonArray.class);
        for (JsonElement json1 : jsonArray1){
            JsonObject jsonObject3 = json1.getAsJsonObject();
            String profileId1 = gson.fromJson(jsonObject3.get("u_id"),String.class);
            String name = gson.fromJson(jsonObject3.get("teacher_name"),String.class);
            System.out.println("all profileId -> " + profileId1);
            allTeachersSet.add(profileId1);
            uidNameMap.put(profileId1, name);
        }

        List<String> incompleteList = allTeachersSet.stream().filter(s -> !completedSet.contains(s)).collect(Collectors.toList());
        System.out.println("--------------------------------------------------------------------");
        for(String uid: incompleteList) {
            System.out.println(uidNameMap.get(uid));
        }
    }
    public static void main(String[] args) throws IOException, ParseException {
//        ReadingJsonFromFile.commonLinks();
        ReadingJsonFromFile.teachersList();
    }
}