package br.com.gabrielmattos.nybooks.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrielmattos.nybooks.R
import br.com.gabrielmattos.nybooks.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(private val books:List<Book>) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>()
{
    class BooksViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    {
        private val title = itemView.textview_title_ID
        private val author = itemView.textview_author_ID

        fun bindView(book:Book)
        {
            title.text = book.title
            author.text = book.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): BooksViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(itemView)
    }

    override fun getItemCount(): Int
    {
        return books.count()
    }

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int)
    {
        viewHolder.bindView(books[position])
    }
}