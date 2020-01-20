package android.rutheford.com.matchit.Activitys

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.rutheford.com.matchit.R
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    // declarations
    private val arrayListForImages: MutableList<Int> = mutableListOf(R.drawable.tigers,R.drawable.bears,R.drawable.giraffes,R.drawable.tigers,R.drawable.bears,R.drawable.giraffes,
        R.drawable.tigers,R.drawable.bears,R.drawable.giraffes,R.drawable.tigers,R.drawable.bears,R.drawable.giraffes)
    private val arrayListForStock: MutableList<Int> = mutableListOf(R.drawable.question,R.drawable.question,R.drawable.question,R.drawable.question,R.drawable.question,R.drawable.question,
        R.drawable.question,R.drawable.question,R.drawable.question,R.drawable.question,R.drawable.question,R.drawable.question)
    private var clicked = 0;
    private var lastClicked = 0;
    private var firstClicked = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_main_view)
        Main();
    }
    private fun Main() {
        arrayListForImages.shuffle()

        val matchingImageViewOne = findViewById<ImageView>(R.id.matchingImageViewOne)
        val matchingImageViewTwo = findViewById<ImageView>(R.id.matchingImageViewTwo)
        val matchingImageViewThree = findViewById<ImageView>(R.id.matchingImageViewThree)
        val matchingImageViewFour = findViewById<ImageView>(R.id.matchingImageViewFour)
        val matchingImageViewFive = findViewById<ImageView>(R.id.matchingImageViewFive)
        val matchingImageViewSix = findViewById<ImageView>(R.id.matchingImageViewSix)
        val matchingImageViewSeven = findViewById<ImageView>(R.id.matchingImageViewSeven)
        val matchingImageViewEight = findViewById<ImageView>(R.id.matchingImageViewEight)
        val matchingImageViewNine = findViewById<ImageView>(R.id.matchingImageViewNine)
        val matchingImageViewTen = findViewById<ImageView>(R.id.matchingImageViewTen)
        val matchingImageViewEleven = findViewById<ImageView>(R.id.matchingImageViewEleven)
        val matchingImageViewTwelve = findViewById<ImageView>(R.id.matchingImageViewTwelve)

        val images = arrayOf(
            matchingImageViewOne,
            matchingImageViewTwo,
            matchingImageViewThree,
            matchingImageViewFour,
            matchingImageViewFive,
            matchingImageViewSix,
            matchingImageViewSeven,
            matchingImageViewEight,
            matchingImageViewNine,
            matchingImageViewTen,
            matchingImageViewEleven,
            matchingImageViewTwelve
        )
        arrayListForImages.forEach {
            println(it)
        }
        for (i in 0..11) {
            images[i].setImageResource(arrayListForStock.get(i))
            println(images[i].tag)
            images[i].setOnClickListener {
                clicked++;
                if (clicked == 1) {
                    images[i].setImageResource(arrayListForImages.get(i))
                    firstClicked = i
                } else if (clicked == 2) {
                    lastClicked = i;
                    images[i].setImageResource(arrayListForImages.get(i))
                    if(arrayListForImages[firstClicked] == arrayListForImages[lastClicked]){
                        println("Match")
                        clicked = 0;
                        // alert that says its matched
                    }else{
                        println("No match")
                        clicked = 0;
                        alertForNonMatch(i,images,images[firstClicked],images[lastClicked],arrayListForStock,firstClicked,lastClicked)
                    }
                }
            }

            // main setup for method will go here.
        }
    }
    private fun alertForNonMatch(i: Int, images: Array<ImageView>, firstClickedImageView: ImageView,secondClickedImageView:ImageView, arrayListForStock: MutableList<Int>, firstClicked: Int,lastClicked: Int){
        val builder = AlertDialog.Builder(this@MainActivity)

        // Set the alert dialog title
        builder.setTitle("App background color")

        // Display a message on alert dialog
        builder.setMessage("Are you want to set the app background color to RED?")

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("OK"){dialog, which ->
            // Do something when user press the positive button
            Toast.makeText(applicationContext,"Ok, we change the app background.",Toast.LENGTH_SHORT).show()
            images[firstClicked].setImageResource(arrayListForStock.get(i))
            images[lastClicked].setImageResource(arrayListForStock.get(i))
            // Change the app background color
            //root_layout.setBackgroundColor(Color.RED)
        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }
}
