package springbootmapper.dao;

import springbootmapper.model.City;

public interface CityDao {
    City selectById(Integer id);
}
