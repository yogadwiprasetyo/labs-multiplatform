package labs.yprsty.mobile.feature.profile.data

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform