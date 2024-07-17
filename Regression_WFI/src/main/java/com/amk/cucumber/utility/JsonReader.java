package com.amk.cucumber.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonReader {

    private static final Logger LOG = LoggerFactory.getLogger(JsonReader.class.getName());
    private final DocumentContext documentContext;

   public static void main(String[] args) {
        String jsonDataSourceString = "{\r\n"
                + "    \"tool\": \r\n"
                + "    {\r\n"
                + "        \"jsonpath\": \r\n"
                + "        {\r\n"
                + "            \"creator\": \r\n"
                + "            {\r\n"
                + "                \"name\": \"Jayway Inc.\",\r\n"
                + "                \"location\": \r\n"
                + "                [\r\n"
                + "                    \"Malmo\",\r\n"
                + "                    \"San Francisco\",\r\n"
                + "                    \"Helsingborg\"\r\n"
                + "                ]\r\n"
                + "            }\r\n"
                + "        }\r\n"
                + "    },\r\n"
                + "\r\n"
                + "    \"book\": \r\n"
                + "    [\r\n"
                + "        {\r\n"
                + "            \"title\": \"Beginning JSON\",\r\n"
                + "            \"price\": 49.99\r\n"
                + "        },\r\n"
                + "\r\n"
                + "        {\r\n"
                + "            \"title\": \"JSON at Work\",\r\n"
                + "            \"price\": 29.99\r\n"
                + "        }\r\n"
                + "    ]\r\n"
                + "}";

        String path = "$.tool.jsonpath.creator.location[2]";
        DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
        String jsonpathCreatorName = jsonContext.read(path);

        System.out.println("Hi: " + jsonpathCreatorName);

    }

    /**
     *
     * @param documentContext
     */
    public JsonReader(DocumentContext documentContext) {
        this.documentContext = documentContext;
    }

    /**
     *
     * @param jsonFileContent
     */
    public JsonReader(String jsonFileContent) {
        this.documentContext = getDocumentContext(jsonFileContent);
    }

    /**
     * thTo read the String data from given jsonPar
     *
     * @param jsonPath
     * @return
     */
    public String getString(String jsonPath) {
        try {
            return this.documentContext.read(jsonPath.startsWith("$.") ? jsonPath : "$." + jsonPath);
        } catch (com.jayway.jsonpath.PathNotFoundException e) {
            return null;
        }
    }

    public DocumentContext setString(String jsonPath, String value) {
        try {
            return this.documentContext.set(jsonPath.startsWith("$.") ? jsonPath : "$." + jsonPath, value);
        } catch (com.jayway.jsonpath.PathNotFoundException e) {
            return null;
        }
    }

    /**
     * To get the DocumentContext object of a json content
     *
     * @param jsonDataSourceString - The Json content as String
     * @return - The DocumentContext object.
     */
    public static DocumentContext getDocumentContext(String jsonDataSourceString) {
        return JsonPath.parse(jsonDataSourceString);
    }

    /**
     * To read the given json file content
     *
     * @param filePath - The JsonFilePath
     * @return - The Json File content
     */
    public static String readJsonFileData(String filePath) {
        String result = "";
        try ( BufferedReader br = new BufferedReader(new FileReader(filePath));) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch (IOException e) {
            LOG.error("Reading JSON exception!" + e.getMessage());
        }
        return result;
    }

    /**
     * To read the <T> data from given jsonParam
     *
     * @param <T>
     * @param jsonParam
     * @return <T extends Object> Data or null
     */
    public <T extends Object> T getValue(String jsonParam) {
        try {
            return this.documentContext.read(jsonParam.startsWith("$.") ? jsonParam : "$." + jsonParam);
        } catch (com.jayway.jsonpath.PathNotFoundException e) {
            return null;
        }
    }

    public JSONArray getList(String jsonPath) {
        try {
            return this.documentContext.read(jsonPath.startsWith("$.") ? jsonPath : "$." + jsonPath);
        } catch (com.jayway.jsonpath.PathNotFoundException e) {
            return null;
        }
    }
    
    public void getJsonAsMap() throws JsonParseException, JsonMappingException, IOException {
    	ObjectMapper obMa = new ObjectMapper();
    	String jsonPath= System.getProperty("user.dir");
    	Map<String, String> data=  (Map) obMa.readValue(new File(jsonPath), new TypeReference() {});
    }
}


