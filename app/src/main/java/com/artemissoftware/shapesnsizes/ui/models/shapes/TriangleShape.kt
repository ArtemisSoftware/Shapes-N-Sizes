package com.artemissoftware.shapesnsizes.ui.models.shapes

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


class TriangleShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        return Outline.Generic(path = drawTrianglePath(size))
    }
}

fun drawTrianglePath(size: Size): Path {

    return Path().apply {

        // Moves to top center position
        moveTo(size.width / 2f, 0f)
        // Add line to right corner above circle
        lineTo(x = size.width, y = size.height)
        //Add line to left corner above circle
        lineTo(x = 0f, y = size.height)

    }

}