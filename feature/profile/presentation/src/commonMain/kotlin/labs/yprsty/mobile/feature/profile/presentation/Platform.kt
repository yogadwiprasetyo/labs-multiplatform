package labs.yprsty.mobile.feature.profile.presentation

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform