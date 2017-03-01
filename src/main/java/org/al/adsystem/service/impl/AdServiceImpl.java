package org.al.adsystem.service.impl;

import org.al.adsystem.dao.iface.AdProviderDAO;
import org.al.adsystem.model.domain.bean.Advert;
import org.al.adsystem.service.iface.AdService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    private AdProviderDAO dao;

    @Override
    public List<Advert> getCurrentAds() {
        return null;
    }

    @Override
    public List<Advert> getUserAds(int id) {
        return null;
    }

    @Override
    public void addNewAdvert(Advert newAd) {
        dao.addNewAdvert(newAd);
    }

    public void setDao(AdProviderDAO dao) {
        this.dao = dao;
    }
}
