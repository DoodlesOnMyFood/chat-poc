/*
 * This file is generated by jOOQ.
 */
package com.example.`data`.tables


import java.time.LocalDateTime
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
open class ChatRoom(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, com.example.`data`.tables.records.ChatRoomRecord>?,
    aliased: Table<com.example.`data`.tables.records.ChatRoomRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<com.example.`data`.tables.records.ChatRoomRecord>(
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
         * The reference instance of <code>chat.chat_room</code>
         */
        val CHAT_ROOM: ChatRoom = ChatRoom()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<com.example.`data`.tables.records.ChatRoomRecord> = com.example.`data`.tables.records.ChatRoomRecord::class.java

    /**
     * The column <code>chat.chat_room.id</code>.
     */
    val ID: TableField<com.example.`data`.tables.records.ChatRoomRecord, UUID?> = createField(DSL.name("id"), SQLDataType.UUID, this, "")

    /**
     * The column <code>chat.chat_room.created_at</code>.
     */
    val CREATED_AT: TableField<com.example.`data`.tables.records.ChatRoomRecord, LocalDateTime?> = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "")

    private constructor(alias: Name, aliased: Table<com.example.`data`.tables.records.ChatRoomRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<com.example.`data`.tables.records.ChatRoomRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>chat.chat_room</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>chat.chat_room</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>chat.chat_room</code> table reference
     */
    constructor(): this(DSL.name("chat_room"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, com.example.`data`.tables.records.ChatRoomRecord>): this(Internal.createPathAlias(child, key), child, key, CHAT_ROOM, null)
    override fun getSchema(): Schema? = if (aliased()) null else com.example.`data`.Chat.CHAT
    override fun `as`(alias: String): ChatRoom = ChatRoom(DSL.name(alias), this)
    override fun `as`(alias: Name): ChatRoom = ChatRoom(alias, this)
    override fun `as`(alias: Table<*>): ChatRoom = ChatRoom(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ChatRoom = ChatRoom(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ChatRoom = ChatRoom(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): ChatRoom = ChatRoom(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row2<UUID?, LocalDateTime?> = super.fieldsRow() as Row2<UUID?, LocalDateTime?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (UUID?, LocalDateTime?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (UUID?, LocalDateTime?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
