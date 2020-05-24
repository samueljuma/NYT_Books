package tk.paulmburu.nytbooks

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.books_loading_animation.*
import kotlinx.android.synthetic.main.fragment_no_network.*
import tk.paulmburu.moviesreview.utils.ExceptionHandler
import tk.paulmburu.nytbooks.interactors.GetAvailableBooksUseCase
import tk.paulmburu.nytbooks.utils.*

/*   Created by Paul Mburu on 5/24/20.
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
open class BaseActivity<T>(): AppCompatActivity() {

    fun onNetworkChange(block: (Boolean) -> Unit) {
        NetworkUtils.getNetworkStatus(this)
            .observe(this, Observer { isConnected ->
                block(isConnected)
            })
    }

    fun handleState(result: ResultState<T>) {
        when (result) {
            is Error -> showOnError(ExceptionHandler(this).parse(result.e))
            is Success -> showOnSuccess(result)
            is Loading -> showLoading(true)
        }
    }

    open fun showLoading(isLoading: Boolean) {
        books_loading_anim.isVisible(isLoading)
        fragment_container.isVisible(false)
    }

    open fun showOnSuccess(result: Success<T>) {
        showLoading(false)
    }

    fun showOnError(message: String) {
        showLoading(false)
//        error_text_view.text = message
        fragment_container.isVisible(true)
    }
}