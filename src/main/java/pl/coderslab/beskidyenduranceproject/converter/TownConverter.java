package pl.coderslab.beskidyenduranceproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.beskidyenduranceproject.entity.Town;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;

public class TownConverter implements Converter<String, Town> {

    @Autowired
    TownRepository townRepository;

    @Override
    public Town convert(String s) {
        Town town = townRepository.getOne(Long.parseLong(s));
        return town;
    }
}


