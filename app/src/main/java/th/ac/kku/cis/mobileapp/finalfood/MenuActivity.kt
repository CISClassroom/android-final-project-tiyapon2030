package th.ac.kku.cis.mobileapp.finalfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        but_menu_food.setOnClickListener{ startActivity(Intent(this@MenuActivity, MenuFoodActivity::class.java))}

    }
}
