package com.gfa.springadvanced.controllers;

import com.gfa.springadvanced.models.DTOs.UserRegisterDTO;
import com.gfa.springadvanced.services.MovieServices;
import com.gfa.springadvanced.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@org.springframework.web.bind.annotation.RestController
@RestController
public class ApiController {


    private final UserService userService;
    private final MovieServices movieServices;

    @Autowired
    public ApiController(UserService userService,
                         MovieServices movieServices) {
        this.userService = userService;
        this.movieServices = movieServices;
    }
    @GetMapping("/movies")
    public ResponseEntity<?> listMovies(@RequestParam Optional<String> optionalTitle) {
    if (optionalTitle.isEmpty()){
        return ResponseEntity.badRequest().build();
    }
    return movieServices.getMoviesByName(optionalTitle.get());
    }

    @GetMapping("/movies/findall")
    public ResponseEntity<?> listMoviesFromDb() {

        return movieServices.getAllMoviesFromDB4();
    }

//    @PostMapping("/api/registruj")
//    public ResponseEntity<String> registerUser(@RequestBody(required = false) UserRegisterDTO userRegisterDTO) {
////    public ResponseEntity<String> registerUser() {
//
//        return ResponseEntity.ok("All good");
//    }

}


