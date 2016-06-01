package by.epam.jaxb.domain;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 26.05.2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"categories"})
public class NewsPortal {
    @XmlElement(name = "category")
    @XmlElementWrapper
    private List<Category> categories;

    public NewsPortal() {
        categories = new ArrayList<>();
    }

    public NewsPortal(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsPortal that = (NewsPortal) o;

        return !(categories != null ? !categories.equals(that.categories) : that.categories != null);

    }

    @Override
    public int hashCode() {
        return categories != null ? categories.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "NewsPortal{" +
                "categories=" + categories +
                '}';
    }
}
