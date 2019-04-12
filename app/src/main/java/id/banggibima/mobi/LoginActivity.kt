package id.banggibima.mobi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<View>(R.id.btnLogin) as Button
        val  txtBelumPunyaAkun = findViewById<View>(R.id.txtBelumPunyaAkun) as TextView

        btnLogin.setOnClickListener(View.OnClickListener { 
            view -> login()
        })

        txtBelumPunyaAkun.setOnClickListener(View.OnClickListener {
            view -> register()
        })
    }

    private fun login() {
        val inputEmailLogin = findViewById<View>(R.id.inputEmailLogin) as EditText
        val inputPasswordLogin = findViewById<View>(R.id.inputPasswordLogin) as EditText

        var email = inputEmailLogin.text.toString()
        var password = inputPasswordLogin.text.toString()

        if (!email.isEmpty() && !password.isEmpty()) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener {
                task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, HomeActivity::class.java))
                    Toast.makeText(this, "successfully logged in", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "error ", Toast.LENGTH_LONG).show()
                }
            })
        } else {
            Toast.makeText(this, "please fill up to credentials", Toast.LENGTH_LONG).show()
        }
    }

    private fun register() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}
