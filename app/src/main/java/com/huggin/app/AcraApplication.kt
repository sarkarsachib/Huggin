package com.huggin.app

/**
 * Deprecated alias for HugginApp for backwards compatibility with plugins.
 * Use HugginApp instead.
 */
@Deprecated(
    message = "AcraApplication is deprecated, use HugginApp instead",
    replaceWith = ReplaceWith("com.huggin.app.HugginApp"),
    level = DeprecationLevel.ERROR
)
class AcraApplication {
	companion object {

		@Deprecated(
		    message = "AcraApplication is deprecated, use HugginApp instead",
		    replaceWith = ReplaceWith("com.huggin.app.HugginApp.context"),
		    level = DeprecationLevel.ERROR
		)
		val context get() = HugginApp.context

		@Deprecated(
		    message = "AcraApplication is deprecated, use HugginApp instead",
		    replaceWith = ReplaceWith("com.huggin.app.HugginApp.removeKeys(folder)"),
		    level = DeprecationLevel.ERROR
		)
		fun removeKeys(folder: String): Int? =
		    HugginApp.removeKeys(folder)

		@Deprecated(
		    message = "AcraApplication is deprecated, use HugginApp instead",
		    replaceWith = ReplaceWith("com.huggin.app.HugginApp.setKey(path, value)"),
		    level = DeprecationLevel.ERROR
		)
		fun <T> setKey(path: String, value: T) =
			HugginApp.setKey(path, value)

		@Deprecated(
		    message = "AcraApplication is deprecated, use HugginApp instead",
		    replaceWith = ReplaceWith("com.huggin.app.HugginApp.setKey(folder, path, value)"),
		    level = DeprecationLevel.ERROR
		)
		fun <T> setKey(folder: String, path: String, value: T) =
			HugginApp.setKey(folder, path, value)

		@Deprecated(
		    message = "AcraApplication is deprecated, use HugginApp instead",
		    replaceWith = ReplaceWith("com.huggin.app.HugginApp.getKey(path, defVal)"),
		    level = DeprecationLevel.ERROR
		)
		inline fun <reified T : Any> getKey(path: String, defVal: T?): T? =
			HugginApp.getKey(path, defVal)

		@Deprecated(
		    message = "AcraApplication is deprecated, use HugginApp instead",
		    replaceWith = ReplaceWith("com.huggin.app.HugginApp.getKey(path)"),
		    level = DeprecationLevel.ERROR
		)
		inline fun <reified T : Any> getKey(path: String): T? =
			HugginApp.getKey(path)

		@Deprecated(
		    message = "AcraApplication is deprecated, use HugginApp instead",
		    replaceWith = ReplaceWith("com.huggin.app.HugginApp.getKey(folder, path)"),
		    level = DeprecationLevel.ERROR
		)
		inline fun <reified T : Any> getKey(folder: String, path: String): T? =
		    HugginApp.getKey(folder, path)

		@Deprecated(
		    message = "AcraApplication is deprecated, use HugginApp instead",
		    replaceWith = ReplaceWith("com.huggin.app.HugginApp.getKey(folder, path, defVal)"),
		    level = DeprecationLevel.ERROR
		)
		inline fun <reified T : Any> getKey(folder: String, path: String, defVal: T?): T? =
			HugginApp.getKey(folder, path, defVal)
	}
}
