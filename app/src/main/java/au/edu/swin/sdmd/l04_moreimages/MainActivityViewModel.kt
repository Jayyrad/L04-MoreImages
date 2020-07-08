package au.edu.swin.sdmd.l04_moreimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

// In
class MainActivityViewModel : AppCompatActivity() {

    // This needs to be a class variable
    val viewModel: ImageModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.imageView)
        // Don't forget to update the UI with the current image!
        image.setImageDrawable(getDrawable(viewModel.getCurrentImage))
        image.contentDescription = viewModel.image

        val station = findViewById<Button>(R.id.station)
        station.setOnClickListener {
            // Update click listeners to use view model data
            viewModel.image = "station"
            image.setImageDrawable(getDrawable(viewModel.getCurrentImage))
            image.contentDescription = viewModel.image
        }

        val college = findViewById<Button>(R.id.college)
        college.setOnClickListener {
            viewModel.image = "college"
            image.setImageDrawable(getDrawable(viewModel.getCurrentImage))
            image.contentDescription = viewModel.image
        }

        val onClickTheatre = View.OnClickListener {
            viewModel.image = "theatre"
            image.setImageDrawable(getDrawable(viewModel.getCurrentImage))
            image.contentDescription = viewModel.image
        }

        val theatre = findViewById<Button>(R.id.theatre)
        theatre.setOnClickListener(onClickTheatre)


    }
}

/**
 * The view model itself: now contains the images
 */
class ImageModel: ViewModel() {
    var image: String = "station"

    val getCurrentImage: Int
        get() = when(image) {
            "station" -> R.drawable.station
            "college" -> R.drawable.college
            "theatre" -> R.drawable.theatre
            else -> R.drawable.station
        }

}