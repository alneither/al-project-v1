package org.al.adsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageFeedController {

    @RequestMapping("/")
    public String mainPage() {
        return "index";
    }
}
