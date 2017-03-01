package org.al.adsystem.model.domain.bean;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "header")
    private String header;

    @Column(name = "body")
    private String body;

    @Column(name = "contact")
    private String contact;

    public Advert() {
    }

    public Advert(String header, String body, String contact) {
        this.header = header;
        this.body = body;
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advert advert = (Advert) o;
        return (id == advert.getId());
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + header.hashCode();
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Advert{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", body='" + body + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
