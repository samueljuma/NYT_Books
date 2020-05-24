package tk.paulmburu.nytbooks.network

import com.squareup.moshi.JsonClass
import tk.paulmburu.nytbooks.models.Book

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
@JsonClass(generateAdapter = true)
data class NetworkBook(
    val title: String,
    val author: String?,
    val description: String?
)

@JsonClass(generateAdapter = true)
data class NetworkBookContainer(
    val results: List<NetworkBook>
)

fun NetworkBookContainer.asDatabaseBookModel(): List<Book>{
    return results.map {
        Book(
            title = it.title,
            author = it.author,
            description = it.description
        )
    }
}


