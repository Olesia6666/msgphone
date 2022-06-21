package com.example.msgphone.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/********请用getDataBaseHelper获取实例
 * @Example 使用表名直接调用 DataBaseHelper.xxx_TABLE ***************/

public class DataBaseHelper extends SQLiteOpenHelper {
    /*******数据库名*****/
    public static final String DATABASE_NAME = "MyNews.db";
    /*******表名*****/
    public static final String BOOK_ITEM_INFO_TABLE = "bookiteminfo";
    public static final String SHOPPING_CART_ITEM_TABLE = "shoppingcartitem";
    public static final String USER_BOUGHT_ITEM_TABLE = "userboughtitem";
    public static final String USER_INFO_TABLE = "userinfo";
    public static final String BROWSING_HISTORY_TABLE = "browsinghistory";
    /******************/


    private static final int DATABASE_VERSION = 1;

    private static final String BOOK_ITEM_INFO_SQL =
            "create table " +
                    BOOK_ITEM_INFO_TABLE + "(" +
                    "bookId varchar(64) PRIMARY KEY not null," +
                    "bookName varchar(64)," +
                    "bookAuthor varchar(64)," +
                    "introduction TEXT," +
                    "iconPath varchar(64)" +
                    ");";

    private static final String SHOPPING_CART_ITEM_SQL =
            "create table " +
                    SHOPPING_CART_ITEM_TABLE + "(" +
                    "itemId varchar(64) PRIMARY KEY not null," +
                    "userId varchar(64) not null ," +
                    "bookId varchar(64)  not null" +
                    ");";


    private static final String USER_BOUGHT_ITEM_SQL =
            "create table " +
                    USER_BOUGHT_ITEM_TABLE + "(" +
                    "itemId varchar(64)  PRIMARY KEY not null," +
                    "bookId varchar(64) not null," +
                    "userId varchar(64) not null" +
                    ");";


    private static final String USER_INFO_SQL =
            "create table " +
                    USER_INFO_TABLE + "(" +
                    "userId varchar(64) PRIMARY KEY not null," +
                    "userName varchar(64)  not null," +
                    "userPassword varchar(64)  not null," +
                    "iconPath varchar(64)" +
                    ");";

