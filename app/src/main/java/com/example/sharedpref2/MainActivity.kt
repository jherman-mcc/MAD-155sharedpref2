package com.example.sharedpref2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch



class MainActivity : AppCompatActivity() {

    val PREF_NAME = "perfs"
    val PREF_DARK_THEME = "dark_theme"
    val PREF_NAME2 = "perfs"
    val PREF_LIGHT_THEME = "light_theme"
    val PREF_NAME3 = "perfs"
    val PREF_COMPACT_THEME = "compact_theme"
    val PREF_NAME4 = "perfs"
    val PREF_SMALLTEXT_THEME = "small text"

    override fun onCreate(savedInstanceState: Bundle?) {

        val SP = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        val useDarkTheme = SP.getBoolean(PREF_DARK_THEME, false)
        if (useDarkTheme) {
            setTheme(R.style.ThemeOverlay_AppCompat_Dark)
        }
        val SP2 = getSharedPreferences(PREF_NAME2, MODE_PRIVATE)
        val useLightTheme = SP2.getBoolean(PREF_LIGHT_THEME, false)
        if (useLightTheme) {
            setTheme(R.style.ThemeOverlay_AppCompat_Light)
        }
        val SP3 = getSharedPreferences(PREF_NAME3, MODE_PRIVATE)
        val useCompactTheme = SP3.getBoolean(PREF_COMPACT_THEME, false)
        if (useCompactTheme) {
            setTheme(R.style.ThemeOverlay_AppCompat_Dialog)
        }
        val SP4 = getSharedPreferences(PREF_NAME4, MODE_PRIVATE)
        val useSmallTextTheme = SP4.getBoolean(PREF_SMALLTEXT_THEME, false)
        if (useSmallTextTheme) {
            setTheme(R.style.Base_CardView)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          val toggle = findViewById<Switch>(R.id.switch1)
          val toggle2 = findViewById<Switch>(R.id.switch2)
          val toggle3 = findViewById<Switch>(R.id.switch3)
          val toggle4 = findViewById<Switch>(R.id.switch4)

          toggle!!.isChecked =  useDarkTheme
          toggle2!!.isChecked = useLightTheme
          toggle3!!.isChecked = useCompactTheme
          toggle4!!.isChecked = useSmallTextTheme

          toggle.setOnCheckedChangeListener { view, isChecked ->
             toggleDarkTheme(isChecked)
           }

        toggle2.setOnCheckedChangeListener{ view, isChecked ->
            toggleLightTheme(isChecked)
        }

        toggle3.setOnCheckedChangeListener{ view, isChecked ->
            toggleCompactTheme(isChecked)
        }

        toggle4.setOnCheckedChangeListener{ view, isChecked ->
            toggleSmallTextTheme(isChecked)
        }

    }

    private fun toggleDarkTheme(darkTheme: Boolean) {
        val editorDark = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit()
        editorDark.apply {
            putBoolean(PREF_DARK_THEME, darkTheme)
            apply()
        }
        val intent = intent
        finish()
        startActivity(intent)
    }

    private fun toggleLightTheme(lightTheme: Boolean) {
        val editorLight = getSharedPreferences(PREF_NAME2, MODE_PRIVATE).edit()
        editorLight.apply {
            putBoolean(PREF_LIGHT_THEME, lightTheme)
            apply()
        }

        val intent2 = intent
        finish()
        startActivity(intent2)
    }

    private fun toggleCompactTheme(compactTheme: Boolean) {
        val editorCompact = getSharedPreferences(PREF_NAME3, MODE_PRIVATE).edit()
        editorCompact.apply {
            putBoolean(PREF_COMPACT_THEME, compactTheme)
            apply()
        }

        val intent3 = intent
        finish()
        startActivity(intent3)
    }

    private fun toggleSmallTextTheme(smallTextTheme: Boolean) {
        val editorSmallText = getSharedPreferences(PREF_NAME4, MODE_PRIVATE).edit()
        editorSmallText.apply {
            putBoolean(PREF_SMALLTEXT_THEME, smallTextTheme)
            apply()
        }

        val intent4 = intent
        finish()
        startActivity(intent4)
    }
}