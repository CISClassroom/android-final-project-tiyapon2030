package th.ac.kku.cis.mobileapp.finalfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add.*
import th.ac.kku.cis.mobileapp.finalfood.Model.actfood

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        add_food.setOnClickListener {
            saveData()
        }
    }


    private fun saveData(){

        val foonam   = add_name.text.toString().trim()
        val foomat = add_mat.text.toString().trim()
        val foohow = add_how.text.toString().trim()


        if (foonam.isEmpty()){
            Toast.makeText(this,"กรุณากรอกข้อมูล ชื่อเมนู",Toast.LENGTH_LONG).show()
            return
        }
        if (foomat.isEmpty()){
            Toast.makeText(this,"กรุณากรอกข้อมูล วัถุดิบ",Toast.LENGTH_LONG).show()
            return
        }
        if (foohow.isEmpty()){
            Toast.makeText(this,"กรุณากรอกข้อมูล วิธีทำ",Toast.LENGTH_LONG).show()
            return
        }

        val myDataBase = FirebaseDatabase.getInstance().getReference("fooddata")
        val id = foonam
        val student = actfood(foomat,foohow)

        myDataBase.child(id).setValue(student).addOnCompleteListener{
            Toast.makeText(this,"บันทึกเรียบร้อย :) ",Toast.LENGTH_LONG).show()
        }
    }

}

