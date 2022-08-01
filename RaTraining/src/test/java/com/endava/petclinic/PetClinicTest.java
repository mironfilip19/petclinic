package com.endava.petclinic;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PetClinicTest {

    @Test
    public void postOwnersTest() {
        given().baseUri("http://api.petclinic.mywire.org/")
                .port(80)
                .basePath("/petclinic")
                .contentType(ContentType.JSON)
                .body(
                        "{\n" +
                        "  \"address\": \"str.Dumbrava Rosie \",\n" +
                        "  \"city\": \"Bucharest\",\n" +
                        "  \"firstName\": \"Filip\",\n" +
                        "  \"id\": null,\n" +
                        "  \"lastName\": \"Miron\",\n" +
                        "  \"telephone\": \"0765489732\"\n" +
                        "}"
                )
                .when().log().all()
                .post("/api/owners")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

    }
    @Test
    public void postPetsTest() {
        given().baseUri("http://api.petclinic.mywire.org/")
                .port(80)
                .basePath("/petclinic")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"birthDate\": \"2022/05/19\",\n" +
                        "  \"id\": null,\n" +
                        "  \"name\": \"Sony\",\n" +
                        "  \"owner\": {\n" +
                        "    \"address\": \"Sony address1\",\n" +
                        "    \"city\": \"Sony City\",\n" +
                        "    \"firstName\": \"Sony Owner\",\n" +
                        "    \"id\": 101,\n" +
                        "    \"lastName\": \"Yes\",\n" +
                        "    \"pets\": [\n" +
                        "      null\n" +
                        "    ],\n" +
                        "    \"telephone\": \"string\"\n" +
                        "  },\n" +
                        "  \"type\": {\n" +
                        "    \"id\": 29,\n" +
                        "    \"name\": \"Elephant\"\n" +
                        "  }\n" +
                        "}"
                )
                .when().log().all()
                .post("/api/pets")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

    }

    @Test
    public void deletePetTest() {

        given().baseUri("http://api.petclinic.mywire.org/")
                .port(80)
                .basePath("/petclinic")
                .delete("/api/owners/{ownerId}", 105)
                .prettyPeek();

    }

    @Test
    public void getOwnerById() {
        given().baseUri("http://api.petclinic.mywire.org/")
                .basePath("/petclinic")
                .port(80)
                .pathParam("ownerId", 101)
                .get("/api/owners/{ownerId}")
                .prettyPeek();
    }
    @Test
    public void getOwner() {
        given().baseUri("http://api.petclinic.mywire.org/")
                .basePath("/petclinic")
                .port(80)
                .get("/api/owners")
                .prettyPeek();
    }
    @Test
    public void getPetList() {
        given().baseUri("http://api.petclinic.mywire.org/")
                .basePath("/petclinic")
                .port(80)
                .get("/api/pets")
                .prettyPeek();
    }
    @Test
    public void postVisitsTest() {
        given().baseUri("http://api.petclinic.mywire.org/")
                .port(80)
                .basePath("/petclinic")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"date\": \"2022/08/01\",\n" +
                        "\t\"description\": \"FilipVisit3\",\n" +
                        "\t\"id\": null,\n" +
                        "\t\"pet\": {\n" +
                        "\t\t\"birthDate\": \"2022/08/01\",\n" +
                        "\t\t\"id\": 143,\n" +
                        "\t\t\"name\": \"Sony\",\n" +
                        "\t\t\"owner\": {\n" +
                        "\t\t\t\"address\": \"string\",\n" +
                        "\t\t\t\"city\": \"string\",\n" +
                        "\t\t\t\"firstName\": \"Filip\",\n" +
                        "\t\t\t\"id\": 101,\n" +
                        "\t\t\t\"lastName\": \"Miron\",\n" +
                        "\t\t\t\"pets\": null,\n" +
                        "\t\t\t\"telephone\": \"1231231234\"\n" +
                        "\t\t},\n" +
                        "\t\t\"type\": {\n" +
                        "\t\t\t\"id\": 29,\n" +
                        "\t\t\t\"name\": \"Elephant\"\n" +
                        "\t\t}\n" +
                        "\t}\n" +
                        "}"
                )
                .when().log().all()
                .post("/api/visits")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_CREATED);

    }
}