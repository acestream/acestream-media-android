# Ace Stream Media

Ace Stream Media is a multifunctional multimedia Android application which is an aggregate consisting of two separate applications:

- [Ace Media Library](https://github.com/acestream/ace-media-library-android) (fork of VLC for Android™ licensed under GPLv3 or later)
- [Ace Stream Engine](https://github.com/acestream/acestream-engine-android) (licensed under MIT License)

# Architecture

This application is an aggregate of two applications: Ace Media Library and Ace Stream Engine. This means that both applications are designed in such way that they can be installed as separate APKs on the user's device and will work together. There is no strict dependency between applications: each application detects whether another one is installed and activates some features only when this is true.

We use such architecture to not violate GPL license under which Ace Media Library is released.
Ace Media Library is a fork of VLC for Android™ application (licensed under GPLv3 or later), so it also is licensed under GPLv3 or later. On the other hand Ace Stream Engine application (licensed under MIT license) cannot use GPL because it contains closed-source libraries. To avoid license violations we organized these two applications in an aggregate where each part runs in its own process and communication between processes is done via Android IPC mechanisms: intents and bound services.

This aggregate application combines two parts into one APK in order to create a single installation package which allows users to install both applications from one source. Inside this single APK both applications still run in a separate processes. This is achieved via "process" attribute in AndroidManifest.xml (the whole "Ace Media Library" application runs in ":media" process).

# Build

## Bootstrap

./bootstap.sh

This will download all necessary binary components

## Build LibVLC

cd ace-media-library-android
./compile.sh -a all -l -r
./compile-medialibrary.sh -a all
cd ..

## Build Android app

./build.sh