/*
 * This file is generated by jOOQ.
 */
package com.example.`data`.tables


import java.util.UUID
import java.util.function.Function

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row2
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UserChatRooms(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, com.example.`data`.tables.records.UserChatRoomsRecord>?,
    aliased: Table<com.example.`data`.tables.records.UserChatRoomsRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<com.example.`data`.tables.records.UserChatRoomsRecord>(
    alias,
    com.example.`data`.Chat.CHAT,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>chat.user_chat_rooms</code>
         */
        val USER_CHAT_ROOMS: UserChatRooms = UserChatRooms()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<com.example.`data`.tables.records.UserChatRoomsRecord> = com.example.`data`.tables.records.UserChatRoomsRecord::class.java

    /**
     * The column <code>chat.user_chat_rooms.user_id</code>.
     */
    val USER_ID: TableField<com.example.`data`.tables.records.UserChatRoomsRecord, String?> = createField(DSL.name("user_id"), SQLDataType.CLOB, this, "")

    /**
     * The column <code>chat.user_chat_rooms.chat_room_id</code>.
     */
    val CHAT_ROOM_ID: TableField<com.example.`data`.tables.records.UserChatRoomsRecord, UUID?> = createField(DSL.name("chat_room_id"), SQLDataType.UUID, this, "")

    private constructor(alias: Name, aliased: Table<com.example.`data`.tables.records.UserChatRoomsRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<com.example.`data`.tables.records.UserChatRoomsRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>chat.user_chat_rooms</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>chat.user_chat_rooms</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>chat.user_chat_rooms</code> table reference
     */
    constructor(): this(DSL.name("user_chat_rooms"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, com.example.`data`.tables.records.UserChatRoomsRecord>): this(Internal.createPathAlias(child, key), child, key, USER_CHAT_ROOMS, null)
    override fun getSchema(): Schema? = if (aliased()) null else com.example.`data`.Chat.CHAT
    override fun `as`(alias: String): UserChatRooms = UserChatRooms(DSL.name(alias), this)
    override fun `as`(alias: Name): UserChatRooms = UserChatRooms(alias, this)
    override fun `as`(alias: Table<*>): UserChatRooms = UserChatRooms(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): UserChatRooms = UserChatRooms(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): UserChatRooms = UserChatRooms(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): UserChatRooms = UserChatRooms(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row2<String?, UUID?> = super.fieldsRow() as Row2<String?, UUID?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (String?, UUID?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (String?, UUID?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
