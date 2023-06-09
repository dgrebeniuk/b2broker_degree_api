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

   static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2ODYzMjg5NDMsIm5iZiI6MTY4NjMyODk0MywiZXhwIjoxNjk1OTI4OTQzLCJpc3MiOiJodHRwczovL3N0YW5kLXFhLTA1LWFwaS5iMmJyb2tlci50ZWNoIiwic3ViIjoiOCIsImlhdF9tdCI6IjE2ODYzMjg5NDMuMjEifQ.Bke27mwjSGV01ZDTQZf_2boOAv-RQV3wM9mBygKzFRYi0tzzox9eIal5aPGl-_aIK7yCCw-bs-pyDJxB-45-74MkS-17kh1oP0Cm_-dWPEZus5ByU7MHGAGDYOWXoPRG_YVlsap67jD8kFuUlq7yNeMzBUO0Yuze9srcfcbd2r0RoXQ5cugicQJAA2k2VM8YmhVYJ6E7kZePecnKjev0isEXZIMJs4jbvnA06k9-uPXRR0Q889rE_2pqkLhN1z5MGUvgaqjQBN7RZzNllFU5xfHTq2dtYSI3YRfrMAUuyVwqYsM0pUV5P-6IohUkNyaxQQxgTi91DQlb-4IN99E2bg";

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
