package com.am.sweater.domain.dto;

import com.am.sweater.domain.Message;
import com.am.sweater.domain.User;
import com.am.sweater.domain.util.MessageHelper;

public class MessageDto {
    private Integer id;
    private String text;
    private String tag;
    private User author;
    private String filename;
    private Long likes;
    private boolean meLiked;

    public MessageDto() {
    }

    public MessageDto(Message message, Long likes, boolean meLiked) {
        this.id = message.getId();
        this.text = message.getText();
        this.tag = message.getTag();
        this.author = message.getAuthor();
        this.filename = message.getFilename();
        this.likes = likes;
        this.meLiked = meLiked;
    }

    public String getAuthorName(){
        return MessageHelper.getAuthorName(author);
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public User getAuthor() {
        return author;
    }

    public String getFilename() {
        return filename;
    }

    public Long getLikes() {
        return likes;
    }

    public boolean isMeLiked() {
        return meLiked;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", author=" + author +
                ", likes=" + likes +
                ", meLiked=" + meLiked +
                '}';
    }
}
