/*
 * This file is generated by jOOQ.
 */
package com.example.`data`.tables


import java.util.function.Function

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row1
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
open class Users(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, com.example.`data`.tables.records.UsersRecord>?,
    aliased: Table<com.example.`data`.tables.records.UsersRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<com.example.`data`.tables.records.UsersRecord>(
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
         * The reference instance of <code>chat.users</code>
         */
        val USERS: Users = Users()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<com.example.`data`.tables.records.UsersRecord> = com.example.`data`.tables.records.UsersRecord::class.java

    /**
     * The column <code>chat.users.id</code>.
     */
    val ID: TableField<com.example.`data`.tables.records.UsersRecord, String?> = createField(DSL.name("id"), SQLDataType.CLOB, this, "")

    private constructor(alias: Name, aliased: Table<com.example.`data`.tables.records.UsersRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<com.example.`data`.tables.records.UsersRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>chat.users</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>chat.users</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>chat.users</code> table reference
     */
    constructor(): this(DSL.name("users"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, com.example.`data`.tables.records.UsersRecord>): this(Internal.createPathAlias(child, key), child, key, USERS, null)
    override fun getSchema(): Schema? = if (aliased()) null else com.example.`data`.Chat.CHAT
    override fun `as`(alias: String): Users = Users(DSL.name(alias), this)
    override fun `as`(alias: Name): Users = Users(alias, this)
    override fun `as`(alias: Table<*>): Users = Users(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Users = Users(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Users = Users(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Users = Users(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row1 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row1<String?> = super.fieldsRow() as Row1<String?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (String?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (String?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
