# Main Page
about

# About the aplication
 - Simple example client-server aplication
 - Work with restful api
 - Saving data to work offline

# Preview

![](http://media.giphy.com/media/fHlMhMIIByBLImbAIv/giphy.gif) ![](http://media.giphy.com/media/1ipjUVgMqKEuWs6TuM/giphy.gif)





# Solution
<details><summary>Open</summary>
<p>	
 

- create [`communication`](https://github.com/gamestudiostandart/Newspaper/tree/master/app/src/main/java/newspaper/gamestudiostandart/newspaper/repository/communication) to [`server with API`](https://newsapi.org/)
- create a [`database.`](https://github.com/gamestudiostandart/Newspaper/tree/master/app/src/main/java/newspaper/gamestudiostandart/newspaper/repository/database) where we will transfer data from the server
- create [`aplication.`](https://github.com/gamestudiostandart/Newspaper/tree/master/app/src/main/java/newspaper/gamestudiostandart/newspaper/aplication) It will work with UI

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
