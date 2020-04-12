#!/usr/bin/env kotlin

@file:DependsOn("com.squareup.moshi:moshi-kotlin:1.9.2")

import com.squareup.moshi.Moshi
import java.io.File

val input = args[0]

val json = File(input).readText()

val adapter = Moshi.Builder().build().adapter(Any::class.java).indent("  ").serializeNulls()
val any = adapter.fromJson(json)!!.makeMutable()

(any as Map<String, Any>).values.forEach { speaker ->
  val map = (speaker as MutableMap<String, Any?>)
  map.put("photoUrl", map.get("photo"))
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

fun duplicatePhoto(any: Any) {

}
