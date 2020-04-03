package th.ac.kku.cis.mobileapp.finalfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        but_select_menu.setOnClickListener{ startActivity(Intent(this@MainActivity, MenuActivity::class.java))}
        admin_login.setOnClickListener{ startActivity(Intent(this@MainActivity, LoginActivity::class.java))}
        }
    }
