package br.com.gabrielmattos.nybooks.data.repository

import br.com.gabrielmattos.nybooks.data.BooksResult

interface BooksRepository
{
    fun getBooks(booksResultCallback: (result: BooksResult) -> Unit)
    {

    }
}