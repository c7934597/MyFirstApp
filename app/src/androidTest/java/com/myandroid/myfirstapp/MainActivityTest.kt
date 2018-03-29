package com.myandroid.myfirstapp

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.test.ActivityInstrumentationTestCase2
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest : ActivityInstrumentationTestCase2<MainActivity>(MainActivity::class.java) {

    //用來儲存MainActivity 物件和它的介面元件
    private var mMainActivity: MainActivity? = null
    private var mEdtSex: EditText? = null
    private var mEdtAge: EditText? = null
    private var mBtnDoSug: Button? = null
    private var mTxtResult: TextView? = null

    @Before
    @Throws(Exception::class)
    public override fun setUp() {
        super.setUp()

        //完成初始設定。
        injectInstrumentation(InstrumentationRegistry.getInstrumentation())

        //利用 getActivity()方法取得 MainActivity物件
        //再取得MainActivity物件的介面元件
        mMainActivity = activity as MainActivity
        mEdtSex = mMainActivity!!.findViewById<View>(R.id.edtSex) as EditText?
        mEdtAge = mMainActivity!!.findViewById<View>(R.id.edtAge) as EditText?
        mBtnDoSug = mMainActivity!!.findViewById<View>(R.id.btnOK) as Button?
        mTxtResult = mMainActivity!!.findViewById<View>(R.id.txtR) as TextView?
    }

    @Test
    fun maleAge25() {
        //測試男生，年齡25的情況
        //對於介面元件的控制必須在UI thread (或稱為 main thread) 中執行
        mMainActivity!!.runOnUiThread {
            mEdtSex!!.setText("男")
            mEdtAge!!.setText("25")
            mBtnDoSug!!.performClick()
        }

        //由於模擬器執行比較慢，等候一點時間讓他執行完畢
        try {
            Thread.sleep(2000) //等2秒鐘
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        //檢查是否顯示正確的字串
        Assert.assertEquals("建議:" + mMainActivity!!.getString(R.string.sug_not_hurry), mTxtResult!!.text.toString())
    }

    @After
    @Throws(Exception::class)
    public override fun tearDown() {
        super.tearDown()

        //加入測試完畢後執行清除的程式碼。
    }
}
