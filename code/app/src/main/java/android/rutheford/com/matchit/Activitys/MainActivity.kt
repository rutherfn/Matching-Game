package android.rutheford.com.matchit.Activitys

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.rutheford.com.matchit.R
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.home_main_view.*

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
        funcForMain();
    }
    private fun funcForMain() {
        arrayListForImages.shuffle()
        funcForMatchingImages()
        funcForReset()
        // set up images
    }
    private fun alertForNonMatch(i: Int, images: Array<ImageView>, arrayListForStock: MutableList<Int>, firstClicked: Int,lastClicked: Int){
        val builder = AlertDialog.Builder(this@MainActivity)

        // Set the alert dialog title
        builder.setTitle("Did Not Find A Match")

        // Display a message on alert dialog
        builder.setMessage("Sorry no match, press OK to continue ")

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("OK"){dialog, which ->
            images[firstClicked].setImageResource(arrayListForStock.get(i))
            images[lastClicked].setImageResource(arrayListForStock.get(i))
        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }
    private fun alertForWinner(){
        val builder = AlertDialog.Builder(this@MainActivity)

        // Set the alert dialog title
        builder.setTitle("Congrats You Won")

        // Display a message on alert dialog
        builder.setMessage("You found all the matches! Press OK to continue! ")

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("OK"){dialog, which ->
            resetGame()
        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }
    private fun resetImageToUnknown(imageView: ImageView){
        imageView.setImageResource(R.drawable.question)
    }
    private fun funcForMatchingImages(){ // setting up array list for images
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
        for (i in 0..11) { // logic for matching items.
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
                        clicked = 0;
                        // alert that says its matched
                    }else{
                        println("No match")
                        clicked = 0;
                        alertForNonMatch(i,images,arrayListForStock,firstClicked,lastClicked)
                    }
                }
            }
        }
    }
    private fun resetGame(){ // reset game func
        arrayListForImages.shuffle()
        resetImageToUnknown(matchingImageViewOne)
        resetImageToUnknown(matchingImageViewTwo)
        resetImageToUnknown(matchingImageViewThree)
        resetImageToUnknown(matchingImageViewFour)
        resetImageToUnknown(matchingImageViewFive)
        resetImageToUnknown(matchingImageViewSix)
        resetImageToUnknown(matchingImageViewSeven)
        resetImageToUnknown(matchingImageViewEight)
        resetImageToUnknown(matchingImageViewNine)
        resetImageToUnknown(matchingImageViewTen)
        resetImageToUnknown(matchingImageViewEleven)
        resetImageToUnknown(matchingImageViewTwelve)
    }
    private fun funcForReset(){
        buttonReset.setOnClickListener(){
            resetGame()
        }
    }
}
