package com.skripsi.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andri Kurniawan <andrikurniawan.id@gmail.com>
 * on 5/13/2017.
 */

@RestController
@RequestMapping("/")
public class WebController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test(){
        return "API success";
    }
}
