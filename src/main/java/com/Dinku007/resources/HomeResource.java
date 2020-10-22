package com.Dinku007.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anand SN
 */

@RestController
@RequestMapping("/home")
public class HomeResource {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @RequestMapping("/index")
    public String index(){
        return "Hello World! from index";
    }

}
