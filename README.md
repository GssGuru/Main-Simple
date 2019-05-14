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
In the [`Manifest`](https://github.com/GssGuru/Login-Beginner/blob/master/app/src/main/AndroidManifest.xml) add permission on the Internet and initialize MyApp.class. Read the comments in the code

## gradle
In the [`gradle`](https://github.com/GssGuru/Login-Beginner/blob/master/app/build.gradle) add only dependencies on the Internet, ButterKnife , Moxy(MVP) and library for work with image. Read the comments in the code

## Aplication code
[`Aplication code`](https://github.com/GssGuru/Login-Beginner/tree/master/app/src/main/java/guru/gss/loginbeginner) - is the code with the mechanics of the application.
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
- main
- utils
- BaseActivity.java
- BaseFragment.java

## Resources code
[`Res folder.`](https://github.com/GssGuru/Login-Beginner/tree/master/app/src/main/res) Change only Application Name

</p>
</details>
