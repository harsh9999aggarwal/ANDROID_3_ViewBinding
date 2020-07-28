package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.apply {
   //         isVisible = false
            textView.text="101010"
            textView.setTextColor(getColor(R.color.colorAccent))
            textView.textSize = 40f
        }

        editTextTextPersonName.apply {
//            isEnabled = false     //it is used to disabe the whole property
            hint = "enter your name"
            setText("harsh aggarwal")
            addTextChangedListener {
                Log.i("ViewBinding", it.toString())
                button.isEnabled = it.toString().length in 7..19
            }


/*
        // we generally dont use this method
        // we use xyz.apply{}


        with(textView){
            textView.text="101010"
            textView.setTextColor(getColor(R.color.colorAccent))
            textView.textSize = 40f
        }
*/

/*      //when we want to call every line separately

        textView.text="101010"
        textView.setTextColor(getColor(R.color.colorAccent))
        textView.textSize = 40f
*/

            button.setOnClickListener {
                Toast.makeText(it.context, "Button Pressed", Toast.LENGTH_LONG).show()
            }
            // below function willwork first becoause code writte below will be ececuted first
            /*button.setOnClickListener(object : View.OnClickListener {
                override fun Onclick(v: View) {
                    Toast.makeText(v.context, "Button Pressed from annonymous function", Toast.LENGTH_LONG).show()
                }
            })*/

        }
     button.setOnClickListener(this)

    }



    override fun onClick(v: View) {
        Toast.makeText(v.context , "Button Pressed from interface function" , Toast.LENGTH_LONG).show()
    }


    /*fun showToast(view: View) {
         Toast.makeText(view.context , "Button Pressed" , Toast.LENGTH_LONG).show()
     }*/
}