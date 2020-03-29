package presentation.books

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.gabrielmattos.nybooks.R
import br.com.gabrielmattos.nybooks.data.BooksResult
import br.com.gabrielmattos.nybooks.data.model.Book
import br.com.gabrielmattos.nybooks.data.repository.BooksRepository
import br.com.gabrielmattos.nybooks.presentation.books.BooksViewModel
import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class) //Forma de inicialização 1
class BooksViewModelTest
{
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var booksLiveDataObserver : Observer<List<Book>>

    @Mock
    private lateinit var viewFlipperLiveDataObserver : Observer<Pair<Int, Int?>>

    private lateinit var viewModel:BooksViewModel

    /*@Before //Forma de inicialização 2
    fun setup()
    {
        MockitoAnnotations.initMocks(this)
    }*/

    @Test
    fun `when view model getBooks get success then sets booksLiveData`()
    {
        //Arrange
        val books = listOf(
            Book("title 1", "author 1", "description 1")
        )
        val resultSuccess = MockRepository(BooksResult.Success(books))
        viewModel = BooksViewModel(resultSuccess)
        viewModel.booksLiveData.observeForever(booksLiveDataObserver)
        viewModel.viewFlipperLiveData.observeForever(viewFlipperLiveDataObserver)

        //Act
        viewModel.getBooks()

        //Assert
        verify(booksLiveDataObserver).onChanged(books)
        verify(viewFlipperLiveDataObserver).onChanged(Pair(1, null))
    }

    @Test
    fun `when view model getBooks get server error then sets viewFlipperLiveData`()
    {
        //Arrange
        val resultServerError = MockRepository(BooksResult.ServerError)
        viewModel = BooksViewModel(resultServerError)
        viewModel.viewFlipperLiveData.observeForever(viewFlipperLiveDataObserver)

        //Act
        viewModel.getBooks()

        //Assert
        verify(viewFlipperLiveDataObserver).onChanged(Pair(2, R.string.books_error_500_generic))
    }
}

class MockRepository(private val result:BooksResult) : BooksRepository
{
    override fun getBooks(booksResultCallback: (result: BooksResult) -> Unit)
     {
        booksResultCallback(result)
    }
}