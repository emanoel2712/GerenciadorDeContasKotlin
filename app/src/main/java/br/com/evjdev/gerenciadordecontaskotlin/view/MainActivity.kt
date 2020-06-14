package br.com.evjdev.gerenciadordecontaskotlin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.evjdev.gerenciadordecontaskotlin.R
import br.com.evjdev.gerenciadordecontaskotlin.control.MainControl


class MainActivity : AppCompatActivity() {

    lateinit var control: MainControl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        control = MainControl(this)

    }

    

}
