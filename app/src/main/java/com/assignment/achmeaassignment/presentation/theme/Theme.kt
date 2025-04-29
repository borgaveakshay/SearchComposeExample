package com.example.compose

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.assignment.achmeaassignment.presentation.theme.AppTypography
import com.assignment.achmeaassignment.presentation.theme.backgroundDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.backgroundDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.backgroundLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.backgroundLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.errorContainerDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.errorContainerDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.errorContainerLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.errorContainerLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.errorDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.errorDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.errorLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.errorLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.inverseOnSurfaceDark
import com.assignment.achmeaassignment.presentation.theme.inverseOnSurfaceDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.inverseOnSurfaceDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.inverseOnSurfaceLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.inverseOnSurfaceLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.inversePrimaryDark
import com.assignment.achmeaassignment.presentation.theme.inversePrimaryDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.inversePrimaryDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.inversePrimaryLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.inversePrimaryLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.inverseSurfaceDark
import com.assignment.achmeaassignment.presentation.theme.inverseSurfaceDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.inverseSurfaceDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.inverseSurfaceLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.inverseSurfaceLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onBackgroundDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.onBackgroundDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onBackgroundLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.onBackgroundLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onErrorContainerDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.onErrorContainerDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onErrorContainerLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.onErrorContainerLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onErrorDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.onErrorDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onErrorLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.onErrorLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onPrimaryContainerDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.onPrimaryContainerDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onPrimaryContainerLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.onPrimaryContainerLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onPrimaryDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.onPrimaryDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onPrimaryLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.onPrimaryLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onSecondaryContainerDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.onSecondaryContainerDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onSecondaryContainerLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.onSecondaryContainerLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onSecondaryDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.onSecondaryDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onSecondaryLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.onSecondaryLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onSurfaceDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.onSurfaceDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onSurfaceLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.onSurfaceLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onSurfaceVariantDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.onSurfaceVariantDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onSurfaceVariantLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.onSurfaceVariantLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onTertiaryContainerDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.onTertiaryContainerDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onTertiaryContainerLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.onTertiaryContainerLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onTertiaryDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.onTertiaryDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.onTertiaryLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.onTertiaryLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.outlineDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.outlineDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.outlineLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.outlineLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.outlineVariantDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.outlineVariantDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.outlineVariantLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.outlineVariantLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.primaryContainerDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.primaryContainerDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.primaryContainerLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.primaryContainerLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.primaryDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.primaryDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.primaryLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.primaryLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.scrimDark
import com.assignment.achmeaassignment.presentation.theme.scrimDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.scrimDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.scrimLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.scrimLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.secondaryContainerDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.secondaryContainerDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.secondaryContainerLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.secondaryContainerLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.secondaryDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.secondaryDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.secondaryLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.secondaryLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceBrightDark
import com.assignment.achmeaassignment.presentation.theme.surfaceBrightDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceBrightDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceBrightLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceBrightLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerDark
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighDark
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighestDark
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighestDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighestDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighestLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighestLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowDark
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowestDark
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowestDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowestDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowestLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowestLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceDimDark
import com.assignment.achmeaassignment.presentation.theme.surfaceDimDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceDimDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceDimLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceDimLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceVariantDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceVariantDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceVariantLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.surfaceVariantLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.tertiaryContainerDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.tertiaryContainerDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.tertiaryContainerLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.tertiaryContainerLightMediumContrast
import com.assignment.achmeaassignment.presentation.theme.tertiaryDarkHighContrast
import com.assignment.achmeaassignment.presentation.theme.tertiaryDarkMediumContrast
import com.assignment.achmeaassignment.presentation.theme.tertiaryLightHighContrast
import com.assignment.achmeaassignment.presentation.theme.tertiaryLightMediumContrast


