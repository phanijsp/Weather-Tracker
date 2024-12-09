**Android Take-Home Test: Weather Tracker**:


1. **Tech Stack**:
  - **Kotlin** and **Jetpack Compose** were used for the app, following modern Android development practices.
  - **MVVM architecture** was implemented to separate concerns and ensure modular, testable code.
  - **Dependency injection** was achieved using **Koin**, ensuring the app is scalable and testable.


2. **API Integration**:
  - **WeatherAPI.com** was integrated to fetch real-time weather data, including temperature, weather condition, humidity, UV index, and "feels like" temperature.
  -  **Error handling** was implemented for invalid city names, no network scenarios, and API errors, with appropriate messages displayed to the user.
  - **Retrofit** was used to interact with the WeatherAPI and fetch weather data asynchronously.


3. **Home Screen**:
  - The **Home Screen** displays weather details (city name, temperature, weather condition, humidity, UV index, and "feels like" temperature).
  - If no city is saved, the app prompts the user to search for a city.


4. **Search Behavior**:
  - A **search bar** was implemented for users to query a city, and a **search result card** displays the queried city's weather details.
  - Tapping the result updates the Home Screen with the city's weather and persists the selection for future use.

5. **Local Storage**:
  - **SharedPreferences** was used to persist the selected city across app launches, so the user doesn’t need to search again after closing the app.
  - The app reloads the weather data for the saved city when reopened.


6. **UI Design**:
  - The UI was built using **Jetpack Compose**, ensuring visual consistency with the provided **Figma designs** (with more than **95% accuracy**).
  - A responsive layout was created to work well on different screen sizes, maintaining a consistent user experience.


7. **Architecture & Code Quality**:
  - The code followed **MVVM architecture** for maintainability and separation of concerns.
  - The code is modular with clear separation between the **UI layer**, **ViewModel**, and **Repository** to promote ease of testing and scalability.



8. **Networking**:
  - Seamless integration with **WeatherAPI** was achieved to fetch live data.
  - **Retrofit** was used for API calls, with all requests and responses handled asynchronously to avoid blocking the main thread.


These steps ensured that all the requirements of the task were met, delivering a functional, user-friendly, and maintainable app.