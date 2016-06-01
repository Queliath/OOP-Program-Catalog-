package by.epam.jaxb.domain;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 26.05.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name", "provider", "dateOfIssue", "body"})
public class News {
    @XmlAttribute
    private int id;
    @XmlElement
    private String name;
    @XmlElement(name = "author")
    @XmlElementWrapper
    private List<String> provider;
    @XmlElement
    private XMLGregorianCalendar dateOfIssue;
    @XmlElement
    private String body;

    public News() {
        provider = new ArrayList<>();
    }

    public News(int id, String name, List<String> provider, String body, XMLGregorianCalendar dateOfIssue) {
        this.id = id;
        this.name = name;
        this.provider = provider;
        this.body = body;
        this.dateOfIssue = dateOfIssue;
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

    public List<String> getProvider() {
        return provider;
    }

    public void setProvider(List<String> provider) {
        this.provider = provider;
    }

    public void addAuthor(String author) {
        provider.add(author);
    }

    public XMLGregorianCalendar getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(XMLGregorianCalendar dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (name != null ? !name.equals(news.name) : news.name != null) return false;
        if (provider != null ? !provider.equals(news.provider) : news.provider != null) return false;
        if (dateOfIssue != null ? !dateOfIssue.equals(news.dateOfIssue) : news.dateOfIssue != null) return false;
        return !(body != null ? !body.equals(news.body) : news.body != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (dateOfIssue != null ? dateOfIssue.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", provider=" + provider +
                ", dateOfIssue=" + dateOfIssue +
                ", body='" + body + '\'' +
                '}';
    }
}
