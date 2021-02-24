package edu.itesm.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        editTextNumberDecimal.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                var subtotal_ = editTextNumberDecimal.text.toString().toDouble()
                Log.i("edu.itesm.ubereats", subtotal_.toString())
                var order_ = subtotal_ * 0.02
                orderText.setText("" + order_)
                var service_ = subtotal_ * 0.05
                serviceText.setText("" + service_)
                var delivery_ = subtotal_ * 0.1
                deliveryText.setText("" + delivery_)

            }
        })
    }

    fun guarda(view: View){
        /*var subtotal_ = editTextNumberDecimal.text.toString().toDouble()
        Log.i("edu.itesm.ubereats", subtotal_.toString())*/

    }
}