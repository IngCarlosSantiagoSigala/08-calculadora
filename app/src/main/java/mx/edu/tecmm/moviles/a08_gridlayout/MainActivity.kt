package mx.edu.tecmm.moviles.a08_gridlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    var num1:String= "";
    var num2:String = "";
    var res = 0
    var bandera = false
    var operacion = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun presiono(v: View){
        val vista =  v as TextView
        val txtres =  findViewById<TextView>(R.id.txtRes)


        if (vista.text == "0" || vista.text == "1" || vista.text == "2" || vista.text == "3" ||
            vista.text == "4" || vista.text == "5" || vista.text == "6" || vista.text == "7" ||
            vista.text == "8" || vista.text == "9") {
            if (bandera == false) {
                num1 += vista.text as String
                txtres.text = num1
            } else {
                num2 += vista.text as String
                var ope = ""
                if (operacion == "Suma")
                    ope = "+"
                else if(operacion == "Resta")
                    ope = "-"
                txtres.text = num1.toString() + " " + ope + " " + num2.toString()
            }

        }


        if (vista.text == "+") {
            operacion = "Suma"
            bandera = true
            txtres.text = num1.toString() + "+" + " "
        }else if(vista.text =="-") {
            operacion = "Resta"
            bandera = true
            txtres.text = num1.toString() + "-" + " "
        }else if (vista.text == "C") {
            num1 = ""
            num2 = ""
            txtres.text = "0"
            bandera = false
        } else if (vista.text == "=") {
            if (operacion == "Suma") {
                res = Integer.parseInt(num1) + Integer.parseInt(num2)
                txtres.text = res.toString()
            } else if (operacion == "Resta") {
                res = Integer.parseInt(num1) - Integer.parseInt(num2)
                txtres.text = res.toString()
            } else {
                txtres.text = num1
            }
        }




    }








}
