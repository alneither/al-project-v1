package org.al.adsystem.model.domain.bean;

import javax.persistence.*;
import java.util.Set;
import static org.al.adsystem.util.Constant.DEFAULT_USERNAME;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int id;

    @Column(name = "login")
    private String login = DEFAULT_USERNAME;

    @Column(name = "salt")
    private String salt;

    @Column(name = "hash")
    private String hash;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private Set<Advert> ads;

    public User() {
    }

    public User(String login, String salt, String hash) {
        this.login = login;
        this.salt = salt;
        this.hash = hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Set<Advert> getAds() {
        return ads;
    }

    public void setAds(Set<Advert> ads) {
        this.ads = ads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!login.equals(user.login)) return false;
        if (!salt.equals(user.salt)) return false;
        return hash.equals(user.hash);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + salt.hashCode();
        result = 31 * result + hash.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", id=" + id +
                '}';
    }
}
