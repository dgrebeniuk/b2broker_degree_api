package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class Specification {

   public static RequestSpecification tagRequestSpec = with()
           .filter(withCustomTemplates())
           .log().uri()
           .log().body()
           .contentType(JSON)
           .baseUri("https://stand-qa-05-api.b2broker.tech")
           .basePath("/api/v2");


   public static ResponseSpecification tagResponseSpec = new ResponseSpecBuilder()
           .log(STATUS)
           .log(BODY)
           .build();
}
