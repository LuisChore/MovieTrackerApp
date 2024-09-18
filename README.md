# Movie Tracker App

## Overview

The **Movie Tracker App** is an Android project that fetches and displays a list of movies from The Movie Database (TMDb) API. Built using the **MVVM** architecture, this app follows **Clean Architecture** and **SOLID** principles to ensure maintainable and scalable code. I used this project to enhance my knowledge of Android development patterns and principles.

## Features

- **MVVM Architecture** with manual dependency injection.
- **Unidirectional Data Flow** using LiveData.
- Error handling with a `ResponseWrapper` class for managing Success, Error, and Loading states.
- **Glide** for efficient image loading and caching.
- Clean and responsive UI with **ConstraintLayout** and **ViewBinding**.

## Technologies

- **Retrofit** for API calls.
- **GSON** for JSON parsing.
- **Glide** for image loading.
- **ViewBinding** for safer UI interactions.

## Architecture Summary

- **Retrofit + MovieService**: Handles API requests.
- **Repository + DataSource**: Manages data flow.
- **ViewModel**: Connects UI and data.
- **RecyclerView + Adapter**: Displays movie lists with custom view holders.
- **Manual Dependency Injection**: No third-party libraries used; implemented via an application container.

## Getting Started

1. **TMDb API Key**: Sign up on [TMDb](https://www.themoviedb.org/) and get your API key.
2. Add the key to `strings.xml`:

   ```xml
   <string name="api_key">YOUR_API_KEY</string>
   ```

3. Run the app on an emulator or physical device.

## Screenshots

<!-- Insert your screenshots here -->

<img src="https://github.com/user-attachments/assets/33fa1e2e-d1a3-4175-8fcb-d1a02f463899" width="240">

<img src="https://github.com/user-attachments/assets/b623d68b-9956-47a9-a8e7-91ce4c907ee2" width="240">

<img src="https://github.com/user-attachments/assets/a3044916-87a6-4749-94a6-c313f7b38258" width="240">


## Key Learnings

- Implementing **Clean Architecture** and **SOLID** principles.
- Managing state with **LiveData** and **ResponseWrapper**.
- Manual **Dependency Injection** without libraries.
- Following **Unidirectional Data Flow** for better UI state management.

## Future Enhancements

- Unit testing and UI testing.
- Pagination for improved list handling.
- Using Hilt for dependency injection.

## Conclusion

This app reflects my commitment to best practices in Android development and is part of my portfolio to demonstrate my skills in creating clean, maintainable, and scalable apps.
