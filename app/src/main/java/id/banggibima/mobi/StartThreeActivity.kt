package id.banggibima.mobi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class StartThreeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_three)

        val btnStart = findViewById<View>(R.id.btnStart) as Button

        btnStart.setOnClickListener(View.OnClickListener {
                view -> start()
        })
    }

    private fun start() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}