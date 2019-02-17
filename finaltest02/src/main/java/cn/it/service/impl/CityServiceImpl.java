package cn.it.service.impl;

import cn.it.domain.City;
import cn.it.mapper.CityMapper;
import cn.it.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> findAll() {
        return cityMapper.findAll();
    }
}
