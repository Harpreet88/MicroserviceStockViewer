package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="quotes", catalog = "test")
public class Quote {

    public Quote() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name=" user_name")
    private String userName;

    @Column(name="quote")
    private String quote;

    public Quote(String userName, String quote) {
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getQuote() {
        return quote;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return Objects.equals(id, quote1.id) &&
                Objects.equals(userName, quote1.userName) &&
                Objects.equals(quote, quote1.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, quote);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}
