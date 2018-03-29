package com.myandroid.myfirstapp

import org.junit.Test

import junit.framework.Assert.assertEquals

class MarriageSuggestionTest {

    @Test
    fun getSuggestoin() {
        val marriageSuggestion = MarriageSuggestion()

        var s = marriageSuggestion.getSuggestoin("男", 25)
        assertEquals(s, "還不急。")

        s = marriageSuggestion.getSuggestoin("男", 30)
        assertEquals(s, "開始找對象。")

        s = marriageSuggestion.getSuggestoin("男", 34)
        assertEquals(s, "趕快結婚。")

        s = marriageSuggestion.getSuggestoin("女", 24)
        assertEquals(s, "還不急。")

        s = marriageSuggestion.getSuggestoin("女", 29)
        assertEquals(s, "開始找對象。")

        s = marriageSuggestion.getSuggestoin("女", 31)
        assertEquals(s, "趕快結婚。")

    }
}
