package com.weeloa.lostark.api.util.vaildator;

public class StringValidation {

    public static void isEmpty(String txt) {
        if (txt == null || txt.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
