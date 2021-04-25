# NYT_Books
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/85e54b270b1149478f21034d5a7ba28d)](https://app.codacy.com/manual/Paulmburu/NYT_Books?utm_source=github.com&utm_medium=referral&utm_content=Paulmburu/NYT_Books&utm_campaign=Badge_Grade_Dashboard)[![BCH compliance](https://bettercodehub.com/edge/badge/Paulmburu/NYT-Books?branch=master&token=3667afebba4d8f08f0f87d49af3fe9766b2de016)](https://bettercodehub.com/)

 An app that fetches [New York Times best sellers books](https://developer.nytimes.com/docs/books-product/1/routes/lists/best-sellers/history.json/get) while leveraging the power and simplicity of [Koin](https://doc.insert-koin.io/#/introduction) for dependency injection.
 
## Techstack 
* [Architecture][1] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [Data Binding][2] - Declaratively bind observable data to UI elements.
  * [Lifecycles][3] - Create a UI that automatically responds to lifecycle events.
  * [LiveData][4] - Build data objects that notify views when the underlying database changes.
  * [Room][5] - Access app's SQLite database with in-app objects and compile-time checks.
  * [ViewModel][6] - Store UI-related data that isn't destroyed on app rotations.
* Third party
  * [Koin][7] - A pragmatic lightweight dependency injection framework for Kotlin developers.
  * [MaterialComponents][12] -  interactive building blocks for creating a user interface (beautiful interfaces :ok_hand:).
  * [Retrofit][8] - A type-safe HTTP client for Android and Java
  * [Moshi][9] - A modern JSON library for Android and Java. It makes it easy to parse JSON into Java objects
  * [Kotlin Coroutines][10] for managing background threads with simplified code and reducing needs for callbacks
  *[Timber][11] logging Library

[1]: https://developer.android.com/jetpack/arch/
[2]: https://developer.android.com/topic/libraries/data-binding/
[3]: https://developer.android.com/topic/libraries/architecture/lifecycle
[4]: https://developer.android.com/topic/libraries/architecture/livedata
[5]: https://developer.android.com/topic/libraries/architecture/room
[6]: https://developer.android.com/topic/libraries/architecture/viewmodel
[7]: https://doc.insert-koin.io/#/introduction
[8]: https://square.github.io/retrofit/
[9]: https://github.com/square/moshi
[10]: https://kotlinlang.org/docs/reference/coroutines-overview.html
[11]: https://github.com/JakeWharton/timber
[12]: https://material.io/develop/android/docs/getting-started/

## Screenshots
<image src="screenshots/1.jpeg" height="500" width="250">[ ]<image src="art/app.gif" height="500" width="250">

## [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
```
   Copyright 2020 Paul Mburu

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   ```
