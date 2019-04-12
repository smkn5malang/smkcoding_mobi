package id.banggibima.mobi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class StartTwoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_two)

        val btnContinues = findViewById<View>(R.id.btnContinues) as Button

        btnContinues.setOnClickListener(View.OnClickListener {
                view -> continues()
        })
    }

    private fun continues() {
        startActivity(Intent(this, StartThreeActivity::class.java))
    }
}