package org.al.adsystem.dao.impl;

import org.al.adsystem.dao.iface.AdProviderDAO;
import org.al.adsystem.model.domain.bean.Advert;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AdProviderDAOImpl implements AdProviderDAO {

    private SessionFactory sessionFactory;

    @Override
    public List<Advert> getCurrentAds() {
        return null;
    }

    @Override
    public List<Advert> getUserAds(int id) {
        return null;
    }

    @Transactional
    @Override
    public void addNewAdvert(Advert newAd) {
        sessionFactory.getCurrentSession().save(newAd);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
