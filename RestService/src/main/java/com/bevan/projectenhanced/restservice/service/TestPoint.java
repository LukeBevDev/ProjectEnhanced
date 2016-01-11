package com.bevan.projectenhanced.restservice.service;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Luke on 10-Jan-16.
 */
@Path("/test-point")
public class TestPoint {

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Product test() {
        return new Product(100, "Hello World");
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private class Product {
        private int id;
        private String name;

        public Product(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


