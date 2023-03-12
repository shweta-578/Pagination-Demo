package com.paginationDemo.service;

import com.paginationDemo.model.Country;

import java.util.List;

public interface CountryService {
    public Country saveCountry(Country country);
 List<Country> findPaginated(int pageNo, int pageSize);
    public  List<Country> findAll();
}
