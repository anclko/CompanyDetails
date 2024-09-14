# Companies App

This is a simple Android app built using Kotlin and Jetpack Compose. The app fetches and displays a list of companies from Firebase Firestore and presents them in a scrollable card-based list format.

## Features

- Fetches data from Firestore.
- Displays companies' information, including their title, city, and webpage.
- Shows a loading indicator while fetching data.
- Handles errors by displaying an error message if data retrieval fails.
- Uses coroutines for asynchronous tasks and data fetching.

## Technologies Used

- **Kotlin**: Primary programming language.
- **Jetpack Compose**: For building UI.
- **Firebase Firestore**: To store and retrieve company data.
- **Coroutines**: For non-blocking, asynchronous data fetching.
- **ViewModel**: For managing UI-related data in a lifecycle-conscious way.

### Data Layer

The data package includes:
- **Company**: Represents each company with fields such as `id`, `title`, `city`, and `webpage`.
- **CompanyResponse**: Wraps a list of `Company` objects.
- **FirestoreService**: Handles data retrieval from Firestore using coroutines.

### UI Layer

- **CompanyScreen**: The main composable function that displays a list of companies or appropriate messages during loading/error states.
- **CompanyCard**: A reusable composable that formats how each company is presented in the list, showing its title, city, and webpage.

### ViewModel

The `MainViewModel` handles the app's logic and data persistence. It fetches companies from Firestore and updates the UI based on the current state.

### Firebase Setup

1. Go to the [Firebase Console](https://console.firebase.google.com/).
2. Create a new Firebase project.
3. Set up Firestore and create a collection named `companies`.
4. Add some company documents with the following fields:
   - `id`: Int
   - `title`: String
   - `city`: String
   - `webpage`: String
5. Download the `google-services.json` file and place it in the `app` directory of your Android project.

## Screenshots

## Contact
For any questions or inquiries, feel free to reach out to me at [anclko@hotmail.com](mailto:anclko@hotmail.com).

## License
This project is licensed under the MIT License

