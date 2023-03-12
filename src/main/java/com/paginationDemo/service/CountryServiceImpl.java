package com.paginationDemo.service;


import com.paginationDemo.model.Country;
import com.paginationDemo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements  CountryService{
    @Autowired
    CountryRepository countryRepository;

    public Country saveCountry(Country country){
        Country savedCountry=countryRepository.save(country);
        List<Country> countries=countryRepository.findAll();
        System.out.println(countries);
        return savedCountry;

    }

    @Override
    public List<Country> findPaginated(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Country> pagedResult = countryRepository.findAll(paging);

        return pagedResult.toList();
    }

    @Override
    public List<Country> findAll() {
        List<Country> list = new ArrayList<>();
        Iterable<Country> items = countryRepository.findAll();
        items.forEach(list::add);
        return list;
    }

}
