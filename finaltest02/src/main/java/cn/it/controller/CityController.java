package cn.it.controller;

import cn.it.domain.City;
import cn.it.service.CityService;
import cn.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;



    @RequestMapping("/findAll")
    public @ResponseBody
    List<City> findAll(){
        System.out.println(cityService.findAll().size());
        List<City> list = cityService.findAll();
        for (City city : list) {
            System.out.println(city.getCity());
        }
        return cityService.findAll();
    }

}
