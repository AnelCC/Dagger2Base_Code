# Using Dagger

### Using Dagger in your Android app - Kotlin

Dependency injection (DI) is a technique widely used in programming and well suited to Android development. By following the principles of DI, you lay the groundwork for a good app architecture.

Implementing dependency injection provides you with the following advantages:

* Reusability of code.
* Ease of refactoring.
* Ease of testing.

### Why Dagger 2 is Different?
If the application gets larger, we will start writing a lot of boilerplate code (e.g. with Factories) which can be error-prone. Doing this wrong can lead to subtle bugs and memory leaks in your app.

In the codelab, we will see how to use Dagger to automate this process and generate the same code you would have written by hand otherwise.

Dagger will be in charge of creating the application graph for us. We'll also use Dagger to perform field injection in our Activities instead of creating the dependencies by hand.

### Android
This repository contains simple COVID19 data monitoring by country. Develop in android over MVVM, Live Data, Kotlin, RxBinding, etc.

### Preview 🎉
The app consists of 4 different flows (implemented as Activities):

* Registration: The user can register by introducing username, password and accepting our terms and conditions.
* Login: The user can log in using the credentials introduced during the registration flow and can also unregister from the app.
* Home: The user is welcomed and can see how many unread notifications they have.
* Settings: The user can log out and refresh the number of unread notifications (which produces a random number of notifications).

The project follows a typical MVVM pattern where all the complexity of the View is deferred to a ViewModel. Take a moment to familiarize yourself with the structure of the project.


### Library References
1. Kotlin
2. Dagger 2


### Package Structure
```
com.anelcc.name    # Root Package
.
├── di                  # AppComponent.kt and define the interface
├── ?                   # ?
│
├── ?                   # ?
│   │── ?               # ?
│   └── ?               # ?
│
└── ?
```


### Library References

1. Kotlin [Read here](https://developer.android.com/kotlin/ktx)
0. Dependency injection in Android [Read here](https://developer.android.com/training/dependency-injection)
0. Manual Dependency Injection in Android [Read here](https://developer.android.com/training/dependency-injection/manual)
0. Dagger basics [Read here](https://developer.android.com/training/dependency-injection/dagger-basics)
0. Dagger 2 by google [Read here](https://docs.google.com/presentation/d/1fby5VeGU9CN8zjw4lAb2QPPsKRxx6mSwCe9q7ECNSJQ/pub?start=false&loop=false&delayms=3000&slide=id.p)
0. MVVM pattern [Read here](https://blog.mindorks.com/mvc-mvp-mvvm-architecture-in-android)
0. Latest available versions of Dagger [Read here](https://github.com/google/dagger/releases)