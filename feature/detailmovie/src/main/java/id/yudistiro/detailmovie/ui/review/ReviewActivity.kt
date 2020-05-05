package id.yudistiro.detailmovie.ui.review

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import id.yudistiro.common.util.Constanta
import id.yudistiro.detailmovie.R
import kotlinx.android.synthetic.main.activity_review.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReviewActivity : AppCompatActivity() {

    private val reviewViewModel: ReviewViewModel by viewModel()
    private val pageListReview = PageListReview()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        val id = intent.getIntExtra(Constanta.Key.ID,0)
        rv_review.apply {
            adapter = pageListReview
        }
        reviewViewModel.getReviewMovie(id.toString())
                .observe(this, Observer {
                    pageListReview.submitList(it)
                })
    }
}
