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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister = findViewById<View>(R.id.btnRegister) as Button
        val btnCancel = findViewById<View>(R.id.btnCancel) as Button
        val txtSudahPunyaAkun = findViewById<View>(R.id.txtSudahPunyaAkun) as TextView

        mDatabase = FirebaseDatabase.getInstance().getReference("names")

        btnRegister.setOnClickListener(View.OnClickListener {
            view -> register()
        })

        btnCancel.setOnClickListener(View.OnClickListener {
            view -> cancel()
        })

        txtSudahPunyaAkun.setOnClickListener(View.OnClickListener {
            view -> haveaccount()
        })
    }

    private fun haveaccount() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun register() {
        val inputUsernameRegister = findViewById<View>(R.id.inputUsernameRegister) as EditText
        val inputEmailRegister = findViewById<View>(R.id.inputEmailRegister) as EditText
        val inputPasswordRegister = findViewById<View>(R.id.inputPasswordRegister) as EditText

        val username = inputUsernameRegister.text.toString()
        val email = inputEmailRegister.text.toString()
        val password = inputPasswordRegister.text.toString()

        if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener {
                task ->
                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    val uid = user!!.uid
                    mDatabase.child(uid).child("name").setValue(username)
                    Toast.makeText(this, "successfully signed in", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
                }
            })
        } else {
            Toast.makeText(this, "please enter the credentials", Toast.LENGTH_LONG).show()
        }
    }

    private fun cancel() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
