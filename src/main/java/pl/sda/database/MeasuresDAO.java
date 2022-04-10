package pl.sda.database;

import pl.sda.database.weather_entity_classes.Measures;

public class MeasuresDAO extends AbstractDao<Measures>{

    public MeasuresDAO() {
        super(Measures.class);
    }
}
