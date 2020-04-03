package th.ac.kku.cis.mobileapp.finalfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.loginform.*

class MainActivity_login : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    private val TAG: String = "Login Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginform)
        mAuth = FirebaseAuth.getInstance()
        if (mAuth!!.currentUser != null) {
            startActivity(Intent(this@MainActivity_login,MenuActivity::class.java))
            finish()
        }
        bot_login.setOnClickListener {
            val email = user.text.toString().trim {it <= ' '}
            val password = pass.text.toString().trim {it <= ' '}

            if (email.isEmpty()){
                Toast.makeText(this,"Please enter your email",Toast.LENGTH_LONG).show()
                Log.d(TAG, " Email was empty")
                return@setOnClickListener
            }
            if (password.isEmpty()){
                Toast.makeText(this,"Please enter your pass",Toast.LENGTH_LONG).show()
                Log.d(TAG, " pass was empty")
                return@setOnClickListener
            }
            mAuth!!.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if (!task.isSuccessful){
                    if (password.length < 6){
                    pass.error = "pls check your password. pass must have 6 characters."
                    Log.d(TAG, "enter password less than 6 characters.")
                } else {
                        Toast.makeText(this,"Authetication Failed: " + task.exception,Toast.LENGTH_LONG).show()
                    Log.d(TAG,"Authetication Failed: " + task.exception)
                }
                } else {
                    Toast.makeText(this,"login success ",Toast.LENGTH_LONG).show()
                    Log.d(TAG,"login success " )
                    startActivity(Intent(this@MainActivity_login, MenuActivity::class.java))
                }
            }
        }
        //bot_login.setOnClickListener { startActivity(Intent(this@MainActivity_login::class.java))}
    }
}
