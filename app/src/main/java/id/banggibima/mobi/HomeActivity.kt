package id.banggibima.mobi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textDescription = findViewById<View>(R.id.textDescription) as TextView
        val btnLogout  = findViewById<View>(R.id.btnLogout) as Button

        mDatabase = FirebaseDatabase.getInstance().getReference("names")

        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val result = snapshot.child("names").toString()
                textDescription.text = "welcome " +  result
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })

        btnLogout.setOnClickListener(View.OnClickListener {
            view -> logout()
        })
    }

    private fun logout() {
        mAuth .signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        Toast.makeText(this, "logged out", Toast.LENGTH_LONG).show()
    }
}