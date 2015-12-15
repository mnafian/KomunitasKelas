##Komunitas Kelas

###Apa itu komunitas kelas?

Komunitas Kelas adalah aplikasi diskusi diluar KBM bagi guru dan siswa.

###Kegunaan utama?
Menghilangkan kesenjangan antara siswa dan guru untuk saling berkomunikasi lebih terbuka

###Apa kelebihannya?
Setiap pengguna bisa memberikan rating untuk setiap jawaban pada setiap pertanyaan yang diajukan di komunitas

###Penjelasan project

Project ini menggunakan framework milik mas Zelory bernama <a href="https://github.com/zetbaitsu/Benih/"> Benih</a> , dan sudah menerapkan
arsitektur android dengan skema 'android clean architecture' yang memisahkan antara Presentation layer, Domain Layer, dan Data Layer.
Untuk penjelasannya dapat dilihat di <a href="http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/"> sini </a>.

Apa yang sudah include di Benih? :

Dilihat dari build.gradle milik benih, sudah ada library yang biasa digunakan, jadi tidak perlu lagi menambah, library
yang sudah include yaitu :

```groovy
dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    compile 'com.android.support:appcompat-v7:23.0.0'
    compile 'com.squareup.retrofit:retrofit:1.9.0'
    compile 'com.android.support:recyclerview-v7:23.0.0'
    compile 'io.reactivex:rxandroid:1.0.1'
    compile 'com.jakewharton.rxbinding:rxbinding:0.1.0'
    compile 'com.trello:rxlifecycle:0.1.0'
    compile 'com.trello:rxlifecycle-components:0.1.0'
    compile 'com.android.support:design:23.0.0'
    compile 'com.android.support:cardview-v7:23.0.0'
    compile 'com.github.bumptech.glide:glide:3.6.1'
    compile 'com.android.support:support-v4:23.0.0'
    compile 'com.jakewharton:butterknife:7.0.1'
    compile 'com.jakewharton.timber:timber:3.1.0'
    compile 'com.squareup.sqlbrite:sqlbrite:0.2.1'
}
```

Susunan project adalah sebagai berikut :

|KomunitasKelas<br>
|-app<br>
|--build<br>
|--jni<br>
|--libs<br>
|--obj<br>
|--src<br>
|---androidTest<br>
|---main<br>
|----assets<br>
|----java<br>
|-----com.inagata.komunitaskelas<br>
|------controller<br>
|------data<br>
|-------api<br>
|-------database<br>
|-------model<br>
|------service<br>
|------ui<br>
|-----in.co.madhur.chatlib<br>
|----res<br>
|---test<br>
|-build<br>
|-gradle<br>

Untuk tampillan chat/message menggunakan chat starter milik madhur di <a href="https://github.com/madhur/android-chat-starter"> Sini </a>
Jadi memerlukan NDK untuk melakukan build. Pada project ini sudah menerapkan penggunaan functional programming dengan mengimplementasikan library android reactivex.

Untuk pertanyaan lebih lanjut silahkan contact saya di <a href="mailto:mnafian@icloud.com"> mnafian@icloud.com </a>.

License
-------
    Copyright (c) 2015 mnafian.
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

