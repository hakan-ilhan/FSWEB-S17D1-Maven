package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    @GetMapping("/")
    public List<Animal> allAnimals(){
        return animals.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id){
        Animal animal = animals.get(id);
        return animal;
    }
    @PostMapping("/")
    public Animal addAnimal(int id,@RequestBody String name){
       Animal animal = new Animal(id,name);
        animals.put(id,animal);
        return animal;
    }
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody String name ){
        Animal animal = new Animal(id,name);
        animals.put(id, animal);
        return animal;
    }
    @DeleteMapping("/{id}")
    public Animal removeAnimal(@PathVariable int id){
        Animal animal = animals.get(id);
        animals.remove(id,new Animal(id, animal.getName()));
        return animal;
    }
}
