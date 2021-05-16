package app.makino.harutiro.ReceivingSimpleDataTest

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PixelFormat
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.createBitmap
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    @Suppress("DEPRECATION")
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

        val domein = UrlDomein().hen(text)


        findViewById<TextView>(R.id.textView2).text = domein.toString()



        Picasso.get()
            //いらすとやの画像URL
            .load("https://www.google.com/s2/favicons?domain=$domein")
            .resize(300, 300) //表示サイズ指定
            .centerCrop() //resizeで指定した範囲になるよう中央から切り出し
            .into(findViewById<ImageView>(R.id.imageView)) //imageViewに流し込み






////        WebViewでの画面の取得の仕方。
//
//        val webview = WebView(this)
//
////        画面を取得するときにここがないと取得できない
//        val wm= getSystemService(Context.WINDOW_SERVICE) as WindowManager
//        val params = WindowManager.LayoutParams(
//            1,
//            1,
//            WindowManager.LayoutParams.TYPE_APPLICATION,
//            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
//            PixelFormat.TRANSLUCENT
//        )
//
//        wm.addView(webview, params)
//
//
//
////      URL
//        webview.loadUrl( "https://blog.foresta.me/posts/getting_started_kotlin_and_coroutines/")
//
////        画像取得部分
//        webview.webViewClient = object : WebViewClient() {
//            override fun onPageFinished(view: WebView, url: String) {
//
//
//
//                val picture = view.capturePicture()
//
//                var bitmap = Bitmap.createBitmap(view.width, view.width, Bitmap.Config.ARGB_8888)
//                val c = Canvas(bitmap)
//                picture.draw(c)
//
////                BAG: なんか知らないけど、デバッグツールを使うと読めたり読めなかったりする。
//                var img: Bitmap? = view.favicon //?:Bitmap.createBitmap(1,1,Bitmap.Config.ARGB_8888)
//
////                画像取得部分
//                findViewById<ImageView>(R.id.imageView).setImageBitmap(img)
//
//
//
//            }
//        }
    }
}