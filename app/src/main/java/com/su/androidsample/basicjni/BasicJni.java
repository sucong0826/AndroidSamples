package com.su.androidsample.basicjni;

import com.su.androidsample.basicjni.entity.Book;

import java.util.List;

/**
 * It contains all JNI functions.
 * <p>
 * Created by Zoom Clever Su on 09/08/2017.
 */

public class BasicJni {

    public Book filter(List<Book> bookList) {
        if (bookList != null && !bookList.isEmpty()) {
            return bookList.get(0);
        }

        return Book.DEF_BOOK;
    }

    public native List<Book> generateBooks();
}
