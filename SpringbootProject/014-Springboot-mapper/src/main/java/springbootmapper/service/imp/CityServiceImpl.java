package springbootmapper.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmapper.dao.CityDao;
import springbootmapper.model.City;
import springbootmapper.service.CityService;

import javax.annotation.Resource;

@Service
public class CityServiceImpl implements CityService {
    @Resource
    private CityDao cityDao;

    @Override
    public City queryCity(Integer id) {
        return cityDao.selectById(id);
    }
}
