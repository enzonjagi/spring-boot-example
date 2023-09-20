package com.chiefomar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.RectangularShape;
import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
        //System.out.println("Asalaam Aleykum");
    }
    @GetMapping("/")
    public GreetResponse greet() {
         GreetResponse response = new GreetResponse(
                "Hello",
                List.of("Java", "Python", "Kotlin"),
                new Person(
                        "Omar",
                        28,
                        900000.0
                )
         );

        return response;
    }

    record Person (String name, int age, double savings) {}
    record GreetResponse(
            String greet,
            List<String>  favProgrammingLanguages,
            Person person
    ){}
    /*NOTE: The above line of code can also be written as:
    * class GreetResponse {
    *   private final String greet;
    *
    *   GreetResponse (String greet) {
    *       this.greet = greet;
    *   }
    *
    *   @Override
    *   public String toString() {
    *       return "GreetResponse{" +
    *               "greet="+ greet + '\'' + '}';
    *   }
    *
    *   @Override
    *   public boolean equals(Object o){
    *       if (this == o) return true;
    *       if (o == null || getClass() != o.getClass() ) return false;
    *       GreetResponse that = (GreetResponse) o;
    *       return Objects.equals(greet, that.greet);
    *   }
    *
    *   @Override
    *   public int hashCode() {
    *       return Objects.hash(greet);
    *   }
    * }
    * */

}
