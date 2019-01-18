import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ProjectApi {


    static String  baseuri ="https://jsonplaceholder.typicode.com/posts";
    static String  baseuri_1="https://jsonplaceholder.typicode.com/posts/1";
    static Map<String, String> map = new HashMap<String, String>();

    static String apibody = "{\n" +
            "    \"title\": \"aaabbb\",\n" +
            "    \"body\": \"xxxxx\",\n" +
            "     \"userId\": 11\n" +
            "    \n" +
            "  }";
    static String apibody1 = "{\n" +
            "  \t\"id\":1,\n" +
            "    \"title\": \"aaabbb\",\n" +
            "    \"body\": \"xxxxx\",\n" +
            "    \"userId\": 12\n" +
            "  }";

    public static void main(String[] args) {


        map.put("Content-type", "application/json");
        map.put("charset", "UTF-8");

        ProjectApi obj = new ProjectApi();
        obj.Post(baseuri, apibody);
        obj.Get(baseuri_1);
        obj.Put(baseuri_1, apibody1);
        obj.Delete(baseuri_1);

    }
    public static void Post(String uri, String body)
    {
        Response response = given().headers(map).body(body)
                .when().post(uri)
                .then().assertThat().statusCode(201).extract().response();

        System.out.println(response.getBody().asString());
    }

    public static void Get(String uri_1)
    {
        Response response1 = (Response) given().headers(map)
                .when().get(uri_1)
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(response1.getBody().asString());
    }
    public static void Put(String uri_1, String body1 )
    {
        Response response3 = given().headers(map).body(body1)
                .when().put(uri_1)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response3.getBody().asString());
    }
    public static void Delete(String uri_1)
    {
        Response response4 = given()
                .when().delete(uri_1)
                .then().assertThat().statusCode(200).extract().response();

        System.out.println(response4.getBody().asString());
    }
}