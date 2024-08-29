package com.curso.android.volumeareaapp
//Model Class for adapter is going display
class Shape(shapeImg: Int, shapeName: String) {
    private val _shapeName: String = shapeName
    private val _shapeImg: Int = shapeImg

    val shapeImg: Int
        get() = _shapeImg

    val shapeName: String
        get() = _shapeName
}
