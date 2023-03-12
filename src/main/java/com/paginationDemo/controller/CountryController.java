package com.paginationDemo.controller;

import com.paginationDemo.model.Country;
import com.paginationDemo.repository.CountryRepository;
import com.paginationDemo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryService countryService;
    @Autowired
    CountryRepository countryRepository;
    @PostMapping("/saveCountry")
    public ResponseEntity<Object> saveCountry(@RequestBody Country country){
        Country savedCountry=countryService.saveCountry(country);
        return new ResponseEntity<Object>(savedCountry,HttpStatus.CREATED);

    }

    @GetMapping("/countries/{pageNo}/{pageSize}")
    public List<Country> getPaginatedCountries(@PathVariable int pageNo,
                                               @PathVariable int pageSize) {

        return countryService.findPaginated(pageNo, pageSize);
    }
    @GetMapping("/findAll")
    public List<Country> getAll(){
List<Country> countries=countryService.findAll();
System.out.println(countries);
return  countries;
    }


}
