package entities;

import enums.Level;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", level=" + level +
                '}';
    }

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Level level;

    public Message() {
        this.date = new Date();
    }

    public Message(String text, Level level) {
        this.date = new Date();
        this.text = text;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
