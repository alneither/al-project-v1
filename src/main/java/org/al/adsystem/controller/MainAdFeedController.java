package org.al.adsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class MainAdFeedController {
    @RequestMapping(method = RequestMethod.GET)
    public String doStart() {
        return "index";
    }
}
