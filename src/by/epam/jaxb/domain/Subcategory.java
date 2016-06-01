package by.epam.jaxb.domain;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 26.05.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name", "newses"})
public class Subcategory {
    @XmlAttribute
    private int id;
    @XmlElement
    private String name;
    @XmlElement(name = "news")
    @XmlElementWrapper
    private List<News> newses;

    public Subcategory() {
        newses = new ArrayList<>();
    }

    public Subcategory(int id, String name, List<News> newses) {
        this.id = id;
        this.name = name;
        this.newses = newses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNewses() {
        return newses;
    }

    public void setNewses(List<News> newses) {
        this.newses = newses;
    }

    public void addNews(News news) {
        newses.add(news);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subcategory that = (Subcategory) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(newses != null ? !newses.equals(that.newses) : that.newses != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (newses != null ? newses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", newses=" + newses +
                '}';
    }
}
