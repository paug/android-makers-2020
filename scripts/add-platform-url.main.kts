#!/usr/bin/env kotlin

// A very dirty script to add a platformUrl field in each session.
// It's in the repo to serve as a base if other json manipulations have to be made.
@file:DependsOn("com.squareup.moshi:moshi-kotlin:1.9.2")

import com.squareup.moshi.Moshi
import java.io.File

val input = args[0]

val json = File(input).readText()

val adapter = Moshi.Builder().build().adapter(Any::class.java).indent("  ").serializeNulls()
val any = adapter.fromJson(json)!!.makeMutable()

(any as Map<String, Any>).values.forEach { speaker ->
  val map = (speaker as MutableMap<String, Any?>)
  if (map.containsKey("slido")) {
    map.put("platformUrl", "https://androidmakers.fr")
  }
}

val transformed = adapter.toJson(any)

println(transformed)

fun Any.makeMutable(): Any {
  return when (this) {
    is Map<*, *> -> mapValues<Any?, Any?, Any?> { entry: Map.Entry<Any?, Any?> ->
      entry.value?.makeMutable()
    }.toMutableMap()
    else -> this
  }

}
