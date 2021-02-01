package tk.paulmburu.nytbooks.interactors

import androidx.core.os.BuildCompat
import tk.paulmburu.nytbooks.models.Theme
import tk.paulmburu.nytbooks.models.themeFromStorageKey
import tk.paulmburu.nytbooks.storage.Storage
import tk.paulmburu.nytbooks.utils.UseCase

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

open class GetThemeUseCase(
    private val preferenceStorage: Storage
) : UseCase<Unit, Theme>() {

    override fun execute(parameters: Unit): Theme {
        preferenceStorage.selectedTheme()?.let { key ->
            return themeFromStorageKey(key)
        }
        // If we get here, we don't currently have a theme set, so we need to provide a default
        return when {
            BuildCompat.isAtLeastQ() -> Theme.SYSTEM
            else -> Theme.BATTERY_SAVER
        }
    }
}