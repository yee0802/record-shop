# Record Shop

## Description
An android application built to serve as a frontend for the [Record Shop API](https://github.com/yee0802/record-shop-api/). 
This app allows users to browse, manage, and interact with albums in the record shop catalog. Built with 
modern Android development practises, including MVVM architecture, RecyclerView for efficient data display, 
and Glide for image loading.

## Features

* **Browse Albums:** View a list of albums available in the record shop.
* **Album Details:** View detailed information about each album, including artist, genre, release year, and stock quantity
* **Update Albums:** Modify album details such as stock quantity and release year directly within the app.
* **Delete Albums**: Remove albums from the catalog with a few taps.
* **Search and Filter**: Filter albums dynamically based on their name or artist.
* **Swipe to Refresh**: Refresh the main feed with a simple swipe-down gesture.

## Technologies Used

* **Android SDK:** Development environment for building the app.
* **Java:** The primary programming language used for the application.
* **RecyclerView:** For displaying album lists efficiently.
* **Retrofit:** Manages network requests to interact with the Record Shop API.
* **ViewModel:** For managing UI-related data in a lifecycle-conscious way.
* **Data Binding:** For binding UI components to data sources.
* **Glide:** Handles image loading and caching for album covers.

## Setup Instructions

### Prerequisites
  Before running the application, ensure you have the following:
1. **Android Studio**: Installed and properly configured. [Download here](https://developer.android.com/studio).
2. **Record Shop API**: The backend API repository must be up and running. Follow the setup instructions in the [Record Shop API repository](https://github.com/yee0802/record-shop-api).
    - The backend should be running locally on the default port (or update the app's base URL if configured differently).

### Steps to Clone and Run the App
1. **Clone the Repository**  
   Open a terminal and run the following command to clone the repository:
   ```bash
   git clone https://github.com/yee0802/record-shop.git && cd record-shop
   ```
2. **Open in Android Studio**
   - Launch Android Studio.
   - Select **File** > **Open** and navigate to the `record-shop` folder.
   - Click **OK** to load the project.
3. **Sync Gradle**
   - When prompted, click **Sync Now** to download dependencies and configure the project.
4. **Run the Backend API**
   - Ensure the Record Shop API is running locally.
5. **Build and Run the App**
   - Connect a physical device (via USB) or start an emulator.
   - Click the **Run** button or press `Shift + F10` to build and run the app.

## Credits
Created by Kye Yee | 2024