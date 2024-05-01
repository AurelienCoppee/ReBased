package dev.rahmouni.neil.counters.core.designsystem.component

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.view.HapticFeedbackConstants
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalView
import dev.rahmouni.neil.counters.core.feedback.getNonComposableFeedbackID

@Composable
fun getHaptic(): Haptic {
    return Haptic().init()
}

class Haptic {

    private var view: View? = null
    private var haptic: HapticFeedback? = null

    @Composable
    fun init(): Haptic {
        view = LocalView.current
        haptic = LocalHapticFeedback.current

        return this
    }

    fun click() {
        if (view == null || haptic == null) throw hapticClassNonInitializedException("vRzFlAB4R2BL1DgQVtDWBUjK2hxPwL79")

        if (VERSION.SDK_INT >= VERSION_CODES.M) {
            view?.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK)
        } else {
            haptic?.performHapticFeedback(HapticFeedbackType.LongPress)
        }
    }

    fun toggle(state: Boolean) {
        if (state) toggleOn() else toggleOff()
    }

    fun toggleOn() {
        if (view == null || haptic == null) throw hapticClassNonInitializedException("2DE1Fjt7SaM5oVBgUZbaKu0T3FHy0WXQ")

        if (VERSION.SDK_INT >= VERSION_CODES.UPSIDE_DOWN_CAKE) {
            view?.performHapticFeedback(HapticFeedbackConstants.TOGGLE_ON)
        } else {
            click()
        }
    }

    fun toggleOff() {
        if (view == null || haptic == null) throw hapticClassNonInitializedException("wSnwbynXGOaOkVsXZCRxVKAJWEmJ6iPF")

        if (VERSION.SDK_INT >= VERSION_CODES.UPSIDE_DOWN_CAKE) {
            view?.performHapticFeedback(HapticFeedbackConstants.TOGGLE_OFF)
        } else {
            click()
        }
    }

    private fun hapticClassNonInitializedException(localID: String): Exception {
        return Exception(
            getNonComposableFeedbackID(
                localName = "Haptic",
                localID = localID,
                "Haptic function not initialized",
            ),
        )
    }
}