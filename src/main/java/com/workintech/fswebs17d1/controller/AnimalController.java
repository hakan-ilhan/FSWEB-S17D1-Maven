package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;
    @Value("${project.developer.fullname}")
    private String fullName;

    @Value("${course.name}")
    private String courseName;
    @PostConstruct
    public void loadAll() {
        System.out.println("postconstruct çalıştı.");
        this.animals = new HashMap<>();
        this.animals.put(1, new Animal(1, "maymun"));
        System.out.println("animalsMap = " + animals);
        System.out.println("fullName=" + fullName + "  --   " + "courseName=" + courseName);
    }


    @GetMapping
    public List<Animal> allAnimals(){
        return animals.values().stream().toList();
    }
    @GetMapping("{id}")
    public Animal getAnimal(@PathVariable int id){
        Animal animal = animals.get(id);
        return animal;
    }
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal){

        animals.put(animal.getId(), animal);
        return animal;
    }
    @PutMapping("{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal ){

        animals.replace(id, animal);
        return animal;
    }
    @DeleteMapping("{id}")
    public Animal removeAnimal(@PathVariable int id){
        Animal animal = animals.get(id);
        animals.remove(id,new Animal(id, animal.getName()));
        return animal;
    }
}
