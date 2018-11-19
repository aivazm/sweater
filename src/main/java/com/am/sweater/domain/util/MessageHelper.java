package com.am.sweater.domain.util;

import com.am.sweater.domain.User;

public abstract class MessageHelper {
    public static String getAuthorName (User author){
        return author != null ? author.getUsername() : "<none>";
    }
}
