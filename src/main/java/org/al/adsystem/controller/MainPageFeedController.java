package org.al.adsystem.controller;

import org.al.adsystem.model.domain.bean.Advert;
import org.al.adsystem.service.iface.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class MainPageFeedController {

    private AdService service;

    @RequestMapping("/")
    public String mainPage() {

        return "index";
    }

}
