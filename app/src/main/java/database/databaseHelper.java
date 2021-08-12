package database;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class databaseHelper extends SQLiteOpenHelper {
    public static int VERSION = 9;
    public static String NOME_DB = "OscarTrackerDB";
    public static String TABELA_FILME = "filme";
    public static String TABELA_CATEGORIA_FILME = "categoriaFilme";
    public static String TABELA_CATEGORIA = "categoria";

    public databaseHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    public void execTableCreation(SQLiteDatabase db, String sql, String table_name){
        try{
            db.execSQL(sql);
            Log.i("INFO BANCODEDADOS", "Sucesso ao criar a tabela "+table_name );
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao criar a tabela "+table_name + e.getMessage() );
        }
    }

    public void instantiate_filme(SQLiteDatabase db, String nome, Integer duracao, String descricao, String caminhoImagem){
        try{
            ContentValues movie_insert = new ContentValues();
            movie_insert.put("nome", nome);
            movie_insert.put("duracao", duracao);
            movie_insert.put("descricao", descricao);
            movie_insert.put("caminhoImagem", caminhoImagem);
            db.insert(TABELA_FILME, null, movie_insert);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao instanciar filme "+nome+ e.getMessage());
        }
    }

    public void populate_filme(SQLiteDatabase db){
        try{
            instantiate_filme(db,
                    "Minari",
                    115,
                    "A Korean American family moves to an Arkansas farm in " +
                            "search of its own American dream. Amidst the challenges of this new " +
                            "life in the strange and rugged Ozarks, they discover the undeniable " +
                            "resilience of family and what really makes a home.",
                    "image_minari_cover");

            instantiate_filme(db,
                    "Judas and the Black Messiah",
                    126,
                    "Fred Hampton, a young, charismatic activist, becomes Chairman " +
                            "of the Illinois chapter of the Black Panther Party - putting him " +
                            "directly in the crosshairs of the government, the FBI, and the " +
                            "Chicago Police. But to destroy the revolution, the authorities are " +
                            "going to need a man on the inside.",
                    "image_black_messiah_cover");

            instantiate_filme(db, "Nomadland",
                    107,
                    "A woman in her sixties, after losing everything in the Great " +
                            "Recession, embarks on a journey through the American West, living " +
                            "as a van-dwelling modern-day nomad.",
                    "image_nomadland_cover");

            instantiate_filme(db, "Quo Vadis, Aida?",
                    101,
                    "Bosnia, July 1995. Aida is a translator for the UN in the small " +
                            "town of Srebrenica. When the Serbian army takes over the town, her " +
                            "family is among the thousands of citizens looking for shelter in the " +
                            "UN camp. As an insider to the negotiations Aida has access to crucial " +
                            "information that she needs to interpret. What is at the horizon for her " +
                            "family and people - rescue or death? Which move should she take?",
                    "image_quo_vadis_cover");

            instantiate_filme(db, "Collective",
                    109,
                    "Director Alexander Nanau follows a crack team of investigators at " +
                            "the Romanian newspaper Gazeta Sporturilor as they try to uncover a " +
                            "vast health-care fraud that enriched moguls and politicians and led " +
                            "to the deaths of innocent citizens.",
                    "image_collective_cover");

            instantiate_filme(db, "Opera",
                    9,
                    "Our society and history, which is filled with beauty and absurdity",
                    "image_opera_cover");

            instantiate_filme(db, "Mank",
                    131,
                    "1940. Film studio RKO hires 24-year-old wunderkind Orson Welles " +
                            "under a contract that gives him full creative control of his movies. " +
                            "For his first film, he calls in washed-up alcoholic Herman J Mankiewicz " +
                            "to write the screenplay. That film is \"Citizen Kane,\" and this is " +
                            "the story of how it was written.",
                    "image_mank_cover");
            instantiate_filme(db, "Soul",
                    100,
                    "Joe is a middle-school band teacher whose life hasn't quite gone the " +
                            "way he expected. His true passion is jazz -- and he's good. But when " +
                            "he travels to another realm to help someone find their passion, he " +
                            "soon discovers what it means to have soul.",
                    "image_soul_cover");

            instantiate_filme(db, "Sound of Metal",
                    120,
                    "A heavy-metal drummer's life is thrown into freefall when he begins " +
                            "to lose his hearing.",
                    "image_sound_metal_cover");

            instantiate_filme(db, "Da 5 Bloods",
                    154,
                    "Four African-American vets battle the forces of man and nature when " +
                            "they return to Vietnam seeking the remains of their fallen squad " +
                            "leader and the gold fortune he helped them hide.",
                    "image_da_five_cover");

            instantiate_filme(db, "Promising Young Woman",
                    113,
                    "A young woman, traumatized by a tragic event in her past, seeks " +
                            "out vengeance against those who crossed her path.",
                    "image_promising_cover");

            instantiate_filme(db, "Tenet",
                    150,
                    "Armed with only one word, Tenet, and fighting for the survival of " +
                            "the entire world, a Protagonist journeys through a twilight world of " +
                            "international espionage on a mission that will unfold in something " +
                            "beyond real time.",
                    "image_tenet_cover");
            instantiate_filme(db, "Ma Rainey's Black Bottom",
                    94,
                    "Tensions rise when trailblazing blues singer Ma Rainey and her " +
                            "band gather at a recording studio in Chicago in 1927.",
                    "image_ma_rainey_cover");

            instantiate_filme(db, "Time",
                    81,
                    "Fox Rich fights for the release of her husband, Rob, who is " +
                            "serving a 60-year sentence in prison.",
                    "image_time_cover");

            instantiate_filme(db, "The Father",
                    97,
                    "A man refuses all assistance from his daughter as he ages. As he " +
                            "tries to make sense of his changing circumstances, he begins to doubt " +
                            "his loved ones, his own mind and even the fabric of his reality.",
                    "image_father_cover");

            instantiate_filme(db, "Do Not Split",
                    35,
                    "In 2019 Hong Kong was rocked by the largest protests since Britain " +
                            "handed back the area to China in 1997. This is the story of the " +
                            "protests, told through a series of demonstrations by local protesters " +
                            "that escalate into conflict when highly armed police appear on the scene.",
                    "image_not_split_cover");

            instantiate_filme(db, "Burrow",
                    6,
                    "A young rabbit tries to build the burrow of her dreams, becoming " +
                            "embarrassed each time she accidentally digs into a neighbor's home.",
                    "image_burrow_cover");

            instantiate_filme(db, "Wolfwalkers",
                    103,
                    "A young apprentice hunter and her father journey to Ireland to " +
                            "help wipe out the last wolf pack. But everything changes when she " +
                            "befriends a free-spirited girl from a mysterious tribe rumored to " +
                            "transform into wolves by night.",
                    "image_wolfwalkers_cover");

            instantiate_filme(db, "Emma",
                    124,
                    "In 1800s England, a well meaning but selfish young woman meddles " +
                            "in the love lives of her friends.",
                    "image_emma_cover");

            instantiate_filme(db, "Another Round",
                    117,
                    "Four high school teachers consume alcohol on a daily basis to " +
                            "see how it affects their social and professional lives.",
                    "image_another_round_cover");

            instantiate_filme(db, "Colette",
                    24,
                    "In Nazi-occupied France, resistance took courage. Seventy-five " +
                            "years later, facing one's ghosts may take even more.",
                    "image_colette_cover");

            instantiate_filme(db, "The Trial of the Chicago 7",
                    129,
                    "What was intended to be a peaceful protest at the 1968 Democratic " +
                            "National Convention turned into a violent clash with police and " +
                            "the National Guard. The organizers of the protest--including " +
                            "Abbie Hoffman, Jerry Rubin, Tom Hayden, and Bobby Seale--were " +
                            "charged with conspiracy to incite a riot. The trial that followed" +
                            " was one of the most notorious in history.",
                    "image_trial_cover");

            instantiate_filme(db, "Feeling Through",
                    18,
                    "A late-night encounter on a New York City street leads to a " +
                            "profound connection between a teen-in-need and a DeafBlind man.",
                    "image_feeling_cover");

            instantiate_filme(db, "The Mole Agent",
                    84,
                    "A private investigator in Chile hires someone to work as a mole " +
                            "at a retirement home where a client of his suspects the caretakers " +
                            "of elder abuse.",
                    "image_mole_cover");

            instantiate_filme(db, "A Love Song for Latasha",
                    19,
                    "\n" +
                            "\n" +
                            "The injustice surrounding the shooting death of 15-year-old " +
                            "Latasha Harlins at a South Central Los Angeles store became a " +
                            "flashpoint for the city’s 1992 civil uprising.",
                    "image_latasha_cover");

            instantiate_filme(db, "Hunger Ward",
                    40,
                    "Filmed from inside two of the most active therapeutic feeding " +
                            "centers in Yemen, Hunger Ward documents two female health care " +
                            "workers fighting to thwart the spread of starvation against the " +
                            "backdrop of a forgotten war. The film provides an unflinching " +
                            "portrait of Dr. Aida Alsadeeq and Nurse Mekkia Mahdi as they try " +
                            "to save the lives of hunger-stricken children within a population " +
                            "on the brink of famine.",
                    "image_hunger_cover");

            instantiate_filme(db, "One Night in Miami",
                    114,
                    "A fictional account of one incredible night where icons Muhammad " +
                            "Ali, Malcolm X, Sam Cooke, and Jim Brown gathered discussing their " +
                            "roles in the Civil Rights Movement and cultural upheaval of the 60s.",
                    "image_miami_cover");

            instantiate_filme(db, "White Eye",
                    20,
                    "A man finds his stolen bicycle, which now belongs to a stranger. " +
                            "While attempting to retrieve it, he struggles to remain human.",
                    "image_white_eye_cover");

            instantiate_filme(db, "Crip Camp",
                    106,
                    "Down the road from Woodstock, a revolution blossomed at a ramshackle " +
                            "summer camp for teenagers with disabilities, transforming their lives " +
                            "and igniting a landmark movement.",
                    "image_crip_camp_cover");

            instantiate_filme(db, "A Concerto is a Conversation",
                    13,
                    "A virtuoso jazz pianist and film composer tracks his family's " +
                            "lineage through his 91-year-old grandfather from Jim Crow Florida " +
                            "to the Walt Disney Concert Hall.",
                    "image_concerto_conversation_cover");

            instantiate_filme(db, "The Man Who Sold His Skin",
                    104,
                    "His own body turned into a living work of art and promptly " +
                            "exhibited in a museum, Sam, a Syrian refugee, will soon realize " +
                            "to have sold away more than just his skin.",
                    "image_sold_skin_cover");

            instantiate_filme(db, "Pinocchio",
                    125,
                    "Old woodcarver Geppetto's puppet creation, Pinocchio, magically " +
                            "comes to life with dreams of becoming a real boy. Easily led astray, " +
                            "Pinocchio tumbles from one misadventure to another as he is tricked, " +
                            "kidnapped and chased by bandits.",
                    "image_pinocchio_cover");

            instantiate_filme(db, "The Letter Room",
                    33,
                    "When a corrections officer is transferred to the letter room, he " +
                            "soon finds himself enmeshed in a prisoner's deeply private life.",
                    "image_letter_room_cover");

            instantiate_filme(db, "Two Distant Strangers",
                    32,
                    "A man trying to get home to his dog gets stuck in a time loop " +
                            "that forces him to relive a deadly run-in with a cop.",
                    "image_two_distant_cover");

            instantiate_filme(db, "Genius Loci",
                    16,
                    "One night, Reine, a young loner, sees the urban chaos as a " +
                            "mystical oneness that seems alive, like some sort of guide.",
                    "image_genius_loci_cover");

            instantiate_filme(db, "The White Tiger",
                    125,
                    "An ambitious Indian driver uses his wit and cunning to escape " +
                            "from poverty and rise to the top. An epic journey based on the " +
                            "New York Times bestseller.",
                    "image_white_tiger_cover");

            instantiate_filme(db, "Eurovision Song Contest: The Story of Fire Saga",
                    123,
                    "When aspiring musicians Lars and Sigrit are given the opportunity " +
                            "to represent their country at the world's biggest song competition, " +
                            "they finally have a chance to prove that any dream worth having is " +
                            "a dream worth fighting for.",
                    "image_eurovision_cover");

            instantiate_filme(db, "The Present",
                    24,
                    "On his wedding anniversary, Yusef and his young daughter set out " +
                            "in the West Bank to buy his wife a gift. Between soldiers, " +
                            "segregated roads and checkpoints, how easy would it be to go " +
                            "shopping?",
                    "image_present_cover");

            instantiate_filme(db, "News of the World",
                    118,
                    "A Civil War veteran agrees to deliver a girl, taken by the Kiowa " +
                            "people years ago, to her aunt and uncle, against her will. They " +
                            "travel hundreds of miles and face grave dangers as they search " +
                            "for a place that either can call home.",
                    "image_news_world_cover");

            instantiate_filme(db, "Onward",
                    102,
                    "Two elven brothers embark on a quest to bring their father back " +
                            "for one day.",
                    "image_onward_cover");

            instantiate_filme(db, "If Anything Happens I Love You",
                    13,
                    "In the aftermath of tragedy, two grieving parents journey through " +
                            "an emotional void as they mourn the loss of a child.",
                    "image_if_anything_cover");

            instantiate_filme(db, "Better Days",
                    135,
                    "A bullied teenage girl forms an unlikely friendship with a " +
                            "mysterious young man who protects her from her assailants, all " +
                            "while she copes with the pressures of her final examinations.",
                    "image_better_days_cover");

            instantiate_filme(db, "The United States vs. Billie Holiday",
                    126,
                    "Follows Holiday during her career as she is targeted by the " +
                            "Federal Department of Narcotics with an undercover sting operation " +
                            "led by black Federal Agent Jimmy Fletcher, with whom she has a " +
                            "tumultuous affair.",
                    "image_billie_holiday_cover");

            instantiate_filme(db, "My Octopus Teacher",
                    85,
                    "A filmmaker forges an unusual friendship with an octopus living " +
                            "in a South African kelp forest, learning as the animal shares the " +
                            "mysteries of her world.",
                    "image_octopus_cover");

            instantiate_filme(db, "The Life Ahead",
                    94,
                    "In seaside Italy, a Holocaust survivor with a daycare business " +
                            "takes in a 12-year-old street kid who recently robbed her.",
                    "image_life_ahead_cover");

            instantiate_filme(db, "Mulan",
                    115,
                    "A young Chinese maiden disguises herself as a male warrior " +
                            "in order to save her father.",
                    "image_mulan_cover");

            instantiate_filme(db, "Love and Monsters",
                    109,
                    "Seven years after he survived the monster apocalypse, lovably " +
                            "hapless Joel leaves his cozy underground bunker behind on a " +
                            "quest to reunite with his ex.",
                    "image_love_monsters_cover");

            instantiate_filme(db, "A Shaun the Sheep Movie: Farmageddon",
                    86,
                    "When an alien with amazing powers crash-lands near Mossy Bottom " +
                            "Farm, Shaun the Sheep goes on a mission to shepherd the " +
                            "intergalactic visitor home before a sinister organization can " +
                            "capture her.",
                    "image_shaun_cover");

            instantiate_filme(db, "Pieces of a Woman",
                    126,
                    "When a young mother's home birth ends in unfathomable tragedy, " +
                            "she begins a year-long odyssey of mourning that fractures " +
                            "relationships with loved ones in this deeply personal story " +
                            "of a woman learning to live alongside her loss.",
                    "image_pieces_woman_cover");

            instantiate_filme(db, "Greyhound",
                    91,
                    "Several months after the U.S. entry into World War II, an " +
                            "inexperienced U.S. Navy commander must lead an Allied convoy " +
                            "being stalked by a German submarine wolf pack.",
                    "image_greyhound_cover");

            instantiate_filme(db, "Over the Moon",
                    95,
                    "In this animated musical, a girl builds a rocket ship and blasts " +
                            "off, hoping to meet a mythical moon goddess.",
                    "image_over_moon_cover");

            instantiate_filme(db, "Borat Subsequent Moviefilm",
                    95,
                    "Borat returns from Kazakhstan to America and this time he reveals " +
                            "more about the American culture, the COVID-19 pandemic and the " +
                            "political elections.",
                    "image_borat_cover");

            instantiate_filme(db, "The One and Only Ivan",
                    95,
                    "A gorilla named Ivan tries to piece together his past with the " +
                            "help of an elephant named Ruby as they hatch a plan to escape from " +
                            "captivity.",
                    "image_ivan_cover");

            instantiate_filme(db, "Yes-People",
                    8,
                    "People living in the same apartment block go about their daily " +
                            "lives and daily routines whilst only uttering the word 'Yes' in " +
                            "several different iterations.",
                    "image_yes_people_cover");

            instantiate_filme(db, "Hillbilly Elegy",
                    116,
                    "An urgent phone call pulls a Yale Law student back to his Ohio " +
                            "hometown, where he reflects on three generations of family history " +
                            "and his own future.",
                    "image_hillbilly_cover");

            instantiate_filme(db, "The Midnight Sky",
                    118,
                    "This post-apocalyptic tale follows Augustine, a lonely scientist " +
                            "in the Arctic, as he races to stop Sully and her fellow astronauts " +
                            "from returning home to a mysterious global catastrophe.",
                    "image_midnight_sky_cover");

            Log.i("INFO BANCODEDADOS", "Sucesso ao popular a tabela "+TABELA_FILME);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao popular a tabela filme"+ e.getMessage());
        }
    }

    public void create_filme_table(SQLiteDatabase db){
        String sql_create_filme = "CREATE TABLE IF NOT EXISTS " + TABELA_FILME +"("+
                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL, " +
                " duracao INTEGER NOT NULL, "+
                " descricao TEXT NOT NULL, " +
                " caminhoImagem TEXT NOT NULL," +
                " jaViu INTEGER DEFAULT 0" +
                ");";

        execTableCreation(db, sql_create_filme, TABELA_FILME);
        populate_filme(db);
    }

    public void instantiate_categoria_filme(SQLiteDatabase db, Integer id_categoria, Integer id_filme, String indicado, String caminhoImagemIndicado, Integer nomeacao_repetida_na_categoria){
        try{
            ContentValues movie_category_insert = new ContentValues();
            movie_category_insert.put("id_categoria", id_categoria);
            movie_category_insert.put("id_filme", id_filme);
            movie_category_insert.put("indicado", indicado);
            movie_category_insert.put("caminhoImagemIndicado", caminhoImagemIndicado);
            movie_category_insert.put("nomeacao_repetida_na_categoria", nomeacao_repetida_na_categoria);
            db.insert(TABELA_CATEGORIA_FILME, null, movie_category_insert);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao instanciar filmeCategoria (" +
                    ""+Integer.toString(id_categoria)+","+Integer.toString(id_filme)+")"+ e.getMessage());
        }
    }

    public void instantiate_categoria_filme(SQLiteDatabase db, Integer id_categoria, Integer id_filme, String indicado, String caminhoImagemIndicado){
        try{
            ContentValues movie_category_insert = new ContentValues();
            movie_category_insert.put("id_categoria", id_categoria);
            movie_category_insert.put("id_filme", id_filme);
            movie_category_insert.put("indicado", indicado);
            movie_category_insert.put("caminhoImagemIndicado", caminhoImagemIndicado);
            db.insert(TABELA_CATEGORIA_FILME, null, movie_category_insert);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao instanciar filmeCategoria (" +
                    ""+Integer.toString(id_categoria)+","+Integer.toString(id_filme)+")"+ e.getMessage());
        }
    }

    public void instantiate_categoria_filme(SQLiteDatabase db, Integer id_categoria, Integer id_filme){
        try{
            ContentValues movie_category_insert = new ContentValues();
            movie_category_insert.put("id_categoria", id_categoria);
            movie_category_insert.put("id_filme", id_filme);
            db.insert(TABELA_CATEGORIA_FILME, null, movie_category_insert);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao instanciar filmeCategoria (" +
                    ""+Integer.toString(id_categoria)+","+Integer.toString(id_filme)+")"+ e.getMessage());
        }
    }

    public void populate_categoria_filme(SQLiteDatabase db){
        try{
            instantiate_categoria_filme(db, 1,  1, "Steven Yeun", "image_minari_actor");
            instantiate_categoria_filme(db, 3,  1, "Yuh-Jung Youn", "image_minari_sup_actress");
            instantiate_categoria_filme(db, 8,  1, "Lee Isaac Chung", "image_minari_direct");
            instantiate_categoria_filme(db, 14, 1);
            instantiate_categoria_filme(db, 16, 1);
            instantiate_categoria_filme(db, 23, 1);
            instantiate_categoria_filme(db, 16, 2);
            instantiate_categoria_filme(db, 2,  2, "LaKeith Stanfield", "image_black_messiah_lakeith");
            instantiate_categoria_filme(db, 2,  2, "Daniel Kaluuya","image_black_messiah_kaluuya", 2);
            instantiate_categoria_filme(db, 23, 2);
            instantiate_categoria_filme(db, 15, 2);
            instantiate_categoria_filme(db, 6,  2);
            instantiate_categoria_filme(db, 16, 3);
            instantiate_categoria_filme(db, 8,  3, "Chloé Zhao", "image_nomadland_direct");
            instantiate_categoria_filme(db, 3,  3, "Frances McDormand", "image_nomadland_actress");
            instantiate_categoria_filme(db, 22, 3);
            instantiate_categoria_filme(db, 6,  3);
            instantiate_categoria_filme(db, 11, 3);
            instantiate_categoria_filme(db, 12, 4);
            instantiate_categoria_filme(db, 9,  5);
            instantiate_categoria_filme(db, 12, 5);
            instantiate_categoria_filme(db, 18, 6);
            instantiate_categoria_filme(db, 13, 7);
            instantiate_categoria_filme(db, 20, 7);
            instantiate_categoria_filme(db, 14, 7);
            instantiate_categoria_filme(db, 7,  7);
            instantiate_categoria_filme(db, 17, 7);
            instantiate_categoria_filme(db, 6,  7);
            instantiate_categoria_filme(db, 4,  7, "Amanda Seyfried", "image_mank_sup_actress");
            instantiate_categoria_filme(db, 1,  7, "Gary Oldman", "image_mank_actor");
            instantiate_categoria_filme(db, 8,  7, "David Fincher", "image_mank_direct");
            instantiate_categoria_filme(db, 16, 7);
            instantiate_categoria_filme(db, 14, 8);
            instantiate_categoria_filme(db, 20, 8);
            instantiate_categoria_filme(db, 5,  8);
            instantiate_categoria_filme(db, 16, 9);
            instantiate_categoria_filme(db, 1,  9, "Riz Ahmed", "image_sound_metal_actor");
            instantiate_categoria_filme(db, 2,  9, "Paul Raci", "image_sound_metal_sup_actor");
            instantiate_categoria_filme(db, 23, 9);
            instantiate_categoria_filme(db, 20, 9);
            instantiate_categoria_filme(db, 11, 9);
            instantiate_categoria_filme(db, 14, 11);
            instantiate_categoria_filme(db, 16, 11);
            instantiate_categoria_filme(db, 8,  11, "Carey Mulligan", "image_promising_actress");
            instantiate_categoria_filme(db, 3,  11, "Emerald Fennell", "image_promising_direct");
            instantiate_categoria_filme(db, 23, 11);
            instantiate_categoria_filme(db, 11, 11);
            instantiate_categoria_filme(db, 17, 12);
            instantiate_categoria_filme(db, 21, 12);
            instantiate_categoria_filme(db, 1,  13, "Chadwick Boseman", "image_ma_rainey_actor");
            instantiate_categoria_filme(db, 3,  13, "Viola Davis", "image_ma_rainey_actress");
            instantiate_categoria_filme(db, 7,  13);
            instantiate_categoria_filme(db, 17, 13);
            instantiate_categoria_filme(db, 13, 13);
            instantiate_categoria_filme(db, 9,  14);
            instantiate_categoria_filme(db, 16, 15);
            instantiate_categoria_filme(db, 1,  15, "Anthony Hopkins", "image_father_actor");
            instantiate_categoria_filme(db, 4,  15, "Olivia Colman", "image_father_sup_actress");
            instantiate_categoria_filme(db, 22, 15);
            instantiate_categoria_filme(db, 17, 15);
            instantiate_categoria_filme(db, 11, 15);
            instantiate_categoria_filme(db, 10, 16);
            instantiate_categoria_filme(db, 18, 17);
            instantiate_categoria_filme(db, 5,  18);
            instantiate_categoria_filme(db, 7,  19);
            instantiate_categoria_filme(db, 13, 19);
            instantiate_categoria_filme(db, 8,  20, "Thomas Vinterberg", "image_another_round_direct");
            instantiate_categoria_filme(db, 12, 20);
            instantiate_categoria_filme(db, 10, 21);
            instantiate_categoria_filme(db, 16, 22);
            instantiate_categoria_filme(db, 2,  22, "Sacha Baron Cohen", "image_trial_actor");
            instantiate_categoria_filme(db, 23, 22);
            instantiate_categoria_filme(db, 6,  22);
            instantiate_categoria_filme(db, 11, 22);
            instantiate_categoria_filme(db, 15, 22);
            instantiate_categoria_filme(db, 19, 23);
            instantiate_categoria_filme(db, 9,  24);
            instantiate_categoria_filme(db, 10, 25);
            instantiate_categoria_filme(db, 10, 26);
            instantiate_categoria_filme(db, 2,  27, "Leslie Odom Jr.", "image_miami_sup_actor");
            instantiate_categoria_filme(db, 22, 27);
            instantiate_categoria_filme(db, 15, 27);
            instantiate_categoria_filme(db, 19, 28);
            instantiate_categoria_filme(db, 9,  29);
            instantiate_categoria_filme(db, 10, 30);
            instantiate_categoria_filme(db, 12, 31);
            instantiate_categoria_filme(db, 7,  32);
            instantiate_categoria_filme(db, 13, 32);
            instantiate_categoria_filme(db, 19, 33);
            instantiate_categoria_filme(db, 19, 34);
            instantiate_categoria_filme(db, 18, 35);
            instantiate_categoria_filme(db, 22, 36);
            instantiate_categoria_filme(db, 15, 37);
            instantiate_categoria_filme(db, 19, 38);
            instantiate_categoria_filme(db, 6,  39);
            instantiate_categoria_filme(db, 14, 39);
            instantiate_categoria_filme(db, 17, 39);
            instantiate_categoria_filme(db, 20, 39);
            instantiate_categoria_filme(db, 5,  40);
            instantiate_categoria_filme(db, 18, 41);
            instantiate_categoria_filme(db, 12, 42);
            instantiate_categoria_filme(db, 3,  43, "Andra Day", "image_billie_actress");
            instantiate_categoria_filme(db, 9,  44);
            instantiate_categoria_filme(db, 15, 45);
            instantiate_categoria_filme(db, 21, 46);
            instantiate_categoria_filme(db, 7,  46);
            instantiate_categoria_filme(db, 21, 47);
            instantiate_categoria_filme(db, 5,  48);
            instantiate_categoria_filme(db, 3,  49, "Vanessa Kirby", "image_pieces_actress");
            instantiate_categoria_filme(db, 20, 50);
            instantiate_categoria_filme(db, 5,  51);
            instantiate_categoria_filme(db, 22, 52);
            instantiate_categoria_filme(db, 4,  52, "Maria Bakalova", "image_borat_sup_actress");
            instantiate_categoria_filme(db, 21, 53);
            instantiate_categoria_filme(db, 18, 54);
            instantiate_categoria_filme(db, 13, 55);
            instantiate_categoria_filme(db, 4, 55, "Glenn Close", "image_hillbilly_sup_actress");
            instantiate_categoria_filme(db, 21, 56);

            Log.i("INFO BANCODEDADOS", "Sucesso ao popular a tabela "+TABELA_CATEGORIA_FILME);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao popular a tabela categoriaFilme"+ e.getMessage());
        }
    }

    public void create_categoria_filme_table(SQLiteDatabase db){
        String sql_create_categoria_filme = "CREATE TABLE IF NOT EXISTS " + TABELA_CATEGORIA_FILME +"("+
                " id_categoria INTEGER REFERENCES categoria(id),"+
                " id_filme INTEGER REFERENCES filme(id)," +
                " nomeacao_repetida_na_categoria INTEGER DEFAULT 1,"+
                " rating INTEGER DEFAULT 0," +
                " indicado TEXT,"+
                " caminhoImagemIndicado TEXT," +
                " CONSTRAINT pk_cat_film PRIMARY KEY (id_categoria, id_filme, nomeacao_repetida_na_categoria)"+
                ");";

        execTableCreation(db, sql_create_categoria_filme, TABELA_CATEGORIA_FILME);
        populate_categoria_filme(db);
    }

    public void instantiate_categoria(SQLiteDatabase db, String nome){
        try {
            ContentValues category_insert = new ContentValues();
            category_insert.put("nome", nome);
            db.insert(TABELA_CATEGORIA, null, category_insert);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao instanciar categoria "+nome+ e.getMessage());
        }
    }

    public void populate_categoria(SQLiteDatabase db){
        try{
            instantiate_categoria(db, "Actor in a Leading Role");
            instantiate_categoria(db, "Actor in a Supporting Role");
            instantiate_categoria(db, "Actress in a Leading Role");
            instantiate_categoria(db, "Actress in a Supporting Role");
            instantiate_categoria(db, "Animated Feature Film");
            instantiate_categoria(db, "Cinematography");
            instantiate_categoria(db, "Costume Design");
            instantiate_categoria(db, "Directing");
            instantiate_categoria(db, "Documentary (Feature)");
            instantiate_categoria(db, "Documentary (Short Subject)");
            instantiate_categoria(db, "Film Editing");
            instantiate_categoria(db, "International Feature Film");
            instantiate_categoria(db, "Makeup and Hairstyling");
            instantiate_categoria(db, "Music (Original Score)");
            instantiate_categoria(db, "Music (Original Song)");
            instantiate_categoria(db, "Best Picture");
            instantiate_categoria(db, "Production Design");
            instantiate_categoria(db, "Short Film (Animated)");
            instantiate_categoria(db, "Short Film (Live Action)");
            instantiate_categoria(db, "Sound");
            instantiate_categoria(db, "Visual Effects");
            instantiate_categoria(db, "Writing (Adapted Screenplay)");
            instantiate_categoria(db, "Writing (Original Screenplay)");

            Log.i("INFO BANCODEDADOS", "Sucesso ao popular a tabela "+TABELA_CATEGORIA);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao popular a tabela categoria"+ e.getMessage());
        }
    }

    public void create_categoria_table(SQLiteDatabase db){
        String sql_create_categoria = "CREATE TABLE IF NOT EXISTS " + TABELA_CATEGORIA +"("+
                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL, " +
                " selecionada INTEGER DEFAULT 1,"+
                " winner INTEGER REFERENCES filme(id),"+
                " runnerUp INTEGER REFERENCES filme(id),"+
                " wantsToWin INTEGER REFERENCES filme(id),"+
                " actualWinner INTEGER REFERENCES filme(id) "+
                ");";

        execTableCreation(db, sql_create_categoria, TABELA_CATEGORIA);
        populate_categoria(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        create_filme_table(db);
        create_categoria_table(db);
        create_categoria_filme_table(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql_create_filme = "DROP TABLE IF EXISTS " + TABELA_FILME + " ;";
        String sql_create_categoria_filme = "DROP TABLE IF EXISTS " + TABELA_CATEGORIA_FILME + " ;";
        String sql_create_categoria = "DROP TABLE IF EXISTS " + TABELA_CATEGORIA + " ;";

        try {
            db.execSQL(sql_create_filme);
            db.execSQL(sql_create_categoria_filme);
            db.execSQL(sql_create_categoria);
            onCreate(db);
            Log.i("INFO BANCODEDADOS", "Sucesso ao atualizar App" );
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao atualizar App" + e.getMessage() );
        }

    }

}
