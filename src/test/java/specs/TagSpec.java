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
   static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2ODYyNjM3NzYsIm5iZiI6MTY4NjI2Mzc3NiwiZXhwIjoxNjg2MjczMzc2LCJpc3MiOiJodHRwczovL3N0YW5kLXFhLTA1LWFwaS5iMmJyb2tlci50ZWNoIiwic3ViIjoiOCIsImlhdF9tdCI6IjE2ODYyNjM3NzYuNjM0NiJ9.JdeerDPlmLE2OnbmQeuwDSWgO7z3L7G6JIuV_KDwR679XTyleTIO-R56kTYIQD47389MoKNKaqP6USj-Ve2oqpe4pf5RytA0gCXqmGQf6h7BbrDtjQWyAJ3sKA9MmJqY2D1AC8s1Ss-er_4GDHwsvbX3C9co0Vvh8blpIFZcoNZSnX3ZrDFFfpZtuheuOtdLmNc9JOWMQavMbW_CNuXhajzlxHbDc24-IUVwOe_KBohTXbGoHFOU6Rsf0Eqcvo3rvRqvqshvF6ZSeDrRmDxBwYYVHZZ-V_aEPxUtRa8Saxe2Xw3lPOXi53FzJ6RbY4T_AtTKIU4gSJnsdrZ0QzHPmA";


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
           //.expectStatusCode(200)
           .build();
}
