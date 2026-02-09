package com.edadursun.warningmessages

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.edadursun.warningmessages.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //CONTEXT:Android işletim sisteminde tüm uygulama içinde nerede ne oluyor takip edebilmek için oluşturulmuş yapı
        //Activity Context:Activity çalıştığında oluşan durumlar this kullanılır
        //Application Context:Tüm uygulamalar ile ilgili durumlar

        //TOAST
        Toast.makeText(this@MainActivity,"Toast Message",Toast.LENGTH_SHORT).show()

        //ALERT DIALOG
        val alert=AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Alert Title")
        alert.setMessage("Message")
        alert.setPositiveButton("Yes", object:DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(this@MainActivity,"Saved",Toast.LENGTH_SHORT).show()
            }
        })
        alert.setNegativeButton("No"){dialog,which ->
            Toast.makeText(this,"Not saved",Toast.LENGTH_SHORT).show()
        }
        alert.show()


        //SNACKBAR
        Snackbar.make(binding.root,"Snackkbar",Snackbar.LENGTH_SHORT).show()

    }
}