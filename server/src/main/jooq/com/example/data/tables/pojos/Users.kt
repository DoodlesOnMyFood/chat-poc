/*
 * This file is generated by jOOQ.
 */
package com.example.`data`.tables.pojos


import java.io.Serializable


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Users(
    var id: String? = null
): Serializable {


    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: Users = other as Users
        if (this.id == null) {
            if (o.id != null)
                return false
        }
        else if (this.id != o.id)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (if (this.id == null) 0 else this.id.hashCode())
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("Users (")

        sb.append(id)

        sb.append(")")
        return sb.toString()
    }
}
