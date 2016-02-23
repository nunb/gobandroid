package org.ligi.gobandroid_hd

import android.support.annotation.StringRes
import org.ligi.gobandroid_hd.logic.Cell
import org.ligi.gobandroid_hd.logic.GoGame

class InteractionScope {

    enum class Mode {
        RECODRD,
        TSUMEGO,
        REVIEW,
        RECORD,
        GNUGO,
        TELEVIZE,
        EDIT,
        COUNT,
        SETUP;

        @StringRes
        fun getStringRes(): Int {
            return when (this) {
                TSUMEGO -> R.string.tsumego
                REVIEW -> R.string.review
                RECORD -> R.string.play
                TELEVIZE -> R.string.go_tv
                COUNT -> R.string.count
                GNUGO -> R.string.gnugo
                EDIT -> R.string.edit
                SETUP -> R.string.setup
                else -> R.string.empty_str
            }
        }
    }


    var touchCell: Cell? = null
    var mode = Mode.SETUP
    var is_in_noif_mode = false

    var ask_variant_session = true

    fun hasValidTouchCoord(game: GoGame): Boolean {
        return touchCell != null && game.calcBoard.statelessGoBoard.getCell(touchCell!!) != null
    }
}