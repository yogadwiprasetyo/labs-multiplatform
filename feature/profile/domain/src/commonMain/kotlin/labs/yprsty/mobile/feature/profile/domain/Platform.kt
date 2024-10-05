package labs.yprsty.mobile.feature.profile.domain

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform