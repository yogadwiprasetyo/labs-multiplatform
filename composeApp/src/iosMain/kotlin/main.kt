import androidx.compose.ui.window.ComposeUIViewController
import labs.yprsty.mobile.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
