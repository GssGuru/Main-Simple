# Main Page
Simple main page with news feeds using fragments, dialogs, adapter, navigation menu

# About the aplication
 - MVP(Moxy)
 - REST(Retrofit2)
 - ButterKnife

# Preview
![](http://media.giphy.com/media/fHlMhMIIByBLImbAIv/giphy.gif) ![](http://media.giphy.com/media/1ipjUVgMqKEuWs6TuM/giphy.gif)

# Code
Description of the application code
<details><summary>Open</summary>
<p>

## Manifest
In the [`Manifest`](https://github.com/GssGuru/Main-Simple/blob/master/app/src/main/AndroidManifest.xml) add permission on the Internet and initialize MyApp.class. Read the comments in the code

## gradle
In the [`gradle`](https://github.com/GssGuru/Main-Simple/blob/master/app/build.gradle) add only dependencies on the Internet, ButterKnife , Moxy(MVP) and library for work with image. Read the comments in the code

## Aplication code
[`Aplication code`](https://github.com/GssGuru/Main-Simple/tree/master/app/src/main/java/guru/gss/mainsimple) - is the code with the mechanics of the application.
Carefully read the code comments.

To make our code more flexible we apply the MVP architectural pattern. Divide application into parts:
- model - here we will work with the business logic of the application
- ui - here we will work with the UI "View-Presenter"
- utils - here we will store our utilities
- MyApp.class - root class in the application. Used for various flexible solutions and getting the context and any place of application

пакет model. Divide package into parts:
- interactors - Here we will work with entities.
- repositories - here we work only with data. We take and place them in the database, internal storage or work with Internet requests

пакет ui. Divide package into parts:
- main - This package is called in accordance with the activation and in it are all the components necessary for the operation of this activit
- utils - our utilities that only work with UI elements
- BaseActivity.java - Activity from which we extends all our Activity. It is good to keep the methods involved in different Activity
- BaseFragment.java - Fragment from which we extends all our Fragments. It is good to keep the methods involved in different Fragments

пакет main. Divide package into parts:
- [`MainActivity`](https://github.com/GssGuru/Main-Simple/blob/master/app/src/main/java/guru/gss/mainsimple/ui/main/MainActivity.java) - 
The main activity. Here we manage fragments using the navigation menu.
- [`FragmentNews`](https://github.com/GssGuru/Main-Simple/blob/master/app/src/main/java/guru/gss/mainsimple/ui/main/fragment/FragmentNews.java) - Fragment showing a specific news feed
- [`PresenterFragment.java`](https://github.com/GssGuru/Main-Simple/blob/master/app/src/main/java/guru/gss/mainsimple/ui/main/fragment/PresenterFragment.java) - Element of the architectural pattern MVP. Binds business logic and view
- [`ViewFragment.java`](https://github.com/GssGuru/Main-Simple/blob/master/app/src/main/java/guru/gss/mainsimple/ui/main/fragment/ViewFragment.java) - Element of the architectural pattern MVP. Binds Presenter and UI
- [`AdapterNews`](https://github.com/GssGuru/Main-Simple/blob/master/app/src/main/java/guru/gss/mainsimple/ui/main/fragment/AdapterNews.java) - using it we work with a list
- [`DialigError`](https://github.com/GssGuru/Main-Simple/blob/master/app/src/main/java/guru/gss/mainsimple/ui/main/fragment/DialigError.java) - Dialog box to display error

## Resources code
[`Res folder.`](https://github.com/GssGuru/Main-Simple/tree/master/app/src/main/res) Change only Application Name

</p>
</details>
