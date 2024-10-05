package labs.yprsty.mobile.umbrella

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform