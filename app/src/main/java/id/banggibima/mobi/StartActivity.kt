package id.banggibima.mobi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_home.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val btnContinue = findViewById<View>(R.id.btnContinue) as Button

        btnContinue.setOnClickListener(View.OnClickListener {
                view -> lanjutkan()
        })
    }

    private fun lanjutkan() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}