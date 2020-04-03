package th.ac.kku.cis.mobileapp.finalfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


import th.ac.kku.cis.mobileapp.finalfood.Adapter.actfoodadapter
import th.ac.kku.cis.mobileapp.finalfood.Model.showfood

class MenuFoodActivity : AppCompatActivity() {

    val TAG = "ListShowACt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_food)

        Firebase.database.reference.child("fooddata").addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                val listView: ListView = findViewById(R.id.list_food)
                val activities_list = mutableListOf<showfood>()
                for (postSnapshot in p0.children) {

                    Log.d(TAG,postSnapshot.key.toString())
                    //activities_list.add(showfood(postSnapshot.key.toString(),postSnapshot.child("foodhow").getValue().toString(),postSnapshot.child("foodmat").getValue().toString())
                    activities_list.add(showfood(postSnapshot.key.toString(),postSnapshot.child("foodhow").getValue().toString(),postSnapshot.child("foodmat").getValue().toString()))
               }

                listView.adapter = actfoodadapter(
                    this@MenuFoodActivity,
                    R.layout.patternact,
                    activities_list
                )
                listView.setOnItemClickListener { parent, view, position, id ->
                    val selectedItem = parent.getItemAtPosition(position) as showfood
                    //Toast.makeText(this@MenuFoodActivity, selectedItem.nickname, Toast.LENGTH_SHORT).show()
                    val i = Intent(this@MenuFoodActivity,FoodDetailActivity::class.java)
                    i.putExtra("food",selectedItem.food)
                   i.putExtra("food_how",selectedItem.foodhow)
                    i.putExtra("food_mat",selectedItem.foodmat)
                    startActivity(i)
                }
            }
        })
   }
}