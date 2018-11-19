package com.am.sweater.domain;

import com.am.sweater.domain.util.MessageHelper;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Please, fill the message")
    @Length(max=2048, message = "Message too long (max - 2kB)")
    private String text;
    @Length(max=255, message = "Tag too long (max - 255 symb)")
    private String tag;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User author;
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @ManyToMany
    @JoinTable(
            name="message_likes",
            joinColumns = { @JoinColumn(name = "message_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<User> likes = new HashSet<>();



    public Message() {
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = "#" + tag;
    }

    public String getAuthorName(){
        return MessageHelper.getAuthorName(author);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }
}
