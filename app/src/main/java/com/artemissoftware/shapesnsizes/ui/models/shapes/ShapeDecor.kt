package com.artemissoftware.shapesnsizes.ui.models.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class ShapeDecor {
}


class Shapeable(private val decoration: ShapeDecoration) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val topStartSize = decoration.topStart.size.value * density.density
        val topEndSize = decoration.topEnd.size.value * density.density
        val bottomEndSize = decoration.bottomEnd.size.value * density.density
        val bottomStartSize = decoration.bottomStart.size.value * density.density

        val path = Path().apply {
            moveTo(0f, topStartSize)
            lineTo(topStartSize, 0f)
            lineTo(size.width - topEndSize, 0f)
            lineTo(size.width, topEndSize)

            lineTo(size.width, size.height - bottomEndSize)
            lineTo(size.width - bottomEndSize, size.height)
        }

        return Outline.Generic(
            // Draw your custom path here
            path = path
        )

    }
}




enum class CornerType {
    CUT,
    ROUNDED,
    NONE
}

data class ShapeCorner(
    val type: CornerType = CornerType.NONE,
    val size: Dp = 0.dp
)

data class ShapeDecoration(
    val topStart: ShapeCorner = ShapeCorner(),
    val topEnd: ShapeCorner = ShapeCorner(),
    val bottomEnd: ShapeCorner = ShapeCorner(),
    val bottomStart: ShapeCorner = ShapeCorner()
)