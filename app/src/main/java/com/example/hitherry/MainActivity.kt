package com.example.hitherry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var a= ArrayList<ImageView>()
    var runnable:Runnable= Runnable {  }
    var handler:Handler= Handler()
    var value:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a=arrayListOf<ImageView>(image1,image2,image3,image4,image5,image6,image7,image8,image9)
        //helper()

        helper()
        //hideimages()
}
    fun helper(){
        var fg:Int=0;
        while(fg<9){
            a[fg].visibility=View.INVISIBLE
            fg++
    }}
fun hideimages(view: View){
    textView.text="High Score: 0"
    value=0
    val timew= object :CountDownTimer(20000,1000) {
        override fun onFinish() {
            textView2.text = "Time Left:0s"
            handler.removeCallbacks(runnable)
            helper()
            button.visibility=View.VISIBLE
        }

        override fun onTick(millisUntilFinished: Long) {
            textView2.text = "Time Left:" + millisUntilFinished/1000+"s"
            button.visibility=View.INVISIBLE
        }
    }.start()
    runnable=object : Runnable{
        override fun run() {
            var x=(0..8).random();
            var j:Int=0;
            while(j<9){
                a[j].visibility=View.INVISIBLE
                if(j==x){
                    a[j].visibility=View.VISIBLE
                }
                j++
            }
            handler.postDelayed(runnable,200)
        }
    }
handler.post(runnable)
}
    fun score(view: View){
       // if(view.visibility==View.VISIBLE){
            value=value+5
            textView.text="High Score: "+value
        //}
    }
}
