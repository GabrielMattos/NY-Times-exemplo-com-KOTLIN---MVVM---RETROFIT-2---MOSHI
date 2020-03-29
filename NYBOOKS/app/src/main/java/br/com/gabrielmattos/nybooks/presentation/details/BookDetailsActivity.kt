package br.com.gabrielmattos.nybooks.presentation.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.gabrielmattos.nybooks.R
import br.com.gabrielmattos.nybooks.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.include_toolbar.*

class BookDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        setupToolbar(toolbar_main_ID, R.string.books_title_Details, true)

        textView_bookDetailsTitle_ID.text = intent.getStringExtra(EXTRA_TITLE)
        textView_bookDetailsDescription_ID.text = intent.getStringExtra(EXTRA_DESCRIPTION)
    }

    companion object
    {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_TITLE"

        fun getStartIntent(context: Context, title:String, description:String) : Intent
        {
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}