private val lightScheme = lightColorScheme(
    primary = com.assignment.achmeaassignment.presentation.theme.primaryLight,
    onPrimary = com.assignment.achmeaassignment.presentation.theme.onPrimaryLight,
    primaryContainer = com.assignment.achmeaassignment.presentation.theme.primaryContainerLight,
    onPrimaryContainer = com.assignment.achmeaassignment.presentation.theme.onPrimaryContainerLight,
    secondary = com.assignment.achmeaassignment.presentation.theme.secondaryLight,
    onSecondary = com.assignment.achmeaassignment.presentation.theme.onSecondaryLight,
    secondaryContainer = com.assignment.achmeaassignment.presentation.theme.secondaryContainerLight,
    onSecondaryContainer = com.assignment.achmeaassignment.presentation.theme.onSecondaryContainerLight,
    tertiary = com.assignment.achmeaassignment.presentation.theme.tertiaryLight,
    onTertiary = com.assignment.achmeaassignment.presentation.theme.onTertiaryLight,
    tertiaryContainer = com.assignment.achmeaassignment.presentation.theme.tertiaryContainerLight,
    onTertiaryContainer = com.assignment.achmeaassignment.presentation.theme.onTertiaryContainerLight,
    error = com.assignment.achmeaassignment.presentation.theme.errorLight,
    onError = com.assignment.achmeaassignment.presentation.theme.onErrorLight,
    errorContainer = com.assignment.achmeaassignment.presentation.theme.errorContainerLight,
    onErrorContainer = com.assignment.achmeaassignment.presentation.theme.onErrorContainerLight,
    background = com.assignment.achmeaassignment.presentation.theme.backgroundLight,
    onBackground = com.assignment.achmeaassignment.presentation.theme.onBackgroundLight,
    surface = com.assignment.achmeaassignment.presentation.theme.surfaceLight,
    onSurface = com.assignment.achmeaassignment.presentation.theme.onSurfaceLight,
    surfaceVariant = com.assignment.achmeaassignment.presentation.theme.surfaceVariantLight,
    onSurfaceVariant = com.assignment.achmeaassignment.presentation.theme.onSurfaceVariantLight,
    outline = com.assignment.achmeaassignment.presentation.theme.outlineLight,
    outlineVariant = com.assignment.achmeaassignment.presentation.theme.outlineVariantLight,
    scrim = com.assignment.achmeaassignment.presentation.theme.scrimLight,
    inverseSurface = com.assignment.achmeaassignment.presentation.theme.inverseSurfaceLight,
    inverseOnSurface = com.assignment.achmeaassignment.presentation.theme.inverseOnSurfaceLight,
    inversePrimary = com.assignment.achmeaassignment.presentation.theme.inversePrimaryLight,
    surfaceDim = com.assignment.achmeaassignment.presentation.theme.surfaceDimLight,
    surfaceBright = com.assignment.achmeaassignment.presentation.theme.surfaceBrightLight,
    surfaceContainerLowest = com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowestLight,
    surfaceContainerLow = com.assignment.achmeaassignment.presentation.theme.surfaceContainerLowLight,
    surfaceContainer = com.assignment.achmeaassignment.presentation.theme.surfaceContainerLight,
    surfaceContainerHigh = com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighLight,
    surfaceContainerHighest = com.assignment.achmeaassignment.presentation.theme.surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = com.assignment.achmeaassignment.presentation.theme.primaryDark,
    onPrimary = com.assignment.achmeaassignment.presentation.theme.onPrimaryDark,
    primaryContainer = com.assignment.achmeaassignment.presentation.theme.primaryContainerDark,
    onPrimaryContainer = com.assignment.achmeaassignment.presentation.theme.onPrimaryContainerDark,
    secondary = com.assignment.achmeaassignment.presentation.theme.secondaryDark,
    onSecondary = com.assignment.achmeaassignment.presentation.theme.onSecondaryDark,
    secondaryContainer = com.assignment.achmeaassignment.presentation.theme.secondaryContainerDark,
    onSecondaryContainer = com.assignment.achmeaassignment.presentation.theme.onSecondaryContainerDark,
    tertiary = com.assignment.achmeaassignment.presentation.theme.tertiaryDark,
    onTertiary = com.assignment.achmeaassignment.presentation.theme.onTertiaryDark,
    tertiaryContainer = com.assignment.achmeaassignment.presentation.theme.tertiaryContainerDark,
    onTertiaryContainer = com.assignment.achmeaassignment.presentation.theme.onTertiaryContainerDark,
    error = com.assignment.achmeaassignment.presentation.theme.errorDark,
    onError = com.assignment.achmeaassignment.presentation.theme.onErrorDark,
    errorContainer = com.assignment.achmeaassignment.presentation.theme.errorContainerDark,
    onErrorContainer = com.assignment.achmeaassignment.presentation.theme.onErrorContainerDark,
    background = com.assignment.achmeaassignment.presentation.theme.backgroundDark,
    onBackground = com.assignment.achmeaassignment.presentation.theme.onBackgroundDark,
    surface = com.assignment.achmeaassignment.presentation.theme.surfaceDark,
    onSurface = com.assignment.achmeaassignment.presentation.theme.onSurfaceDark,
    surfaceVariant = com.assignment.achmeaassignment.presentation.theme.surfaceVariantDark,
    onSurfaceVariant = com.assignment.achmeaassignment.presentation.theme.onSurfaceVariantDark,
    outline = com.assignment.achmeaassignment.presentation.theme.outlineDark,
    outlineVariant = com.assignment.achmeaassignment.presentation.theme.outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

