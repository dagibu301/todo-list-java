/*
 * This file is generated by jOOQ.
 */
package test.generated.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import test.generated.tables.Tasks;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TasksRecord extends UpdatableRecordImpl<TasksRecord> implements Record4<Integer, String, String, Byte> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>todolist.tasks.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>todolist.tasks.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>todolist.tasks.title</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>todolist.tasks.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>todolist.tasks.description</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>todolist.tasks.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>todolist.tasks.isfinished</code>.
     */
    public void setIsfinished(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>todolist.tasks.isfinished</code>.
     */
    public Byte getIsfinished() {
        return (Byte) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, Byte> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, String, Byte> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Tasks.TASKS.ID;
    }

    @Override
    public Field<String> field2() {
        return Tasks.TASKS.TITLE;
    }

    @Override
    public Field<String> field3() {
        return Tasks.TASKS.DESCRIPTION;
    }

    @Override
    public Field<Byte> field4() {
        return Tasks.TASKS.ISFINISHED;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getTitle();
    }

    @Override
    public String component3() {
        return getDescription();
    }

    @Override
    public Byte component4() {
        return getIsfinished();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getTitle();
    }

    @Override
    public String value3() {
        return getDescription();
    }

    @Override
    public Byte value4() {
        return getIsfinished();
    }

    @Override
    public TasksRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TasksRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public TasksRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public TasksRecord value4(Byte value) {
        setIsfinished(value);
        return this;
    }

    @Override
    public TasksRecord values(Integer value1, String value2, String value3, Byte value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TasksRecord
     */
    public TasksRecord() {
        super(Tasks.TASKS);
    }

    /**
     * Create a detached, initialised TasksRecord
     */
    public TasksRecord(Integer id, String title, String description, Byte isfinished) {
        super(Tasks.TASKS);

        setId(id);
        setTitle(title);
        setDescription(description);
        setIsfinished(isfinished);
    }
}