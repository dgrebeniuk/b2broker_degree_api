package tests;

import models.TagModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
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
}
