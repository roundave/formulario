package com.example.formulario

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var option: Spinner
    lateinit var result: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Oncreate", "ok")

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        bt_fecha.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear: Int, mMonth: Int, mDay: Int ->
                    tv_fecha.text = "" + mDay + "/" + mMonth + "/" + mYear
                },
                year,
                month,
                day
            )
            dpd.show()
        }

  ///// creamos las variables para guardar
        bt_guardar.setOnClickListener {
            val nombre = et_nombre.text.toString()
            val telefono = et_telefono.text.toString()
            val correo = et_email.text.toString()
            val contrasena = et_password.text.toString()
            val repcontrasena = et_confirmar_password.text.toString()
            val genero = if (rb_masculino.isChecked) "Masculino" else "Femenino"
            val ciudadnacimiento = sp_ciudad_nacimiento.selectedItem.toString()
            var pasatiempos = ""
            if (ch_cine.isChecked) pasatiempos = "$pasatiempos cine" // sirve para concatenar
            if (ch_videojuegos.isChecked) pasatiempos = "$pasatiempos videojuegos"
            if (ch_cocinar.isChecked) pasatiempos = "$pasatiempos cocinar"


/////////////////////////////////////////////////////////////////////////////////

             /////cargar la app de la fecha

            val fecha = tv_fecha.text.toString()

           ///////// //validar campos vacios
            if (nombre.trim().isEmpty()) {
                Toast.makeText(this, "ingrese un nombre", Toast.LENGTH_SHORT).show()
            }
            if (telefono.trim().isEmpty()) {
                Toast.makeText(this, "Ingrese un numero de telefono", Toast.LENGTH_SHORT).show()
            }
            if (correo.trim().isEmpty()) {
                Toast.makeText(this, "ingrese un correo", Toast.LENGTH_SHORT).show()
            }
            if (contrasena.trim().isEmpty()) {
                Toast.makeText(this, "ingrese una contraseña", Toast.LENGTH_SHORT).show()
            }

            if (ciudadnacimiento.trim().isEmpty()) {
                Toast.makeText(this, "Ingrese una ciudad ", Toast.LENGTH_SHORT).show()
            }
            if (genero.trim().isEmpty()) {
                Toast.makeText(this, "Seleccione el genero", Toast.LENGTH_SHORT).show()
            }
            if (fecha.trim().isEmpty()) {
                Toast.makeText(this, "ingrese una fecha ", Toast.LENGTH_SHORT).show()
            }
            if (pasatiempos.trim().isEmpty()) {
                Toast.makeText(this, "Seleccione al menos un pasatiempo", Toast.LENGTH_SHORT).show()
            }

            if (contrasena == repcontrasena && contrasena.trim().isNotEmpty() && nombre.trim().isNotEmpty() && correo.trim().isNotEmpty()
                && fecha.trim().isNotEmpty() && pasatiempos.trim().isNotEmpty() && ciudadnacimiento.trim().isNotEmpty()
                && genero.trim().isNotEmpty() && telefono.trim().isNotEmpty()) {
                tv_resultado.text =
                    "Nombre: $nombre \nTelefono: $telefono \nEmail: $correo \npasatiempo: $pasatiempos \nCiudad de nacimiento: $ciudadnacimiento \n" +
                            "fecha de nacimiento: $fecha "
                animation_view.playAnimation()

            } else if (contrasena != repcontrasena && contrasena.trim().isNotEmpty()) {
                Toast.makeText(this, "contraseñas no conciden ", Toast.LENGTH_SHORT).show()
            }
        }


        //val btGuardar : Button=findViewById(R.id.bt_guardar)
        //val et_nombre:  EditText=findViewById(R.id.et_nombre)


        /*option=findViewById(R.id.sp_ciudad_nacimiento) as Spinner
        result=findViewById(R.id.tv_ciudad_nacimiento) as TextView
        val Opciones= arrayOf("Cali", "Medellin", "Bogota", "Popayan")
        option.adapter= ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Opciones)
        option.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text="Selecciona una opcion"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                result.text=Opciones.get(position)
            }
        }*/

        ///////////////datapicker para la fecha

        ///////////////////////////////////////////////////////
    }

    override fun onStart() {
        super.onStart()
        Log.d("OnStart", "ok")
    }

    override fun onResume() {
        super.onResume()
        Log.d("OnResume", "ok")
    }

    override fun onPause() {
        super.onPause()
        Log.d("OnPause", "ok")
    }

    override fun onStop() {
        super.onStop()
        Log.d("OnStop", "ok")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("OnRestart", "ok")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroy", "ok")
    }
}
