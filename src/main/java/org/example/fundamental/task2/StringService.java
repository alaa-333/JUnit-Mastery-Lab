package org.example.fundamental.task2;

import java.util.Objects;

public class StringService {

    public String reverse(String arg)
    {
        if (Objects.isNull(arg)) {
            return null;
        }
        return new StringBuilder(arg).reverse().toString();
    }

    public boolean isPalindrome(String str)
    {
        if (Objects.isNull(str) || str.isEmpty()) {
            return false;
        }

        String reversedString = reverse(str);
        return str.equals(reversedString);
    }
}
