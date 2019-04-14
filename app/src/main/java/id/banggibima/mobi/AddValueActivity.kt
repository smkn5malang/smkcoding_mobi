package id.banggibima.mobi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_value.*

class AddValueActivity : AppCompatActivity() {

    lateinit var mAdd : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_value)

        mAdd = FirebaseDatabase.getInstance().getReference("users")

        val btnCreate = findViewById<View>(R.id.btnCreate);
        val btnCancel = findViewById<View>(R.id.btnCancel)

        btnCancel.setOnClickListener  {View.OnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }  }

        btnCreate.setOnClickListener { View.OnClickListener {
            savedata()
        } }
    }

    private fun savedata() {
        val title = titledoesadd.text.toString()
        val desc = descdoesadd.text.toString()
        val date = datedoesadd.text.toString()

        val user = Users(title, desc, date)
        val userId = mAdd.push().key.toString()

        mAdd.child(userId).setValue(user).addOnCompleteListener {
            Toast.makeText(this, "Successs",Toast.LENGTH_SHORT).show()
            titledoesadd.setText("")
            descdoesadd.setText("")
            datedoesadd.setText("")
        }
    }
}