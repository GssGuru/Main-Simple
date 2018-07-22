# Google Play
[`My newspapers`](http://play.google.com/store/apps/details?id=newspaper.gamestudiostandart.newspaper)


# About the aplication
 - Simple example client-server aplication
 - Work with restful api
 - Saving data to work offline


# Solution
<details><summary>Open</summary>
<p>	
 

- create [`communication`](https://github.com/gamestudiostandart/Newspaper/tree/master/app/src/main/java/newspaper/gamestudiostandart/newspaper/repository/communication) to [`server with API`](https://newsapi.org/)
- create a database [`database.`](https://github.com/gamestudiostandart/Newspaper/tree/master/app/src/main/java/newspaper/gamestudiostandart/newspaper/repository/database) where we will transfer data from the server
- create [`aplication.`](https://github.com/gamestudiostandart/Newspaper/tree/master/app/src/main/java/newspaper/gamestudiostandart/newspaper/aplication) It will work with the database and display it on the UI

</p>
</details>


# Manifest
<details><summary>Open</summary>
<p>

[`Manifest`](https://github.com/gamestudiostandart/Newspaper/blob/master/app/src/main/AndroidManifest.xml)

## Permissions
+ internet

## Aplication
+ activity - MainActivity
+ activity - SearchActivity

</p>
</details>


# build.gradle dependencies
<details><summary>Open</summary>
<p>

[`build.gradle`](https://github.com/gamestudiostandart/Newspaper/blob/master/app/build.gradle)
+ compileSdkVersion 27
+ minSdkVersion 21
+ targetSdkVersion 27

## Standard UI librarys
+ implementation fileTree(include: ['*.jar'], dir: 'libs')
+ implementation 'com.android.support:appcompat-v7:27.1.1'
+ implementation 'com.android.support:design:27.1.1'
+ implementation 'com.android.support:cardview-v7:27.1.1'
+ implementation 'com.android.support:recyclerview-v7:27.1.1'
+ implementation 'com.android.support:support-v4:27.1.1'

## Moxy(MVP)
+ implementation 'com.arello-mobile:moxy:1.5.3'
+ implementation 'com.arello-mobile:moxy-android:1.5.3'
+ implementation 'com.arello-mobile:moxy-app-compat:1.5.3'
+ annotationProcessor 'com.arello-mobile:moxy-compiler:1.5.3'

## Retofit
+ implementation 'com.squareup.retrofit2:retrofit:2.3.0'
+ implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
+ implementation 'com.squareup.okhttp3:logging-interceptor:3.10.0'

## Glide
+ implementation 'com.github.bumptech.glide:glide:3.8.0'

## Third-party libraries for working with UI
+ implementation 'me.everything:overscroll-decor-android:1.0.4'
+ implementation 'com.baoyz.pullrefreshlayout:library:1.2.0'

</p>
</details>


# Code architecture
<details><summary>Open</summary>
<p>

## Root
```diff
`Festivality/app/src/main/java/test/mb/festivality/`
```
The [`root`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality) of our project is divided into 3 packages and 1 file

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`aplication`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication) -  that package works with the UI
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`repository`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository) - that package works with the ([server](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication), or data from [database](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/database)
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`utils`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils) - Package with class models, converters, parsers ...
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`MyApp.java`](https://github.com/gamestudiostandart/Festivality/blob/master/app/src/main/java/test/mb/festivality/MyApp.java) - The main class in the program that distributes the context


## MyApp.java
```diff
Festivality/app/src/main/java/test/mb/festivality/MyApp.java
```
[`MyApp.java`](https://github.com/gamestudiostandart/Festivality/blob/master/app/src/main/java/test/mb/festivality/MyApp.java) The main class in the program. They are referring to him in context [repository](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository) and [`utils`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils)

## utils
```diff
Festivality/app/src/main/java/test/mb/festivality/utils/
```
[`utils`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils) - auxiliary files package

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`fragmentanimator`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/fragmentanimator) - The package works with animation of fragments
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`models`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/models) - This package contains models of user classes
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`parser`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/parser) - pass the result from the server to the objects
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`views`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/utils/views) - packet with rewritten UI elements


## repository
```diff
Festivality/app/src/main/java/test/mb/festivality/repository/
```
[`repository`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository) works with the ([server](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication), or data from [database](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/database)
is divided into 3 packages

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`communication`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication) - this package is working with the server
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`database`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/database) - this package is working with the database
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`SharedPreferencesManager.java`](https://github.com/gamestudiostandart/Festivality/blob/master/app/src/main/java/test/mb/festivality/repository/SharedPreferencesManager.java) - the file is responsible for skipping the Login page when re-using the program

### communication
```diff
Festivality/app/src/main/java/test/mb/festivality/repository/communication/
```
[`communication`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication) package working with the server
communication is divided into 3 packages
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`retrofit`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication/retrofit) - A tool for facilitating server requests
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`userlist`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication/userlist) - package with implementation of the [method user-list](https://api.festivality.co/v2/user-list/44779) 
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`services`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/repository/communication/services) - This service we run in a Backgraund


## aplication
```diff
Festivality/app/src/main/java/test/mb/festivality/aplication/
```
[`aplication`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication) is a package that works purely with the interface and it is divided into 3 packages. By package to page. Each package contains the files that the hlm needs to reproduce the responsive mechanics.

- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`userpage`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication/userpage) - user details page
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`login`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication/login) - login page
- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) [`main`](https://github.com/gamestudiostandart/Festivality/tree/master/app/src/main/java/test/mb/festivality/aplication/main) - List of pages and user sorting

</p>
</details>


# Preview
# Screen Capture

![](https://media.giphy.com/media/yuQvSAdfVbNUiPJZBl/giphy.gif) ![](http://media.giphy.com/media/YWWgtGkP2KWVlsTpfr/giphy.gif)

Two libraries for refresh Bounce and Bounce on list news efect

![](http://media.giphy.com/media/kERJqKjDrnxTjaH83y/giphy.gif) ![](http://media.giphy.com/media/lffWSl65jOQyRPKuta/giphy.gif)

