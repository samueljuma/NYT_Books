package tk.paulmburu.nytbooks.repositories

import tk.paulmburu.nytbooks.database.BooksDao
import tk.paulmburu.nytbooks.models.Book
import tk.paulmburu.nytbooks.network.BooksApiService
import tk.paulmburu.nytbooks.network.asDatabaseBookModel
import tk.paulmburu.nytbooks.utils.ResultState
import tk.paulmburu.nytbooks.utils.Success
import tk.paulmburu.nytbooks.utils.executeNonBlocking

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
class BooksRepository(private val api: BooksApiService,private val booksDao: BooksDao) {

    suspend fun getAvailableBooks(): ResultState<List<Book>>{
        return executeNonBlocking {
            if (booksDao.loadAllBooks().isEmpty()){
                val response = api.getAvailableBooks()
                if (response.results.size == 0)
                    Success(emptyList<Book>())
                else{
                    val books = api.getAvailableBooks()
                    booksDao.insertBooks(books.asDatabaseBookModel())
                    Success(booksDao.loadAllBooks())
                }
            }else Success(booksDao.loadAllBooks())
        }
    }
}