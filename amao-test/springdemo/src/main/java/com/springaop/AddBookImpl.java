package com.springaop;

public class AddBookImpl implements AddBook {
    @Override
    public void addBook(String name) {
        System.out.println("添加书籍:"+name);
    }
}
