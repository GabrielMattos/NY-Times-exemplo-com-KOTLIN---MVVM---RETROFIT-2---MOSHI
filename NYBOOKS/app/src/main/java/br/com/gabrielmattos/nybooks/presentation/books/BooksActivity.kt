package br.com.gabrielmattos.nybooks.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.gabrielmattos.nybooks.R
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        toolbar_main_ID.title = "Books"
        setSupportActionBar(toolbar_main_ID)
    }
}
