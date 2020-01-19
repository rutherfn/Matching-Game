package android.rutheford.com.matchit.Activitys

import android.content.SharedPreferences
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.rutheford.com.matchit.Helpers.SwipeLockableViewPager
import android.rutheford.com.matchit.R
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    // declarations
    private val arrayListForImages: MutableList<Int> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_main_view)
        Main();
    }
    private fun Main(){;
        val cnsLayout = findViewById<ConstraintLayout>(R.id.cnsLayout)
        val matchingImageViewOne = findViewById<ImageView>(R.id.matchingImageViewOne)
        val matchingImageViewTwo = findViewById<ImageView>(R.id.matchingImageViewTwo)
        val matchingImageViewThree = findViewById<ImageView>(R.id.matchingImageViewThree)
        addToArrayListTest()
        matchingImageViewOne.setImageResource(arrayListForImages[0])
        matchingImageViewTwo.setImageResource(arrayListForImages[1])
        matchingImageViewThree.setImageResource(arrayListForImages[2])
        // main setup for method will go here.
    }
    private fun addToArrayListTest(){
        arrayListForImages.add(R.drawable.tigers)
        arrayListForImages.add(R.drawable.bears)
        arrayListForImages.add(R.drawable.giraffes)
    }
    private fun setUpIds(){
       // viewPager = fin
       // viewPager = findViewById(R.id.viewPager) as ViewPager;
    }
}
