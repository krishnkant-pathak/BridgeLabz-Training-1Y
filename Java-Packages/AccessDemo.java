package com.access.two;

import com.access.one.Base;

public class AccessDemo extends Base {

    public void test() {
        showPublic();
        showProtected();
    }

    public static void main(String[] args) {
        new AccessDemo().test();
    }
}