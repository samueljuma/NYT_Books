package tk.paulmburu.nytbooks.ui

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tk.paulmburu.nytbooks.interactors.GetAvailableBooksUseCase
import tk.paulmburu.nytbooks.models.Book
import tk.paulmburu.nytbooks.utils.Loading
import tk.paulmburu.nytbooks.utils.ResultState

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
class MainViewModel(private val getAvailableBooksUseCase: GetAvailableBooksUseCase): ViewModel() {
    private val _books = MutableLiveData<ResultState<List<Book>>>()
    val books: LiveData<ResultState<List<Book>>>
        get() = _books


    init {
        getAvailableBooks()
    }

    fun getAvailableBooks(){
        _books.value = Loading<List<Book>>()
        viewModelScope.launch(Dispatchers.IO) {
            _books.postValue(getAvailableBooksUseCase.invoke())
        }
    }

}