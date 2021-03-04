package edu.itesm.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val lista = mutableListOf<String>()

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
                var subtotal_ = 0.0
                if (!TextUtils.isEmpty(editTextNumberDecimal.text.toString())){
                    subtotal_ = editTextNumberDecimal.text.toString().toDouble()
                }
                //Log.i("edu.itesm.ubereats", subtotal_.toString())
                var order_ = subtotal_ * 0.02
                orderText.setText("" + order_)
                var service_ = subtotal_ * 0.05
                serviceText.setText("" + service_)
                var delivery_ = subtotal_ * 0.1
                deliveryText.setText("" + delivery_)

                var total_ = subtotal_ + order_ + service_ + delivery_
                totalText.setText("" + total_)

            }
        })
    }

    fun guarda(view: View){
        var totalFinal = totalText.getText().toString().toDouble()
        Log.i(" Total: ", totalFinal.toString())
        lista.add(totalFinal.toString())
        Log.i(" Compras: ", lista.toString())
        orderText.setText(null)
        serviceText.setText(null)
        deliveryText.setText(null)
        totalText.setText(null)
        //editTextNumberDecimal.setText("")
    }

    fun porcentaje(view:View){
        var preTotal = totalText.getText().toString().toDouble()
        var calc = 0.0
        if(view.getId() == button10.getId()){
            calc = preTotal + (preTotal * 0.1)
            totalText.setText("" + calc)
        } else if(view.getId() == button15.getId()){
            calc = preTotal + (preTotal * 0.15)
            totalText.setText("" + calc)
        }else if(view.getId() == button20.getId()){
            calc = preTotal + (preTotal * 0.2)
            totalText.setText("" + calc)
        }else if(view.getId() == button25.getId()){
            calc = preTotal + (preTotal * 0.25)
            totalText.setText("" + calc)
        }else if(view.getId() == button0.getId()){
            totalText.setText("" + preTotal)
        }

    }
}