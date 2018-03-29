package com.myandroid.myfirstapp

class MarriageSuggestion {

    fun getSuggestoin(strSex: String, iAge: Int): String {
        var strSug = ""
        if (strSex == "男")
            if (iAge < 28)
                strSug += "還不急。"
            else if (iAge > 33)
                strSug += "趕快結婚。"
            else
                strSug += "開始找對象。"
        else if (iAge < 25)
            strSug += "還不急。"
        else if (iAge > 30)
            strSug += "趕快結婚。"
        else
            strSug += "開始找對象。"
        return strSug
    }
}
