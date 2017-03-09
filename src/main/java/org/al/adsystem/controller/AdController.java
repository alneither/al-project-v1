package org.al.adsystem.controller;

import org.al.adsystem.model.domain.bean.Advert;
import org.al.adsystem.service.iface.AdService;
import org.al.adsystem.util.UserDataValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.al.adsystem.util.Constant.*;

@Controller
public class AdController {

    private static final Object INCORRECT_AD_DATA_ENTERED =
            "Please, fill all required fields.";
    private AdService service;

    @RequestMapping("/new-ad")
    public String newAdPage() {
        return "new-ad";
    }

    @RequestMapping(value = "/add-new-ad", method = RequestMethod.POST)
    public String addNewAd(final HttpServletRequest request, final HttpSession session) {
        String header = request.getParameter("ad-header");
        String body = request.getParameter("ad-body");
        String contact = request.getParameter("ad-contact");

        if (UserDataValidator.validateAdData(header, body, contact)) {
            Advert advert = new Advert(header, body, contact);
            service.addNewAdvert(advert);
        } else {
            request.setAttribute(ERROR_MESSAGE_NAME, INCORRECT_AD_DATA_ENTERED);
            return "new-ad";
        }

        return "index";
    }

    public void setService(final AdService service) {
        this.service = service;
    }
}
