package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class TagSpec {

   static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2ODYzMjgyNDQsIm5iZiI6MTY4NjMyODI0NCwiZXhwIjoxNjg2MzM3ODQ0LCJpc3MiOiJodHRwczovL3N0YW5kLXFhLTA1LWFwaS5iMmJyb2tlci50ZWNoIiwic3ViIjoiOCIsImlhdF9tdCI6IjE2ODYzMjgyNDQuMTY5NSJ9.JL64LQyRevWSP1AIaZzC-YTo2MA4yQEuQjdTArBGBNylMlooebKhnJbyBvldUECD2_8vwoEQVigQGswJTOjihLsoUEAxsKTIApT_HBApjkSV6lwo1BnedEBVulKQxP7GDJZzDBj0tmnU_UqMxou5VZQTdnM_FpjmWSOfjeR-cr95RA6SExBGUjjPVJPend-19YUjdbTxoHByaesmG0lEuEcyC0tdq3V9elDBErIgXZKe7Rex24rwbGPiUyS75aj-p0fvEIYh4aH3PmtZssJkW3qLOCpH_FDi09ykV4_J9Ku6k6wJif-NE0kfrcHBvLbQQB515F-pipXN94pKIQF6iQ";

   public static RequestSpecification tagRequestSpec = with()
           .filter(withCustomTemplates())
           .log().uri()
           .log().body()
           .header("Authorization", "Bearer " + token)
           .contentType(JSON)
           .baseUri("https://stand-qa-05-api.b2broker.tech")
           .basePath("/api/v2");

   public static ResponseSpecification tagResponseSpec = new ResponseSpecBuilder()
           .log(STATUS)
           .log(BODY)
           .build();
}
