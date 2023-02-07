package models

sealed class Sex
class Male:Sex() {
    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return System.identityHashCode(this)
    }

    override fun toString(): String {
        return "M"
    }
}

class  Female:Sex() {
    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return System.identityHashCode(this)
    }
    override fun toString(): String {
        return "F"
    }
}

