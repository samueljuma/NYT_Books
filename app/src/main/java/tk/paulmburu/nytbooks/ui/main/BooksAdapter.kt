package tk.paulmburu.nytbooks.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import tk.paulmburu.nytbooks.R
import tk.paulmburu.nytbooks.databinding.ItemBookBinding
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
class BooksAdapter(val onClickListener: OnClickListener) :  RecyclerView.Adapter<BooksViewHolder>() {


    var books: List<Book> = emptyList()
        set(value) {
            field = value
            // For an extra challenge, update this to use the paging library.

            // Notify any registered observers that the data set has changed. This will cause every
            // element in our RecyclerView to be invalidated.
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val withDataBinding: ItemBookBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            BooksViewHolder.LAYOUT,
            parent,
            false)
        return BooksViewHolder(withDataBinding)
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {

        holder.viewDataBinding.also {
            it.book = books.get(position)
            it.clicklistener = onClickListener
        }
    }
}

class BooksViewHolder(val viewDataBinding: ItemBookBinding): RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.item_book
    }
}

