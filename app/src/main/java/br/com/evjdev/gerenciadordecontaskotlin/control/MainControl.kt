package br.com.evjdev.gerenciadordecontaskotlin.control

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.evjdev.gerenciadordecontaskotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainControl {
    private val appCompatActivity: AppCompatActivity

    private lateinit var navView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    constructor(appCompatActivity: AppCompatActivity) {
        this.appCompatActivity = appCompatActivity

        initComponents()
    }

    private fun initComponents() {

        navView = appCompatActivity.findViewById(R.id.nav_view)
        navController = appCompatActivity.findNavController(R.id.nav_host_fragment)

        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.navigation_despesa, R.id.navigation_receita))


        appCompatActivity.setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


}