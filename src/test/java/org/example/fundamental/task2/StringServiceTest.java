package org.example.fundamental.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//Tasks:
//
//Test reverse() with normal string
//Test reverse() with empty string
//Test reverse() with single character
//Implement and test isPalindrome() method

class StringServiceTest {

    private final StringService service = new StringService();

    @Test
    void reverse_whenNormalString()
    {
        String actualResult = service.reverse("hi");
        assertEquals("ih", actualResult);
    }

    @Test
    void reverse_whenEmptyString()
    {
        String actualResult = service.reverse("");
        assertEquals("", actualResult);
    }

    @Test
    void reverse_whenSingleChar()
    {
        String actualResult = service.reverse("a");
        assertEquals("a", actualResult);
    }

    @Test
    void reverse_whenNullString()
    {
        String actualResult = service.reverse(null);
        assertNull(actualResult);
    }

    @Test
    void palindrome_whenPalindrome()
    {
        boolean flag = service.isPalindrome("lol");
        assertTrue(flag);
    }

    @Test
    void palindrome_whenNotPalindrome()
    {
        boolean flag = service.isPalindrome("ahmed");
        assertFalse(flag);
    }

    @Test
    void palindrome_whenEmptyString()
    {
        boolean flag = service.isPalindrome("");
        assertFalse(flag);
    }


}