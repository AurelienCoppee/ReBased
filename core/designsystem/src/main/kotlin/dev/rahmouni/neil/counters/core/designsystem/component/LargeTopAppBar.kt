package dev.rahmouni.neil.counters.core.designsystem.component

import android.widget.Toast
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.AutoMirrored.Outlined
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Feedback
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.window.core.layout.WindowHeightSizeClass
import dev.rahmouni.neil.counters.core.designsystem.R
import dev.rahmouni.neil.counters.core.designsystem.Rn3PreviewComponentDefault
import dev.rahmouni.neil.counters.core.designsystem.Rn3PreviewComponentVariation
import dev.rahmouni.neil.counters.core.designsystem.Rn3Theme

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3AdaptiveApi::class)
fun Rn3LargeTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    scrollBehavior: TopAppBarScrollBehavior,
    feedbackPageID: String? = null,
    onBackIconButtonClicked: (() -> Unit)? = null,
) {
    val localContext = LocalContext.current
    val windowState = currentWindowAdaptiveInfo()

    if (windowState.windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.COMPACT) {
        TopAppBar(
            title = {
                Text(
                    title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            modifier = modifier,
            navigationIcon = {
                if (onBackIconButtonClicked != null) {
                    Rn3IconButton(
                        icon = Outlined.ArrowBack,
                        contentDescription = stringResource(R.string.core_designsystem_largeTopAppBar_navigationIcon_iconButton_arrowBack_contentDescription),
                        onClick = onBackIconButtonClicked,
                    )
                }
            },
            actions = {
                if (feedbackPageID != null) {
                    Rn3IconButton(
                        icon = Icons.Outlined.Feedback,
                        contentDescription = stringResource(R.string.core_designsystem_largeTopAppBar_actions_iconButton_feedback_contentDescription),
                    ) {
                        Toast.makeText(localContext, feedbackPageID, Toast.LENGTH_SHORT).show()
                    }
                }
            },
            windowInsets = windowInsets,
            scrollBehavior = scrollBehavior,
        )
    } else {
        LargeTopAppBar(
            title = {
                Text(
                    title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            modifier = modifier,
            navigationIcon = {
                if (onBackIconButtonClicked != null) {
                    Rn3IconButton(
                        icon = Outlined.ArrowBack,
                        contentDescription = stringResource(R.string.core_designsystem_largeTopAppBar_navigationIcon_iconButton_arrowBack_contentDescription),
                        onClick = onBackIconButtonClicked,
                    )
                }
            },
            actions = {
                if (feedbackPageID != null) {
                    Rn3IconButton(
                        icon = Icons.Outlined.Feedback,
                        contentDescription = stringResource(R.string.core_designsystem_largeTopAppBar_actions_iconButton_feedback_contentDescription),
                    ) {
                        Toast.makeText(localContext, feedbackPageID, Toast.LENGTH_SHORT).show()
                    }
                }
            },
            windowInsets = windowInsets,
            scrollBehavior = scrollBehavior,
        )
    }
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun getRn3LargeTopAppBarScrollBehavior(): TopAppBarScrollBehavior {
    return if (currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.COMPACT) TopAppBarDefaults.pinnedScrollBehavior() else TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
}

@OptIn(ExperimentalMaterial3Api::class)
@Rn3PreviewComponentDefault
@Composable
private fun Default() {
    Rn3Theme {
        Rn3LargeTopAppBar(
            title = "Preview default",
            scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Rn3PreviewComponentVariation
@Composable
private fun BackArrow() {
    Rn3Theme {
        Rn3LargeTopAppBar(
            title = "Preview back button",
            scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
        ) {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Rn3PreviewComponentVariation
@Composable
private fun Feedback() {
    Rn3Theme {
        Rn3LargeTopAppBar(
            title = "Preview feedback",
            scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
            feedbackPageID = "ID",
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Rn3PreviewComponentVariation
@Composable
private fun BackArrowFeedback() {
    Rn3Theme {
        Rn3LargeTopAppBar(
            title = "Preview back+feedback",
            scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
            feedbackPageID = "ID",
        ) {}
    }
}