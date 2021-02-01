package tk.paulmburu.nytbooks.ui.main

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tk.paulmburu.nytbooks.interactors.GetAvailableBooksUseCase
import tk.paulmburu.nytbooks.interactors.GetAvailableThemesUseCase
import tk.paulmburu.nytbooks.interactors.GetThemeUseCase
import tk.paulmburu.nytbooks.interactors.SetThemeUseCase
import tk.paulmburu.nytbooks.models.Book
import tk.paulmburu.nytbooks.models.Theme
import tk.paulmburu.nytbooks.utils.Loading
import tk.paulmburu.nytbooks.utils.Result
import tk.paulmburu.nytbooks.utils.ResultState
import tk.paulmburu.nytbooks.utils.Success

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
class MainViewModel(
    private val getAvailableBooksUseCase: GetAvailableBooksUseCase,
                    getAvailableThemesUseCase: GetAvailableThemesUseCase,
                    getThemeUseCase: GetThemeUseCase,
                    val setThemeUseCase: SetThemeUseCase
): ViewModel() {
    private val _books = MutableLiveData<ResultState<List<Book>>>()
    val books: LiveData<ResultState<List<Book>>>
        get() = _books


//    init {
//        getAvailableBooks()
//    }

    fun getAvailableBooks(){
        _books.value = Loading<List<Book>>()
        viewModelScope.launch(Dispatchers.IO) {
            _books.postValue(getAvailableBooksUseCase.invoke())
        }
    }

    // Theme setting
    private val themeResult = MutableLiveData<Result<Theme>>()
    val theme: LiveData<Theme>

    // Theme setting
    private val availableThemesResult = MutableLiveData<Result<List<Theme>>>()
    val availableThemes: LiveData<List<Theme>>

    init {
        getAvailableBooks()

        getAvailableThemesUseCase(Unit, availableThemesResult)
        availableThemes = availableThemesResult.map {
            (it as? Success<List<Theme>>)?.data ?: emptyList()
        }

        getThemeUseCase(Unit, themeResult)
        theme = themeResult.map {
            (it as? Success<Theme>)?.data ?: Theme.SYSTEM
        }

        Log.d("MainViewModel","${availableThemesResult.value.toString()}")

    }

    fun setTheme(theme: Theme) {
        setThemeUseCase(theme)
    }

}