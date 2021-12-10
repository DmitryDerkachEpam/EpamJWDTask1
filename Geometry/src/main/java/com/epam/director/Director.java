package com.epam.director;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.dataprocessing.DataException;
import com.epam.dataprocessing.DataReader;
import com.epam.director.associativeclasses.ConeCreator;
import com.epam.director.associativeclasses.ConeValidator;
import com.epam.entities.Cone;

public class Director {

    private static final Logger LOGGER = LogManager.getLogger(Director.class);

    private final DataReader reader;
    private final ConeValidator validator;
    private final ConeCreator creator;

    public Director(DataReader reader, ConeValidator validator, ConeCreator creator) {
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Cone> read(String path) {
        LOGGER.info("Started reading data from file with aderess: " + path);
        List<Cone> cones = new ArrayList<>();
        try {
            for (String line : reader.read(path)) {
                if (validator.isValid(line)) {
                    Cone cone = creator.create(line);
                    cones.add(cone);
                }
            }
        } catch (DataException e) {
        }
        return cones;
    }
}
