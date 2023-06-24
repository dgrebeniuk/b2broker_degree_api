package tests;

import com.github.javafaker.Faker;
import models.LoginBodyModel;
import models.TokenForAuth;
import org.junit.jupiter.api.*;


import static io.restassured.RestAssured.given;
import static specs.Specification.tagRequestSpec;
import static specs.Specification.tagResponseSpec;

public class TestBase {
   Faker faker = new Faker();
   static String token;

   @BeforeAll
   static void beforeAll() {

      LoginBodyModel loginBody = new LoginBodyModel();
      loginBody.setEmail("dgrebenyuk@b2broker.com");
      loginBody.setPassword("admin");

      TokenForAuth response = given(tagRequestSpec)
              .body(loginBody)
              .when()
              .post("/signin")
              .then()
              .spec(tagResponseSpec)
              .statusCode(200)
              .extract().as(TokenForAuth.class);

      token = response.getAuthData().getToken();
   }


}
