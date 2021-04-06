package guru.sfg.brewery.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @GetMapping({"", "/", "/index.html"})
    public String index(){
        return "index";
    }
}
