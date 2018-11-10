package com.finance.ymt.sgr.suanliao.model.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.finance.ymt.sgr.suanliao.model.bean.SuanLiao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SUAN_LIAO".
*/
public class SuanLiaoDao extends AbstractDao<SuanLiao, Long> {

    public static final String TABLENAME = "SUAN_LIAO";

    /**
     * Properties of entity SuanLiao.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Data = new Property(3, String.class, "data", false, "DATA");
        public final static Property Curtain_width_edit = new Property(4, double.class, "curtain_width_edit", false, "CURTAIN_WIDTH_EDIT");
        public final static Property Curtain_hight_edit = new Property(5, double.class, "curtain_hight_edit", false, "CURTAIN_HIGHT_EDIT");
        public final static Property Curtain_beilu_edit = new Property(6, double.class, "curtain_beilu_edit", false, "CURTAIN_BEILU_EDIT");
        public final static Property Curtain_bu_edit = new Property(7, double.class, "curtain_bu_edit", false, "CURTAIN_BU_EDIT");
        public final static Property Curtain_sha_edit = new Property(8, double.class, "curtain_sha_edit", false, "CURTAIN_SHA_EDIT");
        public final static Property Lmg_quan_edit = new Property(9, double.class, "lmg_quan_edit", false, "LMG_QUAN_EDIT");
        public final static Property Lmg_gang_edit = new Property(10, double.class, "lmg_gang_edit", false, "LMG_GANG_EDIT");
        public final static Property Lmg_bu_edit = new Property(11, double.class, "lmg_bu_edit", false, "LMG_BU_EDIT");
        public final static Property Pb_num_edit = new Property(12, double.class, "pb_num_edit", false, "PB_NUM_EDIT");
        public final static Property Pb_unit_edit = new Property(13, double.class, "pb_unit_edit", false, "PB_UNIT_EDIT");
        public final static Property Lt_width_edit = new Property(14, double.class, "lt_width_edit", false, "LT_WIDTH_EDIT");
        public final static Property Lt_unit_edit = new Property(15, double.class, "lt_unit_edit", false, "LT_UNIT_EDIT");
        public final static Property Lt_guidao_edit = new Property(16, double.class, "lt_guidao_edit", false, "LT_GUIDAO_EDIT");
        public final static Property Lt_guidaounit_edit = new Property(17, double.class, "lt_guidaounit_edit", false, "LT_GUIDAOUNIT_EDIT");
        public final static Property Lt_hua_edit = new Property(18, double.class, "lt_hua_edit", false, "LT_HUA_EDIT");
        public final static Property Lt_huaunit_edit = new Property(19, double.class, "lt_huaunit_edit", false, "LT_HUAUNIT_EDIT");
        public final static Property Lt_mooshu_edit = new Property(20, double.class, "lt_mooshu_edit", false, "LT_MOOSHU_EDIT");
        public final static Property Lt_moshuunit_edit = new Property(21, double.class, "lt_moshuunit_edit", false, "LT_MOSHUUNIT_EDIT");
        public final static Property Lt_jiagong_edit = new Property(22, double.class, "lt_jiagong_edit", false, "LT_JIAGONG_EDIT");
        public final static Property Lt_jiagongunit_edit = new Property(23, double.class, "lt_jiagongunit_edit", false, "LT_JIAGONGUNIT_EDIT");
        public final static Property Gs_unit_edit = new Property(24, double.class, "gs_unit_edit", false, "GS_UNIT_EDIT");
        public final static Property Gs_gang_edit = new Property(25, double.class, "gs_gang_edit", false, "GS_GANG_EDIT");
        public final static Property Gs_bu_edit = new Property(26, double.class, "gs_bu_edit", false, "GS_BU_EDIT");
        public final static Property Pj_gqnum_edit = new Property(27, double.class, "pj_gqnum_edit", false, "PJ_GQNUM_EDIT");
        public final static Property Pj_gqunit_edit = new Property(28, double.class, "pj_gqunit_edit", false, "PJ_GQUNIT_EDIT");
        public final static Property Pj_hua_edit = new Property(29, double.class, "pj_hua_edit", false, "PJ_HUA_EDIT");
        public final static Property Pj_bengdai_edit = new Property(30, double.class, "pj_bengdai_edit", false, "PJ_BENGDAI_EDIT");
        public final static Property Pj_qianggou_edit = new Property(31, double.class, "pj_qianggou_edit", false, "PJ_QIANGGOU_EDIT");
        public final static Property Pj_buliao_edit = new Property(32, double.class, "pj_buliao_edit", false, "PJ_BULIAO_EDIT");
        public final static Property Pj_sha_edit = new Property(33, double.class, "pj_sha_edit", false, "PJ_SHA_EDIT");
        public final static Property Lml_width_edit = new Property(34, double.class, "lml_width_edit", false, "LML_WIDTH_EDIT");
        public final static Property Lml_height_edit = new Property(35, double.class, "lml_height_edit", false, "LML_HEIGHT_EDIT");
        public final static Property Lml_unit_edit = new Property(36, double.class, "lml_unit_edit", false, "LML_UNIT_EDIT");
        public final static Property By_width_edit = new Property(37, double.class, "by_width_edit", false, "BY_WIDTH_EDIT");
        public final static Property By_height_edit = new Property(38, double.class, "by_height_edit", false, "BY_HEIGHT_EDIT");
        public final static Property By_unit_edit = new Property(39, double.class, "by_unit_edit", false, "BY_UNIT_EDIT");
        public final static Property Gc_width_edit = new Property(40, double.class, "gc_width_edit", false, "GC_WIDTH_EDIT");
        public final static Property Gc_height_edit = new Property(41, double.class, "gc_height_edit", false, "GC_HEIGHT_EDIT");
        public final static Property Gc_unit_edit = new Property(42, double.class, "gc_unit_edit", false, "GC_UNIT_EDIT");
        public final static Property All_num_edit = new Property(43, double.class, "all_num_edit", false, "ALL_NUM_EDIT");
        public final static Property All_bu_discount_edit = new Property(44, double.class, "all_bu_discount_edit", false, "ALL_BU_DISCOUNT_EDIT");
        public final static Property All_pj_discount_edit = new Property(45, double.class, "all_pj_discount_edit", false, "ALL_PJ_DISCOUNT_EDIT");
    }


    public SuanLiaoDao(DaoConfig config) {
        super(config);
    }
    
    public SuanLiaoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SUAN_LIAO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"NAME\" TEXT," + // 2: name
                "\"DATA\" TEXT," + // 3: data
                "\"CURTAIN_WIDTH_EDIT\" REAL NOT NULL ," + // 4: curtain_width_edit
                "\"CURTAIN_HIGHT_EDIT\" REAL NOT NULL ," + // 5: curtain_hight_edit
                "\"CURTAIN_BEILU_EDIT\" REAL NOT NULL ," + // 6: curtain_beilu_edit
                "\"CURTAIN_BU_EDIT\" REAL NOT NULL ," + // 7: curtain_bu_edit
                "\"CURTAIN_SHA_EDIT\" REAL NOT NULL ," + // 8: curtain_sha_edit
                "\"LMG_QUAN_EDIT\" REAL NOT NULL ," + // 9: lmg_quan_edit
                "\"LMG_GANG_EDIT\" REAL NOT NULL ," + // 10: lmg_gang_edit
                "\"LMG_BU_EDIT\" REAL NOT NULL ," + // 11: lmg_bu_edit
                "\"PB_NUM_EDIT\" REAL NOT NULL ," + // 12: pb_num_edit
                "\"PB_UNIT_EDIT\" REAL NOT NULL ," + // 13: pb_unit_edit
                "\"LT_WIDTH_EDIT\" REAL NOT NULL ," + // 14: lt_width_edit
                "\"LT_UNIT_EDIT\" REAL NOT NULL ," + // 15: lt_unit_edit
                "\"LT_GUIDAO_EDIT\" REAL NOT NULL ," + // 16: lt_guidao_edit
                "\"LT_GUIDAOUNIT_EDIT\" REAL NOT NULL ," + // 17: lt_guidaounit_edit
                "\"LT_HUA_EDIT\" REAL NOT NULL ," + // 18: lt_hua_edit
                "\"LT_HUAUNIT_EDIT\" REAL NOT NULL ," + // 19: lt_huaunit_edit
                "\"LT_MOOSHU_EDIT\" REAL NOT NULL ," + // 20: lt_mooshu_edit
                "\"LT_MOSHUUNIT_EDIT\" REAL NOT NULL ," + // 21: lt_moshuunit_edit
                "\"LT_JIAGONG_EDIT\" REAL NOT NULL ," + // 22: lt_jiagong_edit
                "\"LT_JIAGONGUNIT_EDIT\" REAL NOT NULL ," + // 23: lt_jiagongunit_edit
                "\"GS_UNIT_EDIT\" REAL NOT NULL ," + // 24: gs_unit_edit
                "\"GS_GANG_EDIT\" REAL NOT NULL ," + // 25: gs_gang_edit
                "\"GS_BU_EDIT\" REAL NOT NULL ," + // 26: gs_bu_edit
                "\"PJ_GQNUM_EDIT\" REAL NOT NULL ," + // 27: pj_gqnum_edit
                "\"PJ_GQUNIT_EDIT\" REAL NOT NULL ," + // 28: pj_gqunit_edit
                "\"PJ_HUA_EDIT\" REAL NOT NULL ," + // 29: pj_hua_edit
                "\"PJ_BENGDAI_EDIT\" REAL NOT NULL ," + // 30: pj_bengdai_edit
                "\"PJ_QIANGGOU_EDIT\" REAL NOT NULL ," + // 31: pj_qianggou_edit
                "\"PJ_BULIAO_EDIT\" REAL NOT NULL ," + // 32: pj_buliao_edit
                "\"PJ_SHA_EDIT\" REAL NOT NULL ," + // 33: pj_sha_edit
                "\"LML_WIDTH_EDIT\" REAL NOT NULL ," + // 34: lml_width_edit
                "\"LML_HEIGHT_EDIT\" REAL NOT NULL ," + // 35: lml_height_edit
                "\"LML_UNIT_EDIT\" REAL NOT NULL ," + // 36: lml_unit_edit
                "\"BY_WIDTH_EDIT\" REAL NOT NULL ," + // 37: by_width_edit
                "\"BY_HEIGHT_EDIT\" REAL NOT NULL ," + // 38: by_height_edit
                "\"BY_UNIT_EDIT\" REAL NOT NULL ," + // 39: by_unit_edit
                "\"GC_WIDTH_EDIT\" REAL NOT NULL ," + // 40: gc_width_edit
                "\"GC_HEIGHT_EDIT\" REAL NOT NULL ," + // 41: gc_height_edit
                "\"GC_UNIT_EDIT\" REAL NOT NULL ," + // 42: gc_unit_edit
                "\"ALL_NUM_EDIT\" REAL NOT NULL ," + // 43: all_num_edit
                "\"ALL_BU_DISCOUNT_EDIT\" REAL NOT NULL ," + // 44: all_bu_discount_edit
                "\"ALL_PJ_DISCOUNT_EDIT\" REAL NOT NULL );"); // 45: all_pj_discount_edit
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SUAN_LIAO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SuanLiao entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String data = entity.getData();
        if (data != null) {
            stmt.bindString(4, data);
        }
        stmt.bindDouble(5, entity.getCurtain_width_edit());
        stmt.bindDouble(6, entity.getCurtain_hight_edit());
        stmt.bindDouble(7, entity.getCurtain_beilu_edit());
        stmt.bindDouble(8, entity.getCurtain_bu_edit());
        stmt.bindDouble(9, entity.getCurtain_sha_edit());
        stmt.bindDouble(10, entity.getLmg_quan_edit());
        stmt.bindDouble(11, entity.getLmg_gang_edit());
        stmt.bindDouble(12, entity.getLmg_bu_edit());
        stmt.bindDouble(13, entity.getPb_num_edit());
        stmt.bindDouble(14, entity.getPb_unit_edit());
        stmt.bindDouble(15, entity.getLt_width_edit());
        stmt.bindDouble(16, entity.getLt_unit_edit());
        stmt.bindDouble(17, entity.getLt_guidao_edit());
        stmt.bindDouble(18, entity.getLt_guidaounit_edit());
        stmt.bindDouble(19, entity.getLt_hua_edit());
        stmt.bindDouble(20, entity.getLt_huaunit_edit());
        stmt.bindDouble(21, entity.getLt_mooshu_edit());
        stmt.bindDouble(22, entity.getLt_moshuunit_edit());
        stmt.bindDouble(23, entity.getLt_jiagong_edit());
        stmt.bindDouble(24, entity.getLt_jiagongunit_edit());
        stmt.bindDouble(25, entity.getGs_unit_edit());
        stmt.bindDouble(26, entity.getGs_gang_edit());
        stmt.bindDouble(27, entity.getGs_bu_edit());
        stmt.bindDouble(28, entity.getPj_gqnum_edit());
        stmt.bindDouble(29, entity.getPj_gqunit_edit());
        stmt.bindDouble(30, entity.getPj_hua_edit());
        stmt.bindDouble(31, entity.getPj_bengdai_edit());
        stmt.bindDouble(32, entity.getPj_qianggou_edit());
        stmt.bindDouble(33, entity.getPj_buliao_edit());
        stmt.bindDouble(34, entity.getPj_sha_edit());
        stmt.bindDouble(35, entity.getLml_width_edit());
        stmt.bindDouble(36, entity.getLml_height_edit());
        stmt.bindDouble(37, entity.getLml_unit_edit());
        stmt.bindDouble(38, entity.getBy_width_edit());
        stmt.bindDouble(39, entity.getBy_height_edit());
        stmt.bindDouble(40, entity.getBy_unit_edit());
        stmt.bindDouble(41, entity.getGc_width_edit());
        stmt.bindDouble(42, entity.getGc_height_edit());
        stmt.bindDouble(43, entity.getGc_unit_edit());
        stmt.bindDouble(44, entity.getAll_num_edit());
        stmt.bindDouble(45, entity.getAll_bu_discount_edit());
        stmt.bindDouble(46, entity.getAll_pj_discount_edit());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SuanLiao entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String data = entity.getData();
        if (data != null) {
            stmt.bindString(4, data);
        }
        stmt.bindDouble(5, entity.getCurtain_width_edit());
        stmt.bindDouble(6, entity.getCurtain_hight_edit());
        stmt.bindDouble(7, entity.getCurtain_beilu_edit());
        stmt.bindDouble(8, entity.getCurtain_bu_edit());
        stmt.bindDouble(9, entity.getCurtain_sha_edit());
        stmt.bindDouble(10, entity.getLmg_quan_edit());
        stmt.bindDouble(11, entity.getLmg_gang_edit());
        stmt.bindDouble(12, entity.getLmg_bu_edit());
        stmt.bindDouble(13, entity.getPb_num_edit());
        stmt.bindDouble(14, entity.getPb_unit_edit());
        stmt.bindDouble(15, entity.getLt_width_edit());
        stmt.bindDouble(16, entity.getLt_unit_edit());
        stmt.bindDouble(17, entity.getLt_guidao_edit());
        stmt.bindDouble(18, entity.getLt_guidaounit_edit());
        stmt.bindDouble(19, entity.getLt_hua_edit());
        stmt.bindDouble(20, entity.getLt_huaunit_edit());
        stmt.bindDouble(21, entity.getLt_mooshu_edit());
        stmt.bindDouble(22, entity.getLt_moshuunit_edit());
        stmt.bindDouble(23, entity.getLt_jiagong_edit());
        stmt.bindDouble(24, entity.getLt_jiagongunit_edit());
        stmt.bindDouble(25, entity.getGs_unit_edit());
        stmt.bindDouble(26, entity.getGs_gang_edit());
        stmt.bindDouble(27, entity.getGs_bu_edit());
        stmt.bindDouble(28, entity.getPj_gqnum_edit());
        stmt.bindDouble(29, entity.getPj_gqunit_edit());
        stmt.bindDouble(30, entity.getPj_hua_edit());
        stmt.bindDouble(31, entity.getPj_bengdai_edit());
        stmt.bindDouble(32, entity.getPj_qianggou_edit());
        stmt.bindDouble(33, entity.getPj_buliao_edit());
        stmt.bindDouble(34, entity.getPj_sha_edit());
        stmt.bindDouble(35, entity.getLml_width_edit());
        stmt.bindDouble(36, entity.getLml_height_edit());
        stmt.bindDouble(37, entity.getLml_unit_edit());
        stmt.bindDouble(38, entity.getBy_width_edit());
        stmt.bindDouble(39, entity.getBy_height_edit());
        stmt.bindDouble(40, entity.getBy_unit_edit());
        stmt.bindDouble(41, entity.getGc_width_edit());
        stmt.bindDouble(42, entity.getGc_height_edit());
        stmt.bindDouble(43, entity.getGc_unit_edit());
        stmt.bindDouble(44, entity.getAll_num_edit());
        stmt.bindDouble(45, entity.getAll_bu_discount_edit());
        stmt.bindDouble(46, entity.getAll_pj_discount_edit());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public SuanLiao readEntity(Cursor cursor, int offset) {
        SuanLiao entity = new SuanLiao( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // data
            cursor.getDouble(offset + 4), // curtain_width_edit
            cursor.getDouble(offset + 5), // curtain_hight_edit
            cursor.getDouble(offset + 6), // curtain_beilu_edit
            cursor.getDouble(offset + 7), // curtain_bu_edit
            cursor.getDouble(offset + 8), // curtain_sha_edit
            cursor.getDouble(offset + 9), // lmg_quan_edit
            cursor.getDouble(offset + 10), // lmg_gang_edit
            cursor.getDouble(offset + 11), // lmg_bu_edit
            cursor.getDouble(offset + 12), // pb_num_edit
            cursor.getDouble(offset + 13), // pb_unit_edit
            cursor.getDouble(offset + 14), // lt_width_edit
            cursor.getDouble(offset + 15), // lt_unit_edit
            cursor.getDouble(offset + 16), // lt_guidao_edit
            cursor.getDouble(offset + 17), // lt_guidaounit_edit
            cursor.getDouble(offset + 18), // lt_hua_edit
            cursor.getDouble(offset + 19), // lt_huaunit_edit
            cursor.getDouble(offset + 20), // lt_mooshu_edit
            cursor.getDouble(offset + 21), // lt_moshuunit_edit
            cursor.getDouble(offset + 22), // lt_jiagong_edit
            cursor.getDouble(offset + 23), // lt_jiagongunit_edit
            cursor.getDouble(offset + 24), // gs_unit_edit
            cursor.getDouble(offset + 25), // gs_gang_edit
            cursor.getDouble(offset + 26), // gs_bu_edit
            cursor.getDouble(offset + 27), // pj_gqnum_edit
            cursor.getDouble(offset + 28), // pj_gqunit_edit
            cursor.getDouble(offset + 29), // pj_hua_edit
            cursor.getDouble(offset + 30), // pj_bengdai_edit
            cursor.getDouble(offset + 31), // pj_qianggou_edit
            cursor.getDouble(offset + 32), // pj_buliao_edit
            cursor.getDouble(offset + 33), // pj_sha_edit
            cursor.getDouble(offset + 34), // lml_width_edit
            cursor.getDouble(offset + 35), // lml_height_edit
            cursor.getDouble(offset + 36), // lml_unit_edit
            cursor.getDouble(offset + 37), // by_width_edit
            cursor.getDouble(offset + 38), // by_height_edit
            cursor.getDouble(offset + 39), // by_unit_edit
            cursor.getDouble(offset + 40), // gc_width_edit
            cursor.getDouble(offset + 41), // gc_height_edit
            cursor.getDouble(offset + 42), // gc_unit_edit
            cursor.getDouble(offset + 43), // all_num_edit
            cursor.getDouble(offset + 44), // all_bu_discount_edit
            cursor.getDouble(offset + 45) // all_pj_discount_edit
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SuanLiao entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setData(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCurtain_width_edit(cursor.getDouble(offset + 4));
        entity.setCurtain_hight_edit(cursor.getDouble(offset + 5));
        entity.setCurtain_beilu_edit(cursor.getDouble(offset + 6));
        entity.setCurtain_bu_edit(cursor.getDouble(offset + 7));
        entity.setCurtain_sha_edit(cursor.getDouble(offset + 8));
        entity.setLmg_quan_edit(cursor.getDouble(offset + 9));
        entity.setLmg_gang_edit(cursor.getDouble(offset + 10));
        entity.setLmg_bu_edit(cursor.getDouble(offset + 11));
        entity.setPb_num_edit(cursor.getDouble(offset + 12));
        entity.setPb_unit_edit(cursor.getDouble(offset + 13));
        entity.setLt_width_edit(cursor.getDouble(offset + 14));
        entity.setLt_unit_edit(cursor.getDouble(offset + 15));
        entity.setLt_guidao_edit(cursor.getDouble(offset + 16));
        entity.setLt_guidaounit_edit(cursor.getDouble(offset + 17));
        entity.setLt_hua_edit(cursor.getDouble(offset + 18));
        entity.setLt_huaunit_edit(cursor.getDouble(offset + 19));
        entity.setLt_mooshu_edit(cursor.getDouble(offset + 20));
        entity.setLt_moshuunit_edit(cursor.getDouble(offset + 21));
        entity.setLt_jiagong_edit(cursor.getDouble(offset + 22));
        entity.setLt_jiagongunit_edit(cursor.getDouble(offset + 23));
        entity.setGs_unit_edit(cursor.getDouble(offset + 24));
        entity.setGs_gang_edit(cursor.getDouble(offset + 25));
        entity.setGs_bu_edit(cursor.getDouble(offset + 26));
        entity.setPj_gqnum_edit(cursor.getDouble(offset + 27));
        entity.setPj_gqunit_edit(cursor.getDouble(offset + 28));
        entity.setPj_hua_edit(cursor.getDouble(offset + 29));
        entity.setPj_bengdai_edit(cursor.getDouble(offset + 30));
        entity.setPj_qianggou_edit(cursor.getDouble(offset + 31));
        entity.setPj_buliao_edit(cursor.getDouble(offset + 32));
        entity.setPj_sha_edit(cursor.getDouble(offset + 33));
        entity.setLml_width_edit(cursor.getDouble(offset + 34));
        entity.setLml_height_edit(cursor.getDouble(offset + 35));
        entity.setLml_unit_edit(cursor.getDouble(offset + 36));
        entity.setBy_width_edit(cursor.getDouble(offset + 37));
        entity.setBy_height_edit(cursor.getDouble(offset + 38));
        entity.setBy_unit_edit(cursor.getDouble(offset + 39));
        entity.setGc_width_edit(cursor.getDouble(offset + 40));
        entity.setGc_height_edit(cursor.getDouble(offset + 41));
        entity.setGc_unit_edit(cursor.getDouble(offset + 42));
        entity.setAll_num_edit(cursor.getDouble(offset + 43));
        entity.setAll_bu_discount_edit(cursor.getDouble(offset + 44));
        entity.setAll_pj_discount_edit(cursor.getDouble(offset + 45));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(SuanLiao entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(SuanLiao entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SuanLiao entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
