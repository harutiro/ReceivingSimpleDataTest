package app.makino.harutiro.ReceivingSimpleDataTest

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text = ""

        if (TextUtils.equals(intent.action, Intent.ACTION_SEND)) {
            val extras = intent.extras
            val extraText = extras!!.getCharSequence(Intent.EXTRA_TEXT).toString()

            text = extraText

            if (!TextUtils.isEmpty(extraText)) {
//                doSomething(extraText)
            }
        }

        findViewById<TextView>(R.id.textView).text = text
    }
}