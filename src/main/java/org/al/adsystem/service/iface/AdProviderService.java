package org.al.adsystem.service.iface;

import org.al.adsystem.model.domain.bean.Advert;
import java.util.List;

public interface AdProviderService {

    List<Advert> getCurrentAds();

    List<Advert> getUserAds(int id);

    int addNewAdvert(Advert newAd);


}
