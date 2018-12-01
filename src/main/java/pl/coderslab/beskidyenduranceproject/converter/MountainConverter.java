package pl.coderslab.beskidyenduranceproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.beskidyenduranceproject.entity.Mountain;
import pl.coderslab.beskidyenduranceproject.entity.Town;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;

public class MountainConverter implements Converter<String, Mountain> {

    @Autowired
    MountainRepository mountainRepository;

    @Override
    public Mountain convert(String s) {
        Mountain mountain = mountainRepository.getOne(Long.parseLong(s));
        return mountain;
    }
}


