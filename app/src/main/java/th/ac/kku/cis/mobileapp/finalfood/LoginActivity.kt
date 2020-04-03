package th.ac.kku.cis.mobileapp.finalfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    private val TAG: String = "Login Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()

        if (mAuth!!.currentUser != null) {
            startActivity(Intent(this@LoginActivity, AdminActivity::class.java))
            finish()
        }
        but_login.setOnClickListener {
            val email = email_txt.text.toString().trim{it <= ' '}
            val pass = pass_txt.text.toString().trim{it <= ' '}
            if(email.isEmpty()){
                Toast.makeText(this,"pls enter your email",Toast.LENGTH_LONG).show()
                Log.d(TAG,"email was empty")
                return@setOnClickListener
            }
            if(pass.isEmpty()){
                Toast.makeText(this,"pls enter your pasword",Toast.LENGTH_LONG).show()
                Log.d(TAG,"password was empty")
                return@setOnClickListener
            }

            mAuth!!.signInWithEmailAndPassword(email, pass).addOnCompleteListener{ task ->
                if(!task.isSuccessful){
                    if(pass.length < 6){
                        pass_txt.error = "your password must have 6 characters"
                    } else {
                        Toast.makeText(this,"authentication failed: " + task.exception,Toast.LENGTH_LONG).show()
                        Log.d(TAG, "authentication failed: " + task.exception)
                    }
                } else {
                    Toast.makeText(this,"login success",Toast.LENGTH_LONG).show()
                    Log.d(TAG, "login success")
                    startActivity(Intent(this@LoginActivity, AdminActivity::class.java))
                    finish()
                }
            }
        }

    }
}
