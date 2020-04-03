package th.ac.kku.cis.mobileapp.finalfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null
    private  val TAG:String = "Admin Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        go_to_add.setOnClickListener{ startActivity(Intent(this@AdminActivity, AddActivity::class.java))}
        mAuth = FirebaseAuth.getInstance()

        val admin = mAuth!!.currentUser

        show_email.text = admin!!.email
        show_uid.text = admin.uid

        mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val admins = firebaseAuth.currentUser
            if (admins == null) {
                startActivity(Intent(this@AdminActivity, LoginActivity::class.java))
                finish()
            }
        }
        but_logout.setOnClickListener{
            mAuth!!.signOut()
            Toast.makeText(this,"LOGOUT success", Toast.LENGTH_LONG).show()
            Log.d(TAG, "LOGOUT!!!")
            startActivity(Intent(this@AdminActivity,MainActivity::class.java))
            finish()
        }

    }
    override fun onStart(){
        super.onStart()
        mAuth!!.addAuthStateListener { mAuthListener }
    }

    override fun onStop(){
        super.onStop()
        if(mAuthListener != null){mAuth!!.removeAuthStateListener { mAuthListener }}
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){moveTaskToBack( true)}
        return super.onKeyDown(keyCode, event)
    }
}