    private static final String BROWSING_HISTORY_SQL =
            "create table " +
                    BROWSING_HISTORY_TABLE + "(" +
                    "historyId varchar(64) PRIMARY KEY not null," +
                    "userId varchar(64) not null, " +
                    "bookId varchar(64) not null," +
                    "date Date" +
                    ");";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BOOK_ITEM_INFO_SQL);
        db.execSQL(USER_BOUGHT_ITEM_SQL);
        db.execSQL(SHOPPING_CART_ITEM_SQL);
        db.execSQL(USER_INFO_SQL);
        db.execSQL(BROWSING_HISTORY_SQL);
        setDefaultData(db);
    }

    private void setDefaultData(SQLiteDatabase db){
        String insertSql = "insert into bookiteminfo(bookId,bookName,bookAuthor,introduction,iconPath) values(?,?,?,?,?)";
        db.execSQL(insertSql, new Object[]{"1", "学校召开新图书馆内部建设", "苏平", "会上，北京大道致和文化有限公司设计师简要汇报了新图书馆空间布局及文化环境系统设计修订方案有关内容。图书馆馆长表示，新图书馆搬迁工作已到关键时刻，根据学校党委常委会会议精神，结合前期工作情况，就近期及暑期工作需要各相关职能部门配合开展的主要工作进行了说明。各部门负责人均表示，将认真贯彻落实学校党委常委会会议精神和要求，按照部门职责、主动对接、积极配合图书馆做好新馆内部建设及搬迁工作。" +
                "萧懿群充分肯定了图书馆全体职工近期的辛勤付出和工作情况，同时感谢相关部门的支持和配合。他指出，学校新图书馆内部建设及搬迁工作任务重、时间紧，需要举全校之力推动项目实施和各项工作落实。对此，他提出三点工作要求，一是根据统一部署，提前谋划，加强分工协作，全面做好新图书馆开馆准备；二是各部门继续加强配合和支持力度，多沟通、多协调、不推拖、不推责，齐心协力相向而行；三是各部门要尽早安排好暑期工作，确保图书馆搬迁工作实现“分类分步实施项目，分阶段分区域开放”的目标。", "p1.png"});

        insertSql = "insert into bookiteminfo(bookId,bookName,bookAuthor,introduction,iconPath) values(?,?,?,?,?)";
        db.execSQL(insertSql, new Object[]{"2", "青春遇研途，不负韶华年", "吴世钰", "季忆留夏、时光有你。为了营造良好的毕业氛围，加强毕业教育，加深毕业生与母校之间的感情，6月16日上午，“致敬甘农时光：2022届研究生毕业游园”活动在彤笙广场拉开序幕，毕业学子与学校领导、老师一起参加游园活动，同走校园路，共叙母校情。此次活动由党委研究生工作部、研究生院、国际教育学院、校团委联合举办，校研究生会承办。" +
                "本次活动吸引了2022届毕业研究生、留学生的广泛参与。充满着青春朝气的游园队伍，集体身着“研在甘农”T恤、佩戴“研在甘农”手环、手持祝福彩旗，从彤笙广场出发，依次穿过伏羲堂、运动场草坪实训基地、百草园、羲园、认知馆和新图书馆。国际留学生载歌载舞、校史知识互动抢答、在校生深情祝福、签名墙前书写毕业感言……大家重走昔日校园景点，每到一处都拍照、打卡，一幅幅照片是毕业生们在甘农生活的见证，是他们对于美丽校园留恋的见证，是他们一段生命历程结束的见证，同时也是他们新的人生开始的见证。", "p2.png"});

        insertSql = "insert into bookiteminfo(bookId,bookName,bookAuthor,introduction,iconPath) values(?,?,?,?,?)";
        db.execSQL(insertSql, new Object[]{"3", "学校召开本科教育教学研讨会", "刘洋豪", "各学院围绕“十四五”期间本科教育教学改革、专业建设、课程建设、人才培养模式、教材建设、实践教学、教学信息化建设、教师教学能力提升等内容进行了交流发言。农学院院长李玲玲在交流发言中提出要以一流本科专业建设为契机，推进专业——课程——教材一体化建设。财经学院院长吕剑平建议设置专业负责人，加强老中青三代教师间交流，创设教师热爱教学、重视教学研究的氛围，充分调动新任教师知农爱农的情怀和使命。生命科学技术学院院长司怀军就本科实践教学基地校内外建设，构建虚拟教研室，拓展实验平台提出建议。人文学院院长赵丽萍建议在制度层面对线上教学、混合式教学提出标准和要求，确保线上线下教学等质同效。并提出要扎根时代生活，遵循美育特点，加强美育教育，促进青年学生身心都健康成长。水利水电学院院长齐广平提出加强虚拟仿真实验教学平台建设，构建虚实结合、线上线下结合的实验教学新模式。动物医学院副院长包世俊建议结合“劳动教育”和“耕读教育”，引导学生形成马克思主义劳动观。充分利用校外高端人才资源，形成“教—研—产—学—用”协同育人机制，切实推进产教融合。体育教学部副主任胡有宏提出要继续加强体育教育，拓展开设丰富多样的体育课程，全面提升学生素质。其他各学院院长也分别就本科人才培养模式、一流本科支撑保障体系建设、强化实践教学、一流课程建设方面进行了发言。", "p3.png"});

        insertSql = "insert into bookiteminfo(bookId,bookName,bookAuthor,introduction,iconPath) values(?,?,?,?,?)";
        db.execSQL(insertSql, new Object[]{"4", "学校召开2022年全面从严治党工作会议", "张馨正", "6月7日，学校召开2022年全面从严治党工作会议，学习传达了十九届中央纪委六次全会、省十四次党代会、省纪委十三届六次全会精神以及全省教育系统全面从严治党工作会议精神。会议紧跟新时代全面从严治党工作的新内容、新要求、新导向，坚定不移推进学校全面从严治党工作向纵深发展，以实际行动迎接党的二十大胜利召开。会上，校党委书记赵凯与校领导班子成员，基层党组织负责人签订了《2022年履行全面从严治党和党风廉政建设责任书》，并从深刻理解全面从严治党工作的新形势和新要求，牢牢把握今年学校全面从严治党工作重点和任务，深化党风廉政建设、持续维护良好的政治生态三个方面，就进一步推动学校全面从严治党工作提出了明确要求。他指出，要以习近平总书记重要讲话精神为遵循，站稳政治立场、坚定政治方向，自觉把思想和行动统一到党中央决策部署上来，把组织、制度优势更好的转化为治理效能，切实发挥全面从严治党的引领保障作用。要把学习贯彻省十四次党代会精神作为当前和今后一个时期的重要政治任务，深学细研会议精神，切实把思想和行动凝聚到大会确定的各项目标任务上来，聚焦主责主业，一以贯之落实全面从严治党战略方针。要不断夯实从严治党主体责任，持之以恒加强干部队伍建设，不断提升基层党组织的组织力，在作风建设、纪律建设、强化监督上见成效，扎实推进学校全面从严治党工作，为学校事业高质量发展提供坚强政治保障。", "p4.png"});

        insertSql = "insert into bookiteminfo(bookId,bookName,bookAuthor,introduction,iconPath) values(?,?,?,?,?)";
        db.execSQL(insertSql, new Object[]{"5", "学校统战人士赴榆中县开展集体调研", "刘洋豪", "6月2日，学校组织各民主党派和无党派人士赴榆中县开展“喜迎二十大 同心跟党走”集体调研，并举行了“甘肃农业大学统战人士社会服务学习教育实践基地”和“民建甘肃农大支部科技服务基地”挂牌仪式。党委副书记廉志端，党委常委、副校长芦维忠，党委常委闫述乾，各民主党派基层组织（统战团体）主要负责人、部分党外代表人士、民建农大支部全体会员等20余人参加。民建中央委员、省政协常委、民建省委会副主委、兰州虹盛商贸集团有限公司董事长蔡根泉，民建省委会组宣部副部长鲁彬应邀出席本次活动。"
                , "p5.png"});

    }


    public void insertDatas(String id,String title,String author,String content,String icon) {
        String insertSql = "insert into bookiteminfo(bookId,bookName,bookAuthor,introduction,iconPath) values(?,?,?,?,?)";
        dataBaseHelper.getReadableDatabase().execSQL(insertSql, new Object[]{id, title, author, content, icon});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private volatile static DataBaseHelper dataBaseHelper = null;

    public static synchronized DataBaseHelper getDataBaseHelper(Context context) {
        if (dataBaseHelper == null) {
            dataBaseHelper = new DataBaseHelper(context);
        }
        return dataBaseHelper;
    }
}
