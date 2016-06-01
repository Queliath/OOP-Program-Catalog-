package by.epam.jaxb.domain;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 26.05.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name", "subcategories"})
public class Category {
    @XmlAttribute
    private int id;
    @XmlElement
    private String name;
    @XmlElement(name = "subcategory")
    @XmlElementWrapper
    private List<Subcategory> subcategories;

    public Category(){
        this.subcategories = new ArrayList<>();
    }

    public Category(int id, String name, List<Subcategory> subcategories) {
        this.id = id;
        this.name = name;
        this.subcategories = subcategories;
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

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public void addSubcategory(Subcategory subcategory) {
        subcategories.add(subcategory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        return !(subcategories != null ? !subcategories.equals(category.subcategories) : category.subcategories != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (subcategories != null ? subcategories.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subcategories=" + subcategories +
                '}';
    }
}
