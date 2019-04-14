package id.banggibima.mobi

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class EditValueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_value)

        val btnCancel = findViewById<View>(R.id.btnCancel)

        btnCancel.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        })
    }
}