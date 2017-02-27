package org.al.adsystem.dao.iface;

import org.al.adsystem.model.domain.bean.Advert;

import java.util.List;

public interface AdProviderDAO {

    List<Advert> getCurrentAds();

    List<Advert> getUserAds(int id);

    void addNewAdvert(Advert newAd);

}
