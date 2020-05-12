package com.ebookfrenzy.restaurantpos

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.combo_menu.*
import kotlinx.android.synthetic.main.main_menu.*
import androidx.databinding.DataBindingUtil
import com.ebookfrenzy.restaurantpos.databinding.*
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {

    var selectedItems = mutableListOf<Int>()
    var itemIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setMain(this)
    }

    private fun getSelectedView(layout: LinearLayout, textView: TextView) {
        itemIndex = layout.indexOfChild(textView)
        if (selectedItems.contains(itemIndex)) {
            selectedItems.remove(itemIndex)
            textView.setTextColor(Color.GRAY)
        } else {
            selectedItems.add(itemIndex)
            textView.setTextColor(Color.RED)
        }
    }

    fun goToCombos(){
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.menu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:ComboMenuBinding = DataBindingUtil.inflate(inflater, R.layout.combo_menu, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun goToKidsMeals(){
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.menu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:KidsmealMenuBinding = DataBindingUtil.inflate(inflater, R.layout.kidsmeal_menu, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun goToSides(){
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.menu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:SidesMenuBinding = DataBindingUtil.inflate(inflater, R.layout.sides_menu, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun goToDrinks(){
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.menu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:DrinksMenuBinding = DataBindingUtil.inflate(inflater, R.layout.drinks_menu, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun goToShakes(){
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.menu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:ShakesMenuBinding = DataBindingUtil.inflate(inflater, R.layout.shakes_menu, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun goToSlushes(){
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.menu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:SlushesBinding = DataBindingUtil.inflate(inflater, R.layout.slushes, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun homeFromCombos() {
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.combomenu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:MainMenuBinding = DataBindingUtil.inflate(inflater, R.layout.main_menu, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun homeFromKidsMeals(){
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.kidsmenu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:MainMenuBinding = DataBindingUtil.inflate(inflater, R.layout.main_menu, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun homeFromSides() {
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.sidesmenu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:MainMenuBinding = DataBindingUtil.inflate(inflater, R.layout.main_menu, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun homeFromShakes() {
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.shakesmenu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:MainMenuBinding = DataBindingUtil.inflate(inflater, R.layout.main_menu, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun homeFromDrinks(){
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.drinksmenu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:MainMenuBinding = DataBindingUtil.inflate(inflater, R.layout.main_menu, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun homeFromSlushes() {
        val parent = findViewById<LinearLayout>(R.id.main)
        val item = findViewById<LinearLayout>(R.id.slushmenu)
        parent.removeView(item)
        val inflater = layoutInflater
        val binding:MainMenuBinding = DataBindingUtil.inflate(inflater, R.layout.main_menu, parent, true)
        binding.main = this@MainActivity
        binding.root
    }

    fun addItem(name: String, price: String) {
        val nameOfItem = TextView(this)
        val priceOfItem = TextView(this)
        nameOfItem.textSize = 25f
        priceOfItem.textSize = 25f
        nameOfItem.text = name
        priceOfItem.text = price
        priceOfItem.gravity = Gravity.END
        nameOfItem.setTextColor(Color.GRAY)
        priceOfItem.setTextColor(Color.GRAY)

        itemName.addView(nameOfItem)
        itemPrice.addView(priceOfItem)
        nameOfItem.setOnClickListener {
            getSelectedView(itemName, nameOfItem)
        }
    }

    fun deleteItem(view: View) {
        Log.i("Selected Items", selectedItems.toString())
        for (i in selectedItems.sortedDescending()) {
            try {
                itemName.removeViewAt(i)
                itemPrice.removeViewAt(i)
            } catch (e: NullPointerException) {
                print("Nothing")
            }
        }
        selectedItems.removeAll(selectedItems)
    }


}
