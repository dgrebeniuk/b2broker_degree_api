package tests;

import models.TagModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static specs.TagSpec.tagRequestSpec;
import static specs.TagSpec.tagResponseSpec;

public class TagTests extends TestBase{

//   @DisplayName("Get a token")
//   @Test
//   void getToken() {
//
//      LoginBodyModel loginBody = new LoginBodyModel();
//      loginBody.setEmail("dgrebenyuk@b2broker.com");
//      loginBody.setPassword("admin");
//
//      given()
//              .filter(withCustomTemplates())
//              .log().uri()
//              .body(loginBody)
//              .contentType(JSON)
//              .when()
//              .post("https://stand-qa-05-api.b2broker.tech/api/v2/signin")
//              .then()
//              .log().status()
//              .log().body()
//              .statusCode(200);
//String firstName = faker.name().firstName(),
//   }
   String tagName = faker.name().username();

   @DisplayName("Get all tags")
   @Test
   void getAllTags() {
      given(tagRequestSpec)
              .when()
                  .get("/tags")
              .then()
                  .statusCode(200)
                  .spec(tagResponseSpec)
                  .body("total", is(5));
   }

   @DisplayName("Create a new tag")
   @Test
   void createNewTag() {
      TagModel tagBody = new TagModel();
      tagBody.setName(tagName);

      given(tagRequestSpec)
              .body(tagBody)
              .when()
                  .post("/tags")
              .then()
                  .statusCode(201)
                  .spec(tagResponseSpec)
                  .body("name", is(tagName));
   }


   @DisplayName("Get tag by id")
   @Test
   void getTagById() {
      given(tagRequestSpec)
              .when()
                  .get("/tags/1")
              .then()
                  .statusCode(200)
                  .spec(tagResponseSpec)
                  .body("id", is(notNullValue()));
   }

   @DisplayName("Update a tag")
   @Test
   void updateTagById() {
      TagModel tagBody = new TagModel();
      tagBody.setName(tagName);

      given(tagRequestSpec)
              .body(tagBody)
              .when()
                  .put("/tags/3")
              .then()
                  .statusCode(200)
                  .spec(tagResponseSpec)
                  .body("name", is(tagName));
   }

   @DisplayName("Delete a tag")
   @Test
   void deleteTagById() {
      given(tagRequestSpec)
              .when()
              .delete("/tags/15")
              .then()
              .statusCode(204)
              .spec(tagResponseSpec)
              .body("id", is(notNullValue()));
   }





@Disabled
   @DisplayName("Suscesfull")
   @Test
   void successfulLoginTest() {
     // String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";
      String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2ODYyNTg3MDcsIm5iZiI6MTY4NjI1ODcwNywiZXhwIjoxNjg2MjY4MzA3LCJpc3MiOiJodHRwczovL3N0YW5kLXFhLTA1LWFwaS5iMmJyb2tlci50ZWNoIiwic3ViIjoiOCIsImlhdF9tdCI6IjE2ODYyNTg3MDcuODQxMSJ9.CanAh13CM3z6T6CBjrKLaar0UFSQOxRygr4Pzj0IQN-xcUJccdbBoj9x4vCUXkA4aDelQYZo9GnbH4O3E-m41_ONS0uS4mlXKzbZ79hwmmIvteNmFRcjam-UaUHXuiNsNln0nggtoafiBJF1wuXZaAcUcQgmqWNYTJpyUc8av9Xgq1wROD2xvKY7-yT98J51apnBMM81QqPi9mZgHwoKIlKYpBQUUcV0znUqZxy_wWJa8GXHi7p-d1vGX9prp3tC03NH27Z8AudEL5AQNOn5VQFN3SpzyIrwwolQpXtii6JEHLdyzcmWybK7r0qUAyRY94cOr6UwPF5dZrxbj4eP4A";

      given()
              .log().uri()
              .header("Authorization", "Bearer " + token)
              .contentType(JSON)
              .when()
              .get("https://stand-qa-05-api.b2broker.tech/api/v2/tags")
              .then()
              .log().status()
              .log().body()
              .statusCode(200);
   }

@Disabled
   @DisplayName("Fail")
   @Test
   void successfulLoginWithPojoTest() {
      //LoginBodyModel loginBody = new LoginBodyModel();
      //loginBody.setEmail("eve.holt@reqres.in");
      //loginBody.setPassword("cityslicka");

      given()
              .filter(withCustomTemplates())
              .log().uri()
              //.body(loginBody)
              .contentType(JSON)
              .when()
              .post("https://reqres.in/api/login")
              .then()
              .log().status()
              .log().body()
              .statusCode(200)
              .body("token", is("QpwL5tke4Pnpja7X4"));
   }

}
