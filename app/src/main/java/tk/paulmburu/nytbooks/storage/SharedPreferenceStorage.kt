package tk.paulmburu.nytbooks.storage

import android.content.Context
import tk.paulmburu.nytbooks.models.Theme

/*   Created by Paul Mburu on 5/26/20.
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
class SharedPreferencesStorage(context: Context) : Storage {

    private val sharedPreferences = context.getSharedPreferences("ThemePrefs", Context.MODE_PRIVATE)

    override fun setTheme(key: String, value: String) {
        with(sharedPreferences.edit()){
            putString(key,value)
            apply()
        }
    }

    override fun selectedTheme(): String {
        return sharedPreferences.getString("pref_dark_mode", Theme.SYSTEM.storageKey)!!
    }
}