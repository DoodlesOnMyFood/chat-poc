/*
 * This file is generated by jOOQ.
 */
package com.example.`data`.tables.records


import java.time.LocalDateTime
import java.util.UUID

import org.jooq.Field
import org.jooq.Record4
import org.jooq.Row4
import org.jooq.impl.TableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ChatDataRecord() : TableRecordImpl<ChatDataRecord>(com.example.`data`.tables.ChatData.CHAT_DATA), Record4<UUID?, LocalDateTime?, String?, String?> {

    open var chatRoom: UUID?
        set(value): Unit = set(0, value)
        get(): UUID? = get(0) as UUID?

    open var timestamp: LocalDateTime?
        set(value): Unit = set(1, value)
        get(): LocalDateTime? = get(1) as LocalDateTime?

    open var message: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var username: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row4<UUID?, LocalDateTime?, String?, String?> = super.fieldsRow() as Row4<UUID?, LocalDateTime?, String?, String?>
    override fun valuesRow(): Row4<UUID?, LocalDateTime?, String?, String?> = super.valuesRow() as Row4<UUID?, LocalDateTime?, String?, String?>
    override fun field1(): Field<UUID?> = com.example.`data`.tables.ChatData.CHAT_DATA.CHAT_ROOM
    override fun field2(): Field<LocalDateTime?> = com.example.`data`.tables.ChatData.CHAT_DATA.TIMESTAMP
    override fun field3(): Field<String?> = com.example.`data`.tables.ChatData.CHAT_DATA.MESSAGE
    override fun field4(): Field<String?> = com.example.`data`.tables.ChatData.CHAT_DATA.USERNAME
    override fun component1(): UUID? = chatRoom
    override fun component2(): LocalDateTime? = timestamp
    override fun component3(): String? = message
    override fun component4(): String? = username
    override fun value1(): UUID? = chatRoom
    override fun value2(): LocalDateTime? = timestamp
    override fun value3(): String? = message
    override fun value4(): String? = username

    override fun value1(value: UUID?): ChatDataRecord {
        set(0, value)
        return this
    }

    override fun value2(value: LocalDateTime?): ChatDataRecord {
        set(1, value)
        return this
    }

    override fun value3(value: String?): ChatDataRecord {
        set(2, value)
        return this
    }

    override fun value4(value: String?): ChatDataRecord {
        set(3, value)
        return this
    }

    override fun values(value1: UUID?, value2: LocalDateTime?, value3: String?, value4: String?): ChatDataRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        return this
    }

    /**
     * Create a detached, initialised ChatDataRecord
     */
    constructor(chatRoom: UUID? = null, timestamp: LocalDateTime? = null, message: String? = null, username: String? = null): this() {
        this.chatRoom = chatRoom
        this.timestamp = timestamp
        this.message = message
        this.username = username
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised ChatDataRecord
     */
    constructor(value: com.example.`data`.tables.pojos.ChatData?): this() {
        if (value != null) {
            this.chatRoom = value.chatRoom
            this.timestamp = value.timestamp
            this.message = value.message
            this.username = value.username
            resetChangedOnNotNull()
        }
    }
}
