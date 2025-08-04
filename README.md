# Farmer App Settings Fragment

This project contains a complete settings page implementation for a farmer app with the following features:

## Features

1. **Settings Fragment** - Main settings page with clickable buttons
2. **Profile Management** - View and manage user profile
3. **Language Selection** - Support for English, Hindi, and Gujarati
4. **Contact Support** - Multiple ways to contact support (Call, Email, WhatsApp)
5. **Logout Functionality** - Secure logout with confirmation dialog

## Files Created

### Layout Files
- `fragment_settings.xml` - Main settings page layout
- `activity_profile.xml` - Profile page layout
- `activity_language.xml` - Language selection layout
- `activity_support.xml` - Support contact layout
- `activity_main.xml` - Main activity layout

### Java Classes
- `SettingsFragment.java` - Main settings fragment with click handlers
- `ProfileActivity.java` - Profile management activity
- `LanguageActivity.java` - Language selection activity
- `SupportActivity.java` - Support contact activity
- `LoginActivity.java` - Login activity
- `MainActivity.java` - Main activity hosting the fragment
- `SharedPrefManager.java` - Session management utility

### Drawable Resources
- `rounded_button.xml` - Rounded button background
- `circle_background.xml` - Circular background for profile picture
- `radio_button_background.xml` - Radio button styling

### Configuration Files
- `colors.xml` - Color definitions
- `strings.xml` - String resources
- `AndroidManifest.xml` - App manifest with activities and permissions

## Issues Fixed

The original XML had several issues that were corrected:

1. **Missing namespace declaration** - Added `xmlns:app="http://schemas.android.com/apk/res-auto"`
2. **Incorrect attribute** - Changed `app:tint` to `android:tint` for ImageView
3. **Missing clickable attributes** - Added `android:clickable="true"` and `android:focusable="true"`
4. **Missing ripple effect** - Added `android:foreground="?android:attr/selectableItemBackground"`
5. **Incorrect drawable reference** - Fixed `farmer_avtar` to `farmer_avatar`
6. **Missing background tint for logout** - Added red background tint for logout button

## Usage

1. The `SettingsFragment` is the main settings page that displays all options
2. Each button has proper click listeners that navigate to appropriate activities
3. The logout button shows a confirmation dialog before logging out
4. All activities include proper toolbar with back navigation
5. Session management is handled through `SharedPrefManager`

## Dependencies

Make sure to include these dependencies in your `build.gradle` file:

```gradle
dependencies {
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'androidx.fragment:fragment:1.6.2'
    implementation 'com.google.android.material:material:1.10.0'
}
```

## Note

You'll need to add the actual drawable resources (icons) for:
- `farmer_avatar`
- `languages`
- `support`
- `logout`
- `ic_call`
- `ic_email`
- `ic_whatsapp`

These can be added to the `res/drawable` folder as vector drawables or PNG files.