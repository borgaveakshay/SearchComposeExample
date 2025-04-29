# AchmeaAssignment - Android App

This is an Android application built using Kotlin, Jetpack Compose, Hilt, and other modern Android development practices.

## Overview

This application allows users to search for employers. It's built with a focus on clean architecture, testability, and maintainability.

## Key Features

*   **Employer Search:** Users can search for employers using a text-based search query.
*   **Clean Architecture:** The app follows the principles of Clean Architecture to ensure separation of concerns.
*   **Dependency Injection:** Hilt is used for dependency injection, making the code more modular and testable.
*   **Jetpack Compose:** The UI is built using Jetpack Compose, a modern declarative UI toolkit.
*   **State Management:** Uses `StateFlow` for managing the UI state.
*   **Kotlin Coroutines:** Asynchronous operations are handled using Kotlin Coroutines and Flow.
*   **Error Handling:** Robust error handling for network and other potential issues.

## Architecture

The app follows a Clean Architecture approach, which divides the app into distinct layers with well-defined responsibilities. This allows for greater flexibility, maintainability, and testability.

### Layers

1.  **Presentation Layer (`presentation`)**

    *   **Responsibility:** Handles UI logic, interacts with the user, and displays data.
    *   **Components:**
        *   **Composables:** UI elements built using Jetpack Compose.
        *   **ViewModels:** Hold UI state and interact with the `Domain Layer`.
        *   **States:** Data models that represent UI state.
        * **Navigation:** Handle the navigation between composables.
    *   **Frameworks:** Jetpack Compose, Hilt (for ViewModel injection), `StateFlow`.
    *   **Interaction:** `ViewModels` observe `StateFlow` from `UseCases` and update UI state accordingly.
    *   **Dependencies:** Depends on the `Domain Layer`.
2.  **Domain Layer (`domain`)**

    *   **Responsibility:** Contains the core business logic and application rules.
    *   **Components:**
        *   **Entities:** Business objects that represent data.
        *   **Use Cases:** Define actions that users can perform. They interact with `Repositories`.
        *   **Repository Interfaces:** Contracts for data access.
    *   **Frameworks:** None. It is pure Kotlin.
    *   **Interaction:** `Use Cases` call methods on `Repository` interfaces to interact with the `Data Layer`.
    *   **Dependencies:** Does not depend on any other layer. It is completely independent.
3.  **Data Layer (`data`)**

    *   **Responsibility:** Handles data access, whether it's from the network, a local database, or other sources.
    *   **Components:**
        *   **Data Models:** Data transfer objects (DTOs) used to represent data from external sources.
        *   **Repositories:** Implement the `Repository` interfaces defined in the `Domain Layer`. They fetch, transform, and provide data to the `Domain Layer`.
        *   **Remote Data Sources:** Handle communication with APIs.
    *   **Frameworks:** Retrofit (for network), potentially Room (for local storage, if implemented).
    *   **Interaction:** `Repositories` access `Data Sources` to get data. They transform this data into `Domain` entities before passing it to the `Domain Layer`.
    *   **Dependencies:** Does not depend on `Presentation` or `Domain Layer`.

### Dependency Direction

The dependency direction flows inward:

*   The `Presentation Layer` depends on the `Domain Layer`.
*   The `Domain Layer` is independent.
*   The `Data Layer` is independent of the `Domain Layer`.

## Dependency Injection with Hilt

*   Hilt is used to manage dependencies throughout the application.
*   `@HiltAndroidApp`: Annotates the `Application` class to enable Hilt.
*   `@AndroidEntryPoint`: Annotates activities and fragments where you want to inject dependencies.
*   `@HiltViewModel`: Annotates `ViewModels` for injection.
*   `@Inject`: Used in constructors to request dependencies.

## State Management

*   **`StateFlow`:** Used in `ViewModels` to expose a stream of data to the UI.
*   **`MutableStateFlow`:** Used internally within `ViewModels` to manage the state.

## Asynchronous Operations

*   **Kotlin Coroutines:** Used for asynchronous operations, such as network requests.
*   **Flow:** Used to represent a stream of data over time.