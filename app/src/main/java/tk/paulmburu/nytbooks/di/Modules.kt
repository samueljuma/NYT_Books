package tk.paulmburu.nytbooks.di


import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tk.paulmburu.nytbooks.R
import tk.paulmburu.nytbooks.database.BooksDao
import tk.paulmburu.nytbooks.database.BooksDatabase
import tk.paulmburu.nytbooks.interactors.GetAvailableBooksUseCase
import tk.paulmburu.nytbooks.network.ApiClient
import tk.paulmburu.nytbooks.repositories.BooksRepository
import tk.paulmburu.nytbooks.ui.MainViewModel
import tk.paulmburu.nytbooks.utils.Constants

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

val network = module {
    single { ApiClient.provideMoshi() }
    single { ApiClient.provideOkHttpClient() }
    single { ApiClient.provideRetrofitInstance(okHttpClient = get(),moshi = get()) }
    single { ApiClient.provideMoviesApi(retrofit = get()) }
}

val data = module {
    fun provideBooksDao(database: BooksDatabase): BooksDao = database.booksDao()

    single {
        Room.databaseBuilder(
            androidContext(),
            BooksDatabase::class.java,
            Constants.APP_DATABASE_NAME
        ).build()
    }
    single { provideBooksDao(database = get()) }
    single { BooksRepository(api = get(),booksDao = get()) }
}

val viewModel = module {
    viewModel { MainViewModel(getAvailableBooksUseCase = get()) }
}

val domain = module {
    factory { GetAvailableBooksUseCase(booksRepository = get()) }
}

