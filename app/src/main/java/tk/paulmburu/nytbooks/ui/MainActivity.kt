package tk.paulmburu.nytbooks.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel
import tk.paulmburu.nytbooks.BaseActivity
import tk.paulmburu.nytbooks.R
import tk.paulmburu.nytbooks.models.Book
import tk.paulmburu.nytbooks.utils.Success

/*   Created by Paul Mburu on 5/23/20.
 *
 *   Copyright 2020 Paul Mburu
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
class MainActivity : BaseActivity<List<Book>>() {

    private val viewModel: MainViewModel by viewModel()

    private var viewModelAdapter: BooksAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeNetworkChanges()

        viewModelAdapter = BooksAdapter(OnClickListener {
            Log.d("Book Clicked","${it}")
        })

        findViewById<RecyclerView>(R.id.recyclerViewBooks).apply {
            adapter = viewModelAdapter
        }
    }



    private fun observeNetworkChanges() {
        onNetworkChange { isConnected ->
            if (isConnected && viewModel.books.value is Error)
                viewModel.getAvailableBooks()
        }
    }

    override fun onResume() {
        super.onResume()
        observeBooks()
    }

    private fun observeBooks() {
        viewModel.books.observe(this, Observer {
            handleState(it)
        })
    }

    override fun showLoading(isLoading: Boolean) {
        super.showLoading(isLoading)
    }

    override fun showOnSuccess(result: Success<List<Book>>) {
        super.showOnSuccess(result)
        val availableMovies = result.data
        viewModelAdapter?.books = availableMovies
    }
}

//    Create an OnClickListener class with a lambda in its constructor that initializes a matching onClick function
class OnClickListener(val clickListener: (book: Book) -> Unit) {
    fun onClick(book: Book) = clickListener(book)
}