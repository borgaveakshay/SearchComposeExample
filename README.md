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

### Architectural Layers and Key Classes

1.  **Presentation Layer (`presentation`)**

    *   **Responsibility:** Handles UI logic, user interactions, and the display of data.
    *   **Components:**
        *   **Composables (Views):** UI elements built using Jetpack Compose. They receive UI state and emit user events.
            *   **`EmployerSearchScreen.kt`:** The main screen for displaying the search results and search field.
                *   **Role:** Renders the UI, displays data, and handles user input.
                *   **Interaction:** Receives state updates from the `EmployerViewModel` and sends user intents (like search query changes) back to the `EmployerViewModel`.
            * **`EmployerSearchField.kt`:** A reusable component representing the Search field.
                * **Role:** Provides the Search Bar user interface and emits user input events.
                * **Interaction:** receives user input and sends it to the parent composable using the `onQueryChanged` callback
        *   **ViewModels:** Act as the intermediary between Composables and the Domain Layer. They:
            *   Hold UI state as `StateFlow`.
            *   Receive user intents from the UI.
            *   Interact with Use Cases in the Domain Layer.
            *   Transform Domain Layer data into UI-specific state.
            *   **`EmployerViewModel.kt`:**
                *   **Role:** Holds the state for the `EmployerSearchScreen`. It gets employers from the `GetEmployersUseCase`, updates the state based on the results, and exposes the state to the UI.
                *   **Interaction:** Receives user intents from `EmployerSearchScreen`, interacts with `GetEmployersUseCase`, updates the `EmployerSearchState` (the UI state), and exposes it as a `StateFlow`.
        *   **States:** Data models that represent UI state. They are immutable data classes that describe the UI's current state.
            *   **`EmployerSearchState.kt`:**
                *   **Role:** Represents the UI state of the `EmployerSearchScreen`. It includes information like loading state, the list of employers, and error messages.
                *   **Interaction:** `EmployerViewModel` modifies this state, and `EmployerSearchScreen` reads it to update the UI.

2.  **Domain Layer (`domain`)**

    *   **Responsibility:** Contains the core business logic and application rules. It's the most inner layer and is completely independent.
    *   **Components:**
        *   **Entities:** Business objects that represent data (e.g., `Employer`). These are plain Kotlin data classes, independent of how data is stored or fetched.
            *   **`Employer.kt`:**
                *   **Role:** Represents an employer entity. It holds the business logic-relevant data about an employer.
                *   **Interaction:** Used by `UseCases` to define and manipulate business objects.
        *   **Use Cases:** Define actions that users can perform (e.g., `GetEmployersUseCase`). They represent a single unit of business logic.
            *   **`GetEmployersUseCase.kt`:**
                *   **Role:** Defines the action of getting a list of employers. It handles business logic for that specific task.
                *   **Interaction:** Calls methods on `EmployerRepository` to get data, applies any necessary business rules, and returns the result to the caller (typically a ViewModel).

    **DataLayer (`data`)**
        *   **Repository Interfaces:** Contracts for data access (e.g., `EmployerRepository`). They define *what* data operations can be performed, not *how* they are implemented.
            *   **`EmployerRepository.kt`:**
            *   **Role:** Defines the contract for employer data access. It specifies operations like `getEmployers()`.
            *   **Interaction:** Use Cases interact with this interface. `EmployerRepositoryImpl` (in the Data Layer) implements this interface.