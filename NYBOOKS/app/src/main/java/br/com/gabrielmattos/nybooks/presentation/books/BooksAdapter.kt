package br.com.gabrielmattos.nybooks.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.gabrielmattos.nybooks.R
import br.com.gabrielmattos.nybooks.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(private val books:List<Book>, val onItemClickListener: ((book:Book) -> Unit)) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>()
{
    class BooksViewHolder(itemView:View, private val onItemClickListener: ((book:Book) -> Unit)) : RecyclerView.ViewHolder(itemView)
    {
        private val title = itemView.textview_title_ID
        private val author = itemView.textview_author_ID

        fun bindView(book:Book)
        {
            title.text = book.title
            author.text = book.author

            itemView.setOnClickListener {
                onItemClickListener.invoke(book)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): BooksViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(itemView, onItemClickListener)
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