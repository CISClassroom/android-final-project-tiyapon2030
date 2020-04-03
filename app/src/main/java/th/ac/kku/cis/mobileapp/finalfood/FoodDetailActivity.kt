package th.ac.kku.cis.mobileapp.finalfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_detail.*

class FoodDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)
        val i = intent
        var get_name_food = i.getStringExtra("food")
        var get_mat = i.getStringExtra("food_mat")
        var get_how = i.getStringExtra("food_how")



        foodshowname.text = get_name_food
        foodshowmat.text = get_mat
        foodshowhow.text = get_how


    }
}

