package cn.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path")
public class PathController {

    @RequestMapping("/pathname/{jspName}")
    public String addPath(@PathVariable("jspName") String pathName){
        return pathName;

    }
}
