package labs.yprsty.mobile.convention

private const val STRIP = "-"
private const val UNDER_SCORE = "_"

fun String.getModuleName(
    delimiters: String = ":",
    separator: String = ".",
    drop: Int = 0
): String {
    val moduleName = this.split(delimiters)
        .filter { it.isNotBlank() }
        .drop(drop)
        .joinToString(separator)

    if (moduleName.isBlank()) throw IllegalStateException("Module name cannot be empty! Please provide it to fix.")

    return if (moduleName.contains(separator) && moduleName.contains(STRIP)) {
        moduleName.replace(STRIP, UNDER_SCORE)
    } else {
        moduleName
    }
}