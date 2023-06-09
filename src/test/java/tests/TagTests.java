package tests;

import models.TagBodyModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static specs.TagSpec.tagRequestSpec;
import static specs.TagSpec.tagResponseSpec;

@Tag("apiTest")
public class TagTests extends TestBase{

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
                  .body("total", is(notNullValue()));
   }

   @DisplayName("Create a new tag")
   @Test
   void createNewTag() {
      TagBodyModel tagBody = new TagBodyModel();
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
      TagBodyModel tagBody = new TagBodyModel();
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
              .delete("/tags/17")
              .then()
              .statusCode(204)
              .spec(tagResponseSpec)
              .body("id", is(notNullValue()));
   }
}
