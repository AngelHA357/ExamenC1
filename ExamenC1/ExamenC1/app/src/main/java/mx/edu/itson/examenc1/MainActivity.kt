package mx.edu.itson.examenc1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tipoPoliza: EditText = findViewById(R.id.tipoPoliza)
        val anios: EditText = findViewById(R.id.anios)
        val costoMostrado: TextView = findViewById(R.id.costo)
        val resultado: TextView = findViewById(R.id.resultado)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val tipo = tipoPoliza.text.toString().trim()
            val aniosTexto = anios.text.toString().trim()

            var costo = 0.0


            if (tipo == "Autos Sedán") {
                costo = 500.00
            } else if (tipo == "Camionetas") {
                costo = 700.00
            } else if (tipo == "Autos Deportivos") {
                costo = 1200.00
            }


            if (costo > 0) {
                costoMostrado.text = "$ $costo"
            } else {
                costoMostrado.text = "Tipo de póliza no válido"
            }


            var aniosInt = 0
            if (aniosTexto.isNotEmpty()) {
                try {
                    aniosInt = aniosTexto.toInt()
                } catch (e: NumberFormatException) {
                    aniosInt = 0
                }
            }


            if (costo > 0 && aniosInt > 0) {
                val precioTotal = costo * aniosInt
                resultado.text = "Pagar $ $precioTotal"
            } else {
                resultado.text = "Pagar $ 0.00"
            }
        }
    }
}
