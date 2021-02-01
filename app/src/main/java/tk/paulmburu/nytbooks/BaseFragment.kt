package tk.paulmburu.nytbooks

import androidx.appcompat.app.AppCompatDialogFragment
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.compat.ScopeCompat.getViewModel
import tk.paulmburu.nytbooks.ui.themeSettings.ThemeSettingsViewModel
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

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
//open class BaseFragment<M : ViewModel> : AppCompatDialogFragment() {
//    val viewModel: M by lazy { getViewModel(ThemeSettingsViewModel::class.java) }
//
//    @Suppress("UNCHECKED_CAST")
//    private fun viewModelClass(): KClass<M> {
//        // dirty hack to get generic type https://stackoverflow.com/a/1901275/719212
//        return ((javaClass.genericSuperclass as ParameterizedType)
//            .actualTypeArguments[0] as Class<M>).kotlin
//    }
//}