package id.banggibima.mobi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val btnGetStarted = findViewById<View>(R.id.btnGetStarted) as Button

        btnGetStarted.setOnClickListener(View.OnClickListener {
                view -> getstarted()
        })
    }

    private fun getstarted() {
            startActivity(Intent(this, StartTwoActivity::class.java))
    }
}